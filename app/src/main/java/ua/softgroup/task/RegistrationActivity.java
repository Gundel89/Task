package ua.softgroup.task;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import ua.softgroup.task.listeners.SignUpOnClickListener;

public class RegistrationActivity extends AppCompatActivity {

    private EditText email;
    private EditText pass;
    private EditText confirm;

    private Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        initElements();

        signUp.setOnClickListener(new SignUpOnClickListener(this, email, pass, confirm));
    }

    private void initElements() {
        email = (EditText) findViewById(R.id.regEmail);
        pass = (EditText) findViewById(R.id.regPassword);
        confirm = (EditText) findViewById(R.id.confirm);
        signUp = (Button) findViewById(R.id.registrate);
    }
}
