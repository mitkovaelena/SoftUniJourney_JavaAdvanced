import java.util.Scanner;

public class firstOddEvenElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split("[ ]+");
        String[] commands = scanner.nextLine().split("[ ]+");
        Print(arr,commands);
    }

    public static void Print(String[] arr, String[] commands){
        int printed = 0;
        for (int i = 0; i < arr.length; i++) {
            if(Integer.parseInt(arr[i]) % 2 == 0 && commands[2].equals("even") && printed < Integer.parseInt(commands[1])){
                System.out.printf("%s ",arr[i]);
                printed++;
            }
            else if(Integer.parseInt(arr[i]) % 2 != 0 && commands[2].equals("odd") && printed < Integer.parseInt(commands[1])){
                System.out.printf("%s ",arr[i]);
                printed++;
            }
        }
    }
}

