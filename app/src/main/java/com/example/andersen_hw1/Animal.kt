package com.example.andersen_hw1

open class Animal(val name: String) {
    private var favouriteToy: String? = null
    private val innerValue: String = "innerClassMethod"

    constructor(name: String, favouriteToy: String) : this(name) {
        this.favouriteToy = favouriteToy
    }

    open fun makeSound() : String {
        return "$name makes a sound"
    }

    class NestedClass {
        fun nestedClassMethod(): String {
            return "nesetClassMethod"
        }
    }

    inner class InnerClass {
        fun innerClassMethod() : String {
            return innerValue
        }
    }
}