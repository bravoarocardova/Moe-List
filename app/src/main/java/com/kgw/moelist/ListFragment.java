package com.kgw.moelist;


import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {
    private static final String ARG_SECTION = "section";
    private ArrayList<Movie> list;
    private MyAdapter myAdapter;
    private String[] name,genre,release,synopsis;
    private TypedArray poster;

    static ListFragment newInstance(int index){
        ListFragment fragment = new ListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION,index);
        fragment.setArguments(bundle);
        return fragment;
    }

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        list = new ArrayList<>();

        RecyclerView rv = view.findViewById(R.id.rv_data);
        rv.setHasFixedSize(true);

        rv.setLayoutManager(new GridLayoutManager(this.getContext(),2));

        int index = 0;
        if (getArguments() != null){
            index = getArguments().getInt(ARG_SECTION);
        }
        prepare(index);
        addItem();
        rv.setAdapter(myAdapter);
    }

    private void addItem(){
        list = new ArrayList<>();
        for(int i = 0; i < name.length; i++){
            Movie movie = new Movie();
            movie.setName(name[i]);
            movie.setGenre(genre[i]);
            movie.setPoster(poster.getResourceId(i,-1));
            movie.setReleaseYear(release[i]);
            movie.setSynopsis(synopsis[i]);
            list.add(movie);
        }
        myAdapter = new MyAdapter(list);
    }


    private void prepare(int position) {
        switch (position){
            case 0:
                name = getResources().getStringArray(R.array.data_name_movie);
                genre = getResources().getStringArray(R.array.data_genre_movie);
                release = getResources().getStringArray(R.array.data_release_movie);
                synopsis = getResources().getStringArray(R.array.data_synopsis_movie);
                poster = getResources().obtainTypedArray(R.array.data_poster_movie);
                break;
            case 1:
                name = getResources().getStringArray(R.array.data_name_tvshows);
                genre = getResources().getStringArray(R.array.data_genre_tvshows);
                release = getResources().getStringArray(R.array.data_release_tvshows);
                synopsis = getResources().getStringArray(R.array.data_synopsis_tvshows);
                poster = getResources().obtainTypedArray(R.array.data_poster_tvshows);
        }
    }
}
