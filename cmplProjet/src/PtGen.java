/*********************************************************************************
 * VARIABLES ET METHODES FOURNIES PAR LA CLASSE UtilLex (cf libClass_Projet)     *
 *       complement à l'ANALYSEUR LEXICAL produit par ANTLR                      *
 *                                                                               *
 *                                                                               *
 *   nom du programme compile, sans suffixe : String UtilLex.nomSource           *
 *   ------------------------                                                    *
 *                                                                               *
 *   attributs lexicaux (selon items figurant dans la grammaire):                *
 *   ------------------                                                          *
 *     int UtilLex.valEnt = valeur du dernier nombre entier lu (item nbentier)   *
 *     int UtilLex.numIdCourant = code du dernier identificateur lu (item ident) *
 *                                                                               *
 *                                                                               *
 *   methodes utiles :                                                           *
 *   ---------------                                                             *
 *     void UtilLex.messErr(String m)  affichage de m et arret compilation       *
 *     String UtilLex.chaineIdent(int numId) delivre l'ident de codage numId     *
 *     void afftabSymb()  affiche la table des symboles                          *
 *********************************************************************************/


import java.io.*;

/**
 * classe de mise en oeuvre du compilateur
 * =======================================
 * (verifications semantiques + production du code objet)
 * 
 * @author Girard, Grazon, Masson
 *
 */

public class PtGen {
    

    // constantes manipulees par le compilateur
    // ----------------------------------------

	private static final int 
	
	// taille max de la table des symboles
	MAXSYMB=300,

	// codes MAPILE :
	RESERVER=1,EMPILER=2,CONTENUG=3,AFFECTERG=4,OU=5,ET=6,NON=7,INF=8,
	INFEG=9,SUP=10,SUPEG=11,EG=12,DIFF=13,ADD=14,SOUS=15,MUL=16,DIV=17,
	BSIFAUX=18,BINCOND=19,LIRENT=20,LIREBOOL=21,ECRENT=22,ECRBOOL=23,
	ARRET=24,EMPILERADG=25,EMPILERADL=26,CONTENUL=27,AFFECTERL=28,
	APPEL=29,RETOUR=30,

	// codes des valeurs vrai/faux
	VRAI=1, FAUX=0,

    // types permis :
	ENT=1,BOOL=2,NEUTRE=3,

	// categories possibles des identificateurs :
	CONSTANTE=1,VARGLOBALE=2,VARLOCALE=3,PARAMFIXE=4,PARAMMOD=5,PROC=6,
	DEF=7,REF=8,PRIVEE=9,

    //valeurs possible du vecteur de translation 
    TRANSDON=1,TRANSCODE=2,REFEXT=3;


    // utilitaires de controle de type
    // -------------------------------
    /**
     * verification du type entier de l'expression en cours de compilation 
     * (arret de la compilation sinon)
     */
	private static void verifEnt() {
		if (tCour != ENT)
			UtilLex.messErr("expression entiere attendue");
	}
	/**
	 * verification du type booleen de l'expression en cours de compilation 
	 * (arret de la compilation sinon)
	 */
	private static void verifBool() {
		if (tCour != BOOL)
			UtilLex.messErr("expression booleenne attendue");
	}

    // pile pour gerer les chaines de reprise et les branchements en avant
    // -------------------------------------------------------------------

    private static TPileRep pileRep;  


    // production du code objet en memoire
    // -----------------------------------

    private static ProgObjet po;
    
    
    // COMPILATION SEPAREE 
    // -------------------
    //
    /** 
     * modification du vecteur de translation associe au code produit 
     * + incrementation attribut nbTransExt du descripteur
     *  NB: effectue uniquement si c'est une reference externe ou si on compile un module
     * @param valeur : TRANSDON, TRANSCODE ou REFEXT
     */
    private static void modifVecteurTrans(int valeur) {
		if (valeur == REFEXT || desc.getUnite().equals("module")) {
			po.vecteurTrans(valeur);
			desc.incrNbTansExt();
		}
	}    
    // descripteur associe a un programme objet (compilation separee)
    private static Descripteur desc;

     
    // autres variables fournies
    // -------------------------
    
