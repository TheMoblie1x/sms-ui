import React, { useState } from "react";
import { MyTextInput } from "./component/MyTextInput";
import { View, Text, TouchableOpacity } from "react-native";
import styles from "./style/MyStyle";
export default function LoginScreen() {
  return (
    <View style={styles.container}>
      <Text style={{ textAlign: "center", fontSize: 25, marginTop: 20 }}>
        Survey Management System
      </Text>
      <Text style={{ textAlign: "center", fontSize: 25, marginBottom: 80 }}>
        Log In
      </Text>

      <Text style={{ marginBottom: 5 }}>Email</Text>
      <MyTextInput
        myPlaceHolder={"Enter your email"}
        kBoardType={"email-address"}
        autoCompType={"email"}
      />
      <Text style={{ marginBottom: 5 }}>Password</Text>
      <MyTextInput
        myPlaceHolder={"Enter your password"}
        kBoardType={"numeric"}
        autoCompType={"password"}
      />
      <Text style={{ textAlign: "right", fontSize: 12 }}>Forgot Password</Text>

      <TouchableOpacity style={styles.loginButton}>
        <Text style={{ color: "#fff" }}>Log in</Text>
      </TouchableOpacity>
      <Text style={{ ...styles.heading1, ...{ textAlign: "center" } }}>
        Haven’t got an account? Sign up
      </Text>
    </View>
  );
}
