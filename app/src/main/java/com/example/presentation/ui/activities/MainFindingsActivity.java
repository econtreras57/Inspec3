package com.example.presentation.ui.activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
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

/** Datos Registro Hallazgo, con foto
 * 2020-02
 */

public class MainFindingsActivity
        extends BaseActivity
        implements FindingsView, AdapterView.OnItemSelectedListener {

    Findings findings;
    TextView tv_titDocActivity;

    ImageView imageView1;
    ImageView imageView2;

    Button btnActo;
    Button btnCondicion;

    Button btnLowRisk;
    Button btnMedRisk;
    Button btnHighRisk;

    Spinner spinnerManagement;
    Spinner spinnerSubType;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_finding2);

        // Get the Intent that started this activity and extract incoming data

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("objetoFindings");
        this.findings = (Findings) bundle.getSerializable("objetoFindings");
        if (findings==null) findings = new Findings();

        String message = intent.getStringExtra(EXTRA_MESSAGE);
        int position = Integer.parseInt(message);   // posición del arreglo (o -1 si nuevo)

        // Set and load fields on screen (and other objects on screen)
        btnActo=findViewById(R.id.radio_acto);
        btnCondicion=findViewById(R.id.radio_condicion);

        if (findings.getType()==null) findings.setType("");
        if (findings.getType().equalsIgnoreCase("Acto"))
            switchButton(btnActo, SWITCH_BUTTON_ON);
        if (findings.getType().equalsIgnoreCase("Condición"))
            switchButton(btnCondicion, SWITCH_BUTTON_ON);


        btnLowRisk=findViewById(R.id.radio_lowRisk);
        btnMedRisk=findViewById(R.id.radio_mediumRisk);
        btnHighRisk=findViewById(R.id.radio_highRisk);

        switchButton(btnLowRisk,SWITCH_BUTTON_OFF);
        switchButton(btnMedRisk,SWITCH_BUTTON_OFF);
        switchButton(btnHighRisk,SWITCH_BUTTON_OFF);

        if (findings.getRiskLevel()==null) findings.setRiskLevel("");
        if (findings.getRiskLevel().equalsIgnoreCase("Low"))
            switchButton(btnLowRisk,SWITCH_BUTTON_ON);
        if (findings.getRiskLevel().equalsIgnoreCase("Medium"))
            switchButton(btnMedRisk,SWITCH_BUTTON_ON);
        if (findings.getRiskLevel().equalsIgnoreCase("High"))
            switchButton(btnHighRisk,SWITCH_BUTTON_ON);


        // para las fotos
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);

        spinnerManagementLoad();
        spinnerSubTypeLoad();

        tv_titDocActivity = findViewById(R.id.tv_titDocActivity);


        if (findings.getPhoto_1()==null) findings.setPhoto_1("");
        if (findings.getPhoto_2()==null) findings.setPhoto_2("");

        imageView1.setImageBitmap( ImageUtil.convert(findings.getPhoto_1()) );
        imageView2.setImageBitmap( ImageUtil.convert(findings.getPhoto_2()) );


        String title_add = getString(nuevo_hallazgo);
        String title_upd = getString(edita_hallazgo, message);
        if (position == -1) {
            findings.setPhoto_1("");
            findings.setPhoto_2("");
            tv_titDocActivity.setText(title_add);
        } else {
            tv_titDocActivity.setText(title_upd);
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
            case "btnGroupTipoAC":
                setBtnGroupTipoAC(view);
                break;
            case "btnGroupRiskLevel":
                setBtnGroupRiskLevel(view);
                break;
        }
    }

    public void setBtnGroupTipoAC(View view) {

        // colorea botones Acto, Condición

        String tagButton = ((Button) view).getTag().toString();
        switch (tagButton) {
            case "btnActo":
                switchButton(btnActo, SWITCH_BUTTON_ON);
                switchButton(btnCondicion, SWITCH_BUTTON_OFF);
                break;
            case "btnCondicion":
                switchButton(btnActo, SWITCH_BUTTON_OFF);
                switchButton(btnCondicion, SWITCH_BUTTON_ON);
                break;
        }

    }

    public void setBtnGroupRiskLevel(View view) {

        // colorea botones de Nivel de Riesgo { bajo, medio, alto }

        String tagButton = ((Button) view).getTag().toString();
        switch (tagButton) {
            case "btnLowRisk":
                switchButton(btnLowRisk, SWITCH_BUTTON_ON);
                switchButton(btnMedRisk, SWITCH_BUTTON_OFF);
                switchButton(btnHighRisk, SWITCH_BUTTON_OFF);
                break;
            case "btnMedRisk":
                switchButton(btnLowRisk, SWITCH_BUTTON_OFF);
                switchButton(btnMedRisk, SWITCH_BUTTON_ON);
                switchButton(btnHighRisk, SWITCH_BUTTON_OFF);
            break;
            case "btnHighRisk":
                switchButton(btnLowRisk, SWITCH_BUTTON_OFF);
                switchButton(btnMedRisk, SWITCH_BUTTON_OFF);
                switchButton(btnHighRisk, SWITCH_BUTTON_ON);
                break;
        }

    }

    public void switchButton(Button button, Boolean on_off) {
        if (on_off == SWITCH_BUTTON_ON) {

            // Switch the button on
            button.setBackground(this.getDrawable(R.drawable.textview_border_black));
            button.setTypeface(null, button.getTypeface().BOLD);
            button.setTextColor(Color.BLACK);

        } else {

            // Switch the button off
            button.setBackground(this.getDrawable(R.drawable.textview_border_gray));
            button.setTypeface(null, button.getTypeface().NORMAL);
//            button.setTextColor(getResources().getColor(R.color.silver));
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

} // fin clase
