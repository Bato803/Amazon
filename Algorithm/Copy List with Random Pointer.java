/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        
        if(head == null){
            return null;
        }
        
        RandomListNode dummy = new RandomListNode(head.label);
        
        RandomListNode res = dummy;
        
        Map<RandomListNode,RandomListNode> map = new HashMap<>();

        RandomListNode p = head;
        
        
        map.put(p, dummy);
        
        p = p.next;
    
        
        while(p != null){
        
            RandomListNode temp = new RandomListNode(p.label);
        
            map.put(p, temp);
        
            dummy.next = temp;
            
            p = p.next;
            
            dummy = dummy.next;
        }
        
        p = head;
        
        dummy = res;
        
        while(p != null){
            
            if(p.random != null){
                
                dummy.random = map.get(p.random);   
            }
            p = p.next;
            dummy = dummy.next;
        }
        
        return res;
        
        
    }
        
}
