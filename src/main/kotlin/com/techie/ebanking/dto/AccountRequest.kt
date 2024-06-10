package com.techie.ebanking.dto

import jakarta.validation.constraints.Size

data class AccountRequest(
    val accountNo: String,
    @field:Size(message = "Name shall not exceed 50 characters", max = 50)
    val name: String
)
