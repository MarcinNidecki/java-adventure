package com.kodilla.pacmanV2;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Level {

    public int width;
    public int height;
    public  Tile[][] tiles;
    public static int mapTextureX,mapTextureY;
    private ArrayList<String> levelData = new ArrayList<String>();
    char c,d;
    int[][] arrayX = new int[20][20];
    int[][] arrayY = new int[20][20];

    public  Level(String path) {

        // try read the file
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scanner.hasNextLine()) {
            levelData.add(scanner.nextLine());
        }
        scanner.close();

        tiles = new Tile[20][20];

        // load elements from file
        int w = levelData.get(0).length();
        for (int xx = 0; xx < levelData.size(); xx++) {
            String line = levelData.get(xx);
            for (int yy = 0; yy < w; yy++) {
                c = line.charAt(yy);
                System.out.print(c);

                switch (c) {

                    case 'a':
                        arrayX [xx][yy] =0;
                        arrayY [xx][yy] =0;
                        tiles[xx][yy] = new Tile(xx*40,yy*40);
                        break;
                    case 'b':
                        arrayX [xx][yy] =0;
                        arrayY [xx][yy] =1;
                        tiles[xx][yy] = new Tile(xx*40,yy*40);
                        break;
                    case 'c':
                        arrayX [xx][yy] =0;
                        arrayY [xx][yy] =2;
                        tiles[xx][yy] = new Tile(xx*40,yy*40);
                        break;
                    case 'd':
                        arrayX [xx][yy] =0;
                        arrayY [xx][yy] =3;
                        tiles[xx][yy] = new Tile(xx*40,yy*40);
                        break;
                    case 'e':
                        arrayX [xx][yy] =0;
                        arrayY [xx][yy] =4;
                        tiles[xx][yy] = new Tile(xx*40,yy*40);
                        break;
                        case 'f':
                        arrayX [xx][yy] =1;
                        arrayY [xx][yy] =1;
                        tiles[xx][yy] = new Tile(xx*40,yy*40);
                        break;
                    case 'g':
                        arrayX [xx][yy] =1;
                        arrayY [xx][yy] =2;
                        tiles[xx][yy] = new Tile(xx*40,yy*40);
                        break;
                    case'h':
                        arrayX [xx][yy] =1;
                        arrayY [xx][yy] =3;
                        tiles[xx][yy] = new Tile(xx*40,yy*40);
                        break;
                    case 'i':
                        arrayX [xx][yy] =1;
                        arrayY [xx][yy] =4;
                        tiles[xx][yy] = new Tile(xx*40,yy*40);
                        break;
                    case 'j':
                        arrayX [xx][yy] =1;
                        arrayY [xx][yy] =5;
                        tiles[xx][yy] = new Tile(xx*40,yy*40);
                        break;
                    case 'k':
                        arrayX [xx][yy] =1;
                        arrayY [xx][yy] =6;
                        tiles[xx][yy] = new Tile(xx*40,yy*40);
                        break;
                    case 'l':
                        arrayX [xx][yy] =1;
                        arrayY [xx][yy] =7;
                        tiles[xx][yy] = new Tile(xx*40,yy*40);
                        break;
                    case 'm':
                        arrayX [xx][yy] =2;
                        arrayY [xx][yy] =5;
                        tiles[xx][yy] = new Tile(xx*40,yy*40);
                        break;
                    case 'n':
                        arrayX [xx][yy] =2;
                        arrayY [xx][yy] =6;
                        tiles[xx][yy] = new Tile(xx*40,yy*40);
                        break;
                    case 'o':
                        arrayX [xx][yy] =2;
                        arrayY [xx][yy] =7;
                        tiles[xx][yy] = new Tile(xx*40,yy*40);
                        break;
                    case 'q':
                        arrayX [xx][yy] =5;
                        arrayY [xx][yy] =4;
                        tiles[xx][yy] = new Tile(xx*40,yy*40);
                        break;
                    case 'p':
                        arrayX [xx][yy] =2;
                        arrayY [xx][yy] =2;
                        tiles[xx][yy] = new Tile(xx*40,yy*40);
                        break;
                    case 'r':
                        arrayX [xx][yy] =3;
                        arrayY [xx][yy] =1;
                        tiles[xx][yy] = new Tile(xx*40,yy*40);
                        break;
                    case 's':
                        arrayX [xx][yy] =3;
                        arrayY [xx][yy] =2;
                        tiles[xx][yy] = new Tile(xx*40,yy*40);
                        break;
                    case 't':
                        arrayX [xx][yy] =3;
                        arrayY [xx][yy] =3;
                        tiles[xx][yy] = new Tile(xx*40,yy*40);
                        break;

                    case 'u':
                        arrayX [xx][yy] =3;
                        arrayY [xx][yy] =5;
                        tiles[xx][yy] = new Tile(xx*40,yy*40);
                        break;

                    case 'w':
                        arrayX [xx][yy] =3;
                        arrayY [xx][yy] =6;
                        tiles[xx][yy] = new Tile(xx*40,yy*40);
                        break;

                    case 'x':
                        arrayX [xx][yy] =3;
                        arrayY [xx][yy] =7;
                        tiles[xx][yy] = new Tile(xx*40,yy*40);
                        break;

                    case 'y':
                        arrayX [xx][yy] =4;
                        arrayY [xx][yy] =5;
                        tiles[xx][yy] = new Tile(xx*40,yy*40);
                        break;

                    case 'z':
                        arrayX [xx][yy] =4;
                        arrayY [xx][yy] =6;
                        tiles[xx][yy] = new Tile(xx*40,yy*40);
                        break;

                    case '1':
                        arrayX [xx][yy] =4;
                        arrayY [xx][yy] =7;
                        tiles[xx][yy] = new Tile(xx*40,yy*40);
                        break;

                    case '2':
                        arrayX [xx][yy] =4;
                        arrayY [xx][yy] =0;
                        tiles[xx][yy] = new Tile(xx*40,yy*40);
                        break;

                    case '3':
                        arrayX [xx][yy] =4;
                        arrayY [xx][yy] =1;
                        tiles[xx][yy] = new Tile(xx*40,yy*40);
                        break;

                    case '4':
                        arrayX [xx][yy] =4;
                        arrayY [xx][yy] =2;
                        tiles[xx][yy] = new Tile(xx*40,yy*40);
                        break;

                    case '5':
                        arrayX [xx][yy] =4;
                        arrayY [xx][yy] =3;
                        tiles[xx][yy] = new Tile(xx*40,yy*40);
                        break;

                    case '6':
                        arrayX [xx][yy] =4;
                        arrayY [xx][yy] =4;
                        tiles[xx][yy] = new Tile(xx*40,yy*40);
                        break;

                    case '7':
                        arrayX [xx][yy] =5;
                        arrayY [xx][yy] =2;
                        tiles[xx][yy] = new Tile(xx*40,yy*40);
                        break;

                    case '8':
                        arrayX [xx][yy] =5;
                        arrayY [xx][yy] =3;
                        tiles[xx][yy] = new Tile(xx*40,yy*40);
                        break;
                    case '9':
                        arrayX [xx][yy] =6;
                        arrayY [xx][yy] =2;
                        tiles[xx][yy] = new Tile(xx*40,yy*40);
                        break;
                    case '!':
                        arrayX [xx][yy] =5;
                        arrayY [xx][yy] =3;
                        tiles[xx][yy] = new Tile(xx*40,yy*40);
                        break;

                    case '?':
                        arrayX [xx][yy] =6;
                        arrayY [xx][yy] =3;
                        tiles[xx][yy] = new Tile(xx*40,yy*40);
                        break;






                }

            }


            }
        }




    public void render(Graphics g) {

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j<20; j++) {
                if (tiles[i][j] != null) {
                    mapTextureX = arrayX[i][j];
                    mapTextureY = arrayY[i][j];
                    tiles[i][j].render(g);
                }

            }
        }
    }
}

