package com.aplitsoft.newsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.first_fragment.*

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.first_fragment, container, false)
    }

    override fun onStart() {
        super.onStart()
            btn_next.setOnClickListener {
                (activity as MainActivity).navController.navigate(R.id.action_firstFragment_to_secondFragment)
            }
    }

}