package com.barclay.tenziapi.services

import com.barclay.tenziapi.exceptions.UnauthenticatedException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class OAuth2Service {

    @Throws(UnauthenticatedException::class)
    fun getUserId(): String {
        return OAuthClientHelper.getAuthenticatedUserId().ifEmpty {
            throw UnauthenticatedException("User could not be identified")
        }
    }

    fun getTokenValue(): String {
        /*
            OAuth2AuthenticationDetails is deprecated, but this is apparently the only way to access the token
            value when using the IT OAuth library. This token value is used to exchange for another token to
            be provided to a paired device.
         */
        return (SecurityContextHolder.getContext().authentication.details as OAuth2AuthenticationDetails).tokenValue
    }
}