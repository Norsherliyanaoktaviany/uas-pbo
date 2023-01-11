package id.ac.poliban.mi.va.sherli.fda_e020320023.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import id.ac.poliban.mi.va.sherli.fda_e020320023.R;

public class IntroActivity extends AppCompatActivity {
    private ConstraintLayout startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        startBtn = findViewById(R.id.startBtn);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IntroActivity.this, MainActivity.class));
            }
        });
    }
}