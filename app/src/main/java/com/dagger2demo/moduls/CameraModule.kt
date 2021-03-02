//package com.dagger2demo.moduls
//
//import com.dagger2demo.classess.Camera
//import dagger.Module
//import dagger.Provides
//import javax.inject.Named
//
//@Module
//abstract class CameraModule() {
//    @JvmStatic
//    @Provides
//    fun getCameras(@Named("megaPixel") megaPixel: Int): Camera {
//        return Camera(megaPixel)
//    }
//
//
////    @Provides
////    fun getMegabyte(): Int {
////        return megabtye
////    }
//
//}