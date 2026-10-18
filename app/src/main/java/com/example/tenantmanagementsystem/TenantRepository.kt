package com.example.tenantmanagementsystem

object TenantRepository {

    // The shared list of tenants. Every screen reads the same one.
    val tenants = mutableListOf<Tenant>()

    // Add one tenant to the list
    fun addTenant(tenant: Tenant) {
        tenants.add(tenant)
    }

    // Add up every tenant's rent and return the total
    fun totalRent(): Double {
        return tenants.sumOf { it.rent.toDoubleOrNull() ?: 0.0 }
    }
}