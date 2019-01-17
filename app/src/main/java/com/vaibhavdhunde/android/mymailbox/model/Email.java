package com.vaibhavdhunde.android.mymailbox.model;

public class Email {
    private int mId;
    private int mImage;
    private String mName;
    private String mEmail;
    private String mDate;
    private String mSubject;
    private String mMatter;
    private boolean mIsBookmarked;

    public Email(int id, int image, String name, String email, String date, String subject,
                 String matter, boolean isBookmarked) {
        mId = id;
        mImage = image;
        mName = name;
        mEmail = email;
        mDate = date;
        mSubject = subject;
        mMatter = matter;
        mIsBookmarked = isBookmarked;
    }

    public int getId() {
        return mId;
    }

    public int getImage() {
        return mImage;
    }

    public String getName() {
        return mName;
    }

    public String getEmail() {
        return mEmail;
    }

    public String getDate() {
        return mDate;
    }

    public String getSubject() {
        return mSubject;
    }

    public String getMatter() {
        return mMatter;
    }

    public boolean isBookmarked() {
        return mIsBookmarked;
    }
}
