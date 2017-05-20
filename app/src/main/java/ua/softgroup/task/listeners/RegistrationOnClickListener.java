package ua.softgroup.task.listeners;

import android.content.Intent;
import android.view.View;

import ua.softgroup.task.RegistrationActivity;

/**
 * Created by Слава on 17.05.2017.
 */

public class RegistrationOnClickListener implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), RegistrationActivity.class);
        v.getContext().startActivity(intent);
    }
}
