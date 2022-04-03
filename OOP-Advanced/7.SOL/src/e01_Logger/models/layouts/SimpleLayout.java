package e01_Logger.models.layouts;

import e01_Logger.interfaces.Layout;

public class SimpleLayout implements Layout {

    public SimpleLayout() {
    }

    @Override
    public String defineFormat(String date, String reportLvl, String message){
        return date + " - " + reportLvl + " - " + message;
    }
}
