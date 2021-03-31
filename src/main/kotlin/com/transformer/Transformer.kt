package com.transformer

interface Transformer <A, B> {
    fun transform(source: A): B
}