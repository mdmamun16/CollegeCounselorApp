package com.example.collegecounselor


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.collegecounselor.databinding.FragmentLoginBinding
import com.example.collegecounselor.databinding.FragmentTitleBinding
import com.google.firebase.auth.FirebaseAuth

/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {
lateinit var binding: FragmentTitleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_title, container, false)
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_title,container,false)
        binding.butTitle.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_titleFragment_to_loginFragment)
        }
        return binding.root
    }


}
