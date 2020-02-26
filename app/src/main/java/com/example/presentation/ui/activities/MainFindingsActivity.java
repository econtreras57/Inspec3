package com.example.presentation.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.domain.model.Findings;
import com.example.domain.model.Inspection;
import com.example.inspec3.R;
import com.example.presentation.view.FindingsView;

import java.util.ArrayList;
import java.util.List;

import static com.example.presentation.utils.Constants.EXTRA_MESSAGE;

public class MainFindingsActivity
        extends BaseActivity
        implements FindingsView {

    Findings findings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_findings);

        // Get the Intent that started this activity and extract incoming data

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("objetoFindings");
        this.findings = (Findings) bundle.getSerializable("objetoFindings");

        String message = intent.getStringExtra(EXTRA_MESSAGE);
        int position = Integer.parseInt(message);   // posición del arreglo (o 0 si nuevo)

        // Load fields on screen

    }

    @Override
    public void findingsCreated(Findings findings) {

    }

    @Override
    public void findingsCreatedList(List<Findings> findingsList) {

    }

    @Override
    public void findingsUpdated(Findings findings) {

    }

    @Override
    public void findingsDeleted(Findings findings) {

    }

    @Override
    public void findingssListLoaded(ArrayList<Findings> findingss) {

    }

    @Override
    public void showErrorMessage(String message) {

    }

    @Override
    public Context getContext() {
        return null;
    }
}
