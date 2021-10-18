package com.teratail.q364702;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.*;
import androidx.lifecycle.*;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    MainViewModel viewmodel = new ViewModelProvider(this).get(MainViewModel.class);
    viewmodel.setTransitioner(tc -> {
      switch(tc) {
        case TO_TITLE:   changeFragment(new TitleFragment());   break;
        case TO_MAIN:    changeFragment(new MainFragment());    break;
        case TO_RESULT:  changeFragment(new ResultFragment());  break;
        case TO_RANKING: changeFragment(new RankingFragment()); break;
        case APP_FINISH: finish();
      }
    });

    changeFragment(new TitleFragment());
  }

  void changeFragment(Fragment f) {
    getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.container, f)
            .commit();
  }
}

