import sys

'''c

  use Python's str.split() routine to split each line into tokens
  (each on its own line), e.g.,

    echo "hi, how are you?" > hi.txt
    python split.py hi.txt

  gives:

    hi,
    how
    are
    you?

'''

lines = sys.stdin
if sys.argv[1] != '-' :
    lines = open(sys.argv[1], encoding = 'utf8', errors = 'ignore')

for line in lines :
    line = line.strip()

    for token in line.split() :
        print(token)
