package com.techie.ebanking.repository

import com.techie.ebanking.entity.Account
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository: JpaRepository<Account, Long> {
    fun findAccountByAccountNumber(accountNumber: String): Account
}