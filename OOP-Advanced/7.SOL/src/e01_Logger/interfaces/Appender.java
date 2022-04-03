package e01_Logger.interfaces;

import e01_Logger.models.ReportLevel;

public interface Appender {

    void append(String date, ReportLevel reportLvl, String message);

    void setReportLevel(ReportLevel reportLevel);
}
