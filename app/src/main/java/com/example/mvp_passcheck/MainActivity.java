package com.example.mvp_passcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.IpPrefix;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mvp_passcheck.databinding.ActivityMainBinding;
import com.example.mvp_passcheck.presenter.IPresenter;
import com.example.mvp_passcheck.presenter.IViewPresenter;
import com.example.mvp_passcheck.presenter.VerifierPresenter;

public class MainActivity extends AppCompatActivity implements IViewPresenter {
    public static final String TAG = MainActivity.class.getSimpleName(); // trae el nombre de donde estoy
    private ActivityMainBinding mBinding;
    private IPresenter mPresenter;
    TextView imgX;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater()); // asi se implementa Binding
       // setContentView(R.layout.activity_main); se cambia por mBinding.getRoot()
        setContentView(mBinding.getRoot());
        mPresenter = new VerifierPresenter(this);
        mBinding.etPass.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            Log.d(TAG,"changed "+charSequence.toString());
            mPresenter.evaluatePass(charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {
            }

        });
    }

    @Override
    public void showWeak() {
       Log.d(TAG,"WEAK");
        mBinding.tvColor.setText("WEAK");
        Drawable shape = (Drawable) mBinding.tvColor.getBackground();
        shape.setColorFilter(getColor(R.color.colorRojo), android.graphics.PorterDuff.Mode.SRC);

    }

    @Override
    public void showMedium() {
        Log.d(TAG,"MEDIUM");
        mBinding.tvColor.setText("MEDIUM");
        Drawable shape = (Drawable) mBinding.tvColor.getBackground();
        shape.setColorFilter(getColor(R.color.colorNaranjo), android.graphics.PorterDuff.Mode.SRC);
    }

    @Override
    public void showStrong() {
        Log.d(TAG,"STRONG");
        mBinding.tvColor.setText("STRONG");
        Drawable shape = (Drawable) mBinding.tvColor.getBackground();
        shape.setColorFilter(getColor(R.color.colorVerde), android.graphics.PorterDuff.Mode.SRC);
    }
}