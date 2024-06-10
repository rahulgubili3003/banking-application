package com.techie.ebanking.dto.response

import com.techie.ebanking.dto.AccountRequest

data class OkResponse(
    val ok: Boolean = true,
    val data: AccountRequest
)
