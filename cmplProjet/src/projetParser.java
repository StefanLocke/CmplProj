// $ANTLR 3.5.2 projet.g 2020-04-17 18:46:40
           
import java.io.IOException;
import java.io.DataInputStream;
import java.io.FileInputStream;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class projetParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "ID", "INT", "ML_COMMENT", 
		"RC", "WS", "'('", "')'", "'*'", "'+'", "','", "'-'", "':'", "':='", "';'", 
		"'<'", "'<='", "'<>'", "'='", "'>'", "'>='", "'alors'", "'aut'", "'bool'", 
		"'cond'", "'const'", "'debut'", "'def'", "'div'", "'ecrire'", "'ent'", 
		"'et'", "'faire'", "'fait'", "'faux'", "'fcond'", "'fin'", "'fixe'", "'fsi'", 
		"'lire'", "'mod'", "'module'", "'non'", "'ou'", "'proc'", "'programme'", 
		"'ref'", "'si'", "'sinon'", "'ttq'", "'var'", "'vrai'"
	};
	public static final int EOF=-1;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int T__25=25;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int T__33=33;
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int T__37=37;
	public static final int T__38=38;
	public static final int T__39=39;
	public static final int T__40=40;
	public static final int T__41=41;
	public static final int T__42=42;
	public static final int T__43=43;
	public static final int T__44=44;
	public static final int T__45=45;
	public static final int T__46=46;
	public static final int T__47=47;
	public static final int T__48=48;
	public static final int T__49=49;
	public static final int T__50=50;
	public static final int T__51=51;
	public static final int T__52=52;
	public static final int T__53=53;
	public static final int T__54=54;
	public static final int T__55=55;
	public static final int COMMENT=4;
	public static final int ID=5;
	public static final int INT=6;
	public static final int ML_COMMENT=7;
	public static final int RC=8;
	public static final int WS=9;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public projetParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public projetParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return projetParser.tokenNames; }
	@Override public String getGrammarFileName() { return "projet.g"; }



	 
	// variables globales et methodes utiles a placer ici
	  



	// $ANTLR start "unite"
	// projet.g:36:1: unite : ( unitprog EOF | unitmodule EOF );
	public final void unite() throws RecognitionException {
		try {
			// projet.g:36:8: ( unitprog EOF | unitmodule EOF )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==49) ) {
				alt1=1;
			}
			else if ( (LA1_0==45) ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// projet.g:36:12: unitprog EOF
					{
					PtGen.pt(50);
					pushFollow(FOLLOW_unitprog_in_unite65);
					unitprog();
					state._fsp--;

					match(input,EOF,FOLLOW_EOF_in_unite68); 
					}
					break;
				case 2 :
					// projet.g:37:12: unitmodule EOF
					{
					PtGen.pt(51);
					pushFollow(FOLLOW_unitmodule_in_unite83);
					unitmodule();
					state._fsp--;

					match(input,EOF,FOLLOW_EOF_in_unite86); 
					}
					break;

			}
		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "unite"



	// $ANTLR start "unitprog"
	// projet.g:40:1: unitprog : 'programme' ident ':' declarations corps ;
	public final void unitprog() throws RecognitionException {
		try {
			// projet.g:41:3: ( 'programme' ident ':' declarations corps )
			// projet.g:41:5: 'programme' ident ':' declarations corps
			{
			match(input,49,FOLLOW_49_in_unitprog101); 
			pushFollow(FOLLOW_ident_in_unitprog103);
			ident();
			state._fsp--;

			match(input,16,FOLLOW_16_in_unitprog105); 
			pushFollow(FOLLOW_declarations_in_unitprog114);
			declarations();
			state._fsp--;

			pushFollow(FOLLOW_corps_in_unitprog123);
			corps();
			state._fsp--;

			PtGen.pt(253);PtGen.pt(255);System.out.println("succes, arret de la compilation ");
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "unitprog"



	// $ANTLR start "unitmodule"
	// projet.g:46:1: unitmodule : 'module' ident ':' declarations ;
	public final void unitmodule() throws RecognitionException {
		try {
			// projet.g:47:3: ( 'module' ident ':' declarations )
			// projet.g:47:5: 'module' ident ':' declarations
			{
			match(input,45,FOLLOW_45_in_unitmodule140); 
			pushFollow(FOLLOW_ident_in_unitmodule142);
			ident();
			state._fsp--;

			match(input,16,FOLLOW_16_in_unitmodule144); 
			pushFollow(FOLLOW_declarations_in_unitmodule152);
			declarations();
			state._fsp--;

			PtGen.pt(255);System.out.println("succes, arret de la compilation ");
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "unitmodule"



	// $ANTLR start "declarations"
	// projet.g:51:1: declarations : ( partiedef )? ( partieref )? ( consts )? ( vars )? ( decprocs )? ;
	public final void declarations() throws RecognitionException {
		try {
			// projet.g:52:3: ( ( partiedef )? ( partieref )? ( consts )? ( vars )? ( decprocs )? )
			// projet.g:52:5: ( partiedef )? ( partieref )? ( consts )? ( vars )? ( decprocs )?
			{
			// projet.g:52:5: ( partiedef )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==31) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// projet.g:52:5: partiedef
					{
					pushFollow(FOLLOW_partiedef_in_declarations169);
					partiedef();
					state._fsp--;

					}
					break;

			}

			// projet.g:52:16: ( partieref )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==50) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// projet.g:52:16: partieref
					{
					pushFollow(FOLLOW_partieref_in_declarations172);
					partieref();
					state._fsp--;

					}
					break;

			}

			// projet.g:52:27: ( consts )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==29) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// projet.g:52:27: consts
					{
					pushFollow(FOLLOW_consts_in_declarations175);
					consts();
					state._fsp--;

					}
					break;

			}

			// projet.g:52:35: ( vars )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==54) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// projet.g:52:35: vars
					{
					pushFollow(FOLLOW_vars_in_declarations178);
					vars();
					state._fsp--;

					}
					break;

			}

			// projet.g:52:42: ( decprocs )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==48) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// projet.g:52:42: decprocs
					{
					pushFollow(FOLLOW_decprocs_in_declarations182);
					decprocs();
					state._fsp--;

					}
					break;

			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "declarations"



	// $ANTLR start "partiedef"
	// projet.g:55:1: partiedef : 'def' ident ( ',' ident )* ptvg ;
	public final void partiedef() throws RecognitionException {
		try {
			// projet.g:56:3: ( 'def' ident ( ',' ident )* ptvg )
			// projet.g:56:5: 'def' ident ( ',' ident )* ptvg
			{
			match(input,31,FOLLOW_31_in_partiedef199); 
			pushFollow(FOLLOW_ident_in_partiedef201);
			ident();
			state._fsp--;

			PtGen.pt(52);
			// projet.g:56:35: ( ',' ident )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==14) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// projet.g:56:36: ',' ident
					{
					match(input,14,FOLLOW_14_in_partiedef208); 
					pushFollow(FOLLOW_ident_in_partiedef210);
					ident();
					state._fsp--;

					PtGen.pt(52);
					}
					break;

				default :
					break loop7;
				}
			}

			pushFollow(FOLLOW_ptvg_in_partiedef217);
			ptvg();
			state._fsp--;

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "partiedef"



	// $ANTLR start "partieref"
	// projet.g:59:1: partieref : 'ref' specif ( ',' specif )* ptvg ;
	public final void partieref() throws RecognitionException {
		try {
			// projet.g:59:10: ( 'ref' specif ( ',' specif )* ptvg )
			// projet.g:59:12: 'ref' specif ( ',' specif )* ptvg
			{
			match(input,50,FOLLOW_50_in_partieref229); 
			pushFollow(FOLLOW_specif_in_partieref232);
			specif();
			state._fsp--;

			// projet.g:59:26: ( ',' specif )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==14) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// projet.g:59:27: ',' specif
					{
					match(input,14,FOLLOW_14_in_partieref235); 
					pushFollow(FOLLOW_specif_in_partieref237);
					specif();
					state._fsp--;

					}
					break;

				default :
					break loop8;
				}
			}

			pushFollow(FOLLOW_ptvg_in_partieref241);
			ptvg();
			state._fsp--;

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "partieref"



	// $ANTLR start "specif"
	// projet.g:62:1: specif : ident ( 'fixe' '(' type ( ',' type )* ')' )? ( 'mod' '(' type ( ',' type )* ')' )? ;
	public final void specif() throws RecognitionException {
		try {
			// projet.g:62:9: ( ident ( 'fixe' '(' type ( ',' type )* ')' )? ( 'mod' '(' type ( ',' type )* ')' )? )
			// projet.g:62:11: ident ( 'fixe' '(' type ( ',' type )* ')' )? ( 'mod' '(' type ( ',' type )* ')' )?
			{
			pushFollow(FOLLOW_ident_in_specif255);
			ident();
			state._fsp--;

			PtGen.pt(53);
			// projet.g:62:33: ( 'fixe' '(' type ( ',' type )* ')' )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==41) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// projet.g:62:35: 'fixe' '(' type ( ',' type )* ')'
					{
					match(input,41,FOLLOW_41_in_specif261); 
					match(input,10,FOLLOW_10_in_specif263); 
					pushFollow(FOLLOW_type_in_specif265);
					type();
					state._fsp--;

					PtGen.pt(55);
					// projet.g:62:67: ( ',' type )*
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( (LA9_0==14) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// projet.g:62:69: ',' type
							{
							match(input,14,FOLLOW_14_in_specif271); 
							pushFollow(FOLLOW_type_in_specif273);
							type();
							state._fsp--;

							PtGen.pt(55);
							}
							break;

						default :
							break loop9;
						}
					}

					match(input,11,FOLLOW_11_in_specif281); 
					}
					break;

			}

			// projet.g:63:18: ( 'mod' '(' type ( ',' type )* ')' )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==44) ) {
				alt12=1;
			}
			switch (alt12) {
				case 1 :
					// projet.g:63:20: 'mod' '(' type ( ',' type )* ')'
					{
					match(input,44,FOLLOW_44_in_specif306); 
					match(input,10,FOLLOW_10_in_specif309); 
					pushFollow(FOLLOW_type_in_specif311);
					type();
					state._fsp--;

					PtGen.pt(56);
					// projet.g:63:53: ( ',' type )*
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( (LA11_0==14) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// projet.g:63:55: ',' type
							{
							match(input,14,FOLLOW_14_in_specif318); 
							pushFollow(FOLLOW_type_in_specif320);
							type();
							state._fsp--;

							PtGen.pt(56);
							}
							break;

						default :
							break loop11;
						}
					}

					match(input,11,FOLLOW_11_in_specif328); 
					}
					break;

			}

			PtGen.pt(57);
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "specif"



	// $ANTLR start "consts"
	// projet.g:66:1: consts : 'const' ( ident '=' valeur ptvg )+ ;
	public final void consts() throws RecognitionException {
		try {
			// projet.g:66:9: ( 'const' ( ident '=' valeur ptvg )+ )
			// projet.g:66:11: 'const' ( ident '=' valeur ptvg )+
			{
			match(input,29,FOLLOW_29_in_consts347); 
			// projet.g:66:19: ( ident '=' valeur ptvg )+
			int cnt13=0;
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==ID) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// projet.g:66:21: ident '=' valeur ptvg
					{
					pushFollow(FOLLOW_ident_in_consts351);
					ident();
					state._fsp--;

					match(input,22,FOLLOW_22_in_consts354); 
					pushFollow(FOLLOW_valeur_in_consts356);
					valeur();
					state._fsp--;

					PtGen.pt(25);
					pushFollow(FOLLOW_ptvg_in_consts360);
					ptvg();
					state._fsp--;

					}
					break;

				default :
					if ( cnt13 >= 1 ) break loop13;
					EarlyExitException eee = new EarlyExitException(13, input);
					throw eee;
				}
				cnt13++;
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "consts"



	// $ANTLR start "vars"
	// projet.g:69:1: vars : 'var' ( type ident ( ',' ident )* ptvg )+ ;
	public final void vars() throws RecognitionException {
		try {
			// projet.g:69:7: ( 'var' ( type ident ( ',' ident )* ptvg )+ )
			// projet.g:69:9: 'var' ( type ident ( ',' ident )* ptvg )+
			{
			match(input,54,FOLLOW_54_in_vars379); 
			// projet.g:69:15: ( type ident ( ',' ident )* ptvg )+
			int cnt15=0;
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==27||LA15_0==34) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// projet.g:69:17: type ident ( ',' ident )* ptvg
					{
					pushFollow(FOLLOW_type_in_vars383);
					type();
					state._fsp--;

					pushFollow(FOLLOW_ident_in_vars385);
					ident();
					state._fsp--;

					PtGen.pt(26);
					// projet.g:69:46: ( ',' ident )*
					loop14:
					while (true) {
						int alt14=2;
						int LA14_0 = input.LA(1);
						if ( (LA14_0==14) ) {
							alt14=1;
						}

						switch (alt14) {
						case 1 :
							// projet.g:69:48: ',' ident
							{
							match(input,14,FOLLOW_14_in_vars393); 
							pushFollow(FOLLOW_ident_in_vars396);
							ident();
							state._fsp--;

							PtGen.pt(26);
							}
							break;

						default :
							break loop14;
						}
					}

					pushFollow(FOLLOW_ptvg_in_vars405);
					ptvg();
					state._fsp--;

					}
					break;

				default :
					if ( cnt15 >= 1 ) break loop15;
					EarlyExitException eee = new EarlyExitException(15, input);
					throw eee;
				}
				cnt15++;
			}

			PtGen.pt(44);
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "vars"



	// $ANTLR start "type"
	// projet.g:72:1: type : ( 'ent' | 'bool' );
	public final void type() throws RecognitionException {
		try {
			// projet.g:72:7: ( 'ent' | 'bool' )
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==34) ) {
				alt16=1;
			}
			else if ( (LA16_0==27) ) {
				alt16=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// projet.g:72:9: 'ent'
					{
					match(input,34,FOLLOW_34_in_type425); 
					PtGen.pt(28);
					}
					break;
				case 2 :
					// projet.g:73:9: 'bool'
					{
					match(input,27,FOLLOW_27_in_type440); 
					PtGen.pt(27);
					}
					break;

			}
		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "type"



	// $ANTLR start "decprocs"
	// projet.g:76:1: decprocs : ( decproc ptvg )+ ;
	public final void decprocs() throws RecognitionException {
		try {
			// projet.g:76:9: ( ( decproc ptvg )+ )
			// projet.g:76:11: ( decproc ptvg )+
			{
			PtGen.pt(252);
			// projet.g:76:27: ( decproc ptvg )+
			int cnt17=0;
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==48) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// projet.g:76:28: decproc ptvg
					{
					pushFollow(FOLLOW_decproc_in_decprocs458);
					decproc();
					state._fsp--;

					pushFollow(FOLLOW_ptvg_in_decprocs460);
					ptvg();
					state._fsp--;

					}
					break;

				default :
					if ( cnt17 >= 1 ) break loop17;
					EarlyExitException eee = new EarlyExitException(17, input);
					throw eee;
				}
				cnt17++;
			}

			PtGen.pt(251);
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "decprocs"



	// $ANTLR start "decproc"
	// projet.g:79:1: decproc : 'proc' ident ( parfixe )? ( parmod )? ( consts )? ( vars )? corps ;
	public final void decproc() throws RecognitionException {
		try {
			// projet.g:79:9: ( 'proc' ident ( parfixe )? ( parmod )? ( consts )? ( vars )? corps )
			// projet.g:79:12: 'proc' ident ( parfixe )? ( parmod )? ( consts )? ( vars )? corps
			{
			match(input,48,FOLLOW_48_in_decproc477); 
			pushFollow(FOLLOW_ident_in_decproc480);
			ident();
			state._fsp--;

			PtGen.pt(39);
			// projet.g:79:42: ( parfixe )?
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==41) ) {
				alt18=1;
			}
			switch (alt18) {
				case 1 :
					// projet.g:79:42: parfixe
					{
					pushFollow(FOLLOW_parfixe_in_decproc484);
					parfixe();
					state._fsp--;

					}
					break;

			}

			// projet.g:79:51: ( parmod )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==44) ) {
				alt19=1;
			}
			switch (alt19) {
				case 1 :
					// projet.g:79:51: parmod
					{
					pushFollow(FOLLOW_parmod_in_decproc487);
					parmod();
					state._fsp--;

					}
					break;

			}

			PtGen.pt(42);
			// projet.g:79:75: ( consts )?
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==29) ) {
				alt20=1;
			}
			switch (alt20) {
				case 1 :
					// projet.g:79:75: consts
					{
					pushFollow(FOLLOW_consts_in_decproc492);
					consts();
					state._fsp--;

					}
					break;

			}

			PtGen.pt(45);
			// projet.g:79:100: ( vars )?
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==54) ) {
				alt21=1;
			}
			switch (alt21) {
				case 1 :
					// projet.g:79:100: vars
					{
					pushFollow(FOLLOW_vars_in_decproc498);
					vars();
					state._fsp--;

					}
					break;

			}

			pushFollow(FOLLOW_corps_in_decproc501);
			corps();
			state._fsp--;

			PtGen.pt(43);
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "decproc"



	// $ANTLR start "ptvg"
	// projet.g:82:1: ptvg : ( ';' |);
	public final void ptvg() throws RecognitionException {
		try {
			// projet.g:82:7: ( ';' |)
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==18) ) {
				alt22=1;
			}
			else if ( (LA22_0==EOF||LA22_0==ID||LA22_0==27||(LA22_0 >= 29 && LA22_0 <= 30)||LA22_0==34||LA22_0==48||LA22_0==50||LA22_0==54) ) {
				alt22=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				throw nvae;
			}

			switch (alt22) {
				case 1 :
					// projet.g:82:9: ';'
					{
					match(input,18,FOLLOW_18_in_ptvg517); 
					}
					break;
				case 2 :
					// projet.g:84:3: 
					{
					}
					break;

			}
		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ptvg"



	// $ANTLR start "corps"
	// projet.g:86:1: corps : 'debut' instructions 'fin' ;
	public final void corps() throws RecognitionException {
		try {
			// projet.g:86:7: ( 'debut' instructions 'fin' )
			// projet.g:86:9: 'debut' instructions 'fin'
			{
			match(input,30,FOLLOW_30_in_corps535); 
			pushFollow(FOLLOW_instructions_in_corps537);
			instructions();
			state._fsp--;

			match(input,40,FOLLOW_40_in_corps539); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "corps"



	// $ANTLR start "parfixe"
	// projet.g:89:1: parfixe : 'fixe' '(' pf ( ';' pf )* ')' ;
	public final void parfixe() throws RecognitionException {
		try {
			// projet.g:89:8: ( 'fixe' '(' pf ( ';' pf )* ')' )
			// projet.g:89:10: 'fixe' '(' pf ( ';' pf )* ')'
			{
			match(input,41,FOLLOW_41_in_parfixe551); 
			match(input,10,FOLLOW_10_in_parfixe553); 
			pushFollow(FOLLOW_pf_in_parfixe555);
			pf();
			state._fsp--;

			// projet.g:89:24: ( ';' pf )*
			loop23:
			while (true) {
				int alt23=2;
				int LA23_0 = input.LA(1);
				if ( (LA23_0==18) ) {
					alt23=1;
				}

				switch (alt23) {
				case 1 :
					// projet.g:89:26: ';' pf
					{
					match(input,18,FOLLOW_18_in_parfixe559); 
					pushFollow(FOLLOW_pf_in_parfixe561);
					pf();
					state._fsp--;

					}
					break;

				default :
					break loop23;
				}
			}

			match(input,11,FOLLOW_11_in_parfixe565); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "parfixe"



	// $ANTLR start "pf"
	// projet.g:92:1: pf : type ident ( ',' ident )* ;
	public final void pf() throws RecognitionException {
		try {
			// projet.g:92:5: ( type ident ( ',' ident )* )
			// projet.g:92:7: type ident ( ',' ident )*
			{
			pushFollow(FOLLOW_type_in_pf579);
			type();
			state._fsp--;

			pushFollow(FOLLOW_ident_in_pf581);
			ident();
			state._fsp--;

			PtGen.pt(40);
			// projet.g:92:34: ( ',' ident )*
			loop24:
			while (true) {
				int alt24=2;
				int LA24_0 = input.LA(1);
				if ( (LA24_0==14) ) {
					alt24=1;
				}

				switch (alt24) {
				case 1 :
					// projet.g:92:36: ',' ident
					{
					match(input,14,FOLLOW_14_in_pf587); 
					pushFollow(FOLLOW_ident_in_pf589);
					ident();
					state._fsp--;

					PtGen.pt(40);
					}
					break;

				default :
					break loop24;
				}
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "pf"



	// $ANTLR start "parmod"
	// projet.g:95:1: parmod : 'mod' '(' pm ( ';' pm )* ')' ;
	public final void parmod() throws RecognitionException {
		try {
			// projet.g:95:9: ( 'mod' '(' pm ( ';' pm )* ')' )
			// projet.g:95:11: 'mod' '(' pm ( ';' pm )* ')'
			{
			match(input,44,FOLLOW_44_in_parmod608); 
			match(input,10,FOLLOW_10_in_parmod610); 
			pushFollow(FOLLOW_pm_in_parmod612);
			pm();
			state._fsp--;

			// projet.g:95:24: ( ';' pm )*
			loop25:
			while (true) {
				int alt25=2;
				int LA25_0 = input.LA(1);
				if ( (LA25_0==18) ) {
					alt25=1;
				}

				switch (alt25) {
				case 1 :
					// projet.g:95:26: ';' pm
					{
					match(input,18,FOLLOW_18_in_parmod616); 
					pushFollow(FOLLOW_pm_in_parmod618);
					pm();
					state._fsp--;

					}
					break;

				default :
					break loop25;
				}
			}

			match(input,11,FOLLOW_11_in_parmod622); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "parmod"



	// $ANTLR start "pm"
	// projet.g:98:1: pm : type ident ( ',' ident )* ;
	public final void pm() throws RecognitionException {
		try {
			// projet.g:98:5: ( type ident ( ',' ident )* )
			// projet.g:98:7: type ident ( ',' ident )*
			{
			pushFollow(FOLLOW_type_in_pm636);
			type();
			state._fsp--;

			pushFollow(FOLLOW_ident_in_pm638);
			ident();
			state._fsp--;

			PtGen.pt(41);
			// projet.g:98:35: ( ',' ident )*
			loop26:
			while (true) {
				int alt26=2;
				int LA26_0 = input.LA(1);
				if ( (LA26_0==14) ) {
					alt26=1;
				}

				switch (alt26) {
				case 1 :
					// projet.g:98:37: ',' ident
					{
					match(input,14,FOLLOW_14_in_pm645); 
					pushFollow(FOLLOW_ident_in_pm647);
					ident();
					state._fsp--;

					PtGen.pt(41);
					}
					break;

				default :
					break loop26;
				}
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "pm"



	// $ANTLR start "instructions"
	// projet.g:101:1: instructions : instruction ( ';' instruction )* ;
	public final void instructions() throws RecognitionException {
		try {
			// projet.g:102:3: ( instruction ( ';' instruction )* )
			// projet.g:102:5: instruction ( ';' instruction )*
			{
			pushFollow(FOLLOW_instruction_in_instructions667);
			instruction();
			state._fsp--;

			// projet.g:102:17: ( ';' instruction )*
			loop27:
			while (true) {
				int alt27=2;
				int LA27_0 = input.LA(1);
				if ( (LA27_0==18) ) {
					alt27=1;
				}

				switch (alt27) {
				case 1 :
					// projet.g:102:19: ';' instruction
					{
					match(input,18,FOLLOW_18_in_instructions671); 
					pushFollow(FOLLOW_instruction_in_instructions673);
					instruction();
					state._fsp--;

					}
					break;

				default :
					break loop27;
				}
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "instructions"



	// $ANTLR start "instruction"
	// projet.g:105:1: instruction : ( inssi | inscond | boucle | lecture | ecriture | affouappel |);
	public final void instruction() throws RecognitionException {
		try {
			// projet.g:106:3: ( inssi | inscond | boucle | lecture | ecriture | affouappel |)
			int alt28=7;
			switch ( input.LA(1) ) {
			case 51:
				{
				alt28=1;
				}
				break;
			case 28:
				{
				alt28=2;
				}
				break;
			case 53:
				{
				alt28=3;
				}
				break;
			case 43:
				{
				alt28=4;
				}
				break;
			case 33:
				{
				alt28=5;
				}
				break;
			case ID:
				{
				alt28=6;
				}
				break;
			case 14:
			case 18:
			case 26:
			case 37:
			case 39:
			case 40:
			case 42:
			case 52:
				{
				alt28=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 28, 0, input);
				throw nvae;
			}
			switch (alt28) {
				case 1 :
					// projet.g:106:5: inssi
					{
					pushFollow(FOLLOW_inssi_in_instruction690);
					inssi();
					state._fsp--;

					}
					break;
				case 2 :
					// projet.g:107:5: inscond
					{
					pushFollow(FOLLOW_inscond_in_instruction696);
					inscond();
					state._fsp--;

					}
					break;
				case 3 :
					// projet.g:108:5: boucle
					{
					pushFollow(FOLLOW_boucle_in_instruction702);
					boucle();
					state._fsp--;

					}
					break;
				case 4 :
					// projet.g:109:5: lecture
					{
					pushFollow(FOLLOW_lecture_in_instruction708);
					lecture();
					state._fsp--;

					}
					break;
				case 5 :
					// projet.g:110:5: ecriture
					{
					pushFollow(FOLLOW_ecriture_in_instruction714);
					ecriture();
					state._fsp--;

					}
					break;
				case 6 :
					// projet.g:111:5: affouappel
					{
					pushFollow(FOLLOW_affouappel_in_instruction720);
					affouappel();
					state._fsp--;

					}
					break;
				case 7 :
					// projet.g:113:3: 
					{
					}
					break;

			}
		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "instruction"



	// $ANTLR start "inssi"
	// projet.g:115:1: inssi : 'si' expression 'alors' instructions ( 'sinon' instructions )? 'fsi' ;
	public final void inssi() throws RecognitionException {
		try {
			// projet.g:115:7: ( 'si' expression 'alors' instructions ( 'sinon' instructions )? 'fsi' )
			// projet.g:115:9: 'si' expression 'alors' instructions ( 'sinon' instructions )? 'fsi'
			{
			match(input,51,FOLLOW_51_in_inssi738); 
			pushFollow(FOLLOW_expression_in_inssi740);
			expression();
			state._fsp--;

			PtGen.pt(1);PtGen.pt(29);
			match(input,25,FOLLOW_25_in_inssi745); 
			pushFollow(FOLLOW_instructions_in_inssi747);
			instructions();
			state._fsp--;

			// projet.g:115:76: ( 'sinon' instructions )?
			int alt29=2;
			int LA29_0 = input.LA(1);
			if ( (LA29_0==52) ) {
				alt29=1;
			}
			switch (alt29) {
				case 1 :
					// projet.g:115:78: 'sinon' instructions
					{
					match(input,52,FOLLOW_52_in_inssi752); 
					PtGen.pt(31);
					pushFollow(FOLLOW_instructions_in_inssi756);
					instructions();
					state._fsp--;

					}
					break;

			}

			match(input,42,FOLLOW_42_in_inssi760); 
			PtGen.pt(32);
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "inssi"



	// $ANTLR start "inscond"
	// projet.g:118:1: inscond : 'cond' expression ':' instructions ( ',' expression ':' instructions )* ( 'aut' instructions |) 'fcond' ;
	public final void inscond() throws RecognitionException {
		try {
			// projet.g:118:9: ( 'cond' expression ':' instructions ( ',' expression ':' instructions )* ( 'aut' instructions |) 'fcond' )
			// projet.g:118:11: 'cond' expression ':' instructions ( ',' expression ':' instructions )* ( 'aut' instructions |) 'fcond'
			{
			match(input,28,FOLLOW_28_in_inscond776); 
			PtGen.pt(35);
			pushFollow(FOLLOW_expression_in_inscond781);
			expression();
			state._fsp--;

			PtGen.pt(1);PtGen.pt(29);
			match(input,16,FOLLOW_16_in_inscond784); 
			pushFollow(FOLLOW_instructions_in_inscond786);
			instructions();
			state._fsp--;

			// projet.g:119:11: ( ',' expression ':' instructions )*
			loop30:
			while (true) {
				int alt30=2;
				int LA30_0 = input.LA(1);
				if ( (LA30_0==14) ) {
					alt30=1;
				}

				switch (alt30) {
				case 1 :
					// projet.g:119:12: ',' expression ':' instructions
					{
					match(input,14,FOLLOW_14_in_inscond801); 
					PtGen.pt(36);
					pushFollow(FOLLOW_expression_in_inscond807);
					expression();
					state._fsp--;

					PtGen.pt(1);PtGen.pt(29);
					match(input,16,FOLLOW_16_in_inscond812); 
					pushFollow(FOLLOW_instructions_in_inscond814);
					instructions();
					state._fsp--;

					}
					break;

				default :
					break loop30;
				}
			}

			// projet.g:120:11: ( 'aut' instructions |)
			int alt31=2;
			int LA31_0 = input.LA(1);
			if ( (LA31_0==26) ) {
				alt31=1;
			}
			else if ( (LA31_0==39) ) {
				alt31=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 31, 0, input);
				throw nvae;
			}

			switch (alt31) {
				case 1 :
					// projet.g:120:13: 'aut' instructions
					{
					PtGen.pt(36);
					match(input,26,FOLLOW_26_in_inscond835); 
					pushFollow(FOLLOW_instructions_in_inscond838);
					instructions();
					state._fsp--;

					}
					break;
				case 2 :
					// projet.g:120:53: 
					{
					PtGen.pt(37);
					}
					break;

			}

			match(input,39,FOLLOW_39_in_inscond859); 
			PtGen.pt(38);
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "inscond"



	// $ANTLR start "boucle"
	// projet.g:124:1: boucle : 'ttq' expression 'faire' instructions 'fait' ;
	public final void boucle() throws RecognitionException {
		try {
			// projet.g:124:9: ( 'ttq' expression 'faire' instructions 'fait' )
			// projet.g:124:11: 'ttq' expression 'faire' instructions 'fait'
			{
			match(input,53,FOLLOW_53_in_boucle875); 
			PtGen.pt(33);
			pushFollow(FOLLOW_expression_in_boucle879);
			expression();
			state._fsp--;

			PtGen.pt(1);PtGen.pt(29);
			match(input,36,FOLLOW_36_in_boucle884); 
			pushFollow(FOLLOW_instructions_in_boucle886);
			instructions();
			state._fsp--;

			PtGen.pt(34);
			match(input,37,FOLLOW_37_in_boucle890); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "boucle"



	// $ANTLR start "lecture"
	// projet.g:127:1: lecture : 'lire' '(' ident ( ',' ident )* ')' ;
	public final void lecture() throws RecognitionException {
		try {
			// projet.g:127:8: ( 'lire' '(' ident ( ',' ident )* ')' )
			// projet.g:127:10: 'lire' '(' ident ( ',' ident )* ')'
			{
			match(input,43,FOLLOW_43_in_lecture903); 
			match(input,10,FOLLOW_10_in_lecture905); 
			pushFollow(FOLLOW_ident_in_lecture907);
			ident();
			state._fsp--;

			PtGen.pt(24);
			// projet.g:127:44: ( ',' ident )*
			loop32:
			while (true) {
				int alt32=2;
				int LA32_0 = input.LA(1);
				if ( (LA32_0==14) ) {
					alt32=1;
				}

				switch (alt32) {
				case 1 :
					// projet.g:127:46: ',' ident
					{
					match(input,14,FOLLOW_14_in_lecture914); 
					pushFollow(FOLLOW_ident_in_lecture916);
					ident();
					state._fsp--;

					PtGen.pt(24);
					}
					break;

				default :
					break loop32;
				}
			}

			match(input,11,FOLLOW_11_in_lecture924); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "lecture"



	// $ANTLR start "ecriture"
	// projet.g:130:1: ecriture : 'ecrire' '(' expression ( ',' expression )* ')' ;
	public final void ecriture() throws RecognitionException {
		try {
			// projet.g:130:9: ( 'ecrire' '(' expression ( ',' expression )* ')' )
			// projet.g:130:11: 'ecrire' '(' expression ( ',' expression )* ')'
			{
			match(input,33,FOLLOW_33_in_ecriture937); 
			match(input,10,FOLLOW_10_in_ecriture939); 
			pushFollow(FOLLOW_expression_in_ecriture941);
			expression();
			state._fsp--;

			PtGen.pt(23);
			// projet.g:130:52: ( ',' expression )*
			loop33:
			while (true) {
				int alt33=2;
				int LA33_0 = input.LA(1);
				if ( (LA33_0==14) ) {
					alt33=1;
				}

				switch (alt33) {
				case 1 :
					// projet.g:130:54: ',' expression
					{
					match(input,14,FOLLOW_14_in_ecriture948); 
					pushFollow(FOLLOW_expression_in_ecriture950);
					expression();
					state._fsp--;

					PtGen.pt(23);
					}
					break;

				default :
					break loop33;
				}
			}

			match(input,11,FOLLOW_11_in_ecriture957); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ecriture"



	// $ANTLR start "affouappel"
	// projet.g:133:1: affouappel : ident ( ':=' expression | ( effixes ( effmods )? )? ) ;
	public final void affouappel() throws RecognitionException {
		try {
			// projet.g:133:11: ( ident ( ':=' expression | ( effixes ( effmods )? )? ) )
			// projet.g:133:13: ident ( ':=' expression | ( effixes ( effmods )? )? )
			{
			pushFollow(FOLLOW_ident_in_affouappel970);
			ident();
			state._fsp--;

			// projet.g:133:20: ( ':=' expression | ( effixes ( effmods )? )? )
			int alt36=2;
			int LA36_0 = input.LA(1);
			if ( (LA36_0==17) ) {
				alt36=1;
			}
			else if ( (LA36_0==10||LA36_0==14||LA36_0==18||LA36_0==26||LA36_0==37||(LA36_0 >= 39 && LA36_0 <= 40)||LA36_0==42||LA36_0==52) ) {
				alt36=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 36, 0, input);
				throw nvae;
			}

			switch (alt36) {
				case 1 :
					// projet.g:133:25: ':=' expression
					{
					match(input,17,FOLLOW_17_in_affouappel978); 
					PtGen.pt(30);
					pushFollow(FOLLOW_expression_in_affouappel983);
					expression();
					state._fsp--;

					PtGen.pt(22);
					}
					break;
				case 2 :
					// projet.g:134:16: ( effixes ( effmods )? )?
					{
					PtGen.pt(46);
					// projet.g:134:32: ( effixes ( effmods )? )?
					int alt35=2;
					int LA35_0 = input.LA(1);
					if ( (LA35_0==10) ) {
						alt35=1;
					}
					switch (alt35) {
						case 1 :
							// projet.g:134:33: effixes ( effmods )?
							{
							pushFollow(FOLLOW_effixes_in_affouappel1005);
							effixes();
							state._fsp--;

							// projet.g:134:41: ( effmods )?
							int alt34=2;
							int LA34_0 = input.LA(1);
							if ( (LA34_0==10) ) {
								alt34=1;
							}
							switch (alt34) {
								case 1 :
									// projet.g:134:42: effmods
									{
									pushFollow(FOLLOW_effmods_in_affouappel1008);
									effmods();
									state._fsp--;

									}
									break;

							}

							}
							break;

					}

					PtGen.pt(49);
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "affouappel"



	// $ANTLR start "effixes"
	// projet.g:138:1: effixes : '(' ( expression ( ',' expression )* )? ')' ;
	public final void effixes() throws RecognitionException {
		try {
			// projet.g:138:9: ( '(' ( expression ( ',' expression )* )? ')' )
			// projet.g:138:11: '(' ( expression ( ',' expression )* )? ')'
			{
			match(input,10,FOLLOW_10_in_effixes1042); 
			// projet.g:138:15: ( expression ( ',' expression )* )?
			int alt38=2;
			int LA38_0 = input.LA(1);
			if ( ((LA38_0 >= ID && LA38_0 <= INT)||LA38_0==10||LA38_0==13||LA38_0==15||LA38_0==38||LA38_0==46||LA38_0==55) ) {
				alt38=1;
			}
			switch (alt38) {
				case 1 :
					// projet.g:138:16: expression ( ',' expression )*
					{
					pushFollow(FOLLOW_expression_in_effixes1045);
					expression();
					state._fsp--;

					PtGen.pt(47);
					// projet.g:138:43: ( ',' expression )*
					loop37:
					while (true) {
						int alt37=2;
						int LA37_0 = input.LA(1);
						if ( (LA37_0==14) ) {
							alt37=1;
						}

						switch (alt37) {
						case 1 :
							// projet.g:138:44: ',' expression
							{
							match(input,14,FOLLOW_14_in_effixes1050); 
							pushFollow(FOLLOW_expression_in_effixes1052);
							expression();
							state._fsp--;

							PtGen.pt(47);
							}
							break;

						default :
							break loop37;
						}
					}

					}
					break;

			}

			match(input,11,FOLLOW_11_in_effixes1061); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "effixes"



	// $ANTLR start "effmods"
	// projet.g:141:1: effmods : '(' ( ident ( ',' ident )* )? ')' ;
	public final void effmods() throws RecognitionException {
		try {
			// projet.g:141:9: ( '(' ( ident ( ',' ident )* )? ')' )
			// projet.g:141:10: '(' ( ident ( ',' ident )* )? ')'
			{
			match(input,10,FOLLOW_10_in_effmods1073); 
			// projet.g:141:14: ( ident ( ',' ident )* )?
			int alt40=2;
			int LA40_0 = input.LA(1);
			if ( (LA40_0==ID) ) {
				alt40=1;
			}
			switch (alt40) {
				case 1 :
					// projet.g:141:15: ident ( ',' ident )*
					{
					pushFollow(FOLLOW_ident_in_effmods1076);
					ident();
					state._fsp--;

					PtGen.pt(48);
					// projet.g:141:37: ( ',' ident )*
					loop39:
					while (true) {
						int alt39=2;
						int LA39_0 = input.LA(1);
						if ( (LA39_0==14) ) {
							alt39=1;
						}

						switch (alt39) {
						case 1 :
							// projet.g:141:38: ',' ident
							{
							match(input,14,FOLLOW_14_in_effmods1081); 
							pushFollow(FOLLOW_ident_in_effmods1083);
							ident();
							state._fsp--;

							PtGen.pt(48);
							}
							break;

						default :
							break loop39;
						}
					}

					}
					break;

			}

			match(input,11,FOLLOW_11_in_effmods1092); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "effmods"



	// $ANTLR start "expression"
	// projet.g:144:1: expression : ( exp1 ) ( 'ou' exp1 )* ;
	public final void expression() throws RecognitionException {
		try {
			// projet.g:144:11: ( ( exp1 ) ( 'ou' exp1 )* )
			// projet.g:144:13: ( exp1 ) ( 'ou' exp1 )*
			{
			// projet.g:144:13: ( exp1 )
			// projet.g:144:14: exp1
			{
			pushFollow(FOLLOW_exp1_in_expression1106);
			exp1();
			state._fsp--;

			}

			// projet.g:144:20: ( 'ou' exp1 )*
			loop41:
			while (true) {
				int alt41=2;
				int LA41_0 = input.LA(1);
				if ( (LA41_0==47) ) {
					alt41=1;
				}

				switch (alt41) {
				case 1 :
					// projet.g:144:21: 'ou' exp1
					{
					match(input,47,FOLLOW_47_in_expression1110); 
					PtGen.pt(1);
					pushFollow(FOLLOW_exp1_in_expression1114);
					exp1();
					state._fsp--;

					PtGen.pt(1);PtGen.pt(3);
					}
					break;

				default :
					break loop41;
				}
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "expression"



	// $ANTLR start "exp1"
	// projet.g:147:1: exp1 : exp2 ( 'et' exp2 )* ;
	public final void exp1() throws RecognitionException {
		try {
			// projet.g:147:7: ( exp2 ( 'et' exp2 )* )
			// projet.g:147:9: exp2 ( 'et' exp2 )*
			{
			pushFollow(FOLLOW_exp2_in_exp11134);
			exp2();
			state._fsp--;

			// projet.g:147:14: ( 'et' exp2 )*
			loop42:
			while (true) {
				int alt42=2;
				int LA42_0 = input.LA(1);
				if ( (LA42_0==35) ) {
					alt42=1;
				}

				switch (alt42) {
				case 1 :
					// projet.g:147:15: 'et' exp2
					{
					match(input,35,FOLLOW_35_in_exp11137); 
					PtGen.pt(1);
					pushFollow(FOLLOW_exp2_in_exp11142);
					exp2();
					state._fsp--;

					PtGen.pt(1); PtGen.pt(4);
					}
					break;

				default :
					break loop42;
				}
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp1"



	// $ANTLR start "exp2"
	// projet.g:150:1: exp2 : ( 'non' exp2 | exp3 );
	public final void exp2() throws RecognitionException {
		try {
			// projet.g:150:7: ( 'non' exp2 | exp3 )
			int alt43=2;
			int LA43_0 = input.LA(1);
			if ( (LA43_0==46) ) {
				alt43=1;
			}
			else if ( ((LA43_0 >= ID && LA43_0 <= INT)||LA43_0==10||LA43_0==13||LA43_0==15||LA43_0==38||LA43_0==55) ) {
				alt43=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 43, 0, input);
				throw nvae;
			}

			switch (alt43) {
				case 1 :
					// projet.g:150:9: 'non' exp2
					{
					match(input,46,FOLLOW_46_in_exp21161); 
					pushFollow(FOLLOW_exp2_in_exp21163);
					exp2();
					state._fsp--;

					PtGen.pt(1);PtGen.pt(5);
					}
					break;
				case 2 :
					// projet.g:151:5: exp3
					{
					pushFollow(FOLLOW_exp3_in_exp21171);
					exp3();
					state._fsp--;

					}
					break;

			}
		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp2"



	// $ANTLR start "exp3"
	// projet.g:154:1: exp3 : exp4 ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )? ;
	public final void exp3() throws RecognitionException {
		try {
			// projet.g:154:7: ( exp4 ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )? )
			// projet.g:154:9: exp4 ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )?
			{
			pushFollow(FOLLOW_exp4_in_exp31187);
			exp4();
			state._fsp--;

			// projet.g:155:3: ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )?
			int alt44=7;
			switch ( input.LA(1) ) {
				case 22:
					{
					alt44=1;
					}
					break;
				case 21:
					{
					alt44=2;
					}
					break;
				case 23:
					{
					alt44=3;
					}
					break;
				case 24:
					{
					alt44=4;
					}
					break;
				case 19:
					{
					alt44=5;
					}
					break;
				case 20:
					{
					alt44=6;
					}
					break;
			}
			switch (alt44) {
				case 1 :
					// projet.g:155:5: '=' exp4
					{
					match(input,22,FOLLOW_22_in_exp31194); 
					PtGen.pt(2);
					pushFollow(FOLLOW_exp4_in_exp31200);
					exp4();
					state._fsp--;

					PtGen.pt(2);PtGen.pt(16);
					}
					break;
				case 2 :
					// projet.g:156:5: '<>' exp4
					{
					match(input,21,FOLLOW_21_in_exp31208); 
					PtGen.pt(2);
					pushFollow(FOLLOW_exp4_in_exp31213);
					exp4();
					state._fsp--;

					PtGen.pt(2);PtGen.pt(17);
					}
					break;
				case 3 :
					// projet.g:157:5: '>' exp4
					{
					match(input,23,FOLLOW_23_in_exp31221); 
					PtGen.pt(2);
					pushFollow(FOLLOW_exp4_in_exp31227);
					exp4();
					state._fsp--;

					PtGen.pt(2);PtGen.pt(18);
					}
					break;
				case 4 :
					// projet.g:158:5: '>=' exp4
					{
					match(input,24,FOLLOW_24_in_exp31235); 
					PtGen.pt(2);
					pushFollow(FOLLOW_exp4_in_exp31240);
					exp4();
					state._fsp--;

					PtGen.pt(2);PtGen.pt(19);
					}
					break;
				case 5 :
					// projet.g:159:5: '<' exp4
					{
					match(input,19,FOLLOW_19_in_exp31248); 
					PtGen.pt(2);
					pushFollow(FOLLOW_exp4_in_exp31254);
					exp4();
					state._fsp--;

					PtGen.pt(2);PtGen.pt(20);
					}
					break;
				case 6 :
					// projet.g:160:5: '<=' exp4
					{
					match(input,20,FOLLOW_20_in_exp31262); 
					PtGen.pt(2);
					pushFollow(FOLLOW_exp4_in_exp31267);
					exp4();
					state._fsp--;

					PtGen.pt(2);PtGen.pt(21);
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp3"



	// $ANTLR start "exp4"
	// projet.g:164:1: exp4 : exp5 ( '+' exp5 | '-' exp5 )* ;
	public final void exp4() throws RecognitionException {
		try {
			// projet.g:164:7: ( exp5 ( '+' exp5 | '-' exp5 )* )
			// projet.g:164:9: exp5 ( '+' exp5 | '-' exp5 )*
			{
			pushFollow(FOLLOW_exp5_in_exp41289);
			exp5();
			state._fsp--;

			// projet.g:165:2: ( '+' exp5 | '-' exp5 )*
			loop45:
			while (true) {
				int alt45=3;
				int LA45_0 = input.LA(1);
				if ( (LA45_0==13) ) {
					alt45=1;
				}
				else if ( (LA45_0==15) ) {
					alt45=2;
				}

				switch (alt45) {
				case 1 :
					// projet.g:165:2: '+' exp5
					{
					match(input,13,FOLLOW_13_in_exp41292); 
					PtGen.pt(2);
					pushFollow(FOLLOW_exp5_in_exp41296);
					exp5();
					state._fsp--;

					PtGen.pt(2);PtGen.pt(14);
					}
					break;
				case 2 :
					// projet.g:166:2: '-' exp5
					{
					match(input,15,FOLLOW_15_in_exp41302); 
					PtGen.pt(2);
					pushFollow(FOLLOW_exp5_in_exp41306);
					exp5();
					state._fsp--;

					PtGen.pt(2);PtGen.pt(15);
					}
					break;

				default :
					break loop45;
				}
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp4"



	// $ANTLR start "exp5"
	// projet.g:170:1: exp5 : primaire ( '*' primaire | 'div' primaire )* ;
	public final void exp5() throws RecognitionException {
		try {
			// projet.g:170:7: ( primaire ( '*' primaire | 'div' primaire )* )
			// projet.g:170:9: primaire ( '*' primaire | 'div' primaire )*
			{
			pushFollow(FOLLOW_primaire_in_exp51326);
			primaire();
			state._fsp--;

			// projet.g:171:9: ( '*' primaire | 'div' primaire )*
			loop46:
			while (true) {
				int alt46=3;
				int LA46_0 = input.LA(1);
				if ( (LA46_0==12) ) {
					alt46=1;
				}
				else if ( (LA46_0==32) ) {
					alt46=2;
				}

				switch (alt46) {
				case 1 :
					// projet.g:171:14: '*' primaire
					{
					match(input,12,FOLLOW_12_in_exp51342); 
					PtGen.pt(2);
					pushFollow(FOLLOW_primaire_in_exp51348);
					primaire();
					state._fsp--;

					PtGen.pt(2);PtGen.pt(12);
					}
					break;
				case 2 :
					// projet.g:172:13: 'div' primaire
					{
					match(input,32,FOLLOW_32_in_exp51365); 
					PtGen.pt(2);
					pushFollow(FOLLOW_primaire_in_exp51370);
					primaire();
					state._fsp--;

					PtGen.pt(2);PtGen.pt(13);
					}
					break;

				default :
					break loop46;
				}
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp5"



	// $ANTLR start "primaire"
	// projet.g:176:1: primaire : ( valeur | ident | '(' expression ')' );
	public final void primaire() throws RecognitionException {
		try {
			// projet.g:176:9: ( valeur | ident | '(' expression ')' )
			int alt47=3;
			switch ( input.LA(1) ) {
			case INT:
			case 13:
			case 15:
			case 38:
			case 55:
				{
				alt47=1;
				}
				break;
			case ID:
				{
				alt47=2;
				}
				break;
			case 10:
				{
				alt47=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 47, 0, input);
				throw nvae;
			}
			switch (alt47) {
				case 1 :
					// projet.g:176:11: valeur
					{
					pushFollow(FOLLOW_valeur_in_primaire1396);
					valeur();
					state._fsp--;

					PtGen.pt(6);
					}
					break;
				case 2 :
					// projet.g:177:5: ident
					{
					pushFollow(FOLLOW_ident_in_primaire1405);
					ident();
					state._fsp--;

					PtGen.pt(11);
					}
					break;
				case 3 :
					// projet.g:178:5: '(' expression ')'
					{
					match(input,10,FOLLOW_10_in_primaire1415); 
					pushFollow(FOLLOW_expression_in_primaire1417);
					expression();
					state._fsp--;

					match(input,11,FOLLOW_11_in_primaire1419); 
					}
					break;

			}
		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "primaire"



	// $ANTLR start "valeur"
	// projet.g:181:1: valeur : ( nbentier | '+' nbentier | '-' nbentier | 'vrai' | 'faux' );
	public final void valeur() throws RecognitionException {
		try {
			// projet.g:181:9: ( nbentier | '+' nbentier | '-' nbentier | 'vrai' | 'faux' )
			int alt48=5;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt48=1;
				}
				break;
			case 13:
				{
				alt48=2;
				}
				break;
			case 15:
				{
				alt48=3;
				}
				break;
			case 55:
				{
				alt48=4;
				}
				break;
			case 38:
				{
				alt48=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 48, 0, input);
				throw nvae;
			}
			switch (alt48) {
				case 1 :
					// projet.g:181:11: nbentier
					{
					pushFollow(FOLLOW_nbentier_in_valeur1433);
					nbentier();
					state._fsp--;

					PtGen.pt(7);
					}
					break;
				case 2 :
					// projet.g:182:5: '+' nbentier
					{
					match(input,13,FOLLOW_13_in_valeur1441); 
					pushFollow(FOLLOW_nbentier_in_valeur1443);
					nbentier();
					state._fsp--;

					PtGen.pt(7);
					}
					break;
				case 3 :
					// projet.g:183:5: '-' nbentier
					{
					match(input,15,FOLLOW_15_in_valeur1451); 
					pushFollow(FOLLOW_nbentier_in_valeur1453);
					nbentier();
					state._fsp--;

					PtGen.pt(8);
					}
					break;
				case 4 :
					// projet.g:184:5: 'vrai'
					{
					match(input,55,FOLLOW_55_in_valeur1461); 
					PtGen.pt(9);
					}
					break;
				case 5 :
					// projet.g:185:5: 'faux'
					{
					match(input,38,FOLLOW_38_in_valeur1469); 
					PtGen.pt(10);
					}
					break;

			}
		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "valeur"



	// $ANTLR start "nbentier"
	// projet.g:195:1: nbentier : INT ;
	public final void nbentier() throws RecognitionException {
		Token INT1=null;

		try {
			// projet.g:195:11: ( INT )
			// projet.g:195:15: INT
			{
			INT1=(Token)match(input,INT,FOLLOW_INT_in_nbentier1499); 
			 UtilLex.valEnt = Integer.parseInt((INT1!=null?INT1.getText():null));
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "nbentier"



	// $ANTLR start "ident"
	// projet.g:197:1: ident : ID ;
	public final void ident() throws RecognitionException {
		Token ID2=null;

		try {
			// projet.g:197:7: ( ID )
			// projet.g:197:9: ID
			{
			ID2=(Token)match(input,ID,FOLLOW_ID_in_ident1510); 
			 UtilLex.traiterId((ID2!=null?ID2.getText():null)); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ident"

	// Delegated rules



	public static final BitSet FOLLOW_unitprog_in_unite65 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_unite68 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unitmodule_in_unite83 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_unite86 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_49_in_unitprog101 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_unitprog103 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_unitprog105 = new BitSet(new long[]{0x00450000E0000000L});
	public static final BitSet FOLLOW_declarations_in_unitprog114 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_corps_in_unitprog123 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_45_in_unitmodule140 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_unitmodule142 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_unitmodule144 = new BitSet(new long[]{0x00450000A0000000L});
	public static final BitSet FOLLOW_declarations_in_unitmodule152 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_partiedef_in_declarations169 = new BitSet(new long[]{0x0045000020000002L});
	public static final BitSet FOLLOW_partieref_in_declarations172 = new BitSet(new long[]{0x0041000020000002L});
	public static final BitSet FOLLOW_consts_in_declarations175 = new BitSet(new long[]{0x0041000000000002L});
	public static final BitSet FOLLOW_vars_in_declarations178 = new BitSet(new long[]{0x0001000000000002L});
	public static final BitSet FOLLOW_decprocs_in_declarations182 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_partiedef199 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_partiedef201 = new BitSet(new long[]{0x0000000000044000L});
	public static final BitSet FOLLOW_14_in_partiedef208 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_partiedef210 = new BitSet(new long[]{0x0000000000044000L});
	public static final BitSet FOLLOW_ptvg_in_partiedef217 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_50_in_partieref229 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_specif_in_partieref232 = new BitSet(new long[]{0x0000000000044000L});
	public static final BitSet FOLLOW_14_in_partieref235 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_specif_in_partieref237 = new BitSet(new long[]{0x0000000000044000L});
	public static final BitSet FOLLOW_ptvg_in_partieref241 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_specif255 = new BitSet(new long[]{0x0000120000000002L});
	public static final BitSet FOLLOW_41_in_specif261 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_specif263 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_type_in_specif265 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_14_in_specif271 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_type_in_specif273 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_11_in_specif281 = new BitSet(new long[]{0x0000100000000002L});
	public static final BitSet FOLLOW_44_in_specif306 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_specif309 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_type_in_specif311 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_14_in_specif318 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_type_in_specif320 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_11_in_specif328 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_consts347 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_consts351 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_consts354 = new BitSet(new long[]{0x008000400000A040L});
	public static final BitSet FOLLOW_valeur_in_consts356 = new BitSet(new long[]{0x0000000000040020L});
	public static final BitSet FOLLOW_ptvg_in_consts360 = new BitSet(new long[]{0x0000000000000022L});
	public static final BitSet FOLLOW_54_in_vars379 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_type_in_vars383 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_vars385 = new BitSet(new long[]{0x0000000408044000L});
	public static final BitSet FOLLOW_14_in_vars393 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_vars396 = new BitSet(new long[]{0x0000000408044000L});
	public static final BitSet FOLLOW_ptvg_in_vars405 = new BitSet(new long[]{0x0000000408000002L});
	public static final BitSet FOLLOW_34_in_type425 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_type440 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_decproc_in_decprocs458 = new BitSet(new long[]{0x0001000000040000L});
	public static final BitSet FOLLOW_ptvg_in_decprocs460 = new BitSet(new long[]{0x0001000000000002L});
	public static final BitSet FOLLOW_48_in_decproc477 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_decproc480 = new BitSet(new long[]{0x0040120060000000L});
	public static final BitSet FOLLOW_parfixe_in_decproc484 = new BitSet(new long[]{0x0040100060000000L});
	public static final BitSet FOLLOW_parmod_in_decproc487 = new BitSet(new long[]{0x0040000060000000L});
	public static final BitSet FOLLOW_consts_in_decproc492 = new BitSet(new long[]{0x0040000040000000L});
	public static final BitSet FOLLOW_vars_in_decproc498 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_corps_in_decproc501 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_ptvg517 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_corps535 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instructions_in_corps537 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_40_in_corps539 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_41_in_parfixe551 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_parfixe553 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_pf_in_parfixe555 = new BitSet(new long[]{0x0000000000040800L});
	public static final BitSet FOLLOW_18_in_parfixe559 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_pf_in_parfixe561 = new BitSet(new long[]{0x0000000000040800L});
	public static final BitSet FOLLOW_11_in_parfixe565 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_pf579 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pf581 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_14_in_pf587 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pf589 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_44_in_parmod608 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_parmod610 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_pm_in_parmod612 = new BitSet(new long[]{0x0000000000040800L});
	public static final BitSet FOLLOW_18_in_parmod616 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_pm_in_parmod618 = new BitSet(new long[]{0x0000000000040800L});
	public static final BitSet FOLLOW_11_in_parmod622 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_pm636 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pm638 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_14_in_pm645 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pm647 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_instruction_in_instructions667 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_18_in_instructions671 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instruction_in_instructions673 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_inssi_in_instruction690 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_inscond_in_instruction696 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_boucle_in_instruction702 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_lecture_in_instruction708 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ecriture_in_instruction714 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_affouappel_in_instruction720 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_51_in_inssi738 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_inssi740 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_25_in_inssi745 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instructions_in_inssi747 = new BitSet(new long[]{0x0010040000000000L});
	public static final BitSet FOLLOW_52_in_inssi752 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instructions_in_inssi756 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_42_in_inssi760 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_28_in_inscond776 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_inscond781 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_inscond784 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instructions_in_inscond786 = new BitSet(new long[]{0x0000008004004000L});
	public static final BitSet FOLLOW_14_in_inscond801 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_inscond807 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_inscond812 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instructions_in_inscond814 = new BitSet(new long[]{0x0000008004004000L});
	public static final BitSet FOLLOW_26_in_inscond835 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instructions_in_inscond838 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_39_in_inscond859 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_53_in_boucle875 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_boucle879 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_boucle884 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instructions_in_boucle886 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_boucle890 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_43_in_lecture903 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_lecture905 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_lecture907 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_14_in_lecture914 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_lecture916 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_11_in_lecture924 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_33_in_ecriture937 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_ecriture939 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_ecriture941 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_14_in_ecriture948 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_ecriture950 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_11_in_ecriture957 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_affouappel970 = new BitSet(new long[]{0x0000000000020402L});
	public static final BitSet FOLLOW_17_in_affouappel978 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_affouappel983 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_effixes_in_affouappel1005 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_effmods_in_affouappel1008 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_effixes1042 = new BitSet(new long[]{0x008040400000AC60L});
	public static final BitSet FOLLOW_expression_in_effixes1045 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_14_in_effixes1050 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_effixes1052 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_11_in_effixes1061 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_effmods1073 = new BitSet(new long[]{0x0000000000000820L});
	public static final BitSet FOLLOW_ident_in_effmods1076 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_14_in_effmods1081 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_effmods1083 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_11_in_effmods1092 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp1_in_expression1106 = new BitSet(new long[]{0x0000800000000002L});
	public static final BitSet FOLLOW_47_in_expression1110 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_exp1_in_expression1114 = new BitSet(new long[]{0x0000800000000002L});
	public static final BitSet FOLLOW_exp2_in_exp11134 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_35_in_exp11137 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_exp2_in_exp11142 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_46_in_exp21161 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_exp2_in_exp21163 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp3_in_exp21171 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp4_in_exp31187 = new BitSet(new long[]{0x0000000001F80002L});
	public static final BitSet FOLLOW_22_in_exp31194 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp4_in_exp31200 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_exp31208 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp4_in_exp31213 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_23_in_exp31221 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp4_in_exp31227 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_24_in_exp31235 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp4_in_exp31240 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_19_in_exp31248 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp4_in_exp31254 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_exp31262 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp4_in_exp31267 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp5_in_exp41289 = new BitSet(new long[]{0x000000000000A002L});
	public static final BitSet FOLLOW_13_in_exp41292 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp5_in_exp41296 = new BitSet(new long[]{0x000000000000A002L});
	public static final BitSet FOLLOW_15_in_exp41302 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp5_in_exp41306 = new BitSet(new long[]{0x000000000000A002L});
	public static final BitSet FOLLOW_primaire_in_exp51326 = new BitSet(new long[]{0x0000000100001002L});
	public static final BitSet FOLLOW_12_in_exp51342 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_primaire_in_exp51348 = new BitSet(new long[]{0x0000000100001002L});
	public static final BitSet FOLLOW_32_in_exp51365 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_primaire_in_exp51370 = new BitSet(new long[]{0x0000000100001002L});
	public static final BitSet FOLLOW_valeur_in_primaire1396 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_primaire1405 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_primaire1415 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_primaire1417 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_primaire1419 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nbentier_in_valeur1433 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_13_in_valeur1441 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_nbentier_in_valeur1443 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_15_in_valeur1451 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_nbentier_in_valeur1453 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_55_in_valeur1461 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_38_in_valeur1469 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_nbentier1499 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_ident1510 = new BitSet(new long[]{0x0000000000000002L});
}
