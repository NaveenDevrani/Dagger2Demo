package com.mvvmdaggerroomdb.network.api.main

import com.mvvmdaggerroomdb.model.CountryResponseModel
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

/**
 * This interface will contain all the API emd-point methods used to process the 'Main' screens related data.
 */

interface MainNetworkAPI {

    @GET("countries")
    fun getCountry(): Single<Response<CountryResponseModel>>
}