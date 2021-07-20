package com.example.test_sportpro

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.test_sportpro.api.RetrofitInstance
import com.example.test_sportpro.models.DefaultResponse
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.fragment_register.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegisterFragment : Fragment(){
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.bt_register)

        view.bt_register.setOnClickListener {

            val name = editTextName.text.toString().trim()
            val lastName = editTextLastName.text.toString().trim()
            val middlename = editTextMiddleName.text.toString().trim()
            val phone = editTextPhone.text.toString().trim()
            val region = editTextRegion.text.toString().trim()
            val organization = editTextOrganization.text.toString().trim()
            val sport = editTextSport.text.toString().trim()
            val password = editTextPassword.text.toString().trim()
            val document = editTextDocument.text.toString().trim()



            if (name.isEmpty()) {
                editTextName.error = "это поле обязательное"
                editTextName.requestFocus()
                return@setOnClickListener
            }

            if (lastName.isEmpty()) {
                editTextLastName.error = "это поле обязательное"
                editTextLastName.requestFocus()
                return@setOnClickListener
            }
            if (middlename.isEmpty()) {
                editTextMiddleName.error = "это поле обязательное"
                editTextMiddleName.requestFocus()
                return@setOnClickListener
            }
            if (phone.isEmpty()) {
                editTextPhone.error = "это поле обязательное"
                editTextPhone.requestFocus()
                return@setOnClickListener
            }
            if (region.isEmpty()) {
                editTextRegion.error = "это поле обязательное"
                editTextRegion.requestFocus()
                return@setOnClickListener
            }

            if (organization.isEmpty()) {
                editTextOrganization.error = "это поле обязательное"
                editTextOrganization.requestFocus()
                return@setOnClickListener
            }
            if (sport.isEmpty()) {
                editTextSport.error = "это поле обязательное"
                editTextSport.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                editTextPassword.error = "это поле обязательное"
                editTextPassword.requestFocus()
                return@setOnClickListener
            }
            if (document.isEmpty()) {
                editTextDocument.error = "это поле обязательное"
                editTextDocument.requestFocus()
                return@setOnClickListener
            }


            RetrofitInstance.api.createUser(
                name,
                lastName,
                middlename,
                phone,
                region.toInt(),
                organization,
                sport.toInt(),
                password,
                document
            ).enqueue(object : Callback<DefaultResponse> {
                override fun onResponse(
                    call: Call<DefaultResponse>,
                    response: Response<DefaultResponse>
                ) {
                    if (response.isSuccessful) {
                        Log.d("TAG_SUCCESS" + response.body(), response.message())
                        Log.d("TAG_SUCCESS", response.message())
                        navController.navigate(R.id.action_registerFragment_to_mainProfileFragment)

                    } else {
                        Log.d("TAG_ERROR_MESSAGE", response.message())
                        Log.d("TAG_ERROR_BODY", response.body().toString())
                        Log.d("TAG_ERROR_ERRORBODY", response.errorBody().toString())
                        Log.d("TAG_ERROR_CODE", response.code().toString())
                        response.body()?.let { it1 -> Log.d("TAG_ERROR_CODE", it1.name) }


                    }

                    Toast.makeText(activity, response.message(), Toast.LENGTH_LONG).show()

                }

                override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {
                    Toast.makeText(activity, t.message, Toast.LENGTH_LONG).show()
                    Log.d("tag_failure", t.message.toString())
                }
            })
        }


    }

//    override fun onClick(v: View?) {
//        when (v!!.id) {
////            R.id.bt_register -> navController.navigate(R.id.action_registerFragment_to_confirmationFragment)
//
//        }
//    }


}