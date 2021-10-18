package com.teratail.q364702;

import android.os.Bundle;
import android.view.*;

import androidx.annotation.*;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class TitleFragment extends Fragment {
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_title, container, false);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    MainViewModel vm = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

    View.OnClickListener clickListener = new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        switch(v.getId()) {
          case R.id.toMainButton: vm.transition(MainViewModel.TransitionContents.TO_MAIN); break;
          case R.id.toRankingButton: vm.transition(MainViewModel.TransitionContents.TO_RANKING); break;
        }
      }
    };

    view.findViewById(R.id.toMainButton).setOnClickListener(clickListener);
    view.findViewById(R.id.toRankingButton).setOnClickListener(clickListener);
  }
}