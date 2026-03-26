package com.example.convertertabsjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import androidx.activity.OnBackPressedCallback;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        // Liaison ViewPager avec l'adaptateur
        adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);

        // Liaison des onglets avec le ViewPager
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    if (position == 0) {
                        tab.setText("Température");
                    } else {
                        tab.setText("Distance");
                    }
                }
        ).attach();

        // Configuration du gestionnaire de retour (back button)
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                showExitConfirmationDialog();
            }
        };
        getOnBackPressedDispatcher().addCallback(this, callback);
    }

    private void showExitConfirmationDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Quitter")
                .setMessage("Voulez-vous vraiment quitter l'application ?")
                .setPositiveButton("Oui", (dialog, which) -> {
                    // Quitter l'application
                    finish();
                })
                .setNegativeButton("Non", (dialog, which) -> {
                    // Ne rien faire, rester dans l'application
                    dialog.dismiss();
                })
                .show();
    }
}