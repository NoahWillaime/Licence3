package analyse ;

import java_cup.runtime.*;
      
%%
   
%class AnalyseurLexical
%public

%line
%column
    
%type Symbol
%eofval{
        return symbol(CodesLexicaux.EOF) ;
%eofval}

%cup
   
%{
  private Symbol symbol(int type) {
	return new Symbol(type, yyline, yycolumn) ;
  }

  private Symbol symbol(int type, Object value) {
	return new Symbol(type, yyline, yycolumn, value) ;
  }
%}

%state commentaire
cste = [0-9]+
idf = [a-zA-Z]+
typePrimitif = int|char|double|short|bool|boolean|float|long|byte
oper = [\-+*/]
commentaireSlashSlash = [/][/].*
commentaireSlashEtoile = [/][*]
commentaireEtoileSlash = [*][/]

%%
<YYINITIAL>"["          { return symbol(CodesLexicaux.CROCHETOUVERT); }

<YYINITIAL>"]"  		{ return symbol(CodesLexicaux.CROCHETFERMER); }

<YYINITIAL>"("			{ return symbol(CodesLexicaux.PAROUVERT); }

<YYINITIAL>")"			{ return symbol(CodesLexicaux.PARFERMER); }

<YYINITIAL>"="					{ return symbol(CodesLexicaux.EGAL); }

<YYINITIAL>";"                	{ return symbol(CodesLexicaux.POINTVIRGULE); }

<YYINITIAL>"tab"				{ return symbol(CodesLexicaux.TABNAME); }

<YYINITIAL>{oper}				{ return symbol(CodesLexicaux.OP, yytext()); }

<YYINITIAL>{cste}				{ return symbol(CodesLexicaux.CSTE, yytext()); }

<YYINITIAL>{typePrimitif}		{ return symbol(CodesLexicaux.TYPEPRIMITIF, yytext()); }

<YYINITIAL>{idf}			{ return symbol(CodesLexicaux.VAR, yytext()) ; }

<YYINITIAL>{commentaireSlashSlash} {}

<YYINITIAL>{commentaireSlashEtoile}	{yybegin(commentaire);}

<commentaire>{commentaireEtoileSlash} {yybegin(YYINITIAL);}

.                       {}
\n                      {}
\r						{}