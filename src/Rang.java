import javax.swing.*;

public class Rang extends JFrame {
    public ImageIcon tloRang;

    JLabel scoreLabel = new JLabel();

   public Rang(){

    setTitle("RANKING");
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    tloRang = new ImageIcon("wynikiTlo.jpg");
    scoreLabel.setIcon(tloRang);
    JButton buttonExit = new JButton("Back to menu");
    buttonExit.setSize(612 , 40);
    buttonExit.setLocation(0, 379);
    scoreLabel.add(buttonExit);


    buttonExit.addActionListener(e -> {
        new StartView();
        this.setVisible(false);
    });

    add(scoreLabel);
    setSize(612, 459);
    setResizable(false);
    setVisible(true);

   }
}
