package com.example.andersen_hw1

sealed class ExampleSealedClass(val name: String) {

    fun methodWithName() : String {
        return "class method name: $name"
    }

    class FirstClass(name: String) : ExampleSealedClass(name) {
        fun firstClassMethod() : String {
            return "first class method name: $name"
        }
    }

    class SecondClass(name: String) : ExampleSealedClass(name) {
        fun secondClassMethod() : String {
            return "second class method name: $name"
        }
    }
}