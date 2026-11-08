import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Panel extends JPanel implements ActionListener{
    Snake snake;
    Prey prey;
    final int screen_length=1000;
    final int screen_width=1000;
    final int size=25;
    static final int delay = 500;
    Timer timer;
    boolean run=true;
    int power=0;

    Panel() {
        this.setPreferredSize(new Dimension(screen_length, screen_width));
        this.setBackground(Color.LIGHT_GRAY);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        snake=new Snake();
        prey=new Prey();
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
        snake.draw(g);
        prey.draw(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 15));
        g.drawString("Power : "+power, 10, 10);
        if(!run){
            g.setColor(Color.ORANGE);
            g.setFont(new Font("Arial", Font.BOLD, 100));
            g.drawString("Died", 400, 500);
        }
    }

    public void checkPrey(){
            if(snake.x[0]==prey.x && snake.y[0]==prey.y){
                power++;
                snake.body++;
                prey.display();
            }
    }

    public void draw(Graphics g){
        for(int i=0; i<screen_length/size; i++){
            g.drawLine(i*size, 0, i*size, screen_length);
            g.drawLine(0, i*size, screen_width, i*size);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(run){
            snake.movement();
            checkPrey();
            checkWall();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            switch(e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                if(snake.direction != 'D')
                    snake.direction = 'A';
                break;
            case KeyEvent.VK_RIGHT:
                if(snake.direction != 'A')
                    snake.direction = 'D';
                break;
            case KeyEvent.VK_UP:
                if(snake.direction != 'S')
                    snake.direction = 'W';
                break;
            case KeyEvent.VK_DOWN:
                if(snake.direction != 'W')
                    snake.direction = 'S';
                break;
            }
        }
    }

    public void checkWall(){
        if(snake.x[0]<0 || snake.x[0]>=screen_width || snake.y[0]<0 || snake.y[0]>=screen_length){
            run=false;
        }
        if(!run){
            timer.stop();
        }
    }
}