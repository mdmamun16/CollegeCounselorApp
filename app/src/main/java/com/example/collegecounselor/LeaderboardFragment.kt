package com.example.collegecounselor


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.collegecounselor.databinding.FragmentLeaderboardBinding

/**
 * A simple [Fragment] subclass.
 */
class LeaderboardFragment : Fragment() {
    lateinit var binding: FragmentLeaderboardBinding
    lateinit var sharedPreferences: SharedPreferences
    var score:String = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_leaderboard, container, false)
        sharedPreferences = activity!!.getSharedPreferences("SP_GAME", Context.MODE_PRIVATE)

        binding.leader=this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var score = sharedPreferences.getString("TEXT_SCORE", "")
    }
}
