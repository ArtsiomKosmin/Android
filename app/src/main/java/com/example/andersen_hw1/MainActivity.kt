package com.example.andersen_hw1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    private var result: TextView? = null
    private var mainBtn: Button? = null
    private val maxInt: Int = Int.MAX_VALUE
    private val dog:Dog = Dog("Dog Name")
    private val animalNested:Animal.NestedClass = Animal.NestedClass()
    private val firstSealed = ExampleSealedClass.FirstClass("first class")
    private val secondSealed = ExampleSealedClass.SecondClass("second class")


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        result = findViewById(R.id.result)
        mainBtn = findViewById(R.id.main_btn)

        mainBtn?.setOnClickListener {
            if(it.isPressed) {
                result?.text = """
                        |Kotlin primitives, int max value: $maxInt
                        |inheritance, constructors: ${dog.makeSound()}
                        |nested class: ${animalNested.nestedClassMethod()}
                        |inner class: ${dog.InnerClass().innerClassMethod()}
                        |sealed class 1: ${firstSealed.firstClassMethod()} 
                        |sealed class 2: ${secondSealed.secondClassMethod()} 
                        |sealed class method: ${secondSealed.methodWithName()}
                    """.trimMargin()
            }
        }
    }
}