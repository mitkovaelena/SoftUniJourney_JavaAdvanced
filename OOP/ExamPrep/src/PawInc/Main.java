package PawInc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        AnimalCenterManager acm = new AnimalCenterManager();

        while (true) {
            String commandLine = reader.readLine();
            if (commandLine.equals("Paw Paw Pawah")) {
                acm.printStatistics();
                break;
            }

            String[] commandString = commandLine.split(" \\| ");


            switch (commandString[0]){
                case "RegisterCleansingCenter":
                    acm.registerCleansingCenter(commandString[1]);
                    break;
                case "RegisterAdoptionCenter":
                    acm.registerAdoptionCenter(commandString[1]);
                    break;
                case "RegisterDog":
                    acm.registerDog(commandString[1],Integer.parseInt(commandString[2]),Integer.parseInt(commandString[3]),commandString[4]);
                    break;
                case "RegisterCat":
                    acm.registerCat(commandString[1],Integer.parseInt(commandString[2]),Integer.parseInt(commandString[3]),commandString[4]);
                    break;
                case "SendForCleansing":
                    acm.sendForCleansing(commandString[1],commandString[2]);
                    break;
                case "Cleanse":
                    acm.cleanse(commandString[1]);
                    break;
                case "Adopt":
                    acm.adopt(commandString[1]);
                    break;
                case "RegisterCastrationCenter":
                    acm.registerCastrationCenter(commandString[1]);
                    break;
                case "SendForCastration":
                    acm.sendForCastration(commandString[1], commandString[2]);
                    break;
                case "Castrate":
                    acm.castrate(commandString[1]);
                    break;
                case "CastrationStatistics":{
                    acm.castrationStatistics();
                }

            }

        }

    }
}
