package com.stoneposdeeplink.executors

import android.app.Activity

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReadableMap

import android.net.Uri
import android.content.Intent
import java.lang.Exception

class CancelTransaction(reactApplicationContext: ReactApplicationContext ) {

  val reactApplicationContext = reactApplicationContext

  fun executeAction(
    restOfTransactionCancel: ReadableMap
  ) {


    val requiredValues =
      listOf(
        "atk",
        "amount",
        "return_scheme",
        "editable_amount"
      )

    requiredValues.forEach {
      if (!restOfTransactionCancel.hasKey(it)) {
        throw Exception(
          String.format("%s is required", it)
        )
      }
    }   
    
    val atk = restOfTransactionCancel.getString("atk")
    val amount = restOfTransactionCancel.getString("amount")
    val return_scheme = restOfTransactionCancel.getString("return_scheme")
    val editable_amount = restOfTransactionCancel.getString("editable_amount")


    val uriBuilder = Uri.Builder()
    uriBuilder.authority("cancel")
    uriBuilder.scheme("cancel-app")
    uriBuilder.appendQueryParameter("returnscheme", return_scheme)

    uriBuilder.appendQueryParameter("atk", atk)
    uriBuilder.appendQueryParameter("amount", amount)
    uriBuilder.appendQueryParameter("editable_amount", editable_amount)

    val intent = Intent(Intent.ACTION_VIEW)
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    intent.data = uriBuilder.build()

    reactApplicationContext.startActivity(intent)
  }

}
