package edu.uco.dpham9.kotlinclasses.model

import android.util.Log

const val NO_NAME = "No Name"
const val TAG = "STUDENT"
// primary constructor in ()
class Student(var name: String, var gpa: Double) {
    init {
        if(name.isNullOrEmpty() || name.isNullOrBlank()){
            name = NO_NAME
        }

        if(gpa <0 || gpa> 4.0){
            gpa = 0.0
        }
        Log.i(TAG, "init() $name")
    }
    var age: Int = 0
    set(value){
        field = if(value <0) 0 else value
        Log.i(TAG, "age:setter() $name")
    }

    get() :Int{
        Log.i(TAG, "age:getter() $name")
        return field
    }

    //secondary constructor
    constructor(name: String, gpa: Double,age: Int) : this(name, gpa){
        Log.i(TAG, "secondary constructor() $name $age")
        this.age = age
    }

    override fun toString(): String = "[name=$name gpa=$gpa age=$age]"

}