package codingTracker;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tracker {

    @Author(name = "Eli")
    public static void printMethodsByAuthor(Class<?> cl){
        Map<String, List<String>> methodsByAuthor = new HashMap<>();

        Method[] methods = cl.getDeclaredMethods();
        for(Method method : methods){
            Author author = method.getAnnotation(Author.class);
            if(author != null){
                methodsByAuthor.putIfAbsent(author.name(), new ArrayList<>());
                List<String> temp = methodsByAuthor.get(author.name());
                temp.add(method.getName());
                methodsByAuthor.put(author.name(), temp);
            }
        }

        for(String a : methodsByAuthor.keySet()){
            System.out.println(a + ": " + methodsByAuthor.get(a).toString().replaceAll("[\\[\\]]", ""));
        }
    }

    @Author(name = "Eli")
    public static void main(String[] args) {
        Tracker.printMethodsByAuthor(Tracker.class);
    }
}
