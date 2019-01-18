package com.vaibhavdhunde.android.mymailbox.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Email implements Parcelable {
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

    protected Email(Parcel in) {
        mId = in.readInt();
        mImage = in.readInt();
        mName = in.readString();
        mEmail = in.readString();
        mDate = in.readString();
        mSubject = in.readString();
        mMatter = in.readString();
        mIsBookmarked = in.readByte() != 0;
    }

    public static final Creator<Email> CREATOR = new Creator<Email>() {
        @Override
        public Email createFromParcel(Parcel in) {
            return new Email(in);
        }

        @Override
        public Email[] newArray(int size) {
            return new Email[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mId);
        parcel.writeInt(mImage);
        parcel.writeString(mName);
        parcel.writeString(mEmail);
        parcel.writeString(mDate);
        parcel.writeString(mSubject);
        parcel.writeString(mMatter);
        parcel.writeByte((byte) (mIsBookmarked ? 1 : 0));
    }
}
