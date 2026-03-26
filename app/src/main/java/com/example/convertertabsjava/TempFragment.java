package com.example.convertertabsjava;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TempFragment extends Fragment {

    private RadioGroup rgTemp;
    private EditText etTempInput;
    private Button btnConvertTemp;
    private TextView tvTempResult;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_temp, container, false);

        // Initialisation des vues
        rgTemp = view.findViewById(R.id.rgTemp);
        etTempInput = view.findViewById(R.id.etTempInput);
        btnConvertTemp = view.findViewById(R.id.btnConvertTemp);
        tvTempResult = view.findViewById(R.id.tvTempResult);

        // Configuration du bouton de conversion
        btnConvertTemp.setOnClickListener(v -> convertTemperature());

        return view;
    }

    private void convertTemperature() {
        String input = etTempInput.getText().toString().trim();

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
        int selectedId = rgTemp.getCheckedRadioButtonId();

        // Conversion selon le choix de l'utilisateur
        if (selectedId == R.id.rbCtoF) {
            result = (val * 9 / 5) + 32;
            unit = "°F";
        } else {
            result = (val - 32) * 5 / 9;
            unit = "°C";
        }

        // Affichage du résultat avec 2 décimales
        tvTempResult.setText(String.format("Résultat : %.2f%s", result, unit));
    }
}