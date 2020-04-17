/*********************************************************************************
 * VARIABLES ET METHODES FOURNIES PAR LA CLASSE UtilLex (cf libClass_Projet)     *
 *       complement à l'ANALYSEUR LEXICAL produit par ANTLR                     *
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
import java.io.ObjectInputStream.GetField;

import javax.rmi.CORBA.Util;

import org.antlr.runtime.Lexer;

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
	BSIFAUX=18,BINCOND=19,LIREENT=20,LIREBOOL=21,ECRENT=22,ECRBOOL=23,
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
    public static String trinome="SL - MS - GM"; 
    
    private static int tCour; // type de l'expression compilee
    private static int vCour; // sert uniquement lors de la compilation d'une valeur (entiere ou boolenne)
  
    private static int nbVars = 0; //nb de variables, utilisers pour compter le nb de variabls pour numerote leurs adresse dans la case info
    private static int oldIdent = 0; // enregistre un numidcourran, utiliser dans affecter
    private static int nbParams = 0; //nb de paramt dans la procedure entraint d'etre compiler
    private static int procIdent = 0; // ident de la procedure entraint df'etre compiler 
    private static int nbParamsappel = 0; // nb de param entraint d'etre apeler 
    private static int nbParamRef = 0; // could use nbparam mby
    
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
	 * enleve une case du tableau et decale toutes les case apres
	 * @param index de la case a remove
	 */
	
	private static void removeIdent(int index) {
		for (int i = index+1;i < tabSymb.length; i++ ) {
			tabSymb[i-1] = tabSymb[i];
		}
		tabSymb[it] = null;
		it--;
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
		
		
		
		//our inits : 
		nbVars = 0;
	 	oldIdent = 0;
		nbParams = 0;
		procIdent = 0;
		nbParamRef = 0;

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
			int i = presentIdent(bc);
			if (i == 0) {
				i = presentIdent(1);
			}
			if (i > 0) {
				switch (tabSymb[i].categorie) {
					case VARGLOBALE : { // production du code pour un ident qui signifie une var glob
						po.produire(CONTENUG);	
						po.produire(tabSymb[i].info);
						modifVecteurTrans(TRANSDON); // TODO check
						tCour = tabSymb[i].type;
						break;
					}
					case CONSTANTE : { 	// production du code pour un ident qui signifie une constante
						po.produire(EMPILER);	
						po.produire(tabSymb[i].info);
						tCour = tabSymb[i].type;
						break;
					}
					case VARLOCALE : {
						po.produire(CONTENUL);
						po.produire(tabSymb[i].info);
						po.produire(0);
						break;
					}
					case PARAMFIXE : {
						po.produire(CONTENUL);
						po.produire(tabSymb[i].info);
						po.produire(0);
						break;
					}
					case PARAMMOD : {
						po.produire(CONTENUL);
						po.produire(tabSymb[i].info);
						po.produire(1);
						break;
					}
				}
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
				if (bc == 1 ) {
					po.produire(AFFECTERG);
					po.produire(tabSymb[oldIdent].info);
					modifVecteurTrans(TRANSDON); // TODO check
				}
				else 
				{
					if (tabSymb[oldIdent].categorie == VARGLOBALE) {
						po.produire(AFFECTERG);
						po.produire(tabSymb[oldIdent].info);
						modifVecteurTrans(TRANSDON);
					}
					else {
						if (tabSymb[oldIdent].categorie != PARAMFIXE) {
							po.produire(AFFECTERL);
							po.produire(tabSymb[oldIdent].info);
							po.produire((tabSymb[oldIdent].categorie == VARLOCALE)?0:1);
						}
						else {
							UtilLex.messErr("Affectation a param fixe");
						}
					}
				}
			} 
			break;
		}
		
		case 30: { //pre afeect
			int i = presentIdent(bc);
			if (i == 0) {
				i = presentIdent(1);
			}
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
			break;
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
			int i = presentIdent(bc);
			if (i == 0) {
				i = presentIdent(1);
			}
			if (i > 0 ) {
				if (tabSymb[i].type == ENT) {
					po.produire(LIREENT);			
				}			
				if (tabSymb[i].type == BOOL) {
					po.produire(LIREBOOL);
				}
				switch (tabSymb[i].categorie) {
					case VARGLOBALE : {
						po.produire(AFFECTERG);
						po.produire(tabSymb[i].info);
						modifVecteurTrans(TRANSDON); // TODO check
						break;
					}
					case VARLOCALE : {
						po.produire(AFFECTERL);
						po.produire(tabSymb[i].info);
						po.produire(0);
						break;
					}
					case PARAMMOD : {
						po.produire(AFFECTERL);
						po.produire(tabSymb[i].info);
						po.produire(1);
						break;
					}
					case PARAMFIXE : {
						UtilLex.messErr("Lire sur un param fixe");
						break;
					}
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
		
		
		/*
		 * adding new var to table ident
		 * modded to support local vars
		 * 
		 */
		case 26: {
			int i = presentIdent(bc);
			if (i == 0) {
				
				placeIdent(UtilLex.numIdCourant,(bc == 1 )?VARGLOBALE:VARLOCALE, tCour,(bc == 1 )?nbVars:nbVars+nbParams+2);
				nbVars++;
				/*po.produire(RESERVER);
				po.produire(1); //TODO optimise*/
			}
			else {
				UtilLex.messErr("variable already declared");
			}
			break;
		}
		
		case 44: {
				if (desc.getUnite().equals("programme")) {
					po.produire(RESERVER);
					po.produire(nbVars);
				}
				if (bc==1) // TODO Check
					desc.setTailleGlobaux(nbVars); // modif du nombre de var globale, ce code pass dans les proc aussi donc on verif si on est dans une proc ou pas
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
		
		
		/**
		 * Produit un BSIFAUX et sont argm a 00 
		 * Et empile l'indice de l'argument dans la pile de reprise
		 */
		
		case 29: {
			po.produire(BSIFAUX);
			po.produire(00);
			modifVecteurTrans(TRANSCODE); // TODO check
			pileRep.empiler(po.getIpo());
			break;
		}

		case 31: { // reprise de si
			po.produire(BINCOND);
			po.produire(00);
			modifVecteurTrans(TRANSCODE); // TODO check
			po.modifier(pileRep.depiler(),po.getIpo()+1);
			pileRep.empiler(po.getIpo());
			break;
		}
		
		case 32: { // fin si
			po.modifier(pileRep.depiler(),po.getIpo()+1);
			break;
		}
		
		
		/**
		 * Stock l'adresse code que l'on va ajouter apres le ipo courrant
		 * Utiliser pour une boucle, on met dans la pile l'index de la condition
		 */
		case 33: {
			
			pileRep.empiler(po.getIpo() + 1);
			break;
		}
		
		/**
		 * Case pour retourner au debut de boucle
		 * cree le code BINCOND avec arg index de la condition
		 */
		
		case 34 : {
			po.produire(BINCOND);
			
			int indexBcondarg = pileRep.depiler();
			int indexCond = pileRep.depiler();
			
			po.produire(indexCond);
			modifVecteurTrans(TRANSCODE); // TODO check
			po.modifier(indexBcondarg, po.getIpo()+1);
			
	
			break;
		}
		
		/**Case debut de cond
		 * 
		 */
		case 35 : {
			pileRep.empiler(0);		
			break;
		}
		
		/**
		 * case autre + next case
		 */
		
		case 36 : {
			int indiceBsifauxarg = pileRep.depiler();
			int indiceChaine = pileRep.depiler();
			po.produire(BINCOND);
			po.produire(indiceChaine);
			modifVecteurTrans(TRANSCODE); // TODO check
			pileRep.empiler(po.getIpo());
			po.modifier(indiceBsifauxarg,po.getIpo()+1);
			break;
		}
		
		
		/**
		 *case no autre
		 **/
		case 37 : { 
			int indiceBsifauxarg = pileRep.depiler();
			po.modifier(indiceBsifauxarg,po.getIpo()+1);
			break;
		}
		
		/**
		 * fcond
		 * 
		 */
		case 38 : {
			int nextInstr = po.getIpo()+1;
			int dep = pileRep.depiler();
			do {
			int nextdep = po.getElt(dep);
			po.modifier(dep,nextInstr);
			dep = nextdep;
			}while (dep != 0);
			
			break;
		}
		
		/***************************************
		 * PROCEDURES
		 * *************************************		
		 */
		
		
		/**
		 * cas qui cree le debut d'une procedure, cree un bincond qui saute a la fin de cette procedure
		 * on initialise un compteur de parametre, qui va servir a remplire la tab de symb
		 * 
		 * on aurait put utiliser tabSymb[bc-1].info comme compteur
		 */
		case 39 : {
			nbParams = 0;
			/*po.produire(BINCOND);
			po.produire(00);
			modifVecteurTrans(TRANSCODE); // TODO check
			pileRep.empiler(po.getIpo());*/
			placeIdent(UtilLex.numIdCourant,PROC,NEUTRE, po.getIpo()+1);
			if (desc.presentDef(UtilLex.chaineIdent(UtilLex.numIdCourant)) > 0) {
				placeIdent(-1,DEF,NEUTRE,0);
			}
			else {
				placeIdent(-1,PRIVEE,NEUTRE,0);
			}
			bc = it+1;
			break;
		}
		
		case 252 : {
			if (desc.getUnite().equals("programme")) {
				po.produire(BINCOND);
				po.produire(00);
				modifVecteurTrans(TRANSCODE); // TODO check
				pileRep.empiler(po.getIpo());
			}
			break;
		}
		
		
		/**
		 * COUNTER FOR AMOUNT OF PARAMS
		 * incremente le nombre de parametre et l'initialise dans le tab symb 
		 */
		case 40: {
			placeIdent(UtilLex.numIdCourant,PARAMFIXE,tCour,nbParams++);
			break;
		}
		/**
		 *  COUNTER FOR AMOUNT OF PARAMS
		 * incremente le nombre de parametre et l'initialise dans le tab symb 
		 */
		case 41 : {
			placeIdent(UtilLex.numIdCourant,PARAMMOD,tCour,nbParams++);
			break;
		}
		
		/**
		 * Met le nombre de parametre dans le tab symb
		 */
		case 42 : {
			tabSymb[bc-1].info = nbParams;
			int index = desc.presentDef(UtilLex.chaineIdent(tabSymb[bc-2].code));
			if (index > 0 ) {   // on modifie le tableau du descripteu, on verifie si on fait une def avec cette procedure et si oui on change la case nbparam du tableau
				desc.modifDefNbParam(index,nbParams);
				desc.modifDefAdPo(index,tabSymb[bc-2].info);
			}
			break;
		}
		
		/**
		 * Cas de fin de declaration de procedures
		 * on change l'adresse du bincond du debut de procedure a la bonne adresse
		 * et on change le code pour tout les param a -1 
		 * et on enleve toutes les variables du tabSymb
		 */			
		case 43 : {
			
			//po.modifier(pileRep.depiler(), po.getIpo()+1);
			po.produire(RETOUR);
			po.produire(nbParams);
			for (int i = bc; i <= it; i++ ) {
				if (tabSymb[i].categorie != PARAMMOD && tabSymb[i].categorie != PARAMFIXE) {
					removeIdent(i);
					i--;
				}
				else {
					tabSymb[i].code = -1;
				}
			}
			bc = 1;
			break;
		}
		
		case 251 : {
			if (desc.getUnite().equals("programme")) {
				po.modifier(pileRep.depiler(), po.getIpo()+1);
			}
			break;
		}
		
		
		/**
		 * initialise un compteur pour le nombres de variables dans cette procedure
		 */
		case 45: {
			nbVars = 0;
			break;
		}
		
		
		/**
		 * debut d'un appel de procedures
		 * On verifie si le ident est bien une procedure
		 * Et si ident est bien present dans la table de symbole
		 * Une fois ces verif faite, on initialise le nombre de param appele a 0
		 */
		case 46 : {
			procIdent = presentIdent(1);
			if (procIdent > 0) {
				if (tabSymb[procIdent].categorie != PROC)
				UtilLex.messErr("Ident est pas une procedure");
			}
			else {
				UtilLex.messErr("Ident est pas present");
			}
			nbParamsappel = 0;
			break;
		}
		
		/**
		 * Ce cas gere les param fixe
		 * On verifie dabors si on de depasse pas le nombre de paramtre et si on depasse pas le nombre de param fixe
		 * on verifie ensuite le type de chaque expression mis en param
		 * si oui, on incremente le nb de parametre appele et le code est genere par la grammaire de expression
		 */
		case 47 : {
			if ( nbParamsappel + 1 <= tabSymb[procIdent+1].info && tabSymb[procIdent + 2 + nbParamsappel].categorie == PARAMFIXE ) {
				if (tabSymb[procIdent + 2 + nbParamsappel].type == tCour) {
					nbParamsappel ++;
				
				
				
				}
				else {
					UtilLex.messErr("Type de parametre faux");
				}
			}
			else {
				UtilLex.messErr("trop de parametres fixes");
			}
			break;
		}
		
		/**
		 * Cas gere les param mod
		 * On verifie dabors si on de depasse pas le nombre de paramtre et si on depasse pas le nombre de param mod
		 * on verifie ensuite si la variable existe
		 * on verifie ensuite le type de chaque variable mis en param
		 * on verifie ensuite si la categorie de la variable passe peut etre utilise comme param mod et on produit du code dependant de ca categorie
		 */
		case 48 : {
			if ( nbParamsappel + 1 <= tabSymb[procIdent+1].info && tabSymb[procIdent + 2 + nbParamsappel].categorie == PARAMMOD ) {
				int i = presentIdent(bc);
				if (i == 0) {
					i = presentIdent(1);
				}
				if (i > 0) {	
					if (tabSymb[procIdent + 2 + nbParamsappel].type == tabSymb[i].type ) {
						nbParamsappel ++;
							switch (tabSymb[i].categorie) {
								case VARGLOBALE : { // production du code pour un ident qui signifie une var glob
									po.produire(EMPILERADG);	
									po.produire(tabSymb[i].info);
									modifVecteurTrans(TRANSDON); // TODO check
									tCour = tabSymb[i].type;
									break;
								}
								case VARLOCALE : {
									po.produire(EMPILERADL);
									po.produire(tabSymb[i].info);
									po.produire(0);
									break;
								}
								case PARAMMOD : {
									po.produire(EMPILERADL);
									po.produire(tabSymb[i].info);
									po.produire(1);
									break;
								}
								default : {
									UtilLex.messErr("On ne peut pas passer " + tabSymb[i].categorie + " en parametre Mod " );
								}
							}
							tCour = tabSymb[i].type;
							
						}
						else {
							UtilLex.messErr("Type de parametre faux - 48");
						}
					}
					else {
						UtilLex.messErr("variable not declared");
					}
			}
			else {
				UtilLex.messErr("trop de parametres - 48");
			}
			break;
		}
		
		
		/**
		 * Production du code de l'appel
		 */
		case 49 : {
			po.produire(APPEL);
			po.produire(tabSymb[procIdent].info);
			if (desc.presentRef(UtilLex.chaineIdent(tabSymb[procIdent].code)) > 0) {
				modifVecteurTrans(REFEXT); // TODO check
			}else {
				modifVecteurTrans(TRANSCODE); // TODO check
			}
			po.produire(tabSymb[procIdent+1].info);
			break;
		}
		
		/**
		 * COMP SEPAREE
		 */
		
		
		case 50 : {
			desc.setUnite("programme");
			
			break;
		}

		case 51 : {
			desc.setUnite("module");
			break;
		}
		
		
		
		/**
		 * ajout de une proc def
		 */
		
		
		case 52 : {
			desc.ajoutDef(UtilLex.chaineIdent(UtilLex.numIdCourant));
			break;
		}
		
		/**
		 * ajout de ref
		 */
		
		case 53 : {
			desc.ajoutRef(UtilLex.chaineIdent(UtilLex.numIdCourant));
			placeIdent(UtilLex.numIdCourant, PROC, NEUTRE,desc.getNbRef());
			placeIdent(-1, REF, NEUTRE,-1);
			break;
		}
		
		case 54 : {
			int index = desc.presentRef(UtilLex.chaineIdent(UtilLex.numIdCourant));
			if (index != 0) {
				desc.modifRefNbParam(index,0);
				
			}
			else {
				UtilLex.messErr("nom de proc non trouve dans tabRef : case 54");
			}
			//nbParamRef = 0;
			break;
		}
		case 55: {
			int index = desc.presentRef(UtilLex.chaineIdent(UtilLex.numIdCourant));
			if (index != 0) {
				placeIdent(-1, PARAMFIXE,tCour,desc.getRefNbParam(index));
				desc.modifRefNbParam(index,desc.getRefNbParam(index)+1);
			}
			else {
				UtilLex.messErr("nom de proc non trouve dans tabRef : case 55");
			}
			break;
		}
		case 56 : {
			int index = desc.presentRef(UtilLex.chaineIdent(UtilLex.numIdCourant));
			if (index != 0) {
				placeIdent(-1, PARAMMOD,tCour,desc.getRefNbParam(index));
				desc.modifRefNbParam(index,desc.getRefNbParam(index)+1);
			}
			else {
				UtilLex.messErr("nom de proc non trouve dans tabRef : case 56");
			}
			break;
		}
		case 57: {
			int index = presentIdent(1);
			int index2 = desc.presentRef(UtilLex.chaineIdent(UtilLex.numIdCourant));
			tabSymb[index+1].info = desc.getRefNbParam(index2);
			break;
		}
		//TODO add errors
		
		
		case 253 : {
			po.produire(ARRET);	
			break;
		}
		case 254: {
			afftabSymb();
			System.out.println(desc.toString());
			break;
		}
		case 255:{ 
					desc.setTailleCode(po.getIpo());
					afftabSymb();
					System.out.println(desc.toString());
					desc.ecrireDesc(UtilLex.nomSource);
					desc.lireDesc(UtilLex.nomSource);
					po.constGen();
					po.constObj();
					
					
					break;
					}
				
		// TODO
		
		default:
			System.out.println("Point de generation non prevu dans votre liste");
			break;

		}
	}
}
    
    
    
    
    
    
    
    
    
    
    
    
    
 
