package com.example.test_sportpro.ui.fragments.judgeProfile

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test_sportpro.R
import com.example.test_sportpro.adapters.CompetitionsAdapter
import com.example.test_sportpro.databinding.FragmentJudgeBinding
import com.example.test_sportpro.models.UserItem
import com.example.test_sportpro.ui.SportViewModel
import com.example.test_sportpro.ui.activities.MainActivity
import com.example.test_sportpro.utils.Resource
import com.example.test_sportpro.utils.SessionManager
import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.android.synthetic.main.layout_dialog.view.*


class JudgeFragment : Fragment(R.layout.fragment_judge) {

    lateinit var viewModel: SportViewModel
    lateinit var competitionAdapter: CompetitionsAdapter

    private var fragmentJudgeBinding: FragmentJudgeBinding? = null

    private val TAG = "JudgeFragment"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentJudgeBinding = FragmentJudgeBinding.bind(view)

        viewModel = (activity as MainActivity).viewModel
        setupRecyclerView()

        viewModel.getEvents()
        viewModel.getAllSport()

        val sessionManager = SessionManager(requireContext())
        val number = sessionManager.fetchPhone()

        if (findNavController().previousBackStackEntry?.arguments?.getSerializable("user") != null) {
            var user = findNavController().previousBackStackEntry?.arguments?.getSerializable("user") as UserItem

            fragmentJudgeBinding!!.name.text = user.surname.plus(" ").plus(user.name).plus(" ").plus(user.middlename)

            viewModel.sport.observe(viewLifecycleOwner, Observer { response ->
                when (response) {
                    is Resource.Success -> {
                        hideProgressBar()
                        response.message?.let { Log.d("TAG_SUCCESS", it) }
                        response.data?.let { sportArray ->
                            sportArray.forEach() { sport ->
                                if (sport.id == user.sport) {
                                    fragmentJudgeBinding!!.sportCategory.text = sport.category.name
                                    fragmentJudgeBinding!!.sportType.text = sport.name
                                    fragmentJudgeBinding!!.competitions.text = "Соревнования по ".plus(sport.name)
                                }
                            }
                        }
                    }
                    is Resource.Error -> {
                        hideProgressBar()
                        response.message?.let { message ->
                            Log.d(TAG, "An error occured: $message")
                        }
                    }
                    is Resource.Loading -> {
                        showProgressBar()
                        response.message?.let { message ->
                            Log.d(TAG, "An error occured: $message")
                        }
                    }
                }
            })
        }

        competitionAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("competition", it)
            }
            findNavController().navigate(
                    R.id.action_judgeFragment_to_chooseCompetitionFragment,
                    bundle
            )
        }

        viewModel.events.observe(viewLifecycleOwner, Observer { response ->

            when (response) {
                is Resource.Success -> {
                    hideProgressBar()
                    response.message?.let { Log.d("TAG_SUCCESS", it) }
                    response.data?.let { competition ->
                        competitionAdapter.differ.submitList(competition)
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let { message ->
                        Log.d(TAG, "An error occured: $message")
                    }
                }
                is Resource.Loading -> {
                    showProgressBar()
                    response.message?.let { message ->
                        Log.d(TAG, "An error occured: $message")
                    }
                }
            }
        })

//        fragmentJudgeBinding!!.dialog.setOnClickListener{
//            //Inflate the dialog with custom view
//            val mDialogView = LayoutInflater.from(requireContext()).inflate(R.layout.layout_dialog, null)
//            //AlertDialogBuilder
//            val mBuilder = AlertDialog.Builder(requireContext())
//                    .setView(mDialogView)
//            //show dialog
//            val  mAlertDialog = mBuilder.show()
//            val layoutParams = WindowManager.LayoutParams()
//            layoutParams.copyFrom(mAlertDialog.window?.attributes)
//            layoutParams.width = 900
//            mAlertDialog.window?.attributes = layoutParams
//            mAlertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//            //login button click of custom layout
//            mDialogView.btn_no.setOnClickListener {
//                //dismiss dialog
//                mAlertDialog.dismiss()
//            }
//            //cancel button click of custom layout
//            mDialogView.btn_yes.setOnClickListener {
//                //dismiss dialog
//                mAlertDialog.dismiss()
//            }
//        }
    }

    private fun setupRecyclerView() {
        competitionAdapter = CompetitionsAdapter()
        fragmentJudgeBinding?.rv?.apply {
            adapter = competitionAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun hideProgressBar() {
        progressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }
}