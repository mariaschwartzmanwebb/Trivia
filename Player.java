class Player {
  String name;
  int score;

  Player() {
    name = "";
    score = 0;
  }

  Player(String aName) {
    name = aName;
    score = 0;
  }

  String getName() {
    return name;
  }

  int getScore() {
    return score;
  }

  void setName(String aName) {
    name = aName;
  }

  void setScore(int aScore) {
    score = aScore;
  }

  void addPoints(int points) {
    score += points;
  }
}