package com.arfeenkhan.mymaildemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<EmailData> mEmailData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle(R.string.app_name);

        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL));

        MailAdapter mMailAdapter = new MailAdapter(mEmailData, MainActivity.this);
        mRecyclerView.setAdapter(mMailAdapter);

        EmailData mEmail = new EmailData("Apple", "Eat Every day",
                "It's good for health",
                "10:42am");
        mEmailData.add(mEmail);
        mEmail = new EmailData("Milk", "Drink Every Day",
                "Any age people can Drink.it's also good for healt.",
                "16:04pm");
        mEmailData.add(mEmail);
        mEmail = new EmailData("Google+", "Top suggested Google+ pages for you",
                "Top suggested Google+ pages for you",
                "18:44pm");
        mEmailData.add(mEmail);
        mEmail = new EmailData("Twitter", "Follow T-Mobile, Samsung Mobile U",
                "James, some people you may know",
                "20:04pm");
        mEmailData.add(mEmail);
        mEmail = new EmailData("Pinterest Weekly", "Pins you’ll love!",
                "Have you seen these Pins yet? Pinterest",
                "09:04am");
        mEmailData.add(mEmail);
        mEmail = new EmailData("Josh", "Going lunch", "Don't forget our lunch at 3PM in Pizza hut",
                "01:04am");
        mEmailData.add(mEmail);

        mEmail = new EmailData("Milk", "Drink Every Day",
                "Any age people can Drink.it's also good for healt.",
                "16:04pm");
        mEmailData.add(mEmail);

    }
}
