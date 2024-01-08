import { View, Text, Image, TouchableOpacity } from "react-native";
import styles from "./style/AddCompanyStyle";
import { createStackNavigator } from "@react-navigation/stack";
import { RectangleBox } from "./RectangleBoc";
const addComIcon = require("./icon/fi-rr-plus.png");
const userIcon = require("./icon/fi-bs-user.png");

export default function AddCompany({ navigation }) {
  return (
    <View style={styles.mainContainer}>
      <Text style={styles.usernames}>Logged in As- Username (Admin)</Text>
      <View>
        <Text style={styles.textCompany}>Companies</Text>
      </View>
      <View style={styles.secondContainer}>
        <View style={styles.thirdContainer}></View>

        <View style={styles.containerCompany}>
          <TouchableOpacity>
            <View style={styles.rectangleBox}>
              <Image style={styles.addIcon} source={addComIcon} />
            </View>
          </TouchableOpacity>
          <RectangleBox />
          <RectangleBox />
          <RectangleBox />
        </View>
        <View style={styles.containerCompany}>
          <RectangleBox />
          <RectangleBox />
          <RectangleBox />
          <RectangleBox />
        </View>
      </View>
    </View>
  );
}
