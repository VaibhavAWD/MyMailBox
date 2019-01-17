package com.vaibhavdhunde.android.mymailbox;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vaibhavdhunde.android.mymailbox.model.Email;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EmailAdapter extends RecyclerView.Adapter<EmailAdapter.EmailViewHolder> {

    private List<Email> mEmails;

    public EmailAdapter(List<Email> emails) {
        mEmails = emails;
    }

    public class EmailViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_profile)
        ImageView mImageProfile;

        @BindView(R.id.image_bookmark)
        ImageView mImageBookmark;

        @BindView(R.id.text_name)
        TextView mTextName;

        @BindView(R.id.text_date)
        TextView mTextDate;

        @BindView(R.id.text_subject)
        TextView mTextSubject;

        @BindView(R.id.text_matter)
        TextView mTextMatter;

        public EmailViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @NonNull
    @Override
    public EmailViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View emailView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_email, viewGroup, false);
        return new EmailViewHolder(emailView);
    }

    @Override
    public void onBindViewHolder(@NonNull EmailViewHolder emailViewHolder, int position) {
        Email currentEmail = mEmails.get(position);

        emailViewHolder.mImageProfile.setImageResource(currentEmail.getImage());

        if (currentEmail.isBookmarked()) {
            emailViewHolder.mImageBookmark.setVisibility(View.VISIBLE);
        } else {
            emailViewHolder.mImageBookmark.setVisibility(View.GONE);
        }

        emailViewHolder.mTextName.setText(currentEmail.getName());

        emailViewHolder.mTextDate.setText(currentEmail.getDate());

        emailViewHolder.mTextSubject.setText(currentEmail.getSubject());

        emailViewHolder.mTextMatter.setText(currentEmail.getMatter());
    }

    @Override
    public int getItemCount() {
        return mEmails.size();
    }
}
