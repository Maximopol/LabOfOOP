package by.bnty.fitr.fusman.simpletube.musor;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Kek extends JFrame {

    private static List<JLabel> labels = new ArrayList<>();

    public static void createGUI() {
        JFrame frame = new JFrame("Test frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final Font font = new Font("Verdana", Font.PLAIN, 25);

        JPanel butPanel = new JPanel();

        JButton addButton = new JButton("+");
        addButton.setFont(font);
        addButton.setFocusable(false);
        butPanel.add(addButton);

        JButton remButton = new JButton("-");
        remButton.setFont(font);
        remButton.setFocusable(false);
        butPanel.add(remButton);

        final JPanel labPanel = new JPanel();
        final JScrollPane scrollPane = new JScrollPane(labPanel);
        labPanel.setLayout(new BoxLayout(labPanel, BoxLayout.Y_AXIS));

        addButton.addActionListener(e -> {
            int number = labels.size() + 1;
            JLabel label = new JLabel("Label " + number);
            labels.add(label);
            label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            label.setFont(font);
            labPanel.add(label);
            scrollPane.revalidate();
        });

        remButton.addActionListener(e -> {
            if (labels.size() > 0) {
                int index = labels.size() - 1;
                JLabel label = labels.remove(index);
                labPanel.remove(label);
                labPanel.repaint();
                scrollPane.revalidate();
            }
        });

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(butPanel, BorderLayout.NORTH);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        frame.setPreferredSize(new Dimension(250, 200));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            JFrame.setDefaultLookAndFeelDecorated(true);
            createGUI();
        });
    }
}
