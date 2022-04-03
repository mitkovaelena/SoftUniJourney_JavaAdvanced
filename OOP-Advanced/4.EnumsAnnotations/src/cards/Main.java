package cards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Card, String> deck = new TreeMap<>();

        String name1 = reader.readLine();
        String name2 = reader.readLine();

        while (deck.size() < 10) {
            String name = deck.size()<=5 ? name1 : name2;
            String[] cardStr = reader.readLine().split(" of ");
            try {
                Card card = new Card(cardStr[0], cardStr[1]);
                if (!deck.containsKey(card)) {
                    deck.put(card, name);
                } else {
                    System.out.println("Card is not in the deck.");
                }
            } catch (Exception e) {
                System.out.println("No such card exists.");
            }
        }

        for (Card card : deck.keySet()){
            System.out.println(deck.get(card) + " wins with " + card);
            return;
        }

//        String classType = reader.readLine();
//        Class<?> cardClass = null;
//      switch (classType) {
//          case "Rank":
//              cardClass = CardRank.class;
//              break;
//          case "Suit":
//              cardClass = CardSuit.class;
//              break;
//      }
//
//      Enumeration annotation = cardClass.getAnnotation(Enumeration.class);
//        System.out.printf("Type = Enumeration, Description = %s%n", annotation.description());
//    }
    }
}
