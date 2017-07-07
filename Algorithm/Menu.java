public class Menu {


    public static void main(String[] args) {

        Menu menu = new Menu();

        List<List<String>> names = new ArrayList<>();

        List<String> name1 = new ArrayList<>();
        name1.add("A");
        name1.add("AA");
        List<String> name4 = new ArrayList<>();
        name4.add("A1");
        name4.add("AA");
        List<String> name2 = new ArrayList<>();
        name2.add("B");
        name2.add("BB");
        List<String> name3 = new ArrayList<>();
        name3.add("C");
        name3.add("CC");

        names.add(name1);
        names.add(name2);
        names.add(name3);
        names.add(name4);


        List<List<String>> foods = new ArrayList<>();

        List<String> food1 = new ArrayList<>();
        food1.add("AA");
        food1.add("AAA");

        List<String> food4 = new ArrayList<>();
        food4.add("AA");
        food4.add("AAAA");


        List<String> food2 = new ArrayList<>();
        food2.add("BB");
        food2.add("BBB");
        List<String> food3 = new ArrayList<>();
        food3.add("CC");
        food3.add("CCC");


        foods.add(food1);
        foods.add(food2);
        foods.add(food3);
        foods.add(food4);


        Map<String, List<String>> map = menu.getMenu(names, foods);


        for (Map.Entry<String, List<String>> entry : map.entrySet()) {

            System.out.print(entry.getKey());

            for (String s : entry.getValue()) {
                System.out.print(" " + s);
            }

            System.out.println();
        }

    }


    public Map<String, List<String>> getMenu(List<List<String>> names, List<List<String>> foods) {


        Map<String, List<String>> res = new HashMap<>();

        Map<String, String> person = new HashMap<>();


        Map<String, List<String>> foodMap = new HashMap<>();

        if (names == null || names.size() == 0) {
            return res;
        }


        for (List<String> list : names) {

            String name = list.get(0);

            String place = list.get(1);


            person.put(name, place);


        }

        for (List<String> list : foods) {

            String place = list.get(0);

            if (!foodMap.containsKey(place)) {
                foodMap.put(place, new ArrayList<>());
            }

            for (int i = 1; i < list.size(); i++) {

                foodMap.get(place).add(list.get(i));
            }
        }


        for (String s : person.keySet()) {

            res.put(s, foodMap.get(person.get(s)));
        }

        return res;
    }
}
