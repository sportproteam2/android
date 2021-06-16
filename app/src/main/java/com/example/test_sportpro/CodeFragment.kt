package com.example.test_sportpro

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider


class CodeFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController
    lateinit var auth: FirebaseAuth
    lateinit var recipient: String



    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_code, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recipient = requireArguments().getString("recipient").toString()

        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.buttonCode).setOnClickListener(this)

        auth = FirebaseAuth.getInstance()

//        val storedVerificationId = intent.getStringExtra("storedVerificationId")

        //        Reference
        val verify = view.findViewById<Button>(R.id.buttonCode)
        val otpGiven = view.findViewById<EditText>(R.id.editTextPersonalCode)

//        On click listener for the verify button

        verify.setOnClickListener {
            var otp = otpGiven.text.toString().trim()
            if (!otp.isEmpty()) {
                val credential: PhoneAuthCredential = PhoneAuthProvider.getCredential(
                        recipient.toString(), otp
                )
                signInWithPhoneAuthCredential(credential)
            } else {
                Toast.makeText(activity, "Enter OTP", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.buttonCode -> navController.navigate(R.id.action_codeFragment_to_registerFragment)

        }
    }

    //Do your own basic conditions to check whether the OTP is entered or not. If entered, pass the credentials to the signInWithPhoneAuthCredential method

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        activity?.let {
            auth.signInWithCredential(credential)
                .addOnCompleteListener(it) { task ->
                    if (task.isSuccessful) {

                        navController.navigate(
                                R.id.action_codeFragment_to_registerFragment,
                        )
//                        startActivity(Intent(applicationContext, PersonalDataActivity::class.java))
//                        finish()
// ...
                    } else {
// Sign in failed, display a message and update the UI
                        if (task.exception is FirebaseAuthInvalidCredentialsException) {
// The verification code entered was invalid
                            Toast.makeText(activity, "Invalid OTP", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
        }
    }

    //if (task.isSuccessful) login the user. Intent to home activity else toast the error message


}