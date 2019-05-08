package by.bnty.fitr.fusman.simpletube.client.authandreg.authoration.form;

import by.bnty.fitr.fusman.simpletube.client.authandreg.runable.Runnable;
import by.bnty.fitr.fusman.simpletube.common.command.Command;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class AuthorationForm extends JDialog implements Runnable {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JLabel label1;
    private JLabel label2;
    private JButton fogotButton;
    private JLabel label3;

    public AuthorationForm() {
        setTitle("Auth to SimpleTube");
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(e -> onOK());

        buttonCancel.addActionListener(e -> onCancel());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    public static void main(String[] args) {
        AuthorationForm dialog = new AuthorationForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void onOK() {

        try {
            Socket socket = new Socket("localhost", 65432);
            PrintWriter out = new
                    PrintWriter(socket.getOutputStream(), true);


            out.println(Command.AUTHORIZATION + "\n" + textField1.getText() + "\n" + passwordField1.getText());

            System.out.println("посылка");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            if (bufferedReader.readLine().equals("true")) {
                System.out.println("Успех");
                label3.setText("Успех");

            } else {
                label3.setText("Отказ");
            }
            out.close();
            bufferedReader.close();
        } catch (Exception e) {
            label3.setText("Error");
        }

//        // add your code here
//        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public void run() {
        AuthorationForm dialog = new AuthorationForm();
        dialog.pack();
        dialog.setVisible(true);
    }
}
