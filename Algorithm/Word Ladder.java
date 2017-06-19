public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if(beginWord.equals(endWord)){
            return 1;
        }
        
        if(wordList == null || wordList.size() == 0){
            
            return 0;
        }
        
        
        Set<String> words = new HashSet<>();
        
        Set<String> check = new HashSet<>();
        
        for(String s : wordList){
            
            words.add(s);
        }
        
        
        int count = 1;
        
        Queue<String> q = new LinkedList<>();
        
        q.add(beginWord);
        
        while(!q.isEmpty()){
            
            
            count++;
            int size = q.size();
            
            for(int i = 0; i < size; i++){
                
                String temp = q.poll();
      
                for(int j = 0; j < temp.length(); j++){
                    
                    char[] arr = temp.toCharArray();
                    for(char c = 'a'; c <= 'z'; c++){
                        
                        arr[j] = c;
                        
                        String s = new String(arr);
                        
                        if(words.contains(s)){
                        
                        
                            if(s.equals(endWord)){
                            
                                return count;
                            }
                        
                            if(!check.contains(s)){
                                q.add(s);
                                check.add(s);
                            }
                        }
                    }
                    
                }
            }
            
        }
        return 0;
        
    }
}
