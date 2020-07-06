grammar gramatika;

sequence: command (';' command)* (';')?;
command: assignment | if_condition | while_loop | comparison | operation | SKIP_RULE;
assignment: NAME ':=' (operation | boolean_value);
operation: '(' operation ')' | <assoc=right> operation MULT operation | <assoc=right> operation SYMBOL operation | value;
value: NAME | NUMBER;
if_condition: 'if' (comparison | boolean_value | and) 'then' (('(' sequence ')') | command ) 'else' (('(' sequence ')') | command ) ('fi' | 'endif')?;
while_loop: 'while' (boolean_value | comparison | and) 'do' ('begin')? (('(' sequence ')') | command ) ('od' | 'endwhile')?;
boolean_value: (NEG ('(')?)* NAME ')'? | TRUE ')'? | FALSE ')'? | (NEG ('(')?)* '(' NAME ')';
comparison: (NEG ('(')?)* operation COMP_SYMBOL operation | '('(operation COMP_SYMBOL operation)')';
//and: NEG? '('?((boolean_value | comparison) (AND (boolean_value | comparison))+')'?);
//and: (NEG ('(')?)* '('?((boolean_value | comparison) (AND (boolean_value | comparison))+')'?);
and: (NEG ('(')?)* '(' and ')' | <assoc=right> and AND and | boolean_value | comparison ;

TRUE: 'true';
FALSE: 'false';
SKIP_RULE: 'skip';
SYMBOL: '+' | '-';
COMP_SYMBOL: '<' | '>' | '==' | '<=' | '>=';
NAME: [a-zA-Z]+;
NUMBER: [0-9][0-9]*;
WS: [ \n\t\r]+ -> skip;
NEG: '!';
AND: '&&';
MULT: '*';