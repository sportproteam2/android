package com.example.test_sportpro

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.fragment_number.*
import java.util.concurrent.TimeUnit


class NumberFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    lateinit var auth: FirebaseAuth
    lateinit var storedVerificationId: String
    lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks


    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
//        recipient = requireArguments().getString("recipient").toString()
    }

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
//                startActivity(Intent(applicationContext, PersonalDataActivity::class.java))
//                finish()

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
                resendToken = token


//                val myNumber = editTextPersonalNumber.text.toString()


                val action =
                    NumberFragmentDirections.actionNumberFragmentToCodeFragment(storedVerificationId)
                Navigation.findNavController(view).navigate(action)

//                var intent = Intent(applicationContext, Verify::class.java)
//                intent.putExtra("storedVerificationId", storedVerificationId)
//                startActivity(intent)

//                val bundle = bundleOf("recipient" to storedVerificationId)
//                Log.d("TAG", "bundle$bundle")
//
//                navController.navigate(
//                        R.id.action_numberFragment_to_codeFragment,
//                        bundle
//                )
            }
        }


    }
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.buttonNum -> {
                if (!TextUtils.isEmpty(editTextPersonalNumber.text.toString())) {

//                    val bundle = bundleOf("recipient" to editTextPersonalNumber)
//
//                    navController.navigate(
//                            R.id.action_numberFragment_to_codeFragment,
//                            bundle
//                    )

                    val myNumber = editTextPersonalNumber.text.toString()



                    val action = NumberFragmentDirections.actionNumberFragmentToCodeFragment(myNumber)
                    Navigation.findNavController(v).navigate(action)


                } else {
                    Toast.makeText(activity, "Enter a name", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun login() {
        val mobileNumber = view?.findViewById<EditText>(R.id.editTextPersonalNumber)
        var number = mobileNumber?.text.toString().trim()

        if (!number.isEmpty()) {
            number = "+996" + number
            sendVerificationcode(number)
//            uploadImageToFirebaseStorage()
            // load image to firebase
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