package com.example.sms_mui_compose.network

import com.example.sms_mui_compose.APIClient
import com.example.sms_mui_compose.network.company.Companies
import com.example.sms_mui_compose.network.company.Company
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GetEntityList {

    val apiClient = APIClient.get()
    public suspend fun  getAllCompaniesList(): List<Company> {
        val getAllCompaniesAPI = apiClient.create(Companies::class.java)
        lateinit var data:List<Company>
        val launch = withContext(Dispatchers.IO) { // Use a coroutine scope tied to a lifecycle
            val allCompanies = getAllCompaniesAPI.getAllCompanies()
             data = allCompanies.data

        }
        return data

    }

}