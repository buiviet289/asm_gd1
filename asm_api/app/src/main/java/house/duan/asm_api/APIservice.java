package house.duan.asm_api;



import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIservice {
      String DOMAIN = "http://192.168.36.102:3000/";

      @GET("/api/list")
      Call<List<carmodel>> getCars();
}
