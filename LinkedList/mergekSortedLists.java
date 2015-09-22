/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b){
                if(a.val > b.val) return 1;
                else if(a.val == b.val) return 0;
                else return -1;
            }  
        });
        
        for(ListNode node :  lists){
            if(node != null) q.add(node);
        }
        
        ListNode head = new ListNode(0);
        ListNode node = head;
        
        while(q.size() > 0){
            ListNode poll = q.poll();
            node.next = poll;
            if(poll.next != null) q.add(poll.next);
            node = node.next;
        }
        if(node !=null) node.next = null;
        return head.next;
    }
}