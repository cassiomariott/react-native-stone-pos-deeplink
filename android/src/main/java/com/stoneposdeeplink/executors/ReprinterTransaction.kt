package com.stoneposdeeplink.executors

import android.app.Activity

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReadableMap

import android.net.Uri
import android.content.Intent
import java.lang.Exception

class ReprinterTransaction(reactApplicationContext: ReactApplicationContext ) {

  val reactApplicationContext = reactApplicationContext

  fun executeAction(
    restOfTransactionReprinter: ReadableMap
  ) {

    val requiredValues =
      listOf(
        "show_feedback_screen",
        "return_scheme",
        "type_customer",
        "atk"
      )

    requiredValues.forEach {
      if (!restOfTransactionReprinter.hasKey(it)) {
        throw Exception(
          String.format("%s is required", it)
        )
      }
    }   
    
    val show_feedback_screen = restOfTransactionReprinter.getString("show_feedback_screen")
    val type_customer = restOfTransactionReprinter.getString("type_customer")
    val return_scheme = restOfTransactionReprinter.getString("return_scheme")
    val atk = restOfTransactionReprinter.getString("atk")


    val uriBuilder = Uri.Builder()
    uriBuilder.authority("reprint")
    uriBuilder.scheme("reprinter-app")
    uriBuilder.appendQueryParameter("SCHEME_RETURN", return_scheme)

    uriBuilder.appendQueryParameter("SHOW_FEEDBACK_SCREEN", show_feedback_screen)
    uriBuilder.appendQueryParameter("TYPE_CUSTOMER", type_customer)
    uriBuilder.appendQueryParameter("ATK", atk)

    val intent = Intent(Intent.ACTION_VIEW)
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    intent.data = uriBuilder.build()

    reactApplicationContext.startActivity(intent)
  }

}
