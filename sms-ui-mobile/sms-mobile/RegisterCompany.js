import React, { useState } from "react";
import { MyTextInput } from "./component/MyTextInput";
import { View, Text, TouchableOpacity } from "react-native";
import styles from "./style/MyStyle";
export default function RegisterScreen() {
  return (
    <View style={styles.container}>
      <Text
        style={{ ...styles.heading1, ...{ textAlign: "center", fontSize: 25 } }}
      >
        Register Company
      </Text>
      <Text style={{ marginBottom: 5 }}>Company Email</Text>
      <MyTextInput
        myPlaceHolder={"Enter Company email"}
        kBoardType={"email-address"}
        autoCompType={"email"}
      />
      <Text style={{ marginBottom: 5 }}>Company Name</Text>
      <MyTextInput
        myPlaceHolder={"Enter your Company Name"}
        kBoardType={"name-phone-pad"}
        autoCompType={"name"}
      />
      <Text style={{ marginBottom: 5 }}>Address </Text>
      <MyTextInput
        myPlaceHolder={"Enter your Company Address"}
        kBoardType={"name-phone-pad"}
        autoCompType={"address"}
      />

      <TouchableOpacity style={styles.loginButton}>
        <Text style={{ color: "#fff" }}>Proceed</Text>
      </TouchableOpacity>
    </View>
  );
}
