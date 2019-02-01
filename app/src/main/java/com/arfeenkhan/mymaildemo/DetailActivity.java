package com.arfeenkhan.mymaildemo;

import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle("Details");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        TextView mIcon = findViewById(R.id.tvIcon);
        TextView mSender = findViewById(R.id.tvEmailSender);
        TextView mEmailTitle = findViewById(R.id.tvEmailTitle);
        TextView mEmailDetails = findViewById(R.id.tvEmailDetails);
        TextView mEmailTime = findViewById(R.id.tvEmailTime);
        final ImageView mFavorite = findViewById(R.id.ivFavorite);


        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
            mIcon.setText(mBundle.getString("icon"));
            ((GradientDrawable) mIcon.getBackground()).setColor(mBundle.getInt("colorIcon"));
            mSender.setText(mBundle.getString("sender"));
            mEmailDetails.setText(mBundle.getString("details"));
            mEmailTime.setText(mBundle.getString("time"));
            mEmailTitle.setText(mBundle.getString("title"));
        }

        mFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mFavorite.getColorFilter() != null) {
                    mFavorite.clearColorFilter();
                } else {
                    mFavorite.setColorFilter(ContextCompat.getColor(DetailActivity.this, R.color.colorOrange));
                }
            }
        });

    }
}
