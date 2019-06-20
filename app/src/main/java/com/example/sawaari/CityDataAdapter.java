package com.example.sawaari;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CityDataAdapter extends RecyclerView.Adapter<CityDataAdapter.ViewHolder> {

    private Context mContext;
    private List<CityData> mItems;


    public CityDataAdapter(Context context, @NonNull List<CityData> items){
        this.mContext = context;
        this.mItems = items;



    }


    @Override
    public CityDataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemView = inflater.inflate(R.layout.cardview, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CityDataAdapter.ViewHolder holder, int position) {
        final CityData item = mItems.get(position);

        try {
            holder.city_name.setText(item.getName());
            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "You selected " + item.getId(), Toast.LENGTH_SHORT).show();

                }
            });

        }
        catch (Exception e){

        }

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView city_name;
        public View mView;



        public ViewHolder(View itemView){
            super(itemView);
            city_name = itemView.findViewById(R.id.text_view_creator);







        }



    }

}
