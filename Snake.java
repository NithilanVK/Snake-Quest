import java.awt.*;

public class Snake {
    int[] x;
    int[] y;
    int body;
    char direction;

    Snake(){
        body=2;
        x=new int[100];
        y=new int[100];

        x[0]=500; y[0]=500;
        x[1]=475; y[1]=500;
        x[2]=450; y[2]=500;

        direction='D';
    }

    public void draw(Graphics g){
        for(int i=0; i<body; i++){
            if(i==0){
                g.setColor(Color.black);
            }
            else{
                g.setColor(Color.DARK_GRAY);
            }
            g.fillOval(x[i], y[i], 25, 25);
        };
    }

    public void movement(){
        for(int i=body; i>0; i--){
            x[i]=x[i-1]; y[i]=y[i-1];
        }
        switch(direction){
            case 'W':
            y[0]-=25;
            break;
            case 'S':
            y[0]+=25;
            break;
            case 'A':
            x[0]-=25;
            break;
            case 'D':
            x[0]+=25;
            break;
        }
    }
}
