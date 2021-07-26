package com.example.test_sportpro.ui.fragments.judgeProfile

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test_sportpro.R
import com.example.test_sportpro.adapters.CompetitionsAdapter
import com.example.test_sportpro.databinding.FragmentJudgeBinding
import kotlinx.android.synthetic.main.layout_dialog.view.*


class JudgeFragment : Fragment(R.layout.fragment_judge) {

    lateinit var competitionAdapter: CompetitionsAdapter

    private var fragmentJudgeBinding : FragmentJudgeBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentJudgeBinding = FragmentJudgeBinding.bind(view)

        setupRecyclerView()

        fragmentJudgeBinding!!.dialog.setOnClickListener{
            //Inflate the dialog with custom view
            val mDialogView = LayoutInflater.from(requireContext()).inflate(R.layout.layout_dialog, null)
            //AlertDialogBuilder
            val mBuilder = AlertDialog.Builder(requireContext())
                    .setView(mDialogView)
            //show dialog
            val  mAlertDialog = mBuilder.show()
            val layoutParams = WindowManager.LayoutParams()
            layoutParams.copyFrom(mAlertDialog.window?.attributes)
            layoutParams.width = 900
            mAlertDialog.window?.attributes = layoutParams
            mAlertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            //login button click of custom layout
            mDialogView.btn_no.setOnClickListener {
                //dismiss dialog
                mAlertDialog.dismiss()
            }
            //cancel button click of custom layout
            mDialogView.btn_yes.setOnClickListener {
                //dismiss dialog
                mAlertDialog.dismiss()
            }
        }
    }

    private fun setupRecyclerView() {
        val competitions : ArrayList<String> = ArrayList()
        competitions.add("Открытое первенство по дзюдо")
        competitions.add("Открытое первенство по дзюдо")
        competitions.add("Открытое первенство по дзюдо")
        competitions.add("Открытое первенство по дзюдо")
        competitions.add("Открытое первенство по дзюдо")

        competitionAdapter = CompetitionsAdapter(competitions)
        fragmentJudgeBinding?.rv?.apply {
            adapter = competitionAdapter
            layoutManager = LinearLayoutManager(activity)
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
}