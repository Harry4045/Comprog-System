/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.comprehension;

/**
 *
 * @author ficti
 */
import java.io.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

public class dashboard implements ActionListener{

    String[] questions = {"Athens had _________ the other Greek city-states against the Persians." , 
                        "Darius took drastic steps to ________ the rebellious Athenians." ,
                        "Their participation _________ to the Athenians." , 
                        "The people of Delos did not want to ______ the conquest of Greece." ,
                        "The Athenians were _________ by some soldiers who arrived from Plataea."};

    String[][] options = {
                        {"A. intervened on behalf of", "B. wanted to fight", "C. refused help to","D. irritate"},
                        {"A. help","B. pursuade","C. irritate","D. refused help to"},
                        {"A. gave trust","B. gave strength","C. gave honor","D. refused help to"},
                        {"A. end","B. encourage","C. think about","D. refused help to"},
                        {"A. comprehended","B. strengthened","C. compromised","D. refused help to"},
                        };

    char[] answers = {
                      'A' , 'C' , 'C' , 'B', 'B'
                     };

    char guess;
    char answer;
    int index;
    int correct_guesses = 0;
    int total_questions = questions.length;
    int result;
    int seconds = 10;


    JFrame frame = new JFrame();
    JTextField textfield = new JTextField();
    JTextArea textarea = new JTextArea();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();
    JButton buttonE = new JButton();
    JLabel answer_labelA = new JLabel();
    JLabel answer_labelB = new JLabel();
    JLabel answer_labelC = new JLabel();
    JLabel answer_labelD = new JLabel();
    JLabel time_label = new JLabel();
    JLabel seconds_left = new JLabel();
    JTextField number_right = new JTextField();
    JTextField percentage = new JTextField();
        
