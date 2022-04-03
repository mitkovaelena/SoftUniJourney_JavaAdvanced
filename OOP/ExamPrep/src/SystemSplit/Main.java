package SystemSplit;

import SystemSplit.Components.TheSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(java.lang.System.in));
        TheSystem theSystem = new TheSystem();

        while (true) {
            String[] commandLine = scan.readLine().replace(")", "").split("\\(");

            if (commandLine[0].equals("System Split")) {
                System.out.print(theSystem.split());
                break;
            }

            String[] command = new String[4];
            if(commandLine.length>1) {
                command = commandLine[1].split(", ");
            }
            switch (commandLine[0]) {
                case "RegisterPowerHardware":
                    theSystem.registerPowerHardware(command[0], Integer.parseInt(command[1]), Integer.parseInt(command[2]));
                     break;
                case "RegisterHeavyHardware":
                    theSystem.registerHeavyHardware(command[0], Integer.parseInt(command[1]), Integer.parseInt(command[2]));
                    break;
                case "RegisterLightSoftware":
                    theSystem.registerLightSoftware(command[0],command[1], Integer.parseInt(command[2]), Integer.parseInt(command[3]));
                    break;
                case "RegisterExpressSoftware":
                    theSystem.registerExpressSoftware(command[0],command[1], Integer.parseInt(command[2]), Integer.parseInt(command[3]));
                    break;
                case "ReleaseSoftwareComponent":
                    theSystem.releaseSoftwareComponent(command[0],command[1]);
                    break;
                case "Analyze":
                    System.out.print(theSystem.analyze());
                    break;
                case "Dump":
                    theSystem.dump(command[0]);
                    break;
                case "Restore":
                    theSystem.restore(command[0]);
                    break;
                case "Destroy":
                    theSystem.destroy(command[0]);
                    break;
                case "DumpAnalyze":
                    System.out.print(theSystem.dumpAnalyze());
                    break;
                default:
                    break;
            }
        }
    }
}
