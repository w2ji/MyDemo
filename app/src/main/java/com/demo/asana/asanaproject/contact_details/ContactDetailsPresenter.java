package com.demo.asana.asanaproject.contact_details;

import android.view.View;

import com.demo.asana.asanaproject.Repository.AsanaContactRepository;

import io.reactivex.disposables.CompositeDisposable;

public class ContactDetailsPresenter implements ContactDetailsContract.Presenter {

    ContactDetailsContract.View view;
    AsanaContactRepository asanaContactRepository;
    CompositeDisposable compositeDisposable;

    public ContactDetailsPresenter(ContactDetailsContract.View view) {
        this.view = view;
        asanaContactRepository = AsanaContactRepository.getInstance();
    }

    @Override
    public void subscribe() {
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void unsubscribe() {
        compositeDisposable.dispose();
    }

    @Override
    public void loadContactDetails(String id) {

    }
}
