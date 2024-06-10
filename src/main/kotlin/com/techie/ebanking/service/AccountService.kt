package com.techie.ebanking.service

import com.techie.ebanking.dto.request.AccountRequest
import com.techie.ebanking.dto.request.AmountDepositOrWithdraw
import com.techie.ebanking.entity.Account
import com.techie.ebanking.repository.AccountRepository
import org.springframework.stereotype.Service

@Service
class AccountService(private val accountRepository: AccountRepository) {

    fun deposit(deposit: AmountDepositOrWithdraw): Double {
        val account = accountRepository.findAccountByAccountNumber(deposit.accountNo)
        val newBalance = account.balance + deposit.amount
        account.balance = newBalance
        val savedEntity = accountRepository.save(account)
        return savedEntity.balance
    }

    fun withdraw(withdraw: AmountDepositOrWithdraw): Double {
        val account = accountRepository.findAccountByAccountNumber(withdraw.accountNo)
        val balance = account.balance
        var newBalance = balance - withdraw.amount
        if(balance == 0.0 || newBalance < 0.0) {
            newBalance = 0.0
        }
        account.balance = newBalance
        val savedEntity = accountRepository.save(account)
        return savedEntity.balance
    }


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