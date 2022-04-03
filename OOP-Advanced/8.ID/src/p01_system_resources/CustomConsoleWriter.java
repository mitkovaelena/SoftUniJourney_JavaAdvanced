package p01_system_resources;

public class CustomConsoleWriter implements Writer {

    @Override
    public void println(String input) {
        System.out.println(input);
    }
}
