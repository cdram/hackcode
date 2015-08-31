public class Solution {
      public TreeNode sortedListToBST(ListNode head) {
                if(head == null) return null;
                        ListNode prev = null;
                                ListNode slow = head;
                                        ListNode fast = head;
                                                
                                                while(fast.next != null && fast.next.next != null){
                                                              prev = slow;
                                                                          slow = slow.next;
                                                                                      fast = fast.next.next;
                                                                                              }
                                                        
                                                        TreeNode root = new TreeNode(slow.val);
                                                                if(slow.next!=null) root.right = sortedListToBST(slow.next);
                                                                        if(prev != null) prev.next = null;
                                                                                if(head!=slow) root.left = sortedListToBST(head);
                                                                                        return root;
                                                                                            }
}

