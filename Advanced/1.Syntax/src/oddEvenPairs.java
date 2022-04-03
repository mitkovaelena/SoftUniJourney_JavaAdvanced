import java.util.Scanner;

public class oddEvenPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String array = scanner.nextLine();
        String[] arr = array.split(" ");
        if(arr.length % 2 != 0){
             System.out.printf("invalid length");
            return;
        }
        for (int i = 0; i < arr.length-1; i+=2) {
            if(Integer.parseInt(arr[i]) % 2 == 0 && Integer.parseInt(arr[i+1]) % 2 == 0 ){
                System.out.printf("%s, %s -> both are even\n",arr[i], arr[i+1]);
            }
            else  if(Integer.parseInt(arr[i]) % 2 == 1 && Integer.parseInt(arr[i+1]) % 2 == 1 ){
                System.out.printf("%s, %s -> both are odd\n",arr[i], arr[i+1]);
            }
            else{
                System.out.printf("%s, %s -> different\n",arr[i], arr[i+1]);
            }
        }
    }
}
