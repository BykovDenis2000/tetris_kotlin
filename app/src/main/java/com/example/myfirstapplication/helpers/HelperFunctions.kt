package com.example.myfirstapplication.helpers

fun array2dOfByte(sizeOuter: Int, sizeInner: Int): Array<ByteArray> = Array(sizeOuter){
        ByteArray(sizeInner)
    }