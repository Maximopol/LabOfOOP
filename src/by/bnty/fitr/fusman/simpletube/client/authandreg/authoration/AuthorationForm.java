package by.bnty.fitr.fusman.simpletube.client.authandreg.authoration;

import by.bnty.fitr.fusman.labs.lab10.blogers.Account;
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
        return dialog.account;
    }

    private void onCancel() {
        dispose();
    }

    private void onOK() {
        try {
            Socket socket = new Socket("localhost", 65432);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println(Command.AUTHORIZATION + "\n" + textField1.getText() + "\n" + passwordField1.getText());

            logger.info("Sent");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            if (bufferedReader.readLine().equals("true")) {
                logger.info("Success");
                label3.setText("Успех");
                String nic = bufferedReader.readLine();
                account = new Account(nic, textField1.getText());
                logger.info(account);
                account.setPlaylists(CreatePlaulistFromServ.create(bufferedReader));
                logger.info(account);

            } else {
                label3.setText("Отказ");
                logger.warn("Fail");
            }
            out.close();
            bufferedReader.close();
            socket.close();
        } catch (Exception e) {
            label3.setText("Error");
            logger.error(e);
        }
    }
}
