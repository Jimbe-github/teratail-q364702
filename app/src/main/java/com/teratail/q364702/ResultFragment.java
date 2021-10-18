package com.teratail.q364702;

import android.os.Bundle;
import android.view.*;

import androidx.annotation.*;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class ResultFragment extends Fragment {
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_result, container, false);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    MainViewModel vm = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

    View.OnClickListener clickListener = new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        switch(v.getId()) {
          case R.id.toTitleButton: vm.transition(MainViewModel.TransitionContents.TO_TITLE); break;
          case R.id.toMainButton: vm.transition(MainViewModel.TransitionContents.TO_MAIN); break;
          case R.id.toRankingButton: vm.transition(MainViewModel.TransitionContents.TO_RANKING); break;
          case R.id.finishButton: vm.transition(MainViewModel.TransitionContents.APP_FINISH); break;
        }
      }
    };

    view.findViewById(R.id.toTitleButton).setOnClickListener(clickListener);
    view.findViewById(R.id.toMainButton).setOnClickListener(clickListener);
    view.findViewById(R.id.toRankingButton).setOnClickListener(clickListener);
    view.findViewById(R.id.finishButton).setOnClickListener(clickListener);

    //int score = vm.getScore();
  }
}