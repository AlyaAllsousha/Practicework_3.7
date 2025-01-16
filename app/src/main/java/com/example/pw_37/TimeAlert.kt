package com.example.pw_37

import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment

class TimeAlert:DialogFragment() {
    interface IonCalendarClick{
        fun onCalClick(hour: Int, min: Int)
    }
    var listener:IonCalendarClick? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as IonCalendarClick
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val curHour = c.get(Calendar.HOUR_OF_DAY)
        val curMin = c.get(Calendar.MINUTE)
        return TimePickerDialog(activity, {first, hour, minute ->
            listener!!.onCalClick(hour, minute)
        }, curHour, curMin, false)
    }

}