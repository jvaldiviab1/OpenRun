package com.finalproject.openrun.module.todos.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.finalproject.openrun.R;
import com.finalproject.openrun.module.todos.TodosContract;
import com.finalproject.openrun.module.todos.model.AdapterDatos;

import java.util.ArrayList;

public class TodosFragment extends Fragment implements TodosContract.View {
    ArrayList<String> listDatos;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_todos, container, false);
        final RecyclerView ReVi = root.findViewById(R.id.recyclerView);
        ReVi.setLayoutManager(new LinearLayoutManager(this.getContext(),LinearLayoutManager.HORIZONTAL,false));
        listDatos= new ArrayList<String>();
        for(int i=0;i<=10;i++){
            listDatos.add("Dato #"+i+" ");
        }
        AdapterDatos adapterDatos= new AdapterDatos(listDatos);
        ReVi.setAdapter(adapterDatos);
        return root;
    }
}