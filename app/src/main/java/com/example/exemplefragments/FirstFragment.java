package com.example.exemplefragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.exemplefragments.databinding.FragmentFirstBinding;


public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private Spinner spinner;
    private TextView res;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        View view = inflater.inflate(R.layout.fragment_first, container, false); //Inflem l'XML del primer fragment per poder capturar les referencies dels recursos
        spinner = view.findViewById(R.id.dia_set_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(view.getContext(), R.array.dies_setmana,
                android.R.layout.simple_spinner_item);


        //res = view.findViewById(R.id.textview_first);

        spinner.setAdapter(adapter);

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.diaSetSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Decidir que fer amb l'opcio seleccionada

                String selected = parent.getItemAtPosition(position).toString();

                Toast.makeText(getActivity(),"Dia de la setmana que més t'agrada: "+selected.toString(),Toast.LENGTH_LONG).show();
                //En qualsevol cas imprimim l'opcio escollida

            }

            @Override
            public void onNothingSelected(AdapterView position) {   //No fer res si no s'ha seleccionat cap opco de l'spinner

            }
        });

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}