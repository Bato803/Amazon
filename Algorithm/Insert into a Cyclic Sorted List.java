/*

Description
Given a node from a cyclic linked list which has been sorted, write a function to insert a value into the list such that it remains a cyclic sorted list. The given node can be any single node in the list. Return the inserted new node.

3->5->1 is a cyclic list, so 3 is next node of 1.
3->5->1 is same with 5->1->3

Have you met this question in a real interview?  
Example
Given a list, and insert a value 4:
3->5->1
Return 5->1->3->4

Related Problems

*/

public class Solution {
    /**
     * @param node a list node in the list
     * @param x an integer
     * @return the inserted new list node
     */
    public ListNode insert(ListNode start, int x) {
       if (start == null) {
            start = new ListNode(x);
            start.next = start;
            return start;
        }
        
        ListNode cur = start;
        while (true) {
            if (cur.val < cur.next.val) {//没有到拐点
                if (x>=cur.val && x<=cur.next.val) {
                    add(cur, x);
                    break;
                }
                else cur = cur.next;
            }
            else if (cur.val > cur.next.val) { //到了拐点
                if (x>=cur.val || x<=cur.next.val) {
                    add(cur, x);
                    break;
                }
                else cur = cur.next;
            }
            else { //cur.val == cur.next.val
                if (cur.next == start) {
                    add(cur, x);
                    break;
                }
                cur = cur.next;
            }
        }
        return start;
    }
    
    public void add(ListNode cur, int x) {
        ListNode node = new ListNode(x);
        node.next = cur.next;
        cur.next = node;
    }
}
