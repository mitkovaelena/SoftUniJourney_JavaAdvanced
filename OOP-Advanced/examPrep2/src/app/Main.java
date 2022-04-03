package app;

import app.waste_disposal.engines.Engine;

public class Main {
    public static void main(String[] args) {
        Runnable engine = new Engine();
        engine.run();
    }
}
