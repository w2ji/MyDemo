package com.demo.asana.asanaproject;

import com.demo.asana.asanaproject.domain.Contact;

import java.util.List;

/**
 * Created by mastertao on 7/25/17.
 */

public class ContactListContract {

    public interface View {
        void onMoreContactsLoaded(List<Contact> urls);
    }

    public interface Presenter {
        void subscribe();

        void unsubscribe();

        void loadContactList();
    }
}