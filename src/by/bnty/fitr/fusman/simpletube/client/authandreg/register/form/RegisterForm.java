package by.bnty.fitr.fusman.simpletube.client.authandreg.register.form;

import by.bnty.fitr.fusman.simpletube.client.authandreg.runable.Runnable;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RegisterForm extends JDialog implements Runnable {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JLabel label1;
    private JLabel label2;


    public RegisterForm() {
        setTitle("Reg to SimpleTube");
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
        RegisterForm dialog = new RegisterForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void onOK() {
        //тут обработка

    }

    private void onCancel() {
        // add your code here if necessary

        dispose();
    }

    public void run() {
        RegisterForm dialog = new RegisterForm();
        dialog.pack();
        dialog.setVisible(true);
    }


}
