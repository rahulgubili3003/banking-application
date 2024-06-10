package com.techie.ebanking.dto.request

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import jakarta.validation.constraints.Size

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class AccountRequest(
    val accountNo: String,
    @field:Size(message = "Name shall not exceed 50 characters", max = 50)
    val name: String
)
