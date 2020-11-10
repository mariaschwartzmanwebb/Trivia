class Question {
  String text;
  String ans1, ans2, ans3, ans4;
  int correctAns;
  int points;

  Question(String aText, String aAns1, String aAns2, String aAns3, String aAns4, int aCorrectAns, int aPoints) {
    text = aText;
    ans1 = aAns1;
    ans2 = aAns2;
    ans3 = aAns3;
    ans4 = aAns4;
    correctAns = aCorrectAns;
    points = aPoints;
  }

  String getText() {
    return text;
  }

  String getAns1() {
    return ans1;
  }

  String getAns2() {
    return ans2;
  }

  String getAns3() {
    return ans3;
  }

  String getAns4() {
    return ans4;
  }

  int getCorrectAns() {
    return correctAns;
  }

  int getPoints() {
    return points;
  }

}