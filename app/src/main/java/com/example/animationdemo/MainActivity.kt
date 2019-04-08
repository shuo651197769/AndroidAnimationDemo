package com.example.animationdemo

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.support.v4.util.Pair
import android.view.Window

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.animator).setOnClickListener {
            startActivity(Intent(this, AnimatorActivity::class.java))
        }

        findViewById<View>(R.id.transition).setOnClickListener {
            val views = arrayOf(Pair(it, "transitionName"))
            val transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this, *views)
            startActivity(Intent(this, TransitionActivity::class.java), transitionActivityOptions.toBundle())

        }

        findViewById<View>(R.id.motionLayout).setOnClickListener {
            startActivity(Intent(this, MotionLayoutActivity::class.java))
        }

        findViewById<View>(R.id.onStopTest).setOnClickListener {
            startActivity(Intent(this, OnStopTestActivity::class.java))
        }
    }

    override fun onPause() {
        Log.d(MainActivity::class.java.name, "test onPause")
        super.onPause()
    }


    override fun onStop() {
        Log.d(MainActivity::class.java.name, "test onStop")
        super.onStop()
    }
}
