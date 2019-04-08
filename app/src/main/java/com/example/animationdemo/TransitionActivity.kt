package com.example.animationdemo

import android.animation.LayoutTransition
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.view.ViewGroup
import android.view.Window


class TransitionActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition)

        findViewById<ViewGroup>(R.id.container).layoutTransition = LayoutTransition()
        supportFragmentManager.beginTransaction().replace(R.id.container, FirstFragment()).commit()
    }


}
