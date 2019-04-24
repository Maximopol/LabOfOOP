package by.bnty.fitr.fusman.simpletube.client;

import by.bnty.fitr.fusman.simpletube.client.mode.Modes;
import org.apache.log4j.Logger;

public class SimpleTube {
    private static final Logger log = Logger.getLogger(SimpleTube.class);
    private static SimpleTube simpleTube;
    private Modes modes;

    private SimpleTube() {
        modes = Modes.Offline;
    }

    public static SimpleTube getSimpleTube() {
        return simpleTube == null ? simpleTube = new SimpleTube() : simpleTube;
    }

    public static void main(String[] args) {
        log.info("Запуск");
        SimpleTube simpleTube = SimpleTube.getSimpleTube();
        log.info("Создан обьект: " + simpleTube);
        log.info("Статус " + simpleTube.modes);
        log.info("Начал работать");
        simpleTube.run();
    }

    public void run() {

    }

    public Modes getModes() {
        return modes;
    }
}
