package ua.softgroup.task.listeners;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

import java.security.NoSuchAlgorithmException;

import ua.softgroup.task.UserActivity;
import ua.softgroup.task.util.HashMd5;

/**
 * Created by Слава on 17.05.2017.
 */

public class SubmitOnClickListener extends AbstractOnClickListener {

    public SubmitOnClickListener(Context context, EditText email, EditText pass) {
        super(context, email, pass);
    }

    @Override
    public void onClick(View v) {
        String txtEmail = email.getText().toString();
        String txtPass = pass.getText().toString();
        String originPass = service.getPassByEmail(txtEmail);
        try {
            if (!HashMd5.makeHash(txtPass).equalsIgnoreCase(originPass)) {
                Toast.makeText(context, "Неверная почта или пароль", Toast.LENGTH_LONG).show();
                return;
            }
        } catch (NoSuchAlgorithmException e) {
            Toast.makeText(context, "Проблема с базой данных", Toast.LENGTH_LONG).show();
            return;
        }
        Intent intent = new Intent(context, UserActivity.class);
        intent.putExtra("email", txtEmail);
        context.startActivity(intent);
    }
}
