package com.mvvmdaggerroomdb.dagger.network

import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.mvvmdaggerroomdb.network.JSONArrayAdapter
import com.mvvmdaggerroomdb.network.JSONObjectAdapter
import com.mvvmdaggerroomdb.network.api.main.MainNetworkAPI
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * This class is dagger module and is used to get Reference of the 'Main' screens related network
 * call apis interface.
 */

@Module
class MainModule {

    @Provides
    @Singleton
    fun provideMainNetworkAPI(client: OkHttpClient, gson: Gson): MainNetworkAPI {
        val updatedGson = gson.newBuilder().setLenient()
            .registerTypeAdapter(JSONObject::class.java, JSONObjectAdapter.sInstance)
            .registerTypeAdapter(JSONArray::class.java, JSONArrayAdapter.sInstance)
            .create()

        return Retrofit.Builder()
            .baseUrl("http://api.printful.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(updatedGson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(MainNetworkAPI::class.java)
    }
}