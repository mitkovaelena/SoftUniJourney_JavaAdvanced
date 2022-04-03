import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class criticalBreakpoint {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        Long critRatio = null;
        ArrayList<String> lines = new ArrayList<>();

        while (!line.equals("Break it.")){
            lines.add(line);
            long[] coordinates = Arrays.stream(line.split(" ")).mapToLong(Long::parseLong).toArray();
            Long ratio = Math.abs((coordinates[2]+ coordinates[3]) - (coordinates[1]+ coordinates[0]));
            if(critRatio == null && ratio != 0L){
                critRatio = ratio;
            }
            if(!ratio.equals(critRatio) && ratio != 0L){
                System.out.println("Critical breakpoint does not exist.");
                return;
            }
            line = reader.readLine();
        }

        if(critRatio == null){
            System.out.println("Critical breakpoint does not exist.");
            return;
        }

        BigInteger cb = new BigInteger(critRatio.toString());
        cb = cb.pow(lines.size());
        Integer temp = lines.size();
        BigInteger numLines = new BigInteger(temp.toString());
        cb = cb.divideAndRemainder(numLines)[1];

        for (String l : lines) {
            System.out.println(String.format("Line: [%s]", String.join(", ", l.split(" "))));
        }
        System.out.println("Critical Breakpoint: " + cb.toString());
    }
}
