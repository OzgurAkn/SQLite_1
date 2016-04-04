package com.example.ozgur.sqlite_2048;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UpdateUserActivity extends AppCompatActivity {

    @Bind(R.id.edit_name)
    EditText name;
    @Bind(R.id.edit_age)
    EditText age;
    @Bind(R.id.edit_adress)
    EditText adress;
    @Bind(R.id.edit_zipcode)
    EditText zipcode;
    @Bind(R.id.edit_city)
    EditText city;

    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.databaseHelper = new DatabaseHelper(this);
        this.database = databaseHelper.getWritableDatabase();

        ButterKnife.bind(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateUserActivity.this.saveUser();
                startActivity(new Intent(UpdateUserActivity.this, MainActivity.class));
            }
        });
    }

    private void saveUser() {
        this.database.execSQL("Delete from " + UserTable.TABLE_NAME);

        User user = new User();
        user.setName(name.getText().toString());
        user.setAge(Integer.parseInt(age.getText().toString()));
        user.setAdress(adress.getText().toString());
        user.setZipcode(Integer.parseInt(zipcode.getText().toString()));
        user.setCity(city.getText().toString());

        this.database.insert(UserTable.TABLE_NAME, null, UserTable.getContentValues(user));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.database.close();
    }
}
