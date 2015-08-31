/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * } https://www.dropbox.com/s/wlbf3qkpwoxfaca/Screenshot%202015-08-16%2018.15.50.png?dl=0
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp = head.next;
        head.next = temp.next;
        temp.next = head;
        if(head.next != null && head.next.next != null) head.next = swapPairs(head.next);
        return temp;
    }
}