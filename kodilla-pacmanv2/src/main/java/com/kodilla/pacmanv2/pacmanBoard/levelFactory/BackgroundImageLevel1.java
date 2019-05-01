package com.kodilla.pacmanv2.pacmanBoard.levelFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class BackgroundImageLevel1 extends Rectangle {

    private BufferedImage background;


    public BackgroundImageLevel1() {
        try {
            File fileBackground = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("assets/textures/background.png")).getFile());
            background = ImageIO.read(fileBackground);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setBounds(0, 0, 1520, 960);
    }

    public void render(Graphics g) {


        g.drawImage(background, 0, 0, 1520, 960, null);

    }
}
