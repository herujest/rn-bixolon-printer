package com.rnbixolonprinter.PrinterControl

fun <T> Result.Companion.failure(message: String): Result<T> {
    return Result.failure<T>(Throwable(message))
}
