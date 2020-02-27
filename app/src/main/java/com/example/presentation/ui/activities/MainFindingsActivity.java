package com.example.presentation.ui.activities;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.ColorUtils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

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
        setContentView(R.layout.activity_main_finding2);

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

        RadioGroup rg =(RadioGroup) ((Button) view).getParent();
        String rgTag = rg.getTag().toString();

//        String rgTag = (
//                (RadioGroup) ( ((Button) view).getParent() )
//        ).getTag().toString();

        switch (rgTag) {
            case "btnGroupTipoAC":
                onRBClicked_tipo(view); break;
            case "btnGroupRiskLevel":
                onRBClicked_risk(view); break;
        }
    }

    public void onRBClicked_tipo(View view) {

        String idButton = ((Button) view).getTag().toString();

        Button button1 = (Button) findViewById(R.id.radio_acto);
        button1.setBackground(this.getDrawable(R.drawable.textview_border_grey));
        Button button2 = (Button) findViewById(R.id.radio_condicion);
        button2.setBackground(this.getDrawable(R.drawable.textview_border_grey));

        switch (idButton) {
            case "btnActo":
                button1.setBackground(this.getDrawable(R.drawable.textview_border_black));
                break;
            case "btnCondicion":
                button2.setBackground(this.getDrawable(R.drawable.textview_border_black));
                break;
        }

    }

    public void onRBClicked_risk(View view) {

        String idButton = ((Button) view).getTag().toString();

        Button button1 = (Button) findViewById(R.id.radio_lowRisk);
        button1.setBackgroundColor(Color.parseColor("#778BC34A")); // ligth green
        Button button2 = (Button) findViewById(R.id.radio_mediumRisk);
        button2.setBackgroundColor(Color.parseColor("#75FFBB33")); // light yellow
        Button button3 = (Button) findViewById(R.id.radio_highRisk);
        button3.setBackgroundColor(Color.parseColor("#77FF4444")); // light red

        switch (idButton) {
            case "btnLowRisk":
                button1.setBackgroundColor(Color.GREEN);
                break;
            case "btnMedRisk":
                button2.setBackgroundColor(Color.YELLOW);
                break;
            case "btnHighRisk":
                button3.setBackgroundColor(Color.RED);
                break;
        }

    }

}
