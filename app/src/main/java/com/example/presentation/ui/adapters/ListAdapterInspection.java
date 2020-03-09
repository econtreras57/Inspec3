package com.example.presentation.ui.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.domain.model.Inspection;
import com.example.inspec3.R;

import java.util.ArrayList;
import java.util.List;


public class ListAdapterInspection
        extends
        RecyclerView.Adapter<ListAdapterInspection.InspectionViewHolder> {

    public ListAdapterInspection.OnItemClickListener mlistener;
    private Context mContext;
    private List<Inspection> items = new ArrayList<>();   // items, definición solamente


    public ListAdapterInspection(
            ListAdapterInspection.OnItemClickListener listener,
            Context context,
            ArrayList<Inspection> item
    ) {

        this.mlistener = listener;
        this.mContext = context;
        this.items = item;

    }

    public interface OnItemClickListener {
        void onItemClicked(View v, Inspection inspection);
    }

    public void add(Inspection item) {
        items.add(item);
        notifyItemInserted(items.size() - 1);
    }

    @Override
    public ListAdapterInspection.InspectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from
                (parent.getContext()).inflate(
                R.layout.ly_item_inspection,
                parent,
                false);

        ListAdapterInspection.InspectionViewHolder
                rvMainAdapterViewHolder =
                new ListAdapterInspection.InspectionViewHolder(view);

        return rvMainAdapterViewHolder;
    }

    @Override   // <-- onBind... definir campos aquí
    public void onBindViewHolder(
            final ListAdapterInspection.InspectionViewHolder holder,
            int position) {

        Inspection inspection = items.get(position);    // carga objeto INSPECTION( position )

        holder.position.setText(Integer.toString(position + 1));     // guarda la posición
        holder.project.setText(inspection.getProject());
        holder.inspector.setText(inspection.getInspector());
        holder.site.setText(inspection.getSite());
        holder.contractor.setText(inspection.getContractor());
        holder.status.setText(inspection.getStatus());
        holder.statusDate.setText(inspection.getStatusDate());
        holder.subStatus.setText(inspection.getSubStatus());

        if (!inspection.getStatus().equals("Abierto")) {
            holder.subStatus.setTextColor(Color.BLACK);
            holder.status.setTextColor(Color.BLACK);
            holder.status.setBackground(this.mContext.getDrawable(R.drawable.textview_border_accent_off));
        } else {
            holder.subStatus.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
            holder.status.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
            holder.status.setBackground(this.mContext.getDrawable(R.drawable.textview_border_accent));
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    // subclase... definir aquí también campos
    class InspectionViewHolder
            extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        TextView position;   // para guardar la pos.
        TextView project;
        TextView inspector;
        TextView site;
        TextView contractor;
        TextView status;
        TextView statusDate;
        TextView subStatus;


        public InspectionViewHolder(View v) {
            super(v);

            position = (TextView) v.findViewById(R.id.tv_position);
            project = (TextView) v.findViewById(R.id.tv_project);
            inspector = (TextView) v.findViewById(R.id.tv_inspector);
            site = (TextView) v.findViewById(R.id.tv_site);
            contractor = (TextView) v.findViewById(R.id.tv_contractor);
            status = (TextView) v.findViewById(R.id.tv_status);
            statusDate = (TextView) v.findViewById(R.id.tv_statusDate);
            subStatus = (TextView) v.findViewById(R.id.tv_subStatus);

            v.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            int i = Integer.parseInt(position.getText().toString());
            Inspection inspection = items.get(i - 1);

            mlistener.onItemClicked(v, inspection);

        }
    }

}

