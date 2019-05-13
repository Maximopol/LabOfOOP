package by.bnty.fitr.fusman.simpletube.client.loadervideo;

import by.bnty.fitr.fusman.labs.lab10.blogers.Account;
import by.bnty.fitr.fusman.simpletube.common.command.Command;
import javafx.stage.FileChooser;
import org.apache.log4j.Logger;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.Socket;

public class LoaderVideo extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton openFileButton;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel path;
    private FileChooser fileChooser;
    private Logger log;

    private Account account;

    private String fullpath;

    public LoaderVideo() {
        log = Logger.getLogger(LoaderVideo.class);
        fileChooser = new FileChooser();
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(e -> onOK());

        buttonCancel.addActionListener(e -> onCancel());

        openFileButton.addActionListener(e -> {
            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            jfc.setDialogTitle("Выбор файла");
            jfc.setBackground(Color.LIGHT_GRAY);

            if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jfc.getSelectedFile();
                path.setText(selectedFile.getName());
                fullpath = selectedFile.getAbsolutePath();
                log.info("Path" + fullpath);
            }
        });

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    public static void run(Account account) {
        LoaderVideo dialog = new LoaderVideo();
        dialog.account = account;
        dialog.pack();
        dialog.setModal(true);
        dialog.setVisible(true);

    }

    public static void main(String[] args) {
        LoaderVideo dialog = new LoaderVideo();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void onOK() {
        try {
            Socket socket = new Socket("localhost", 65432);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            File f = new File(fullpath);

            out.println(Command.LOADING + "\n" +
                    account.getNickname() + "\n" +
                    account.getEmail() + "\n" +
                    path.getText() + "\n" +
                    textField1.getText() + "\n" +
                    textField2.getText() + "\n" + f.length());

            DataOutputStream outD = new DataOutputStream(socket.getOutputStream());

            log.info("File name: " + f.getName() + " length: " + f.length());

            FileInputStream in = new FileInputStream(f);
            byte[] buffer = new byte[64 * 1024];
            int count;

            while ((count = in.read(buffer)) != -1) {
                outD.write(buffer, 0, count);
            }

            outD.flush();
            in.close();
            out.close();
            socket.close();
            log.info("Done!");

        } catch (IOException e) {
            log.error(e);
        }
    }

    private void onCancel() {
        dispose();
    }
}
