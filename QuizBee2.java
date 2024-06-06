/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

 package com.mycompany.comprehension;


 import java.io.*;
 import java.util.*;
 
 public class QuizBee {
 
     // Instantiating Variables
     private final Scanner UserInput = new Scanner(System.in);
     private int score;
     private int index = 0;
     private String ChosenLetter;
     private String currentUser;
     private final Map<String, Integer> leaderboard = new HashMap<>();
 
     // Creating Passage String Array
     private final String[] Passages = {
         "The victory of the small Greek democracy of Athens over the mighty Persian Empire in 490 B.C. is one of the most famous events in history. Darius, king of the Persian Empire, was furious because Athens had interceded for the other Greek city-states in revolt against Persian domination. In anger the king sent an enormous army to defeat Athens. He thought it would take drastic steps to pacify the rebellious part of the empire.\n" +
         "\n" +
         "Persia was ruled by one man. In Athens, however, all citizens helped to rule. Ennobled by this participation, Athenians were prepared to die for their city-state. Perhaps this was the secret of the remarkable victory at Marathon, which freed them from Persian rule. On their way to Marathon, the Persians tried to fool some Greek city-states by claiming to have come in peace. The frightened citizens of Delos refused to believe this. Not wanting to abet the conquest of Greece, they fled from their city and did not return until the Persians had left. They were wise, for the Persians next conquered the city of Eritrea and captured its people.\n" +
         "\n" +
         "Tiny Athens stood alone against Persia. The Athenian people went to their sanctuaries. There they prayed for deliverance. They asked their gods to expedite their victory. The Athenians refurbished their weapons and moved to the plain of Marathon, where their little band would meet the Persians. At the last moment, soldiers from Plataea reinforced the Athenian troops.\n" +
         "\n" +
         "The Athenian army attacked, and Greek citizens fought bravely. The power of the mighty Persians was offset by the love that the Athenians had for their city. Athenians defeated the Persians in both archery and hand combat. Greek soldiers seized Persian ships and burned them, and the Persians fled in terror. Herodotus, a famous historian, reports that 6,400 Persians died, compared to only 192 Athenians.", 
         "One of the most intriguing stories of the Russian Revolution concerns the identity of Anastasia, the youngest daughter of Czar Nicholas II. During his reign over Russia, the czar had planned to revoke many of the harsh laws established by previous czars. Some workers and peasants, however, clamored for more rapid social reform. In 1918, a group of these people known as Bolsheviks overthrew the government. On July 17 or 18, they murdered the czar and what was thought to be his entire family.\n" +
         "\n" +
         "Although witnesses vouched that all the members of the czar’s family had been executed, there were rumors suggesting that Anastasia had survived. Over the years, a number of women claimed to be Grand Duchess Anastasia. Perhaps the most famous claimant was Anastasia Tschaikovsky, who was also known as Anna Anderson.\n" +
         "\n" +
         "In 1920, 18 months after the czar’s execution, this terrified young woman was rescued from drowning in a Berlin river. She spent two years in a hospital, where she attempted to reclaim her health and shattered mind. The doctors and nurses thought that she resembled Anastasia and questioned her about her background. She disclaimed any connection with the czar’s family. Eight years later, however, she claimed that she was Anastasia. She said that she had been rescued by two Russian soldiers after the czar and the rest of her family had been killed. Two brothers named Tschaikovsky had carried her into Romania. She had married one of the brothers, who had taken her to Berlin and left her there, penniless and without a vocation. Unable to invoke the aid of her mother’s family in Germany, she had tried to drown herself.\n" +
         "\n" +
         "During the next few years, scores of the czar’s relatives, ex-servants, and acquaintances interviewed her. Many of these people said that her looks and mannerisms were evocative of the Anastasia that they had known. Her grandmother and other relatives denied that she was the real Anastasia, however.\n" +
         "\n" +
         "Tired of being accused of fraud, Anastasia immigrated to the United States in 1928 and took the name Anna Anderson. She still wished to prove that she was Anastasia, though, and returned to Germany in 1933 to bring suit against her mother’s family. There she declaimed to the court, asserting that she was indeed Anastasia and deserved her inheritance.\n" +
         "\n" +
         "In 1957, the court decided that it could neither confirm nor deny Anastasia’s identity. Although it will probably never be known whether this woman was the Grand Duchess Anastasia, her search to establish her identity has been the subject of numerous books, plays, and movies."
     };
 
     // Passage1
     private final String[] Questions1 = {
         "Athens had _________ the other Greek city-states against the Persians.",
         "Darius took drastic steps to ________ the rebellious Athenians.",
         "Their participation _________ to the Athenians.",
         "The people of Delos did not want to ______ the conquest of Greece.",
         "The Athenians were _________ by some soldiers who arrived from Plataea."
     };
 
     private final String[] choices1 = {
         "A. intervened on behalf of\nB. wanted to fight\nC. refused help to",
         "A. help\nB. pursuade\nC. irritate",
         "A. gave trust\nB. gave strength\nC. gave honor",
         "A. end\nB. encourage\nC. think about",
         "A. comprehended\nB. strengthened\nC. compromised"
     };
 
     private final char[] answers1 = {'A', 'C', 'C', 'B', 'B'};
 
     // Passage2
     private final String[] Questions2 = {
         "Some Russian peasants and workers ______ for social reform.",
         "Witnesses ______ that all members of the czar’s family had been executed.",
         "Tschaikovsky initially ______ any connection with the czar’s family.",
         "She was unable to ______ the aid of her relatives.",
         "In court she _________ maintaining that she was Anastasia and deserved her inheritance."
     };
 
     private final String[] choices2 = {
         "A. asked\nB. cried out\nC. were desperate",
         "A. thought\nB. gave assurance\nC. convinced some",
         "A. denied\nB. stopped\nC. justified",
         "A. noted\nB. call upon\nC. know",
         "A. finally appeared\nB. spoke forcefully\nC. Answer not available"
     };
 
     private final char[] answers2 = {'B', 'B', 'A', 'B', 'B'};
 
     // EXCEPTIONS
 
     // user defined
     class InvalidLetterException extends Exception {
         public InvalidLetterException() {
             super("The entered letter is not in the choices, please try again.");
         }
     }
 
     class BlankException extends Exception {
         public BlankException() {
             super("No answer, please try again.");
         }
     }
 
     class NumberException extends Exception {
         public NumberException() {
             super("You've inputted a number, please try again.");
         }
     }
 
     class SpecialCharException extends Exception {
         public SpecialCharException() {
             super("You've inputted a special characters/symbols, please try again.");
         }
     }
 
     // WRITE INPUT METHOD
     public void writeInput() {
         try {
             // loop for printing passages and questions
 
             // Passage 1
             System.out.println("Passage 1");
             System.out.println(Passages[0]);
             do {
                 System.out.println((index + 1) + "." + Questions1[index]);
                 System.out.println(choices1[index]);
                 ChosenLetter = UserInput.nextLine().toUpperCase();
                 // This checks if the users input is blank
                 if (ChosenLetter.isEmpty() || ChosenLetter.isBlank() || ChosenLetter == null) {
                     throw new BlankException();
                 }
 
                 // This checks if the user input is in the choices
                 else if (ChosenLetter.charAt(0) == 'A' || ChosenLetter.charAt(0) == 'B' || ChosenLetter.charAt(0) == 'C') {
                     // This will add the score of the user once their input matches within the correct answer
                     if (ChosenLetter.charAt(0) == answers1[index]) {
                         score++;
                     }
                 }
                 // This will throw if the input of the user is a number
                 else if (Character.isDigit(ChosenLetter.charAt(0))) {
                     throw new NumberException();
                 }
                 // Throws if user input is a special character
                 else if (Character.isLetter(ChosenLetter.charAt(0)) == false) {
                     throw new SpecialCharException();
                 }
                 // Otherwise, if the user enters a letter that is outside the letter
                 else {
                     throw new InvalidLetterException();
                 }
                 index++;
             } while (index < 5);
 
             // resets the index for the next passage
             index = 0;
 
             // Passage 2
             System.out.println("Passage 2");
             System.out.println(Passages[1]);
             do {
                 System.out.println((index + 1) + "." + Questions2[index]);
                 System.out.println(choices2[index]);
                 ChosenLetter = UserInput.nextLine().toUpperCase();
                 // This checks if the users input is blank
                 if (ChosenLetter.isEmpty() || ChosenLetter.isBlank() || ChosenLetter == null) {
                     throw new BlankException();
                 }
 
                 // This checks if the user input is in the choices
                 else if (ChosenLetter.charAt(0) == 'A' || ChosenLetter.charAt(0) == 'B' || ChosenLetter.charAt(0) == 'C') {
                     // This will add the score of the user once their input matches within the correct answer
                     if (ChosenLetter.charAt(0) == answers2[index]) {
                         score++;
                     }
                 }
                 // This will throw if the input of the user is a number
                 else if (Character.isDigit(ChosenLetter.charAt(0))) {
                     throw new NumberException();
                 }
                 // Throws if user input is a special character
                 else if (Character.isLetter(ChosenLetter.charAt(0)) == false) {
                     throw new SpecialCharException();
                 }
                 index++;
             } while (index < 5);
             System.out.println("Your total score is: " + score + " over 10!");
             updateLeaderboard();
             displayLeaderboard();
         }
         // CATCHING EXCEPTIONS
         catch (BlankException NoAnswer) {
             System.out.println(NoAnswer.getMessage());
             this.writeInput();
         }
         catch (NumberException aNumber) {
             System.out.println(aNumber.getMessage());
             this.writeInput();
         }
         catch (SpecialCharException specialChar) {
             System.out.println(specialChar.getMessage());
             this.writeInput();
         }
         catch (InvalidLetterException OutOfRange) {
             System.out.println(OutOfRange.getMessage());
             this.writeInput();
         }
     }
 
     public void loadUsers() {
         try (BufferedReader reader = new BufferedReader(new FileReader("words.txt"))) {
             String line;
             while ((line = reader.readLine()) != null) {
                 leaderboard.put(line, 0); // Initialize leaderboard with user names and 0 scores
             }
         } catch (IOException e) {
             System.out.println("Error reading users from words.txt: " + e.getMessage());
         }
     }
 
     public void updateLeaderboard() {
         leaderboard.put(currentUser, score);
     }
 
     public void displayLeaderboard() {
         System.out.println("Leaderboard:");
         leaderboard.entrySet().stream()
                 .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                 .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
     }
 
     public void startQuiz() {
         loadUsers();
         System.out.println("Enter your username:");
         currentUser = UserInput.nextLine();
         if (!leaderboard.containsKey(currentUser)) {
             System.out.println("Username not found. Please make sure your username is in the words.txt file.");
             return;
         }
         writeInput();
     }
 
     public static void main(String[] args) {
         System.out.println("Welcome to Reading Comprehension Evaluator!");
         System.out.println("Instructions: Type the letter of the most appropriate answer and gain score");
         QuizBee Quiz = new QuizBee();
         Quiz.startQuiz();
     }
 }
 