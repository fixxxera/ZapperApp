package com.example.fixxxer.zapperapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.fixxxer.zapperapp.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements CategoryFragment.OnListFragmentInteractionListener {

    MainActivityFragment mainActivityFragment;
    CategoryFragment categoryFragment;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivityFragment = new MainActivityFragment();
        categoryFragment = new CategoryFragment();

        manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container_for_fragments,mainActivityFragment,"main_activity");
        transaction.commit();


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.container_for_fragments, categoryFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }


    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        Toast.makeText(this, String.valueOf(item.content), Toast.LENGTH_SHORT).show();
    }
}
