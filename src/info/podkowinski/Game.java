package info.podkowinski;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Game implements KeyListener {

    final int DOT_STARTING_POINT_X = 100;
    final int DOT_STARTING_POINT_Y = 180;
    int x = DOT_STARTING_POINT_X; //Dots x actual position
    int y = DOT_STARTING_POINT_Y; //Dots y actual position

    JFrame frame = new JFrame("Sandra's Snake Game");
    JPanel panel = new JPanel();

    JButton button = new JButton("PLAY");
    JLabel label = new JLabel("Welcome to Snake Game. Have fun!");
    JLabel snake = new JLabel(new ImageIcon("C:/Users/SPodkowinska/Downloads/snake.png"));
    JLabel dot = new JLabel(new ImageIcon("dot.png"));
    Timer timer = new Timer(1000, evt -> moveRight());


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
                timer.start();
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
            this.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.moveDown();
        }
        dot.setLocation(x, y);
        panel.add(dot);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void moveLeft() {
        this.x = dot.getX() - 15;
    }

    public void moveRight() {
        this.x = dot.getX() + 15;
    }

    public void moveUp() {
        this.y = dot.getY() - 15;
    }

    public void moveDown() {
        this.y = dot.getY() + 15;
    }

}
