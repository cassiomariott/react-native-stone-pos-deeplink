package com.stoneposdeeplink.executors

import android.app.Activity

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReadableMap

import android.net.Uri
import android.content.Intent
import java.lang.Exception

class Printer(reactApplicationContext: ReactApplicationContext ) {

  val reactApplicationContext = reactApplicationContext

  fun executeAction(
    restOfPrinter: ReadableMap
  ) { 
    
    val requiredValues =
      listOf(
        "show_feedback_screen",
        "return_scheme",
        "json"
      )

    requiredValues.forEach {
      if (!restOfPrinter.hasKey(it)) {
        throw Exception(
          String.format("%s is required", it)
        )
      }
    } 
    
    val json = restOfPrinter.getString("json")
    val return_scheme = restOfPrinter.getString("return_scheme")
    val show_feedback_screen = restOfPrinter.getString("show_feedback_screen")

    val uriBuilder = Uri.Builder()
    uriBuilder.authority("print")
    uriBuilder.scheme("printer-app")
    uriBuilder.appendQueryParameter("SCHEME_RETURN", return_scheme)

    uriBuilder.appendQueryParameter("PRINTABLE_CONTENT", json)
    uriBuilder.appendQueryParameter("SHOW_FEEDBACK_SCREEN", show_feedback_screen)

    val intent = Intent(Intent.ACTION_VIEW)
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    intent.data = uriBuilder.build()

    reactApplicationContext.startActivity(intent)
  }

}
