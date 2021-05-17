package com.upsin.holamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnSaludar;
    private EditText txtNombre;
    private TextView lblSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSaludar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtNombre.getText().toString().matches("")) {
                    Toast.makeText(MainActivity.this, "Favor de ingresar un nombre",
                            Toast.LENGTH_SHORT).show();
                } else {
                    String txtSaludar = txtNombre.getText().toString();
                    lblSaludo.setText("Hola "+txtSaludar+", ¿cómo estás?");
                }
            }
        });
    }
}
