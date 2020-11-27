package com.finalproject.openrun.module.todos.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.finalproject.openrun.R;
import com.finalproject.openrun.module.BottomActivityMain;
import com.finalproject.openrun.module.GeneralFragment;
import com.finalproject.openrun.module.todos.TodosContract;
import com.finalproject.openrun.module.todos.model.AdapterDatos;

import java.util.ArrayList;

public class TodosDetaFragment extends GeneralFragment implements TodosContract.View {
    ArrayList<String> listDatos;
    Button agregar;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_todos_deta, container, false);
        final RecyclerView ReVi = root.findViewById(R.id.recyclerViewDeta);
        agregar=root.findViewById(R.id.BuAddTask);
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),PopUpActivity.class));
            }
        });
        //ReVi.setLayoutManager(new LinearLayoutManager(this.getContext(),LinearLayoutManager.HORIZONTAL,false));
        ReVi.setLayoutManager(new GridLayoutManager(this.getContext(),2));
        listDatos= new ArrayList<String>();
        for(int i=0;i<=10;i++){
            listDatos.add("Dato #"+i+" ");
        }
        AdapterDatos adapterDatos= new AdapterDatos(listDatos);
        ReVi.setAdapter(adapterDatos);
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {

                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,TodosFragment.class, new Bundle()).commit();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback((LifecycleOwner) this.getContext(), callback);
        return root;

    }
}