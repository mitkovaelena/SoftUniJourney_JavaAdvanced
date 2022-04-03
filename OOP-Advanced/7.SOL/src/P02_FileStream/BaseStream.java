package P02_FileStream;

public abstract class BaseStream implements Streamable{
    private int length;
    private int bytesSent;

    protected BaseStream(int length, int bytesSent) {
        this.length = length;
        this.bytesSent = bytesSent;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public int getBytesSent() {
        return bytesSent;
    }
}
