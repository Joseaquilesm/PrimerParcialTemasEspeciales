package com.pucmm.examenparcial;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Texto extends Fragment {

        TextView text, info;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.texto_fragment, container, false);
        TextView conceptos = (TextView)view.findViewById(R.id.textViewConceptos);
        TextView informacion = (TextView)view.findViewById(R.id.textViewDefinicion);

        Bundle bundle = getArguments();
        if(bundle != null){
            if(bundle.getString("informacion") != null){
                conceptos.setText(bundle.getString("conceptos"));
                informacion.setText(bundle.getString("informacion"));
            }
        }
        return view;
    }


    public void change(String txt, String txt1){

           // text.setText(txt);
        //    info.setText(txt1);

    }

}
