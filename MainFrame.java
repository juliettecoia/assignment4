import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;

public class MainFrame extends JFrame {

    private final PaintPanel paintPanel;

    public MainFrame() {
        super("Assignment 4: Simple Paint Program");
        setLayout(new FlowLayout());

        paintPanel = new PaintPanel();
        paintPanel.setPreferredSize(new Dimension(400, 400));
        add(paintPanel);
    }
}