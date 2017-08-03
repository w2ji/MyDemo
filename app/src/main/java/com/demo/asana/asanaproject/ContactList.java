package com.demo.asana.asanaproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.demo.asana.asanaproject.domain.Contact;
import com.demo.asana.asanaproject.domain.Contacts;
import com.demo.asana.asanaproject.network.AsanaContactService;
import com.paginate.Paginate;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactList extends AppCompatActivity implements ContactListContract.View{

    ContactListContract.Presenter presenter;

    @BindView(R.id.image_list)
    RecyclerView recyclerView;

    ContactListAdapter contactListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        presenter = new ContactListPresenter(this);
        ButterKnife.bind(this);
        setupRecyclerView();
    }

    @Override
    public void onStart(){
        super.onStart();
        presenter.subscribe();
        presenter.loadContactList();
    }


    @Override
    public void onStop(){
        super.onStop();
        presenter.unsubscribe();
    }

    private void setupRecyclerView(){
        contactListAdapter = new ContactListAdapter();
        recyclerView.setAdapter(contactListAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onMoreContactsLoaded(List<Contact> urls) {
        contactListAdapter.addNewContacts(urls);
    }
}
