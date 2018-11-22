package com.ams.planindia.Activities;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import com.ams.planindia.Adapter.PackageAdapter;
import com.ams.planindia.Database.DatabaseHelper;
import com.ams.planindia.Model.PackagePojo;
import com.ams.planindia.R;

import java.util.ArrayList;

public class PackageActivity extends Activity {


    ArrayList<PackagePojo> packageDetailsArrayList;
    ListView packageList;
    DatabaseHelper db = new DatabaseHelper(PackageActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.package_activity);

    }


    public void getdata() {
        packageDetailsArrayList = new ArrayList<>();
        Cursor ques = db.getPackageData();

    }
}
