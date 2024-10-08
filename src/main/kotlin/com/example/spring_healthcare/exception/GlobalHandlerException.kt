package com.example.spring_healthcare.exception

import com.example.spring_healthcare.entity.response.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class GlobalHandlerException {

    @ExceptionHandler(RuntimeException::class)
    fun handleRuntimeException(ex: RuntimeException, request: WebRequest): ResponseEntity<ApiResponse<Void>> {
        val errorCode = ErrorCode.UNCATEGORIZED_EXCEPTION
        return ResponseEntity.status(errorCode.statusCode).body(ApiResponse(errorCode))
    }

    @ExceptionHandler(AppException::class)
    fun handleAppException(ex: AppException, request: WebRequest): ResponseEntity<ApiResponse<Void>> {
        val errorCode = ex.errorCode
        return ResponseEntity.status(errorCode.statusCode).body(ApiResponse(errorCode))
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(
        ex: MethodArgumentNotValidException,
        request: WebRequest
    ): ResponseEntity<ApiResponse<Void>> {
        val errorCode = ex.fieldError?.defaultMessage.let { ErrorCode.get(it) }
        return ResponseEntity.status(errorCode.statusCode).body(ApiResponse(errorCode))
    }

    @ExceptionHandler(AccessDeniedException::class)
    fun handleAccessDeniedException(
        ex: AccessDeniedException,
        request: WebRequest
    ): ResponseEntity<ApiResponse<Void>> {
        val errorCode = ErrorCode.UNAUTHORIZED
        return ResponseEntity.status(errorCode.statusCode).body(ApiResponse(errorCode))
    }
}
