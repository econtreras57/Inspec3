package com.example.presentation.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import com.example.domain.model.Inspection;
import com.example.inspec3.R;
import com.example.presentation.utils.ImageUtil;
import com.example.presentation.view.InspectionView;

import java.util.ArrayList;
import java.util.List;

import static com.example.presentation.utils.Constants.EXTRA_MESSAGE;

public class MainInspectionActivity
        extends BaseActivity
        implements InspectionView {

    Inspection inspection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_inspection);

        // Get the Intent that started this activity and extract incoming data

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("objetoInspection");
        this.inspection = (Inspection) bundle.getSerializable("objetoInspection");

        String message = intent.getStringExtra(EXTRA_MESSAGE);
        int position = Integer.parseInt(message);   // posición del arreglo (o 0 si nuevo)

        // Load fields on screen

    }

    @Override
    public void inspectionCreated(Inspection inspection) {

    }

    @Override
    public void inspectionCreatedList(List<Inspection> inspectionList) {

    }

    @Override
    public void inspectionUpdated(Inspection inspection) {

    }

    @Override
    public void inspectionDeleted(Inspection inspection) {

    }

    @Override
    public void inspectionsListLoaded(ArrayList<Inspection> inspections) {

    }

    @Override
    public void showErrorMessage(String message) {

    }

    @Override
    public Context getContext() {
        return null;
    }

} // fin clase
