import java.io.*;

import antlr.collections.List;
 //TODO : Renseigner le champs auteur : Nom1_Prenom1_Nom2_Prenom2_Nom3_Prenom3
 /**
 * 
 * @author XXX, YYY, ZZZ
 * @version 2020
 *
 *error todo 
 *Module without def
 *fix def ref privee in ptgen tabsymb
 *
 */


public class Edl {

	// nombre max de modules, taille max d'un code objet d'une unite
	static final int MAXMOD = 5, MAXOBJ = 1000;
	// nombres max de references externes (REF) et de points d'entree (DEF)
	// pour une unite
	private static final int MAXREF = 10, MAXDEF = 10;

	// typologie des erreurs
	private static final int FATALE = 0, NONFATALE = 1;

	// valeurs possibles du vecteur de translation
	private static final int TRANSDON=1,TRANSCODE=2,REFEXT=3;

	// table de tous les descripteurs concernes par l'edl
	static Descripteur[] tabDesc = new Descripteur[MAXMOD + 1];

	//: declarations de variables A COMPLETER SI BESOIN
	static int ipo, nMod, nbErr;
	static String nomProg;
	static String[] nomMod;
	//mes Vars
	static DicoDefElt[] dicoDef;
	static int nbDef;
	
	static int[] transDon;
	static int[] transCode;
	static int[][] adFinale;
	
	static class DicoDefElt {
		String nomProc;
		int adPo;
		int nbParam;
		
		public DicoDefElt(String name,int ad,int nbparam) {
			nomProc = name;
			adPo = ad;
			nbParam = nbparam;
		}
	}
	
	//mes Vars fin
	
	//mes Procedures 
	
	
	
	private static void initnomMod() {
		nomMod = new String[6];
		for (int i = 0; i<=MAXMOD ; i++ ) {
			nomMod[i] = "";
		}
	}
	
	
	static public boolean dicoContains(String procName) {
		for (int i = 1 ; i <= nbDef; i++) {
			if (dicoDef[i].nomProc.equals(procName))
				return true;
		}
		return false;
	}
	
	public static void printDico() {
		System.out.println("----DICODEF----");
		for (int i = 1; i <= nbDef;i++) {
			System.out.println(i + " : " + dicoDef[i].nomProc + " ; " + dicoDef[i].adPo + " ; " + dicoDef[i].nbParam);
		}
	}
	
	public static void printTrans() {
		System.out.println("----TRANS----");
		System.out.print("TransDon : 0 ; ");
		for (int i = 1 ; i <=nMod ; i++) {
			System.out.print(transDon[i] + " ; ");
		}
		System.out.println("");
		System.out.print("TransCod : 0 ; ");
		for (int i = 1 ; i <=nMod ; i++) {
			System.out.print(transCode[i] + " ; ");
		}
		System.out.println("");
	}
	
	public static void printadFinale() {
		System.out.println("----ADFINALE----");
		for (int i = 0 ; i <= nMod; i++) {
			for (int j = 1; j <= 6 ; j++) {
				System.out.print(adFinale[i][j] + " ; ");
			}
			System.out.println("");
		}
	}
	
	//mes Procedures fin

	// utilitaire de traitement des erreurs
	// ------------------------------------
	static void erreur(int te, String m) {
		System.out.println(m);
		if (te == FATALE) {
			System.out.println("ABANDON DE L'EDITION DE LIENS");
			System.exit(1);
		}
		nbErr = nbErr + 1;
	}

	// utilitaire de remplissage de la table des descripteurs tabDesc
	// --------------------------------------------------------------
	static void lireDescripteurs() {
		initnomMod();
		String s;
		System.out.println("les noms doivent etre fournis sans suffixe");
		System.out.print("nom du programme : ");
		s = Lecture.lireString();
		tabDesc[0] = new Descripteur();
		tabDesc[0].lireDesc(s);
		if (!tabDesc[0].getUnite().equals("programme"))
			erreur(FATALE, "programme attendu");
		nomProg = s;
		//added
		nomMod[0] = nomProg;
		//added		
		nMod = 0;
		while (!s.equals("") && nMod < MAXMOD) {
			System.out.print("nom de module " + (nMod + 1)
					+ " (RC si termine) ");
			s = Lecture.lireString();
			if (!s.equals("")) {
				
				nMod = nMod + 1;
				nomMod[nMod] = s;
				tabDesc[nMod] = new Descripteur();
				tabDesc[nMod].lireDesc(s);

				if (!tabDesc[nMod].getUnite().equals("module"))
					erreur(FATALE, "module attendu");
			}
		}
	}

	
	

