/*
Iterator for Combination

Design an Iterator class, which has:

A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
A function next() that returns the next combination of length combinationLength in lexicographical order.
A function hasNext() that returns True if and only if there exists a next combination.
 

Example:

CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.

iterator.next(); // returns "ab"
iterator.hasNext(); // returns true
iterator.next(); // returns "ac"
iterator.hasNext(); // returns true
iterator.next(); // returns "bc"
iterator.hasNext(); // returns false
 

Constraints:

1 <= combinationLength <= characters.length <= 15
There will be at most 10^4 function calls per test.
It's guaranteed that all calls of the function next are valid

*/
--------------------------------------------------------------------------------------------------------------------------

class CombinationIterator {
    ArrayList<String> combinations;
    int index;
    int N;
    
    public CombinationIterator(String characters, int combinationLength) {
       combinations = new ArrayList<String>();
       generateCombinations(characters.toCharArray(), combinationLength, new StringBuilder(), 0);
       index = 0;
       N = combinations.size(); 
    }
    
    public String next() {
      if(index<N)
        return combinations.get(index++);
      return "";
    }
    
    public boolean hasNext() {
       return index < N; 
    }
    
    private void generateCombinations(char[] c, int k, StringBuilder s, int start){
        if(s.length() == k){
           combinations.add(s.toString());
           return;
        }
        
        for(int i=start; i<c.length; i++){
            s.append(c[i]);
            generateCombinations(c, k, s, i+1);
            s.deleteCharAt(s.length()-1);
        }
        
    }
}

