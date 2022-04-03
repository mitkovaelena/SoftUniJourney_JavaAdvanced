package reflectionClass;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

//Field field = reflection.getDeclaredField("name");
//field.setAccessible(true)
//
//Field modifiersField = Dield.class.getDeclaredField("modifiers");
//modifiersField.setAccessible(true)
//modifiersField.setInt(field, field.getModifiers & ~Modifier.FINAL) -> vs FINAL stavat non-final

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<Reflection> reflection = Reflection.class;
//        System.out.println(reflection);
//        System.out.println(reflection.getSuperclass());
//        Class[] interfaces = reflection.getInterfaces();
//
//        for(Class intef : interfaces){
//            System.out.println(intef);
//        }
//
//        Reflection instance = reflection.newInstance();
//        System.out.println(instance);

        Field[] fields = reflection.getDeclaredFields();
        Arrays.sort(fields, (m1, m2) -> m1.getName().compareTo(m2.getName()));
        Arrays.stream(fields).filter(x-> !Modifier.isPrivate(x.getModifiers()))
                .forEachOrdered(x -> System.out.println(String.format("%s must be private!", x.getName())));


        Method[] methods = reflection.getDeclaredMethods();
        Arrays.sort(methods, (m1, m2) -> m1.getName().compareTo(m2.getName()));

        Arrays.stream(methods).filter(x-> x.getName().startsWith("get")).filter(x-> !Modifier.isPublic(x.getModifiers()))
                .forEachOrdered(x -> System.out.println(String.format("%s have to be public!", x.getName())));

        Arrays.stream(methods).filter(x-> x.getName().startsWith("set")).filter(x-> !Modifier.isPrivate(x.getModifiers()))
                .forEachOrdered(x -> System.out.println(String.format("%s have to be private!", x.getName())));
    }
}
