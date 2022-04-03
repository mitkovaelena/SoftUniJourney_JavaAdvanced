import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class highscore {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, ArrayList<String>> playersInfo = new LinkedHashMap<>();
        LinkedHashMap<String, Long> highscoresInfo = new LinkedHashMap<>();

        while (true) {
            String inputline = reader.readLine();
            if (inputline.equals("osu!")) break;

            String[] line = inputline.split("<->");
            String[] opponent1 = line[0].split(" ");
            String[] opponent2 = line[1].split(" ");

            String opp1Name = opponent1[1];
            Long opp1Score = Long.parseLong(opponent1[0]);
            String opp2Name = opponent2[0];
            Long opp2Score = Long.parseLong(opponent2[1]);

            highscoresInfo.putIfAbsent(opp1Name, 0L);
            highscoresInfo.putIfAbsent(opp2Name, 0L);
            playersInfo.putIfAbsent(opp1Name, new ArrayList<String>());
            playersInfo.putIfAbsent(opp2Name, new ArrayList<String>());

            highscoresInfo.put(opp1Name, highscoresInfo.get(opp1Name) + opp1Score - opp2Score);
            highscoresInfo.put(opp2Name, highscoresInfo.get(opp2Name) + opp2Score - opp1Score);
            playersInfo.get(opp1Name).add(String.format("*   %s <-> %d", opp2Name, opp1Score - opp2Score));
            playersInfo.get(opp2Name).add(String.format("*   %s <-> %d", opp1Name, opp2Score - opp1Score));
        }

        Map<String, Long> sortedHighscores = new LinkedHashMap<String, Long>();
        highscoresInfo.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEachOrdered(x -> sortedHighscores.put(x.getKey(), x.getValue()));

        StringBuilder output = new StringBuilder();
        for (String player : sortedHighscores.keySet()) {
            output.append(player + " - (" + sortedHighscores.get(player) + ")\n");
            for (String opponent : playersInfo.get(player)) {
                output.append(opponent + "\n");
            }
        }
        System.out.println(output);
    }
}
