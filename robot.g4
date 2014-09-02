grammar robot;
options {
	language = Java;
}

fragment LETTER  :	('a'..'z'|'A'..'Z'|'_');
fragment DIGIT :	'0'..'9'+;
WS : [ \t\n\r]+ -> channel(HIDDEN);
CONST	:	'const';
SIGNED	:	'signed';
UNSIGNED:	'unsigned';
CELL	:	'cell';
MATRIX	:	'matrix';
TOP	:	'top';
RIGHT	:	'right';
DOWN	:	'down';
LEFT	:	'left';
NTOP	:	'ntop';
NRIGHT	:	'nright';
NDOWN	:	'ndown';
NLEFT	:	'nleft';
TESTREP	:	'testrep';
TESTONCE:	'testonce';
CALL	:	'call';
START	:	'start';
FUNC	:	'func';
IDENT : (LETTER ) (LETTER | DIGIT)* ;
UNUMBER	:	DIGIT'u';
SNUMBER	:	('-')?DIGIT;
SEMICOLON:	';';
MUL :'*';
DIV :'/';
ADD :'+';
SUB :'-';
MOD :'%';
MORE:'>';
LESS:'<';
EQUALLY:'=';
ELSE:'else';

prog	:	(stmts|function)* START block;
function:	FUNC IDENT args block;
stmt	:	(declaration|assignment|condition|cycle|access|print|drawing) SEMICOLON;
stmts	:	stmt+;
block 	:	'(' stmts ')';
args	:	'('(arg)* ')';
arg     :	(type=(UNSIGNED|SIGNED)IDENT);
declaration
	:	CONST UNSIGNED IDENT '<-' expression 						#ConstAssignUnsigned
	|	CONST SIGNED IDENT '<-' expression							#ConstAssignSigned
	|	UNSIGNED IDENT												#AssignUnsignedId
	|	UNSIGNED IDENT'<-' expression								#AssignUnsigned				
	|	SIGNED IDENT												#AssignSignedId
	|	SIGNED IDENT'<-' expression									#AssignSigned
	|	MATRIX UNSIGNED IDENT '('expression','expression')'			#DeclMatUnsigned
	|	MATRIX SIGNED IDENT	'('expression','expression')'			#DeclMatSigned
	|	MATRIX CELL IDENT '('expression','expression')'				#World
	;
assignment
	:	IDENT '<-' expression										#AssignId
	|	IDENT '('expression','expression')' '<-' expression			#AssignMatrix
	|	IDENT '('expression','expression')' '<-' '('u=(TOP|NTOP)','r=(RIGHT|NRIGHT)','d=(DOWN|NDOWN)','l=(LEFT|NLEFT)')' #AssignWorld
	;
expression
	:	expression op=('*'|'/'|'%') expression				#mult					
	|	expression op=('<' | '>' | '=')expression 			#bool	
	|	expression op=('+' | '-') expression				#AddSub
	|	IDENT												#Id
	| 	UNUMBER												#UnsignedNumber
	|	SNUMBER												#SignedNumber
	|	IDENT '('expression','expression')'					#IdMatrix
	|	IDENT '('expression','expression')''['expression']' #IdWorld
	| 	'(' expression ')'									#Parens
		;
access	:	CALL IDENT '('(expression)* ')' ;
condition	:	TESTREP '('expression')' block;
cycle	:	TESTONCE '('expression')' block;
print	: 'put' IDENT '('expression','expression')';
drawing	:	'mapping' IDENT '('expression','expression')';
