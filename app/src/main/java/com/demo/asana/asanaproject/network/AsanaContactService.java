package com.demo.asana.asanaproject.network;

import com.demo.asana.asanaproject.domain.Contact;
import com.demo.asana.asanaproject.domain.Contacts;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AsanaContactService {
    @GET("/connectionsjson")
    Single<Contacts> getContactList();

    @GET("/contact/:id")
    Single<Contact> getContact(@Path("id") String id);
}
