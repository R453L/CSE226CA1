package com.example.bms.cse226_ca1;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtPersonName;
    EditText edtPersonNumber;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    ArrayList<Person> personList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ContactAdapter(personList);
        recyclerView.setAdapter(adapter);

        edtPersonName = findViewById(R.id.edt_person_name);
        edtPersonNumber = findViewById(R.id.edt_person_number);
        findViewById(R.id.btn_add_contact).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtPersonName.getText().toString().trim();
                String number = edtPersonNumber.getText().toString().trim();
                if(!name.equals("") || !number.equals("")){
                    Snackbar.make(v,name+" added.",Snackbar.LENGTH_SHORT).show();
                    personList.add(new Person(name,number));
                    adapter.notifyDataSetChanged();
                    recyclerView.scrollToPosition(adapter.getItemCount()-1);
                }else{
                    Snackbar.make(v,"Type a name and number!",Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }
}
