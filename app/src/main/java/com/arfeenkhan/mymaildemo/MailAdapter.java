package com.arfeenkhan.mymaildemo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MailAdapter extends RecyclerView.Adapter<MailAdapter.MailViewHolder> {
    private ArrayList<EmailData> mEmailData;
    private Context mContext;

    public MailAdapter(ArrayList<EmailData> mEmailData, Context mContext) {
        this.mEmailData = mEmailData;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MailViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_mail_item, viewGroup, false);
        return new MailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MailViewHolder mailViewHolder, int i) {
        EmailData emailData = mEmailData.get(i);
        mailViewHolder.mSender.setText(emailData.getmSender());
        mailViewHolder.mEmailTime.setText(emailData.getmTime());
        mailViewHolder.mEmailDetails.setText(emailData.getmDetails());
        mailViewHolder.mEmailTitle.setText(emailData.getmTitle());
        mailViewHolder.mIcon.setText(mEmailData.get(i).getmSender().substring(0, 1));

        Random mRandom = new Random();
        final int color = Color.argb(255, mRandom.nextInt(256), mRandom.nextInt(256), mRandom.nextInt(256));
        ((GradientDrawable) mailViewHolder.mIcon.getBackground()).setColor(color);

        mailViewHolder.mFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mailViewHolder.mFavorite.getColorFilter() != null) {
                    mailViewHolder.mFavorite.clearColorFilter();
                } else {
                    mailViewHolder.mFavorite.setColorFilter(ContextCompat.getColor(mContext, R.color.colorOrange));
                }
            }
        });

        mailViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(mContext, DetailActivity.class);
                mIntent.putExtra("sender", mailViewHolder.mSender.getText().toString());
                mIntent.putExtra("title", mailViewHolder.mEmailTitle.getText().toString());
                mIntent.putExtra("details", mailViewHolder.mEmailDetails.getText().toString());
                mIntent.putExtra("time", mailViewHolder.mEmailTime.getText().toString());
                mIntent.putExtra("icon", mailViewHolder.mIcon.getText().toString());
                mIntent.putExtra("colorIcon", color);
                mContext.startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mEmailData.size();
    }


    public class MailViewHolder extends RecyclerView.ViewHolder {

        TextView mIcon;
        TextView mSender;
        TextView mEmailTitle;
        TextView mEmailDetails;
        TextView mEmailTime;
        ImageView mFavorite;

        public MailViewHolder(@NonNull View itemView) {
            super(itemView);

            mIcon = itemView.findViewById(R.id.tvIcon);
            mSender = itemView.findViewById(R.id.tvEmailSender);
            mEmailTitle = itemView.findViewById(R.id.tvEmailTitle);
            mEmailDetails = itemView.findViewById(R.id.tvEmailDetails);
            mEmailTime = itemView.findViewById(R.id.tvEmailTime);
            mFavorite = itemView.findViewById(R.id.ivFavourite);

        }
    }
}
