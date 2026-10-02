
import java.util.Arrays;

public class Playlist {
    private final String[] songs;
    private int songCount;

    public Playlist(int capacity) {
        this.songs = new String[capacity];
        this.songCount = 0;
    }

    public void addSong(String songTitle) {
        if (songCount < songs.length) {
            songs[songCount] = songTitle;
            songCount++;
        } else {
            System.out.println("Playlist capacity reached.");
        }
    }

    // Returns a safe copy of the array up to the current count
    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked"; // Modifying copy does not affect internal playlist

        System.out.println("p.getSongs()[0] is still: \"" + p.getSongs()[0] + "\"");
        System.out.println("p.getSongCount() -> " + p.getSongCount());
    }
}