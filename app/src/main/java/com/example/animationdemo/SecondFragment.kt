package com.example.animationdemo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class SecondFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_second, null)
    }

    override fun onResume() {
        super.onResume()

        view?.findViewById<View>(R.id.firstText)?.setOnClickListener {
            TransitionManager.beginDelayedTransition(view as? ViewGroup)
            view?.findViewById<View>(R.id.firstText)?.visibility = View.GONE
            view?.findViewById<View>(R.id.thirdText)?.visibility = View.VISIBLE
        }
    }
}