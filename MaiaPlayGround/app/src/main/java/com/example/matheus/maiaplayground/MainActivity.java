package com.example.matheus.maiaplayground;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private android.support.v7.widget.ShareActionProvider shareActionProvider;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu_main, menu);



        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider = (android.support.v7.widget.ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        setIntent("Queria compartilhar algo");


        return true;
    }
    private void setIntent(String text){
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(shareIntent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id== R.id.action_refresh){
            Toast.makeText(this, "Vc clicou no Refresh ;P", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // ViewPager
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new TabsAdapter(getSupportFragmentManager()));

        // Configura as Tabs
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(android.app.ActionBar.NAVIGATION_MODE_TABS);
        actionBar.addTab(actionBar.newTab().setText("Coisas").setTabListener(new MyTabListener(viewPager, 0)));
        actionBar.addTab(actionBar.newTab().setText("Paradas").setTabListener(new MyTabListener(viewPager, 1)));
        actionBar.addTab(actionBar.newTab().setText("Trecos").setTabListener(new MyTabListener(viewPager, 2)));
        actionBar.setTitle("Maia PlayGround");
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
            @Override
            public void onPageScrollStateChanged(int state) {}
        });
    }


}