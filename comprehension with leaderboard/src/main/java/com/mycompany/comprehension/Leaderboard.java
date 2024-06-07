
package com.mycompany.comprehension;

import java.awt.Color;
import java.awt.Font;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Leaderboard {

    private final List<String> scores;

    public Leaderboard() {
        scores = new ArrayList<>();
        loadScores();
    }

    private void loadScores() {
        try {
            try (BufferedReader reader = new BufferedReader(new FileReader("leaderboard.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    scores.add(line);
                }
            }
            sortScores();
        } catch (IOException e) {
        }
    }

    private void sortScores() {
        Collections.sort(scores, (String s1, String s2) -> {
            int score1 = Integer.parseInt(s1.split(": ")[1].replace("%", ""));
            int score2 = Integer.parseInt(s2.split(": ")[1].replace("%", ""));
            return Integer.compare(score2, score1);
        });
    }

    public void show() {
        JFrame frame = new JFrame("Leaderboard");
        frame.setSize(400, 600);
        frame.getContentPane().setBackground(new Color(0, 0, 102));
        frame.setLayout(null);
        frame.setResizable(false);

        JTextArea leaderboardArea = new JTextArea();
        leaderboardArea.setBounds(20, 20, 360, 520);
        leaderboardArea.setBackground(new Color(70, 73, 75));
        leaderboardArea.setForeground(new Color(255, 255, 255));
        leaderboardArea.setFont(new Font("Showcard Gothic", Font.BOLD, 20));
        leaderboardArea.setEditable(false);

        StringBuilder leaderboardText = new StringBuilder("Leaderboard:\n");
        for (String score : scores) {
            leaderboardText.append(score).append("\n");
        }
        leaderboardArea.setText(leaderboardText.toString());

        frame.add(leaderboardArea);
        frame.setVisible(true);
    }
}
