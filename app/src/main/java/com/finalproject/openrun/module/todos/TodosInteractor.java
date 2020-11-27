package com.finalproject.openrun.module.todos;

import com.finalproject.openrun.module.login.LoginContract;
import com.finalproject.openrun.module.todos.presenter.TodosPresenter;

public class TodosInteractor implements TodosContract.Intractor {
    private final String TAG = "LoginPresenter";
    private final TodosContract.Presenter TodosPresenter;

    public TodosInteractor(TodosPresenter cTodosPresenter){
        this.TodosPresenter=cTodosPresenter;
    }
}
