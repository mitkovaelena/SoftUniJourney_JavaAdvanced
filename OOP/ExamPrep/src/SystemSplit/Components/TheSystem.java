package SystemSplit.Components;

import SystemSplit.Components.HardwareComponents.HardwareComponent;
import SystemSplit.Components.HardwareComponents.HeavyHardwareComponent;
import SystemSplit.Components.HardwareComponents.PowerHardwareComponent;
import SystemSplit.Components.SoftwareComponents.ExpressSoftwareComponent;
import SystemSplit.Components.SoftwareComponents.LightSoftwareComponent;
import SystemSplit.Components.SoftwareComponents.SoftwareComponent;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TheSystem {
    private Map<String,HardwareComponent> hardwareComponents ;
    private Map<String,SoftwareComponent> softwareComponents;
    private Map<String ,ArrayList<SoftwareComponent>> hardwareToSoftware;
    private Map<String ,ArrayList<SoftwareComponent>> dumpedHardwareToSoftware;
    private Map<String,HardwareComponent> dumpedHCs;

    public TheSystem() {
        this.hardwareComponents = new LinkedHashMap<>();
        this.softwareComponents = new LinkedHashMap<>();
        this.hardwareToSoftware = new LinkedHashMap<>();
        this.dumpedHardwareToSoftware = new LinkedHashMap<>();
        this.dumpedHCs = new LinkedHashMap<>();
    }

    public void registerPowerHardware(String name, int capacity, int memory){
        PowerHardwareComponent phc = new PowerHardwareComponent(name,capacity,memory);
        hardwareComponents.put(name,phc);
        hardwareToSoftware.put(name, new ArrayList<>());
    }

	public void registerHeavyHardware(String name, int capacity, int memory){
        HeavyHardwareComponent hhc = new HeavyHardwareComponent(name,capacity,memory);
        hardwareComponents.put(name,hhc);
        hardwareToSoftware.put(name, new ArrayList<>());
    }

	public void registerExpressSoftware(String hardwareComponentName, String name, int capacity, int memory){
	    try{
        ExpressSoftwareComponent esc = new ExpressSoftwareComponent(name, capacity, memory);
        hardwareComponents.get(hardwareComponentName).registerSoftwareComponent(esc);
        softwareComponents.put(name,esc);

        ArrayList<SoftwareComponent> temp = hardwareToSoftware.get(hardwareComponentName);
        temp.add(softwareComponents.get(name));
        hardwareToSoftware.put(hardwareComponentName, temp);
        } catch (IllegalArgumentException iae){

        }
    }

	public void registerLightSoftware(String hardwareComponentName, String name, int capacity, int memory){
	    try {
            LightSoftwareComponent lsc = new LightSoftwareComponent(name, capacity, memory);
            hardwareComponents.get(hardwareComponentName).registerSoftwareComponent(lsc);
            softwareComponents.put(name, lsc);

            if (!hardwareToSoftware.containsKey(hardwareComponentName)) {
                hardwareToSoftware.put(hardwareComponentName, new ArrayList<SoftwareComponent>());
            }

            ArrayList<SoftwareComponent> temp = hardwareToSoftware.get(hardwareComponentName);
            temp.add(softwareComponents.get(name));
            hardwareToSoftware.put(hardwareComponentName, temp);
        } catch (IllegalArgumentException iae){

        }
    }

	public void releaseSoftwareComponent(String hardwareComponentName, String softwareComponentName){
            if (hardwareToSoftware.containsKey(hardwareComponentName) && hardwareToSoftware.get(hardwareComponentName).contains(softwareComponents.get(softwareComponentName))) {
                hardwareToSoftware.get(hardwareComponentName).remove(softwareComponents.get(softwareComponentName));
                hardwareComponents.get(hardwareComponentName).removeSoftwareComponent(softwareComponents.get(softwareComponentName));
            }
    }

	public String analyze(){

        int totalMemoryLeft = 0;
        int totalMemory = 0;
        int totalCapacityLeft = 0;
        int totalCapacity = 0;

        for (String hc : hardwareComponents.keySet()){
            totalMemory += hardwareComponents.get(hc).getMaxMemory();
            totalCapacity += hardwareComponents.get(hc).getMaxCapacity();
            totalMemoryLeft += hardwareComponents.get(hc).getMemory();
            totalCapacityLeft += hardwareComponents.get(hc).getCapacity();
        }

	    return String.format("System Analysis\n" +
                "Hardware Components: %d\n" +
                "Software Components: %d\n" +
                "Total Operational Memory: %d / %d\n" +
                "Total Capacity Taken: %d / %d\n",
                hardwareComponents.size(), softwareComponents.size(),
                totalMemory-totalMemoryLeft, totalMemory,
                totalCapacity-totalCapacityLeft, totalCapacity);
    }

	public String split(){
	    StringBuilder output = new StringBuilder("");

        Map<String, HardwareComponent> sortedHCs = new LinkedHashMap<String, HardwareComponent>();
        hardwareComponents.entrySet().stream()
                .filter(x -> x.getValue().getType().equals("Power"))
                .forEachOrdered(x -> sortedHCs.put(x.getKey(), x.getValue()));
        hardwareComponents.entrySet().stream()
                .filter(x -> x.getValue().getType().equals("Heavy"))
                .forEachOrdered(x -> sortedHCs.put(x.getKey(), x.getValue()));

	    for(String hcName : sortedHCs.keySet()){
	        output.append("Hardware Component - " + hcName +"\n");
	        output.append("Express Software Components - "+ hardwareToSoftware.get(hcName).stream().filter(x -> x.getType().equals("Express")).count()+"\n");
	        output.append("Light Software Components - "+ hardwareToSoftware.get(hcName).stream().filter(x -> x.getType().equals("Light")).count()+"\n");

            int userdMemory = hardwareComponents.get(hcName).getMaxMemory()-hardwareComponents.get(hcName).getMemory();
            output.append("Memory Usage: "+ userdMemory +" / "+hardwareComponents.get(hcName).getMaxMemory() +"\n");

            int capacityTaken = hardwareComponents.get(hcName).getMaxCapacity()-hardwareComponents.get(hcName).getCapacity();
            output.append("Capacity Usage: "+ capacityTaken +" / "+ hardwareComponents.get(hcName).getMaxCapacity() +"\n");

            String softwareComps= (hardwareToSoftware.get(hcName).size() > 0 )? hardwareToSoftware.get(hcName).stream().map(Component::getName).collect(Collectors.toList()).toString().replaceAll("[\\[\\]]", "") : "None";
            output.append("Type: " + hardwareComponents.get(hcName).getType() + "\n");
            output.append("Software Components: " + softwareComps +"\n");
        }
	    return output.toString();
    }

    public void dump(String hardwareComponentName){
	    if(hardwareComponents.containsKey(hardwareComponentName)) {
            HardwareComponent dumpedHC = hardwareComponents.get(hardwareComponentName);
            hardwareComponents.remove(hardwareComponentName);
            dumpedHCs.put(hardwareComponentName, dumpedHC);

            ArrayList<SoftwareComponent> dumpedSCs = hardwareToSoftware.get(hardwareComponentName);
            hardwareToSoftware.remove(hardwareComponentName);
            dumpedHardwareToSoftware.put(hardwareComponentName, dumpedSCs);

            for (SoftwareComponent softCom : dumpedSCs) {
                softwareComponents.remove(softCom.getName());
            }
        }
    }

    public void restore(String hardwareComponentName){
        if(dumpedHCs.containsKey(hardwareComponentName)) {
            HardwareComponent restoredHC = dumpedHCs.get(hardwareComponentName);
            dumpedHCs.remove(hardwareComponentName);
            hardwareComponents.put(restoredHC.getName(), restoredHC);

            ArrayList<SoftwareComponent> restoredSCs = dumpedHardwareToSoftware.get(hardwareComponentName);
            dumpedHardwareToSoftware.remove(hardwareComponentName);
            hardwareToSoftware.put(hardwareComponentName, restoredSCs);

            for (SoftwareComponent softCom : restoredSCs) {
                softwareComponents.put(softCom.getName(), softCom);
            }
        }
    }

    public void destroy(String hardwareComponentName){
        if(dumpedHCs.containsKey(hardwareComponentName)) {
            dumpedHCs.remove(hardwareComponentName);
            dumpedHardwareToSoftware.remove(hardwareComponentName);
        }
    }

    public String dumpAnalyze(){
        StringBuilder output = new StringBuilder("");

        output.append("Dump Analysis\n");
        output.append("Power Hardware Components: "+ dumpedHCs.entrySet().stream().filter(x -> x.getValue().getType().equals("Power")).count()+"\n");
        output.append("Heavy Hardware Components: "+ dumpedHCs.entrySet().stream().filter(x -> x.getValue().getType().equals("Heavy")).count()+"\n");

        int dumpedES = 0;
        int dumpedLS = 0;
        int dumpedCap = 0;
        int dumpedMem = 0;
        for(String dhcName : dumpedHardwareToSoftware.keySet()){
            for(SoftwareComponent dsc : dumpedHardwareToSoftware.get(dhcName)){
                if(dsc.getType().equals("Express")) dumpedES ++;
                if(dsc.getType().equals("Light")) dumpedLS ++;
                dumpedCap += dsc.getCapacity();
                dumpedMem += dsc.getMemory();
            }
        }

        output.append("Express Software Components: "+ dumpedES +"\n");
        output.append("Light Software Components: "+ dumpedLS +"\n");

        output.append("Total Dumped Memory: " + dumpedMem + "\n");
        output.append("Total Dumped Capacity: " + dumpedCap +"\n");

        return output.toString();
    }

}
