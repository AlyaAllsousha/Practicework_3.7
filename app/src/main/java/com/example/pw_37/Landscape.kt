package com.example.pw_37

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.toColorInt
import androidx.databinding.DataBindingUtil
import com.example.pw_37.databinding.FragmentLandscapeBinding


/**
 * A simple [Fragment] subclass.
 * Use the [Landscape.newInstance] factory method to
 * create an instance of this fragment.
 */
class Landscape : Fragment() {
    // TODO: Rename and change types of parameters
    private var sun: Boolean = true
    private var moonStar: Boolean = false
    private var dayTime: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            sun = it.getBoolean("sun")
            moonStar = it.getBoolean("moonStar")
            dayTime = it.getBoolean("dayTime")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:FragmentLandscapeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_landscape, container, false)
        if(dayTime == true) {
            if (sun==true){
                binding.sunMoon.setImageResource(R.drawable.sun)
            }
            else{
                binding.sunMoon.visibility = View.INVISIBLE
            }
            binding.FrLayout.setBackgroundColor("#2196F3".toColorInt())
        }
        else{
            if(moonStar == true){
                binding.sunMoon.setImageResource(R.drawable.moon)
                binding.FrLayout.setBackgroundResource(R.drawable.bg_night)
            }
            else{
                binding.sunMoon.visibility = View.INVISIBLE
                binding.FrLayout.setBackgroundColor("#3F51B5".toColorInt())
            }
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(sun:Boolean, moonStar:Boolean, dayTime: Boolean) =
            Landscape().apply {
                arguments = Bundle().apply {
                    putBoolean("sun", sun)
                    putBoolean("moonStar", moonStar)
                    putBoolean("dayTime", dayTime)
                }
            }
    }
}