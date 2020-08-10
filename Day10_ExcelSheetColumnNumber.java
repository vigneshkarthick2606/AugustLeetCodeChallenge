/*
Excel Sheet Column Number

Solution
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
Example 1:

	Input: "A"
	Output: 1
	Example 2:

	Input: "AB"
	Output: 28
	Example 3:

	Input: "ZY"
	Output: 701
 

Constraints:

	1 <= s.length <= 7
	s consists only of uppercase English letters.
	s is between "A" and "FXSHRXW".

*/
--------------------------------------------------------------------------------------------------------------------------
class Solution {
    public int titleToNumber(String s) {
        
        int result = 0; 
        for (int i = 0; i < s.length(); i++) 
        { 
            result *= 26; 
            result += s.charAt(i) - 'A' + 1; 
        } 
        return result; 
        
    }
}


/*

Ref : https://www.geeksforgeeks.org/find-excel-column-number-column-title/

the process is similar to binary to decimal conversion.
For example, to convert AB, the formula is 26 * 1 + 2.
As another example,

To convert CDA,
3*26*26 + 4*26 + 1
= 26(3*26 + 4) + 1
= 26(0*26 + 3*26 + 4) + 1

*/

