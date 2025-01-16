package com.example.pw_37

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment


class FlagAlert:DialogFragment() {
    interface OnButtonClick{
        fun onDialogClickListener(sun:Boolean, moonstar:Boolean)
    }

    var listener: OnButtonClick ? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnButtonClick
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val choose = arrayOf("Звезды и луна", "Солнце")
        val checked = booleanArrayOf(false, false)
        return AlertDialog.Builder(activity)
            .setMultiChoiceItems(choose, checked) { dialog, which, isChecked ->
                checked[which] = isChecked
            }
            .setTitle("Выберете вариант")
            .setPositiveButton("Ok",{dialog, which ->
                listener!!.onDialogClickListener(checked[1], checked[0])
            } )
            .create()
    }

}
