package com.curiousca.lotterywin.data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.curiousca.lotterywin.R;
import com.curiousca.lotterywin.model.MegaItem;

import java.util.ArrayList;

public class MegaAdapter extends RecyclerView.Adapter<MegaAdapter.MegaViewHolder> {

    private Context mContext;
    private ArrayList<MegaItem> mMegaItemList;

    public MegaAdapter(Context context, ArrayList<MegaItem> megaItemList){

        this.mContext = context;
        this.mMegaItemList = megaItemList;
    }

    @NonNull
    @Override
    public MegaAdapter.MegaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.mega_item_card, parent, false);

        return new MegaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MegaAdapter.MegaViewHolder holder, int position) {
        MegaItem currentItem = mMegaItemList.get(position);

        String numbers  = currentItem.getmNumbers();
        String mega  = currentItem.getmMega();
        String drawDate = currentItem.getmDrawDate();

        holder.mTextViewNumbers.setText(numbers);
        holder.mTextViewMegaPower.setText(mega);
        holder.mTextViewDrawDate.setText("Draw Date: " + drawDate);

    }

    @Override
    public int getItemCount() {
        return mMegaItemList.size();
    }

    public class MegaViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextViewNumbers;
        public TextView mTextViewMegaPower;
        public TextView mTextViewDrawDate;

        public MegaViewHolder(@NonNull View itemView) {
            super(itemView);

            mTextViewNumbers = itemView.findViewById(R.id.textView_numbers);
            mTextViewMegaPower = itemView.findViewById(R.id.textView_megaPower);
            mTextViewDrawDate = itemView.findViewById(R.id.textViewDrawDate);
        }
    }
}
