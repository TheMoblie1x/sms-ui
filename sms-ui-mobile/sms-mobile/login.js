import React, { useState } from "react";
import { MyTextInput } from "./component/MyTextInput";
import { View, Text, TouchableOpacity, Image } from "react-native";
import styles from "./style/MyStyle";
const backgroundImg = require("./icon/Ellipse.png");
const logoApple = require("./icon/logoApple.png");
const logoGoogle = require("./icon/logoGoogle.png");
const logoFb = require("./icon/logoFb.png");
export default function LoginScreen({ navigation }) {
  return (
    <View style={styles.containerMain}>
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
        <Text style={{ textAlign: "right", fontSize: 12 }}>
          Forgot Password
        </Text>

        <TouchableOpacity
          onPress={() => navigation.navigate("AddCompany")}
          style={styles.loginButton}
        >
          <Text style={{ color: "#fff" }}>Log in</Text>
        </TouchableOpacity>
        <Text style={{ ...styles.heading1, ...{ textAlign: "center" } }}>
          Haven’t got an account? Sign up
        </Text>
        <View style={styles.containerLoginOp}>
          <Text>Or sign in with</Text>
          <View
            style={{
              ...styles.containerLoginOp,
              ...{ marginStart: 100 },
            }}
          >
            <OverLayImg overImg={logoGoogle} />
            <OverLayImg overImg={logoFb} />
            <OverLayImg overImg={logoApple} />
          </View>
        </View>
      </View>
    </View>
  );
}

const OverLayImg = ({ overImg }) => {
  return (
    <TouchableOpacity style={{ marginLeft: 5 }}>
      <Image source={backgroundImg} />
      <Image
        source={overImg}
        style={{ position: "absolute", marginLeft: 12, marginTop: 10 }}
      />
    </TouchableOpacity>
  );
};
