package com.wilderpereira.ecobox;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class FriendsFragment extends Fragment {

    FriendsAdapter adapter;

    public FriendsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_friends, container, false);
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recicler_ranking);

        adapter = new FriendsAdapter(getFriends());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return v;

    }

    List<Friend> getFriends(){
        List<Friend> friends = new ArrayList<>();
        String names[] = {"Wilder Pereira", "Kesia Fortunato", "Diego Moreno" ,"Julio Cesar"};
        for(int i = 0; i < 4; i++){
            Friend f = new Friend();
            f.setName(names[i]);
            f.setLevel("Nivel: "+new Random().nextInt(7) + "\nPontos: "+ new Random().nextInt(7)*24);
            friends.add(f);
        }
        return friends;
    }
}
