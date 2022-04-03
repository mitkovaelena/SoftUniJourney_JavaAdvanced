import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");

        ArrayDeque<String> numbersQueue = new ArrayDeque<>();
        ArrayDeque<String> operatorStack = new ArrayDeque<>();

        for(String token : tokens){
            if(isNumeric(token)){
                numbersQueue.add(token);
            }
            else{
                if(operatorStack.size()==0) operatorStack.push(token);
                else{
                    if(token.equals(")")){
                        String poppedOperator = operatorStack.pop();
                        while (!poppedOperator.equals("(")) {
                            numbersQueue.add(poppedOperator);
                            poppedOperator = operatorStack.pop();
                        }
                    }
                    else if(isCrntPrior(token, operatorStack.peek())){
                        operatorStack.push(token);
                    }
                    else{
                        numbersQueue.add(operatorStack.pop());
                        operatorStack.push(token);
                    }
                }
            }
        }
        while (operatorStack.size()>0){
            numbersQueue.add(operatorStack.pop());
        }
        while (numbersQueue.size()>0){
            String poppedEl = numbersQueue.poll();
            if(isNumeric(poppedEl)){
                operatorStack.push(poppedEl);
            }
            else{
                String first =  operatorStack.pop();
                String second =  operatorStack.pop();
                operatorStack.push(operation(poppedEl,first,second));
            }
        }
        System.out.printf("%.2f",Double.parseDouble(operatorStack.pop()));
    }
    public static boolean isNumeric(String str)
    {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }
    public static boolean isCrntPrior(String crnt, String prev)
    {
        switch (crnt){
            case "-":
            case "+":
                if(prev.equals("(") ) return true;
                return false;
            case "*":
            case "/":
                if(prev.equals("-") || prev.equals("+") || prev.equals("(")) return true;
                return false;
            case "^":
            case "(":
                return true;

        }
        return true;
    }

    public static String operation(String operator, String first, String second) {
        switch (operator){
            case "-":
                return String.valueOf(Double.parseDouble(second)-Double.parseDouble(first));

            case "+":
                return String.valueOf(Double.parseDouble(second)+Double.parseDouble(first));
            case "*":
                return String.valueOf(Double.parseDouble(second)*Double.parseDouble(first));
            case "/":
                return String.valueOf(Double.parseDouble(second)/Double.parseDouble(first));
        }
        return "0";
    }
}
