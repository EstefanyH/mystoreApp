package com.hache.mystoreapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationView;
import com.hache.mystoreapp.ui.bodega.PerfilBodFragment;
import com.hache.mystoreapp.ui.bodega.ProductoBodFragment;
import com.hache.mystoreapp.ui.cliente.HistorialCliFragment;
import com.hache.mystoreapp.ui.cliente.PerfilCliFragment;
import com.hache.mystoreapp.ui.cliente.ProductoCliFragment;
import com.hache.mystoreapp.ui.repartidor.HistorialRepFragment;
import com.hache.mystoreapp.ui.repartidor.PedidoRepFragment;
import com.hache.mystoreapp.ui.repartidor.PerfilRepFragment;
import com.hache.mystoreapp.ui.seguridad.RolSecFragment;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener, RolSecFragment.OnFragmentInteractionListener,
        PerfilRepFragment.OnFragmentInteractionListener, PerfilCliFragment.OnFragmentInteractionListener,
        ProductoCliFragment.OnFragmentInteractionListener, HistorialCliFragment.OnFragmentInteractionListener {

    Menu menu = null;
    Fragment fragment = null;
    private LoadingDialog loadingDialog = null;
    ActionBarDrawerToggle toggle = null;
    ToggleButton toggleButton = null;
    //Toolbar toolbar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //ButterKnife.bind(this);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer,toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.bringToFront();


        /*
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                menu = navigationView.getMenu();
                MenuItem item = menu.findItem(1).setVisible(false);
            }
        });*/
        loadingDialog = new LoadingDialog(MainActivity.this);

        displaySelectedScreen(1);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //menu.add(0, 0, 0, "Quit").setIcon(R.drawable.ic_menu);
        getMenuInflater().inflate(R.menu.main, menu);

        //MenuItem itemSearch = menu.findItem(R.id.nav_cli_producto);
        //itemSearch.setVisible(false);
        MenuItem search = menu.findItem(R.id.nav_search);
        SearchView searchView = (SearchView) search.getActionView();
        searchView.setQueryHint("Busqueda....");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        /*switch (item.getItemId()){
            default:
                item.setVisible(false);
                break;
        } */
        return super.onOptionsItemSelected(item);
    }


    private void displaySelectedScreen(int itemId) {
        // update the main content by replacing fragments
        try{

            switch (itemId) {
                /*case R.id.nav_cli_perfil:
                    fragment = new PerfilCliFragment();
                    break; */
                case R.id.nav_cli_producto:
                    fragment = new ProductoCliFragment();

                    break;
                case R.id.nav_cli_historial:
                    fragment = new HistorialCliFragment();
                    break;
               /* case R.id.nav_bod_perfil:
                    fragment = new PerfilBodFragment();
                    break;*/
                case R.id.nav_bod_producto:
                    fragment = new ProductoBodFragment();
                    break;
                /*case R.id.nav_rep_perfil:
                    fragment = new PerfilRepFragment();
                    break;*/
                case R.id.nav_rep_pedido:
                    fragment = new PedidoRepFragment();
                case R.id.nav_rep_historial:
                    fragment = new HistorialRepFragment();
                    break;
                case 1:
                    fragment = new RolSecFragment();
                    break;
                default:
                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                    break;

            }

            if (fragment != null) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragment, fragment);
                ft.commit();
            }

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
        }catch (Exception ex){
            Log.e("SlidingMenu", "Error in creating fragment");
            Log.e("Error: ",ex.getMessage());
        }

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        //calling the method displayselectedscreen and passing the id of selected menu
        displaySelectedScreen(item.getItemId());
        //make this method blank
        return true;
    }

    @Override
    public void setActionBarTitle(String title) {
        setTitle(title);
    }

    @Override
    public void onLoadingShow() {
        loadingDialog.startLoadingDialog();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadingDialog.dismissDialog();
            }
        },5000);
    }

    @Override
    public void onLoadingHide() {
        loadingDialog.dismissDialog();
    }


}