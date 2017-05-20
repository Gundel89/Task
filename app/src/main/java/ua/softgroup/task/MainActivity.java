package ua.softgroup.task;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import ua.softgroup.task.listeners.RegistrationOnClickListener;
import ua.softgroup.task.listeners.SubmitOnClickListener;

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private EditText pass;
    private Button submit;
    private Button registration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initElements();

        submit.setOnClickListener(new SubmitOnClickListener(this, email, pass));
        registration.setOnClickListener(new RegistrationOnClickListener());
    }

    private void initElements() {
        email = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.password);
        submit = (Button) findViewById(R.id.submit);
        registration = (Button) findViewById(R.id.registration);
    }
}
