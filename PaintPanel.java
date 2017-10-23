import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;

public class PaintPanel extends JPanel {

    private final JButton bSmall;
    private final JButton bMedium;
    private final JButton bLarge;

    private final JButton bBlack;
    private final JButton bBlue;
    private final JButton bYellow;
    private final JButton bPink;

    private final JButton bClear;
    private final JLabel labelL;

    private Color color;

    private static int size = 3;

    private final ArrayList<PaintPoint> points;

    public PaintPanel() {
        points = new ArrayList<>();

        bSmall = new JButton ("small");
        bSmall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                labelL.setText("size: small!");
                size = 3;
            }
        });
        add(bSmall);

        bMedium = new JButton ("medium");
        bMedium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                labelL.setText("size: medium!");
                size = 6;
            }
        });
        add(bMedium);

        bLarge = new JButton ("large");
        bLarge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                labelL.setText("size: large!");
                size = 10;
            }
        });
        add(bLarge);

        bClear = new JButton ("clear");
        bClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                labelL.setText("screen cleared!");
                points.clear();
                revalidate();
                repaint();
            }
        });
        add(bClear);

        bBlack = new JButton ("black");
        bBlack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                labelL.setText("color: black!");
                color = Color.BLACK;
            }
        });
        add(bBlack);

        bBlue = new JButton ("blue");
        bBlue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                labelL.setText("color: blue!");
                color = Color.BLUE;
            }
        });
        add(bBlue);

        bPink = new JButton ("pink");
        bPink.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                labelL.setText("color: pink!");
                color = Color.PINK;
            }
        });
        add(bPink);

        bYellow = new JButton ("yellow");
        bYellow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                labelL.setText("color: yellow!");
                color = Color.YELLOW;
            }
        });
        add(bYellow);

        labelL = new JLabel("no button clicked");
        add(labelL);

        MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent event){
                PaintPoint point = new PaintPoint(event.getX(), event.getY(), size);
                points.add(point);
                repaint();
            }
        };

        addMouseListener(adapter);
        addMouseMotionListener(adapter);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setColor(color);

        for (PaintPoint point : points) {
            point.draw(graphics);
        }
    }
}