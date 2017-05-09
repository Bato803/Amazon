/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if(l1 == null && l2 == null){
            return null;
        }
        
        if(l1 == null){
            return l2;
        }
        
        if(l2 == null){
            return l1;
        }
        
        ListNode dummy = new ListNode(0);
        
        ListNode head = dummy;
        
        int val = 0;
        int carry = 0;
        
        while(l1 != null && l2 != null){
            
            val =  (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            
            head.next = new ListNode(val);
            
            head = head.next;
            
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null){
            val =  (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            
            head.next = new ListNode(val);
            
            head = head.next;
            
            l1 = l1.next;
        }
        
        while(l2 != null){
            val =  (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;
            
            head.next = new ListNode(val);
            
            head = head.next;
            
            l2 = l2.next;
        }
        
        if(carry > 0){
            head.next = new ListNode(carry);
        }
        
        return dummy.next;
        
    }
}
