package com.example.presentation.ui.activities;

import androidx.annotation.NonNull;
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
import android.graphics.drawable.ShapeDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.domain.model.Findings;
import com.example.inspec3.R;
import com.example.presentation.utils.ImageUtil;
import com.example.presentation.view.FindingsView;

import java.util.ArrayList;
import java.util.List;

import static com.example.presentation.utils.Constants.EXTRA_MESSAGE;
import static com.example.presentation.utils.Constants.MY_PERMISSIONS_REQUEST_CAMERA;
import static com.example.presentation.utils.Constants.REQUEST_IMAGE_CAPTURE;

public class MainFindingsActivity
        extends BaseActivity
        implements FindingsView {

    Findings findings;

    ImageView imageView1;
    ImageView imageView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_finding2);

        // Get the Intent that started this activity and extract incoming data

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("objetoFindings");
        this.findings = (Findings) bundle.getSerializable("objetoFindings");

        String message = intent.getStringExtra(EXTRA_MESSAGE);
        int position = Integer.parseInt(message);   // posición del arreglo (o 0 si nuevo)

        // Load fields on screen

        // para las fotos
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);

        // photo_x
        if (position == 0) {
            findings.setPhoto_1("");
            findings.setPhoto_2("");
        }

        imageView1.setImageBitmap( ImageUtil.convert(findings.getPhoto_1()) );
        imageView2.setImageBitmap( ImageUtil.convert(findings.getPhoto_2()) );

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
                onRBClicked_tipo(view);
                break;
            case "btnGroupRiskLevel":
                onRBClicked_risk(view);
                break;
        }
    }

    public void onRBClicked_tipo(View view) {

        // colorea botones Acto, Condición


        String idButton = ((Button) view).getTag().toString();

        Drawable drawableBg = this.getDrawable(R.drawable.textview_border_black);


        Button button1 = (Button) findViewById(R.id.radio_acto);
        button1.setBackground(this.getDrawable(R.drawable.textview_border_gray));
        button1.setTypeface(null, button1.getTypeface().NORMAL);
        button1.setTextColor(Color.GRAY);

        Button button2 = (Button) findViewById(R.id.radio_condicion);
        button2.setBackground(this.getDrawable(R.drawable.textview_border_gray));
        button2.setTypeface(null, button1.getTypeface().NORMAL);
        button2.setTextColor(Color.GRAY);


        switch (idButton) {
            case "btnActo":
                button1.setBackground(drawableBg);
                button1.setTextColor(Color.BLACK);
                button1.setTypeface(null, button1.getTypeface().BOLD);
                break;
            case "btnCondicion":
                button2.setBackground(drawableBg);
                button2.setTextColor(Color.BLACK);
                button2.setTypeface(null, button1.getTypeface().BOLD);
                break;
        }

    }

    public void onRBClicked_risk(View view) {

        // colorea botones de Nivel de Riesgo { bajo, medio, alto }


        String idButton = ((Button) view).getTag().toString();

        Drawable drawableBg = this.getDrawable(R.drawable.textview_border_wk1); // white
        drawableBg = DrawableCompat.wrap(drawableBg);
        DrawableCompat.setTintMode(drawableBg, PorterDuff.Mode.ADD);
        DrawableCompat.setTint(drawableBg, Color.WHITE);

        Button button1 = (Button) findViewById(R.id.radio_lowRisk);
        button1.setBackground(this.getDrawable(R.drawable.textview_border_white));
        button1.setTypeface(null, button1.getTypeface().NORMAL);
        button1.setTextColor(Color.GRAY);
//        button1.setBackgroundColor(Color.parseColor("#778BC34A")); // ligth green

        Button button2 = (Button) findViewById(R.id.radio_mediumRisk);
        button2.setBackground(this.getDrawable(R.drawable.textview_border_white));
        button2.setTypeface(null, button1.getTypeface().NORMAL);
        button2.setTextColor(Color.GRAY);
//        button2.setBackgroundColor(Color.parseColor("#75FFBB33")); // light yellow

        Button button3 = (Button) findViewById(R.id.radio_highRisk);
        button3.setBackground(this.getDrawable(R.drawable.textview_border_white));
        button3.setTypeface(null, button1.getTypeface().NORMAL);
        button3.setTextColor(Color.GRAY);
//        button3.setBackgroundColor(Color.parseColor("#77FF4444")); // light red

        switch (idButton) {
            case "btnLowRisk":
                button1.setTypeface(null, button1.getTypeface().BOLD);
                button1.setTextColor(Color.WHITE);
                button1.setBackground(drawableBg);
                break;
            case "btnMedRisk":
                button2.setTypeface(null, button1.getTypeface().BOLD);
                button2.setTextColor(Color.WHITE);
                button2.setBackground(drawableBg);
                break;
            case "btnHighRisk":
                button3.setTypeface(null, button1.getTypeface().BOLD);
                button3.setTextColor(Color.WHITE);
                button3.setBackground(drawableBg);
                break;
        }

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


} // fin clase
