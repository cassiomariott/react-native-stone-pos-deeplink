package com.stoneposdeeplink.executors

import android.app.Activity

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReadableMap

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import java.lang.Exception

class MakeTransaction(reactApplicationContext: ReactApplicationContext ) {

  val reactApplicationContext = reactApplicationContext

  fun executeAction(
    transactionSetup: ReadableMap
  ) {


    val requiredValues =
      listOf(
        "amountInCents",
        "typeOfTransaction",
        "installmentCount"
      )

    requiredValues.forEach {
      if (!transactionSetup.hasKey(it)) {
        throw Exception(
          String.format("%s is required", it)
        )
      }
    }   
    
    val amount = transactionSetup.getString("amountInCents")
    //val typeOfTransaction = transactionSetup.getString("typeOfTransaction")
    //val installmentCount = transactionSetup.getString("installmentCount")


    val uriBuilder = Uri.Builder()
    uriBuilder.authority("pay")
    uriBuilder.scheme("payment-app")
    uriBuilder.appendQueryParameter("return_scheme", "com.livn.livngo")

    uriBuilder.appendQueryParameter("amount", amount)
    uriBuilder.appendQueryParameter("editable_amount", "0")
    uriBuilder.appendQueryParameter("transaction_type", "CREDIT")
    uriBuilder.appendQueryParameter("installment_type", "MERCHANT")
    uriBuilder.appendQueryParameter("installment_count", "2")
    uriBuilder.appendQueryParameter("order_id", "123")

    val intent = Intent(Intent.ACTION_VIEW)
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    intent.data = uriBuilder.build()

    reactApplicationContext.startActivity(intent)
  }

}
