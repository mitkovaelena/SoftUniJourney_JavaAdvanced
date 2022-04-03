package e01_Logger.models.appenders;

import e01_Logger.models.ReportLevel;
import e01_Logger.interfaces.Layout;

public class ConsoleAppender extends BaseAppender {

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String date, ReportLevel reportLvl, String message){
        if (reportLvl.compareTo(super.getReportLevel()) >= 0) {
            System.out.println(super.getLayout().defineFormat(date, reportLvl.toString(), message));
            super.incrementAppendedMessages();
        }
    }
}
