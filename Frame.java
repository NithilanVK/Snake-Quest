import javax.swing.*;

public class Frame extends JFrame{
    Panel panel;
    Frame(){
        panel=new Panel();
        this.add(panel);
        this.setTitle("Snake Quest");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
}
