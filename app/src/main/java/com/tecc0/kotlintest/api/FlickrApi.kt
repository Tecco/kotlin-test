package com.tecc0.kotlintest.api

import com.tecc0.kotlintest.model.Flickr
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface FlickrApi {

    @GET("/services/rest/")
    fun index(@Query("api_key") apiKey: String,
                  @Query("method") method: String,
                  @Query("tags") tags: String,
                  @Query("tag_mode") tagMode: String,
                  @Query("format") format: String,
                  @Query("nojsoncallback") num: Int,
                  @Query("per_page") perPage: Int,
                  @Query("page") page: Int): Observable<Flickr>
}