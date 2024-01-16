import { StatusBar } from "expo-status-bar";
import { StyleSheet, Text, View } from "react-native";
import LoginScreen from "./login";
import RegisterScreen from "./RegisterCompany";
import MyStyle from "./style/MyStyle";
import AddCompany from "./AddCompany";
import { NavigationContainer } from "@react-navigation/native";
import { createNativeStackNavigator } from "@react-navigation/native-stack";
import AddGroup from "./AddGroup";
import YourComponent from "./YourComponent";
const Stack = createNativeStackNavigator();
export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen
          name="Login"
          component={LoginScreen}
          options={{ title: "Login" }}
        />
        <Stack.Screen
          name="AddCompany"
          component={AddCompany}
          options={{ title: "Add Company" }}
        />
        <Stack.Screen
          name="RegisterScreen"
          component={RegisterScreen}
          options={{ title: "Register Company" }}
        />
        <Stack.Screen
          name="AddGroup"
          component={AddGroup}
          options={{ title: "Add Group" }}
        />
      </Stack.Navigator>
    </NavigationContainer>
  );
}
