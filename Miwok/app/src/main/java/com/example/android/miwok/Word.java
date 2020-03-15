package com.example.android.miwok;

// It contains a Miwok translation and a default translation for that word.
public class Word {

    /**
     * Create a variable for an image resource id
     * And set default value for no image state.
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /**
     * Define a constant that indicates no image.
     * Static is a keyword used to define the class member that can be used independently of any object of that class.
     * Final keyword is used to declare, a constant variable, a method which can not be overridden and a class that can not be inherited.
     */
    private static final int NO_IMAGE_PROVIDED = -1;

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

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
        // If there is an image provided, it would return true.
        // And it there is no image provided, it would return false.
    }

}
