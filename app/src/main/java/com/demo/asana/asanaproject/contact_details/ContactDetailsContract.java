package com.demo.asana.asanaproject.contact_details;

import com.demo.asana.asanaproject.domain.Contact;
import com.demo.asana.asanaproject.util.BasePresenter;

/**
 * Created by mastertao on 7/25/17.
 */

public class ContactDetailsContract {

    public interface View {
        void onContactLoaded(Contact contact);
    }

    public interface Presenter extends BasePresenter<ContactDetailsContract.View> {
        void loadContactDetails(String id);
    }
}
