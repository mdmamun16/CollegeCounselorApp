package com.example.collegecounselor


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.collegecounselor.databinding.FragmentSettingBinding

/**
 * A simple [Fragment] subclass.
 */
class SettingFragment : Fragment() {

    lateinit var binding:FragmentSettingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_setting, container, false)

        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_setting,container,false)
        return binding.root
    }


}
