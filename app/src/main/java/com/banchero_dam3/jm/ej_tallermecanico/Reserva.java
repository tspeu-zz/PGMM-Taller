package com.banchero_dam3.jm.ej_tallermecanico;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;

public class Reserva extends AppCompatActivity {
    private Spinner spEncargo, spAseguradoras;
    private EditText etOtros;
    private CheckBox chkAseguradora;
    private Button btnConfirmar;
    private String [] tipoEncargos ={"seleccionar" ,"cambio de aceite", "revisión general", "chapa y pintura", "reparación de siniestro", "otro"};
    private String [] listaAseguradoras ={"Aseguradora de coches","Axa","Catalana Occidente", "Regal", "Mafre", "Linea Directa","otra"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);

        etOtros = (EditText) findViewById(R.id.editTextOtroEncargo);
        //etOtros.setEnabled(false);

        spEncargo= (Spinner) findViewById(R.id.spinnerTipoEncargo);
ArrayAdapter<String> adapterEncargo =  new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tipoEncargos);
       spEncargo.setAdapter(adapterEncargo);

        spAseguradoras= (Spinner) findViewById(R.id.spinnerAseguradoras);
ArrayAdapter<String> adapterAseguradoras = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, listaAseguradoras);
       spAseguradoras.setAdapter(adapterAseguradoras);

        chkAseguradora = (CheckBox)findViewById(R.id.checkBoxPendiente);
        chkAseguradora.setEnabled(false);

        btnConfirmar = (Button) findViewById(R.id.buttonConfirmarReserva);
        btnConfirmar.setEnabled(false);

        spEncargo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                //  String place= parent.getItemAtPosition(pos).toString();
                String valor = parent.getSelectedItem().toString();
                int select = parent.getSelectedItemPosition();

                //Toast.makeText(MainActivity.this, "seleccionado " + valor, Toast.LENGTH_SHORT).show();

                if (valor.equals("otro")) {
                    etOtros.setEnabled(true);

                    //etOtros.setText("indicar por favor");
                    //etOtros.setText(getResources().getString(R.string.lblotroSlect));

                } else {
                    etOtros.setEnabled(false);
                }


                switch (select) {

                    case 0:
                        chkAseguradora.setEnabled(false);
                        btnConfirmar.setEnabled(false);
                        etOtros.setText("");
                        break;
                    case 1:
                    case 2:
                    case 5:
                        chkAseguradora.setEnabled(false);
                        btnConfirmar.setEnabled(true);
                        spAseguradoras.setEnabled(false);
                        break;

                    case 3:
                    case 4:
                        chkAseguradora.setEnabled(true);
                        btnConfirmar.setEnabled(true);

                        if (chkAseguradora.isChecked()){

                            spAseguradoras.setEnabled(true);
                        }else{
                            spAseguradoras.setEnabled(false);
                        }

                        break;
                    /*
                    case 5:
                        btnConfirmar.setEnabled(true);
                        break;
                    default:
                        chkAseguradora.setEnabled(false);
                        //btnConfirmar.setEnabled(true);
                        break;
                        */
                }

            }


            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing, just another required interface callback
            }

        });

        spAseguradoras.setEnabled(false);
        chkAseguradora.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    spAseguradoras.setEnabled(true);
                } else {
                    spAseguradoras.setEnabled(false);
                }
            }
        });





    }

    public void otros(){

        etOtros = (EditText) findViewById(R.id.editTextOtroEncargo);
        String selec = spEncargo.getSelectedItem().toString();

        if (selec.equals("otro") ){

            etOtros.setEnabled(true);
            etOtros.setText("indicar por favor");

        }else{
            etOtros.setEnabled(false);
        }


    }



    public void confirmarReserva(){




    }
}
