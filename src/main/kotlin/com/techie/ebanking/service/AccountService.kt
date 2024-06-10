package com.techie.ebanking.service

import com.techie.ebanking.dto.request.AccountRequest
import com.techie.ebanking.dto.request.AmountDepositOrWithdraw
import com.techie.ebanking.entity.Account
import com.techie.ebanking.repository.AccountRepository
import org.springframework.stereotype.Service

private const val ACCOUNT_NOT_PRESENT = "Account Not Present"

private const val ACCOUNT_BALANCE_INSUFFICIENT = "Account Balance Insufficient"

@Service
class AccountService(private val accountRepository: AccountRepository) {

    fun deposit(deposit: AmountDepositOrWithdraw): Double {
        val account = accountRepository.findAccountByAccountNumber(deposit.accountNo)
        val newBalance = account.map { it.balance + deposit.amount }.orElseThrow { RuntimeException(ACCOUNT_NOT_PRESENT) }
        accountRepository.save(account.get().apply { balance = newBalance })
        return newBalance
    }

    fun withdraw(withdraw: AmountDepositOrWithdraw): Double {
        val optionalAccount = accountRepository.findAccountByAccountNumber(withdraw.accountNo)
        val eligible = optionalAccount.map { it.balance >= withdraw.amount }.orElseThrow { RuntimeException(
            ACCOUNT_NOT_PRESENT)
        }
        if (!eligible) {
            throw RuntimeException(ACCOUNT_BALANCE_INSUFFICIENT)
        }
        val account = optionalAccount.get()
        val newBalance =account.balance - withdraw.amount
        accountRepository.save(optionalAccount.get().apply { balance = newBalance })
        return newBalance
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

    fun fetchBalance(accountNumber: String): Double? {
        val optionalAccount = accountRepository.findAccountByAccountNumber(accountNumber)
        return optionalAccount.map { account -> account.balance }
            .orElseThrow { RuntimeException(ACCOUNT_NOT_PRESENT) }
    }
}