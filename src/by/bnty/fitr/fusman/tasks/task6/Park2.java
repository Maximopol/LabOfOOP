package by.bnty.fitr.fusman.tasks.task6;

import org.apache.log4j.Logger;

public class Park2 {
    private static final int MAX_PLACE_FOR_CAR = 50;
    private static Park2 park;
    final Logger log = Logger.getLogger(Park2.class);
    private Car[] playlist;
    private int count;

    private Park2() {
        log.info("Парковка 2");
        count = 0;
        playlist = new Car[MAX_PLACE_FOR_CAR];
    }

    public synchronized static Park2 getInstance() {
        return park == null ? park = new Park2() : park;
    }

    public synchronized void add(Car t) {
        if (count < MAX_PLACE_FOR_CAR) {
            playlist[count] = t;

            log.info("add " + t);
            log.info("Все занято " + (count + 1) + " из " + MAX_PLACE_FOR_CAR);
            count++;
        } else {
            log.warn("ОТКАЗАНО");
        }
    }
}
