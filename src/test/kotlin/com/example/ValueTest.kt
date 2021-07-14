package com.example

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class ValueTest {

    companion object {
        @JvmStatic
        fun testValues(): List<Arguments> = listOf(
            arguments(Value.StringValue("a string")),
            arguments(Value.BooleanValue(true))
        )
    }

    @MethodSource("testValues")
    @ParameterizedTest
    fun `test KT-47739`(value: Value<*>) {
        when (value) {
            is Value.StringValue -> assertEquals("a string", value.value)
            is Value.BooleanValue -> assertTrue(value.value)
        }
    }

}
