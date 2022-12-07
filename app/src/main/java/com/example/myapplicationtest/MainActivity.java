package com.example.myapplicationtest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.Math;
public class MainActivity extends AppCompatActivity {
    TextView tvInfo;
    EditText etInput;
    Button bControl;
    Button bControlExit;
    ImageView resView;
    static public int progress = 0;
    private ProgressBar pbHorizontal;

    int random_num = (int)(Math.random() * 200) + 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = (TextView)findViewById(R.id.textView3);
        etInput = (EditText) findViewById(R.id.editTextNumber2);
        bControl = (Button)findViewById(R.id.button);
        bControlExit = (Button)findViewById(R.id.buttonExit);
        resView = (ImageView) findViewById(R.id.resView);
        pbHorizontal = (ProgressBar) findViewById(R.id.pb_horizontal);
        resView.setBackgroundResource(R.drawable.img);

        bControl.setBackgroundColor(Color.RED);
        etInput.setBackgroundColor(Color.WHITE);
        bControlExit.setBackgroundColor(Color.RED);

        findViewById(android.R.id.content).getRootView().setBackgroundColor(Color.WHITE);
    }

    private void postProgress(int progress) {
        pbHorizontal.setProgress(progress);

        if (progress == 0) {
            pbHorizontal.setSecondaryProgress(0);
        } else {
            pbHorizontal.setSecondaryProgress(progress);
        }
    }

    public void onClick(View V){
        try {
            progress += 1;
            postProgress(progress);
            int user_number = Integer.parseInt(etInput.getText().toString());
            if (user_number < 0 || user_number > 200 ){
                resView.clearAnimation();
                resView.setBackgroundResource(R.drawable.img);
                tvInfo.setText(getResources().getString(R.string.number_more_then_100));
            }
            else if (user_number == random_num){
                resView.setBackgroundResource(R.drawable.good);
                tvInfo.setText(getResources().getString(R.string.hit));

                CustomDialogFragment dialog = new CustomDialogFragment();
                dialog.show(getSupportFragmentManager(), "custom");

                resView.setBackgroundResource(R.drawable.good);
                Animation transformAnimation = AnimationUtils.loadAnimation(this, R.anim.animation);
                resView.startAnimation(transformAnimation);
            }
            else if (user_number > random_num){
                resView.clearAnimation();
                resView.setBackgroundResource(R.drawable.big);
                tvInfo.setText(getResources().getString(R.string.ahead));
            }
            else{
                resView.clearAnimation();
                resView.setBackgroundResource(R.drawable.big);
                tvInfo.setText(getResources().getString(R.string.behind));
            }
        }
        catch (Exception e){
            tvInfo.setText(getResources().getString(R.string.emptyEntry));
        }
    }


    public void onClickExit(View V){
        finishAndRemoveTask();
    }
}