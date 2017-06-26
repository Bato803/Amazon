public class LFUCache {


    private Map<Integer, Integer> values;
    private Map<Integer, Integer> counts;
    private Map<Integer, LinkedHashSet<Integer>> map;
    private int min = -1;
    
    private int capacity;
    public LFUCache(int capacity) {
        
        values = new HashMap<>();
        counts = new HashMap<>();
        map = new HashMap<>();
        this.capacity = capacity;
        map.put(1, new LinkedHashSet<>());
    }
    
    public int get(int key) {
        
        
        if(!values.containsKey(key)){
            return -1;
        }
        
        int count = counts.get(key);
        counts.put(key, count + 1);
        map.get(count).remove(key);
        int size = map.get(count).size();
        
        if(count == min && size == 0){
            min = min + 1;
        }
        
        if(!map.containsKey(count + 1)){
            map.put(count + 1, new LinkedHashSet<>());

        }
                    
        map.get(count + 1).add(key);
        
        return values.get(key);
        
    }
    
    public void put(int key, int value) {
        if(capacity <= 0)
            return;
            
        if(values.containsKey(key)){
            
            values.put(key, value);
            
            get(key);
            
            return;
        }
        
        if(values.size() == capacity){
            
            int val = map.get(min).iterator().next();
            
            counts.remove(val);
            map.get(min).remove(val);
            values.remove(val);
            
        }
        
        values.put(key,value);
        counts.put(key, 1);
        min = 1;
        map.get(1).add(key);
        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
