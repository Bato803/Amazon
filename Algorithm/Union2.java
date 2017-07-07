public class Union {

    public static void main(String[] args){
        Union union = new Union();

        String[][] arr = new String[][]{
                {"friend1", "friend2"},
                {"friend1", "friend7"},
                {"friend3", "friend4"},
                {"friend4", "friend5"},
        };

        System.out.println(union.getString(arr));

    }



    private List<String> getString(String[][] arr){

        List<String> res = new ArrayList<>();

        if(arr == null || arr.length == 0){
            return res;
        }


        Map<String, String> map = new HashMap<>();

        for(String[] subset : arr){

            String s1 = subset[0];
            String s2 = subset[1];

            if(s1.compareTo(s2) < 0){
                map.put(s2, s1);
            }else{
                map.put(s1, s2);
            }
        }

        int max = 1;
        String key = null;

        Map<String, List<String>> result = new HashMap<>();

        for(Map.Entry<String, String> entry : map.entrySet()){

            String root = entry.getKey();

            String parent = getParent(map, root);

            if(!result.containsKey(parent)){
                result.put(parent, new ArrayList<>());
            }

            result.get(parent).add(root);
        }


        for(Map.Entry<String, List<String>> entry : result.entrySet()){


            String s = entry.getKey();
            List<String> r = entry.getValue();
            r.add(s);
            Collections.sort(r);

            if(r.size() > max || r.size() == max && ( key == null || r.get(0).compareTo(key) < 0)){
                max = r.size();
                key = r.get(0);
            }


        }

        return result.get(key);




    }

    private String getParent(Map<String, String> parent, String s){

        if(parent.containsKey(s)){
            return getParent(parent, parent.get(s));
        }else{
            return s;
        }
    }

}
