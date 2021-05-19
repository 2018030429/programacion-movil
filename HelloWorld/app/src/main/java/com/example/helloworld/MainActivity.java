package com.example.helloworld;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnGreeting;
    private EditText txtName;
    private TextView lblGreeting;
    private Button btnClean;
    private Button btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGreeting = (Button) findViewById(R.id.btnGreeting);
        txtName = (EditText) findViewById(R.id.txtGreeting);
        lblGreeting = (TextView) findViewById(R.id.lblGreeting);
        btnClean = (Button) findViewById(R.id.clean);
        btnClose = (Button) findViewById(R.id.close);
        
        btnGreeting.setOnClickListener(v -> {
            if (txtName.getText().toString().matches("")) {
                Toast.makeText(MainActivity.this, "Please, introduce a name",
                        Toast.LENGTH_SHORT).show();
            } else {
                String txtGreeting = txtName.getText().toString();
                lblGreeting.setText("Hello "+txtGreeting+", how are you?");
            }
        });

        btnClean.setOnClickListener(v -> {
            txtName.setText("");
            lblGreeting.setText("");
        });

        btnClose.setOnClickListener(v -> {
            AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
            dlg.setTitle(R.string.tittle);
            dlg.setMessage(R.string.message)
                .setCancelable(false)
                .setPositiveButton("OK", (dialog, which) -> finish())
                .setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());
            AlertDialog alertDialog = dlg.create();
            alertDialog.show();
        });
    }
}