package com.devnovikov.qiwiapp;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.devnovikov.qiwiapp.Adapters.WalletAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HomeFragment extends Fragment {


    public HomeFragment() {
    }


    private List<String> listOfWallet = new ArrayList<String>(Arrays.asList("1000 \u20BD", "24242 $", "1424252 €", "43817 \u20BD"));

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initRecyclerView(view);
        return view;
    }

    private void initRecyclerView(View view) {
        RecyclerView walletRecyclerView = view.findViewById(R.id.wallet_recyclerView);
        WalletAdapter walletAdapter = new WalletAdapter(view.getContext(), listOfWallet);

        walletAdapter.setListener(new WalletAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getActivity(), "id [" + position + "]", Toast.LENGTH_SHORT).show();
            }
        });

        walletRecyclerView.setAdapter(walletAdapter);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                if (!TextUtils.isEmpty(s.trim())) {

                    Toast.makeText(getContext(), "[" + s + "]", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "[" + s + "]", Toast.LENGTH_SHORT).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (!TextUtils.isEmpty(newText.trim())) {
                    Toast.makeText(getContext(), "[" + newText + "]", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "[" + newText + "]", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

        super.onCreateOptionsMenu(menu, inflater);
    }
}
