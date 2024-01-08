import { StatusBar } from "expo-status-bar";
import { StyleSheet, Text, View } from "react-native";
import LoginScreen from "./login";
import RegisterScreen from "./RegisterCompany";
import MyStyle from "./style/MyStyle";
import AddCompany from "./AddCompany";

export default function App() {
  return (
    <View style={MyStyle.containerMain}>
      <LoginScreen />
    </View>
  );
}
