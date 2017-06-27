public class Solution {


    public static void main(String[] args) {


        User user = new User();


        Inventory inventory = Inventory.getInstance();

        Video tv = new TV();

        inventory.map.put(1L, tv);

        Video video = inventory.map.get(1L);

        user.playVideo(video);

        user.stopPlay(video);


    }
}


enum Type {

    MOVIE("MOVIE"), SHORT_VIDEO("SHORT_VIDEO"), TV("TV");


    String code;

    Type(String code) {
        this.code = code;


    }


    static Type getType(String code) {


        for (Type t : Type.values()) {

            if (code.equals(t.code)) {
                return t;
            }
        }

        return null;
    }
}


class TV extends Video {


    private double time;
    private Type type;

    public TV() {
        type = Type.TV;
    }

    @Override
    void play(double offset) {
        System.out.println("TV");
    }

    @Override
    void stop() {
        System.out.println("STOP");
    }
}

abstract class Video {

    long id;

    String url;

    double offset;

    int rated;


    static class VideoComparator implements Comparator<Video> {

        @Override
        public int compare(Video o1, Video o2) {
            return o2.rated - o1.rated;
        }
    }


    abstract void play(double offset);

    abstract void stop();

}


class Inventory {


    public static Inventory inventory = new Inventory();

    private Inventory() {

    }

    public static Inventory getInstance() {
        return inventory;
    }

    Map<Long, Video> map = new HashMap<>();


}

class User {

    String email;

    Map<Long, Double> watchlist = new HashMap<>();  // should be LRU

    public void playVideo(Video video) {


        if (watchlist.containsKey(video.id)) {

            video.play(watchlist.get(video.id));
        } else {

            video.play(0);
        }

    }

    public void stopPlay(Video video) {


        video.stop();


        long id = video.id;

        watchlist.put(id, video.offset);

    }
}

