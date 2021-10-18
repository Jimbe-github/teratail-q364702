package com.teratail.q364702;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
  enum TransitionContents {
    TO_TITLE, TO_MAIN, TO_RESULT, TO_RANKING, APP_FINISH;
  }

  interface Transitioner {
    void transition(TransitionContents tc);
  }

  private Transitioner transitioner;

  void setTransitioner(Transitioner t) {
    this.transitioner = t;
  }

  void transition(TransitionContents sc) {
    transitioner.transition(sc);
  }

  private int score;
  int getScore() { return score; }
  void setScore(int score) { this.score = score; }
}
