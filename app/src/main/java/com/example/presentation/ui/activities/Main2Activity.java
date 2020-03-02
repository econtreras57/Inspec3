package com.example.presentation.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.domain.model.Findings;
import com.example.domain.model.Inspection;
import com.example.inspec3.R;
import com.example.presentation.ui.adapters.ListAdapterFindings;
import com.example.presentation.ui.adapters.ListAdapterFindings;
import com.example.presentation.view.FindingsView;
import com.example.presentation.view.FindingsView;

import java.util.ArrayList;
import java.util.List;

import static com.example.presentation.utils.Constants.EXTRA_MESSAGE;

public class Main2Activity
        extends BaseActivity
        implements
        FindingsView,
        ListAdapterFindings.OnItemClickListener  {

    RecyclerView rvFindings;

    public static Inspection inspection = new Inspection();
    public static Findings findings = new Findings();
    public static ArrayList listaFindings = new ArrayList<>();

    private ListAdapterFindings adapterFindings;
    private ListAdapterFindings.OnItemClickListener mlistenerFindings;
    private View v;

    protected void initialSetup () {

        findings = new Findings();
        findings.setId(1);
        findings.setRiskLevel("HIGH");
        findings.setSubtype("Procedure missing");
        findings.setText("No hay procedimiento para esta actividad.");
        findings.setDate("2020-02-25");
        findings.setStatus("Abierto");

        listaFindings.add(findings);

        findings = new Findings();
        findings.setId(2);
        findings.setRiskLevel("Low");
        findings.setSubtype("Procedure missing");
        findings.setText("No hay procedimiento para esta actividad.");
        findings.setDate("2020-02-25");
        findings.setStatus("Abierto");

        listaFindings.add(findings);

        findings = new Findings();
        findings.setId(3);
        findings.setRiskLevel("Medium");
        findings.setSubtype("Procedure missing");
        findings.setText("No hay procedimiento para esta actividad.");
        findings.setDate("2020-02-25");
        findings.setStatus("Cerrado");

        listaFindings.add(findings);

        findings = new Findings();
        findings.setId(4);
        findings.setRiskLevel("Medium");
        findings.setSubtype("Procedure missing");
        findings.setText("No hay procedimiento para esta actividad.");
        findings.setDate("2020-02-26");
        findings.setStatus("Cerrado");

        listaFindings.add(findings);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initialSetup();

        Intent intent = getIntent();
        Bundle intentBundleExtra = intent.getBundleExtra("objetoInspection");
        if (intentBundleExtra!= null) {
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

        tv_position.setText( inspection.getId().toString() );
        tv_subStatus.setText( inspection.getSubStatus().toString() );
        tv_project.setText( inspection.getProject());
        tv_inspector.setText( inspection.getInspector());
        tv_site.setText( inspection.getSite());
        tv_contractor.setText( inspection.getContractor());
        tv_status.setText( inspection.getStatus());
        tv_statusDate.setText( inspection.getStatusDate());

        if ( !tv_status.getText().equals("Abierto") ) {
            tv_subStatus.setTextColor(Color.BLACK);
            tv_status.setTextColor(Color.BLACK);
            tv_status.setBackground(this.getDrawable(R.drawable.textview_border_blue));
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
    public void onItemClicked(View v, Findings findings) {

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

    public void onAddClicked(View v) {

        Context context = getApplicationContext();
        CharSequence text = "Click ADD button " ;
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        // Empaqueta objeto _nuevo_...
        Bundle bundle = new Bundle();
        bundle.putSerializable("objetoFindings", new Findings());

        // Y envía ese paquete a la siguiente pantlla...
        Intent intent = new Intent(this, MainFindingsActivity.class);
        intent.putExtra("objetoFindings", bundle);

        String message = "0";
        intent.putExtra(EXTRA_MESSAGE, message);

        startActivity(intent);      // intent

    }

}
