package _08_LeagueSnake;

import java.awt.Color;

import _02_shapes_inheritance.Square;
import processing.core.PApplet;

public class LeagueSnake extends PApplet {
    static final int WIDTH = 800;
    static final int HEIGHT = 800;
    int direction = UP;
    int eaten = 0;
    Segment head;
    int foodX;
    int foodY;
    /*
     * Game variables
     * 
     * Put all the game variables here.
     */
    

    
    /*
     * Setup methods
     * 
     * These methods are called at the start of the game.
     */
    @Override
    public void settings() {
        setSize(500,500);
    }

    @Override
    public void setup() {
        head = new Segment();
        frameRate(20);
        dropFood();
    }

    void dropFood() {
        // Set the food in a new random location
    	foodX = ((int)random(50)*10);
    	foodY = ((int)random(50)*10);
        
    }

    /*
     * Draw Methods
     * 
     * These methods are used to draw the snake and its food
     */

    @Override
    public void draw() {
        background(5);
        move();
        drawFood();
        drawSnake();
    }

    void drawFood() {
    	fill(255,0,0);
    	rect(foodX,foodY,10,10);
    
    }

    void drawSnake() {
        fill(100,0,100);
        rect(head.x,head.y,10,10);
        
    }

    void drawTail() {
        
        
    }

    /*
     * Tail Management methods
     * 
     * These methods make sure the tail is the correct length.
     */

    void manageTail() {
        // After drawing the tail, add a new segment at the "start" of the tail and
        // remove the one at the "end"
        // This produces the illusion of the snake tail moving.

    }

    void checkTailCollision() {
        // If the snake crosses its own tail, shrink the tail back to one segment
        
    }

    /*
     * Control methods
     * 
     * These methods are used to change what is happening to the snake
     */

    @Override
    public void keyPressed() {
        if(keyCode == CODED) {
        	if() {
        		
        	}
        
        }
        
    }

    void move() {
        // Change the location of the Snake head based on the direction it is moving.

        
        if (direction == UP) {
            head.y-=30;
            
        } else if (direction == DOWN) {
            head.y+=30;
                
        } else if (direction == LEFT) {
            head.x -=30;
        } else if (direction == RIGHT) {
        	head.y-=30;
            
        }
        
    }

    void checkBoundaries() {
        if (head.x >=800) {
        	head.x = 0;
        }
        if (head.x >=0) {
        	head.x = 800;
        }
        if(head.y >=800) {
        	head.y = 0;
        }
        if (head.y >=0) {
        	head.y = 800;
        }
    }

    void eat() {
        // When the snake eats the food, its tail should grow and more
        // food appear
        
    }

    static public void main(String[] passedArgs) {
        PApplet.main(LeagueSnake.class.getName());
    }
}
