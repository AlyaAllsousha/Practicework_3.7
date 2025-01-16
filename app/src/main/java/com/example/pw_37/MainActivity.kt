package com.example.pw_37

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.example.pw_37.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), FlagAlert.OnButtonClick, TimeAlert.IonCalendarClick {
    var sun:Boolean = true
    var moonstar:Boolean = false
    var dayTime:Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMainBinding =  DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)
        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction().add(R.id.Fr1, Landscape()).commit()
        }
        binding.root.setOnClickListener {
            FlagAlert().show(supportFragmentManager, "YesNoCancelDialog")
        }

    }


    override fun onDialogClickListener(sunDialog: Boolean, moonstarDialog: Boolean) {
        sun = sunDialog
        moonstar  =moonstarDialog
        TimeAlert().show(supportFragmentManager, "TimeAlert")
    }

    override fun onCalClick(hour: Int, min: Int) {
        dayTime = if(hour >= 5 && hour <= 15) true else false
        Log.d("dayTime", "$dayTime, $hour")
        supportFragmentManager.beginTransaction().replace(R.id.Fr1, Landscape.newInstance(sun, moonstar, dayTime)).commit()
    }
}
