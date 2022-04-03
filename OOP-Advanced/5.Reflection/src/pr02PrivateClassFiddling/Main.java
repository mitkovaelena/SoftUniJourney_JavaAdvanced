package pr02PrivateClassFiddling;

import pr02PrivateClassFiddling.com.peshoslav.BlackBoxInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Class blackBoxIntClass = BlackBoxInt.class;
		Field innerValue = blackBoxIntClass.getDeclaredFields()[1];
		innerValue.setAccessible(true);
		Method[] methods = blackBoxIntClass.getDeclaredMethods();

		Constructor constructor =  blackBoxIntClass.getDeclaredConstructor();
		constructor.setAccessible(true);
		BlackBoxInt blackBoxInt = (BlackBoxInt) constructor.newInstance();

		String command;
		while (!"END".equals(command = reader.readLine())) {
			String[] ivokedMethod = command.split("_");
			for( Method method : methods){
				if(method.getName().equals(ivokedMethod[0])){
					method.setAccessible(true);
					method.invoke(blackBoxInt, Integer.parseInt(ivokedMethod[1]));
					System.out.println(innerValue.get(blackBoxInt));
				}
			}
		}
	}
}
