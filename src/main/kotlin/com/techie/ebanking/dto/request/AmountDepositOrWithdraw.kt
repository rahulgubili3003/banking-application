package com.techie.ebanking.dto.request

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class AmountDepositOrWithdraw(
    val accountNo: String,
    val amount: Double
)
