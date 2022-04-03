package e01_Logger.models.layouts;

import e01_Logger.interfaces.Layout;

public class XmlLayout implements Layout {

    public XmlLayout() {
    }

    @Override
    public String defineFormat(String date, String reportLvl, String message) {
        return String.format("<log>%n   <date>%s</date>%n   <level>%s</level>%n   <message>%s</message>%n</log>",
                date, reportLvl, message);
    }
}