 // MERCI de renseigner ici un nom pour le trinome, constitue EXCLUSIVEMENT DE LETTRES
    public static String trinome="XxxYyyZzz"; 
    
    private static int tCour; // type de l'expression compilee
    private static int vCour; // sert uniquement lors de la compilation d'une valeur (entiere ou boolenne)
  
    private static int nbVars = 0;
    private static int oldIdent = 0;
    // TABLE DES SYMBOLES
    // ------------------
    //
    private static EltTabSymb[] tabSymb = new EltTabSymb[MAXSYMB + 1];
    
    // it = indice de remplissage de tabSymb
    // bc = bloc courant (=1 si le bloc courant est le programme principal)
	private static int it, bc;
	
	/** 
	 * utilitaire de recherche de l'ident courant (ayant pour code UtilLex.numIdCourant) dans tabSymb
	 * 
	 * @param borneInf : recherche de l'indice it vers borneInf (=1 si recherche dans tout tabSymb)
	 * @return : indice de l'ident courant (de code UtilLex.numIdCourant) dans tabSymb (O si absence)
	 */
	private static int presentIdent(int borneInf) {
		int i = it;
		while (i >= borneInf && tabSymb[i].code != UtilLex.numIdCourant)
			i--;
		if (i >= borneInf)
			return i;
		else
			return 0;
	}

	/**
	 * utilitaire de placement des caracteristiques d'un nouvel ident dans tabSymb
	 * 
	 * @param code : UtilLex.numIdCourant de l'ident
	 * @param cat : categorie de l'ident parmi CONSTANTE, VARGLOBALE, PROC, etc.
	 * @param type : ENT, BOOL ou NEUTRE
	 * @param info : valeur pour une constante, ad d'exécution pour une variable, etc.
	 */
	private static void placeIdent(int code, int cat, int type, int info) {
		if (it == MAXSYMB)
			UtilLex.messErr("debordement de la table des symboles");
		it = it + 1;
		tabSymb[it] = new EltTabSymb(code, cat, type, info);
	}

	/**
	 *  utilitaire d'affichage de la table des symboles
	 */
	private static void afftabSymb() { 
		System.out.println("       code           categorie      type    info");
		System.out.println("      |--------------|--------------|-------|----");
		for (int i = 1; i <= it; i++) {
			if (i == bc) {
				System.out.print("bc=");
				Ecriture.ecrireInt(i, 3);
			} else if (i == it) {
				System.out.print("it=");
				Ecriture.ecrireInt(i, 3);
			} else
				Ecriture.ecrireInt(i, 6);
			if (tabSymb[i] == null)
				System.out.println(" reference NULL");
			else
				System.out.println(" " + tabSymb[i]);
		}
		System.out.println();
	}
    

	/**
	 *  initialisations A COMPLETER SI BESOIN
	 *  -------------------------------------
	 */
	public static void initialisations() {
	
		// indices de gestion de la table des symboles
		it = 0;
		bc = 1;
		
		// pile des reprises pour compilation des branchements en avant
		pileRep = new TPileRep(); 
		// programme objet = code Mapile de l'unite en cours de compilation
		po = new ProgObjet();
		// COMPILATION SEPAREE: desripteur de l'unite en cours de compilation
		desc = new Descripteur();
		
		// initialisation necessaire aux attributs lexicaux
		UtilLex.initialisation();
	
		// initialisation du type de l'expression courante
		tCour = NEUTRE;

	} // initialisations

