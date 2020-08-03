/*
 Valid Palindrome

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
 

Constraints:
s consists only of printable ASCII characters.

*/
--------------------------------------------------------------------------------------------------------------------------

class Solution {
    public boolean isPalindrome(String s) {
        int start = 0; 
        int end = s.length() - 1;
        char[] input = s.toCharArray();
        while(start <= end) {
            while(start <= end && !Character.isLetterOrDigit(input[start])) {
                start++;
            }
            while(start <= end && !Character.isLetterOrDigit(input[end])) {
                end--;
            }
            if(start <= end && Character.toLowerCase(input[start]) != Character.toLowerCase(input[end])) {
                return false;
            }
            start++;
            end--;
        }
        return true;
        
    }
}

