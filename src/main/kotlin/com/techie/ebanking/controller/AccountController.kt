package com.techie.ebanking.controller

import com.techie.ebanking.dto.request.AccountRequest
import com.techie.ebanking.dto.request.AmountDepositOrWithdraw
import com.techie.ebanking.dto.response.OkResponse
import com.techie.ebanking.service.AccountService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
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

    @PutMapping("/withdraw")
    fun withdraw(@RequestBody amountDepositOrWithdraw: AmountDepositOrWithdraw): ResponseEntity<OkResponse> {
        val updatedBal = accountService.withdraw(amountDepositOrWithdraw)
        return ResponseEntity.ok(OkResponse(data = updatedBal))
    }


    @PutMapping("/deposit")
    fun deposit(@RequestBody amountDepositOrWithdraw: AmountDepositOrWithdraw): ResponseEntity<OkResponse> {
        val newBalance = accountService.deposit(amountDepositOrWithdraw)
        return ResponseEntity.ok(
            OkResponse(
            data = newBalance
        )
        )
    }

    @GetMapping("/getBalance/{accountNumber}")
    fun getBalance(@PathVariable accountNumber: String): ResponseEntity<OkResponse> {
        val balance = accountService.fetchBalance(accountNumber)
        return ResponseEntity.ok(
            OkResponse(
            data = balance
        )
        )
    }

}