package com.example.collegecounselor


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.collegecounselor.databinding.FragmentUnlockBinding

/**
 * A simple [Fragment] subclass.
 */
class UnlockFragment : Fragment() {

    lateinit var binding: FragmentUnlockBinding
    var unlockscore1 = 1
    var unlockscore2 = 2
    var unlockscore3 = 3
    var unlockscore4 = 4


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_unlock, container, false)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_unlock, container, false)

        binding.levelButton1.setOnClickListener {
            val work = UnlockFragmentDirections.actionUnlockFragmentToQuizFragment(unlockscore1)
            view!!.findNavController().navigate(work)
        }

        binding.levelButton2.setOnClickListener {
            val work = UnlockFragmentDirections.actionUnlockFragmentToQuizFragment(unlockscore2)
            view!!.findNavController().navigate(work)
        }

        binding.levelButton3.setOnClickListener {
            val work = UnlockFragmentDirections.actionUnlockFragmentToQuizFragment(unlockscore3)
            view!!.findNavController().navigate(work)
        }
        binding.levelButton4.setOnClickListener {
            val work = UnlockFragmentDirections.actionUnlockFragmentToQuizFragment(unlockscore4)
            view!!.findNavController().navigate(work)
        }

        return binding.root
    }


}



