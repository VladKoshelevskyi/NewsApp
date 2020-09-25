package com.aplitsoft.newsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.second_fragment.*

class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.second_fragment, container, false)
    }

    override fun onStart() {
        super.onStart()
        btn_back.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_secondFragment_to_firstFragment)
        }
    }
}