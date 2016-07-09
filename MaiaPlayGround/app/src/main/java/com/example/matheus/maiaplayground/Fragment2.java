package com.example.matheus.maiaplayground;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Matheus on 16/06/2016.
 */
public class Fragment2 extends android.support.v4.app.Fragment {

    private int[] imagensLista = {R.drawable.planeta_01_mercurio, R.drawable.planeta_02_venus,
            R.drawable.planeta_03_terra, R.drawable.planeta_04_marte, R.drawable.planeta_05_jupiter,
            R.drawable.planeta_06_saturno, R.drawable.planeta_07_urano, R.drawable.planeta_08_neptuno,
            R.drawable.planeta_09_plutao};
    private String[] planetasLista = new String[]{"Mercúrio", "Vênus", "Terra", "Marte", "Júpiter",
            "Saturno", "Urano", "Netuno", "Plutão"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        //Button button = (Button) view.findViewById(R.id.button);
        Button buttonAlerta = (Button) view.findViewById(R.id.button2);
       /* button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                ImageView imagem = new ImageView(getActivity());
                imagem.setImageResource(R.drawable.biiir);
                Toast toast = new Toast(getActivity());
                toast.setView(imagem);
                toast.setDuration(Toast.LENGTH_SHORT);
                Toast.makeText(getActivity(), "BIIIIRL", Toast.LENGTH_SHORT).show();
                toast.show();

            }
        });*/

        buttonAlerta.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());
                builder.setIcon(R.drawable.smile2);
                builder.setTitle("ALERTA!!!");
                builder.setMessage("Teste");
                builder.setPositiveButton("Legal", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "OK", Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


        AutoCompleteTextView planetas = (AutoCompleteTextView) view.findViewById(R.id.planetas);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, planetasLista);
        planetas.setAdapter(adaptador);

        final Spinner combo = (Spinner) view.findViewById(R.id.spinner);
        ArrayAdapter<String> adaptadorSpinner = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, planetasLista);
        adaptadorSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        combo.setAdapter(adaptadorSpinner);
        final String[] posicaoPlaneta = new String[1];
        final int[] posicaoCombo = {0};

        planetas.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                posicaoPlaneta[0] = arg0.getItemAtPosition(arg2).toString();
            }
        });

        combo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                posicaoCombo[0] = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Button button3 = (Button) view.findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (planetasLista[posicaoCombo[0]] != null) {


                    if (posicaoPlaneta[0] == planetasLista[posicaoCombo[0]]) {
                        ImageView imagem = new ImageView(getActivity());
                        imagem.setImageResource(imagensLista[posicaoCombo[0]]);
                        Toast toast = new Toast(getActivity());
                        toast.setView(imagem);
                        toast.setDuration(Toast.LENGTH_SHORT);
                        Toast.makeText(getActivity(), "Planeta " + posicaoPlaneta[0] + ":", Toast.LENGTH_SHORT).show();
                        toast.show();
                    } else {
                        Toast.makeText(getActivity(), "Selecione o mesmo planeta nos dois campos", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        return view;
    }


}
