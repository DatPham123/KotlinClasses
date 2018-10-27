package edu.uco.dpham9.kotlinclasses

//HELLO

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.Toast
import edu.uco.dpham9.kotlinclasses.model.Student
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : Activity() {

    private val classRoll = ArrayList<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        var constraintLayout = findViewById(R.id.constraintLayout) as ConstraintLayout
        var animationDrawable = constraintLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(3000)
        animationDrawable.setExitFadeDuration(3000)
        animationDrawable.start()

        extra.setOnClickListener {
            val content = Intent(this, Activity2::class.java)
            startActivity(content)
        }
        //primary constructor call

        for( i in 0..9){
            classRoll.add(Student(getString(R.string.nobody,i.toString()), i.toDouble()/2))
        }

        //secondary
        for(i in 10..20){
            classRoll.add(Student(getString(R.string.nobody,i.toString()), i.toDouble()/2, i+5))
        }

        val classRollAdapter: ArrayAdapter<Student> =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, classRoll)

        listview.adapter = classRollAdapter
        
        listview.setOnItemClickListener { adapterview, view, position, id ->
            val s = listview.getItemAtPosition(position)

            Toast.makeText(this, "$s", Toast.LENGTH_SHORT).show()
        }
    }


}
