package com.barclay.tenziapi.exceptions

import java.lang.RuntimeException

class UnauthenticatedException(
    override val message: String? = "",
    override val cause: Throwable? = null
): RuntimeException(message, cause)