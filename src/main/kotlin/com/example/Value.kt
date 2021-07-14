package com.example

sealed class Value<T>(
    @JvmField
    val value: T
) {
    class StringValue(value: String) : Value<String>(value)
    class BooleanValue(value: Boolean) : Value<Boolean>(value)
}
