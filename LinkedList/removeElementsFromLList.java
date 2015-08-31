/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * } https://www.dropbox.com/s/bklhruzh47zdj0u/Screenshot%202015-08-16%2018.26.22.png?dl=0
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        
        ListNode temp = head;
        ListNode prev = null;
        
        while(temp != null){
            if(temp.val == val && prev == null){
                head = temp.next;
            }else if(temp.val == val && prev != null){
                prev.next = temp.next;
            }else{
                prev = temp;
            }
            
            temp = temp.next;
        }
        
     
        return head;
        
    }
}