package com.demo.asana.asanaproject;

import com.demo.asana.asanaproject.Repository.AsanaContactRepository;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ContactListPresenter implements ContactListContract.Presenter {

    CompositeDisposable compositeDisposable;
    ContactListContract.View view;
    AsanaContactRepository asanaContactRepository;

    public ContactListPresenter(ContactListContract.View view) {
        asanaContactRepository = AsanaContactRepository.getInstance();
        this.view = view;
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
    public void loadContactList() {
        compositeDisposable.add(asanaContactRepository.getContacts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(contacts -> {
                    view.onMoreContactsLoaded(contacts.values);
                }));
    }
}
