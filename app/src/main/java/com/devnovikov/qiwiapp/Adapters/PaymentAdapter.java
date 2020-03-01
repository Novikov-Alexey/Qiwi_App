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

import de.hdodenhof.circleimageview.CircleImageView;

public class PaymentAdapter extends RecyclerView.Adapter<PaymentAdapter.ViewHolder>{

    private ArrayList<String> mPaymentImageUrls = new ArrayList<>();
    private ArrayList<String> mPaymentTitles = new ArrayList<>();
    private Context mContext;

    public PaymentAdapter(Context context, ArrayList<String> images, ArrayList<String> titles) {
        this.mPaymentImageUrls = images;
        this.mPaymentTitles = titles;
        this.mContext = context;
    }

    @NonNull
    @Override
    public PaymentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_payment, parent, false);
        return new PaymentAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentAdapter.ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mPaymentImageUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView mPaymentItemImage;
        private TextView mPaymentItemTitle;
        private ConstraintLayout mPaymentItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mPaymentItemImage = itemView.findViewById(R.id.payment_image);
            mPaymentItemTitle = itemView.findViewById(R.id.payment_describe_title);
            mPaymentItem = itemView.findViewById(R.id.payment_item);
        }

        public void bind(int position) {
            Glide.with(mContext)
                    .asBitmap()
                    .load(mPaymentImageUrls.get(position))
                    .into(mPaymentItemImage);
            mPaymentItemTitle.setText(mPaymentTitles.get(position));

            mPaymentItem.setOnClickListener((View view) -> {
                Toast.makeText(mContext, mPaymentTitles.get(position).toString() + " clicked position: " + position  , Toast.LENGTH_SHORT).show();
            });
        }
    }
}
