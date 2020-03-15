package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    /**
     * Create background color variable.
     */
    private int mBackgroundColor;
    // Create getter.
    public int getBackgroundColor(){
        return mBackgroundColor;
    }
    /**
     * Make constructor of 'WordAdapter' class.
     * @param context The context.(Where we are)
     */
    public WordAdapter(Activity context, ArrayList<Word> words, int backgroundColor){
        // Initialize WordAdapter using ArrayAdapter's constructor.
        // Because second parameter is used to populate single TextView, we don't use it here. We customize.
        // So, put the value 0.
        super(context, 0, words);
        mBackgroundColor = backgroundColor;
    }
    /*
     * @param convertView is an existing view we can reuse.(recycle)
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Use 'Ctrl+O' to generate override method.
        // Check if the existing view(convertivew) is being reused, otherwise inflate the view
        // Such as opening the screen first time.
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get 'Word' object located at this position in the list.
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the miwok word from the current Word object and
        // set this text on the miwok TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID default_text_view
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the default word from the current Word object and
        // set this text on the default TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // Find the ImageView in the list_item.xml layout with the ID image
        ImageView imageView = listItemView.findViewById(R.id.image);

        if(currentWord.hasImage()){
            // Get the image from the currentWord object and
            // set this on the ImageView.
            imageView.setImageResource(currentWord.getImageResourceId());
            // Make sure the ImageVIew is  set visible.
            // Because Views are recycled.
            imageView.setVisibility((View.VISIBLE));
        }
        else{
            // Otherwise hide an ImageView.
            imageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), getBackgroundColor());
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
