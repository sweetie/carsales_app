package com.carsales.project.mvp.model.netwotk;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Enny Querales
 */
public interface RestAPIService {

    @GET("chileautos/v1/stock/listing")
    Call<ResponseBody> getAutos();
}
