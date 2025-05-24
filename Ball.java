import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Ball extends Rectangle {

    Random random;
    int xVelocity;
    int yVelocity;
    int initialSpeed = 2;


    Ball(int x, int y, int width, int height){
        super(x,y,width,height);
        random = new Random();
        setXDirection(random.nextInt(2) == 0 ? initialSpeed : initialSpeed);
        setYDirection(random.nextInt(2) == 0 ? initialSpeed : initialSpeed);

        int randomXDirection = random.nextInt(2) == 0 ? -5 : 5;
        if(randomXDirection == 0)
            randomXDirection--;
        setXDirection(randomXDirection);
        
        int randomYDirection = random.nextInt(2) == 0 ? -5 : 5;
        if(randomYDirection == 0)
            randomYDirection--;
        setYDirection(randomYDirection);
        

    }

    public void setXDirection(int randomXDirection) {
        xVelocity = randomXDirection;

    }
    
    public void setYDirection(int randomYDirection) {
        yVelocity = randomYDirection;

    }

    public void move() {
        x += xVelocity;
        y += yVelocity;

        if (Math.abs(xVelocity) > 6) xVelocity = (xVelocity > 0) ? 5 : -5;
        if (Math.abs(yVelocity) > 6) yVelocity = (yVelocity > 0) ? 5 : -5;
        
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillOval(x, y, width, height);

    }

    

}
