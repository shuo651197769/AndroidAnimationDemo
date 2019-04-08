package com.example.animationdemo

import android.animation.ObjectAnimator
import android.animation.ValueAnimator.INFINITE
import android.animation.ValueAnimator.REVERSE
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.AnimationUtils


class OnStopTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_stop_test)

//        animateFromResource()
        animateFromViewProperty()
    }

    private fun animateFromResource() {
        findViewById<View>(R.id.imageView).startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_out))
    }

    private fun animateFromViewProperty() {
        val objectAnimator = ObjectAnimator.ofFloat(findViewById(R.id.imageView), "alpha", 1.0f, 0.5f)
        objectAnimator.duration = 500
        objectAnimator.repeatCount = INFINITE
        objectAnimator.repeatMode = REVERSE
        objectAnimator.start()
    }
}
