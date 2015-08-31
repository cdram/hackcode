/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * } https://www.dropbox.com/s/nzhgdcjhhsadsxw/Screenshot%202015-08-16%2018.20.10.png?dl=0
 */
public class Solution {
    ListNode first = null;
    
    private ListNode reverse(ListNode node, int counter){
        counter = counter - 1;
        if(counter == 0) {
            first = node;
            return node;
        }
        
        ListNode ret = reverse(node.next, counter);
        node.next = ret.next;
        ret.next = node;
        return node;
    }
    
    
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return null;
        if(m-n==0) return head;
        int counter = 1;
        ListNode temp = head;
        
        if(m == 1){
            reverse(temp, (n-counter)+1);
            return first;
        }else{
            while(counter+1 != m){ temp = temp.next;
                counter++;
            }
            reverse(temp.next, n-counter);
            temp.next = first;
        }
        
        return head;
        
    }
}