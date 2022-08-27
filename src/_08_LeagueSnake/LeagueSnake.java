package _08_LeagueSnake;

import java.awt.Color;
import java.util.ArrayList;

import _02_shapes_inheritance.Square;
import processing.core.PApplet;

public class LeagueSnake extends PApplet {
	static final int WIDTH = 800;
	static final int HEIGHT = 800;
	int direction = UP;
	int eaten = 0;
	Segment head;
	ArrayList<Segment> tail = new ArrayList<Segment>();
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
		setSize(WIDTH, HEIGHT);
	}

	@Override
	public void setup() {
		head = new Segment(50, 50);
		frameRate(20);
		dropFood();
	}

	void dropFood() {
		// Set the food in a new random location
		foodX = ((int) random(50) * 10);
		foodY = ((int) random(50) * 10);

	}

	/*
	 * Draw Methods
	 * 
	 * These methods are used to draw the snake and its food
	 */

	@Override
	public void draw() {
		background(0, 200, 70);
		move();
		drawFood();
		drawSnake();
		eat();
	}

	void drawFood() {
		fill(255, 0, 0);
		rect(foodX, foodY, 10, 10);

	}

	void drawSnake() {
		fill(0, 100, 255);
		rect(head.x, head.y, 10, 10);
		manageTail();

	}

	void drawTail() {
		for (int i = 0; i < tail.size(); i++) {
			Segment tailpos = tail.get(i);
			fill(0, 100, 255);
			rect(tailpos.x, tailpos.y, 10, 10);
		}
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
		checkTailCollision();
		drawTail();
		tail.add(new Segment(head.x, head.y));
		tail.remove(0);

	}

	void checkTailCollision() {
		// If the snake crosses its own tail, shrink the tail back to one segment
		for (int i = 0; i < tail.size(); i++) {
			Segment tailpos = tail.get(i);
			if (head.x == tailpos.x && head.y == tailpos.y) {
				eaten = 1;
				tail.clear();
				tail.add(new Segment(head.x, head.y));
			}
		}
	}

	/*
	 * Control methods
	 * 
	 * These methods are used to change what is happening to the snake
	 */

	@Override
	public void keyPressed() {
		if (key == CODED) {
			if (keyCode == UP) {
				if (direction != DOWN) {
					// direction = DOWN;
					direction = UP;

				}

			}
			if (keyCode == DOWN) {
				if (direction != UP) {
					direction = DOWN;
				}

			}
			if (keyCode == RIGHT) {
				if (direction != LEFT) {
					direction = RIGHT;
				}

			}
			if (keyCode == LEFT) {
				if (direction != RIGHT) {
					direction = LEFT;
				}

			}
		}
	}

	void move() {
		// Change the location of the Snake head based on the direction it is moving.

		if (direction == UP) {
			head.y -= 10;
			checkBoundaries();

		} else if (direction == DOWN) {
			head.y += 10;
			checkBoundaries();

		} else if (direction == LEFT) {
			head.x -= 10;
			checkBoundaries();
		} else if (direction == RIGHT) {
			head.x += 10;
			checkBoundaries();

		}
		// System.out.println("MOVING");

	}

	void checkBoundaries() {
		if (head.x >= 800) {
			head.x = 0;
		}
		else if (head.x <= 0) {
			head.x = 800;
		}
		else if (head.y > 800) {
			head.y = 0;
		}
		else if (head.y <= 0) {
			head.y = 800;
		}
	}

	void eat() {
		// When the snake eats the food, its tail should grow and more
		// food appear
		if (head.y == foodY && head.x == foodX) {
			dropFood();
			eaten += 1;
			tail.add(new Segment(head.x, head.y));
		}

	}

	static public void main(String[] passedArgs) {
		PApplet.main(LeagueSnake.class.getName());
	}
}
