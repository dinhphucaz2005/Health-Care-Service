package com.example.spring_healthcare.entity.response

import com.example.spring_healthcare.exception.ErrorCode
import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ApiResponse<out T : Any>(
    val code: Int,
    val msg: String? = null,
    val data: T? = null
) {
    constructor(errorCode: ErrorCode) : this(errorCode.code, errorCode.message, null)
    constructor(data: T?) : this(200, null, data)
}

