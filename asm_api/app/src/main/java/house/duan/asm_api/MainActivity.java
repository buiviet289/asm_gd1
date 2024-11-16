package house.duan.asm_api;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
 ListView lvmain;
 List<carmodel> list;
 caradapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lvmain = findViewById(R.id.lvmain);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIservice.DOMAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIservice apiService = retrofit.create(APIservice.class);

        Call<List<carmodel>> call = apiService.getCars();

        call.enqueue(new Callback<List<carmodel>>() {
            @Override
            public void onResponse(Call<List<carmodel>> call, Response<List<carmodel>> response) {
                if (response.isSuccessful()) {
                    list = response.body();

                    adapter = new caradapter(getApplicationContext(), list);

                    lvmain.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<carmodel>> call, Throwable t) {
                Log.e("Main", t.getMessage());

            }
        });


    }
}