package com.example.test_sportpro.ui.fragments.auth

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.test_sportpro.R
import com.example.test_sportpro.api.RetrofitInstance
import com.example.test_sportpro.models.DefaultResponse
import com.example.test_sportpro.models.Region
import com.example.test_sportpro.models.Role
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.fragment_register.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegisterFragment : Fragment() {

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


        val regionArray = resources.getStringArray(R.array.arrayOfRegion)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdow_item, regionArray)
        view.autoCompleteTextView.setAdapter(arrayAdapter)

        val sportArray = resources.getStringArray(R.array.arrayOfSport)
        val arrayAdapter2 = ArrayAdapter(requireContext(), R.layout.dropdow_item, sportArray)
        view.autoCompleteSport.setAdapter(arrayAdapter2)

        view.bt_register.setOnClickListener {

            val name = editTextName.text.toString().trim()
            val lastName = editTextLastName.text.toString().trim()
            val middlename = editTextMiddleName.text.toString().trim()
            val phone = editTextPhone.text.toString().trim()
            val number = autoCompleteTextView.text.toString().trim()
            val organization = editTextOrganization.text.toString().trim()
            val sport = autoCompleteSport.text.toString().trim()
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
//            if (region.isEmpty()) {
//                autoCompleteTextView.error = "это поле обязательное"
//                autoCompleteTextView.requestFocus()
//                return@setOnClickListener
//            }

            if (organization.isEmpty()) {
                editTextOrganization.error = "это поле обязательное"
                editTextOrganization.requestFocus()
                return@setOnClickListener
            }
//            if (sport.isEmpty()) {
//                autoCompleteSport.error = "это поле обязательное"
//                autoCompleteSport.requestFocus()
//                return@setOnClickListener
//            }
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


            val result = when (number) {
                "Чуйская область" -> 1
                "Ошская область" -> 2
                "Баткенская область" -> 3
                "Джал - Абадская область" -> 4
                "Талаская область" -> 5
                "Нарынская область" -> 6
                "Ысыкульская область" -> 7
                else -> 8
            }

            val sport1 = when (sport) {
                "Дзюдо" -> 1
                "Көк бөрү" -> 2
                "Борьба" -> 3
                "Айкидо" -> 4
                else -> 5
            }

            RetrofitInstance.api.createUser(
                name,
                lastName,
                middlename,
                phone,
                Role(id = 2, name = "Тренер"),
                Region(id = 1, name = "Чуйская область"),
                organization,
                sport1,
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

}
