// Define the package for your project
package com.example.fragmentslab;

// Import necessary Android and Fragment libraries
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    // Declare the button variables for the top navigation bar
    private Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Link this Java file to the activity_main.xml layout
        setContentView(R.layout.activity_main);

        // Find the buttons in the XML layout using their IDs
        btn1 = findViewById(R.id.btnFragment1);
        btn2 = findViewById(R.id.btnFragment2);

        // check if savedInstanceState is null to avoid overlapping fragments on screen rotation
        if (savedInstanceState == null) {
            // Load FragmentOne by default when the app first starts
            // 'false' means we don't add this initial view to the BackStack
            replaceFragment(new FragmentOne(), false);
        }

        // Set a click listener for the first button using a Lambda expression
        btn1.setOnClickListener(v -> replaceFragment(new FragmentOne(), true));

        // Set a click listener for the second button
        btn2.setOnClickListener(v -> replaceFragment(new FragmentTwo(), true));
    }

    // A helper method to handle the logic of swapping fragments
    private void replaceFragment(Fragment fragment, boolean addToBackStack) {
        // Get the FragmentManager which handles fragment transactions
        FragmentManager fm = getSupportFragmentManager();
        // Start a new series of edit operations (a transaction)
        FragmentTransaction ft = fm.beginTransaction();

        // Improve performance by allowing the system to optimize state changes
        ft.setReorderingAllowed(true);

        // Replace whatever is in the 'fragment_container' layout with the new fragment
        ft.replace(R.id.fragment_container, fragment);

        // If true, allow the user to use the 'Back' button to return to the previous fragment
        if (addToBackStack) {
            ft.addToBackStack(null);
        }

        // Finalize and apply the changes to the UI
        ft.commit();
    }
}