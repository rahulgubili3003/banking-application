package com.techie.ebanking.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*

@Entity
@Table(name = "accounts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
data class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, updatable = false)
    val id: Long = 0,

    @Column(name = "account_number", unique = true, updatable = false, nullable = false)
    val accountNumber: String,

    @Column(name = "account_name")
    val name: String,

    @Column(name = "balance")
    var balance: Double = 0.0,

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    val createdAt: Date = Date(),

    @UpdateTimestamp
    @Column(name = "updated_at")
    val updatedAt: Date = Date()
)
