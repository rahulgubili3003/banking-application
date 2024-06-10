package com.techie.ebanking.dto.response

import com.techie.ebanking.dto.request.AccountRequest

data class OkResponse(
    val ok: Boolean = true,
    val data: Any
)
