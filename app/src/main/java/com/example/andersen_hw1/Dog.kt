package com.example.andersen_hw1

class Dog(name: String) : Animal(name) {
    override fun makeSound() : String {
        return "$name make sound"
    }
}