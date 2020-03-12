/**
 * IMPORTANT: Make sure you are using the correct package name. 
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;

import java.text.NumberFormat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String name = ((EditText) findViewById(R.id.name_field)).getText().toString();

        boolean hasWhippedCream = ((CheckBox) findViewById(R.id.whipped_cream_checkbox)).isChecked();
        boolean hasChocolate = ((CheckBox) findViewById(R.id.chocolate_checkbox)).isChecked();
        int price = calculatePrice(hasWhippedCream, hasChocolate);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.order_subject) + name);
        intent.putExtra(Intent.EXTRA_TEXT, createOrderSummary(price, hasWhippedCream, hasChocolate, name));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * Calculates the price of the order.
     * @return total price.
     */
    private int calculatePrice(boolean hasWhippedCream, boolean hasChocolate) {
        int basePrice = 5;

        if(hasWhippedCream) {
            basePrice += 1;
        }
        if(hasChocolate) {
            basePrice += 2;
        }
        return basePrice * quantity;
    }

    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view){
        if(quantity >= 100) {
            Toast.makeText(this, getString(R.string.toast_increment_prevent), Toast.LENGTH_SHORT).show();
        }
        else {
            quantity = quantity + 1;
            displayQuantity(quantity);
        }
    }

    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view){
        if(quantity < 2) {
            Toast.makeText(this, getString(R.string.toast_decrement_prevent), Toast.LENGTH_SHORT).show();
        }
        else {
            quantity = quantity - 1;
            displayQuantity(quantity);
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method returns summary of the order.
     *
     * @param hasWhippedCream is whether or not the user wants whipped cream topping.
     * @param hasChocolate is whether or not the user wants chocolate topping.
     * @param price of the order.
     * @param name of the customer.
     * @return text summary.
     */
    private  String createOrderSummary(int price, boolean hasWhippedCream, boolean hasChocolate, String name) {
        String summary = getString(R.string.order_summary_name, name)
                + "\n" + getString(R.string.hasWhippedCream) + hasWhippedCream
                + "\n" + getString(R.string.hasChocolate) + hasChocolate
                + "\n" + getString(R.string.quantity_summary) + quantity
                + "\n" + getString(R.string.total) + price
                + "\n" + getString(R.string.thank_you) ;
        return summary;
    }
}