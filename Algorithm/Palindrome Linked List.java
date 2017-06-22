/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        
        
        if(head == null || head.next == null){
            return true;
        }
        
        
        ListNode dummy = head;
        
        ListNode mid = getMid(dummy);
        
        
        ListNode reverse = reverse(mid);
        
        
        while(head != null && reverse != null){
            
            if(head.val != reverse.val){
                
                return false;
            }
            
            head = head.next;
            reverse = reverse.next;
        }
        

        return true;
    }
    
    private ListNode reverse(ListNode node){
        
        
        ListNode prev = null;
        
        while(node != null){
            
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
            
        }
        
        return prev;
    }
    
    private ListNode getMid(ListNode node){
        
        ListNode slow = node;
        ListNode fast = node.next;
        
        
        while(fast != null && fast.next != null){
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}
