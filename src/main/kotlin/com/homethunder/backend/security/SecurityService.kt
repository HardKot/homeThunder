package com.homethunder.backend.security

import com.vaadin.flow.component.UI
import com.vaadin.flow.server.VaadinServletRequest
import jakarta.servlet.ServletException
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler
import org.springframework.stereotype.Component


@Component
class SecurityService {
    private val LOGOUT_SUCCESS_URL = "/auth"
    private val LOGIN_SUCCESS_URL = "/"

    fun logout() {
        UI.getCurrent().page.setLocation(LOGOUT_SUCCESS_URL)
        SecurityContextLogoutHandler().logout(VaadinServletRequest.getCurrent().httpServletRequest, null, null)
    }

    fun authenticate(username: String, password: String, rememberMe: Boolean = false): Boolean {
        val request = VaadinServletRequest.getCurrent()
            ?: return false
        try {
            request.login(username, password)
            request.httpServletRequest.changeSessionId()
            return true
        } catch (e: ServletException) {
            return false
        }
    }
}
