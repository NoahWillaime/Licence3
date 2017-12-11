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

var = [0-9]+
idf = [a-zA-Z]+
typePrimitif = int|char|double|short|bool|boolean|float|long|byte
oper = [\-+*/]

%%
"["          { return symbol(CodesLexicaux.CROCHETOUVERT); }

"]"  		{ return symbol(CodesLexicaux.CROCHETFERMER); }

"("			{ return symbol(CodesLexicaux.PAROUVERT); }

")"			{ return symbol(CodesLexicaux.PARFERMER); }

"="					{ return symbol(CodesLexicaux.EGAL); }

";"                	{ return symbol(CodesLexicaux.POINTVIRGULE); }

"tab"				{ return symbol(CodesLexicaux.TABNAME); }

{oper}				{ return symbol(CodesLexicaux.OP, yytext()); }

{var}				{ return symbol(CodesLexicaux.VAR, yytext()); }

{typePrimitif}		{ return symbol(CodesLexicaux.TYPEPRIMITIF, yytext()); }

{idf}			{ return symbol(CodesLexicaux.IDF, yytext()) ; }

.                       {}
\n                      {}
\r						{}