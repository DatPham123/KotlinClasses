package edu.uco.dpham9.kotlinclasses

import android.app.Activity
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_2.*

class Activity2 : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        var constraintLayout = findViewById(R.id.constraintLayout2) as ConstraintLayout
        var animationDrawable = constraintLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(3000)
        animationDrawable.setExitFadeDuration(3000)
        animationDrawable.start()

        seekBar.max = 100

        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                display.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                display.text= seekBar?.progress.toString()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                display.text= seekBar?.progress.toString()
            }
        })
    }
}
