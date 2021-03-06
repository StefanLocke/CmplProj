// CMPL L3info 
// Nathalie Girard, Anne Grazon, Veronique Masson
// il convient d'y inserer les appels a {PtGen.pt(k);}
// relancer Antlr apres chaque modification et raffraichir le projet Eclipse le cas echeant

// attention l'analyse est poursuivie apres erreur si l'on supprime la clause rulecatch

grammar projet;

options {
  language=Java; k=1;
 }

@header {           
import java.io.IOException;
import java.io.DataInputStream;
import java.io.FileInputStream;
} 


// partie syntaxique :  description de la grammaire //
// les non-terminaux doivent commencer par une minuscule


@members {

 
// variables globales et methodes utiles a placer ici
  
}
// la directive rulecatch permet d'interrompre l'analyse a la premiere erreur de syntaxe
@rulecatch {
catch (RecognitionException e) {reportError (e) ; throw e ; }}


unite  :   {PtGen.pt(50);} unitprog  EOF
      |    {PtGen.pt(51);} unitmodule  EOF
  ;
  
unitprog
  : 'programme' ident ':'  
     declarations  
     corps {PtGen.pt(253);PtGen.pt(255);System.out.println("succes, arret de la compilation ");}
  ;
  
unitmodule
  : 'module' ident ':' 
     declarations {PtGen.pt(255);System.out.println("succes, arret de la compilation ");}
  ;
  
declarations
  : partiedef? partieref? consts? vars?  decprocs? 
  ;
  
partiedef
  : 'def' ident  {PtGen.pt(52);}  (',' ident {PtGen.pt(52);} )* ptvg
  ;
  
partieref: 'ref'  specif (',' specif)* ptvg
  ;
  
specif  : ident {PtGen.pt(53);} ( 'fixe' '(' type {PtGen.pt(55);} ( ',' type  {PtGen.pt(55);} )* ')' )? 
                 ( 'mod'  '(' type  {PtGen.pt(56);} ( ',' type  {PtGen.pt(56);} )* ')' )? {PtGen.pt(57);}
  ;
  
consts  : 'const' ( ident  '=' valeur {PtGen.pt(25);} ptvg  )+ 
  ;
  
vars  : 'var' ( type ident  {PtGen.pt(26);}  ( ','  ident  {PtGen.pt(26);}  )* ptvg  )+ {PtGen.pt(44);}
  ;
  
type  : 'ent'   {PtGen.pt(28);} 
  |     'bool' 	{PtGen.pt(27);} 
  ;
  
decprocs: {PtGen.pt(252);}(decproc ptvg)+{PtGen.pt(251);}
  ;
  
decproc :  'proc'  ident {PtGen.pt(39);} parfixe? parmod? {PtGen.pt(42);} consts?  {PtGen.pt(45);} vars? corps {PtGen.pt(43);}
  ;
  
ptvg  : ';'
  | 
  ;
  
corps : 'debut' instructions 'fin'
  ;
  
parfixe: 'fixe' '(' pf ( ';' pf)* ')'
  ;
  
pf  : type ident {PtGen.pt(40);} ( ',' ident {PtGen.pt(40);} )*  
  ;

parmod  : 'mod' '(' pm ( ';' pm)* ')'
  ;
  
pm  : type ident {PtGen.pt(41);}  ( ',' ident {PtGen.pt(41);} )*
  ;
  
instructions
  : instruction ( ';' instruction)*
  ;
  
instruction
  : inssi
  | inscond
  | boucle
  | lecture
  | ecriture
  | affouappel
  | 
  ;
  
inssi : 'si' expression {PtGen.pt(1);PtGen.pt(29);}  'alors' instructions  ( 'sinon' {PtGen.pt(31);} instructions)? 'fsi' {PtGen.pt(32);} 
  ;
  
inscond : 'cond' {PtGen.pt(35);}  expression {PtGen.pt(1);PtGen.pt(29);}':' instructions  
          (','  {PtGen.pt(36);}  expression  {PtGen.pt(1);PtGen.pt(29);} ':' instructions  )* 
          ( {PtGen.pt(36);} 'aut'  instructions  |  {PtGen.pt(37);} ) 
          'fcond' {PtGen.pt(38);}
  ;
  
boucle  : 'ttq' {PtGen.pt(33);} expression  {PtGen.pt(1);PtGen.pt(29);} 'faire' instructions {PtGen.pt(34);} 'fait' 
  ;
  
