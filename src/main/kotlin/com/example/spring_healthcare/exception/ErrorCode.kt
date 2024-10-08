package com.example.spring_healthcare.exception

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode

enum class ErrorCode(
    val code: Int,
    val message: String,
    val statusCode: HttpStatusCode
) {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_KEY(1001, "Uncategorized error", HttpStatus.BAD_REQUEST),
    USER_EXISTED(1002, "User existed", HttpStatus.BAD_REQUEST),
    INVALID_USERNAME(1003, "Username must be at least 8 characters", HttpStatus.BAD_REQUEST),
    INVALID_PASSWORD(1004, "Password must be at least 8 characters", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(1005, "User not existed", HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(1006, "Unauthenticated", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1007, "You do not have permission", HttpStatus.FORBIDDEN);

    companion object {
        fun get(message: String?): ErrorCode {
            return entries.find { it.message == message } ?: UNCATEGORIZED_EXCEPTION
        }
    }

}
