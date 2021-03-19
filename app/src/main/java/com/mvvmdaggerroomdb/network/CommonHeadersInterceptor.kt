package com.mvvmdaggerroomdb.network

import com.dagger2demo.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

/**
 * This class contains code which will add all the common headers which needs to be sent in every
 * api call. Adds common headers like x-platform-code, x-version-code etc to the request.
 */

class CommonHeadersInterceptor @Inject constructor() : Interceptor {

    companion object {
        const val X_PLATFORM_CODE = "x-platform-code"
        const val X_VERSION_CODE = "x-version-code"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        requestBuilder.addHeader(X_PLATFORM_CODE, "an")
        requestBuilder.addHeader(X_VERSION_CODE, BuildConfig.VERSION_CODE.toString())
        return chain.proceed(requestBuilder.build())
    }
}