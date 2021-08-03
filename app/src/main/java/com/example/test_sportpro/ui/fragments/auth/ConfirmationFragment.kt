package com.example.test_sportpro.ui.fragments.auth

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.test_sportpro.R
import com.example.test_sportpro.api.RetrofitInstance
import com.example.test_sportpro.databinding.FragmentConfirmationBinding
import com.example.test_sportpro.models.LoginRequest
import com.example.test_sportpro.models.LoginResponse
import com.example.test_sportpro.models.UserPhone
import com.example.test_sportpro.ui.SportViewModel
import com.example.test_sportpro.ui.activities.MainActivity
import com.example.test_sportpro.utils.Resource
import com.example.test_sportpro.utils.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ConfirmationFragment : Fragment(R.layout.fragment_confirmation) {

    private var fragmentConfirmationBinding: FragmentConfirmationBinding? = null

    private val args : ConfirmationFragmentArgs by navArgs()

    lateinit var viewModel: SportViewModel

    private val TAG = "ConfirmationrFragment"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentConfirmationBinding = FragmentConfirmationBinding.bind(view)

        viewModel = (activity as MainActivity).viewModel
        viewModel.getTrainers()

        var number = args.number

        viewModel.trainers.observe(viewLifecycleOwner, { response ->
            when (response) {
                is Resource.Success -> {
                    response.message?.let { Log.d("TAG_SUCCESS", it) }

                    response.data?.let { user ->
                        for (i in user.results) {
                            if (i.is_approved && i.user.phone == number) {
                                val sessionManager = SessionManager(requireContext())

                                RetrofitInstance.api.login(LoginRequest(user = UserPhone(number)))
                                    .enqueue(object : Callback<LoginResponse> {
                                        override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                                            // Error logging in
                                        }

                                        override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                                            val loginResponse = response.body()

                                            if (loginResponse != null) {
                                                sessionManager.saveAuthToken(loginResponse.user.token)
                                                sessionManager.saveStatus("1")
                                            }
                                        }
                                    })

                                val bundle = Bundle().apply {
                                    putSerializable("user", i.user)
                                }
                                findNavController().navigate(R.id.action_confirmationFragment_to_mainProfileFragment, bundle)
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
    }


}