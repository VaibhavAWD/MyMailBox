package com.vaibhavdhunde.android.mymailbox.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.Group;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vaibhavdhunde.android.mymailbox.R;
import com.vaibhavdhunde.android.mymailbox.model.Email;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EmailDetailsFragment extends Fragment {

    private static final String CURRENT_EMAIL = "currentEmail";
    private static final String DETAILS_VISIBILITY = "detailsVisibility";

    @BindView(R.id.text_subject)
    TextView mTextSubject;

    @BindView(R.id.image_bookmark)
    ImageView mImageBookmark;

    @BindView(R.id.image_profile)
    ImageView mImageProfile;

    @BindView(R.id.text_name)
    TextView mTextName;

    @BindView(R.id.text_date)
    TextView mTextDate;

    @BindView(R.id.text_from_name)
    TextView mTextFromName;

    @BindView(R.id.text_email)
    TextView mTextEmail;

    @BindView(R.id.text_details_date)
    TextView mTextDetailsDate;

    @BindView(R.id.text_matter)
    TextView mTextMatter;

    @BindView(R.id.view_details_group)
    Group mViewDetailsGroup;

    @BindView(R.id.details_group)
    Group mDetailsGroup;

    private Email mCurrentEmail;

    public EmailDetailsFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_email_details, container, false);
        ButterKnife.bind(this, rootView);

        if (savedInstanceState != null) {
            mCurrentEmail = savedInstanceState.getParcelable(CURRENT_EMAIL);

            boolean isVisible = savedInstanceState.getBoolean(DETAILS_VISIBILITY);

            if (isVisible) {
                showEmailDetails();
            } else {
                hideEmailDetails();
            }
        }

        fillDetails();

        return rootView;
    }

    private void fillDetails() {
        mTextSubject.setText(mCurrentEmail.getSubject());

        if (mCurrentEmail.isBookmarked()) {
            mImageBookmark.setVisibility(View.VISIBLE);
        } else {
            mImageBookmark.setVisibility(View.GONE);
        }

        mImageProfile.setImageResource(mCurrentEmail.getImage());

        mTextName.setText(mCurrentEmail.getName());

        mTextDate.setText(mCurrentEmail.getDate());

        mTextFromName.setText(mCurrentEmail.getName());

        mTextEmail.setText(mCurrentEmail.getEmail());

        mTextDetailsDate.setText(mCurrentEmail.getDate());

        mTextMatter.setText(mCurrentEmail.getMatter()
                .replace("Hi, ", "Hi,\n\n")
                .replace("Regards,", "\n\nRegards,\n")
                .replace(getString(R.string.name_placeholder), mCurrentEmail.getName()));
    }

    public void setEmail(Email email) {
        mCurrentEmail = email;
    }

    @OnClick(R.id.text_view_details)
    protected void viewDetails() {
        showEmailDetails();
    }

    private void showEmailDetails() {
        mDetailsGroup.setVisibility(View.VISIBLE);
        mViewDetailsGroup.setVisibility(View.GONE);
    }

    @OnClick(R.id.text_hide_details)
    protected void hideDetails() {
        hideEmailDetails();
    }

    private void hideEmailDetails() {
        mViewDetailsGroup.setVisibility(View.VISIBLE);
        mDetailsGroup.setVisibility(View.GONE);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle currentState) {
        currentState.putParcelable(CURRENT_EMAIL, mCurrentEmail);

        if (mDetailsGroup.getVisibility() == View.VISIBLE) {
            currentState.putBoolean(DETAILS_VISIBILITY, true);
        } else {
            currentState.putBoolean(DETAILS_VISIBILITY, false);
        }
    }
}
