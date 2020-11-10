import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Game implements ActionListener {
  ArrayList<Question> questions;
  String filename;
  FileReader myFile;
  Player player1;
  int qNumber;
  JFrame frame;
  JLabel score;

  Game() {
    player1 = new Player("Maria");
    questions = new ArrayList<Question>();
    qNumber = 0;
    filename = "usageography_bank.txt";
    try {
      myFile = new FileReader(filename);
      BufferedReader reader = new BufferedReader(myFile);
      String qText, a1, a2, a3, a4, correctA, pts;

      while (reader.ready()) {
        qText = reader.readLine();
        a1 = reader.readLine();
        a2 = reader.readLine();
        a3 = reader.readLine();
        a4 = reader.readLine();
        correctA = reader.readLine();
        pts = reader.readLine();
        Question theQ = new Question(qText, a1, a2, a3, a4, Integer.parseInt(correctA), Integer.parseInt(pts));
        questions.add(theQ);
      }
      reader.close();
    } catch (IOException exception) {
      System.out.println("An error occurred: " + exception);
    }

    
    frame = new JFrame("Trivia Game");
    frame.setLayout(new FlowLayout());
    frame.setSize(800,500);

    JLabel welcome = new JLabel("<html><font size=20 color=blue>Welcome to the trivia game, " + player1.getName() + "<html><br><br><br></font></html>");

    frame.add(welcome);

    //for(int i=0; i < questions.size(); i++) {

      qNumber = 0;
      nextQuestion(qNumber);

      
    //}



    
  }

  public void actionPerformed(ActionEvent ae) {
    if(ae.getActionCommand().equals(questions.get(qNumber).getAns1()) && questions.get(qNumber).getCorrectAns()==1) {
      player1.addPoints(questions.get(qNumber).getPoints());
      score.setText("Your score is: " + player1.getScore());
    }
    else if(ae.getActionCommand().equals(questions.get(qNumber).getAns2()) && questions.get(qNumber).getCorrectAns()==2) {
      player1.addPoints(questions.get(qNumber).getPoints());
      score.setText("Your score is: " + player1.getScore());
    }
    else if(ae.getActionCommand().equals(questions.get(qNumber).getAns3()) && questions.get(qNumber).getCorrectAns()==3) {
      player1.addPoints(questions.get(qNumber).getPoints());
      score.setText("Your score is: " + player1.getScore());
    }
    else if(ae.getActionCommand().equals(questions.get(qNumber).getAns4()) && questions.get(qNumber).getCorrectAns()==4) {
      player1.addPoints(questions.get(qNumber).getPoints());
      score.setText("Your score is: " + player1.getScore());
    }
    else if(ae.getActionCommand().equals("Next") && (qNumber != questions.size())) {
      qNumber++;
      frame.setVisible(false);
      frame.getContentPane().removeAll();
      frame.repaint();
      nextQuestion(qNumber);
    }
    
    else {

    }
    }

    public void nextQuestion(int i) {
      JLabel questionText = new JLabel("<html><font size=5>" + questions.get(i).getText() + "<br><br>");

      JButton ans1Button = new JButton(questions.get(i).getAns1());
      JButton ans2Button = new JButton(questions.get(i).getAns2());
      JButton ans3Button = new JButton(questions.get(i).getAns3());
      JButton ans4Button = new JButton(questions.get(i).getAns4());

      JLabel worthPoints = new JLabel("\nThis is worth " + questions.get(i).getPoints() + " points");

      score = new JLabel("\nYour score is: " + player1.getScore());

      ans1Button.addActionListener(this);
      ans2Button.addActionListener(this);
      ans3Button.addActionListener(this);
      ans4Button.addActionListener(this);

      frame.add(questionText);
      frame.add(worthPoints);

      frame.add(ans1Button);
      frame.add(ans2Button);
      frame.add(ans3Button);
      frame.add(ans4Button);

      frame.add(score);

      if(++i < questions.size()) {
        JButton next = new JButton("Next");
        next.addActionListener(this);

        frame.add(next);
      }
      else {
        JLabel finalScore = new JLabel("Game complete. Your final score is: " + player1.getScore());
        frame.add(finalScore);
      }

      frame.setVisible(true);
    }
}