	static void constMap() {
		// f2 = fichier executable .map construit
		OutputStream f2 = Ecriture.ouvrir(nomProg + ".map");
		if (f2 == null)
			erreur(FATALE, "creation du fichier " + nomProg
					+ ".map impossible");
		// pour construire le code concatene de toutes les unités
		int[] po = new int[(nMod + 1) * MAXOBJ + 1];
		
		
		
		int[] transExt = new int[MAXOBJ+1];
		
		ipo = 0; //ipo du fichier final
		
		for (int k = 0; k <=nMod ; k++) { // on itere sur tout les ficher obj
		
			for (int i = 0; i < MAXOBJ+1; i++) { //on initialise un tab de trans
				transExt[i] = -1; 
			}
			
			InputStream progIO = Lecture.ouvrir(nomMod[k] + ".obj");  //on ouvre le fichier 
			if (progIO == null ) {
				erreur(FATALE," Erreur : Le fichier " + nomMod[k] + " ne peut pas etre ouvert pour la concatenation");
			}
			
			for (int i = 1; i <= tabDesc[k].getNbTransExt(); i++) { // on prend le nombre de trans de ce fichier et on itere ce nombre de fois
				int ad = Lecture.lireInt(progIO);
				int type = Lecture.lireInt(progIO);
				transExt[ad] = type; 
				System.out.println("trans " + nomMod[k] + " "+ i + " = (" + ad + "," + type + ") "  ); // on stocke les trans de la meme facon de dans progobjet
				
			}
			
			
			for (int i = 1; i <= tabDesc[k].getTailleCode(); i++) { // on itere sur chaque int du fichier 
				ipo++; 
				po[ipo] = Lecture.lireInt(progIO);
				if (ipo == 2 && po[ipo-1] == 1)  // On replace le Nombre de var globale a reserver
				{
					int totglob = 0;
					for (int j = 0; j <= nMod ; j++) {
						totglob = totglob + tabDesc[j].getTailleGlobaux();
					}
					po[ipo] = totglob;
				}
				if (transExt[i] != -1) { // si cette ligne m'a pas de trans on y fait riien
					if (transExt[i] == TRANSDON) {
						po[ipo] = po[ipo] + transDon[k]; // on decale la donne
					}
					if (transExt[i] == TRANSCODE) {
						po[ipo] = po[ipo] + transCode[k]; // on decale l'adresse 
					}
					if (transExt[i] == REFEXT) {
						po[ipo] = adFinale[k][po[ipo]]; // on donne l'adresse
					}
				}
			}
		
		}
		
		
		
		for (int i = 1; i <= ipo ; i++) { // Ecriture de po usr un fichier
			Ecriture.ecrireInt(f2,po[i]);
			Ecriture.ecrireStringln(f2,"");
		}
		Ecriture.fermer(f2);

		// creation du fichier en mnemonique correspondant
		Mnemo.creerFichier(ipo, po, nomProg + ".ima");
	}
	
	
	

	public static void main(String argv[]) {
		System.out.println("EDITEUR DE LIENS / PROJET LICENCE");
		System.out.println("---------------------------------");
		System.out.println("");
		nbErr = 0;

		// Phase 1 de l'edition de liens
		// -----------------------------
		lireDescripteurs();	
		transDon = new int[10]; //init de toutes les vars
		transCode = new int[10];
		transDon[0]=0;
		transCode[0]=0;
		dicoDef = new DicoDefElt[60];
		nbDef = 0;
		adFinale = new int[5][10];
		
		for (int i = 1;i<=nMod;i++) {  // remplissage des tab transDon et transCode
			transDon[i] = transDon[i-1] + tabDesc[i-1].getTailleGlobaux();
			transCode[i] = transCode[i-1] + tabDesc[i-1].getTailleCode();
		}
		
		for (int i = 0;i<=nMod;i++) { // remplissage de DicoDef
			
			if (tabDesc[i].getNbDef() < 1 && i != 0) { // detection de Module sans Def
				erreur(NONFATALE,"Le Module #" + i + " n'a pas de Def");
			}
			
			for (int j = 1;j <= tabDesc[i].getNbDef();j++) {
				
				if (!dicoContains(tabDesc[i].getDefNomProc(j))) {
					nbDef++;
					dicoDef[nbDef] = new DicoDefElt(tabDesc[i].getDefNomProc(j),tabDesc[i].getDefAdPo(j) + transCode[i], tabDesc[i].getDefNbParam(j));
				}
				else 
				{
					erreur(NONFATALE,"Erreur : La procedure " + tabDesc[i].getDefNomProc(j) + " est deja declare dans un autre porgramme/module");
				}
			}
		}
		printTrans();
		printDico();
		
		
		boolean  b = false;
		
		for (int i = 0 ; i <=nMod ; i++) { // Remplissage du tab adFinale
			for (int j = 1; j <= tabDesc[i].getNbRef();j++) {
				String procname = tabDesc[i].getRefNomProc(j);
				for (int k = 1; k <= nbDef; k++) {
					if (dicoDef[k].nomProc.equals(procname)) {
						adFinale[i][j] = dicoDef[k].adPo;
						 b = true;
						 if (dicoDef[k].nbParam != tabDesc[i].getRefNbParam(j)) { // detection de Nombre de parametre faux
							 erreur(NONFATALE,"La Procedure appele en Ref : " + tabDesc[i].getRefNomProc(j) + " a un nombre different de parametre a sa Def");
						 }
						
					}
				}
				if (!b) { // detection de manque de procedure Def
					erreur(NONFATALE, "La Procedure appele en Ref : " + tabDesc[i].getRefNomProc(j) + " m'est pas declare en Def dans un Autre Module");
				}
				
			}
		}
		printadFinale();

		if (nbErr > 0) {
			System.out.println("programme executable non produit");
			System.exit(1);
		}

		// Phase 2 de l'edition de liens
		// -----------------------------
		constMap();
		System.out.println("Edition de liens terminee");
	}
}