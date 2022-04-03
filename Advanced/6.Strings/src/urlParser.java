
import java.util.Scanner;

public class urlParser {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String protocol = "";
        String server = "";
        String resource = "";
        if(str.indexOf("://")<0) {
                System.out.println("Invalid URL");
                return;
        }

        if(str.indexOf("://")>0){
            int ind = str.indexOf("://");
            if(str.indexOf("://", ind+1)>0){
                System.out.println("Invalid URL");
                return;
            }
                protocol = str.substring(0, str.indexOf("://" ));
            String servRes = str.substring(str.indexOf("://")+3, str.length());
            if(servRes .indexOf("/")> 0){
                server = servRes .substring(0, servRes.indexOf("/" ));
                resource = servRes .substring(servRes.indexOf("/")+1, servRes.length());
            }
            else{
                server = servRes ;
                resource = "";

            }
        }
        else{
            protocol = "";
            if(str .indexOf("/")> 0){
                server = str.substring(0, str.indexOf("/" ));
                resource = str.substring(str.indexOf("/")+1, str .length());
            }
            else{
                server = str ;
                resource = "";
            }
        }
        System.out.printf("Protocol = %s\n" +
                "Server = %s\n" +
                "Resources = %s", protocol,server,resource);

    }

}
