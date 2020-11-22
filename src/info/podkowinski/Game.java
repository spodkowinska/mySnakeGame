package info.podkowinski;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

import static info.podkowinski.Game.Direction.*;


public class Game implements KeyListener {

    enum Direction {
        RIGHT(1,0), LEFT(-1,0), UP(0, -1), DOWN(0, 1);
        Direction(int x, int y){
            X = x;
            Y = y;
        }
        int X, Y;
    }


    final int DOT_STARTING_POINT_X = 100;
    final int DOT_STARTING_POINT_Y = 180;
    final int DOT_SIZE = 15;
    int x = DOT_STARTING_POINT_X; //Dots x actual position
    int y = DOT_STARTING_POINT_Y; //Dots y actual position

    JFrame frame = new JFrame("Sandra's Snake Game");
    JPanel panel = new JPanel();

    JButton button = new JButton("PLAY");
    JLabel label = new JLabel("Welcome to Snake Game. Have fun!");
    JLabel snake = new JLabel(new ImageIcon("C:/Users/SPodkowinska/Downloads/snake.png"));
    JLabel dot = new JLabel(new ImageIcon("dot.png"));
    Direction direction = Direction.RIGHT;
    Timer timer = new Timer(500, evt -> move(direction));

    public void init() {
        frame.getContentPane();

        Dimension sizeLabel = label.getPreferredSize();
        Dimension sizeSnake = snake.getPreferredSize();
        Dimension sizeButton = button.getPreferredSize();
        Dimension sizeDot = dot.getPreferredSize();

        button.setBounds(240, 180, sizeButton.width, sizeButton.height);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                panel.revalidate();
                panel.repaint();
                panel.setLayout(null);
                panel.setBackground(Color.lightGray);
                dot.setLocation(x, y);
                panel.add(dot);
                panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                if (!timer.isRunning()) {
                    timer.start();
                }
            }
        });

        label.setBounds(180, 150, sizeLabel.width, sizeLabel.height);
        snake.setBounds(200, 130, sizeSnake.width, sizeSnake.height);
        dot.setBounds(x, y, sizeDot.width, sizeDot.height);

        panel.setLayout(null);
        panel.add(label);
        panel.add(button);
        panel.add(snake);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        frame.setContentPane(panel);
        frame.getContentPane().setBackground(Color.white);
        frame.addKeyListener(this);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(new ImageIcon("snake.png").getImage());
        frame.setFocusable(true);
        frame.setFocusTraversalKeysEnabled(false);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (direction != RIGHT && direction != LEFT) {
                move(LEFT);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (direction != LEFT && direction != RIGHT) {
                move(RIGHT);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (direction != DOWN && direction != UP) {
                move(UP);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (direction != UP && direction != DOWN) {
                move(DOWN);
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    public void move(Direction d) {

        dot.setLocation(dot.getX() + d.X * DOT_SIZE, dot.getY() + d.Y * DOT_SIZE);
        direction = d;
    }
//
//    public void moveLeft() {
//        dot.setLocation(dot.getX() - 15, dot.getY());
//        direction = Direction.LEFT;
//    }
//
//    public void moveRight() {
//        dot.setLocation(dot.getX() + 15, dot.getY());
//        direction = Direction.RIGHT;
//    }
//
//    public void moveUp() {
//        dot.setLocation(dot.getX(), dot.getY() - 15);
//        direction = Direction.UP;
//    }
//
//    public void moveDown() {
//        dot.setLocation(dot.getX(), dot.getY() + 15);
//        direction = Direction.DOWN;
//    }
//        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//            this.moveLeft();
//        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//            this.moveRight();
//        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
//            this.moveUp();
//        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//            this.moveDown();
//        }
//        dot.setLocation(x, y);
//        panel.add(dot);
//        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
}
