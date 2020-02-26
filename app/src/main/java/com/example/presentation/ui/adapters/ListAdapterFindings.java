package com.example.presentation.ui.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.domain.model.Findings;
import com.example.inspec3.R;

import java.security.AccessControlContext;
import java.util.ArrayList;
import java.util.List;

import static com.mapbox.mapboxsdk.Mapbox.getApplicationContext;
import static java.security.AccessController.getContext;


public class ListAdapterFindings
        extends
        RecyclerView.Adapter<ListAdapterFindings.FindingsViewHolder> {

    public ListAdapterFindings.OnItemClickListener mlistener;
    private Context mContext;
    private List<Findings> items = new ArrayList<>();   // items, definición solamente


    public ListAdapterFindings(
            ListAdapterFindings.OnItemClickListener listener,
            Context context,
            ArrayList<Findings> item
    ) {

        this.mlistener = listener;
        this.mContext = context;
        this.items = item;

    }

    public interface OnItemClickListener {
        void onItemClicked(View v, Findings findings);
    }

    public void add(Findings item) {
        items.add(item);
        notifyItemInserted(items.size() - 1);
    }

    @Override
    public ListAdapterFindings.FindingsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from
                (parent.getContext()).inflate(
                R.layout.ly_item_findings,
                parent,
                false);

        ListAdapterFindings.FindingsViewHolder
                rvMainAdapterViewHolder =
                new ListAdapterFindings.FindingsViewHolder(view);

        return rvMainAdapterViewHolder;
    }

    @Override   // <-- onBind... definir campos aquí
    public void onBindViewHolder(
            final ListAdapterFindings.FindingsViewHolder holder,
            int position) {

        Findings findings = items.get(position);    // carga objeto FINDINGS( position )

        holder.position.setText(Integer.toString(position));     // guarda la posición
        holder.risk.setText(findings.getRiskLevel());
        holder.subtype.setText(findings.getSubtype());
        holder.text.setText(findings.getText());
        holder.date.setText(findings.getDate());
        holder.status.setText(findings.getStatus());

//        if (findings.getRiskLevel()=="HIGH") holder.risk.setBackgroundColor(Color.RED);
//        if (findings.getRiskLevel()=="Medium") holder.risk.setBackgroundColor(Color.YELLOW);

        switch (findings.getRiskLevel()) {
            case "HIGH":
                holder.risk.setBackgroundColor(Color.RED);
                break;
            case "Medium":
                holder.risk.setBackgroundColor(Color.YELLOW);
                break;
            default:
                holder.risk.setBackgroundColor(Color.GRAY);
                break;
        }

        if (findings.getStatus() != "Abierto") {
            holder.status.setTextColor(Color.BLACK);
            holder.status.setBackground(null);
//            holder.status.setBackground(this.mContext.getDrawable(R.drawable.textview_border_blue));
            // <-- ok para saber
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    // subclase... definir aquí también campos
    class FindingsViewHolder
            extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        TextView position;   // para guardar la pos.
        TextView risk;
        TextView subtype;
        TextView text;
        TextView date;
        TextView status;


        public FindingsViewHolder(View v) {
            super(v);

            position = (TextView) v.findViewById(R.id.tv_position);
            risk = (TextView) v.findViewById(R.id.tv_risk);
            subtype = (TextView) v.findViewById(R.id.tv_subtype);
            text = (TextView) v.findViewById(R.id.tv_text);
            date = (TextView) v.findViewById(R.id.tv_date);
            status = (TextView) v.findViewById(R.id.tv_status);

            v.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            int i = Integer.parseInt(position.getText().toString());
            Findings findings = items.get(i);

            mlistener.onItemClicked(v, findings);

        }
    }

}

