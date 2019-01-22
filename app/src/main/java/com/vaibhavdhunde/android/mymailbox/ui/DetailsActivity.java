package com.vaibhavdhunde.android.mymailbox.ui;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.vaibhavdhunde.android.mymailbox.R;
import com.vaibhavdhunde.android.mymailbox.model.Email;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setTitle("");

        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();

            EmailDetailsFragment detailsFragment = new EmailDetailsFragment();

            Email currentEmail = getIntent().getParcelableExtra(MainActivity.EXTRA_EMAIL);
            detailsFragment.setEmail(currentEmail);

            fragmentManager.beginTransaction()
                    .add(R.id.email_details_container, detailsFragment)
                    .commit();
        }
    }
}
