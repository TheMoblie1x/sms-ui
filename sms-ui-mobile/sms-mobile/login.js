import React, { useEffect, useState, useRef } from "react";
// import { MyTextInput } from "./component/MyTextInput";
import {
  View,
  Text,
  TouchableOpacity,
  Image,
  TextInput,
  StyleSheet,
} from "react-native";
import styles from "./style/MyStyle";
import Toast from "react-native-toast-message";
import getApiUrlFor from "./constants";
const backgroundImg = require("./icon/Ellipse.png");
const logoApple = require("./icon/logoApple.png");
const logoGoogle = require("./icon/logoGoogle.png");
const logoFb = require("./icon/logoFb.png");
export default function LoginScreen({ navigation }) {
  const [userName, setUsername] = useState("");
  const [userId, setUserId] = useState("");
  const [password, setPassword] = useState("");
  const [userDetails, setUserDetails] = useState([]);
  const [error, setError] = useState(null);
  const [isLoading, setLoading] = useState(true);
  let API_PATH_LOGIN = "login/";
  const passwordInput = useRef(null);
  const [text, setText] = useState("");
  const [borderColor, setBorderColor] = useState("#ffffff");
  // const [isUserNameCorrect, setIsUserNameCorrect] = useState(false);
  let isUserNameCorrect = false;
  let res = false;
  const getUser = async (enterUsername) => {
    try {
      let loginApiUrl = getApiUrlFor(API_PATH_LOGIN);
      const response = await fetch(loginApiUrl + enterUsername);
      const json = await response.json();
      setUserDetails([json]);

      if (json.status == 200) {
        console.log("username is correct");
        isUserNameCorrect = true;
        setBorderColor("#ffffff");
        console.log(borderColor);
      } else {
        isUserNameCorrect = false;
        setBorderColor("#ff0000");
        console.log(borderColor);
      }
    } catch (error) {
      console.error(error);
      console.error("invalid details");
    } finally {
      setLoading(false);
    }
  };
  useEffect(() => {}, []);
  const handleUsernameChange = () => {
    setUsername(text);
    getUser(text);
  };
  const handleTextChange = (newText) => {
    setText(newText);
  };
  return (
    <View style={styles.containerMain}>
      <View style={styles.container}>
        <Text style={{ textAlign: "center", fontSize: 25, marginTop: 20 }}>
          Survey Management System
        </Text>
        <Text style={{ textAlign: "center", fontSize: 25, marginBottom: 80 }}>
          Log In
        </Text>
        <Text style={{ marginBottom: 5 }}>userName</Text>
        <TextInput
          style={[styles.input, textInputStyle.textInputStyle, { borderColor }]}
          onChangeText={handleTextChange}
          // onChangeText={console.log(username)}
          placeholder="username"
          // onChangeText={(text) => setUsername(text)}
          // onChangeText={handleUsernameChange}
          required
        />
        {/* {!isUserNameCorrect && (
          <Text style={{ color: "red" }}>Invalid username</Text>
        )} */}
        <Text style={{ marginBottom: 5 }}>Password</Text>
        <TextInput
          style={styles.input}
          placeholder="password"
          autoCapitalize="none"
          onChangeText={(text) => setPassword(text)}
          onFocus={handleUsernameChange}
          editable={true}
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

const textInputStyle = StyleSheet.create({
  textInputStyle: {
    borderWidth: 2,

    borderColor: "gray",
  },
});
