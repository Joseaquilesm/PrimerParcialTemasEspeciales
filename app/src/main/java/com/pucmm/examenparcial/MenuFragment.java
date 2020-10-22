package com.pucmm.examenparcial;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ListFragment;

import com.google.android.material.snackbar.Snackbar;


public class MenuFragment extends ListFragment {
    String[] listaConceptos = new String[]{"Apps","Fragments","Activities","Intents","Widgets","Services","Sensors"};
    String[] info = new String[]{"An Android app is an Android application. An app is packaged in an APK file (Android application package). The APK file contains the compiled Java code and other resources like texts and images for the Android application.",
    "In Android a fragment is a fragment of a total user interface. A fragment typically only takes up part of the screen. Fragments are used inside activities. Fragments can be reused within different activities.",
    "An Android activity is a GUI component. It corresponds roughly to a window in a desktop application. Since mobile phone screens are small, an activity typically takes up the whole screen. If you open multiple activities they are stacked on top of each other. You cannot arrange activities side by side, like you can do with desktop windows.",
    "Android intents are small objects that an activity can pass to the Android operating system, to tell the operating system that some other action or actvity is required. For instance, a photo app may send an intent to the operating system when the user has chosen to share a photo. The intent describes the \"sharing action\". Other applications that knows how to perform the \"sharing action\" can then be opened, and the sharing can be performed via another application.",
    "Android widgets are GUI components which can be displayed outside of an activity. For instance, a weather widget showing todays weather is shown on many Android home screens. Widgets are implemented and packaged as part of an Android application.",
    "Android services are background processes that can be executed on an Android device, even if no application is visible. Services do not need a user interface. A service could for instance check a remote server for updates, or backup data every hour etc.",
    "Android devices typically have a set of sensors built in which you can access from your Android applications. For instance, the built-in GPS in many smart phones is a sensor. Thus, you can get access to the GPS from inside your Android applications."};

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.menu_fragment, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, listaConceptos);
        setListAdapter(adapter);
        return view;
    }

    @Override
    public void onListItemClick( ListView l,  View v, int position, long id) {
        // super.onListItemClick(l, v, position, id);
        //para crear un mensaje al clickear
        // Snackbar.make(v, "HOLA", Snackbar.LENGTH_SHORT).show();

        FragmentManager fragmentManager = getFragmentManager();

    //creando bundle para pasar informacion
    Bundle bundle = new Bundle();
    String textoInfo = info[position];
    String textoConcepto = listaConceptos[position];
    bundle.putString("informacion",textoInfo);
    bundle.putString("conceptos",textoConcepto);
    Texto textoFragment = new Texto();
    textoFragment.setArguments(bundle);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            fragmentManager.beginTransaction().replace(R.id.definicionLayout, textoFragment).commit();
        }else{
            fragmentManager.beginTransaction().replace(R.id.conceptoLayout,textoFragment).addToBackStack(null).commit();
            //fragmentManager.beginTransaction().attach(textoFragment).addToBackStack(null).commit();
           // textoFragment.change(listaConceptos[position], info[position],MainActivity.orientacion);
        }
    }
}
