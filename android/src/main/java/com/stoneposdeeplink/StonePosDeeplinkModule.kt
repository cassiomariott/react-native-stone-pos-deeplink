package com.stoneposdeeplink

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Promise

import com.stoneposdeeplink.executors.*

class StonePosDeeplinkModule(reactContext: ReactApplicationContext) :
  ReactContextBaseJavaModule(reactContext) {

  override fun getName(): String {
    return NAME
  }

  // Example method
  // See https://reactnative.dev/docs/native-modules-android
  @ReactMethod
  fun multiply(a: Double, b: Double, promise: Promise) {
    promise.resolve(a * b)
  }

  @ReactMethod
  fun makeTransaction(
    transactionSetup: ReadableMap,
    promise: Promise
  ) {
    try {
      MakeTransaction(reactApplicationContext, currentActivity).executeAction(
        transactionSetup,
        promise
      )
    } catch (e: Exception) {
      promise.reject(e)
    }
  }

  companion object {
    const val NAME = "StonePosDeeplink"
  }
}
