package com.example.fragmentslab;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentOne extends Fragment {
    private TextView tv;
    private Button btnHello;

    // Link the layout to the Java class
    public FragmentOne() {
        super(R.layout.fragment_one);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Bind the text and button from the XML
        tv = view.findViewById(R.id.textOne);
        btnHello = view.findViewById(R.id.btnHello);

        // Change the text when the button inside this fragment is clicked
        btnHello.setOnClickListener(v -> tv.setText("Bonjour depuis Fragment 1 !"));
    }
}