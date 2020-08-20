/*

Reorder List

Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

*/

--------------------------------------------------------------------------------------------------------------------------

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 
class Solution {
    public void reorderList(ListNode head) {
        
        if (head == null || head.next == null || head.next.next == null) return;

        ListNode slast = head; 
        ListNode last = head.next; 
        
        while (last.next != null) {
            last = last.next;
            slast = slast.next;
        }
        
        ListNode tmp = head.next;
        head.next = last;
        last.next = tmp;
	
		slast.next = null;
        
        reorderList(tmp);
        
    }
}