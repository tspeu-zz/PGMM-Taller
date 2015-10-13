package com.banchero_dam3.jm.ej_tallermecanico;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Button btnReserva;
    private EditText etNombre,etTelf,etMatricula;
    private Spinner sMarcas,sModelos;
    //private String [] Marcas = {"Audi","Peugot","Renault"};
    //private String [] Modelos = {"A2","A3","A4"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnReserva = (Button)findViewById(R.id.buttonConfirmarReserva);

        etNombre = (EditText) findViewById(R.id.editTextNombre);
        etTelf =(EditText) findViewById(R.id.editTexttelefono);
        etMatricula =(EditText) findViewById(R.id.editTextMatricula);

        sMarcas = (Spinner) findViewById(R.id.spinnerMarca);
        //ArrayAdapter<CharSequence> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, R.array.marcas);
        //sMarcas.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.marcas, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        this.sMarcas.setAdapter(adapter);

        sModelos = (Spinner) findViewById(R.id.spinnerModelo);
        //ArrayAdapter<String> adapterModelos = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Modelos);
        //sModelos.setAdapter(adapterModelos);

        //ArrayAdapter<CharSequence> adapterAudi = ArrayAdapter.createFromResource(this, R.array.mAudi, android.R.layout.simple_spinner_item);


        sMarcas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                int select = parent.getSelectedItemPosition();
                switch (select) {
                    case 0:
                        modelosAudi();
    //ArrayAdapter<CharSequence> adapterAudi = ArrayAdapter.createFromResource( this.getBaseContext(),
    //        R.array.mAudi, android.R.layout.simple_spinner_item);
      //adapter = ArrayAdapter.createFromResource(this, R.array.Games,android.R.layout.simple_spinner_item);


                        // Retrieves an array
                        //TypedArray arrayAudi = getResources().obtainTypedArray(R.array.mAudi);
                        //CharSequence[] modelosAudi = arrayAudi.getTextArray(pos);
                        //arrayAudi.recycle();

                        // Create an ArrayAdapter using the string array and a default
                        // spinner layout
                        // ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, modelosAudi );
                        //ArrayAdapter<String> adapterAseguradoras = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, R.array.mAudi);
                        // Specify the layout to use when the list of choices appears
                        // adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                        // Apply the adapter to the spinner
                        //this.spLocalidades.setAdapter(adapter);

                        break;
                    case 1:
                        modelosCitroen();
                        break;
                    case 2:
                        modelosPeugot();
                        break;
                    case 3:
                        modelosRenault();
                        break;
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing, just another required interface callback
            }


        });





        }




    public void modelosAudi(){
        sModelos = (Spinner) findViewById(R.id.spinnerModelo);
        ArrayAdapter adapterA = ArrayAdapter.createFromResource(this, R.array.mAudi, android.R.layout.simple_spinner_item);
        adapterA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sModelos.setAdapter(adapterA);
    }
    public void modelosCitroen(){
        sModelos = (Spinner) findViewById(R.id.spinnerModelo);
        ArrayAdapter adapterA = ArrayAdapter.createFromResource(this, R.array.mCitroen, android.R.layout.simple_spinner_item);
        adapterA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sModelos.setAdapter(adapterA);
    }
    public void modelosPeugot(){
        sModelos = (Spinner) findViewById(R.id.spinnerModelo);
        ArrayAdapter adapterA = ArrayAdapter.createFromResource(this, R.array.mPeugot, android.R.layout.simple_spinner_item);
        adapterA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sModelos.setAdapter(adapterA);
    }
    public void modelosRenault(){
        sModelos = (Spinner) findViewById(R.id.spinnerModelo);
        ArrayAdapter adapterA = ArrayAdapter.createFromResource(this, R.array.mRenault, android.R.layout.simple_spinner_item);
        adapterA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sModelos.setAdapter(adapterA);
    }

    public void reservarOk (View v){

        Intent intent = new Intent(MainActivity.this, Reserva.class);



        Bundle bundle = new Bundle();
        //capturar datos
        bundle.putString("nombre", etNombre.getText().toString());
        bundle.putString("telefono", etTelf.getText().toString());
        bundle.putString("matricula",etMatricula.getText().toString());



        //enviar al intent
        intent.putExtras(bundle);
        startActivity(intent);

    }


}
