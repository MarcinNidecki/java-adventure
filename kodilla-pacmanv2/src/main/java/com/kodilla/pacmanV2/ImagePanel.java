package com.kodilla.pacmanV2;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {


    private Image img;

    public ImagePanel(String img) {
        this(Toolkit.getDefaultToolkit().createImage(img));
    }

    public ImagePanel(Image img) {
        this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(new GridBagLayout());
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}

