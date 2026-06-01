package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

public class Quiz extends JFrame implements ActionListener {

    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];

    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit;

    public int timer = 15;
    public int ans_given = 0;
    public int count = 0;
    public int score = 0;

    String name;

    Quiz(String name) {
        this.name = name;
        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // BANNER IMAGE INTEGRATION
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1440, 392);
        add(image);


        // MODERN UI STYLING FOR LABELS
        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Segoe UI", Font.BOLD, 24));
        qno.setForeground(new Color(20, 30, 50));
        add(qno);

        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Segoe UI", Font.BOLD, 24));
        question.setForeground(new Color(20, 30, 50));
        add(question);


        // The Master Question Bank (25 Questions)
        String qBank[][] = new String[25][5];
        String aBank[][] = new String[25][2];

        qBank[0][0] = "Which is used to find and fix bugs in the Java programs?";
        qBank[0][1] = "JVM"; qBank[0][2] = "JRE"; qBank[0][3] = "JDK"; qBank[0][4] = "JDB";
        aBank[0][1] = "JDB";

        qBank[1][0] = "What is the return type of the hashCode() method in the Object class?";
        qBank[1][1] = "int"; qBank[1][2] = "Object"; qBank[1][3] = "long"; qBank[1][4] = "void";
        aBank[1][1] = "int";

        qBank[2][0] = "Which package contains the Random class?";
        qBank[2][1] = "java.util package"; qBank[2][2] = "java.lang package"; qBank[2][3] = "java.awt package"; qBank[2][4] = "java.io package";
        aBank[2][1] = "java.util package";

        qBank[3][0] = "An interface with no fields or methods is known as?";
        qBank[3][1] = "Runnable Interface"; qBank[3][2] = "Abstract Interface"; qBank[3][3] = "Marker Interface"; qBank[3][4] = "CharSequence Interface";
        aBank[3][1] = "Marker Interface";

        qBank[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        qBank[4][1] = "Stack"; qBank[4][2] = "String memory"; qBank[4][3] = "Random storage space"; qBank[4][4] = "Heap memory";
        aBank[4][1] = "Heap memory";

        qBank[5][0] = "Which of the following is a marker interface?";
        qBank[5][1] = "Runnable interface"; qBank[5][2] = "Remote interface"; qBank[5][3] = "Readable interface"; qBank[5][4] = "Result interface";
        aBank[5][1] = "Remote interface";

        qBank[6][0] = "Which keyword is used for accessing the features of a package?";
        qBank[6][1] = "import"; qBank[6][2] = "package"; qBank[6][3] = "extends"; qBank[6][4] = "export";
        aBank[6][1] = "import";

        qBank[7][0] = "In java, jar stands for?";
        qBank[7][1] = "Java Archive Runner"; qBank[7][2] = "Java Archive"; qBank[7][3] = "Java Application Resource"; qBank[7][4] = "Java Application Runner";
        aBank[7][1] = "Java Archive";

        qBank[8][0] = "Which of the following is a mutable class in java?";
        qBank[8][1] = "java.lang.String"; qBank[8][2] = "java.lang.Byte"; qBank[8][3] = "java.lang.Short"; qBank[8][4] = "java.lang.StringBuilder";
        aBank[8][1] = "java.lang.StringBuilder";

        qBank[9][0] = "Which of the following option leads to the portability and security of Java?";
        qBank[9][1] = "Bytecode is executed by JVM"; qBank[9][2] = "The applet makes the Java code secure and portable"; qBank[9][3] = "Use of exception handling"; qBank[9][4] = "Dynamic binding between objects";
        aBank[9][1] = "Bytecode is executed by JVM";

        qBank[10][0] = "Which component is used to compile, debug and execute the java programs?";
        qBank[10][1] = "JRE"; qBank[10][2] = "JIT"; qBank[10][3] = "JDK"; qBank[10][4] = "JVM";
        aBank[10][1] = "JDK";

        qBank[11][0] = "Which of these cannot be used for a variable name in Java?";
        qBank[11][1] = "identifier & keyword"; qBank[11][2] = "identifier"; qBank[11][3] = "keyword"; qBank[11][4] = "none of the mentioned";
        aBank[11][1] = "keyword";

        qBank[12][0] = "What is the extension of java code files?";
        qBank[12][1] = ".js"; qBank[12][2] = ".txt"; qBank[12][3] = ".class"; qBank[12][4] = ".java";
        aBank[12][1] = ".java";

        qBank[13][0] = "Which of the following is not an OOPS concept in Java?";
        qBank[13][1] = "Polymorphism"; qBank[13][2] = "Inheritance"; qBank[13][3] = "Compilation"; qBank[13][4] = "Encapsulation";
        aBank[13][1] = "Compilation";

        qBank[14][0] = "What is the extension of compiled java classes?";
        qBank[14][1] = ".txt"; qBank[14][2] = ".js"; qBank[14][3] = ".class"; qBank[14][4] = ".java";
        aBank[14][1] = ".class";

        qBank[15][0] = "Which exception is thrown when java is out of memory?";
        qBank[15][1] = "MemoryError"; qBank[15][2] = "OutOfMemoryError"; qBank[15][3] = "MemoryOutOfBoundsException"; qBank[15][4] = "MemoryFullException";
        aBank[15][1] = "OutOfMemoryError";

        qBank[16][0] = "Which of these are selection statements in Java?";
        qBank[16][1] = "break"; qBank[16][2] = "continue"; qBank[16][3] = "for()"; qBank[16][4] = "if()";
        aBank[16][1] = "if()";

        qBank[17][0] = "Which of the following is a superclass of every class in Java?";
        qBank[17][1] = "ArrayList"; qBank[17][2] = "Abstract class"; qBank[17][3] = "Object class"; qBank[17][4] = "String";
        aBank[17][1] = "Object class";

        qBank[18][0] = "Which of these packages contains the exception Stack Overflow in Java?";
        qBank[18][1] = "java.io"; qBank[18][2] = "java.system"; qBank[18][3] = "java.lang"; qBank[18][4] = "java.util";
        aBank[18][1] = "java.lang";

        qBank[19][0] = "Which statement is true about Java?";
        qBank[19][1] = "Java is a sequence-dependent programming language"; qBank[19][2] = "Java is a code dependent programming language"; qBank[19][3] = "Java is a platform-dependent programming language"; qBank[19][4] = "Java is a platform-independent programming language";
        aBank[19][1] = "Java is a platform-independent programming language";

        qBank[20][0] = "Which one of the following is not an access modifier?";
        qBank[20][1] = "Protected"; qBank[20][2] = "Void"; qBank[20][3] = "Public"; qBank[20][4] = "Private";
        aBank[20][1] = "Void";

        qBank[21][0] = "What is the default value of a local variable?";
        qBank[21][1] = "null"; qBank[21][2] = "0"; qBank[21][3] = "Depends upon the type of variable"; qBank[21][4] = "No default value";
        aBank[21][1] = "No default value";

        qBank[22][0] = "Which method of the Class.class is used to determine the name of a class?";
        qBank[22][1] = "getClass()"; qBank[22][2] = "intern()"; qBank[22][3] = "getName()"; qBank[22][4] = "toString()";
        aBank[22][1] = "getName()";

        qBank[23][0] = "In which process, a local variable has the same name as one of the instance variables?";
        qBank[23][1] = "Serialization"; qBank[23][2] = "Variable Shadowing"; qBank[23][3] = "Abstraction"; qBank[23][4] = "Multi-threading";
        aBank[23][1] = "Variable Shadowing";

        qBank[24][0] = "What is meant by chained exceptions in Java?";
        qBank[24][1] = "Exceptions occurred by the VirtualMachineError"; qBank[24][2] = "An exception caused by other exceptions"; qBank[24][3] = "Exceptions occur in chains with discarding the debugging information"; qBank[24][4] = "None of the above";
        aBank[24][1] = "An exception caused by other exceptions";

        // The Randomization Engine
        ArrayList<Integer> randomIndices = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            randomIndices.add(i);
        }
        Collections.shuffle(randomIndices);

        for (int i = 0; i < 10; i++) {
            int selectedIndex = randomIndices.get(i);
            for (int j = 0; j < 5; j++) {
                questions[i][j] = qBank[selectedIndex][j];
            }
            answers[i][1] = aBank[selectedIndex][1];
        }

        //  Rendering the UI
        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        opt1.setForeground(new Color(50, 50, 50));
        opt1.setFocusPainted(false);
        opt1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 570, 700, 30); // Increased Y spacing to 570
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        opt2.setForeground(new Color(50, 50, 50));
        opt2.setFocusPainted(false);
        opt2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 620, 700, 30); // Increased Y spacing to 620
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        opt3.setForeground(new Color(50, 50, 50));
        opt3.setFocusPainted(false);
        opt3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 670, 700, 30); // Increased Y spacing to 670
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        opt4.setForeground(new Color(50, 50, 50));
        opt4.setFocusPainted(false);
        opt4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(opt4);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        // MODERN FLAT BUTTONS
        next = new JButton("Next");
        next.setBounds(1100, 550, 200, 40);
        next.setFont(new Font("Segoe UI", Font.BOLD, 18)); // Sleeker font
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.setFocusPainted(false); // Removes dotted box
        next.setBorder(BorderFactory.createEmptyBorder()); // Removes clunky 3D border
        next.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Adds pointer hand
        next.addActionListener(this);
        add(next);

        submit = new JButton("Submit");
        submit.setBounds(1100, 620, 200, 40);
        submit.setFont(new Font("Segoe UI", Font.BOLD, 18)); // Sleeker font
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.setFocusPainted(false);
        submit.setBorder(BorderFactory.createEmptyBorder()); // Removes clunky 3D border
        submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submit.setEnabled(false);
        submit.addActionListener(this);
        add(submit);

        start(count);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            ans_given = 1;

            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);

        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                }
            }
            setVisible(false);
            new Score(name, score);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        String time = "Time left - " + timer + " seconds";
        g.setColor(new Color(220, 53, 69)); // Slightly softer modern red
        g.setFont(new Font("Segoe UI", Font.BOLD, 22)); // Matched font style

        if (timer > 0) {
            g.drawString(time, 1100, 500);
        } else {
            g.drawString("Times up!!", 1100, 500);
        }

        timer--;

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            if (count == 9) {
                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }

                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    }
                }
                setVisible(false);
                new Score(name, score);
            } else {
                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++;
                start(count);
            }
        }
    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);

        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupoptions.clearSelection();
    }

    public static void main(String[] args) {
        new Quiz("Arghyakamal");
    }
}