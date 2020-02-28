package com.example.collegecounselor


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.collegecounselor.databinding.FragmentWonBinding

/**
 * A simple [Fragment] subclass.
 */
class WonFragment : Fragment() {
    lateinit var binding:FragmentWonBinding
    var score = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_won, container, false)
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_won,container,false)
        binding.playAgain.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_wonFragment_to_unlockFragment)
        }

        return binding.root
    }
}
