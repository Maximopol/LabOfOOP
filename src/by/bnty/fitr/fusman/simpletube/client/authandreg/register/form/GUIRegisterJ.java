package by.bnty.fitr.fusman.simpletube.client.authandreg.register.form;

import javax.swing.*;
import java.awt.*;

public class GUIRegisterJ {
    private static void run() {
        JFrame frame = new JFrame("Reg to SimpleTube");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        //     panel.setBackground(Color.PINK);
//        JTextArea textArea = new JTextArea("Welcome");
//        Font font = new Font("Tahoma", Font.ITALIC, 20);
//        textArea.setFont(font);
//        panel.add(textArea,
//        panel.add(textArea);


        //==============================
        JLabel userName = new JLabel("Email:");
        panel.add(userName);

        TextField userTextField = new TextField();
        panel.add(userTextField);//, 0, 0);

        JLabel pw = new JLabel("Password:");
        panel.add(pw);//, 2, 0);
//
        JPasswordField pwBox = new JPasswordField();
        panel.add(pwBox);//, 2, 1);
//
        JButton btn = new JButton("Reg");
        panel.add(btn);
//
        final JLabel actiontarget = new JLabel();
        panel.add(actiontarget);//, 1, 1);
//
        btn.addActionListener(e -> {
            actiontarget.setText("LOLKEK");
        });
//======================
        frame.getContentPane().add(panel);

        frame.setPreferredSize(new Dimension(400, 300));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void call() {
        javax.swing.SwingUtilities.invokeLater(() -> {
            JFrame.setDefaultLookAndFeelDecorated(true);
            run();
        });
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            JFrame.setDefaultLookAndFeelDecorated(true);
            run();
        });
    }
}
