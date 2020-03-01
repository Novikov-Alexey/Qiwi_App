package com.devnovikov.qiwiapp;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;


public class HomeFragment extends Fragment {


    public HomeFragment() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true); //to show menu option in fragment
        super.onCreate(savedInstanceState);
    }

    //inflate options menu
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        //inflating menu
        inflater.inflate(R.menu.menu_main, menu);

        //SearchView
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        //search listener
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                //called when user press search button from keyboard
                // if search query is not empty then search
                if (!TextUtils.isEmpty(s.trim())){
                    //search text contains text, search it
//                    searchUsers(s);
                    Toast.makeText(getContext(), "1"+s, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "2"+s, Toast.LENGTH_SHORT).show();
                    //search text empty,get all users
//                    getAllUsers();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //called whenever user press any single letter
                if (!TextUtils.isEmpty(newText.trim())){
                    //search text contains text, search it
                    Toast.makeText(getContext(), "1"+newText, Toast.LENGTH_SHORT).show();
                } else {
                    //search text empty,get all users
                    Toast.makeText(getContext(), "2"+newText, Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

        super.onCreateOptionsMenu(menu, inflater);
    }



}
