package com.example.sms_mui_compose.network.company

public class Company {
    lateinit var companyId:String
    lateinit var contactInfo:String
    lateinit var name:String
    lateinit var location:String
    lateinit var email:String
    lateinit var address:String

    override fun toString(): String {
        return "Company(companyId='$companyId', contactInfo='$contactInfo', name='$name', location='$location', email='$email', address='$address')"
    }

}
