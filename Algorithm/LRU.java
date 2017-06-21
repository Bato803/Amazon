public class LRUCache {


    class Node{
        
        int key;
        int val;
        
        Node prev;
        Node next;
        
        Node(int key, int val){
            this.key = key;
            this.val = val;
            
            prev = null;
            next = null;
        }
    }
    
    private Map<Integer, Node> map = new HashMap<>();
    
    private Node head = new Node(-1, -1);
    
    private Node tail = new Node(-1, -1);
    
    private int capacity;

    public LRUCache(int capacity) {
        
        this.capacity = capacity;
        
        head.next = tail;
        tail.prev = head;
        
    }
    
    private void moveToTail(Node curr){
        
        Node prev = tail.prev;
        tail.prev = curr;
        curr.prev = prev;
        prev.next = curr;
        curr.next = tail;
    }
    
    public int get(int key) {
        
        if(!map.containsKey(key)){
            return -1;
            
        }
        
        Node temp = map.get(key);
        
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        
        moveToTail(temp);
        
        return temp.val;
        
        
    }
    public void put(int key, int value) {
        
        if(get(key) != -1){
            
            map.get(key).val = value;
            return;
        }else{
            
            Node node = new Node(key, value);
            
            if(map.size() == capacity){
                
                map.remove(head.next.key);
                head.next = head.next.next;
                head.next.prev = head;
                
            }
            
            map.put(key, node);
            moveToTail(node);
            return;
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
