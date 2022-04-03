package oneListyIterator;

public class CommandInterpreter {

        private static Listy iterator;

        public CommandInterpreter() {}

        public static void interpretCommand (String[] input) {
            switch (input[0]) {
                case "Create":
                    String[] params = new String[input.length - 1];
                    System.arraycopy(input, 1, params, 0, input.length - 1);
                    iterator = new Listy(params);
                    break;
                case "Move":
                    System.out.println(iterator.move());
                    break;
                case "Print":
                    iterator.print();
                    break;
                case "HasNext":
                    System.out.println(iterator.hasNext());
                    break;
                case "PrintAll":
                    iterator.printAll();
                    break;
                default:
                    break;
            }
        }
}
