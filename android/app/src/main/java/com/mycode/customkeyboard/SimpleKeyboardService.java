package com.mycode.customkeyboard;

import android.inputmethodservice.InputMethodService;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.LinearLayout;

public class SimpleKeyboardService extends InputMethodService {
    @Override
    public View onCreateInputView() {
        // Programmatic native layout creation (No XML UI inflation needed)
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setBackgroundColor(0xFF121212);

        // Define a simple key 'A'
        Button buttonA = new Button(this);
        buttonA.setText("A");
        buttonA.setOnClickListener(v -> {
            InputConnection ic = getCurrentInputConnection();
            if (ic != null) {
                ic.commitText("A", 1); // This sends 'A' directly into WhatsApp/System input
            }
        });

        layout.addView(buttonA);
        return layout;
    }
}
