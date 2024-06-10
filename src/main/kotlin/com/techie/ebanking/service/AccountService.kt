package com.techie.ebanking.service

import com.techie.ebanking.dto.AccountRequest
import com.techie.ebanking.entity.Account
import com.techie.ebanking.repository.AccountRepository
import org.springframework.stereotype.Service

@Service
class AccountService(private val accountRepository: AccountRepository) {

    fun createAccount(accountRequest: AccountRequest): AccountRequest {
        val accountToBeCreated = Account(
            name = accountRequest.name,
            accountNumber = accountRequest.accountNo
        )
        val savedAccount = accountRepository.save(accountToBeCreated)
        return AccountRequest(
            name = savedAccount.name,
            accountNo = savedAccount.accountNumber
        )
    }
}