class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        if(words == null || words.length == 0){
            
            return null;
        }
        
        List<String> res = new ArrayList<>();
        
        
        Map<String, Integer> map = new HashMap<>();
        
        
        
        
        for(String s : words){
            
            if(map.containsKey(s)){
                
                map.put(s, map.get(s) + 1);
            }else{
                
                map.put(s, 1);
            }
            
        }
        
        PriorityQueue<Map.Entry<String, Integer>> q = new PriorityQueue<>(
        
            (a,b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()
        );
            
            
        for(Map.Entry<String, Integer> e : map.entrySet()){
            
            q.offer(e);
            
            if(q.size() > k){
                
                q.poll();
            }
        }
        
        while(!q.isEmpty()){
            
            res.add(q.poll().getKey());
        }
        
        
        
        Collections.reverse(res);
        
        return res;
        
        
    }
}
