package by.bnty.fitr.fusman.simpletube.client.authandreg.register.form;

import by.bnty.fitr.fusman.simpletube.common.command.Command;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class RegisterForm extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JTextField textField2;
    private JLabel lableinfo;
    private Logger log;

    public RegisterForm() {
        log = Logger.getLogger(RegisterForm.class);

        setTitle("Reg to SimpleTube");
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(e -> onOK());

        buttonCancel.addActionListener(e -> onCancel());

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    public static void main(String[] args) {
        RegisterForm dialog = new RegisterForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void onOK() {
        try {
            log.info("run");
            Socket socket = new Socket("localhost", 65432);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println(Command.REGISTRATION + "\n" + textField1.getText() + "\n" + passwordField1.getText() + "\n" + textField2.getText());

            log.info("Sent");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            if (bufferedReader.readLine().equals("true")) {
                log.info("Success");
                lableinfo.setText("Успех");

            } else {
                lableinfo.setText("Отказ");
                log.info("Fail");
            }
            out.close();
            bufferedReader.close();
            socket.close();
            log.info("Done");
        } catch (Exception e) {
            lableinfo.setText("Error");
            log.error(e);
        }
    }

    private void onCancel() {
        dispose();
    }

    public static void run() {
        RegisterForm dialog = new RegisterForm();
        dialog.pack();
        dialog.setModal(true);
        dialog.setVisible(true);
    }


}
