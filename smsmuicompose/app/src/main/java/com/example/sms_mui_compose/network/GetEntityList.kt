package com.example.sms_mui_compose.network

import android.content.Context
import android.content.Intent
import com.example.sms_mui_compose.APIClient
import com.example.sms_mui_compose.network.company.CompaniesAPI
import com.example.sms_mui_compose.network.company.Company
import com.example.sms_mui_compose.network.group.Groups
import com.example.sms_mui_compose.network.group.GroupsAPI
import com.example.sms_mui_compose.network.surveyset.SurveySet
import com.example.sms_mui_compose.network.surveyset.SurveySetsAPI
import com.example.sms_mui_compose.ui.theme.ErrorActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import java.net.SocketTimeoutException

class GetEntityList {

    val apiClient = APIClient.get()
    suspend fun getAllCompaniesList(context: Context): List<Company>? {
        return safeApiCall(context,{
            val getAllCompaniesAPI = apiClient.create(CompaniesAPI::class.java)
            lateinit var data:List<Company>
            if(!NetworkUtil.isNetworkAvailable(context)){
                navigateToErrorScreen(context)
            }

            val launch = withContext(Dispatchers.IO) { // Use a coroutine scope tied to a lifecycle
                val allCompanies = getAllCompaniesAPI.getAllCompanies()
                data = allCompanies.data?: emptyList()
            }
            data
        })
    }

    private fun navigateToErrorScreen(context: Context) {
        context.startActivity(Intent(context,ErrorActivity::class.java))
    }

    suspend fun getAllGroupsByCompany(context:Context, companyID:Int): List<Groups>? {
        return safeApiCall(context, {
            val allGroupsAPI = apiClient.create(GroupsAPI::class.java)
            lateinit var data: List<Groups>
            if (!NetworkUtil.isNetworkAvailable(context)) {
                navigateToErrorScreen(context)
            }
            val launch = withContext(Dispatchers.IO) { // Use a coroutine scope tied to a lifecycle
                val allGroups = allGroupsAPI.getGroupByCompanyID(companyID)
                data = allGroups.data ?: emptyList()
            }
            data
        })
    }

    suspend fun getSurveySetsByGroupID(context:Context, groupID:Int): List<SurveySet>? {
        return safeApiCall(context,{
        val allSurveysAPI = apiClient.create(SurveySetsAPI::class.java)
        lateinit var data:List<SurveySet>
        if(!NetworkUtil.isNetworkAvailable(context)){
            navigateToErrorScreen(context)
        }
        val launch = withContext(Dispatchers.IO) { // Use a coroutine scope tied to a lifecycle
            val allSurveySets = allSurveysAPI.getSurveySetsByGroupId(groupID)
            data = allSurveySets.data?: emptyList()
        }
        data})
    }

    suspend fun getSurveySetBySurveySetID(context:Context, surveySetID:Int): List<SurveySet>? {
        return safeApiCall(context,{
        val allSurveysAPI = apiClient.create(SurveySetsAPI::class.java)
        lateinit var data:List<SurveySet>
        if(!NetworkUtil.isNetworkAvailable(context)){
            navigateToErrorScreen(context)
        }
        val launch = withContext(Dispatchers.IO) { // Use a coroutine scope tied to a lifecycle
            val allSurveySets = allSurveysAPI.getSurveySetsByGroupId(surveySetID)
            data = allSurveySets.data?: emptyList()
        }
        data})
    }


    suspend fun <T> safeApiCall(
        context: Context,
        apiCall: suspend () -> T?
    ): T? {
        if (!NetworkUtil.isNetworkAvailable(context)) {
            navigateToErrorScreen(context)
            return null
        }

        return try {
            apiCall()
        } catch (e: SocketTimeoutException) {
            navigateToErrorScreen(context)
            null
        } catch (e: IOException) {
            navigateToErrorScreen(context)
            null
        } catch (e: Exception) {
            // optional: log the exception here
            navigateToErrorScreen(context)
            null
        }
    }

}