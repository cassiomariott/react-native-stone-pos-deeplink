package com.stoneposdeeplink

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.ReadableMap
import com.facebook.react.bridge.Promise

import com.stoneposdeeplink.executors.*
import com.facebook.react.bridge.*

class StonePosDeeplinkModule(reactContext: ReactApplicationContext) :
  ReactContextBaseJavaModule(reactContext) {

  override fun getName(): String {
    return NAME
  }

  @ReactMethod
  fun makeTransaction( transactionSetup: ReadableMap, promise: Promise ) {
    try {
      MakeTransaction(reactApplicationContext).executeAction( transactionSetup )
      promise.resolve(true)
    } catch (e: Exception) {
      promise.reject(e)
    }
  }

  @ReactMethod
  fun reprinterTransaction( restOfTransactionReprinter: ReadableMap, promise: Promise ) {
    try {
      ReprinterTransaction(reactApplicationContext).executeAction( restOfTransactionReprinter )
      promise.resolve(true)
    } catch (e: Exception) {
      promise.reject(e)
    }
  }

  @ReactMethod
  fun cancelTransaction( restOfTransactionCancel: ReadableMap, promise: Promise ) {
    try {
      CancelTransaction(reactApplicationContext).executeAction( restOfTransactionCancel )
      promise.resolve(true)
    } catch (e: Exception) {
      promise.reject(e)
    }
  } 

  @ReactMethod
  fun printer( restOfPrinter: ReadableMap, promise: Promise ) {
    try {
      Printer(reactApplicationContext).executeAction( restOfPrinter )
      promise.resolve(true)
    } catch (e: Exception) {
      promise.reject(e)
    }
  }

  companion object {
    const val NAME = "StonePosDeeplink"
  }
}
