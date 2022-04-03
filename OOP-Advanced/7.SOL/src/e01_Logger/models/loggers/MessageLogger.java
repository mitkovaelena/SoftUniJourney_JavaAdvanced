package e01_Logger.models.loggers;

import e01_Logger.interfaces.Appender;
import e01_Logger.interfaces.Logger;
import e01_Logger.models.ReportLevel;

public class MessageLogger implements Logger {

    private Appender[] appenders;

    public MessageLogger(Appender... appenders) {
        this.setAppenders(appenders);
    }

    @Override
    public void logError(String date, String message) {
        for (Appender appender : this.appenders){
            appender.append(date, ReportLevel.ERROR, message);
        }
    }

    @Override
    public void logInfo(String date, String message) {
        for (Appender appender : this.appenders){
            appender.append(date, ReportLevel.INFO, message);
        }
    }

    @Override
    public void logWarning(String date, String message) {
        for (Appender appender : this.appenders){
            appender.append(date, ReportLevel.WARNING, message);
        }
    }

    @Override
    public void logFatal(String date, String message) {
        for (Appender appender : this.appenders){
            appender.append(date, ReportLevel.FATAL, message);
        }
    }

    @Override
    public void logCritical(String date, String message) {
        for (Appender appender : this.appenders){
            appender.append(date, ReportLevel.CRITICAL, message);
        }
    }

    private void setAppenders(Appender[] appenders) {
        if (appenders.length <= 0) {
            throw new IllegalArgumentException("MessageLogger must have at least 1 appender!");
        }
        this.appenders = appenders;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Logger info").append(System.lineSeparator());
        for (Appender appender : appenders) {
            sb.append(appender).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
