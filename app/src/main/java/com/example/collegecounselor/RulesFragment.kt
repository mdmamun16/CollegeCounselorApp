package com.example.collegecounselor


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.collegecounselor.databinding.FragmentQuizBinding
import com.example.collegecounselor.databinding.FragmentRulesBinding

/**
 * A simple [Fragment] subclass.
 */
class RulesFragment : Fragment() {
    lateinit var binding: FragmentRulesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_rules, container, false)
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_rules,container,false)
        binding.rulesBut.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_rulesFragment_to_quizFragment)
        }
        return binding.root
    }


}
