package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Implementing ActionListener allows us to handle button clicks
public class Login extends JFrame implements ActionListener {

    JButton rules, back;
    JTextField tfname;

    Login() {
        // Setting the frame layout to null so we can use absolute positioning (setBounds)
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // Adding the Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 600, 500); // x, y, width, height
        add(image);

        // Adding the Main Heading
        JLabel heading = new JLabel("Code Quest");
        heading.setBounds(750, 60, 300, 45);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
        heading.setForeground(new Color(30, 144, 254)); // Custom blue color
        add(heading);

        // Adding the Name Input Label
        JLabel name = new JLabel("Enter your name");
        name.setBounds(810, 150, 300, 20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        name.setForeground(new Color(30, 144, 254));
        add(name);

        // Adding the Text Field
        tfname = new JTextField();
        tfname.setBounds(735, 200, 300, 25);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfname);

        // Adding the Rules Button
        rules = new JButton("Ready");
        rules.setBounds(735, 270, 120, 25);
        rules.setBackground(new Color(30, 144, 254));
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        add(rules);

        // Adding the Back Button
        back = new JButton("Back");
        back.setBounds(915, 270, 120, 25);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        // Frame Setup
        setSize(1200, 500);
        setLocation(200, 150);
        setVisible(true);
    }

    // This method handles what happens when a button is clicked
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == rules) {
            String name = tfname.getText();
            setVisible(false); // Hide the login screen
            new Rules(name);   // Open the rules screen and pass the name
        } else if (ae.getSource() == back) {
            setVisible(false); // Close the application
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Login(); // Run the app
    }
}