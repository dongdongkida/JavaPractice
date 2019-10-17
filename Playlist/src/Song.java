public class Song {
    private String title;
    private double durationOfSong;

    public Song(String title, double durationOfSong) {
        this.title = title;
        this.durationOfSong = durationOfSong;
    }

    public String getTitle() {
        return title;
    }

    public double getDurationOfSong() {
        return durationOfSong;
    }

    @Override
    public String toString() {
        return this.title + ":  " + this.durationOfSong;
    }
}
