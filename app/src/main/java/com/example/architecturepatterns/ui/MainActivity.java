package com.example.architecturepatterns.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.architecturepatterns.R;
import com.example.architecturepatterns.databinding.ActivityMainBinding;
import com.example.architecturepatterns.pojo.DataBase;

public class MainActivity extends AppCompatActivity implements DivView{

    ActivityMainBinding binding ;
    DivPresenter presenter;
    MulViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        // mvvm
        viewModel = new ViewModelProvider(this).get(MulViewModel.class);
        binding.setMulView(viewModel);
        binding.setLifecycleOwner(this);

        presenter = new DivPresenter(this);

        // mvc
        binding.plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.plusResultTextView.setText(getPlusResult() + "");
            }
        });

        // mvp
        binding.divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getresult();
            }
        });

    }

    // plus
    public int getPlusResult() {

        return ((new DataBase().getNumbers().getFirstNum()) + (new DataBase().getNumbers().getSecondNum()));

    }

    @Override
    public void onGetDivResult(int result) {
        binding.divResultTextView.setText(result + "");
    }
}