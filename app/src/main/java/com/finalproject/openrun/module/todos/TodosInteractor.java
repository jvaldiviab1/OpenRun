package com.finalproject.openrun.module.todos;

import com.finalproject.openrun.module.login.LoginContract;
import com.finalproject.openrun.module.todos.presenter.TodosPresenter;

public class TodosInteractor implements TodosContract.Intractor {
    private String TAG = "LoginPresenter";
    private TodosContract.Presenter TodosPresenter;

    public TodosInteractor(TodosPresenter cTodosPresenter){
        this.TodosPresenter=cTodosPresenter;
    }
}
