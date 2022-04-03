import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> commands = new ArrayDeque<>();
        ArrayDeque<String> deletedText = new ArrayDeque<>();

        String text = "";
        for (int i = 0; i < n; i++) {
            String commandStr = scanner.nextLine();
            commands.push(commandStr);
            String[] command = commandStr.split(" ");
            if(command[0].equals("1")){
                text +=command[1];
            }
            else if(command[0].equals("2")){
                deletedText.push(text.substring(text.length()-Integer.parseInt(command[1]), text.length()));
                text = text.substring(0, text.length()-Integer.parseInt(command[1]));
            }
            else if(command[0].equals("3")){
                commands.pop();
                System.out.println(text.charAt(Integer.parseInt(command[1])-1));
            }
            else if(command[0].equals("4")){
                commands.pop();
                command = commands.pop().split(" ");
                if(command[0].equals("1")){
                    int l = text.length()-(command[1].length());
                    text = text.substring(0, l);
                }
                else if(command[0].equals("2")){
                    text += deletedText.pop();
                }

            }
        }

    }
}
