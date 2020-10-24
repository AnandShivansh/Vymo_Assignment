package com.example.vymoassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText owner_name,repo_name;
    Button submit_button;
    String owner_text,repo_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        owner_name=findViewById(R.id.ownerid);
        repo_name=findViewById(R.id.repoid);
        submit_button=findViewById(R.id.submitbtn);
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                owner_text=owner_name.getText().toString();
                repo_text=repo_name.getText().toString();
                Intent i=new Intent(MainActivity.this,List_Activity.class);
                i.putExtra("owner_text",owner_text);
                i.putExtra("repo_text", repo_text);
                startActivity(i);
            }
        });
    }
}