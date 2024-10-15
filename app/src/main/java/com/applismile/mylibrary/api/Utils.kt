package com.applismile.mylibrary.api

import android.app.AlertDialog
import android.content.Context
import com.applismile.mylibrary.R
import com.applismile.mylibrary.data.Constants.API_FAILED_CODE
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import kotlin.reflect.KMutableProperty

inline fun <reified T> toResultFlow(crossinline call: suspend () -> Response<T>?): Flow<NetWorkResult<T>> {
    return flow {

        emit(NetWorkResult.Loading(true))
        val c = call()
        c?.let { response ->
            try {
                if (c.isSuccessful && c.body() != null) {
                    c.body()?.let {
                        emit(NetWorkResult.Success(it))
                    }
                } else {
                    val model = setResponseStatus<T>(
                        T::class.java.getDeclaredConstructor().newInstance(),
                        response.code().toString(),
                        response.message()
                    )
                    emit(NetWorkResult.Error(model, response.message()))
                }
            } catch (e: Exception) {
                val model = setResponseStatus<T>(
                    T::class.java.getDeclaredConstructor().newInstance(),
                    API_FAILED_CODE,
                    e.message
                )
                emit(NetWorkResult.Error(model, e.toString()))
            }
        }

    }.flowOn(Dispatchers.IO)
}

inline fun <reified T> setResponseStatus(instance: T?, errorCode: String?, message: String?): T? {
    return try {
        instance?.let {
            val properties = it::class.members
            for (property in properties) {
                if (property is KMutableProperty<*>) {
                    when (property.name) {
                        "ErrorCode" -> property.setter.call(instance, errorCode)
                        "Message" -> property.setter.call(instance, message)
                    }
                }
            }
        }
        instance
    } catch (e: Exception) {
        null
    }
}


fun showAlertDialog(context: Context, message: String) {
    try {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(R.string.app_name)
        builder.setMessage(message)
        builder.setIcon(android.R.drawable.ic_dialog_alert)
        builder.setPositiveButton("OK") { dialogInterface, which ->
            dialogInterface.dismiss()
        }
        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    } catch (e: Exception) {
        e.stackTrace
    }
}