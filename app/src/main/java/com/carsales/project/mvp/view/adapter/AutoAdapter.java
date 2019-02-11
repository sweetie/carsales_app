package com.carsales.project.mvp.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.carsales.project.R;
import com.carsales.project.mvp.common.interfaces.Listener;
import com.carsales.project.mvp.model.data.Auto;
import com.carsales.project.mvp.model.data.Result;
import com.carsales.project.mvp.view.custom.CustomTextView;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Enny Querales
 */

public class AutoAdapter extends RecyclerView.Adapter<AutoAdapter.ViewHolder> {

    /**
     * Attributes
     */
    private Context context;
    private List<Result> items;
    private Listener.OnSelectedListener listener;

    public AutoAdapter(Context context, List<Result> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View convertView = inflater.inflate(R.layout.auto_item, parent, false);
        return new ViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(final AutoAdapter.ViewHolder holder, int position) {
        final Result item = items.get(position);
        if (item != null) {
            holder.textViewDesc.setText(item.getDisplayTitle());
            holder.textViewPrice.setText(item.getDisplayPrice().getPrice() + " " + item.getDisplayPrice().getPreInfo());
            Picasso.with(context).load(item.getMainPhoto()).into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void clear() {
        int size = items.size();
        items.clear();
        notifyItemRangeRemoved(0, size);
    }

    public void add(Result item) {
        items.add(item);
        notifyDataSetChanged();
    }

    public void setOnSelectedListener(Listener.OnSelectedListener listener) {
        this.listener = listener;
    }

    /**
     * View holder class for list item
     */
    class ViewHolder
            extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        /**
         * Attributes
         */

        ImageView imageView;
        CustomTextView textViewDesc;
        CustomTextView textViewPrice;

        ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.image_auto);
            textViewDesc = view.findViewById(R.id.description);
            textViewPrice = view.findViewById(R.id.price);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();

        }
    }
}
