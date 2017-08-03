package com.demo.asana.asanaproject.Repository;

import com.demo.asana.asanaproject.InMemoryHashMap;
import com.demo.asana.asanaproject.domain.Contact;
import com.demo.asana.asanaproject.domain.Contacts;
import com.demo.asana.asanaproject.network.AsanaContactService;
import com.demo.asana.asanaproject.network.AsanaContactServiceProvider;

import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class AsanaContactRepository {

    private static AsanaContactRepository asanaContactRepository;

    AsanaContactService asanaContactService;

    private AsanaContactRepository() {
        asanaContactService = AsanaContactServiceProvider.getAsanaContactService();
    }

    public Single<Contacts> getContacts(){
        return asanaContactService.getContactList().observeOn(Schedulers.io()).doOnSuccess(contacts -> {
            for (Contact c : contacts.values) {
                InMemoryHashMap.memoryMap.put(c.id, c);
            }
        });
    }

    public Maybe<Contact> getContactDetail(String id){
        return Single.merge(Single.just(InMemoryHashMap.memoryMap.get(id)),
                asanaContactService.getContact(id)).firstElement();
    }

    public static synchronized AsanaContactRepository getInstance(){
        if (asanaContactRepository == null){
            synchronized(AsanaContactRepository.class){
                if (asanaContactRepository == null) {
                    asanaContactRepository = new AsanaContactRepository();
                }
            }
        }

        return asanaContactRepository;
    }

}
