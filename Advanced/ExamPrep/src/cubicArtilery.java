import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;

public class cubicArtilery {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer bunkerCapacity = Integer.parseInt(reader.readLine());
        String line = reader.readLine();
        ArrayDeque<String> bunkers = new ArrayDeque<>();
        Map<String, ArrayDeque<Integer>> bunkersIntake = new LinkedHashMap<>();

        StringBuilder output = new StringBuilder("");

        while(!line.equals("Bunker Revision")){
            String[] tokens = line.split(" ");
            for(int i = 0; i< tokens.length; i++){
                if(Character.isLetter(tokens[i].charAt(0))){
                    bunkers.offer(tokens[i]);
                    bunkersIntake.put(tokens[i], new ArrayDeque<>());
                }

                if(Character.isDigit(tokens[i].charAt(0))){
                    Integer weapon = Integer.parseInt(tokens[i]);
                    String bunker = bunkers.peek();
                    ArrayDeque<Integer> intake = bunkersIntake.get(bunker);
                    int sum = 0;
                    for (Integer s : intake) {
                        sum += s;
                    }
                    if (sum + weapon <= bunkerCapacity){
                        intake.offer(weapon);
                        bunkersIntake.put(bunker, intake);
                    }
                    else {
                        if (bunkers.size() == 1) {
                              while (sum + weapon > bunkerCapacity) {
                                  if(intake.size()==0) {
                                      break;
                                  }
                                  intake.poll();
                                  sum = 0;
                                  for (Integer s : intake) {
                                      sum += s;

                                  }
                                }
                                if(weapon <= bunkerCapacity) {
                                    intake.offer(weapon);
                                }
                                bunkersIntake.put(bunker, intake);

                        }
                        else{
                            bunkers.poll();
                            if (!intake.isEmpty()) {
                                output.append(bunker + " -> " + intake.toString().replaceAll("[\\[\\]]", "") + "\n");
                            } else {
                               output.append(bunker + " -> Empty\n");
                            }
                            i--;
                        }
                    }

                }
            }
            line = reader.readLine();
        }
        System.out.println(output.toString());
    }
}
