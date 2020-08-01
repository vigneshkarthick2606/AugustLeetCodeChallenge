/*
Detect Capital

Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.

Input: "USA"
Output: True

Input: "FlaG"
Output: False

*/
--------------------------------------------------------------------------------------------------------------------------

class Solution {
    public boolean detectCapitalUse(String word) {
        int count = 0; 
        char[] input = word.toCharArray();
        for(int i=1; i<input.length; i++){
            if(input[i] >= 'A' && input[i] <= 'Z')
                count++;
        }   
        
        if((input[0] >= 'A' && input[0] <= 'Z') && count==0){
            return true;
        }
        
        if((input[0] >= 'A' && input[0] <= 'Z') && (input.length == count + 1)){
            return true;
        }        
        
        return count==0;
    }
}