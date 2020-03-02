package com.example.presentation.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.domain.model.Inspection;
import com.example.inspec3.R;
import com.example.presentation.utils.ImageUtil;
import com.example.presentation.view.InspectionView;

import java.util.ArrayList;
import java.util.List;

import static com.example.presentation.utils.Constants.EXTRA_MESSAGE;

/** Datos registro Inspección
 * 2020-02 ECV
 */

public class MainInspectionActivity
        extends BaseActivity
        implements InspectionView {

    Inspection inspection;
    TextView tv_titDocActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_inspection);

        // Get the Intent that started this activity and extract incoming data

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("objetoInspection");
        this.inspection = (Inspection) bundle.getSerializable("objetoInspection");

        String message = intent.getStringExtra(EXTRA_MESSAGE);
        int position = Integer.parseInt(message);   // posición del arreglo (o -1 si nuevo)

        // Load fields on screen

        tv_titDocActivity = findViewById(R.id.tv_titDocActivity);

        if (position == -1) {
            tv_titDocActivity.setText("Nueva Inspección");
        } else {
            tv_titDocActivity.setText("Inspección: " + message);
        }


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

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
//        switch(view.getId()) {
//            case R.id.radio_lowRisk:
//                if (checked)
//                    // Pirates are the best
//                    break;
//            case R.id.radio_mediumRisk:
//                if (checked)
//                    // Ninjas rule
//                    break;
//            case R.id.radio_highRisk:
//                if (checked)
//                    // Ninjas rule
//                    break;
//        }

        RadioGroup rg = (RadioGroup) ((Button) view).getParent();
        String rgTag = rg.getTag().toString();

        switch (rgTag) {
            case "btnGroupPlanned":
                onRBClicked_planned(view);
                break;

        }
    }

    public void onRBClicked_planned(View view) {

        // colorea botones Planeado, no planeaao


        String idButton = ((Button) view).getTag().toString();  // tag

        Drawable drawableBg = this.getDrawable(R.drawable.textview_border_black);

        Button button1 = (Button) findViewById(R.id.radio_planned); // <-- id
        button1.setBackground(this.getDrawable(R.drawable.textview_border_gray));
        button1.setTypeface(null, button1.getTypeface().NORMAL);
        button1.setTextColor(Color.GRAY);

        Button button2 = (Button) findViewById(R.id.radio_notPlanned); // <-- id
        button2.setBackground(this.getDrawable(R.drawable.textview_border_gray));
        button2.setTypeface(null, button1.getTypeface().NORMAL);
        button2.setTextColor(Color.GRAY);

        switch (idButton) {
            case "btnPlanned":
                button1.setBackground(drawableBg);
                button1.setTextColor(Color.BLACK);
                button1.setTypeface(null, button1.getTypeface().BOLD);
                break;
            case "btnNotPlanned":
                button2.setBackground(drawableBg);
                button2.setTextColor(Color.BLACK);
                button2.setTypeface(null, button1.getTypeface().BOLD);
                break;
        }

    }

} // fin clase
