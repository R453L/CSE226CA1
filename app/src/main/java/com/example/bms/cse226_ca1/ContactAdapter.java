package com.example.bms.cse226_ca1;

import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    ArrayList<Person> contactList;

    public ContactAdapter(ArrayList<Person> contactList) {
        this.contactList = contactList;
    }
//backup
    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_list_item,parent,false);
        return new ContactViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder contactViewHolder, int i) {
        contactViewHolder.tvPersonName.setText(contactList.get(i).getName());
        contactViewHolder.tvPersonNumber.setText(contactList.get(i).getNumber());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        final TextView tvPersonName;
        final TextView tvPersonNumber;
        Button btnRemove;
        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);

            tvPersonName = itemView.findViewById(R.id.tv_person_name);
            tvPersonNumber=itemView.findViewById(R.id.tv_person_number);
            btnRemove = itemView.findViewById(R.id.btn_remove_item);
            btnRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    contactList.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                    Snackbar.make(v,tvPersonName.getText().toString()+" removed.",Snackbar.LENGTH_SHORT).show();
                }
            });
        }
    }
}
