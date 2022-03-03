import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.CoderMalfunctionError;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class Game extends Thread {


    JFrame f = new JFrame("ANIME SHOOT GAME");
    JLabel background;

    int zycie =10;
    int liczydlo=0;
    int lvl;
    int harder;
    int x=0;
    Thread thread;
    final ArrayList<Anime> animesy;
    final ArrayList<Cloud> clouds;

    JLabel counter = new JLabel("0:0");

    public Game(int lvl){

        this.lvl = lvl;
        this.harder = lvl;


        f.setLayout(new BorderLayout());
        f.pack();
        f.setSize(1248, 701);
        f.setLocationRelativeTo(null);
        f.add(counter,BorderLayout.PAGE_END);

        ImageIcon img = new ImageIcon("tlo3.jpg");
        background = new JLabel("",img,JLabel.CENTER);
        background.setBounds(0,0,1248, 701);
        f.add(background);



        animesy = new ArrayList<>();
        clouds = new ArrayList<>();


        thread = new Thread(){
            public void run(){
                liczydlo =0;
                while (!interrupted()){
                    counter.setText("time: "+(liczydlo /60)+":"+(liczydlo %60)+
                            "    score: "+ (liczydlo * lvl) +
                            "    life: "+ zycie);
                    System.out.println(counter.getText());
                    counter.updateUI();
                    liczydlo++;
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        this.interrupt();
                    }
                }
            }

        };



        thread.start();
        f.setResizable(false);
        f.setVisible(true);

        f.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_F5) {
                    System.out.println("F5 pressed");
                    thread.interrupt();
                    f.dispose();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        f.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {

                thread.interrupt();
                f.dispose();
                System.out.println("wyjscie z gry");
                new StartView();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

    }


    public void run() {

        long timeB = System.currentTimeMillis();
        long timeN = 0;

        while (!isInterrupted()) {
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                System.out.println("blad w thread");
            }

            if (timeN < System.currentTimeMillis() - timeB) {
                timeB = System.currentTimeMillis();
                timeN = (int) (Math.random() * 2500 + 500);


                synchronized (animesy) {

                    while (x > 3000) {
                        int h = (int) (Math.random() * background.getHeight() / 2);
                        int g = Math.random() < 0.5 ? -100 : background.getWidth() + 100;

                        Anime.Kierunek kierunek = g < 0 ? Anime.Kierunek.LEWO : Anime.Kierunek.PRAWO;
                        String icon = "cos55.gif";
                        Anime3 anime1 = new Anime3(g, h, kierunek, icon);

                        anime1.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                synchronized (animesy){
                                    if (anime1.HP <= 0) {
                                        background.remove(anime1);
                                        f.repaint();
                                        animesy.remove(anime1);
                                    } else {
                                        anime1.HP--;
                                    }
                                }
                            }

                        });
                        animesy.add(anime1);
                        background.add(anime1);
                        anime1.setBounds(anime1.x, anime1.y,160, 129);
                        x -= 3000;

                    }
                    while (x > 2000) {
                        int h = (int) (Math.random() * background.getHeight() / 2);
                        int g = Math.random() < 0.5 ? -100 : background.getWidth() + 100;

                        Anime.Kierunek kierunek = g < 0 ? Anime.Kierunek.LEWO : Anime.Kierunek.PRAWO;
                        String icon = "cos33.gif";
                        Anime2 anime1 = new Anime2(g, h, kierunek, icon);

                        anime1.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                synchronized (animesy){
                                    if (anime1.HP <= 0) {
                                        background.remove(anime1);
                                        f.repaint();
                                        animesy.remove(anime1);
                                    } else {
                                        anime1.HP--;
                                    }
                                }
                            }

                        });
                        animesy.add(anime1);
                        background.add(anime1);
                        anime1.setBounds(anime1.x, anime1.y,160, 120);
                        x -= 2000;

                    }
                    while (x > 1000) {
                        int h = (int) (Math.random() * background.getHeight() / 2);
                        int g = Math.random() < 0.5 ? -100 : background.getWidth() + 100;

                        Anime.Kierunek kierunek = g < 0 ? Anime.Kierunek.LEWO : Anime.Kierunek.PRAWO;
                        String icon = "cos2.gif";
                        Anime1 anime1 = new Anime1(g, h, kierunek, icon);
                        animesy.add(anime1);
                        anime1.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                synchronized (animesy){
                                    if (anime1.HP <= 0) {
                                        background.remove(anime1);
                                        f.repaint();
                                        animesy.remove(anime1);
                                    } else {
                                        anime1.HP--;
                                    }
                                }
                            }

                        });

                        background.add(anime1);
                        anime1.setBounds(anime1.x, anime1.y,160, 120);
                        x -= 1000;

                    }

                    if (Math.random() > 0.91) {
                        int h = (int) (Math.random() * background.getHeight() / 2);
                        int g = Math.random() < 0.5 ? -100 : background.getWidth() + 100;
                        Cloud.Kierunek kierunek = g > 0 ? Cloud.Kierunek.PRAWO : Cloud.Kierunek.LEWO;

                        Cloud cloud = new Cloud(g, h, kierunek);
                        clouds.add(cloud);
                        background.add(cloud);
                        cloud.setBounds(cloud.x, cloud.y, 220, 162);
                        x -= 100;
                    }
                    harder = harder + lvl;
                }


            }


            synchronized (animesy) {
                try{

                for (Anime anime : animesy) {
                    int v = anime.fast;
                    if (v % 100 != 0) {
                        if (anime.bool) {
                            anime.bool = false;
                            if (anime.kierunek == Anime.Kierunek.LEWO) {
                                anime.x += 1;
                            } else {
                                anime.x -= 1;
                            }
                        } else {
                            anime.bool = true;
                        }
                    }

                    if (anime.kierunek == Anime.Kierunek.LEWO) {
                        anime.x += v / 100;
                    } else {
                        anime.x -= v / 100;
                    }
                    anime.setBounds(anime.x, anime.y, 114, 100);
                }


                for (Cloud cloud : clouds) {

                    int v = 100;
                    if (cloud.l > 4) {
                        if (cloud.kierunek == Cloud.Kierunek.LEWO) {
                            cloud.x += v / 100;
                        } else {
                            cloud.x -= v / 100;
                        }
                        cloud.setBounds(cloud.x, cloud.y, 220, 162);
                        cloud.l = 0;
                    }
                    cloud.l++;
                }

                for (Anime anime : this.animesy) {
                    if (anime.kierunek == Anime.Kierunek.LEWO) {
                        if (anime.x > background.getWidth()) {
                            background.remove(anime);
                            this.animesy.remove(anime);
                            zycie--;
                        }
                    } else {
                        if (anime.x < -114) {
                            background.remove(anime);
                            this.animesy.remove(anime);
                            zycie--;
                        }
                    }
                }

                for (Cloud cloud : clouds) {
                    if (cloud.kierunek == Cloud.Kierunek.LEWO) {
                        if (cloud.x > background.getWidth()) {
                            background.remove(cloud);
                            clouds.remove(cloud);
                        }
                    } else {
                        if (cloud.x < -256) {
                            background.remove(cloud);
                            clouds.remove(cloud);

                        }
                    }
                }

            }catch (ConcurrentModificationException e)
            {
                System.out.println("exit");
            }


                x = x + harder;

                if (zycie <= 0) {
                    f.dispose();
                    this.interrupt();
                }


            }
        }

        thread.interrupt();

        save();
    }


    void save(){

        System.out.println("zapis");
        JFrame save = new JFrame("SAVE SCORE");
        JTextField nick = new JTextField();
        save.setLayout(new FlowLayout());
        nick.setPreferredSize(new Dimension(100 , 20));
        save.add(nick);
        JButton saveButton = new JButton("save");
        saveButton.setBackground(Color.CYAN);
        save.setBackground(Color.BLUE);
        save.add(saveButton);
        save.pack();
        save.setSize(400 , 80);
        save.setVisible(true);
        save.setLocationRelativeTo(null);
        save.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        saveButton.addActionListener(e -> {
            save.dispose();
            new StartView();
        });






    }







}