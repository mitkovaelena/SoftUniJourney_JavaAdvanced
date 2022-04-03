import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EliQMurzi {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String url = reader.readLine();
        if(url.split("://").length > 2 || url.split("://").length == 1) {
            System.out.println("Invalid URL");
            return;
        }

        String[] params = url.split("://");
        String protocol = params[0];
        String server = params[1].split("/")[0];
        String resources = params[1].substring(params[1].indexOf('/') + 1);

        System.out.println(String.format("Protocol = %s\nServer = %s\nResources = %s", protocol, server, resources));
    }
}
