package by.bnty.fitr.fusman.simpletube.client.authandreg.authoration.form;

import by.bnty.fitr.fusman.labs.lab10.blogers.Account;
import by.bnty.fitr.fusman.simpletube.common.command.Command;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class AuthorationForm extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JLabel label1;
    private JLabel label2;
    private JButton fogotButton;
    private JLabel label3;
    private Account account;

    public AuthorationForm() {
        account = null;
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
        // add your code here if necessary
        dispose();
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
                String nic = bufferedReader.readLine();
                System.out.println(nic);
                account = new Account(nic, textField1.getText());

            } else {
                label3.setText("Отказ");
            }
            out.close();
            bufferedReader.close();
        } catch (IOException e) {
            label3.setText("Server not");
        } catch (Exception e) {
            label3.setText("Error");
        }
    }
}
