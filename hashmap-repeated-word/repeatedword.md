## hashmap-repeated-word
Write a function called repeatedWord that finds the first word to occur more than once in a string. The function should take a string as an argument and return the first repeated word in the string.


## Whiteboard Process

![abd.drawio.png](abd.drawio.png)
## Approach & Efficiency
# Approach
Tokenize the Input String:

Split the input string into words. You can use regular expressions or the split method to break the string into words based on spaces and punctuation marks.
Create a Set to Track Words:

Initialize an empty set to keep track of unique words encountered in the string.
Iterate Through Words:

Iterate through the words in the tokenized string.
For each word, convert it to lowercase (to make the search case-insensitive).
Check for Repeated Words:

For each word, check if it already exists in the set of unique words.
If it does, return the word as the first repeated word.
If not, add the word to the set of unique words.
Handle the No Repeated Word Case:

If you reach the end of the iteration without finding a repeated word, return an empty string to indicate that there are no repeated words.



# Efficiency
Time Complexity:

Tokenization of the input string has a time complexity of O(n), where 'n' is the length of the input string.
The loop that iterates through the words has a time complexity of O(n) because each word is processed once.
HashSet operations (addition and contains) have an average time complexity of O(1).
Therefore, the overall time complexity of this solution is O(n), where 'n' is the length of the input string.

Space Complexity:

The space complexity is determined by the storage used for the HashSet, which stores unique words.
In the worst case, where there are no repeated words, the HashSet will store all 'n' words.
In the best case, where the first word is repeated, the HashSet will store just two words.
Therefore, the space complexity of this solution can be O(n) in the worst case and O(1) in the best case.

## Solution
![Capture.PNG](Capture.PNG)
