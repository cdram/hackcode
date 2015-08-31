/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * } https://www.dropbox.com/s/pkgbyqc7vltdl8w/Screenshot%202015-08-16%2018.16.43.png?dl=0
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        int len = 1;
        ListNode temp = head;
        ListNode mid = head;
        
        //find the length of the list and the pointer to the last node
        while(temp.next != null){
            len++;
            temp = temp.next;
        }
        
        k = k % len; //this will give the point in the list, whose next node is the new head!
        if(k == 0) return head; //this means that the list after the rotations will be the same as the input list!
        
        for(int i = 0;i<len-k-1; i++){
            mid = mid.next;
        }
        
        temp.next = head;
        head = mid.next;
        mid.next = null;
        
        return head;
    }
}