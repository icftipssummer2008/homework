#5*. Given a string find all substrings that are palindromes.
#Runtime Complexity: Polynomial, O(n^2). Memory Complexity: Constant, O(1).
#For each letter in the input string, start expanding to left and right while checking for even and odd length palindromes.
# Move to the next letter if we know a palindrome doesn't exist.
#We expand one character to the left and right and compare them. If both of them are equal, we print out the palindrome substring.
def find_palindromes_in_sub_string(input, j, k):
  count = 0
  while j >= 0 and k < len(input):
    if input[j] != input[k]:
      break
    print input[j: k + 1],
    count += 1
    j -= 1
    k += 1
  return count

def find_all_palindrome_substrings2(input):
  count = 0
  for i in xrange(0, len(input)):
    count += find_palindromes_in_sub_string(input, i - 1, i + 1)
    count += find_palindromes_in_sub_string(input, i, i + 1)
  return count
print find_all_palindrome_substrings2('aabbbaa')