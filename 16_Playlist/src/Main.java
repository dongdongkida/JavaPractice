import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Song underTheBridge = new Song("Under The Bridge", 4.33);
        Song giveItAway = new Song("Give It Away", 4.44);
        Song california = new Song("California", 5.29);
        Song scarTissue = new Song("Scar Tissue",3.35);
        Song soulToSqueeze = new Song("Soul to Squeeze", 4.50);
        Song greatNation = new Song ("Great Nation", 3.00);

        Album classic = new Album("Classic");
        classic.addSong(underTheBridge);
        classic.addSong(giveItAway);
        classic.addSong(scarTissue);
        classic.addSong(california);
        classic.addSong(soulToSqueeze);
        classic.showAlbumList();

        Song angry = new Song("Angry", 3.44);
        Song blackAndWhitePeople = new Song("Black & White People", 3.45);
        Song crutch = new Song("Crutch", 3.25);
        Song lastBeautifulGirl = new Song("Last Beautiful Girl", 4.03);
        Song ifYoureGone = new Song("If You're Gone", 4.34);
        Song badGirl = new Song ("Bad Girl", 3.90);

        Album rockRoll = new Album("Rock & Roll");
        rockRoll.addSong(angry);
        rockRoll.addSong(blackAndWhitePeople);
        rockRoll.addSong(crutch);
        rockRoll.addSong(lastBeautifulGirl);
        rockRoll.addSong(ifYoureGone);
        rockRoll.addSong(crutch);
        rockRoll.showAlbumList();
        rockRoll.removeSong(badGirl);
        rockRoll.removeSong(crutch);
        rockRoll.addSong(badGirl);
        rockRoll.showAlbumList();

        ArrayList<Album> albums = new ArrayList<>();
        albums.add(classic);
        albums.add(rockRoll);

        LinkedList<Song> playlist = new LinkedList<>();
        addToPlaylist(badGirl,playlist,albums);
        addToPlaylist(ifYoureGone,playlist,albums);
        addToPlaylist(greatNation,playlist,albums);
        addToPlaylist(angry,playlist,albums);
        addToPlaylist(california,playlist,albums);
        addToPlaylist(ifYoureGone,playlist,albums);



        MediaPlayer ipod = new MediaPlayer("Ipod", playlist);

        ipod.playing();


    }

    private static boolean addToPlaylist (Song song, LinkedList<Song> playlist, ArrayList<Album> albums) {
        if(playlist.contains(song)) {
            System.out.println(song.getTitle() + " is already in your list");
            return false;
        } else {
            if(findSong(song, albums)) {
            playlist.add(song);
            return true;
        } else
            return false;
        }
    }

    private static boolean findSong(Song song, ArrayList<Album> albums) {
        for(int i = 0; i<albums.size(); i++) {
            if(albums.get(i).findSong(song)) {
                return true;
            }
        }
        System.out.println(song.getTitle() + "not found in your albums, please check it again");
        return false;
    }
}
