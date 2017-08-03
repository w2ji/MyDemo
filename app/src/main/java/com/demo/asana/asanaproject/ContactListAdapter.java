package com.demo.asana.asanaproject;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.demo.asana.asanaproject.domain.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ContactListViewHolder> {

    private final List<Contact> contactList = new ArrayList<>();

    @Override
    public ContactListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ContactListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ContactListViewHolder holder, int position) {
        Contact contact = contactList.get(position);
        Glide.with(holder.itemView).setDefaultRequestOptions(RequestOptions.placeholderOf(R.mipmap.ic_launcher)).load(contact.picture).into(holder.picture);
        holder.headline.setText(contact.headline);
        holder.name.setText(contact.firstName + " " + contact.lastName);

    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public void addNewContacts(List<Contact> newUrls) {
        contactList.addAll(newUrls);
        notifyItemRangeChanged(contactList.size() - newUrls.size(), newUrls.size());
    }

    public static class ContactListViewHolder extends RecyclerView.ViewHolder {

        ImageView picture;
        TextView headline;
        TextView name;

        public ContactListViewHolder(View itemView) {
            super(itemView);
            picture = itemView.findViewById(R.id.image);
            headline = itemView.findViewById(R.id.headline);
            name = itemView.findViewById(R.id.name);
        }
    }
}
