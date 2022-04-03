package e01_Logger.models;

import e01_Logger.interfaces.File;

public class LogFile implements File {
    private StringBuilder input;

    public LogFile() {
        this.input = new StringBuilder();
    }

    public void write(String message){
        input.append(message);
    }

    public int getSize(){
        int sum = 0;
            for(Character ch : this.input.toString().toCharArray()){
                if (ch >= 65 && ch <= 122) {
                    sum += (int) ch;
                }
            }

        return sum;
    }
}
