package com.kodilla.pacmanV2.pacmanBoard;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackgroundLevel1 extends Rectangle{

    public BufferedImage background;


    File filebackground= new File("kodilla-pacmanv2\\src\\main\\resources\\assets\\textures\\background.png");




        public BackgroundLevel1() {
            try {
                background = ImageIO.read(filebackground);
            } catch (IOException e) {
                e.printStackTrace();
            }
            setBounds(0,0,1520,960);
        }

        public void render(Graphics g) {


            g.drawImage(background,0,0,1520,960,null);
        }
}
