package ua.softgroup.task.listeners;

import android.content.Context;
import android.view.View;
import android.widget.EditText;

import ua.softgroup.task.service.UserService;

/**
 * Created by Слава on 17.05.2017.
 */

public abstract class AbstractOnClickListener implements View.OnClickListener {

    protected UserService service;
    protected Context context;

    protected EditText email;
    protected EditText pass;

    protected AbstractOnClickListener(Context context, EditText email, EditText pass) {
        service = new UserService(context);
        this.context = context;
        this.email = email;
        this.pass = pass;
    }

    public EditText getEmail() {
        return email;
    }

    public void setEmail(EditText email) {
        this.email = email;
    }

    public EditText getPass() {
        return pass;
    }

    public void setPass(EditText pass) {
        this.pass = pass;
    }
}
