package com.example.android.miwok;

// It contains a Miwok translation and a default translation for that word.
public class Word {

    // Image resouce id for the word.
    private int mImageResourceId;

    // Default translation for the word.
    private String mDefaultTranslation;
    // 'm' is short for 'private member of class'

    // Miwok translation for the word.
    private String mMiwokTranslation;

    // 2-input Word class constructor.
    public Word(String defaultTranslation, String miwokTranslation) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    // 3-input Word class constructor.
    public Word(int imageResourceId, String defaultTranslation, String miwokTranslation) {
        mImageResourceId = imageResourceId;
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    // A method that gets resource image id of the word
    public int getImageResourceId() {
        return mImageResourceId;
    }

    // A method that gets default translation of the word
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    // A method that gets miwok translation of the word
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }
}
