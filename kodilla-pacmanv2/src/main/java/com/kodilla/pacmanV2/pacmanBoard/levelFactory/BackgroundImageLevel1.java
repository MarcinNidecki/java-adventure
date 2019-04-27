package com.kodilla.pacmanV2.pacmanBoard.levelFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class BackgroundImageLevel1 extends Rectangle {

    private BufferedImage background;


    private File fileBackground = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("assets/textures/background.png")).getFile());


    public BackgroundImageLevel1() {
        try {
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
