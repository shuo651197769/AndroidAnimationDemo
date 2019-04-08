package com.example.animationdemo

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.Point
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ArrayAdapter
import android.widget.Spinner


class AnimatorActivity : AppCompatActivity() {

    private lateinit var image: View
    private var screenHeight: Float = 0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val list = ArrayList<String>()
        list.add("ValueAnimator")
        list.add("ObjectAnimator")
        list.add("PropertyViewAnimator")
        val dataAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item, list
        )
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = dataAdapter

        findViewById<View>(R.id.button).setOnClickListener { onClick() }
        image = findViewById<View>(R.id.imageView)

        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        screenHeight = size.y.toFloat()
    }

    private fun onClick() {
        image.y = screenHeight/2
        val destination = screenHeight/2 - image.height
        val animator = findViewById<Spinner>(R.id.spinner).selectedItem.toString()
        when (animator) {
            "ValueAnimator" -> useValueAnimator(destination)
            "ObjectAnimator" -> useObjectAnimator(destination)
            "PropertyViewAnimator" -> useViewPropertyAnimator(destination)
        }
    }

    private fun useValueAnimator(destination: Float) {
        val valueAnimator = ValueAnimator.ofFloat(0f, destination)

        valueAnimator.addUpdateListener {
            image.translationY = it.animatedValue as Float
        }

        valueAnimator.interpolator = AccelerateDecelerateInterpolator()
        valueAnimator.duration = 300
        valueAnimator.start()
    }

    private fun useObjectAnimator(destination: Float) {
        val objectAnimator = ObjectAnimator.ofFloat(image, "translationY", 0f, destination)
        objectAnimator.interpolator = AccelerateDecelerateInterpolator()
        objectAnimator.duration = 300
        objectAnimator.start()
    }

    private fun useViewPropertyAnimator(destination: Float) {
        image.animate()
            .translationY(destination)
            .setDuration(300)
            .setInterpolator(AccelerateDecelerateInterpolator())
            .start()
    }
}
