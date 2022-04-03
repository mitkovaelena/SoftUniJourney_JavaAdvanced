package pr01HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Class richSoilLand = RichSoilLand.class;
        Field[] allFields = richSoilLand.getDeclaredFields();

		String command;
		while (!"HARVEST".equals(command = reader.readLine())) {
			switch (command) {
				case "all":
                    Arrays.stream(allFields)
                            .forEachOrdered(x -> System.out.println(String.format("%s %s %s", Modifier.toString(x.getModifiers()), x.getType().getSimpleName(), x.getName())));
					break;
				case "private":
					executePrintCommand(allFields, Modifier.PRIVATE);
					break;
				case "protected":
					executePrintCommand(allFields, Modifier.PROTECTED);
					break;
				case "public":
					executePrintCommand(allFields, Modifier.PUBLIC);
					break;
			}
		}
	}

    public static void executePrintCommand(Field[] allFields, int modifier){
        Arrays.stream(allFields).filter(x-> modifier ==(x.getModifiers()))
                .forEachOrdered(x -> System.out.println(String.format("%s %s %s", Modifier.toString(x.getModifiers()),  x.getType().getSimpleName(), x.getName())));
    }
}
