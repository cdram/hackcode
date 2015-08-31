/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    ListNode first = null;
    private ListNode helper(ListNode head){
        if(head == null || head.next == null){
            first = head;
            return null;
        }
        
        ListNode next = head.next;
        head.next = helper(head.next);
        next.next = head;
        return head.next;
    }
    
    public ListNode reverseList(ListNode head) {
     helper(head);
        return first;
    }
    
    
}