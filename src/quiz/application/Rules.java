package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {

    String name;
    JButton start, back;

    // Constructor accepts the name passed from the Login screen
    Rules(String name) {
        this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Welcome Heading
        JLabel heading = new JLabel("Welcome " + name + " to Code Quest ");
        heading.setBounds(50, 20, 700, 30);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 28));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);

        // The Rules Text (Using HTML tags for clean paragraph formatting)
        JLabel rules = new JLabel();
        rules.setBounds(20, 90, 700, 350);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rules.setText(
                "<html>"+
                        "1. You are trained to be a programmer and not a story teller, answer point to point!" + "<br><br>" +
                        "2. Do not unnecessarily smile at the person sitting next to you, they may also not know the answer..." + "<br><br>" +
                        "3. You may have a lot of options in life but here all the questions are compulsory." + "<br><br>" +
                        "4. Crying is allowed but please do so quietly." + "<br><br>" +
                        "5. Only a fool asks and a wise man answers (Be wise, not otherwise)." + "<br><br>" +
                        "6. Do not get nervous if your friend is answering more questions, may be he/she is doing Jai Mata Di." + "<br><br>" +
                        "7. Brace yourself, this paper is not for the faint hearted." + "<br><br>" +
                        "8. May you know more than what John Snow knows, Good Luck." + "<br><br>" +
                        "</html>"
        );
        add(rules);

        // Back Button
        back = new JButton("Back");
        back.setBounds(250, 500, 100, 30);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        // Start Game Button
        start = new JButton("Start");
        start.setBounds(400, 500, 100, 30);
        start.setBackground(new Color(30, 144, 254));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);

        // Frame Setup
        setSize(800, 650);
        setLocation(350, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new Quiz(name); // Successfully opens the Quiz screen
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Login(); // Goes back to the Login screen
        }
    }

    public static void main(String[] args) {
        // Testing
        new Rules("Arghyakamal");
    }
}