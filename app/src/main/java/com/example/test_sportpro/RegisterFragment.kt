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
import com.example.test_sportpro.api.RegPost
import com.example.test_sportpro.api.RetrofitInstance
import com.example.test_sportpro.models.DefaultResponse
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.fragment_register.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegisterFragment : Fragment(), View.OnClickListener {
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
        view.findViewById<Button>(R.id.bt_register).setOnClickListener(this)

        view.bt_register.setOnClickListener {
            val username = editTextUserName.text.toString().trim()
            val name = editTextName.text.toString().trim()
            val lastName = editTextLastName.text.toString().trim()
            val phone = editTextPhone.text.toString().trim()
            val role = editTextRole.text.toString().trim()
            val password = editTextPassword.text.toString().trim()
            val age = editTextAge.text.toString().trim()

//            val middleName = editTextMiddleName.text.toString().trim()
//            val region = editTextRegion.text.toString().trim()
//            val category = editTextCategory.text.toString().trim()
//            val typeOfSport = editTextTypeOfSport.text.toString().trim()
//            val organization = editTextOrganisation.text.toString().trim()

            if (name.isEmpty()) {
                editTextName.error = "Name required"
                editTextName.requestFocus()
                return@setOnClickListener
            }

            if (lastName.isEmpty()) {
                editTextLastName.error = "Name required"
                editTextLastName.requestFocus()
                return@setOnClickListener
            }
//            if (middleName.isEmpty()) {
//                editTextMiddleName.error = "Name required"
//                editTextMiddleName.requestFocus()
//                return@setOnClickListener
//            }
//            if (region.isEmpty()) {
//                editTextCategory.error = "Name required"
//                editTextCategory.requestFocus()
//                return@setOnClickListener
//            }
//            if (category.isEmpty()) {
//                editTextName.error = "Name required"
//                editTextName.requestFocus()
//                return@setOnClickListener
//            }
//
//            if (typeOfSport.isEmpty()) {
//                editTextTypeOfSport.error = "Name required"
//                editTextTypeOfSport.requestFocus()
//                return@setOnClickListener
//            }
//
//            if (organization.isEmpty()) {
//                editTextOrganisation.error = "Name required"
//                editTextOrganisation.requestFocus()
//                return@setOnClickListener
//            }

            Log.d("USERNAME", username)
            Log.d("name", name)
            Log.d("lastname", lastName)
            Log.d("phone", phone)
            Log.d("role", role)
            Log.d("password", password)
            Log.d("age", age)

            RetrofitInstance.api.createUser(
                    username,
                    name,
                    lastName,
                    phone,
                    role.toInt(),
                    password,
                    age.toInt()
                    ).enqueue(object: Callback<DefaultResponse>{
                override fun onResponse(call: Call<DefaultResponse>, response: Response<DefaultResponse>) {
                    if (response.isSuccessful){
                        Log.d("TAG_SUCCESS" + response.body(), response.message())
                    }
                    else{
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

    override fun onClick(v: View?) {
        when (v!!.id) {
//            R.id.bt_register -> navController.navigate(R.id.action_registerFragment_to_confirmationFragment)

        }
    }



}