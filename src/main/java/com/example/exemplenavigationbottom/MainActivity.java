package com.example.exemplenavigationbottom;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    NavController navController;

    public NavController getNavController() {
        return navController;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar (haute navigation)
        initToolbar();

        //Bottom navigation
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home,
                R.id.navigation_dashboard,
                R.id.navigation_compte,
                R.id.navigation_sorties,
                R.id.navigation_adherents,
                R.id.navigation_notifications)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

    }

    //initialisation de notre navbar
    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);

        //on remplace l'actionbar par la toolbar (l'actionbar est l'ancienne version de toolnbar)
        setSupportActionBar(toolbar);

        //on supprime le titre par défault de ma toolbar
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //on ajoute un logo qui a été créé depuis Drawable
        toolbar.setLogo(R.drawable.ic_asso);
        //on définit le titre de la toolbar
        toolbar.setTitle("AfpaAsso");

        //on ajoute un évènement click sur la toolbar (tous ce qui n'est pas un item du menu, sera lié à ce clique)
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //j'instancie mon fragment par défaut

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //on associe un menu à notre activity
        getMenuInflater().inflate(R.menu.mnu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id)
        {
            case R.id.action_compte:
                navController.navigate(R.id.navigation_compte);
                break;

            case R.id.action_sorties:
                navController.navigate(R.id.navigation_sorties);
                break;

            case R.id.action_quitter:
                //on quitte l'application
                finish();
                break;

        }

        return true;
    }

}
