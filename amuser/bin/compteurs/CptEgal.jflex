package compteurs ;
%%
%{
private int nb;
private int nb_c;
private int nb_t;
public int nbOccurrences() {
	return nb;
}
public int nbNbCases() {
	return nb_c;
}
public int nbTab() {
	return nb_t;
}
%}
%init{
nb = 0;
nb_c = 0;
nb_t = 0;
%init}
%public
%class CptEgal
%function analyser
%type String
lettre = [a-zA-Z]
chiffre = [0-9]
motcle = if|for|while|switch
type = int|char|float|double|String
%%
"=" { nb++ ;}
"nbCases" {}
"tab" {}
{type} {return ("Type : "+yytext());}
{motcle} {return ("Mot cle : "+yytext());}
{lettre}*{lettre} {return ("Identificateur : "+yytext());}
{chiffre}*{chiffre} {return ("Constante entiere : "+yytext());}
\n {}
\r {}
. {}
