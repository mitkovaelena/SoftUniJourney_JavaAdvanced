import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class earthquake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        ArrayDeque<ArrayDeque<Integer>> activities = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] activity =reader.readLine().split("\\s+");
            ArrayDeque<Integer> actDeque = new ArrayDeque<>();
            for (int j = 0; j < activity.length; j++) {
                actDeque.offer(Integer.parseInt(activity[j]));
            }
            activities.offer(actDeque);
        }

        ArrayList<Integer> seismicities = new ArrayList<>();
        while (activities.size() > 0){
            ArrayDeque<Integer> crntAct = activities.poll();
            int seismicity = 0;
            if(crntAct.size()> 0) {
                seismicity = crntAct.poll();
            }
            seismicities.add(seismicity);
            while (crntAct.size()>0) {
                int nextInt = crntAct.peek();
                if(seismicity >= nextInt){
                    crntAct.poll();
                }
                else {
                    if(!crntAct.isEmpty()){
                        activities.offer(crntAct);
                    }
                    break;
                }
            }
        }

        System.out.println(seismicities.size());
        StringBuilder output = new StringBuilder("");
        for (Integer s : seismicities) {
                output.append(s + " ");
        }
        System.out.println(output.toString());
    }
}
