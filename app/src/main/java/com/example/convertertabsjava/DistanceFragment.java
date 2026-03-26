package com.example.convertertabsjava;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DistanceFragment extends Fragment {

    private RadioGroup rgDist;
    private EditText etDistInput;
    private Button btnConvertDist;
    private TextView tvDistResult;

    private static final double KM_TO_MILES = 0.621371;
    private static final double MILES_TO_KM = 1.609344;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_distance, container, false);

        // Initialisation des vues
        rgDist = view.findViewById(R.id.rgDist);
        etDistInput = view.findViewById(R.id.etDistInput);
        btnConvertDist = view.findViewById(R.id.btnConvertDist);
        tvDistResult = view.findViewById(R.id.tvDistResult);

        // Configuration du bouton de conversion
        btnConvertDist.setOnClickListener(v -> convertDistance());

        return view;
    }

    private void convertDistance() {
        String input = etDistInput.getText().toString().trim();

        // Vérification si le champ est vide
        if (TextUtils.isEmpty(input)) {
            Toast.makeText(getContext(), "Veuillez entrer une valeur", Toast.LENGTH_SHORT).show();
            return;
        }

        double val;
        try {
            val = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            Toast.makeText(getContext(), "Veuillez entrer un nombre valide", Toast.LENGTH_SHORT).show();
            return;
        }

        double result;
        String unit;
        int selectedId = rgDist.getCheckedRadioButtonId();

        // Conversion selon le choix de l'utilisateur
        if (selectedId == R.id.rbKmToMiles) {
            result = val * KM_TO_MILES;
            unit = " miles";
        } else {
            result = val * MILES_TO_KM;
            unit = " km";
        }

        // Affichage du résultat avec 2 décimales
        tvDistResult.setText(String.format("Résultat : %.2f%s", result, unit));
    }
}