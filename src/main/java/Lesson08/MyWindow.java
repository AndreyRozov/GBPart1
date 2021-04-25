package Lesson08;

import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {
    public MyWindow() {
        setTitle("Main Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(0,0,400,200);
        mainPanel.setBackground(Color.BLUE);

        JButton [] jButtons = new JButton[5];

        for (int i = 0; i < jButtons.length; i++) {
            jButtons[i] = new JButton(String.valueOf(i));
        }

        mainPanel.setLayout(new GridLayout());
        mainPanel.add(jButtons[1], new GridLayout(2, 2));

        add(mainPanel);

        JPanel secondPanel = new JPanel();
        secondPanel.setBounds(000,200, 400,200);
        secondPanel.setBackground(Color.GREEN);

        secondPanel.setLayout(new BorderLayout());
        secondPanel.add(jButtons[1], BorderLayout.WEST);

        add(secondPanel);

        JPanel finalPanel = new JPanel();
        add(finalPanel);

        setVisible(true);
    }
}
