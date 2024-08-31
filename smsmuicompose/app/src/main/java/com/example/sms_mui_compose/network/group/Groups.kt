package com.example.sms_mui_compose.network.group

public class Groups {
     var groupId:Int? = null
     var creationDate:Int? = null
     var name:String? = null
     var description:String? = null
     var companyId:Int? = null
     var email:String? = null
     var address:String? = null
     override fun toString(): String {
          return "Groups(groupId=$groupId, creationDate=$creationDate, name=$name, description=$description, companyId=$companyId, email=$email, address=$address)"
     }

}