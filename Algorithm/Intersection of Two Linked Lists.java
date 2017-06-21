/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA == null || headB == null){
            
            return null;
        }
        
        Set<ListNode> set = new HashSet<>();
        
        while(headA != null){
            
            set.add(headA);
            headA = headA.next;
            
        }
        
        
        while(headB != null){
            
            if(set.contains(headB)){
                return headB;
            }
            
            headB = headB.next;
        }
        
        return null;
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA == null || headB == null){
            return null;
        }
        
        ListNode a = headA;
        ListNode b = headB;
        
        int la = getLen(a);
        int lb = getLen(b);
        
        while(la > lb){
            
            headA = headA.next;
            la--;
            
        }
        
        
        while(la < lb){
            headB = headB.next;
            lb--;
        }
        
        
        while(headA != null){
            
            if(headA == headB){
                return headA;
            }
            
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
        
        
        
        
    }
    
    private int getLen(ListNode n1){
        
        int count = 0;
        while(n1 != null){
            
            count++;
            n1 = n1.next;
        }
        
        
        return count;
    }
}
