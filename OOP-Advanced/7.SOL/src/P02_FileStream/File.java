package P02_FileStream;

public class File extends BaseStream{

    private String name;

    public File(String name, int length, int bytesSent) {
        super(length, bytesSent);
        this.name = name;
    }
}
