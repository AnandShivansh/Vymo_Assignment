package com.example.vymoassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class List_Activity extends AppCompatActivity {
    private ListView ls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_);
        ls = findViewById(R.id.ls);
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit=builder.build();
        github_client client=retrofit.create(github_client.class);
        String owner = getIntent().getStringExtra("owner_text");
        String repo = getIntent().getStringExtra("repo_text");
        Call<List<git_class>> call=client.pulls_for_repo(owner,repo);
        call.enqueue(new Callback<List<git_class>>() {
            @Override
            public void onResponse(Call<List<git_class>> call, Response<List<git_class>> response) {
                List<git_class> res=response.body();
                if(res!=null) {
                    ls.setAdapter(new git_adapter(List_Activity.this, -1, res));
                }else
                {
                    Toast.makeText(List_Activity.this,"Invalid Repo Name or Owner Name",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<git_class>> call, Throwable t) {
                Toast.makeText(List_Activity.this, "Connection Failed", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
