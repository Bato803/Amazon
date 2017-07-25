public class Solution {
    
    
    private List<String> res = new ArrayList<>();
    private HashMap<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
    public List<String> findItinerary(String[][] tickets) {

        
        if(tickets == null || tickets.length == 0 || tickets[0].length == 0){
            
            return res;
        }
        
        for(String[] ticket : tickets){
            
            String start = ticket[0];
            
            if(!map.containsKey(start)){
                
                map.put(start, new PriorityQueue<>());
            }
            
            map.get(start).add(ticket[1]);
        }
        
        
        dfs("JFK");
        
        Collections.reverse(res);
        
        return res;
        
    }
    
    
	public void dfs(String s) {
		PriorityQueue<String> q = map.get(s);
 
		while (q != null && !q.isEmpty()) {
			dfs(q.poll());
		}
 
		res.add(s);
	}
}
