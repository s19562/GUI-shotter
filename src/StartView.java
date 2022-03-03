import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartView extends JFrame {

    public ImageIcon tloStart;
    JLabel startV = new JLabel();

    public StartView(){
        tloStart = new ImageIcon("start1.jpg");
        setResizable(false);
        setVisible(true);
        setTitle("ANIME SHOOT GAME");
        setSize(new Dimension(800, 445));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        startV.setLayout(null);
        JButton buttonStart = new JButton("START");
        buttonStart.setSize(50, 50);
        buttonStart.addActionListener(e -> {
            this.setVisible(false);
            JFrame chooselvl = new JFrame("CHOOSE LVL");
            chooselvl.setBackground(Color.CYAN);
            chooselvl.setLayout(new FlowLayout());

            JComboBox lvl = new JComboBox();
            lvl.addItem("EASY");
            lvl.addItem("MID");
            lvl.addItem("HARD");
            chooselvl.add(lvl);

            JButton start1 = new JButton("START <3");
            start1.setBackground(Color.CYAN);
            start1.addActionListener(e1 -> {
                if(lvl.getSelectedIndex()==0) {
                    Game game = new Game(lvl.getSelectedIndex() + 1);
                    game.start();
                }else if(lvl.getSelectedIndex()==1)
                {
                    Game game = new Game( lvl.getSelectedIndex() + 1);
                    game.start();
                }else if(lvl.getSelectedIndex()==2)
                {
                    Game game = new Game( lvl.getSelectedIndex() + 1);
                    game.start();
                }
                chooselvl.dispose();
            });
            chooselvl.add(start1);

            chooselvl.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            chooselvl.setLocationRelativeTo(null);
            chooselvl.pack();
            chooselvl.setVisible(true);



        });

        buttonStart.setLocation(120 , 70);
        startV.add(buttonStart);
        buttonStart.setOpaque(false);
        buttonStart.setBorderPainted(true);
        buttonStart.setBorder(BorderFactory.createEmptyBorder());
        buttonStart.setContentAreaFilled(false);

        JButton buttonRang = new JButton("RANKING");
        buttonRang.setSize(127, 50);
        startV.add(buttonRang);
        buttonRang.setLocation(564,67);
        buttonRang.setOpaque(false);
        buttonRang.setBorderPainted(true);
        buttonRang.setBorder(BorderFactory.createEmptyBorder());
        buttonRang.setContentAreaFilled(false);
        buttonRang.addActionListener(e -> {
            new Rang();
            this.setVisible(false);
        });


        JButton buttonExit = new JButton("EXIT");
        buttonExit.setSize(127, 50);
        startV.add(buttonExit);
        buttonExit.setLocation(500,300);
        buttonExit.setOpaque(false);
        buttonExit.setBorderPainted(true);
        buttonExit.setBorder(BorderFactory.createEmptyBorder());
        buttonExit.setContentAreaFilled(false);
        buttonExit.addActionListener(e -> System.exit(0));

        startV.setIcon(tloStart);
        add(startV);
    }

}