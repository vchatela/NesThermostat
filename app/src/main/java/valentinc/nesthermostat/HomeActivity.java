package valentinc.nesthermostat;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.github.clans.fab.FloatingActionButton;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Boolean FabHeaterOn = Boolean.TRUE;
    private Boolean FabMosquitoOn = Boolean.TRUE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // TODO : Create FAB because of server info
        // TODO : remove statics
        // TODO : save plugs.json in app
        FloatingActionButton fab_heater = (FloatingActionButton) findViewById(R.id.fab_heater);
        FloatingActionButton fab_mosquito = (FloatingActionButton) findViewById(R.id.fab_mosquito);

        // TODO : Must Ask server
        fab_heater.setColorNormal(Color.parseColor(getResources().getString(R.color.fab_red)));
        fab_mosquito.setColorNormal(Color.parseColor(getResources().getString(R.color.fab_red)));

        fab_heater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FloatingActionButton fab_heater = (FloatingActionButton) findViewById(R.id.fab_heater);

                if(!FabHeaterOn){
                    FabHeaterOn = Boolean.TRUE;
                    fab_heater.setColorNormal(Color.parseColor(getResources().getString(R.color.fab_red)));
                    Snackbar.make(view, "Chauffage éteint", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                else{
                    FabHeaterOn = Boolean.FALSE;
                    fab_heater.setColorNormal(Color.parseColor(getResources().getString(R.color.fab_green)));
                    Snackbar.make(view, "Chauffage allumé", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        fab_mosquito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FloatingActionButton fab_mosquito = (FloatingActionButton) findViewById(R.id.fab_mosquito);

                if(!FabMosquitoOn){
                    FabMosquitoOn = Boolean.TRUE;
                    fab_mosquito.setColorNormal(Color.parseColor(getResources().getString(R.color.fab_red)));
                    Snackbar.make(view, "Anti moustique éteint", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                else{
                    FabMosquitoOn = Boolean.FALSE;
                    fab_mosquito.setColorNormal(Color.parseColor(getResources().getString(R.color.fab_green)));
                    Snackbar.make(view, "Anti moustique allumé", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.admin) {
            // Handle the camera action
        } else if (id == R.id.parameters) {

        } else if (id == R.id.programmation) {

        } else if (id == R.id.sensors) {

        } else if (id == R.id.stats) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
