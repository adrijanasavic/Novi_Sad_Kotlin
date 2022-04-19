package com.example.mycitynovisad.dialog

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog

class AboutDialog(context: Context?) : AlertDialog.Builder(context!!) {
    override fun show(): AlertDialog? {
        TODO("Not yet implemented")
    }

    init {
        setTitle("About App")
        setMessage("App name: Novi Sad\nAuthor: Adrijana Savic\nadrijana.work@gmail.com")
        setPositiveButton("OK") { dialog: DialogInterface, _: Int -> dialog.dismiss() }
        setNegativeButton("Cancel") { dialog: DialogInterface, _: Int -> dialog.dismiss() }
    }
}