package trafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> trafficLights = new ArrayList<>();

        String[] initialStates = reader.readLine().split("\\s+");
        Integer n = Integer.parseInt(reader.readLine());

        for(String s : initialStates) {
            trafficLights.add(Enum.valueOf(TrafficLight.class, s).ordinal());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < trafficLights.size(); j++) {
                trafficLights.set(j, trafficLights.get(j)+1);
                System.out.printf(TrafficLight.values()[(trafficLights.get(j)) % 3] + " ");

            }
            System.out.println();
        }
    }
}
