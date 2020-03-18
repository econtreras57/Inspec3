package com.example.presentation.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.domain.model.Inspection;
import com.example.inspec3.R;
import com.example.presentation.ui.adapters.ListAdapterInspection;
import com.example.presentation.view.InspectionView;
import com.example.presentation.view.ListInspectionsView;

import java.util.ArrayList;
import java.util.List;

import static com.example.presentation.utils.Constants.EXTRA_MESSAGE;

/**
 * Muestra Inspecciones
 * 2020-02
 */

public class Main1ListInspectionsActivity
        extends BaseActivity
        implements
        ListInspectionsView,
        ListAdapterInspection.OnItemClickListener {

    RecyclerView rvInspection;

    public static Inspection inspection = new Inspection();
    public static ArrayList listaInspection = new ArrayList<>();

    private ListAdapterInspection adapterInspection;
    private ListAdapterInspection.OnItemClickListener mlistenerInspection;
    private View v;

    protected void initialSetup() {

        inspection = new Inspection();
        inspection.setId(1);
        inspection.setProject("PE-MOPAR");
        inspection.setInspector("Percy R.");
        inspection.setSite("SE Moquegua");
        inspection.setContractor("HMZ Ingenieros");
        inspection.setStatusDate("2020-02-14");
        inspection.setStatus("Abierto");
        inspection.setSubStatus("Pendiente de cierre");
        inspection.setPlanned("Planned");

        listaInspection.add(inspection);

        inspection = new Inspection();
        inspection.setId(2);
        inspection.setProject("PE-MOPAR");
        inspection.setInspector("Percy R.");
        inspection.setSite("SE Moquegua");
        inspection.setContractor("HMZ Ingenieros");
        inspection.setStatusDate("2020-02-05");
        inspection.setStatus("Abierto");
        inspection.setSubStatus("Pendiente de cierre");

        listaInspection.add(inspection);

        inspection = new Inspection();
        inspection.setId(3);
        inspection.setProject("PE-MOPAR");
        inspection.setInspector("Carlos Cabrera");
        inspection.setSite("SE Moquegua");
        inspection.setContractor("HMZ Ingenieros");
        inspection.setStatusDate("2020-02-05");
        inspection.setStatus("Abierto");
        inspection.setSubStatus("Pendiente de cierre");

        listaInspection.add(inspection);

        inspection = new Inspection();
        inspection.setId(4);
        inspection.setProject("PE-MOPAR");
        inspection.setInspector("Carlos Cabrera");
        inspection.setSite("SE Moquegua");
        inspection.setContractor("HMZ Ingenieros");
        inspection.setStatusDate("2020-02-05");
        inspection.setStatus("Cerrado");
        inspection.setSubStatus("Resuelto");
        inspection.setPlanned("Not Planned");


        listaInspection.add(inspection);

        inspection = new Inspection();
        inspection.setId(5);
        inspection.setProject("PE-MOPAR");
        inspection.setInspector("Juan García");
        inspection.setSite("SE Moquegua");
        inspection.setContractor("HMZ Ingenieros");
        inspection.setStatusDate("2020-02-22");
        inspection.setStatus("Abierto");
        inspection.setSubStatus("Falta documentación");

        listaInspection.add(inspection);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1_list_inspections);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        this.getSupportActionBar().setSubtitle(
                getResources().getText(R.string.lista_inspecciones)
        );

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        initialSetup();

        rvInspection = findViewById(R.id.rvInspection);
        rvInspection.setLayoutManager(
                new LinearLayoutManager(
                        getApplicationContext(),
                        LinearLayoutManager.VERTICAL,
                        false
                )
        );

        mlistenerInspection = this;
        adapterInspection = new ListAdapterInspection(
                mlistenerInspection,
                getApplicationContext(),
                listaInspection);

        rvInspection.setAdapter(adapterInspection);


    }

    @Override
    public void inspectionCreatedList(List<Inspection> inspectionList) {

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

    @Override
    public void onItemClicked(View v, Inspection inspection) {

        this.v = v;

        // toast
        TextView tv_position = v.findViewById(R.id.tv_position);

        Context context = getApplicationContext();
        CharSequence text =
                "Click pos.: " + tv_position.getText().toString();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        // toast

        // intent

        // Empaqueta objeto "lost" recibido...
        Bundle bundle = new Bundle();
        bundle.putSerializable("objetoInspection", inspection);

        // Y envía el paquete a siguiente pantlla...
        Intent intent = new Intent(this, Main2ListFindingsActivity.class);
        intent.putExtra("objetoInspection", bundle);

        String message = tv_position.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);

        startActivity(intent);      // intent

    }

    public void onAddClicked(View v) {

        Context context = getApplicationContext();
        CharSequence text = "Click ADD button ";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        // Empaqueta objeto _nuevo_...
        Bundle bundle = new Bundle();
        bundle.putSerializable("objetoInspection", new Inspection());

        // Y envía ese paquete a la siguiente pantlla...
        Intent intent = new Intent(this, MainInspectionActivity.class);
        intent.putExtra("objetoInspection", bundle);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

        String message = "-1";
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
