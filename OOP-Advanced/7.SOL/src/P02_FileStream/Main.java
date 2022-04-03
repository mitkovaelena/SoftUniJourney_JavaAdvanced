package P02_FileStream;

public class Main {
    public static void main(String[] args) {
        StreamProgressInfo spi = new StreamProgressInfo(new File("eli", 120, 1500));
        System.out.println(spi.calculateCurrentPercent());

    }
}
