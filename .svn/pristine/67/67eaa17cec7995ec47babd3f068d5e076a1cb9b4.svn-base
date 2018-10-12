package com.ibis.ibisecp2.retrofit;

import com.ibis.ibisecp2.model.RecipeResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by danila on 23.12.15.
 */
public interface MedvedApi {
    @GET("search")
    Observable<RecipeResponse> getRecipe(@Query("snils") String snils);
}
