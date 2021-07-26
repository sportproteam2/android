package com.example.test_sportpro.ui.fragments.auth

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.fragment.navArgs
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.test_sportpro.R
import com.example.test_sportpro.ui.SportViewModel
import com.example.test_sportpro.ui.activities.MainActivity
import com.example.test_sportpro.utils.Resource
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.fragment_number.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit


class NumberFragment : Fragment(), View.OnClickListener {


    val args: NumberFragmentArgs by navArgs()

    lateinit var navController: NavController

    lateinit var viewModel: SportViewModel

    private val TAG = "NumberFragment"

    lateinit var auth: FirebaseAuth
    lateinit var storedVerificationId: String
    lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_number, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.buttonNum).setOnClickListener(this)


        Toast.makeText(activity, args.status, Toast.LENGTH_LONG).show()
        viewModel = (activity as MainActivity).viewModel

        MainScope().launch { viewModel.getUsers() }

        auth = FirebaseAuth.getInstance()

        val Login = view.findViewById<Button>(R.id.buttonNum)


        var currentUser = auth.currentUser

        if (currentUser != null) {
//            navController.navigate(
//                    R.id.action_numberFragment_to_codeFragment,
//
//                    )
//            startActivity(Intent(view.applicationContext, Home::class.java))
//            finish()
        }

        Login.setOnClickListener {
            login()

        }


        // Callback function for Phone Auth
        callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            override fun onVerificationCompleted(credential: PhoneAuthCredential) {

                navController.navigate(
                    R.id.action_codeFragment_to_registerFragment,
                )
            }

            override fun onVerificationFailed(e: FirebaseException) {
                Log.d("TAG", "$e")
                Toast.makeText(activity, "Failed", Toast.LENGTH_LONG).show()
            }

            override fun onCodeSent(
                verificationId: String,
                token: PhoneAuthProvider.ForceResendingToken
            ) {

                Log.d("TAG", "onCodeSent:$verificationId")
                storedVerificationId = verificationId
                val numberForTextView = editTextPersonalNumber.unMasked
                resendToken = token

                val action =
                    NumberFragmentDirections.actionNumberFragmentToCodeFragment(
                        storedVerificationId,
                        numberForTextView,
                        args.status
                    )
                NumberFragmentDirections.actionNumberFragmentToCodeFragment(
                    storedVerificationId, numberForTextView
                )
                Navigation.findNavController(view).navigate(action)

            }
        }
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.buttonNum -> {
                if (!TextUtils.isEmpty(editTextPersonalNumber.unMasked.toString())) {
                    val myNumber = editTextPersonalNumber.unMasked.toString()
                    Log.d("TAG_number", myNumber.toString())


                    val action =
                        NumberFragmentDirections.actionNumberFragmentToCodeFragment(myNumber)
                    Navigation.findNavController(v).navigate(action)


                } else {
                    Toast.makeText(activity, "Enter the phone number", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun login() {

        var mobileNumber = editTextPersonalNumber.unMasked
        var number = mobileNumber.trim()
        Log.d("number", number)

        if (number.isNotEmpty()) {
            number = "+996$number"

            viewModel.users.observe(viewLifecycleOwner, { response ->
                when (response) {
                    is Resource.Success -> {
                        response.message?.let { Log.d("TAG_SUCCESS", it) }
                        response.data?.let { user ->
                            user.forEach {
                                if (it.phone == number) {
                                    sendVerificationcode(number)
                                    Log.d("number2", number)
                                }
                            }
                        }
                    }
                    is Resource.Error -> {
                        response.message?.let { message ->
                            Log.d(TAG, "An error occured: $message")
                        }
                    }
                    is Resource.Loading -> {
                        response.message?.let { message ->
                            Log.d(TAG, "An error occured: $message")
                        }
                    }
                }
            })


        } else {
            Toast.makeText(activity, "Enter mobile number", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }

    private fun sendVerificationcode(number: String) {
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(number) // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(this.requireActivity())
            .setCallbacks(callbacks) // OnVerificationStateChangedCallbacks
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }
}