package com.example.designpractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import static com.example.designpractice.R.menu.menu;

public class MainActivity extends AppCompatActivity {

    Development development_frag;
    Design design_fraq;
    Markting markting_fraq;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        development_frag = new Development();
        design_fraq = new Design();
        markting_fraq = new Markting();

        BottomNavigationView nav = findViewById(R.id.nav);
        final FrameLayout content = findViewById(R.id.content_layout);
        change_fragment(development_frag);

        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId())
                {
                    case R.id.it1:
                        change_fragment(development_frag);
                        Animation animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.custom_animation);
                        content.startAnimation(animation);
                        break;
                    case R.id.it2:
                        change_fragment(design_fraq);
                        Animation an= AnimationUtils.loadAnimation(MainActivity.this,R.anim.custom_animation);
                        content.startAnimation(an);
                        break;
                    case R.id.it3:
                        Animation ani= AnimationUtils.loadAnimation(MainActivity.this,R.anim.custom_animation);
                        content.startAnimation(ani);
                        break;
                default:return false;
                }

                return true;
            }
        });

    }

    private void change_fragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_layout,fragment);
        fragmentTransaction.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();            //integer since we cannot pass objects to switch case
        switch (id) {
            case R.id.it1:
                Toast.makeText(MainActivity.this, "Hii 1 !!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.it2:
                Toast.makeText(MainActivity.this, "Hii 2 !!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.it3:
                Toast.makeText(MainActivity.this, "Hii 3 !!", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
