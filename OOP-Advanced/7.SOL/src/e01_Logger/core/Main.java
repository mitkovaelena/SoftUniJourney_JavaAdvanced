package e01_Logger.core;

import e01_Logger.interfaces.Appender;
import e01_Logger.interfaces.Logger;
import e01_Logger.models.ReportLevel;
import e01_Logger.models.loggers.MessageLogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Controller controller = new Controller();
        List<Appender> appenders = new ArrayList<>();

        int count = Integer.parseInt(reader.readLine());

        for (int i = 0; i < count; i++) {
            Appender appender = controller.readAppender(reader.readLine().split(" "));
            appenders.add(appender);
        }

        Logger logger = new MessageLogger(appenders.toArray(new Appender[appenders.size()]));

        String command;

        while (!"END".equals(command = reader.readLine())) {
            String[] commandArgs = command.split("\\|");
            controller.invokeAppendersMethod(logger, ReportLevel.valueOf(commandArgs[0]), commandArgs[1],commandArgs[2]);
        }

        System.out.println(logger);
    }
}
