package com.vaibhavdhunde.android.mymailbox.ui;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ScrollView;

import com.vaibhavdhunde.android.mymailbox.R;
import com.vaibhavdhunde.android.mymailbox.data.EmailData;
import com.vaibhavdhunde.android.mymailbox.model.Email;

public class MainActivity extends AppCompatActivity implements EmailListFragment.OnEmailClickListener {

    private static final String IS_ADDED = "isAdded";

    public static final String EXTRA_EMAIL = "extra_email";

    private boolean mIsTwoPane;

    private boolean mIsAdded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null && savedInstanceState.containsKey(IS_ADDED)) {
            mIsAdded = savedInstanceState.getBoolean(IS_ADDED);
        }

        if (findViewById(R.id.email_details_container) != null) {
            mIsTwoPane = true;

            if (!mIsAdded) {
                showInitialEmail();
                mIsAdded = true;
            }
        } else {
            mIsTwoPane = false;
        }
    }

    private void showInitialEmail() {
        FragmentManager fragmentManager = getSupportFragmentManager();

        EmailDetailsFragment detailsFragment = new EmailDetailsFragment();

        Email email = new Email(
                1,
                EmailData.images.get(0),
                EmailData.names.get(0),
                EmailData.emails.get(0),
                EmailData.dates.get(0),
                EmailData.subjects.get(0),
                getString(R.string.email_matter),
                EmailData.isBookmarked.get(0)
        );
        detailsFragment.setEmail(email);

        fragmentManager.beginTransaction()
                .add(R.id.email_details_container, detailsFragment)
                .commit();
    }

    @Override
    public void OnEmailSelected(Email email) {
        if (mIsTwoPane) {
            FragmentManager fragmentManager = getSupportFragmentManager();

            EmailDetailsFragment detailsFragment = new EmailDetailsFragment();
            detailsFragment.setEmail(email);
            fragmentManager.beginTransaction()
                    .replace(R.id.email_details_container, detailsFragment)
                    .commit();

            ScrollView scrollView = findViewById(R.id.details_scroll_view);
            // scroll to top
            scrollView.smoothScrollTo(0, 0);
        } else {
            Intent detailsIntent = new Intent(MainActivity.this, DetailsActivity.class);
            detailsIntent.putExtra(EXTRA_EMAIL, email);
            startActivity(detailsIntent);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle currentState) {
        currentState.putBoolean(IS_ADDED, mIsAdded);
        super.onSaveInstanceState(currentState);
    }
}
