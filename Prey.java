import java.awt.*;
import java.util.Random;

public class Prey {
    int x, y;
    final int prey_size=25;
    final int screen_length=600;
    final int screen_width=600;
    Random random=new Random();

    Prey(){
        display();
    }

    public void display(){
        x=random.nextInt(screen_width/prey_size)*prey_size;
        y=random.nextInt(screen_length/prey_size)*prey_size;
    }

    public void draw(Graphics g){
            g.setColor(Color.PINK);
            g.fillOval(x, y, prey_size, prey_size);
    }
}
