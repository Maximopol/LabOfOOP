package by.bnty.fitr.fusman.simpletube.client;

import by.bnty.fitr.fusman.simpletube.client.mode.Modes;
import by.bnty.fitr.fusman.simpletube.videoexample.VideoExample;
import org.apache.log4j.Logger;

public class SimpleTube {
    //private static final String VERSION = "0.0.1";
    private static final Logger log = Logger.getLogger(SimpleTube.class);
    private static SimpleTube simpleTube;
    private Modes modes;

    private SimpleTube() {
        modes = Modes.Offline;
    }

    public static SimpleTube getSimpleTube() {
        return simpleTube == null ? simpleTube = new SimpleTube() : simpleTube;
    }

    public void run(String[] args) {

        VideoExample.startter(args);

    }

    public Modes getModes() {
        return modes;
    }

    public void setModes(Modes modes) {
        this.modes = modes;
    }
}
