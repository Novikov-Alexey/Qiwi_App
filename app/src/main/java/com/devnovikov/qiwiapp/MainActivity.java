package com.devnovikov.qiwiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.devnovikov.qiwiapp.Adapters.FavoriteAdapter;
import com.devnovikov.qiwiapp.Adapters.PaymentAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> mFavoriteImageUrls = new ArrayList<>();
    private ArrayList<String> mFavoriteTitles = new ArrayList<>();

    private ArrayList<String> mPaymentImageUrls = new ArrayList<>();
    private ArrayList<String> mPaymentTitles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initHomeFragment();
        getImages();

    }

    private void initHomeFragment() {
        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, homeFragment, "");
        fragmentTransaction.commit();
    }

    private void getImages(){

        mFavoriteImageUrls.add("https://habrastorage.org/getpro/moikrug/uploads/company/771/607/661/logo/medium_f7e95e28a457ea9ee7d854a61491eaf5.png");
        mFavoriteTitles.add("Мой мобильный");

        mFavoriteImageUrls.add("https://static.ssl.mts.ru/mts_rf/images/banner1_logo.png");
        mFavoriteTitles.add("Запасной номер");

        mPaymentImageUrls.add("https://i.redd.it/j6myfqglup501.jpg");
        mPaymentTitles.add("Национальный парк");


        mPaymentImageUrls.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        mPaymentTitles.add("ОАО \"ДЭПО\"");

        mPaymentImageUrls.add("https://i.redd.it/k98uzl68eh501.jpg");
        mPaymentTitles.add("Себе на карту");


        mPaymentImageUrls.add("https://i.redd.it/glin0nwndo501.jpg");
        mPaymentTitles.add("Белые пески");

        mPaymentImageUrls.add("https://i.redd.it/obx4zydshg601.jpg");
        mPaymentTitles.add("Австралия");

        mPaymentImageUrls.add("https://i.imgur.com/ZcLLrkY.jpg");
        mPaymentTitles.add("Мексика");

        initRecyclerView();

    }

    private void initRecyclerView(){

        RecyclerView favoriteRecyclerView = findViewById(R.id.favorite_recyclerview);
        RecyclerView paymentRecyclerView = findViewById(R.id.payment_recyclerview);
        //RecyclerView walletRecyclerView = findViewById(R.id.wallet_recyclerView);

        FavoriteAdapter favoriteAdapter = new FavoriteAdapter(this, mFavoriteImageUrls, mFavoriteTitles);
        PaymentAdapter paymentAdapter = new PaymentAdapter(this, mPaymentImageUrls, mPaymentTitles);

        favoriteRecyclerView.setAdapter(favoriteAdapter);
        paymentRecyclerView.setAdapter(paymentAdapter);
    }
}
