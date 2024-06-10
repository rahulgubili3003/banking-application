package com.techie.ebanking.controller

import com.techie.ebanking.dto.AccountRequest
import com.techie.ebanking.dto.response.OkResponse
import com.techie.ebanking.service.AccountService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/banking")
class AccountController(private val accountService: AccountService) {

    @PostMapping("/createAccount")
    fun createAccount(@RequestBody accountRequest: AccountRequest): ResponseEntity<OkResponse> {
        val savedAccount = accountService.createAccount(accountRequest)
        return ResponseEntity.ok(OkResponse(
            data = savedAccount
        ))
    }
}