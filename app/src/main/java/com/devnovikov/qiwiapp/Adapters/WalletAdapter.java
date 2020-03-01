package com.devnovikov.qiwiapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.devnovikov.qiwiapp.R;

import java.util.ArrayList;

public class WalletAdapter extends RecyclerView.Adapter<WalletAdapter.ViewHolder> {

    private ArrayList<String> mListOfWallet = new ArrayList<>();
    private Listener listener;

    public interface Listener {
        void onClick(int position);
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public WalletAdapter(Context context, ArrayList<String> listOfWallet) {
        mListOfWallet = listOfWallet;
    }

    @NonNull
    @Override
    public WalletAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_wallet, parent, false);
        return new WalletAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WalletAdapter.ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mListOfWallet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private Button mWalletUpdateBalanceButton;
        private TextView mWalletBalanceTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mWalletUpdateBalanceButton = itemView.findViewById(R.id.wallet_update_balance_btn);
            mWalletBalanceTextView = itemView.findViewById(R.id.wallet_balance_textview);
        }

        public void bind(int position) {
            mWalletBalanceTextView.setText(mListOfWallet.get(position));
            mWalletUpdateBalanceButton.setOnClickListener((View v) -> {
                if (listener != null) {
                    listener.onClick(position);
                }
            });
        }
    }
}
