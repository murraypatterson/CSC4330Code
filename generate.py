import sys
from itertools import product

'''

  generate the Kleene closure of alphabet upto strings of length (but
  not including) m, e.g.,

    python generate.py ab 3

  gives:

    
    a
    b
    aa
    ab
    ba
    bb

'''

alphabet = list(sys.argv[1])
m = int(sys.argv[2])

for i in range(m) :
    for string in product(alphabet, repeat = i) :

        print(*string, sep = '')
