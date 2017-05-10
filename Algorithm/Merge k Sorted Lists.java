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
        
        if(lists == null || lists.length == 0){
            
            return null;
        }
        
        if(lists.length == 1){
            return lists[0];
        }
        
        
        if(lists.length == 2){
            
            return mergeTwoList(lists[0], lists[1]);
        }
        
        int st = 0;
        int ed = lists.length;
        
        int mid = st + (ed - st) / 2;
        
        return mergeTwoList(mergeKLists(Arrays.copyOfRange(lists, 0, mid)), mergeKLists(Arrays.copyOfRange(lists, mid, ed)));
        
        // return mergeTwoList(mergeKLists(Arrays.copyOfRange(lists, 0, mid)), mergeKLists(Arrays.copyOfRange(lists, mid, ed)));
        
        
    }
    
    private ListNode mergeTwoList(ListNode l1, ListNode l2){
        
        ListNode dummy = new ListNode(0);
        
        ListNode res = dummy;
        
        while(l1 != null && l2 != null){
            
            if(l1.val < l2.val){
                dummy.next = l1;
                
                l1 = l1.next;
            }else{
                
                dummy.next = l2;
                
                l2 = l2.next;
            }
            
            dummy = dummy.next;
            
        }
        
        
        if(l1 != null){
            
            dummy.next = l1;
        }
        
        if(l2 != null){
            
            dummy.next = l2;
        }
        
        return res.next;
        
    }
}
