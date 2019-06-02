package by.bnty.fitr.fusman.simpletube.client.authandreg.authoration;

import by.bnty.fitr.fusman.labs.lab10.blogers.Account;
import by.bnty.fitr.fusman.simpletube.common.command.Command;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class AuthorationForm extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JLabel label3;

    private Account account;
    private Logger logger;

    public AuthorationForm() {
        logger = Logger.getLogger(AuthorationForm.class);

        setTitle("Auth to SimpleTube");
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
        AuthorationForm dialog = new AuthorationForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public static Account run() {
        AuthorationForm dialog = new AuthorationForm();
        dialog.pack();
        dialog.setVisible(true);
        dialog.setModal(true);
        return dialog.account;
    }

    private void onCancel() {
        dispose();
    }

    private void onOK() {
        try {
            logger.info("run");
            Socket socket = new Socket("localhost", 65432);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println(Command.AUTHORIZATION + "\n" + textField1.getText() + "\n" + passwordField1.getText());

            logger.info("Sent");

            ObjectInputStream oin = new ObjectInputStream(socket.getInputStream());

            account = (Account) oin.readObject();

            if (account == null) {
                label3.setText("оТКАЗ");
            } else {
                label3.setText("Успех");
            }

            oin.close();
            out.close();
            socket.close();

            logger.info("Done");
        } catch (Exception e) {
            label3.setText("Error");
            logger.error(e);
        }
    }
}
