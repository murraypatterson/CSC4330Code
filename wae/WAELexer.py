import ply.lex as lex

reserved = { 'with': 'WITH', 'if': 'IF' }

tokens = ['NUMBER','ID','LBRACE','RBRACE','SEMI','PLUS','MINUS','TIMES','DIV'] + list(reserved.values())

t_LBRACE = r'\{'
t_RBRACE = r'\}'
t_SEMI = r';'
t_WITH = r'[wW][iI][tT][hH]'
t_IF = r'[iI][fF]'
t_PLUS = r'\+'
t_MINUS = r'-'
t_TIMES = r'\*'
t_DIV = r'/'

def t_NUMBER(t):
  r'[-+]?[0-9]+(\.([0-9]+)?)?'
  t.value = float(t.value)
  t.type = 'NUMBER'
  return t

def t_ID(t):
  r'[a-zA-Z][_a-zA-Z0-9]*'
  t.type = reserved.get(t.value.lower(),'ID')
  return t

# Ignored characters
t_ignore = " \r\n\t"
t_ignore_COMMENT = r'\#.*'

def t_error(t):
  print("Illegal character '%s'" % t.value[0])
  #t.lexer.skip(1)
  raise Exception('LEXER ERROR')

lexer = lex.lex()

## Test it out..
#data = '{with {{x 5} {y 2}} {- x y}};'

## Give the lexer some input
#print("Tokenizing: ", data)
#lexer.input(data)

## Tokenize
#while True:
#  tok = lexer.token()
#  if not tok: 
#    break      # No more input
#  print(tok)
