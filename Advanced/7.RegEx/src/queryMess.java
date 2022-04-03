import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class queryMess {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String textLine = reader.readLine();
        while(!textLine.equals("END")){
            String[] line = textLine.split( "[\\?\\&]");
            LinkedHashMap<String,LinkedHashSet<String>> fields = new LinkedHashMap<>();
            String field;
            String value;
            for (String l : line){
                if (l.indexOf("=") > 0) {
                    field = l.split("=")[0];
                    value = l.split("=")[1];

                    field = field.replaceAll( "\\+", " ");
                    field = field.replaceAll( "\\%20", " ");
                    field = field.replaceAll( "\\s+", " ");
                    value = value.replaceAll( "\\+", " ");
                    value = value.replaceAll( "\\%20", " ");
                    value = value.replaceAll( "\\s+", " ");
                    field = field.trim();
                    value = value.trim();

                    LinkedHashSet<String> valueArr = new LinkedHashSet<>();
                    if (fields.containsKey(field))
                        valueArr = fields.get(field);

                    valueArr.add(value);
                    fields.put(field, valueArr);
                }
            }

            String log = "";
            for (String key : fields.keySet()){
                log += String .format("%s=[%s]", key, fields.get(key).toString().replaceAll("\\[|\\]",""));
            }
            System.out.println(log);
            textLine = reader.readLine();
        }
    }
}
