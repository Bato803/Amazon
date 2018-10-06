package am;

import java.util.HashMap;
import java.util.Map;

public class GetMinStringArray {
    public int getMinimumStringArray(String[] tagList, String[] allTags) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();


        for (String s : tagList) {

            map1.put(s, 1);
        }

        int res = allTags.length + 1;
        int st = 0;

        for (int ed = 0; ed < allTags.length; ed++) {


            if (map1.containsKey(allTags[ed])) {

                if (!map2.containsKey(allTags[ed])) {

                    map2.put(allTags[ed], 1);
                } else {

                    map2.put(allTags[ed], map2.get(allTags[ed]) + 1);
                }
            }


            while (st <= ed && map2.size() == tagList.length) {

                if (ed - st + 1 < res) {

                    res = ed - st + 1;
                }

                if (map1.containsKey(allTags[st])) {
                    if (map2.get(allTags[st]) == 1) {
                        map2.remove(allTags[st]);
                    } else {
                        map2.put(allTags[st], map2.get(allTags[st]) - 1);
                    }
                }
                st++;
            }
        }

        if (res == allTags.length + 1) {
            return -1;
        }
        return res;
    }


}
