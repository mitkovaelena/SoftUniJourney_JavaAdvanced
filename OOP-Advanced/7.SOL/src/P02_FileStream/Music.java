package P02_FileStream;

public class Music extends BaseStream{

    private String artist;
    private String album;

    public Music(String artist, String album, int length, int bytesSent) {
        super(length, bytesSent);
        this.artist = artist;
        this.album = album;
    }
}
