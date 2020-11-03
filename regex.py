import re

'''

  for testing regexes by looking for patterns in [ab]{0,5}, that is,
  the kleene closure of {a,b} upto strings of length (but not
  including) 6.  Note that this should give the same result as:

    python generate.py ab 6 > generate-ab-6.txt
    python find.py fullmatch "b*(ab*ab*)*" generate-ab-6.txt strip

'''

# the pattern (put your regex here)
#----------------------------------------------------------------------

# strings over alphabet {a,b} with an even number of a's
pattern = 'b*(ab*ab*)*'


# the set of strings (that we will try to match against)
#----------------------------------------------------------------------

strings = [''] + '''

   a b
   aa ab ba bb
   aaa aab aba abb baa bab bba bbb
   aaaa aaab aaba aabb abaa abab abba abbb
   baaa baab baba babb bbaa bbab bbba bbbb
   aaaaa aaaab aaaba aaabb aabaa aabab aabba aabbb
   abaaa abaab ababa ababb abbaa abbab abbba abbbb
   baaaa baaab baaba baabb babaa babab babba babbb
   bbaaa bbaab bbaba bbabb bbbaa bbbab bbbba bbbbb

'''.split()

sanity = 'hi any canal alpaca amalgamation abracadabra'.split()


# rest of the program..
#----------------------------------------------------------------------

# match pattern to each string in strings
def matchup(pattern, strings) :

    regex = re.compile(pattern) # "compile" pattern
    count = len(strings)

    layout = '{:<20}{:<20}{:<20}'
    print(layout.format('string', 'match', 'notes')) # header
    print(60*'-')

    matches = 0
    for string in strings :
        match = regex.fullmatch(string) # require a full match

        the_match = '' # default
        note = '** no match **' # default
        if match :        
            matches += 1

            the_match = '"' + match.group(0) + '"' # report the entire match
            note = ''

        print(layout.format('"' + string + '"', the_match, note))

    print(60*'-')
    print('matched', matches, '/', count, 'strings') # summary


# Main
#----------------------------------------------------------------------

print()
matchup(pattern, strings)
print()
print()
print('sanity check:')
print()
matchup(pattern, sanity)
print()
