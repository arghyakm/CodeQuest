package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {

    Score(String name, int score) {
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Adding a Graphic
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 200, 300, 250);
        add(image);

        // Displaying the Thank You Message
        JLabel heading = new JLabel("Thank you " + name + " for playing!");
        heading.setBounds(45, 30, 700, 30);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 26));
        heading.setForeground(new Color(20, 30, 50));
        add(heading);

        // Displaying the Final Score
        JLabel lblscore = new JLabel("Your final score is: " + score);
        lblscore.setBounds(350, 200, 300, 30);
        lblscore.setFont(new Font("Segoe UI", Font.BOLD, 26));
        lblscore.setForeground(new Color(30, 144, 255));
        add(lblscore);

        // Play Again Button
        JButton playAgain = new JButton("Play Again");
        playAgain.setBounds(380, 270, 160, 40);
        playAgain.setFont(new Font("Segoe UI", Font.BOLD, 18));
        playAgain.setBackground(new Color(30, 144, 255));
        playAgain.setForeground(Color.WHITE);
        playAgain.setFocusPainted(false);
        playAgain.setBorder(BorderFactory.createEmptyBorder());
        playAgain.setCursor(new Cursor(Cursor.HAND_CURSOR));
        playAgain.addActionListener(this);

        // Adding the dip-down animation to this button too!
        playAgain.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JButton btn = (JButton) e.getSource();
                btn.setLocation(btn.getX() + 2, btn.getY() + 2);
                btn.setBackground(new Color(20, 110, 220));
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                JButton btn = (JButton) e.getSource();
                btn.setLocation(btn.getX() - 2, btn.getY() - 2);
                btn.setBackground(new Color(30, 144, 255));
            }
        });

        add(playAgain);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new Score("Arghyakamal", 100);
    }
}