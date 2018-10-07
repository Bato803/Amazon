package am;

import java.util.ArrayList;
import java.util.List;

public class MaxShipDistance {


    private List<Integer> maxShippingDist(List<List<Integer>> list1, List<List<Integer>> list2, int maxDist) {

        if (list1 == null || list1.size() == 0 || list1.get(0).size() == 0 ||
                list2 == null || list2.size() == 0 || list2.get(0).size() == 0) {

            return null;
        }


        List<Integer> res = new ArrayList<>();

        int max = 0;
        for (List<Integer> listOne : list1) {


            for (List<Integer> listTwo : list2) {


                if (listOne.get(1) + listTwo.get(1) <= maxDist) {

                    max = Math.max(max, listOne.get(1) + listTwo.get(1));
                }
            }

        }
        for (List<Integer> listOne : list1) {


            for (List<Integer> listTwo : list2) {


                if (listOne.get(1) + listTwo.get(1) == maxDist) {

                    res.add(listOne.get(0));
                    res.add(listTwo.get(0));
                }
            }

        }

        return res;
    }
}
