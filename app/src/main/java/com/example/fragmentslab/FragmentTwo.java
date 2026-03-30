package com.example.fragmentslab;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentTwo extends Fragment {
    // UI components
    private TextView tvValue;
    private SeekBar seek;
    // Variable to store the current progress of the SeekBar
    private int progress = 0;
    // Constant key for saving/restoring state in the Bundle
    private static final String KEY_PROGRESS = "progress";

    // Constructor linking the Fragment class directly to its XML layout
    public FragmentTwo() {
        super(R.layout.fragment_two);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        // This method runs after the layout is "inflated" (created)
        super.onViewCreated(view, savedInstanceState);

        // Initialize UI components from the inflated view
        tvValue = view.findViewById(R.id.tvValue);
        seek = view.findViewById(R.id.seekBar);

        // Check if there is a saved state (e.g., after a screen rotation)
        if (savedInstanceState != null) {
            // Retrieve the saved progress value, defaulting to 0 if not found
            progress = savedInstanceState.getInt(KEY_PROGRESS, 0);
            // Update the SeekBar position to the saved value
            seek.setProgress(progress);
            // Update the text display to match the saved value
            tvValue.setText("Valeur : " + progress);
        }

        // Add a listener to detect when the user slides the SeekBar
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int p, boolean fromUser) {
                // 'p' is the new progress value (0-100)
                progress = p;
                // Display the current value in the TextView
                tvValue.setText("Valeur : " + p);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {} // Required but unused here

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {} // Required but unused here
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        // This runs before the fragment is destroyed (e.g., during rotation)
        super.onSaveInstanceState(outState);
        // Save our current progress integer into the "outState" bundle
        outState.putInt(KEY_PROGRESS, progress);
    }
}