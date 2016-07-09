package com.example.matheus.maiaplayground;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

/**
 * Created by Matheus on 16/06/2016.
 */
public class Fragment3 extends android.support.v4.app.Fragment {
    SeekBar seekBar;
    int progresso;
    Button button;
    ImageView androidBoneco;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_3, container, false);

        seekBar = (SeekBar) view.findViewById(R.id.seekBar);
        androidBoneco = (ImageView) view.findViewById(R.id.bonecoAndroid);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progresso = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        button = (Button) view.findViewById(R.id.buttonAnimar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("Livro", ""+Integer.toString(progresso) + "   andas   " + Float.toString(androidBoneco.getRotation()));
                ObjectAnimator a = ObjectAnimator.ofFloat(androidBoneco, "rotation", androidBoneco.getRotation(), progresso );
                a.start();
            }
        });



        return view;
    }

    public void onClickAnimacao(View view){
        int i = 0;
        Log.v("Livro", "oaea");

    }
}
