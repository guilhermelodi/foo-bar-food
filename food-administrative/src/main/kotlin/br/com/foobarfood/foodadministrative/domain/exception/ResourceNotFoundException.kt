package br.com.foobarfood.foodadministrative.domain.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
class ResourceNotFoundException : RuntimeException()