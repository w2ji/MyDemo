package com.demo.asana.asanaproject.contact_details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.demo.asana.asanaproject.domain.Contact;

public class ContactDetails extends AppCompatActivity implements ContactDetailsContract.View{

    ContactDetailsContract.Presenter presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ContactDetailsPresenter(this);
    }

    @Override
    public void onContactLoaded(Contact contact) {

    }
}
