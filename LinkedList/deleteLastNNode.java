/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * } https://www.dropbox.com/s/0ylwr5qb3y0spoc/Screenshot%202015-08-16%2018.14.22.png?dl=08
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        
        while(n != 0){
            n--;
            fast = fast.next;
        }
        
        //this is the catch, very important part, if the fast hits null, then concentrate
        if(fast == null) return head.next;
        
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        return head;
    }
}