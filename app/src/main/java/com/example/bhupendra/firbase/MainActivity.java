package com.example.bhupendra.firbase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText editName;
    Button btnSave;
    Spinner sp;
    DatabaseReference databaseplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseplayer= FirebaseDatabase.getInstance().getReference("Player");
        editName=findViewById(R.id.ed);
        sp=findViewById(R.id.sp);
        btnSave=findViewById(R.id.button);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPlayers();
            }
        });

    }

    public void  addPlayers(){
        String name=editName.getText().toString().trim();
        String game=sp.getSelectedItem().toString();

        if(!TextUtils.isEmpty(name)){

            String id = databaseplayer.push().getKey();
            Player player = new Player(id, name, game);
            databaseplayer.child(id).setValue(player);
            Toast.makeText(getApplicationContext(),"Player Successfully Added",Toast.LENGTH_LONG).show();

        }
        else
        {
            Toast.makeText(getApplicationContext(),"Enter Your Player",Toast.LENGTH_LONG).show();
        }


    }
}
