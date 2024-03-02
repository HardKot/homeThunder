package com.homethunder.backend.data

interface IResetPasswordForm {
    var droppedToken: String?
    var password: String?
    var confirmPassword: String?
}
