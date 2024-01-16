import React, { useEffect, useState } from "react";
// import { MyTextInput } from "./component/MyTextInput";
import { View, Text, TouchableOpacity, Image, TextInput } from "react-native";
import styles from "./style/MyStyle";
import Toast from "react-native-toast-message";
const backgroundImg = require("./icon/Ellipse.png");
const logoApple = require("./icon/logoApple.png");
const logoGoogle = require("./icon/logoGoogle.png");
const logoFb = require("./icon/logoFb.png");
export default function LoginScreen({ navigation }) {
  const [username, setUsername] = useState("");
  const [userId, setUserId] = useState("");
  const [password, setPassword] = useState("");
  const [userDetails, setUserDetails] = useState([]);
  const [error, setError] = useState(null);
  const [isLoading, setLoading] = useState(true);

  const getUser = async () => {
    try {
      const response = await fetch("http://192.168.114.212:8080/login/User1");
      const json = await response.json();
      setUserDetails([json]);

      if (json.status == 200) {
        console.log("Login successfully");
      }
      console.log(json.userId);
    } catch (error) {
      console.error(error);
      console.error("invalid details");
    } finally {
      setLoading(false);
    }
  };
  useEffect(() => {
    // getUser();
  }, []);

  return (
    <View style={styles.containerMain}>
      <View style={styles.container}>
        <Text style={{ textAlign: "center", fontSize: 25, marginTop: 20 }}>
          Survey Management System
        </Text>
        <Text style={{ textAlign: "center", fontSize: 25, marginBottom: 80 }}>
          Log In
        </Text>
        <Text style={{ marginBottom: 5 }}>userId</Text>
        <TextInput
          style={styles.input}
          placeholder="user ID"
          autoCapitalize="none"
          onChangeText={(text) => setUserId(text)}
          required
        />

        <Text style={{ marginBottom: 5 }}>userName</Text>
        <TextInput
          style={styles.input}
          placeholder="username"
          onChangeText={(text) => setUsername(text)}
          required
        />
        <Text style={{ marginBottom: 5 }}>Password</Text>
        <TextInput
          style={styles.input}
          placeholder="password"
          autoCapitalize="none"
          onChangeText={(text) => setPassword(text)}
          required
        />
        <Text style={{ textAlign: "right", fontSize: 12 }}>
          Forgot Password
        </Text>

        <TouchableOpacity
          onPress={getUser}
          // onPress={() => navigation.navigate("AddCompany")}
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

export function MyTextInput({ myPlaceHolder, kBoardType, autoCompType }) {
  return (
    <View>
      <TextInput
        style={styles.input}
        placeholder={myPlaceHolder}
        keyboardType={kBoardType}
        autoCapitalize="none"
        autoCompleteType={autoCompType}
        autoCorrect={false}
        required
      />
    </View>
  );
}
