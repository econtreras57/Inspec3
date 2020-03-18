package com.example.presentation.ui.activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.domain.model.Findings;
import com.example.inspec3.R;
import com.example.presentation.utils.ImageUtil;
import com.example.presentation.view.FindingsView;

import java.util.ArrayList;
import java.util.List;

import static com.example.inspec3.R.string.edita_hallazgo;
import static com.example.inspec3.R.string.nuevo_hallazgo;
import static com.example.presentation.utils.Constants.EXTRA_MESSAGE;
import static com.example.presentation.utils.Constants.MY_PERMISSIONS_REQUEST_CAMERA;
import static com.example.presentation.utils.Constants.REQUEST_IMAGE_CAPTURE;
import static com.example.presentation.utils.Constants.SWITCH_BUTTON_OFF;
import static com.example.presentation.utils.Constants.SWITCH_BUTTON_ON;

/**
 * Datos Registro Hallazgo, con foto
 * 2020-02
 */

public class MainFindingsActivity
        extends BaseActivity
        implements FindingsView, AdapterView.OnItemSelectedListener {

    Findings findings;
    TextView tv_titDocActivity;

    ImageView imageView1;
    ImageView imageView2;

    Spinner spinnerManagement;
    Spinner spinnerSubType;

    Button buttonA;
    Button buttonC;

    Button button1;
    Button button2;
    Button button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_finding3);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        // subtítulo del toolbar luego, al final de esta rutina

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Get the Intent that started this activity and extract incoming data

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("objetoFindings");
        this.findings = (Findings) bundle.getSerializable("objetoFindings");
        if (findings == null) findings = new Findings();

        String message = intent.getStringExtra(EXTRA_MESSAGE);
        int position = Integer.parseInt(message);   // posición del arreglo (o -1 si nuevo)

        // Set and load fields on screen (and other objects on screen)

        buttonA = findViewById(R.id.buttonA);
        buttonC = findViewById(R.id.buttonC);

        switchButton(buttonA, SWITCH_BUTTON_OFF);
        switchButton(buttonC, SWITCH_BUTTON_OFF);

        if (findings.getType() == null) findings.setType("");
        if (findings.getType().equalsIgnoreCase("Acto"))
            switchButton(buttonA, SWITCH_BUTTON_ON);
        if (findings.getType().equalsIgnoreCase("Condición"))
            switchButton(buttonC, SWITCH_BUTTON_ON);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        switchButton(button1, SWITCH_BUTTON_OFF);
        switchButton(button2, SWITCH_BUTTON_OFF);
        switchButton(button3, SWITCH_BUTTON_OFF);

        if (findings.getRiskLevel() == null) findings.setRiskLevel("");
        if (findings.getRiskLevel().equalsIgnoreCase("Low"))
            switchButton(button1, SWITCH_BUTTON_ON);
        if (findings.getRiskLevel().equalsIgnoreCase("Medium"))
            switchButton(button2, SWITCH_BUTTON_ON);
        if (findings.getRiskLevel().equalsIgnoreCase("High"))
            switchButton(button3, SWITCH_BUTTON_ON);


        // para las fotos
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);

        spinnerManagementLoad();
        spinnerSubTypeLoad();

        tv_titDocActivity = findViewById(R.id.tv_titDocActivity);


        if (findings.getPhoto_1() == null) findings.setPhoto_1("");
        if (findings.getPhoto_2() == null) findings.setPhoto_2("");

        imageView1.setImageBitmap(ImageUtil.convert(findings.getPhoto_1()));
        imageView2.setImageBitmap(ImageUtil.convert(findings.getPhoto_2()));

        EditText et_text = findViewById(R.id.et_text);
        et_text.setText(findings.getText());
        if (et_text.getText()==null) et_text.setText("");

        String title_add = getString(nuevo_hallazgo);
        String title_upd = getString(edita_hallazgo, message);
        if (position == -1) {
            findings.setPhoto_1("");
            findings.setPhoto_2("");
            tv_titDocActivity.setText(title_add);
            this.getSupportActionBar().setSubtitle(title_add);
            View header = findViewById(R.id.constraintLayoutHeader);
            header.setVisibility(View.GONE);

        } else {
            tv_titDocActivity.setText(title_upd);
            this.getSupportActionBar().setSubtitle("");
            View header = findViewById(R.id.constraintLayoutHeader);
            header.setVisibility(View.VISIBLE);

        }

    }

    public void spinnerManagementLoad() {
//        Spinner spinnerManagement = (Spinner) findViewById(R.id.spinner_management);
        spinnerManagement = (Spinner) findViewById(R.id.spinner_management);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterManagement = ArrayAdapter.createFromResource(this,
                R.array.management_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapterManagement.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinnerManagement.setAdapter(adapterManagement);

        spinnerManagement.setSelection(adapterManagement.getPosition(findings.getManagement()));
        spinnerManagement.setOnItemSelectedListener(this);
    }

    public void spinnerSubTypeLoad() {
        spinnerSubType = (Spinner) findViewById(R.id.spinner_subType);
        ArrayAdapter<CharSequence> adapterSubType = ArrayAdapter.createFromResource(this,
                R.array.subType_array, android.R.layout.simple_spinner_item);
        adapterSubType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSubType.setAdapter(adapterSubType);

        spinnerSubType.setSelection(adapterSubType.getPosition(findings.getSubType()));
        spinnerSubType.setOnItemSelectedListener(this);
    }

    @Override
    public void findingsCreated(Findings findings) {

    }

//    @Override
//    public void findingsCreatedList(List<Findings> findingsList) {
//
//    }
//
    @Override
    public void findingsUpdated(Findings findings) {

    }

    @Override
    public void findingsDeleted(Findings findings) {

    }

//    @Override
//    public void findingssListLoaded(ArrayList<Findings> findingss) {
//
//    }
//
    @Override
    public void showErrorMessage(String message) {

    }

    @Override
    public Context getContext() {
        return null;
    }

    public void OnButtonG1Checked(View view) {

        switchButton(buttonA, SWITCH_BUTTON_OFF);
        switchButton(buttonC, SWITCH_BUTTON_OFF);

        switch (view.getId()) {
            case R.id.buttonA:
                switchButton(buttonA, SWITCH_BUTTON_ON);
                break;
            case R.id.buttonC:
                switchButton(buttonC, SWITCH_BUTTON_ON);
                break;

        }
    }

    public void OnButtonG2Checked(View view) {

        switchButton(button1, SWITCH_BUTTON_OFF);
        switchButton(button2, SWITCH_BUTTON_OFF);
        switchButton(button3, SWITCH_BUTTON_OFF);

        switch (view.getId()) {
            case R.id.button1:
                switchButton(button1, SWITCH_BUTTON_ON);
                break;
            case R.id.button2:
                switchButton(button2, SWITCH_BUTTON_ON);
                break;
            case R.id.button3:
                switchButton(button3, SWITCH_BUTTON_ON);
                break;

        }
    }

    public void switchButton(Button button, Boolean on_off) {
        if (on_off == SWITCH_BUTTON_ON) {

            // Switch the button on
//            button.setTypeface(null, button.getTypeface().BOLD);
            button.setTypeface(null, Typeface.BOLD);
            button.setTextColor(Color.BLACK);

        } else {

            // Switch the button off
//            button.setTypeface(null, button.getTypeface().NORMAL);
            button.setTypeface(null, Typeface.NORMAL);
            button.setTextColor(Color.GRAY);

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)

        String sTest = (String) parent.getTag();
        String itemAtPosition = (String) parent.getItemAtPosition(position);

        Context context = getApplicationContext();
        CharSequence text = "Click SPINNER button: \n" + sTest + "\n" + itemAtPosition;
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

        // Another interface callback

    }

    public void onImgClicked(View v) {

        CharSequence text = "Clic imagen... ";   // validar primero
        Context thisActivity = this;

        if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)) {
            text = text + "cámara no disponible... ";
        }

        if (ContextCompat.checkSelfPermission(
                thisActivity, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            text = text + "cámara sin permiso";


            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CAMERA)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

//                WaitAMomentPls(0, "Necesitamos la cámara por favor");
                // toast solicita camera
                Context context = getApplicationContext();
                CharSequence charSequence = "Click Imagen, necesitamos la cámara por favor";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, charSequence, duration);
                toast.show();


            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA},
                        MY_PERMISSIONS_REQUEST_CAMERA);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }


        }

        if (text != "Clic imagen... ") {
            // toast no camera
            Context context = getApplicationContext();
//            CharSequence text = "Click Imagen, cámara no disponible";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            return;
        }

        // todo_ ok, acción

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }

    } // on clic

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView1.setImageBitmap(imageBitmap);
//            tv32petImage.setText(ImageUtil.convert(imageBitmap));
        }
    }

    @Override
    public void onRequestPermissionsResult(
            int requestCode,
            @NonNull String[] permissions,
            @NonNull int[] grantResults) {

        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CAMERA: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // CAMERA-related task you need to do.

                    Context context = getApplicationContext();
                    CharSequence text = "Listo! Vuelve a intentar la foto";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // otros casos

        } // fin casos

    } // fin permisos

    public void onButtonSaveClicked(View v) {
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

} // fin clase
