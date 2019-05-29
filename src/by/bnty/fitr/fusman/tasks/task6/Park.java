package by.bnty.fitr.fusman.tasks.task6;

import by.bnty.fitr.fusman.labs.lab10.arrays.common.Storage;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class Park extends Storage<Car> {
    private static final int MAX_PLACE_FOR_CAR = 50;
    private static Park park;
    final Logger log = Logger.getLogger(Park.class);

    private Park() {
        log.info("Парковка 1");
        playlist = new ArrayList<>();
    }

    public synchronized static Park getInstance() {
        return park == null ? park = new Park() : park;
    }

    public void add(Car t) {
        if (playlist.size() < MAX_PLACE_FOR_CAR) {
            playlist.add(t);
            log.info("add " + t);
            log.info("Все занято " + size() + " из " + MAX_PLACE_FOR_CAR);
        } else {
            log.warn("ОТКАЗАНО");
        }
    }

//    public synchronized void go(Car t) {
//        add(t);
//    }
}
