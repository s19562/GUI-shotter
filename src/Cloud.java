import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Cloud extends JButton {

    enum Kierunek {
        LEWO,
        PRAWO
    }

    int x;
    int y;
    Kierunek kierunek;
    int l=0;


    Cloud(int x, int y, Kierunek kierunek)
    {
        super();
        this.kierunek = kierunek;
        this.x=x;
        this.y=y;
        BufferedImage icon;

        try {
            icon= ImageIO.read(new File("chmurka.png"));
            this.setIcon(new ImageIcon(icon));
            this.setSize(100,100);
            this.setOpaque(false);
            this.setContentAreaFilled(false);
            this.setBorderPainted(false);
            this.setBorder(null);

        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}