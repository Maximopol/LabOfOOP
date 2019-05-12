package by.bnty.fitr.fusman.simpletube.client.accountform;

import by.bnty.fitr.fusman.labs.lab10.blogers.Account;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AccountForm extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel mail;
    private JLabel nick;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private Account account;


    public AccountForm(Account account) {
        this.account = account;
        setTitle("About your account");
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        nick.setText(account.getNickname());
        mail.setText(account.getEmail());

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
        AccountForm dialog = new AccountForm(null);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public static void run(Account account) {
        AccountForm dialog = new AccountForm(account);
        dialog.pack();
        dialog.setVisible(true);
    }

    private void onOK() {

        dispose();
    }

    private void onCancel() {

        dispose();
    }
}
