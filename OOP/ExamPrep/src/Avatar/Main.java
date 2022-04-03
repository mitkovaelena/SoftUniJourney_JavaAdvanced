package Avatar;

import Avatar.benders.*;
import Avatar.monuments.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        List<AirBender> airBenders = new ArrayList<>();
        List<FireBender> fireBenders = new ArrayList<>();
        List<EarthBender> earthBenders = new ArrayList<>();
        List<WaterBender> waterBenders = new ArrayList<>();

        List<AirMonument> airMonuments = new ArrayList<>();
        List<WaterMonument> waterMonuments = new ArrayList<>();
        List<FireMonument> fireMonuments = new ArrayList<>();
        List<EarthMonument> earthMonuments = new ArrayList<>();

        StringBuilder wars = new StringBuilder();
        int warCounter = 0;

        while(true) {
            String[] input = scan.readLine().split("\\s+");
            if (input[0].trim().equalsIgnoreCase("quit")) {
                System.out.println(wars.toString().trim());
                break;
            }

            switch (input[0].trim().toLowerCase()) {
                case "bender":

                    if (input[1].equalsIgnoreCase("water")) {
                       WaterBender bender = new WaterBender(input[2], Integer.valueOf(input[3]), Double.valueOf(input[4]));
                       waterBenders.add(bender);
                    } else if (input[1].equalsIgnoreCase("air")) {
                        AirBender bender = new AirBender(input[2], Integer.valueOf(input[3]), Double.valueOf(input[4]));
                        airBenders.add(bender);
                    } else if (input[1].equalsIgnoreCase("earth")) {
                        EarthBender bender = new EarthBender(input[2], Integer.valueOf(input[3]), Double.valueOf(input[4]));
                        earthBenders.add(bender);
                    } else {
                        FireBender bender = new FireBender(input[2], Integer.valueOf(input[3]), Double.valueOf(input[4]));
                        fireBenders.add(bender);
                    }
                    break;
                case "monument":
                    if (input[1].equalsIgnoreCase("water")) {
                        WaterMonument monument = new WaterMonument(input[2], Integer.valueOf(input[3]));
                        waterMonuments.add(monument);
                    } else if (input[1].equalsIgnoreCase("air")) {
                        AirMonument monument = new AirMonument(input[2], Integer.valueOf(input[3]));
                        airMonuments.add(monument);
                    } else if (input[1].equalsIgnoreCase("earth")) {
                        EarthMonument monument = new EarthMonument(input[2], Integer.valueOf(input[3]));
                        earthMonuments.add(monument);
                    } else {
                        FireMonument monument = new FireMonument(input[2], Integer.valueOf(input[3]));
                        fireMonuments.add(monument);
                    }
                    break;
                case "status":
                    System.out.println(input[1].trim() + " Nation");
                    if (input[1].trim().equalsIgnoreCase("water")) {
                        if (waterBenders.isEmpty()) {
                            System.out.println("Benders: None");
                        } else {
                            System.out.println("Benders:");
                            waterBenders.forEach(waterBender -> System.out.println("###" + waterBender));
                        }

                        if (waterMonuments.isEmpty()) {
                            System.out.println("Monuments: None");
                        } else {
                            System.out.println("Monuments:");
                            waterMonuments.forEach(waterMonument-> System.out.println("###" + waterMonument));
                        }
                    } else if (input[1].trim().equalsIgnoreCase("air")) {
                        if (airBenders.isEmpty()) {
                            System.out.println("Benders: None");
                        } else {
                            System.out.println("Benders:");
                            airBenders.forEach(airBender -> System.out.println("###" + airBender));
                        }

                        if (airMonuments.isEmpty()) {
                            System.out.println("Monuments: None");
                        } else {
                            System.out.println("Monuments:");
                            airMonuments.forEach(airMonument -> System.out.println("###" + airMonument));
                        }
                    } else if (input[1].trim().equalsIgnoreCase("earth")) {
                        if (earthBenders.isEmpty()) {
                            System.out.println("Benders: None");
                        } else {
                            System.out.println("Benders:");
                            earthBenders.forEach(earthBender -> System.out.println("###" + earthBender));
                        }

                        if (earthMonuments.isEmpty()) {
                            System.out.println("Monuments: None");
                        } else {
                            System.out.println("Monuments:");
                            earthMonuments.forEach(earthMonument-> System.out.println("###" + earthMonument));
                        }
                    } else if (input[1].trim().equalsIgnoreCase("fire")){
                        if (fireBenders.isEmpty()) {
                            System.out.println("Benders: None");
                        } else {
                            System.out.println("Benders:");
                            fireBenders.forEach(fireBender -> System.out.println("###" + fireBender));
                        }

                        if (fireMonuments.isEmpty()) {
                            System.out.println("Monuments: None");
                        } else {
                            System.out.println("Monuments:");
                            fireMonuments.forEach(fireMonument -> System.out.println("###" + fireMonument));
                        }
                    }
                    break;
                case "war":
                    warCounter++;
                    wars.append("War ").append(warCounter).append(" ").append("issued by ").append(input[1]).append("\n");

                    Double airTotal = airBenders.stream().mapToDouble((x) -> (x.getPower() * x.getAerialIntegrity())).sum();
                    Double waterTotal = waterBenders.stream().mapToDouble((x) -> (x.getPower() * x.getWaterClarity())).sum();
                    Double fireTotal = fireBenders.stream().mapToDouble((x) -> (x.getPower() * x.getHeatAggression())).sum();
                    Double earthTotal = earthBenders.stream().mapToDouble((x) -> (x.getPower() * x.getGroundSaturation())).sum();

                    Long airMonumentSum = airMonuments.stream().mapToLong((x) -> x.getAirAffinity()).sum();
                    Long waterMonumentSum = waterMonuments.stream().mapToLong((x) -> x.getWaterAffinity()).sum();
                    Long fireMonumentSum = fireMonuments.stream().mapToLong((x) -> x.getFireAffinity()).sum();
                    Long earthMonumentSum = earthMonuments.stream().mapToLong((x) -> x.getEarthAffinity()).sum();


                    airTotal += ((airTotal / 100) * airMonumentSum);
                    earthTotal += ((earthTotal / 100) * earthMonumentSum);
                    waterTotal += ((waterTotal / 100) * waterMonumentSum);
                    fireTotal += ((fireTotal / 100) * fireMonumentSum);

                    if (airTotal > earthTotal && airTotal > waterTotal && airTotal > fireTotal) {
                        earthBenders.clear();
                        earthMonuments.clear();

                        waterBenders.clear();
                        waterMonuments.clear();

                        fireBenders.clear();
                        fireMonuments.clear();
                    } else if (earthTotal > waterTotal && earthTotal > airTotal && earthTotal > fireTotal) {
                        airBenders.clear();
                        airMonuments.clear();

                        waterBenders.clear();
                        waterMonuments.clear();

                        fireBenders.clear();
                        fireMonuments.clear();
                    } else if (waterTotal > earthTotal && waterTotal > airTotal && waterTotal > fireTotal) {
                        airBenders.clear();
                        airMonuments.clear();

                        earthBenders.clear();
                        earthMonuments.clear();

                        fireBenders.clear();
                        fireMonuments.clear();
                    } else if (fireTotal > earthTotal && fireTotal > airTotal && fireTotal > waterTotal) {
                        airBenders.clear();
                        airMonuments.clear();

                        earthBenders.clear();
                        earthMonuments.clear();

                        waterBenders.clear();
                        waterMonuments.clear();
                    }

                    break;
            }
        }
    }
}
