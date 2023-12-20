package com.stoneposdeeplink.executors

import android.app.Activity

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReadableMap

import android.net.Uri
import android.content.Intent
import java.lang.Exception

class MakeTransaction(reactApplicationContext: ReactApplicationContext ) {

  val reactApplicationContext = reactApplicationContext

  fun executeAction(
    transactionSetup: ReadableMap
  ) {


    val requiredValues =
      listOf(
        "amount",
        "return_scheme",
        "typeOfTransaction"
      )

    requiredValues.forEach {
      if (!transactionSetup.hasKey(it)) {
        throw Exception(
          String.format("%s is required", it)
        )
      }
    }   
    
    val amount = transactionSetup.getString("amount")
    val return_scheme = transactionSetup.getString("return_scheme")
    val amountOfEditable = transactionSetup.getString("amountOfEditable")
    val typeOfTransaction = transactionSetup.getString("typeOfTransaction")

    val uriBuilder = Uri.Builder()
    uriBuilder.authority("pay")
    uriBuilder.scheme("payment-app")
    uriBuilder.appendQueryParameter("return_scheme", return_scheme)

    uriBuilder.appendQueryParameter("amount", amount)
    uriBuilder.appendQueryParameter("editable_amount", amountOfEditable)
    uriBuilder.appendQueryParameter("transaction_type", typeOfTransaction)
    
    val typeOfInstallment = transactionSetup.getString("typeOfInstallment")
    if (typeOfInstallment?.isNotEmpty() == true){
      uriBuilder.appendQueryParameter("installment_type", typeOfInstallment)  
      
        val installmentCount = transactionSetup.getString("installmentCount")
        if (installmentCount?.isNotEmpty() == true){
          uriBuilder.appendQueryParameter("installment_count", installmentCount) 
        } 
    }
    

    val intent = Intent(Intent.ACTION_VIEW)
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    intent.data = uriBuilder.build()

    reactApplicationContext.startActivity(intent)
  }

}
