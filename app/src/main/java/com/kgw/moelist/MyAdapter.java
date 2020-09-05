package com.kgw.moelist;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<Movie> list;

    MyAdapter(ArrayList<Movie> list){
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.name.setText(list.get(position).getName());
        holder.poster.setImageResource(list.get(position).getPoster());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailIntent = new Intent(holder.itemView.getContext(),DetailActivity.class);
                Movie movie = new Movie();
                movie.setName(list.get(position).getName());
                movie.setSynopsis(list.get(position).getSynopsis());
                movie.setReleaseYear(list.get(position).getReleaseYear());
                movie.setGenre(list.get(position).getGenre());
                movie.setPoster(list.get(position).getPoster());
                detailIntent.putExtra(DetailActivity.EXTRA_DETAIL,movie);
//                Toast.makeText(holder.itemView.getContext(),list.get(position).getName(),Toast.LENGTH_SHORT).show();
                holder.itemView.getContext().startActivity(detailIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView poster;
        private TextView name;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.poster);
            name = itemView.findViewById(R.id.name);
        }
    }
}
