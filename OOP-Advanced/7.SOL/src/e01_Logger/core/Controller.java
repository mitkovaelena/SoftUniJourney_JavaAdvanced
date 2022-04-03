package e01_Logger.core;

import e01_Logger.interfaces.Appender;
import e01_Logger.interfaces.Layout;
import e01_Logger.interfaces.Logger;
import e01_Logger.models.ReportLevel;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Controller {
    private static final String APPENDERS_FILE_PATH = "e01_Logger.models.appenders.";
    private static final String LAYOUTS_FILE_PATH = "e01_Logger.models.layouts.";

    public Appender readAppender(String[] input) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        String layoutType = input[1];
        Class<Layout> layoutClass = (Class<Layout>) Class.forName(LAYOUTS_FILE_PATH + layoutType);
        Layout layout = layoutClass.newInstance();

        String appenderType = input[0];
        Class<Appender> appenderClass = (Class<Appender>) Class.forName(APPENDERS_FILE_PATH + appenderType);
        Constructor<Appender> appenderConstructor = appenderClass.getDeclaredConstructor(Layout.class);
        Appender appender = appenderConstructor.newInstance(layout);

        if (input.length > 2) {
            appender.setReportLevel(ReportLevel.valueOf(input[2]));
        }
        return appender;
    }

    public void invokeAppendersMethod(Logger logger, ReportLevel reportLevel, String date, String text) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        String methodName = "log" + reportLevel.name().charAt(0) + reportLevel.name().toLowerCase().substring(1);

        Method method = Logger.class.getDeclaredMethod(methodName, String.class, String.class);
        method.invoke(logger, date, text);
    }
}
