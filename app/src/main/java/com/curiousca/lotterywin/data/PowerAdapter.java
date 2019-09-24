package com.curiousca.lotterywin.data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.curiousca.lotterywin.R;
import com.curiousca.lotterywin.model.PowerItem;

import java.util.ArrayList;

public class PowerAdapter extends RecyclerView.Adapter<PowerAdapter.PowerViewHolder> {

    private Context mContext;
    private ArrayList<PowerItem> mPowerItemList;

    public PowerAdapter(Context context, ArrayList<PowerItem> powerItemList){

        this.mContext = context;
        this.mPowerItemList = powerItemList;
    }

    @NonNull
    @Override
    public PowerAdapter.PowerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.power_item_card, parent, false);

        return new PowerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PowerAdapter.PowerViewHolder holder, int position) {
        PowerItem currentItem = mPowerItemList.get(position);

        String numbers  = currentItem.getpNumbers();
        String drawDate = currentItem.getpDrawDate();

        holder.mTextViewNumbers.setText(numbers);
        holder.mTextViewDrawDate.setText("Draw Date: " + drawDate);

    }

    @Override
    public int getItemCount() {
        return mPowerItemList.size();
    }

    public class PowerViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextViewNumbers;
        public TextView mTextViewDrawDate;

        public PowerViewHolder(@NonNull View itemView) {
            super(itemView);

            mTextViewNumbers = itemView.findViewById(R.id.textView_numbers);
            mTextViewDrawDate = itemView.findViewById(R.id.textViewDrawDate);
        }
    }
}
