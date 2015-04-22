package com.thuytrinh.myassessment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class View2Activity extends ActionBarActivity {
    public static final String KEY_CHOICE = "choice";
    public static final String KEY_COLOR = "color";

    @InjectView(R.id.choiceTextView) TextView choiceTextView;
    @InjectView(R.id.containerView) View containerView;

    public static Intent newIntent(Context context, int choice, int color) {
        final Intent intent = new Intent(context, View2Activity.class);
        intent.putExtra(KEY_CHOICE, choice);
        intent.putExtra(KEY_COLOR, color);
        return intent;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view2);
        ButterKnife.inject(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final int choice = getIntent().getIntExtra(KEY_CHOICE, 1);
        choiceTextView.setText(String.format(getString(R.string.button_pressed_is), choice));

        final int color = getIntent().getIntExtra(KEY_COLOR, Color.BLUE);
        containerView.setBackgroundColor(color);
    }

    @OnClick(R.id.goOneButton)
    void onGoOneButtonClick() {
        dismissSelf(getString(R.string.one));
    }

    @OnClick(R.id.goTwoButton)
    void onGoTwoButtonClick() {
        dismissSelf(getString(R.string.two));
    }

    @OnClick(R.id.goThreeButton)
    void onGoThreeButtonClick() {
        dismissSelf(getString(R.string.three));
    }

    @OnClick(R.id.goLastButton)
    void onGoLastButtonClick() {
        startActivity(new Intent(this, View3Activity.class));
    }

    private void dismissSelf(String choice) {
        final Intent data = new Intent();
        data.putExtra(KEY_CHOICE, choice);
        setResult(RESULT_OK, data);
        finish();
    }
}