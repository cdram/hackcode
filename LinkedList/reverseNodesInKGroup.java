/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * } https://www.dropbox.com/s/8itf7gozb8c8fc2/Screenshot%202015-08-16%2018.17.37.png?dl=0
 */
public class Solution {
    ListNode first = null;
    
    private ListNode reverse(ListNode node, int counter){
        counter--;
        
        if(counter == 0){
            first = node;
            return node;
        }
        
        ListNode ret = reverse(node.next, counter);
        node.next = ret.next;
        ret.next = node;
        return node;
    }
    
    
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        int len = 0;
        ListNode temp = head;
        
        //find the length of the LinkedList
        while(temp != null){
            len++;
            temp = temp.next;
        }
        
        //if the LinkedList is smaller than k, just return the head;
        if(len < k) return head;
        
        //point temp back to head
        temp = head;
        
        //number of possible groups in the LinkedList
        int numOfGroups = len/k;
        ListNode prev = null;
        
        temp = reverse(temp, k);
        prev = temp; //preserve the last node as previous
        head = first; //preserve the first node as its the head
        temp = temp.next; 
        numOfGroups--;
        
        while(temp != null && numOfGroups != 0){
            temp = reverse(temp, k);
            prev.next = first;
            prev = temp;
            
            //decrement the number of passes
            numOfGroups--;
            
            //move to the next node
            temp = temp.next;
        }
        
        return head;
        
    }
}