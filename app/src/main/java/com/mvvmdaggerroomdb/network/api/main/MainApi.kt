package com.mvvmdaggerroomdb.network.api.main

import com.mvvmdaggerroomdb.model.CountryResponseModel
import io.reactivex.Single

/**

 * This interface will contain all the methods declaration used to get data from the api and will
 * pass the information back to repositories.
 */

interface MainApi {
    fun getCountry(): Single<CountryResponseModel>
}