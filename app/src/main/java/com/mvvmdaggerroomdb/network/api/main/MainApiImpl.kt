package com.mvvmdaggerroomdb.network.api.main

import com.mvvmdaggerroomdb.model.CountryResponseModel
import io.reactivex.Single
import javax.inject.Inject

/**
 * This interface will contain all the methods definitions used to get data from the api and will
 * pass the processed information back to repositories.
 */

class MainApiImpl @Inject constructor(private val mainNetworkAPI: MainNetworkAPI) : MainApi {

    override fun getCountry(): Single<CountryResponseModel> {
        return mainNetworkAPI.getCountry().map { response ->
            // Here we can process the response received from the api before returning it.
            response.body()
        }
    }
}