package e01_Logger.models.appenders;

import e01_Logger.models.LogFile;
import e01_Logger.models.ReportLevel;
import e01_Logger.interfaces.File;
import e01_Logger.interfaces.Layout;

public class FileAppender extends BaseAppender {
    private File logFile;

    public FileAppender(Layout layout) {
        super(layout);
        this.logFile = new LogFile();
    }

    public void setFile(File logFile) {
        this.logFile = logFile;
    }

    @Override
    public void append(String date, ReportLevel reportLvl, String message){
        if (reportLvl.compareTo(super.getReportLevel()) >= 0) {
            this.logFile.write(this.getLayout().defineFormat(date, reportLvl.toString(), message));
            super.incrementAppendedMessages();
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", File size: " + this.logFile.getSize();
    }
}
