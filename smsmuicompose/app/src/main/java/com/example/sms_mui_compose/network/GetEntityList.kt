package com.example.sms_mui_compose.network

import com.example.sms_mui_compose.APIClient
import com.example.sms_mui_compose.network.company.CompaniesAPI
import com.example.sms_mui_compose.network.company.Company
import com.example.sms_mui_compose.network.group.Groups
import com.example.sms_mui_compose.network.group.GroupsAPI
import com.example.sms_mui_compose.network.surveyset.SurveySet
import com.example.sms_mui_compose.network.surveyset.SurveySetsAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetEntityList {

    val apiClient = APIClient.get()
    public suspend fun getAllCompaniesList(): List<Company>? {
        val getAllCompaniesAPI = apiClient.create(CompaniesAPI::class.java)
        lateinit var data:List<Company>
        val launch = withContext(Dispatchers.IO) { // Use a coroutine scope tied to a lifecycle
            val allCompanies = getAllCompaniesAPI.getAllCompanies()
             data = allCompanies.data?: emptyList()
        }
        return data
    }

    public suspend fun getAllGroupsByCompany(companyID:Int): List<Groups>? {
        val allGroupsAPI = apiClient.create(GroupsAPI::class.java)
        lateinit var data:List<Groups>
        val launch = withContext(Dispatchers.IO) { // Use a coroutine scope tied to a lifecycle
            val allGroups = allGroupsAPI.getGroupByCompanyID(companyID)
            data = allGroups.data?: emptyList()
        }
        return data
    }

    public suspend fun getSurveySetsByGroupID(groupID:Int): List<SurveySet>? {
        val allSurveysAPI = apiClient.create(SurveySetsAPI::class.java)
        lateinit var data:List<SurveySet>
        val launch = withContext(Dispatchers.IO) { // Use a coroutine scope tied to a lifecycle
            val allSurveySets = allSurveysAPI.getSurveySetsByGroupId(groupID)
            data = allSurveySets.data?: emptyList()
        }
        return data
    }
    public suspend fun getSurveySetBySurveySetID(surveySetID:Int): List<SurveySet>? {
        val allSurveysAPI = apiClient.create(SurveySetsAPI::class.java)
        lateinit var data:List<SurveySet>
        val launch = withContext(Dispatchers.IO) { // Use a coroutine scope tied to a lifecycle
            val allSurveySets = allSurveysAPI.getSurveySetsByGroupId(surveySetID)
            data = allSurveySets.data?: emptyList()
        }
        return data
    }

}