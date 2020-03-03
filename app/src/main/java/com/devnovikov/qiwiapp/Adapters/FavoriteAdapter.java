package com.devnovikov.qiwiapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.devnovikov.qiwiapp.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {


    private List<String> mFavoriteImageUrls = new ArrayList<>();
    private List<String> mFavoriteTitles = new ArrayList<>();
    private Context mContext;

    public FavoriteAdapter(Context context, ArrayList<String> images, ArrayList<String> titles) {
        this.mFavoriteImageUrls = images;
        this.mFavoriteTitles = titles;
        this.mContext = context;
    }

    @NonNull
    @Override
    public FavoriteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_favorite, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteAdapter.ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mFavoriteImageUrls.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView mFavoriteItemImage;
        private TextView mFavoriteItemTitle;
        private ConstraintLayout mFavoriteItem;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            mFavoriteItemImage = itemView.findViewById(R.id.favorite_image);
            mFavoriteItemTitle = itemView.findViewById(R.id.favorite_describe_title);
            mFavoriteItem = itemView.findViewById(R.id.favorite_item);
        }

        private void bind(int position) {
            Glide.with(mContext)
                    .asBitmap()
                    .load(mFavoriteImageUrls.get(position))
                    .into(mFavoriteItemImage);
            mFavoriteItemTitle.setText(mFavoriteTitles.get(position));

            mFavoriteItem.setOnClickListener((View view) -> {
                Toast.makeText(mContext, mFavoriteTitles.get(position).toString() + " clicked position: " + position, Toast.LENGTH_SHORT).show();
            });
        }
    }
}
