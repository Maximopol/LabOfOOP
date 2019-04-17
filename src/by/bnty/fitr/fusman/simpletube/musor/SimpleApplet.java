package by.bnty.fitr.fusman.simpletube.musor;

import java.awt.*;
import java.util.Calendar;

public class SimpleApplet extends javax.swing.JApplet {
    private Calendar calendar;

    public void init() {
        calendar = Calendar.getInstance();
        setSize(250, 80);
    }

    public void paint(Graphics g) {
        g.drawString("Апплет запущен:", 20, 15);
        g.drawString(
                calendar.getTime().toString(), 20, 35);
    }
}
