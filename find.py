import sys, re

'''

  facilitate the use of Python's re library --- somewhat of a
  "wrapper", e.g.,

    echo "hi, how are you?" > hi.txt
    python find.py findall "h." hi.txt

  gives:

    hi ho

  to be used with caution (i.e., it is not "automagic" :)

'''

#
# using a particular "searchtype" (search, match, fullmatch, findall,
# etc.), look for "pattern" in "string"
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
searchtype = getattr(re, searchname)

lines = sys.stdin
if filename != '-' :
    lines = open(filename, encoding = 'utf8', errors = 'ignore')

for line in lines :
    line = line.strip()

    match = find(searchtype, pattern, line)
    if match :
        print(' '.join(match))
