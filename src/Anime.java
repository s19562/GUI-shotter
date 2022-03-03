import javax.swing.*;

public abstract class Anime extends JButton{


    enum Kierunek {
        LEWO,
        PRAWO
    }

    Kierunek kierunek;
    int x;
    int y;
    int HP;
    int fast;
    boolean bool;



    Anime(int x, int y,  Kierunek kierunek,String icon) {
        super();
        this.x = x;
        this.y = y;
        this.kierunek = kierunek;
        this.fast =200;
        ImageIcon imageIcon = new ImageIcon(icon);

        this.setIcon(imageIcon);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setBorder(null);


    }


}