lecture: 'lire' '(' ident  {PtGen.pt(24);} ( ',' ident  {PtGen.pt(24);} )* ')' 
  ;
  
ecriture: 'ecrire' '(' expression {PtGen.pt(23);}  ( ',' expression {PtGen.pt(23);} )* ')'
   ;
  
affouappel: ident  (    ':='  {PtGen.pt(30);} expression {PtGen.pt(22);}
            |  {PtGen.pt(46);} (effixes (effmods)?)?   {PtGen.pt(49);}
           )
  ;
  
effixes : '(' (expression {PtGen.pt(47);} (',' expression {PtGen.pt(47);} )*)? ')'
  ;
  
effmods :'(' (ident {PtGen.pt(48);} (',' ident {PtGen.pt(48);} )*)? ')'
  ; 
  
expression: (exp1) ('ou' {PtGen.pt(1);} exp1 {PtGen.pt(1);PtGen.pt(3);}  )*
  ;
  
exp1  : exp2 ('et' {PtGen.pt(1);}  exp2 {PtGen.pt(1); PtGen.pt(4);} )*
  ;
  
exp2  : 'non' exp2 {PtGen.pt(1);PtGen.pt(5);}
  | exp3  
  ;
  
exp3  : exp4 
  ( '='   {PtGen.pt(2);} exp4 {PtGen.pt(2);PtGen.pt(16);}
  | '<>'  {PtGen.pt(2);} exp4 {PtGen.pt(2);PtGen.pt(17);}
  | '>'   {PtGen.pt(2);} exp4 {PtGen.pt(2);PtGen.pt(18);}
  | '>='  {PtGen.pt(2);} exp4 {PtGen.pt(2);PtGen.pt(19);}
  | '<'   {PtGen.pt(2);} exp4 {PtGen.pt(2);PtGen.pt(20);}
  | '<='  {PtGen.pt(2);} exp4 {PtGen.pt(2);PtGen.pt(21);}
  ) ?
  ;
  
exp4  : exp5
('+' {PtGen.pt(2);} exp5  {PtGen.pt(2);PtGen.pt(14);}
|'-' {PtGen.pt(2);} exp5  {PtGen.pt(2);PtGen.pt(15);}
)*
  ;
  
exp5  : primaire 
        (    '*'  {PtGen.pt(2);}  primaire  {PtGen.pt(2);PtGen.pt(12);}
          | 'div' {PtGen.pt(2);}  primaire  {PtGen.pt(2);PtGen.pt(13);}
        )*
  ;
  
primaire: valeur  {PtGen.pt(6);}
  | ident   {PtGen.pt(11);}
  | '(' expression ')'
  ;
  
valeur  : nbentier {PtGen.pt(7);}
  | '+' nbentier {PtGen.pt(7);}
  | '-' nbentier {PtGen.pt(8);}
  | 'vrai' {PtGen.pt(9);}
  | 'faux' {PtGen.pt(10);}
  ;

// partie lexicale  : cette partie ne doit pas etre modifiee  //
// les unites lexicales de ANTLR doivent commencer par une majuscule
// Attention : ANTLR n'autorise pas certains traitements sur les unites lexicales, 
// il est alors ncessaire de passer par un non-terminal intermediaire 
// exemple : pour l'unit lexicale INT, le non-terminal nbentier a du etre introduit
 
      
nbentier  :   INT { UtilLex.valEnt = Integer.parseInt($INT.text);}; // mise a jour de valEnt

ident : ID  { UtilLex.traiterId($ID.text); } ; // mise a jour de numIdCourant
     // tous les identificateurs seront places dans la table des identificateurs, y compris le nom du programme ou module
     // (NB: la table des symboles n'est pas geree au niveau lexical mais au niveau du compilateur)
        
  
ID  :   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ; 
     
// zone purement lexicale //

INT :   '0'..'9'+ ;
WS  :   (' '|'\t' |'\r')+ {skip();} ; // definition des "blocs d'espaces"
RC  :   ('\n') {UtilLex.incrementeLigne(); skip() ;} ; // definition d'un unique "passage a la ligne" et comptage des numeros de lignes

COMMENT
  :  '\{' (.)* '\}' {skip();}   // toute suite de caracteres entouree d'accolades est un commentaire
  |  '#' ~( '\r' | '\n' )* {skip();}  // tout ce qui suit un caractere diese sur une ligne est un commentaire
  ;

// commentaires sur plusieurs lignes
ML_COMMENT    :   '/*' (options {greedy=false;} : .)* '*/' {$channel=HIDDEN;}
    ;	   