	/**
	 *  code des points de generation A COMPLETER
	 *  -----------------------------------------
	 * @param numGen : numero du point de generation a executer
	 */
	public static void pt(int numGen) {
	
		switch (numGen) {
		case 0:
			initialisations();
			break;
		case 1: verifBool();break; // verif si le type de vCour (tCour) est un boolean
		case 2: verifEnt();break; // verif si le type de vCour (tCour) est un entier
		
		case 3: po.produire(OU);break; // produire le code de ou 
		case 4: po.produire(ET);break; // produire le code de et 
		case 5: po.produire(NON);break; // produire le code de non 
		
		case 6:po.produire(EMPILER);po.produire(vCour);break; // produire le code de empiler
		
		case 7: vCour=UtilLex.valEnt;tCour = ENT;break; // affecter vCour et tCour a l'entier courrant
		case 8: vCour=-UtilLex.valEnt;tCour = ENT;break;// affecter vCour et tCour a l'entier negatif courrant
		
		case 9: vCour = 1; tCour = BOOL;break;  // affecter vCour et tCour au bool courrant
		case 10: vCour = 0; tCour = BOOL;break; // affecter vCour et tCour au bool courrant
		
		case 11:{
			int i = presentIdent(1);
			if (i > 0) {
				switch (tabSymb[i].categorie) {
					case VARGLOBALE : { // production du code pour un ident qui signifie une var glob
						po.produire(CONTENUG);		
						break;
					}
					case CONSTANTE : { 	// production du code pour un ident qui signifie une constante
						po.produire(EMPILER);	
						break;
					}		
				}
				po.produire(tabSymb[i].info);
				tCour = tabSymb[i].type;
				
			}
			else {
				UtilLex.messErr("variable not declared");
			}
			break;}
			
		case 12:po.produire(MUL);break;// produire le code de MUL 
		case 13:po.produire(DIV);break;// produire le code de DIV 
		case 14:po.produire(ADD);break;// produire le code de ADD 
		case 15:po.produire(SOUS);break;// produire le code de ADD 
		
		case 16:po.produire(EG);tCour = BOOL;break;// produire le code de EG 
		case 17:po.produire(DIFF);tCour = BOOL;break;// produire le code de DIFF 
		case 18:po.produire(SUP);tCour = BOOL;break;// produire le code de SUP 
		case 19:po.produire(SUPEG);tCour = BOOL;break;// produire le code de SUPEG 
		case 20:po.produire(INF);tCour = BOOL;break;// produire le code de INF 
		case 21:po.produire(INFEG);tCour = BOOL;break;// produire le code de INFEG 
		
		
		case 22:{ // CODE AFFECTATION
			if (tCour != tabSymb[oldIdent].type) {
				UtilLex.messErr("non matching type");
			}
			else
			{
				po.produire(AFFECTERG);
				po.produire(tabSymb[oldIdent].info);
			} 
			break;
		}
		
		case 30: {
			int i = presentIdent(1);
			if (i > 0) {
				if(tabSymb[i].categorie == CONSTANTE) {
					UtilLex.messErr("Affectation a constante");
				}
				else {
					oldIdent = i;
				}
			}
			else {
				UtilLex.messErr("variable not declared");
			}
		}
		
		case 23: { // code ecrire
			if (tCour == ENT) {
				po.produire(ECRENT);
			}
			if (tCour == BOOL) {
				po.produire(ECRBOOL);
			}	
			
			break;
		}
		
		case 24: { // lire
			int i = presentIdent(1);
			if (i > 0 ) {
				if (tabSymb[i].type == ENT) {
					po.produire(LIRENT);
					po.produire(AFFECTERG);
					po.produire(tabSymb[i].info);
				}
				if (tabSymb[i].type == BOOL) {
					po.produire(LIREBOOL);
					po.produire(AFFECTERG);
					po.produire(tabSymb[i].info);
				}
			}
			break;
		}
			
		case 25: {
			int i = presentIdent(1);
			if (i == 0) {
				placeIdent(UtilLex.numIdCourant,CONSTANTE, tCour, vCour);
			}
			else {
				UtilLex.messErr("Constant already declared");
			}
			break;
		}
		
		case 26: {
			int i = presentIdent(1);
			if (i == 0) {
				placeIdent(UtilLex.numIdCourant,VARGLOBALE, tCour,nbVars);
				nbVars++;
				po.produire(RESERVER);
				po.produire(1); //TODO optimise
			}
			else {
				UtilLex.messErr("variable already declared");
			}
			break;
		}
		
		case 27: {
			tCour = BOOL;
			break;
		}
			
		case 28: {
			tCour = ENT;
			break;
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		case 254: {
			afftabSymb();
		}
		case 255:{ 	afftabSymb();
					po.constGen();
					po.constObj();
					break;
					}
				
		// TODO
		
		default:
			System.out
					.println("Point de generation non prevu dans votre liste");
			break;

		}
	}
}
    
    
    
    
    
    
    
    
    
    
    
    
    
 
