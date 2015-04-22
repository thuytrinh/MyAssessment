package com.thuytrinh.myassessment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class View1Activity extends ActionBarActivity {
    public static final int RC_VIEW2 = 0;

    @InjectView(R.id.resultTextView) TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view1);
        ButterKnife.inject(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == RC_VIEW2) {
            final String choice = data.getStringExtra(View2Activity.KEY_CHOICE);
            resultTextView.setText(String.format(getString(R.string.button_pressed_is_s), choice));
        } else {
            resultTextView.setText(R.string.none);
        }
    }

    @OnClick(R.id.goBlueButton)
    void onGoBlueButtonClick() {
        startActivityForResult(View2Activity.newIntent(this, 1, Color.BLUE), RC_VIEW2);
    }

    @OnClick(R.id.goRedButton)
    void onGoRedButtonClick() {
        startActivityForResult(View2Activity.newIntent(this, 2, Color.RED), RC_VIEW2);
    }

    @OnClick(R.id.goGreenButton)
    void onGoGreenButtonClick() {
        startActivityForResult(View2Activity.newIntent(this, 3, Color.GREEN), RC_VIEW2);
    }
}