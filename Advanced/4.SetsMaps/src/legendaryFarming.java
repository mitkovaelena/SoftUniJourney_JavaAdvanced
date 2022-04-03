import java.util.*;

public class legendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, Integer> keyMaterials = new TreeMap<>();
        TreeMap<String, Integer> junk = new TreeMap<>();

        keyMaterials.put("shards" , 0);
        keyMaterials.put("fragments" , 0);
        keyMaterials.put("motes" , 0);

            while (true) {
                Integer quantity = Integer.parseInt(scanner.next());
                String material = scanner.next().toLowerCase();

                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                    if (keyMaterials.containsKey(material)) {
                        keyMaterials.put(material, keyMaterials.get(material) + quantity);
                    } else {
                        keyMaterials.put(material, quantity);
                    }
                } else {
                    if (junk.containsKey(material)) {
                        junk.put(material, junk.get(material) + quantity);
                    } else {
                        junk.put(material, quantity);
                    }
                }

                if (keyMaterials.get("shards") >= 250 || keyMaterials.get("fragments") >= 250 || keyMaterials.get("motes") >= 250) {

                    if (keyMaterials.get("shards") >= 250) {
                        System.out.println("Shadowmourne obtained!");
                        keyMaterials.put("shards", keyMaterials.get("shards")-250);
                        Map<String, Integer> sorted = new LinkedHashMap<String, Integer>();
                        keyMaterials.entrySet().stream()
                                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                                .forEachOrdered(x -> sorted.put(x.getKey(), x.getValue()));

                        for (String m : sorted.keySet()) {
                            System.out.println(m + ": " + sorted.get(m));
                        }
                    } else if (keyMaterials.get("fragments") >= 250) {
                        System.out.println("Valanyr obtained!");
                        keyMaterials.put("fragments", keyMaterials.get("fragments")-250);
                        Map<String, Integer> sorted = new LinkedHashMap<String, Integer>();
                        keyMaterials.entrySet().stream()
                                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                                .forEachOrdered(x -> sorted.put(x.getKey(), x.getValue()));

                        for (String m : sorted.keySet()) {
                            System.out.println(m + ": " + sorted.get(m));
                        }
                    } else if (keyMaterials.get("motes") >= 250) {
                        System.out.println("Dragonwrath obtained!");
                        keyMaterials.put("motes", keyMaterials.get("motes")-250);
                        Map<String, Integer> sorted = new LinkedHashMap<String, Integer>();
                        keyMaterials.entrySet().stream()
                                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                                .forEachOrdered(x -> sorted.put(x.getKey(), x.getValue()));

                        for (String m : sorted.keySet()) {
                            System.out.println(m + ": " + sorted.get(m));
                        }
                    }

                    for (String m : junk.keySet()) {
                        System.out.println(m + ": " + junk.get(m));
                    }
                    return;
                }
            }
    }
}
