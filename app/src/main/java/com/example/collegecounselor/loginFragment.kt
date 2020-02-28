package com.example.collegecounselor


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.collegecounselor.databinding.FragmentLoginBinding
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth

/**
 * A simple [Fragment] subclass.
 */
class loginFragment : Fragment() {
    lateinit var binding:FragmentLoginBinding
    val user = FirebaseAuth.getInstance().currentUser
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_login, container, false)
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false)
        binding.leaderbordButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_leaderboardFragment)
        }

        binding.playButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_unlockFragment)
        }
        binding.settingBut.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_settingFragment)
        }


        binding.logoutLogin.setOnClickListener {
            AuthUI.getInstance().signOut(activity?.applicationContext!!)

                .addOnSuccessListener {
                    Navigation.findNavController(view!!).navigate(R.id.action_loginFragment_to_logFirstFragment)
                    Toast.makeText(activity,"Logged Out", Toast.LENGTH_SHORT)
                }
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if(user==null){
            Navigation.findNavController(view!!).navigate(R.id.action_loginFragment_to_logFirstFragment)
        }
    }

}
