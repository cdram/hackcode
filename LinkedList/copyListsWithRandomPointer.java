/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    
    private void helper(RandomListNode head, HashMap<RandomListNode, RandomListNode> map){
               RandomListNode node = new RandomListNode(head.label);
               node.next = null;
               node.random = null;
               map.put(head, node);
    }
    
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        RandomListNode hC = head;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        
        while(head != null){
            
            if(!map.containsKey(head)){
                helper(head, map);
            }
            
            if(head.next != null && !map.containsKey(head.next)){
                helper(head.next, map);
                map.get(head).next = map.get(head.next);
            }else if(head.next != null){
                map.get(head).next = map.get(head.next);
            }
                
            
            if(head.random !=null && !map.containsKey(head.random)){
                helper(head.random, map);
                map.get(head).random = map.get(head.random);
            }else if(head.random !=null){
                map.get(head).random = map.get(head.random);
            }
            
            head = head.next;
        }
        
        return map.get(hC);
    }
}
