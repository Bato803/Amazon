public class Song {

    private long id;
    private String detail;

    public Song(long id, String detail) {
        this.detail = detail;
        this.id = id;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}

public class CD {


    private long id;

    private String detail;



    public CD(long id, String detail) {
        this.id = id;
        this.detail = detail;

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

}


public class CDPlayer {

    private Playlist p;

    private CD c;


    public CDPlayer(CD c, Playlist p) {
    }


    public CDPlayer(Playlist p) {
        this.p = p;
    }


    public CDPlayer(CD c) {
        this.c = c;
    }


    public void playSong(Song s) {
    }


    public Playlist getPlaylist() {
        return p;
    }


    public void setPlaylist(Playlist p) {
        this.p = p;
    }


    public CD getCD() {
        return c;
    }


    public void setCD(CD c) {
        this.c = c;
    }


}
public class Playlist {

    private Song song;

    private Queue<Song> queue;


    public Playlist(Song song, Queue<Song> queue) {

    }


    public Song getNextSToPlay()

    {
        return queue.peek();

    }


    public void queueUpSong(Song s) {
        queue.add(s);

    }


}

public class Jukebox {

    private CDPlayer cdPlayer;

    private User user;

    private Set<CD> cdCollection;


    public Jukebox(CDPlayer cdPlayer, User user, Set<CD> cdCollection) {

    }


    public void setUser(User u) {
        this.user = u;

    }


}


public class User {

    private String name;
    private long id;


    public User(String name, long id) {

        this.name = name;
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
