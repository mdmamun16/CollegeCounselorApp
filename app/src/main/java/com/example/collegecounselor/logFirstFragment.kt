package com.example.collegecounselor


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.collegecounselor.databinding.FragmentLogFirstBinding
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse

/**
 * A simple [Fragment] subclass.
 */
class logFirstFragment : Fragment() {
    lateinit var binding: FragmentLogFirstBinding
    companion object{
        private const val RC_SIGN = 111
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_log_first, container, false)
        return binding.root
    }

    private fun createUI(){
        val providers = arrayListOf<AuthUI.IdpConfig>(
            AuthUI.IdpConfig.GoogleBuilder().build(),
            AuthUI.IdpConfig.EmailBuilder().build()
        )

        startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .setLogo(R.drawable.logo)
                .setIsSmartLockEnabled(false)
                .build(), RC_SIGN

        )

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode== RC_SIGN){
            val response = IdpResponse.fromResultIntent(data)
            if(resultCode== Activity.RESULT_OK){
                Navigation.findNavController(view!!).navigate(R.id.action_logFirstFragment_to_loginFragment)
            }
            else{
                if(response==null){
                    activity?.finishAffinity()
                    return
                }
            }
        }

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        createUI()
    }
}
