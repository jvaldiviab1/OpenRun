package com.finalproject.openrun.module.todos.presenter;

import android.app.Activity;

import com.finalproject.openrun.module.todos.TodosContract;
import com.finalproject.openrun.module.todos.TodosInteractor;

public class TodosPresenter implements TodosContract.Presenter {

    private String TAG = "TodosPresenter";

    private TodosContract.View mTodosView;
    private TodosInteractor mTodosInteractor;

    public TodosPresenter(TodosContract.View mTodosView){
        this.mTodosView = mTodosView;
        mTodosInteractor = new TodosInteractor(this);

    }
}
