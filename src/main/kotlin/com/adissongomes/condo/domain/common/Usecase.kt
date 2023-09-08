package com.adissongomes.condo.domain.common

fun interface Usecase<In, Out> {
    fun execute(input: In): Out
    operator fun invoke(input: In) = execute(input)
}
