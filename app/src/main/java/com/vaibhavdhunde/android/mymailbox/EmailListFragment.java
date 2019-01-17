package com.vaibhavdhunde.android.mymailbox;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.vaibhavdhunde.android.mymailbox.data.EmailData;
import com.vaibhavdhunde.android.mymailbox.model.Email;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EmailListFragment extends Fragment {

    @BindView(R.id.list_emails)
    RecyclerView mListEmails;

    public EmailListFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_emails_list, container, false);
        ButterKnife.bind(this, rootView);

        setupListEmails();

        EmailAdapter emailAdapter = new EmailAdapter(getEmails());
        mListEmails.setAdapter(emailAdapter);

        return rootView;
    }

    private List<Email> getEmails() {
        List<Email> emails = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            emails.add(new Email(
                    i + 1,
                    EmailData.images.get(i),
                    EmailData.names.get(i),
                    EmailData.emails.get(i),
                    EmailData.dates.get(i),
                    EmailData.subjects.get(i),
                    getString(R.string.email_matter),
                    EmailData.isBookmarked.get(i)
            ));
        }

        return emails;
    }

    private void setupListEmails() {
        mListEmails.setHasFixedSize(true);
        LayoutManager layoutManager = new LinearLayoutManager(getContext());
        mListEmails.setLayoutManager(layoutManager);
        mListEmails.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
    }
}
