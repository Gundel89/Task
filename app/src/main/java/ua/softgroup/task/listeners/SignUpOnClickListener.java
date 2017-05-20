package ua.softgroup.task.listeners;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import java.security.NoSuchAlgorithmException;

import ua.softgroup.task.MainActivity;
import ua.softgroup.task.util.HashMd5;
import ua.softgroup.task.util.Validator;

/**
 * Created by Слава on 19.05.2017.
 */

public class SignUpOnClickListener extends AbstractOnClickListener {

    private EditText confirm;

    public SignUpOnClickListener(Context context, EditText email, EditText pass, EditText confirm) {
        super(context, email, pass);
        this.confirm = confirm;
    }

    @Override
    public void onClick(View v) {
        String txtEmail = email.getText().toString();
        String txtPass = pass.getText().toString();
        String txtConfirm = confirm.getText().toString();

        String errorMessage = getErrorMessage(txtEmail, txtPass, txtConfirm);

        if (!errorMessage.isEmpty()) {
            Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show();
            return;
        }
        try {
            String hashPass = HashMd5.makeHash(txtPass);
            if (!service.createUser(txtEmail, hashPass)) {
                throw new Exception("Такой имейл уже зарегистрирован");
            }
            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
        } catch (NoSuchAlgorithmException e) {
            Toast.makeText(context, "Проблема с шифрованием пароля", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private String getErrorMessage(String txtEmail, String txtPass, String txtConfirm) {
        String errorMessage = "";
        if (txtEmail.length() < 6 || !Validator.validateEmail(txtEmail)) {
            errorMessage += "Email должен быть не менее 6 символов и иметь формат name@mail.com";
        }
        if (txtPass.length() < 4) {
            errorMessage += "\nПароль должен быть не менее 4 символов";
        } else if (!txtPass.equals(txtConfirm)) {
            errorMessage += "\nПароль не совпадает с подтверждением";
        }
        return errorMessage;
    }
}
