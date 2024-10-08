package com.example.spring_healthcare.exception

class AppException(val errorCode: ErrorCode) : RuntimeException(errorCode.message)
