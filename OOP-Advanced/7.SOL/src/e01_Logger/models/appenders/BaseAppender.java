package e01_Logger.models.appenders;

import e01_Logger.models.ReportLevel;
import e01_Logger.interfaces.Appender;
import e01_Logger.interfaces.Layout;

public abstract class BaseAppender implements Appender {
    private ReportLevel reportLevel;
    private Layout layout;
    private int appendedMessages;

    protected BaseAppender(Layout layout) {
        this.layout = layout;
        this.reportLevel = ReportLevel.INFO;
        this.appendedMessages = 0;
    }

    protected Layout getLayout() {
        return layout;
    }

    protected ReportLevel getReportLevel() {
        return reportLevel;
    }

    protected void incrementAppendedMessages() {
        this.appendedMessages += 1;
    }

    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d",
                this.getClass().getSimpleName(), this.getLayout().getClass().getSimpleName(),
                this.getReportLevel().toString(), this.appendedMessages);
    }
}
