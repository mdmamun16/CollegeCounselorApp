package com.example.collegecounselor


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.collegecounselor.databinding.FragmentLossBinding
import com.firebase.ui.auth.AuthUI

/**
 * A simple [Fragment] subclass.
 */
class LossFragment : Fragment() {
    lateinit var binding:FragmentLossBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_loss, container, false)
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_loss,container,false)
        binding.LogoutBut.setOnClickListener {
            AuthUI.getInstance().signOut(activity?.applicationContext!!)

                .addOnSuccessListener {
                    Navigation.findNavController(view!!).navigate(R.id.action_lossFragment_to_loginFragment)
                    Toast.makeText(activity,"Logged Out", Toast.LENGTH_SHORT)
                }
        }
        binding.playAgain.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_lossFragment_to_loginFragment)
        }

        return binding.root
    }
}
