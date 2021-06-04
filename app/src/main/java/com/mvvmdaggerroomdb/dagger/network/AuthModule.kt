package com.mvvmdaggerroomdb.dagger.network

import com.google.gson.Gson
import com.mvvmdaggerroomdb.network.JSONArrayAdapter
import com.mvvmdaggerroomdb.network.JSONObjectAdapter
import com.mvvmdaggerroomdb.network.api.auth.AuthNetworkAPI
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * This class is dagger module and is used to get Reference of the 'Auth' screens related network
 * call apis interface.
 */

@Module
class AuthModule {

    @Provides
    @Singleton
    fun provideAuthNetworkAPI(client: OkHttpClient, gson: Gson): AuthNetworkAPI {
        val updatedGson = gson.newBuilder().setLenient()
            .registerTypeAdapter(JSONObject::class.java, JSONObjectAdapter.sInstance)
            .registerTypeAdapter(JSONArray::class.java, JSONArrayAdapter.sInstance)
            .create()

        return Retrofit.Builder()
            .baseUrl("https://api.printful.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(updatedGson))
            .build().create(AuthNetworkAPI::class.java)
    }
}