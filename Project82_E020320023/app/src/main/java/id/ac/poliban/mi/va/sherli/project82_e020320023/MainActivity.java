package id.ac.poliban.mi.va.sherli.project82_e020320023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
    }

    public void btlogin(View view) {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    public void btsignup(View view) {
        Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
        startActivity(intent);
    }
}