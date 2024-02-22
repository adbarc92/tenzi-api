package com.barclay.tenziapi.exceptions

class UserNotFoundException(message: String? = null): EntityNotFoundException(message = message)