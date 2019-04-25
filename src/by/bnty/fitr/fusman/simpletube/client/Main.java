package by.bnty.fitr.fusman.simpletube.client;

import org.apache.log4j.Logger;

public class Main {
    public static void main(final String[] args) {
        final Logger log = Logger.getLogger(Main.class);
        log.info("Запуск");
        SimpleTube simpleTube = SimpleTube.getSimpleTube();
        log.info("Создан обьект: " + simpleTube);
        log.info("Статус " + simpleTube.getModes());
        log.info("Начал работать");
        simpleTube.run(args);
        log.info("Конец работы");
    }
}
