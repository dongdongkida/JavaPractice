import java.util.ArrayList;

public class Album{
    private String name;
    private ArrayList<Song> album;

    public Album(String name) {
        this.name = name;
        this.album = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Song> getAlbum() {
        return album;
    }

    public boolean addSong(Song song) {
        if(findSong(song)){
            return false;
        } else {
            this.album.add(song);
            return true;
        }
    }

    public boolean removeSong(Song song) {
        if(findSong(song)){
            this.album.remove(song);
            return true;
        } else {
            return false;
        }
    }

    public boolean findSong(Song song) {
        for(Song song1: this.album) {
            if(song1 == song) {
                return true;
            }
        } return false;
    }

    public void showAlbumList() {
        System.out.println("Album " + this.name + "'s list:");
        for(int i=0; i<this.album.size(); i++) {
            System.out.println((i+1) + ". " + this.album.get(i).getTitle() + ":  " + this.album.get(i).getDurationOfSong());
        }
        System.out.println("=====================================");
    }


}
