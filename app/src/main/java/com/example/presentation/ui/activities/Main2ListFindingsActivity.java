package com.example.presentation.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.domain.model.Findings;
import com.example.domain.model.Inspection;
import com.example.inspec3.R;
import com.example.presentation.ui.adapters.ListAdapterFindings;
import com.example.presentation.view.FindingsView;
import com.example.presentation.view.ListFindingsView;

import java.util.ArrayList;
import java.util.List;

import static com.example.presentation.utils.Constants.EXTRA_MESSAGE;

/**
 * Muestra Hallazgos de una Inspección
 * 2020-02
 */

public class Main2ListFindingsActivity
        extends BaseActivity
        implements
        ListFindingsView,
        ListAdapterFindings.OnItemClickListener {

    RecyclerView rvFindings;

    public static Inspection inspection = new Inspection();
    public static Findings findings = new Findings();
    public static ArrayList listaFindings = new ArrayList<>();

    private ListAdapterFindings adapterFindings;
    private ListAdapterFindings.OnItemClickListener mlistenerFindings;
    private View v;

    protected void initialSetup() {

        Integer idNum = listaFindings.size();

        findings = new Findings();
        ++idNum;
        findings.setId(idNum);
        findings.setRiskLevel("HIGH");
        findings.setSubType("Procedure missing");
        findings.setText("No hay procedimiento para esta actividad.");
        findings.setDate("2020-02-25");
        findings.setStatus("Abierto");
        findings.setType("Condición");

        listaFindings.add(findings);

        findings = new Findings();
        ++idNum;
        findings.setId(idNum);
        findings.setRiskLevel("Low");
        findings.setSubType("Procedure missing");
        findings.setText("No hay procedimiento para esta actividad.");
        findings.setDate("2020-02-25");
        findings.setStatus("Abierto");
        findings.setType("Acto");

        listaFindings.add(findings);

        findings = new Findings();
        ++idNum;
        findings.setId(idNum);
        findings.setRiskLevel("Medium");
        findings.setSubType("Procedure missing");
        findings.setText("No hay procedimiento para esta actividad.");
        findings.setDate("2020-02-25");
        findings.setStatus("Cerrado");

        listaFindings.add(findings);

        findings = new Findings();
        ++idNum;
        findings.setId(idNum);
        findings.setRiskLevel("Medium");
        findings.setSubType("Procedure missing");
        findings.setText("No hay procedimiento para esta actividad.");
        findings.setDate("2020-02-26");
        findings.setStatus("Cerrado");

        listaFindings.add(findings);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_list_findings);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        this.getSupportActionBar().setSubtitle(
                getResources().getText(R.string.lista_hallazgos)
        );


        for (int i = 0; i < 3; i++) initialSetup();

        Intent intent = getIntent();
        Bundle intentBundleExtra = intent.getBundleExtra("objetoInspection");
        if (intentBundleExtra != null) {
            this.inspection = (Inspection) intentBundleExtra.getSerializable("objetoInspection");
        }   // Recibe objeto inspection

        TextView tv_position = findViewById(R.id.tv_position);
        TextView tv_subStatus = findViewById(R.id.tv_subStatus);
        TextView tv_project = findViewById(R.id.tv_project);
        TextView tv_inspector = findViewById(R.id.tv_inspector);
        TextView tv_site = findViewById(R.id.tv_site);
        TextView tv_contractor = findViewById(R.id.tv_contractor);
        TextView tv_status = findViewById(R.id.tv_status);
        TextView tv_statusDate = findViewById(R.id.tv_statusDate);

        tv_position.setText(inspection.getId().toString());
        tv_subStatus.setText(inspection.getSubStatus().toString());
        tv_project.setText(inspection.getProject());
        tv_inspector.setText(inspection.getInspector());
        tv_site.setText(inspection.getSite());
        tv_contractor.setText(inspection.getContractor());
        tv_status.setText(inspection.getStatus());
        tv_statusDate.setText(inspection.getStatusDate());

        if (!tv_status.getText().equals("Abierto")) {
            tv_subStatus.setTextColor(Color.BLACK);
            tv_status.setTextColor(Color.BLACK);
            tv_status.setBackground(this.getDrawable(R.drawable.textview_border_accent_off));
        } else {
            tv_subStatus.setTextColor(this.getResources().getColor(R.color.colorAccent));
            tv_status.setTextColor(this.getResources().getColor(R.color.colorAccent));
            tv_status.setBackground(this.getDrawable(R.drawable.textview_border_accent));
        }

        rvFindings = findViewById(R.id.rvFindings);
        rvFindings.setLayoutManager(
                new LinearLayoutManager(
                        getApplicationContext(),
                        LinearLayoutManager.VERTICAL,
                        false
                )
        );

        mlistenerFindings = this;
        adapterFindings = new ListAdapterFindings(
                mlistenerFindings,
                getApplicationContext(),
                listaFindings);

        rvFindings.setAdapter(adapterFindings);


    }

    @Override
    public void findingsCreatedList(List<Findings> findingsList) {

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

    @Override
    public void onItemClicked(View v, Findings findings) {

        this.v = v;

        //region Toast
        TextView tv_position = v.findViewById(R.id.tv_position);

        Context context = getApplicationContext();
        CharSequence text =
                "Click pos.: " + tv_position.getText().toString();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
//        toast.show();
        //endregion

        // Empaqueta objeto "lost" recibido...
        Bundle bundle = new Bundle();
        bundle.putSerializable("objetoFindings", findings);

        // Y envía el paquete a siguiente pantlla...
        Intent intent = new Intent(this, MainFindingsActivity.class);
        intent.putExtra("objetoFindings", bundle);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY); // <-- anula el retorno de foto

        String message = tv_position.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);

        startActivity(intent);      // intent

    }

    public void onAddClicked(View v) {

        Context context = getApplicationContext();
        CharSequence text = "Click ADD button ";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
//        toast.show();
//
        // Empaqueta objeto _nuevo_...
        Bundle bundle = new Bundle();
        bundle.putSerializable("objetoFindings", new Findings());

        // Y envía ese paquete a la siguiente pantlla...
        Intent intent = new Intent(this, MainFindingsActivity.class);
        intent.putExtra("objetoFindings", bundle);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY); // <-- anula el retorno de foto

        String message = "-1";
        intent.putExtra(EXTRA_MESSAGE, message);

        startActivity(intent);      // intent

    }

    public void onHeaderClicked(View v) {

        Context context = getApplicationContext();
        CharSequence text = "Click HEADER button ";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        // Empaqueta objeto _nuevo_...
        Bundle bundle = new Bundle();
        bundle.putSerializable("objetoInspection", inspection);

        // Y envía ese paquete a la siguiente pantlla...
        Intent intent = new Intent(this, MainInspectionActivity.class);
        intent.putExtra("objetoInspection", bundle);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

//        String message = "-7";
        String message = inspection.getId().toString();
        intent.putExtra(EXTRA_MESSAGE, message);

        startActivity(intent);      // intent

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
}
