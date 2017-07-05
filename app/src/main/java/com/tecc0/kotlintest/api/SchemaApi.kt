package com.tecc0.kotlintest.api

import com.tecc0.kotlintest.model.SchemaResponse
import retrofit2.http.GET
import rx.Observable


interface SchemaApi {

    @GET("/api/v2/schema")
    fun index(): Observable<SchemaResponse>

}