/*
Power of Four

Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example 1:

Input: 16
Output: true
Example 2:

Input: 5
Output: false

Follow up: Could you solve it without loops/recursion?

*/
--------------------------------------------------------------------------------------------------------------------------

class Solution {
    public boolean isPowerOfFour(int num) {
         
        if(num > 0){
            boolean msb = ((num & num -1) == 0);           //1.check if only the leftmost bit is set
            boolean bitPosition = (num & 0x55555555) != 0; //2.check if the set bit is in odd positon
            return msb && bitPosition;
        }
        return false;
    }
}

/*
Explanation:

0x55555555 - is a hex value, when converted to binary will have only odd bits set (binary 32 bit binary representation: 0101 0101 0101 0101 0101 0101 0101 0101)
Similarly the number 0xAAAAAAAA is a 32 bit number with all even bits set as 1 and all odd bits as 0.(Not in scope of this problem)

Multiples of 4 binary Representaion

4 -         100
16 -      10000
64 -    1000000
256 - 100000000

when you see the above binary representation you can notice multiples of 4 have only one set bit and it is the most significant bit or leftmost bit
so buy using the following two condyions we can verify if a given number is power of 4 or not.
1.check if only the leftmost bit is set
2.check if the set bit is in odd positon

*/