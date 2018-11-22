package com.ams.planindia.Activities;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ams.planindia.Adapter.MainMenuAdapter;
import com.ams.planindia.Adapter.PackageAdapter;
import com.ams.planindia.Database.DatabaseHelper;
import com.ams.planindia.Model.MenuActivityPojo;
import com.ams.planindia.Model.PackagePojo;
import com.ams.planindia.R;

import java.util.ArrayList;

public class MainMenuActivity extends Activity {


    ArrayList<MenuActivityPojo> menuNamelist;
    DatabaseHelper db = new DatabaseHelper(this);


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_activity);



        db.insertMenuName("Package");
        db.insertMenuName("Experience");
        db.insertMenuName("Tools");
        db.insertMenuName("About Us");
        db.insertMenuName("FAQs");
        db.insertMenuName("Queries");


initRecyclerView();



    }
    private void initRecyclerView(){




        menuNamelist = new ArrayList<>();
        Cursor menuname = db.getMenuNames();


        if (menuname.getCount() == 0) {

            return;
        }
        while (menuname.moveToNext()) {

            MenuActivityPojo menu = new MenuActivityPojo();
            menu.setMenuName(menuname.getString(menuname.getColumnIndex("menuName")));

            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            menuNamelist.add(menu);
            MainMenuAdapter adapter = new MainMenuAdapter(menuNamelist,this);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }



    }
}
