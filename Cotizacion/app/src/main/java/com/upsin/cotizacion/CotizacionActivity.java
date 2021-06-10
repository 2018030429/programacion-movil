package com.upsin.cotizacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class CotizacionActivity extends AppCompatActivity {

  private TextView lblNombre;
  private TextView lblFolio;
  private EditText txtDescripcion;
  private EditText txtValorAuto;
  private EditText txtPorEng;
  private RadioButton rdb12;
  private RadioButton rdb18;
  private RadioButton rdb24;
  private RadioButton rdb36;
  private EditText txtMensual;
  private Button btnCalcular;
  private Button btnLimpiar;
  private Button btnRegresar;
  private TextView lblEnganche;
  private TextView lblPagoMensual;
  private Cotizacion cot;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cotizacion);

    lblNombre = (TextView) findViewById(R.id.lblCliente);
    lblFolio = (TextView) findViewById(R.id.lblFolio);
    txtDescripcion = (EditText) findViewById(R.id.txtDescripcion);
    txtValorAuto = (EditText) findViewById(R.id.txtValorAuto);
    txtPorEng = (EditText) findViewById(R.id.txtPorEng);
    rdb12 = (RadioButton) findViewById(R.id.rdb12);
    rdb18 = (RadioButton) findViewById(R.id.rdb18);
    rdb24 = (RadioButton) findViewById(R.id.rdb24);
    rdb36 = (RadioButton) findViewById(R.id.rdb36);
    lblPagoMensual = (TextView) findViewById(R.id.lblPagoMensual);
    lblEnganche = (TextView) findViewById(R.id.lblEnganche);
    btnCalcular = (Button) findViewById(R.id.btnCalcular);
    btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
    btnRegresar = (Button) findViewById(R.id.btnRegresar);
    cot = new Cotizacion();
    lblFolio.setText("Folio : " + String.valueOf((cot.generarFolio())));
    Bundle datos = getIntent().getExtras();
    String nombre = datos.getString("cliente");
    lblNombre.setText("Cliente: " + nombre);
    rdb12.setSelected(true);

    btnRegresar.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        finish();
      }
    });

    btnCalcular.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (txtDescripcion.getText().toString().matches("") ||
          txtValorAuto.getText().toString().matches("")
          || txtPorEng.getText().toString().matches("")) {
          Toast.makeText(
            CotizacionActivity.this,
            "Falto capturar informacion",
            Toast.LENGTH_SHORT
          ).show();
          txtDescripcion.requestFocus();
        } else {
          int plazos = 0;
          float enganche = 0;
          float pagomensual = 0.0f;
          if (rdb12.isChecked()) {
            plazos = 12;
          }
          if (rdb18.isChecked()) {
            plazos = 18;
          }
          if (rdb24.isChecked()) {
            plazos = 24;
          }
          if (rdb36.isChecked()) {
            plazos = 36;
          }

          cot.setDescripcion(txtDescripcion.getText().toString());

          cot.setValorAuto(Float.parseFloat(txtValorAuto.getText().toString()));

          cot.setPorEnganche(Float.parseFloat(txtPorEng.getText().toString()));
          cot.setPlazos(plazos);
          enganche = cot.calcularEnganche();
          pagomensual = cot.calcularPagoMensual();
          lblEnganche.setText("Pago Inicial $" + String.format("%.2f",enganche));
          lblPagoMensual.setText("Pago Mensual $" + String.format("%.2f",pagomensual));
        }
      }
    });

    btnLimpiar.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        lblFolio.setText(String.valueOf("Folio : " + cot.generarFolio()));
        txtDescripcion.setText("");
        txtValorAuto.setText("");
        txtPorEng.setText("");
        lblPagoMensual.setText("Pago Mensual :");
        rdb12.setChecked(true);
        lblEnganche.setText("Enganche :");
      }
    });
  }
}