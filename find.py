import sys, re

'''

  facilitate the use of Python's re library --- somewhat of a
  "wrapper", e.g.,

    echo "hi, how are you?" > hi.txt
    python find.py findall "h." hi.txt

  gives:

    1 ['hi', 'ho']

  while,

    python find.py fullmatch "[a-z]+" hi.txt split one-per-line

  gives:

    1 ['how']
    1 ['are']

  to be used with caution (i.e., it is not "automagic" :)

'''

#
# using a particular `searchtype` (search, match, fullmatch, findall,
# etc.), look for `pattern` in `string`
def find(searchtype, pattern, string) :

    # make all groups non-capturing by default
    pattern = pattern.replace('(', '(?:')
    pattern = pattern.replace('\(?:', '\(') # just in case..

    match = searchtype(pattern, string)
    if match :
        return match if searchtype.__name__ == 'findall' else [match.group()]

#
# Main
#----------------------------------------------------------------------

searchname, pattern, filename = sys.argv[1:4] # first 3 arguments

processing = None
if len(sys.argv) > 4 : # optional 4th argument
    processing = sys.argv[4]

perline = 'many'
if len(sys.argv) > 5 : # optional 5th argument
    perline = sys.argv[5]

searchtype = getattr(re, searchname)
lines = open(filename, encoding = 'utf8', errors = 'ignore')

count = 0
for line in lines :
    count += 1

    if processing == 'strip' :
        line = line.strip()

    match = find(searchtype, pattern, line) # "default"

    if processing == 'split' :
        match = []

        for token in line.split() :
            m = find(searchtype, pattern, token)
            match += m if m else []

    if match :

        if perline == 'one-per-line' :
            for m in match :
                print(count, [m])

        else :
            print(count, match)
