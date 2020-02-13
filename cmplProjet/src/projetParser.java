// $ANTLR 3.5.2 projet.g 2020-02-13 15:50:14
           
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
					pushFollow(FOLLOW_unitprog_in_unite63);
					unitprog();
					state._fsp--;

					match(input,EOF,FOLLOW_EOF_in_unite66); 
					}
					break;
				case 2 :
					// projet.g:37:12: unitmodule EOF
					{
					pushFollow(FOLLOW_unitmodule_in_unite79);
					unitmodule();
					state._fsp--;

					match(input,EOF,FOLLOW_EOF_in_unite82); 
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
			match(input,49,FOLLOW_49_in_unitprog97); 
			pushFollow(FOLLOW_ident_in_unitprog99);
			ident();
			state._fsp--;

			match(input,16,FOLLOW_16_in_unitprog101); 
			pushFollow(FOLLOW_declarations_in_unitprog110);
			declarations();
			state._fsp--;

			pushFollow(FOLLOW_corps_in_unitprog119);
			corps();
			state._fsp--;

			PtGen.pt(255);System.out.println("succes, arret de la compilation ");
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
			match(input,45,FOLLOW_45_in_unitmodule136); 
			pushFollow(FOLLOW_ident_in_unitmodule138);
			ident();
			state._fsp--;

			match(input,16,FOLLOW_16_in_unitmodule140); 
			pushFollow(FOLLOW_declarations_in_unitmodule148);
			declarations();
			state._fsp--;

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
					pushFollow(FOLLOW_partiedef_in_declarations166);
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
					pushFollow(FOLLOW_partieref_in_declarations169);
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
					pushFollow(FOLLOW_consts_in_declarations172);
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
					pushFollow(FOLLOW_vars_in_declarations175);
					vars();
					state._fsp--;

					}
					break;

			}

			// projet.g:52:41: ( decprocs )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==48) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// projet.g:52:41: decprocs
					{
					pushFollow(FOLLOW_decprocs_in_declarations178);
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
			match(input,31,FOLLOW_31_in_partiedef195); 
			pushFollow(FOLLOW_ident_in_partiedef197);
			ident();
			state._fsp--;

			// projet.g:56:18: ( ',' ident )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==14) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// projet.g:56:19: ',' ident
					{
					match(input,14,FOLLOW_14_in_partiedef201); 
					pushFollow(FOLLOW_ident_in_partiedef203);
					ident();
					state._fsp--;

					}
					break;

				default :
					break loop7;
				}
			}

			pushFollow(FOLLOW_ptvg_in_partiedef208);
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
			match(input,50,FOLLOW_50_in_partieref220); 
			pushFollow(FOLLOW_specif_in_partieref223);
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
					match(input,14,FOLLOW_14_in_partieref226); 
					pushFollow(FOLLOW_specif_in_partieref228);
					specif();
					state._fsp--;

					}
					break;

				default :
					break loop8;
				}
			}

			pushFollow(FOLLOW_ptvg_in_partieref232);
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
			pushFollow(FOLLOW_ident_in_specif246);
			ident();
			state._fsp--;

			// projet.g:62:18: ( 'fixe' '(' type ( ',' type )* ')' )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==41) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// projet.g:62:20: 'fixe' '(' type ( ',' type )* ')'
					{
					match(input,41,FOLLOW_41_in_specif251); 
					match(input,10,FOLLOW_10_in_specif253); 
					pushFollow(FOLLOW_type_in_specif255);
					type();
					state._fsp--;

					// projet.g:62:37: ( ',' type )*
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( (LA9_0==14) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// projet.g:62:39: ',' type
							{
							match(input,14,FOLLOW_14_in_specif260); 
							pushFollow(FOLLOW_type_in_specif262);
							type();
							state._fsp--;

							}
							break;

						default :
							break loop9;
						}
					}

					match(input,11,FOLLOW_11_in_specif268); 
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
					match(input,44,FOLLOW_44_in_specif293); 
					match(input,10,FOLLOW_10_in_specif296); 
					pushFollow(FOLLOW_type_in_specif298);
					type();
					state._fsp--;

					// projet.g:63:37: ( ',' type )*
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( (LA11_0==14) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// projet.g:63:39: ',' type
							{
							match(input,14,FOLLOW_14_in_specif303); 
							pushFollow(FOLLOW_type_in_specif305);
							type();
							state._fsp--;

							}
							break;

						default :
							break loop11;
						}
					}

					match(input,11,FOLLOW_11_in_specif311); 
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
	// $ANTLR end "specif"



	// $ANTLR start "consts"
	// projet.g:66:1: consts : 'const' ( ident '=' valeur ptvg )+ ;
	public final void consts() throws RecognitionException {
		try {
			// projet.g:66:9: ( 'const' ( ident '=' valeur ptvg )+ )
			// projet.g:66:11: 'const' ( ident '=' valeur ptvg )+
			{
			match(input,29,FOLLOW_29_in_consts329); 
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
					pushFollow(FOLLOW_ident_in_consts333);
					ident();
					state._fsp--;

					match(input,22,FOLLOW_22_in_consts336); 
					pushFollow(FOLLOW_valeur_in_consts338);
					valeur();
					state._fsp--;

					pushFollow(FOLLOW_ptvg_in_consts341);
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
			match(input,54,FOLLOW_54_in_vars360); 
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
					pushFollow(FOLLOW_type_in_vars364);
					type();
					state._fsp--;

					pushFollow(FOLLOW_ident_in_vars366);
					ident();
					state._fsp--;

					// projet.g:69:29: ( ',' ident )*
					loop14:
					while (true) {
						int alt14=2;
						int LA14_0 = input.LA(1);
						if ( (LA14_0==14) ) {
							alt14=1;
						}

						switch (alt14) {
						case 1 :
							// projet.g:69:31: ',' ident
							{
							match(input,14,FOLLOW_14_in_vars371); 
							pushFollow(FOLLOW_ident_in_vars374);
							ident();
							state._fsp--;

							}
							break;

						default :
							break loop14;
						}
					}

					pushFollow(FOLLOW_ptvg_in_vars380);
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
			// projet.g:
			{
			if ( input.LA(1)==27||input.LA(1)==34 ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
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
			// projet.g:76:11: ( decproc ptvg )+
			int cnt16=0;
			loop16:
			while (true) {
				int alt16=2;
				int LA16_0 = input.LA(1);
				if ( (LA16_0==48) ) {
					alt16=1;
				}

				switch (alt16) {
				case 1 :
					// projet.g:76:12: decproc ptvg
					{
					pushFollow(FOLLOW_decproc_in_decprocs424);
					decproc();
					state._fsp--;

					pushFollow(FOLLOW_ptvg_in_decprocs426);
					ptvg();
					state._fsp--;

					}
					break;

				default :
					if ( cnt16 >= 1 ) break loop16;
					EarlyExitException eee = new EarlyExitException(16, input);
					throw eee;
				}
				cnt16++;
			}

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
			match(input,48,FOLLOW_48_in_decproc442); 
			pushFollow(FOLLOW_ident_in_decproc445);
			ident();
			state._fsp--;

			// projet.g:79:27: ( parfixe )?
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==41) ) {
				alt17=1;
			}
			switch (alt17) {
				case 1 :
					// projet.g:79:27: parfixe
					{
					pushFollow(FOLLOW_parfixe_in_decproc448);
					parfixe();
					state._fsp--;

					}
					break;

			}

			// projet.g:79:36: ( parmod )?
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==44) ) {
				alt18=1;
			}
			switch (alt18) {
				case 1 :
					// projet.g:79:36: parmod
					{
					pushFollow(FOLLOW_parmod_in_decproc451);
					parmod();
					state._fsp--;

					}
					break;

			}

			// projet.g:79:44: ( consts )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==29) ) {
				alt19=1;
			}
			switch (alt19) {
				case 1 :
					// projet.g:79:44: consts
					{
					pushFollow(FOLLOW_consts_in_decproc454);
					consts();
					state._fsp--;

					}
					break;

			}

			// projet.g:79:52: ( vars )?
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==54) ) {
				alt20=1;
			}
			switch (alt20) {
				case 1 :
					// projet.g:79:52: vars
					{
					pushFollow(FOLLOW_vars_in_decproc457);
					vars();
					state._fsp--;

					}
					break;

			}

			pushFollow(FOLLOW_corps_in_decproc460);
			corps();
			state._fsp--;

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
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==18) ) {
				alt21=1;
			}
			else if ( (LA21_0==EOF||LA21_0==ID||LA21_0==27||(LA21_0 >= 29 && LA21_0 <= 30)||LA21_0==34||LA21_0==48||LA21_0==50||LA21_0==54) ) {
				alt21=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				throw nvae;
			}

			switch (alt21) {
				case 1 :
					// projet.g:82:9: ';'
					{
					match(input,18,FOLLOW_18_in_ptvg475); 
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
			match(input,30,FOLLOW_30_in_corps493); 
			pushFollow(FOLLOW_instructions_in_corps495);
			instructions();
			state._fsp--;

			match(input,40,FOLLOW_40_in_corps497); 
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
			match(input,41,FOLLOW_41_in_parfixe509); 
			match(input,10,FOLLOW_10_in_parfixe511); 
			pushFollow(FOLLOW_pf_in_parfixe513);
			pf();
			state._fsp--;

			// projet.g:89:24: ( ';' pf )*
			loop22:
			while (true) {
				int alt22=2;
				int LA22_0 = input.LA(1);
				if ( (LA22_0==18) ) {
					alt22=1;
				}

				switch (alt22) {
				case 1 :
					// projet.g:89:26: ';' pf
					{
					match(input,18,FOLLOW_18_in_parfixe517); 
					pushFollow(FOLLOW_pf_in_parfixe519);
					pf();
					state._fsp--;

					}
					break;

				default :
					break loop22;
				}
			}

			match(input,11,FOLLOW_11_in_parfixe523); 
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
			pushFollow(FOLLOW_type_in_pf537);
			type();
			state._fsp--;

			pushFollow(FOLLOW_ident_in_pf539);
			ident();
			state._fsp--;

			// projet.g:92:19: ( ',' ident )*
			loop23:
			while (true) {
				int alt23=2;
				int LA23_0 = input.LA(1);
				if ( (LA23_0==14) ) {
					alt23=1;
				}

				switch (alt23) {
				case 1 :
					// projet.g:92:21: ',' ident
					{
					match(input,14,FOLLOW_14_in_pf544); 
					pushFollow(FOLLOW_ident_in_pf546);
					ident();
					state._fsp--;

					}
					break;

				default :
					break loop23;
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
			match(input,44,FOLLOW_44_in_parmod564); 
			match(input,10,FOLLOW_10_in_parmod566); 
			pushFollow(FOLLOW_pm_in_parmod568);
			pm();
			state._fsp--;

			// projet.g:95:24: ( ';' pm )*
			loop24:
			while (true) {
				int alt24=2;
				int LA24_0 = input.LA(1);
				if ( (LA24_0==18) ) {
					alt24=1;
				}

				switch (alt24) {
				case 1 :
					// projet.g:95:26: ';' pm
					{
					match(input,18,FOLLOW_18_in_parmod572); 
					pushFollow(FOLLOW_pm_in_parmod574);
					pm();
					state._fsp--;

					}
					break;

				default :
					break loop24;
				}
			}

			match(input,11,FOLLOW_11_in_parmod578); 
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
			pushFollow(FOLLOW_type_in_pm592);
			type();
			state._fsp--;

			pushFollow(FOLLOW_ident_in_pm594);
			ident();
			state._fsp--;

			// projet.g:98:19: ( ',' ident )*
			loop25:
			while (true) {
				int alt25=2;
				int LA25_0 = input.LA(1);
				if ( (LA25_0==14) ) {
					alt25=1;
				}

				switch (alt25) {
				case 1 :
					// projet.g:98:21: ',' ident
					{
					match(input,14,FOLLOW_14_in_pm599); 
					pushFollow(FOLLOW_ident_in_pm601);
					ident();
					state._fsp--;

					}
					break;

				default :
					break loop25;
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
			pushFollow(FOLLOW_instruction_in_instructions620);
			instruction();
			state._fsp--;

			// projet.g:102:17: ( ';' instruction )*
			loop26:
			while (true) {
				int alt26=2;
				int LA26_0 = input.LA(1);
				if ( (LA26_0==18) ) {
					alt26=1;
				}

				switch (alt26) {
				case 1 :
					// projet.g:102:19: ';' instruction
					{
					match(input,18,FOLLOW_18_in_instructions624); 
					pushFollow(FOLLOW_instruction_in_instructions626);
					instruction();
					state._fsp--;

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
	// $ANTLR end "instructions"



	// $ANTLR start "instruction"
	// projet.g:105:1: instruction : ( inssi | inscond | boucle | lecture | ecriture | affouappel | expression );
	public final void instruction() throws RecognitionException {
		try {
			// projet.g:106:3: ( inssi | inscond | boucle | lecture | ecriture | affouappel | expression )
			int alt27=7;
			switch ( input.LA(1) ) {
			case 51:
				{
				alt27=1;
				}
				break;
			case 28:
				{
				alt27=2;
				}
				break;
			case 53:
				{
				alt27=3;
				}
				break;
			case 43:
				{
				alt27=4;
				}
				break;
			case 33:
				{
				alt27=5;
				}
				break;
			case ID:
				{
				alt27=6;
				}
				break;
			case INT:
			case 10:
			case 13:
			case 15:
			case 38:
			case 46:
			case 55:
				{
				alt27=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 27, 0, input);
				throw nvae;
			}
			switch (alt27) {
				case 1 :
					// projet.g:106:5: inssi
					{
					pushFollow(FOLLOW_inssi_in_instruction643);
					inssi();
					state._fsp--;

					}
					break;
				case 2 :
					// projet.g:107:5: inscond
					{
					pushFollow(FOLLOW_inscond_in_instruction649);
					inscond();
					state._fsp--;

					}
					break;
				case 3 :
					// projet.g:108:5: boucle
					{
					pushFollow(FOLLOW_boucle_in_instruction655);
					boucle();
					state._fsp--;

					}
					break;
				case 4 :
					// projet.g:109:5: lecture
					{
					pushFollow(FOLLOW_lecture_in_instruction661);
					lecture();
					state._fsp--;

					}
					break;
				case 5 :
					// projet.g:110:5: ecriture
					{
					pushFollow(FOLLOW_ecriture_in_instruction667);
					ecriture();
					state._fsp--;

					}
					break;
				case 6 :
					// projet.g:111:5: affouappel
					{
					pushFollow(FOLLOW_affouappel_in_instruction673);
					affouappel();
					state._fsp--;

					}
					break;
				case 7 :
					// projet.g:112:5: expression
					{
					pushFollow(FOLLOW_expression_in_instruction679);
					expression();
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
	// $ANTLR end "instruction"



	// $ANTLR start "inssi"
	// projet.g:115:1: inssi : 'si' expression 'alors' instructions ( 'sinon' instructions )? 'fsi' ;
	public final void inssi() throws RecognitionException {
		try {
			// projet.g:115:7: ( 'si' expression 'alors' instructions ( 'sinon' instructions )? 'fsi' )
			// projet.g:115:9: 'si' expression 'alors' instructions ( 'sinon' instructions )? 'fsi'
			{
			match(input,51,FOLLOW_51_in_inssi692); 
			pushFollow(FOLLOW_expression_in_inssi694);
			expression();
			state._fsp--;

			match(input,25,FOLLOW_25_in_inssi696); 
			pushFollow(FOLLOW_instructions_in_inssi698);
			instructions();
			state._fsp--;

			// projet.g:115:46: ( 'sinon' instructions )?
			int alt28=2;
			int LA28_0 = input.LA(1);
			if ( (LA28_0==52) ) {
				alt28=1;
			}
			switch (alt28) {
				case 1 :
					// projet.g:115:47: 'sinon' instructions
					{
					match(input,52,FOLLOW_52_in_inssi701); 
					pushFollow(FOLLOW_instructions_in_inssi704);
					instructions();
					state._fsp--;

					}
					break;

			}

			match(input,42,FOLLOW_42_in_inssi708); 
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
			match(input,28,FOLLOW_28_in_inscond722); 
			pushFollow(FOLLOW_expression_in_inscond725);
			expression();
			state._fsp--;

			match(input,16,FOLLOW_16_in_inscond728); 
			pushFollow(FOLLOW_instructions_in_inscond730);
			instructions();
			state._fsp--;

			// projet.g:119:11: ( ',' expression ':' instructions )*
			loop29:
			while (true) {
				int alt29=2;
				int LA29_0 = input.LA(1);
				if ( (LA29_0==14) ) {
					alt29=1;
				}

				switch (alt29) {
				case 1 :
					// projet.g:119:12: ',' expression ':' instructions
					{
					match(input,14,FOLLOW_14_in_inscond744); 
					pushFollow(FOLLOW_expression_in_inscond747);
					expression();
					state._fsp--;

					match(input,16,FOLLOW_16_in_inscond750); 
					pushFollow(FOLLOW_instructions_in_inscond752);
					instructions();
					state._fsp--;

					}
					break;

				default :
					break loop29;
				}
			}

			// projet.g:120:11: ( 'aut' instructions |)
			int alt30=2;
			int LA30_0 = input.LA(1);
			if ( (LA30_0==26) ) {
				alt30=1;
			}
			else if ( (LA30_0==39) ) {
				alt30=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 30, 0, input);
				throw nvae;
			}

			switch (alt30) {
				case 1 :
					// projet.g:120:12: 'aut' instructions
					{
					match(input,26,FOLLOW_26_in_inscond769); 
					pushFollow(FOLLOW_instructions_in_inscond772);
					instructions();
					state._fsp--;

					}
					break;
				case 2 :
					// projet.g:120:35: 
					{
					}
					break;

			}

			match(input,39,FOLLOW_39_in_inscond790); 
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
			match(input,53,FOLLOW_53_in_boucle805); 
			pushFollow(FOLLOW_expression_in_boucle808);
			expression();
			state._fsp--;

			match(input,36,FOLLOW_36_in_boucle810); 
			pushFollow(FOLLOW_instructions_in_boucle812);
			instructions();
			state._fsp--;

			match(input,37,FOLLOW_37_in_boucle814); 
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
			match(input,43,FOLLOW_43_in_lecture827); 
			match(input,10,FOLLOW_10_in_lecture829); 
			pushFollow(FOLLOW_ident_in_lecture831);
			ident();
			state._fsp--;

			// projet.g:127:28: ( ',' ident )*
			loop31:
			while (true) {
				int alt31=2;
				int LA31_0 = input.LA(1);
				if ( (LA31_0==14) ) {
					alt31=1;
				}

				switch (alt31) {
				case 1 :
					// projet.g:127:30: ',' ident
					{
					match(input,14,FOLLOW_14_in_lecture836); 
					pushFollow(FOLLOW_ident_in_lecture838);
					ident();
					state._fsp--;

					}
					break;

				default :
					break loop31;
				}
			}

			match(input,11,FOLLOW_11_in_lecture844); 
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
			match(input,33,FOLLOW_33_in_ecriture857); 
			match(input,10,FOLLOW_10_in_ecriture859); 
			pushFollow(FOLLOW_expression_in_ecriture861);
			expression();
			state._fsp--;

			// projet.g:130:36: ( ',' expression )*
			loop32:
			while (true) {
				int alt32=2;
				int LA32_0 = input.LA(1);
				if ( (LA32_0==14) ) {
					alt32=1;
				}

				switch (alt32) {
				case 1 :
					// projet.g:130:38: ',' expression
					{
					match(input,14,FOLLOW_14_in_ecriture866); 
					pushFollow(FOLLOW_expression_in_ecriture868);
					expression();
					state._fsp--;

					}
					break;

				default :
					break loop32;
				}
			}

			match(input,11,FOLLOW_11_in_ecriture874); 
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
			// projet.g:134:3: ( ident ( ':=' expression | ( effixes ( effmods )? )? ) )
			// projet.g:134:5: ident ( ':=' expression | ( effixes ( effmods )? )? )
			{
			pushFollow(FOLLOW_ident_in_affouappel890);
			ident();
			state._fsp--;

			// projet.g:134:12: ( ':=' expression | ( effixes ( effmods )? )? )
			int alt35=2;
			int LA35_0 = input.LA(1);
			if ( (LA35_0==17) ) {
				alt35=1;
			}
			else if ( (LA35_0==10||LA35_0==14||LA35_0==18||LA35_0==26||LA35_0==37||(LA35_0 >= 39 && LA35_0 <= 40)||LA35_0==42||LA35_0==52) ) {
				alt35=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 35, 0, input);
				throw nvae;
			}

			switch (alt35) {
				case 1 :
					// projet.g:134:17: ':=' expression
					{
					match(input,17,FOLLOW_17_in_affouappel898); 
					pushFollow(FOLLOW_expression_in_affouappel900);
					expression();
					state._fsp--;

					}
					break;
				case 2 :
					// projet.g:135:17: ( effixes ( effmods )? )?
					{
					// projet.g:135:17: ( effixes ( effmods )? )?
					int alt34=2;
					int LA34_0 = input.LA(1);
					if ( (LA34_0==10) ) {
						alt34=1;
					}
					switch (alt34) {
						case 1 :
							// projet.g:135:18: effixes ( effmods )?
							{
							pushFollow(FOLLOW_effixes_in_affouappel920);
							effixes();
							state._fsp--;

							// projet.g:135:26: ( effmods )?
							int alt33=2;
							int LA33_0 = input.LA(1);
							if ( (LA33_0==10) ) {
								alt33=1;
							}
							switch (alt33) {
								case 1 :
									// projet.g:135:27: effmods
									{
									pushFollow(FOLLOW_effmods_in_affouappel923);
									effmods();
									state._fsp--;

									}
									break;

							}

							}
							break;

					}

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
	// projet.g:139:1: effixes : '(' ( expression ( ',' expression )* )? ')' ;
	public final void effixes() throws RecognitionException {
		try {
			// projet.g:139:9: ( '(' ( expression ( ',' expression )* )? ')' )
			// projet.g:139:11: '(' ( expression ( ',' expression )* )? ')'
			{
			match(input,10,FOLLOW_10_in_effixes955); 
			// projet.g:139:15: ( expression ( ',' expression )* )?
			int alt37=2;
			int LA37_0 = input.LA(1);
			if ( ((LA37_0 >= ID && LA37_0 <= INT)||LA37_0==10||LA37_0==13||LA37_0==15||LA37_0==38||LA37_0==46||LA37_0==55) ) {
				alt37=1;
			}
			switch (alt37) {
				case 1 :
					// projet.g:139:16: expression ( ',' expression )*
					{
					pushFollow(FOLLOW_expression_in_effixes958);
					expression();
					state._fsp--;

					// projet.g:139:28: ( ',' expression )*
					loop36:
					while (true) {
						int alt36=2;
						int LA36_0 = input.LA(1);
						if ( (LA36_0==14) ) {
							alt36=1;
						}

						switch (alt36) {
						case 1 :
							// projet.g:139:29: ',' expression
							{
							match(input,14,FOLLOW_14_in_effixes962); 
							pushFollow(FOLLOW_expression_in_effixes964);
							expression();
							state._fsp--;

							}
							break;

						default :
							break loop36;
						}
					}

					}
					break;

			}

			match(input,11,FOLLOW_11_in_effixes972); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "effixes"



	// $ANTLR start "effmods"
	// projet.g:142:1: effmods : '(' ( ident ( ',' ident )* )? ')' ;
	public final void effmods() throws RecognitionException {
		try {
			// projet.g:142:9: ( '(' ( ident ( ',' ident )* )? ')' )
			// projet.g:142:10: '(' ( ident ( ',' ident )* )? ')'
			{
			match(input,10,FOLLOW_10_in_effmods984); 
			// projet.g:142:14: ( ident ( ',' ident )* )?
			int alt39=2;
			int LA39_0 = input.LA(1);
			if ( (LA39_0==ID) ) {
				alt39=1;
			}
			switch (alt39) {
				case 1 :
					// projet.g:142:15: ident ( ',' ident )*
					{
					pushFollow(FOLLOW_ident_in_effmods987);
					ident();
					state._fsp--;

					// projet.g:142:22: ( ',' ident )*
					loop38:
					while (true) {
						int alt38=2;
						int LA38_0 = input.LA(1);
						if ( (LA38_0==14) ) {
							alt38=1;
						}

						switch (alt38) {
						case 1 :
							// projet.g:142:23: ',' ident
							{
							match(input,14,FOLLOW_14_in_effmods991); 
							pushFollow(FOLLOW_ident_in_effmods993);
							ident();
							state._fsp--;

							}
							break;

						default :
							break loop38;
						}
					}

					}
					break;

			}

			match(input,11,FOLLOW_11_in_effmods1001); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "effmods"



	// $ANTLR start "expression"
	// projet.g:145:1: expression : ( exp1 ) ( 'ou' exp1 )* ;
	public final void expression() throws RecognitionException {
		try {
			// projet.g:145:11: ( ( exp1 ) ( 'ou' exp1 )* )
			// projet.g:145:13: ( exp1 ) ( 'ou' exp1 )*
			{
			// projet.g:145:13: ( exp1 )
			// projet.g:145:14: exp1
			{
			pushFollow(FOLLOW_exp1_in_expression1015);
			exp1();
			state._fsp--;

			}

			// projet.g:145:20: ( 'ou' exp1 )*
			loop40:
			while (true) {
				int alt40=2;
				int LA40_0 = input.LA(1);
				if ( (LA40_0==47) ) {
					alt40=1;
				}

				switch (alt40) {
				case 1 :
					// projet.g:145:21: 'ou' exp1
					{
					match(input,47,FOLLOW_47_in_expression1019); 
					PtGen.pt(1);
					pushFollow(FOLLOW_exp1_in_expression1023);
					exp1();
					state._fsp--;

					PtGen.pt(1);PtGen.pt(3);
					}
					break;

				default :
					break loop40;
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
	// projet.g:148:1: exp1 : exp2 ( 'et' exp2 )* ;
	public final void exp1() throws RecognitionException {
		try {
			// projet.g:148:7: ( exp2 ( 'et' exp2 )* )
			// projet.g:148:9: exp2 ( 'et' exp2 )*
			{
			pushFollow(FOLLOW_exp2_in_exp11043);
			exp2();
			state._fsp--;

			// projet.g:148:14: ( 'et' exp2 )*
			loop41:
			while (true) {
				int alt41=2;
				int LA41_0 = input.LA(1);
				if ( (LA41_0==35) ) {
					alt41=1;
				}

				switch (alt41) {
				case 1 :
					// projet.g:148:15: 'et' exp2
					{
					match(input,35,FOLLOW_35_in_exp11046); 
					PtGen.pt(1);
					pushFollow(FOLLOW_exp2_in_exp11051);
					exp2();
					state._fsp--;

					PtGen.pt(1); PtGen.pt(4);
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
	// $ANTLR end "exp1"



	// $ANTLR start "exp2"
	// projet.g:151:1: exp2 : ( 'non' exp2 | exp3 );
	public final void exp2() throws RecognitionException {
		try {
			// projet.g:151:7: ( 'non' exp2 | exp3 )
			int alt42=2;
			int LA42_0 = input.LA(1);
			if ( (LA42_0==46) ) {
				alt42=1;
			}
			else if ( ((LA42_0 >= ID && LA42_0 <= INT)||LA42_0==10||LA42_0==13||LA42_0==15||LA42_0==38||LA42_0==55) ) {
				alt42=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 42, 0, input);
				throw nvae;
			}

			switch (alt42) {
				case 1 :
					// projet.g:151:9: 'non' exp2
					{
					match(input,46,FOLLOW_46_in_exp21070); 
					pushFollow(FOLLOW_exp2_in_exp21072);
					exp2();
					state._fsp--;

					PtGen.pt(1);PtGen.pt(5);
					}
					break;
				case 2 :
					// projet.g:152:5: exp3
					{
					pushFollow(FOLLOW_exp3_in_exp21080);
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
	// projet.g:155:1: exp3 : exp4 ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )? ;
	public final void exp3() throws RecognitionException {
		try {
			// projet.g:155:7: ( exp4 ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )? )
			// projet.g:155:9: exp4 ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )?
			{
			pushFollow(FOLLOW_exp4_in_exp31096);
			exp4();
			state._fsp--;

			// projet.g:156:3: ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )?
			int alt43=7;
			switch ( input.LA(1) ) {
				case 22:
					{
					alt43=1;
					}
					break;
				case 21:
					{
					alt43=2;
					}
					break;
				case 23:
					{
					alt43=3;
					}
					break;
				case 24:
					{
					alt43=4;
					}
					break;
				case 19:
					{
					alt43=5;
					}
					break;
				case 20:
					{
					alt43=6;
					}
					break;
			}
			switch (alt43) {
				case 1 :
					// projet.g:156:5: '=' exp4
					{
					match(input,22,FOLLOW_22_in_exp31103); 
					PtGen.pt(2);
					pushFollow(FOLLOW_exp4_in_exp31109);
					exp4();
					state._fsp--;

					PtGen.pt(2);PtGen.pt(16);
					}
					break;
				case 2 :
					// projet.g:157:5: '<>' exp4
					{
					match(input,21,FOLLOW_21_in_exp31117); 
					PtGen.pt(2);
					pushFollow(FOLLOW_exp4_in_exp31122);
					exp4();
					state._fsp--;

					PtGen.pt(2);PtGen.pt(17);
					}
					break;
				case 3 :
					// projet.g:158:5: '>' exp4
					{
					match(input,23,FOLLOW_23_in_exp31130); 
					PtGen.pt(2);
					pushFollow(FOLLOW_exp4_in_exp31136);
					exp4();
					state._fsp--;

					PtGen.pt(2);PtGen.pt(18);
					}
					break;
				case 4 :
					// projet.g:159:5: '>=' exp4
					{
					match(input,24,FOLLOW_24_in_exp31144); 
					PtGen.pt(2);
					pushFollow(FOLLOW_exp4_in_exp31149);
					exp4();
					state._fsp--;

					PtGen.pt(2);PtGen.pt(19);
					}
					break;
				case 5 :
					// projet.g:160:5: '<' exp4
					{
					match(input,19,FOLLOW_19_in_exp31157); 
					PtGen.pt(2);
					pushFollow(FOLLOW_exp4_in_exp31163);
					exp4();
					state._fsp--;

					PtGen.pt(2);PtGen.pt(20);
					}
					break;
				case 6 :
					// projet.g:161:5: '<=' exp4
					{
					match(input,20,FOLLOW_20_in_exp31171); 
					PtGen.pt(2);
					pushFollow(FOLLOW_exp4_in_exp31176);
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
	// projet.g:165:1: exp4 : exp5 ( '+' exp5 | '-' exp5 )* ;
	public final void exp4() throws RecognitionException {
		try {
			// projet.g:165:7: ( exp5 ( '+' exp5 | '-' exp5 )* )
			// projet.g:165:9: exp5 ( '+' exp5 | '-' exp5 )*
			{
			pushFollow(FOLLOW_exp5_in_exp41198);
			exp5();
			state._fsp--;

			// projet.g:166:2: ( '+' exp5 | '-' exp5 )*
			loop44:
			while (true) {
				int alt44=3;
				int LA44_0 = input.LA(1);
				if ( (LA44_0==13) ) {
					alt44=1;
				}
				else if ( (LA44_0==15) ) {
					alt44=2;
				}

				switch (alt44) {
				case 1 :
					// projet.g:166:2: '+' exp5
					{
					match(input,13,FOLLOW_13_in_exp41201); 
					PtGen.pt(2);
					pushFollow(FOLLOW_exp5_in_exp41205);
					exp5();
					state._fsp--;

					PtGen.pt(2);PtGen.pt(14);
					}
					break;
				case 2 :
					// projet.g:167:2: '-' exp5
					{
					match(input,15,FOLLOW_15_in_exp41211); 
					PtGen.pt(2);
					pushFollow(FOLLOW_exp5_in_exp41215);
					exp5();
					state._fsp--;

					PtGen.pt(2);PtGen.pt(15);
					}
					break;

				default :
					break loop44;
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
	// projet.g:171:1: exp5 : primaire ( '*' primaire | 'div' primaire )* ;
	public final void exp5() throws RecognitionException {
		try {
			// projet.g:171:7: ( primaire ( '*' primaire | 'div' primaire )* )
			// projet.g:171:9: primaire ( '*' primaire | 'div' primaire )*
			{
			pushFollow(FOLLOW_primaire_in_exp51235);
			primaire();
			state._fsp--;

			// projet.g:172:9: ( '*' primaire | 'div' primaire )*
			loop45:
			while (true) {
				int alt45=3;
				int LA45_0 = input.LA(1);
				if ( (LA45_0==12) ) {
					alt45=1;
				}
				else if ( (LA45_0==32) ) {
					alt45=2;
				}

				switch (alt45) {
				case 1 :
					// projet.g:172:14: '*' primaire
					{
					match(input,12,FOLLOW_12_in_exp51251); 
					PtGen.pt(2);
					pushFollow(FOLLOW_primaire_in_exp51257);
					primaire();
					state._fsp--;

					PtGen.pt(2);PtGen.pt(12);
					}
					break;
				case 2 :
					// projet.g:173:13: 'div' primaire
					{
					match(input,32,FOLLOW_32_in_exp51274); 
					PtGen.pt(2);
					pushFollow(FOLLOW_primaire_in_exp51279);
					primaire();
					state._fsp--;

					PtGen.pt(2);PtGen.pt(13);
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
	// $ANTLR end "exp5"



	// $ANTLR start "primaire"
	// projet.g:177:1: primaire : ( valeur | ident | '(' expression ')' );
	public final void primaire() throws RecognitionException {
		try {
			// projet.g:177:9: ( valeur | ident | '(' expression ')' )
			int alt46=3;
			switch ( input.LA(1) ) {
			case INT:
			case 13:
			case 15:
			case 38:
			case 55:
				{
				alt46=1;
				}
				break;
			case ID:
				{
				alt46=2;
				}
				break;
			case 10:
				{
				alt46=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 46, 0, input);
				throw nvae;
			}
			switch (alt46) {
				case 1 :
					// projet.g:177:11: valeur
					{
					pushFollow(FOLLOW_valeur_in_primaire1305);
					valeur();
					state._fsp--;

					PtGen.pt(6);
					}
					break;
				case 2 :
					// projet.g:178:5: ident
					{
					pushFollow(FOLLOW_ident_in_primaire1314);
					ident();
					state._fsp--;

					PtGen.pt(11);
					}
					break;
				case 3 :
					// projet.g:179:5: '(' expression ')'
					{
					match(input,10,FOLLOW_10_in_primaire1324); 
					pushFollow(FOLLOW_expression_in_primaire1326);
					expression();
					state._fsp--;

					match(input,11,FOLLOW_11_in_primaire1328); 
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
	// projet.g:182:1: valeur : ( nbentier | '+' nbentier | '-' nbentier | 'vrai' | 'faux' );
	public final void valeur() throws RecognitionException {
		try {
			// projet.g:182:9: ( nbentier | '+' nbentier | '-' nbentier | 'vrai' | 'faux' )
			int alt47=5;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt47=1;
				}
				break;
			case 13:
				{
				alt47=2;
				}
				break;
			case 15:
				{
				alt47=3;
				}
				break;
			case 55:
				{
				alt47=4;
				}
				break;
			case 38:
				{
				alt47=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 47, 0, input);
				throw nvae;
			}
			switch (alt47) {
				case 1 :
					// projet.g:182:11: nbentier
					{
					pushFollow(FOLLOW_nbentier_in_valeur1342);
					nbentier();
					state._fsp--;

					PtGen.pt(7);
					}
					break;
				case 2 :
					// projet.g:183:5: '+' nbentier
					{
					match(input,13,FOLLOW_13_in_valeur1350); 
					pushFollow(FOLLOW_nbentier_in_valeur1352);
					nbentier();
					state._fsp--;

					PtGen.pt(7);
					}
					break;
				case 3 :
					// projet.g:184:5: '-' nbentier
					{
					match(input,15,FOLLOW_15_in_valeur1360); 
					pushFollow(FOLLOW_nbentier_in_valeur1362);
					nbentier();
					state._fsp--;

					PtGen.pt(8);
					}
					break;
				case 4 :
					// projet.g:185:5: 'vrai'
					{
					match(input,55,FOLLOW_55_in_valeur1370); 
					PtGen.pt(9);
					}
					break;
				case 5 :
					// projet.g:186:5: 'faux'
					{
					match(input,38,FOLLOW_38_in_valeur1378); 
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
	// projet.g:196:1: nbentier : INT ;
	public final void nbentier() throws RecognitionException {
		Token INT1=null;

		try {
			// projet.g:196:11: ( INT )
			// projet.g:196:15: INT
			{
			INT1=(Token)match(input,INT,FOLLOW_INT_in_nbentier1408); 
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
	// projet.g:198:1: ident : ID ;
	public final void ident() throws RecognitionException {
		Token ID2=null;

		try {
			// projet.g:198:7: ( ID )
			// projet.g:198:9: ID
			{
			ID2=(Token)match(input,ID,FOLLOW_ID_in_ident1419); 
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



	public static final BitSet FOLLOW_unitprog_in_unite63 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_unite66 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unitmodule_in_unite79 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_unite82 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_49_in_unitprog97 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_unitprog99 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_unitprog101 = new BitSet(new long[]{0x00450000E0000000L});
	public static final BitSet FOLLOW_declarations_in_unitprog110 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_corps_in_unitprog119 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_45_in_unitmodule136 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_unitmodule138 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_unitmodule140 = new BitSet(new long[]{0x00450000A0000000L});
	public static final BitSet FOLLOW_declarations_in_unitmodule148 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_partiedef_in_declarations166 = new BitSet(new long[]{0x0045000020000002L});
	public static final BitSet FOLLOW_partieref_in_declarations169 = new BitSet(new long[]{0x0041000020000002L});
	public static final BitSet FOLLOW_consts_in_declarations172 = new BitSet(new long[]{0x0041000000000002L});
	public static final BitSet FOLLOW_vars_in_declarations175 = new BitSet(new long[]{0x0001000000000002L});
	public static final BitSet FOLLOW_decprocs_in_declarations178 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_partiedef195 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_partiedef197 = new BitSet(new long[]{0x0000000000044000L});
	public static final BitSet FOLLOW_14_in_partiedef201 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_partiedef203 = new BitSet(new long[]{0x0000000000044000L});
	public static final BitSet FOLLOW_ptvg_in_partiedef208 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_50_in_partieref220 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_specif_in_partieref223 = new BitSet(new long[]{0x0000000000044000L});
	public static final BitSet FOLLOW_14_in_partieref226 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_specif_in_partieref228 = new BitSet(new long[]{0x0000000000044000L});
	public static final BitSet FOLLOW_ptvg_in_partieref232 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_specif246 = new BitSet(new long[]{0x0000120000000002L});
	public static final BitSet FOLLOW_41_in_specif251 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_specif253 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_type_in_specif255 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_14_in_specif260 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_type_in_specif262 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_11_in_specif268 = new BitSet(new long[]{0x0000100000000002L});
	public static final BitSet FOLLOW_44_in_specif293 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_specif296 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_type_in_specif298 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_14_in_specif303 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_type_in_specif305 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_11_in_specif311 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_consts329 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_consts333 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_consts336 = new BitSet(new long[]{0x008000400000A040L});
	public static final BitSet FOLLOW_valeur_in_consts338 = new BitSet(new long[]{0x0000000000040020L});
	public static final BitSet FOLLOW_ptvg_in_consts341 = new BitSet(new long[]{0x0000000000000022L});
	public static final BitSet FOLLOW_54_in_vars360 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_type_in_vars364 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_vars366 = new BitSet(new long[]{0x0000000408044000L});
	public static final BitSet FOLLOW_14_in_vars371 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_vars374 = new BitSet(new long[]{0x0000000408044000L});
	public static final BitSet FOLLOW_ptvg_in_vars380 = new BitSet(new long[]{0x0000000408000002L});
	public static final BitSet FOLLOW_decproc_in_decprocs424 = new BitSet(new long[]{0x0001000000040000L});
	public static final BitSet FOLLOW_ptvg_in_decprocs426 = new BitSet(new long[]{0x0001000000000002L});
	public static final BitSet FOLLOW_48_in_decproc442 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_decproc445 = new BitSet(new long[]{0x0040120060000000L});
	public static final BitSet FOLLOW_parfixe_in_decproc448 = new BitSet(new long[]{0x0040100060000000L});
	public static final BitSet FOLLOW_parmod_in_decproc451 = new BitSet(new long[]{0x0040000060000000L});
	public static final BitSet FOLLOW_consts_in_decproc454 = new BitSet(new long[]{0x0040000040000000L});
	public static final BitSet FOLLOW_vars_in_decproc457 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_corps_in_decproc460 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_ptvg475 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_corps493 = new BitSet(new long[]{0x00A848421000A460L});
	public static final BitSet FOLLOW_instructions_in_corps495 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_40_in_corps497 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_41_in_parfixe509 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_parfixe511 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_pf_in_parfixe513 = new BitSet(new long[]{0x0000000000040800L});
	public static final BitSet FOLLOW_18_in_parfixe517 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_pf_in_parfixe519 = new BitSet(new long[]{0x0000000000040800L});
	public static final BitSet FOLLOW_11_in_parfixe523 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_pf537 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pf539 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_14_in_pf544 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pf546 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_44_in_parmod564 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_parmod566 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_pm_in_parmod568 = new BitSet(new long[]{0x0000000000040800L});
	public static final BitSet FOLLOW_18_in_parmod572 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_pm_in_parmod574 = new BitSet(new long[]{0x0000000000040800L});
	public static final BitSet FOLLOW_11_in_parmod578 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_pm592 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pm594 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_14_in_pm599 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pm601 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_instruction_in_instructions620 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_18_in_instructions624 = new BitSet(new long[]{0x00A848421000A460L});
	public static final BitSet FOLLOW_instruction_in_instructions626 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_inssi_in_instruction643 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_inscond_in_instruction649 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_boucle_in_instruction655 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_lecture_in_instruction661 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ecriture_in_instruction667 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_affouappel_in_instruction673 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_instruction679 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_51_in_inssi692 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_inssi694 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_25_in_inssi696 = new BitSet(new long[]{0x00A848421000A460L});
	public static final BitSet FOLLOW_instructions_in_inssi698 = new BitSet(new long[]{0x0010040000000000L});
	public static final BitSet FOLLOW_52_in_inssi701 = new BitSet(new long[]{0x00A848421000A460L});
	public static final BitSet FOLLOW_instructions_in_inssi704 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_42_in_inssi708 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_28_in_inscond722 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_inscond725 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_inscond728 = new BitSet(new long[]{0x00A848421000A460L});
	public static final BitSet FOLLOW_instructions_in_inscond730 = new BitSet(new long[]{0x0000008004004000L});
	public static final BitSet FOLLOW_14_in_inscond744 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_inscond747 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_inscond750 = new BitSet(new long[]{0x00A848421000A460L});
	public static final BitSet FOLLOW_instructions_in_inscond752 = new BitSet(new long[]{0x0000008004004000L});
	public static final BitSet FOLLOW_26_in_inscond769 = new BitSet(new long[]{0x00A848421000A460L});
	public static final BitSet FOLLOW_instructions_in_inscond772 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_39_in_inscond790 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_53_in_boucle805 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_boucle808 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_boucle810 = new BitSet(new long[]{0x00A848421000A460L});
	public static final BitSet FOLLOW_instructions_in_boucle812 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_boucle814 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_43_in_lecture827 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_lecture829 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_lecture831 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_14_in_lecture836 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_lecture838 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_11_in_lecture844 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_33_in_ecriture857 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_ecriture859 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_ecriture861 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_14_in_ecriture866 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_ecriture868 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_11_in_ecriture874 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_affouappel890 = new BitSet(new long[]{0x0000000000020402L});
	public static final BitSet FOLLOW_17_in_affouappel898 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_affouappel900 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_effixes_in_affouappel920 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_effmods_in_affouappel923 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_effixes955 = new BitSet(new long[]{0x008040400000AC60L});
	public static final BitSet FOLLOW_expression_in_effixes958 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_14_in_effixes962 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_effixes964 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_11_in_effixes972 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_effmods984 = new BitSet(new long[]{0x0000000000000820L});
	public static final BitSet FOLLOW_ident_in_effmods987 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_14_in_effmods991 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_effmods993 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_11_in_effmods1001 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp1_in_expression1015 = new BitSet(new long[]{0x0000800000000002L});
	public static final BitSet FOLLOW_47_in_expression1019 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_exp1_in_expression1023 = new BitSet(new long[]{0x0000800000000002L});
	public static final BitSet FOLLOW_exp2_in_exp11043 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_35_in_exp11046 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_exp2_in_exp11051 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_46_in_exp21070 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_exp2_in_exp21072 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp3_in_exp21080 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp4_in_exp31096 = new BitSet(new long[]{0x0000000001F80002L});
	public static final BitSet FOLLOW_22_in_exp31103 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp4_in_exp31109 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_exp31117 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp4_in_exp31122 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_23_in_exp31130 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp4_in_exp31136 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_24_in_exp31144 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp4_in_exp31149 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_19_in_exp31157 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp4_in_exp31163 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_exp31171 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp4_in_exp31176 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp5_in_exp41198 = new BitSet(new long[]{0x000000000000A002L});
	public static final BitSet FOLLOW_13_in_exp41201 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp5_in_exp41205 = new BitSet(new long[]{0x000000000000A002L});
	public static final BitSet FOLLOW_15_in_exp41211 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp5_in_exp41215 = new BitSet(new long[]{0x000000000000A002L});
	public static final BitSet FOLLOW_primaire_in_exp51235 = new BitSet(new long[]{0x0000000100001002L});
	public static final BitSet FOLLOW_12_in_exp51251 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_primaire_in_exp51257 = new BitSet(new long[]{0x0000000100001002L});
	public static final BitSet FOLLOW_32_in_exp51274 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_primaire_in_exp51279 = new BitSet(new long[]{0x0000000100001002L});
	public static final BitSet FOLLOW_valeur_in_primaire1305 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_primaire1314 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_primaire1324 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_primaire1326 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_primaire1328 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nbentier_in_valeur1342 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_13_in_valeur1350 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_nbentier_in_valeur1352 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_15_in_valeur1360 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_nbentier_in_valeur1362 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_55_in_valeur1370 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_38_in_valeur1378 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_nbentier1408 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_ident1419 = new BitSet(new long[]{0x0000000000000002L});
}