    Timer timer = new Timer(1000, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			seconds--;
			seconds_left.setText(String.valueOf(seconds));
			if(seconds<=0) {
				displayAnswer();
			}
			}
		});
    
    public dashboard(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(750,850);
		frame.getContentPane().setBackground(new Color(0,0,102));
		frame.setLayout(null);
		frame.setResizable(false);
		
		textfield.setBounds(0,0,750,70);
		textfield.setBackground(new Color(70,73,75));
		textfield.setForeground(new Color(255,255,255));
		textfield.setFont(new Font("Showcard Gothic",Font.BOLD,30));
		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);
		
		textarea.setBounds(50,80,660,150);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setBackground(new Color(70,73,75));
		textarea.setForeground(new Color(255,255,255));
		textarea.setFont(new Font("Showcard Gothic",Font.BOLD,25));
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		textarea.setEditable(false);
		
		buttonA.setBounds(10,300,100,100);
		buttonA.setFont(new Font("Showcard Gothic",Font.BOLD,35));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setText("A");
		
		buttonB.setBounds(10,400,100,100);
		buttonB.setFont(new Font("Showcard Gothic",Font.BOLD,35));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("B");
		
		buttonC.setBounds(10,500,100,100);
		buttonC.setFont(new Font("Showcard Gothic",Font.BOLD,35));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setText("C");
		
		buttonD.setBounds(10,600,100,100);
		buttonD.setFont(new Font("Showcard Gothic",Font.BOLD,35));
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		buttonD.setText("D");
                
                buttonE.setBounds(10,700,150,80);
		buttonE.setFont(new Font("Showcard Gothic",Font.BOLD,30));
		buttonE.setFocusable(false);
		buttonE.addActionListener(this);
		buttonE.setText("BACK");
		
		answer_labelA.setBounds(125,300,500,100);
		answer_labelA.setBackground(new Color(50,50,50));
		answer_labelA.setForeground(new Color(255,255,255));
		answer_labelA.setFont(new Font("Showcard Gothic",Font.BOLD,25));
		
		answer_labelB.setBounds(125,400,500,100);
		answer_labelB.setBackground(new Color(50,50,50));
		answer_labelB.setForeground(new Color(255,255,255));
		answer_labelB.setFont(new Font("Showcard Gothic",Font.BOLD,25));
		
		answer_labelC.setBounds(125,500,500,100);
		answer_labelC.setBackground(new Color(50,50,50));
		answer_labelC.setForeground(new Color(255,255,255));
		answer_labelC.setFont(new Font("Showcard Gothic",Font.BOLD,25));
		
		answer_labelD.setBounds(125,600,500,100);
		answer_labelD.setBackground(new Color(50,50,50));
		answer_labelD.setForeground(new Color(255,255,255));
		answer_labelD.setFont(new Font("Showcard Gothic",Font.BOLD,25));
		
		seconds_left.setBounds(630,670,100,100);
		seconds_left.setBackground(new Color(25,25,25));
		seconds_left.setForeground(new Color(255,255,255));
		seconds_left.setFont(new Font("Showcard Gothic",Font.BOLD,60));
		seconds_left.setBorder(BorderFactory.createBevelBorder(1));
		seconds_left.setOpaque(true);
		seconds_left.setHorizontalAlignment(JTextField.CENTER);
		seconds_left.setText(String.valueOf(seconds));
		
		time_label.setBounds(630,770,100,25);
		time_label.setBackground(new Color(50,50,50));
		time_label.setForeground(new Color(255,255,255));
		time_label.setFont(new Font("Showcard Gothic",Font.BOLD,16));
		time_label.setHorizontalAlignment(JTextField.CENTER);
		time_label.setText("TIMER");
		
		number_right.setBounds(300,280,200,100);
		number_right.setBackground(new Color(25,25,25));
		number_right.setForeground(new Color(255,255,255));
		number_right.setFont(new Font("Showcard Gothic",Font.BOLD,50));
		number_right.setBorder(BorderFactory.createBevelBorder(1));
		number_right.setHorizontalAlignment(JTextField.CENTER);
		number_right.setEditable(false);
		
		percentage.setBounds(300,400,200,100);
		percentage.setBackground(new Color(25,25,25));
		percentage.setForeground(new Color(255,255,255));
		percentage.setFont(new Font("Showcard Gothic",Font.BOLD,50));
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setEditable(false);
		
		frame.add(time_label);
		frame.add(seconds_left);
		frame.add(answer_labelA);
		frame.add(answer_labelB);
		frame.add(answer_labelC);
		frame.add(answer_labelD);
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(buttonC);
		frame.add(buttonD);
                
		frame.add(textarea);
		frame.add(textfield);
		frame.setVisible(true);
        
        nextQuestion();
    }
        public void nextQuestion() {
		
		if(index>=total_questions) {
			results();
		}
		else {
			textfield.setText("Question "+(index+1));
			textarea.setText(questions[index]);
			answer_labelA.setText(options[index][0]);
			answer_labelB.setText(options[index][1]);
			answer_labelC.setText(options[index][2]);
			answer_labelD.setText(options[index][3]);
			timer.start();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
			buttonA.setEnabled(false);
			buttonB.setEnabled(false);
			buttonC.setEnabled(false);
			buttonD.setEnabled(false);
                        buttonE.setEnabled(false);
			
			if(e.getSource()==buttonA) {
				answer= 'A';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonB) {
				answer= 'B';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonC) {
				answer= 'C';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonD) {
				answer= 'D';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
                        
			displayAnswer();
	}
	public void displayAnswer() {
		
		timer.stop();
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
                buttonE.setEnabled(false);
		
		if(answers[index] != 'A')
			answer_labelA.setForeground(new Color(255,0,0));
		if(answers[index] != 'B')
			answer_labelB.setForeground(new Color(255,0,0));
		if(answers[index] != 'C')
			answer_labelC.setForeground(new Color(255,0,0));
		if(answers[index] != 'D')
			answer_labelD.setForeground(new Color(255,0,0));
		
		Timer pause = new Timer(2000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				answer_labelA.setForeground(new Color(255,255,255));
				answer_labelB.setForeground(new Color(255,255,255));
				answer_labelC.setForeground(new Color(255,255,255));
				answer_labelD.setForeground(new Color(255,255,255));
				
				answer = ' ';
				seconds=10;
				seconds_left.setText(String.valueOf(seconds));
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);
				buttonD.setEnabled(true);
                                buttonE.setEnabled(true);
				index++;
				nextQuestion();
			}
		});
		pause.setRepeats(false);
		pause.start();
	}
	public void results(){
		
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        buttonE.setEnabled(false);

        result = (int)((correct_guesses/(double)total_questions)*100);

        textfield.setText("RESULTS!");
        textarea.setText("");
        answer_labelA.setText("");
        answer_labelB.setText("");
        answer_labelC.setText("");
        answer_labelD.setText("");

        number_right.setText("("+correct_guesses+"/"+total_questions+")");
        percentage.setText(result+"%");

        saveScore(result); // Save the score

        Leaderboard leaderboard = new Leaderboard();
        leaderboard.show();

        frame.add(number_right);
        frame.add(percentage);
    }

    private void saveScore(int score) {
        try {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("leaderboard.txt", true))) {
                writer.write("Player: " + score + "%");
                writer.newLine();
            }
        } catch (IOException e) {
        }
    }
}

