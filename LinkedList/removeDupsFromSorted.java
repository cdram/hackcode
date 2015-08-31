/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * } https://www.dropbox.com/s/87y3jk036fz0zv9/Screenshot%202015-08-20%2023.45.33.png?dl=0
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast != null){
            
            //check whether slow and fast have same val? If yes, move fast until the values are not same!
            if(slow.val == fast.val){
                while(fast != null){
                    if(slow.val != fast.val) break;
                    fast = fast.next;
                }
                //if the prev is null / prev and slow are same values, point both prev and head to fast
                if(prev == null || prev.val == slow.val) {
                    prev= fast;
                    head = fast;
                }else{ //else hook the next of prev to fast
                    prev.next = fast;
                }
                slow = fast;
                if(fast != null) fast = fast.next;
            }else{ //if slow and fast are not same, then prev becomes slow and then move slow and fast by 1
                prev = slow;
                slow= slow.next;
                fast = fast.next;
            }
        }
        
        return head;
    }
}