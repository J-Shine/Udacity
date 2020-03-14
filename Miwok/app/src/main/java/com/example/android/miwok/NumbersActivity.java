package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        //Create ArrayList of numbers by using Word object.
        ArrayList<Word> words = new ArrayList<Word>();

        // Add words by using 'add' function.
        words.add(new Word(R.drawable.number_one, "one", "lutti"));
        words.add(new Word(R.drawable.number_two, "two", "otiiko"));
        words.add(new Word(R.drawable.number_three, "three", "tolookosu"));
        words.add(new Word(R.drawable.number_four, "four", "oyyisa"));
        words.add(new Word(R.drawable.number_five, "five", "massokka"));
        words.add(new Word(R.drawable.number_six, "six", "temmokka"));
        words.add(new Word(R.drawable.number_seven, "seven", "kenekaku"));
        words.add(new Word(R.drawable.number_eight, "eight", "kawinta"));
        words.add(new Word(R.drawable.number_nine, "nine", "wo'e"));
        words.add(new Word(R.drawable.number_ten, "ten", "na'aacha"));

        // Create a Word Adapter (custom adapter), using constructor.
        WordAdapter itemsAdapter =
                new WordAdapter(this, words);

        // Find the ListView object in the view hierarchy of the Activity.
        // There should be a ListView with the view ID called list, which is declared in the
        // words_listayout file.
        ListView listView = findViewById(R.id.list);

        // Make the ListView use the ArrayAdapter we created above, so that the
        // ListView will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the ListView object and pass in
        // 1 argument, which is the ArrayAdapter with the variable name itemsAdapter.
        listView.setAdapter(itemsAdapter);
        // setAdapter needs ListAdapter as an input parameter.
        // ListAdapter is an Interface, BaseAdapter is an Abstract class and lastly ArrayAdapter is a Concrete class.
        // ListAdapter -> BaseAdapter -> ArrayAdapter.
        // ArrayAdapter is also used with GridList and Spinner
    }
}
