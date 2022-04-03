package e02_Blobs.interfaces;

import java.lang.reflect.InvocationTargetException;

public interface Command {

    void execute(String... params) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException;
}
