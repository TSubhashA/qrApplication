package com.example.buscustomerapplicationv2.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.buscustomerapplicationv2.R;
import com.example.buscustomerapplicationv2.adapter.MyArrayAdapter;
import com.example.buscustomerapplicationv2.adapter.MyTicketAdapter;
import com.example.buscustomerapplicationv2.models.Model_ListSjt_ResponsePayload;
import com.example.buscustomerapplicationv2.utils.ConnectionDetector;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import dmax.dialog.SpotsDialog;

public class SelectPassActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    ConnectionDetector cd;
    TextView noPassAvailableTV;

    SpotsDialog progressDialog;

    ProgressBar progressBar;

    MyArrayAdapter myArrayAdapter;

    MyTicketAdapter adapter;
    List<Model_ListSjt_ResponsePayload> list;
    LinearLayout retryLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_pass);

        Objects.requireNonNull(getSupportActionBar()).setTitle("My Passes");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        recyclerView = findViewById(R.id.recyclerView);

        cd = new ConnectionDetector(this);

        noPassAvailableTV=findViewById(R.id.no_pass_available);

        myArrayAdapter=new MyArrayAdapter(this);

        list = new ArrayList<>();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), linearLayoutManager.getOrientation());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}