import { View, Text, Image, TouchableOpacity, ScrollView } from "react-native";
import styles from "./style/AddCompanyStyle";
import { RectangleBox } from "./RectangleBoc";
const addComIcon = require("./icon/fi-rr-plus.png");
const userIcon = require("./icon/fi-bs-user.png");

export default function AddCompany({ navigation }) {
  const textComName = "Company Name";
  return (
    <ScrollView>
      <View style={styles.mainContainer}>
        <Text style={styles.usernames}>Logged in As- Username (Admin)</Text>
        <View>
          <Text style={styles.textCompany}>Companies</Text>
        </View>
        <View style={styles.secondContainer}>
          <View style={styles.thirdContainer}></View>
            <View style={styles.containerCompany}>
              <TouchableOpacity onPress={() => navigation.navigate("RegisterScreen")}>
                <View style={styles.rectangleBox}>
                  <Image style={styles.addIcon} source={addComIcon} />
                </View>
              </TouchableOpacity>
              <RectangleBox textName={textComName} icon={userIcon} />
            </View>
          <View style={styles.containerCompany}>
            <RectangleBox textName={textComName} icon={userIcon} />
            <RectangleBox textName={textComName} icon={userIcon} />
          </View>
          <View style={styles.containerCompany}>
            <RectangleBox textName={textComName} icon={userIcon} />
            <RectangleBox textName={textComName} icon={userIcon} />
          </View>
          <View style={styles.containerCompany}>
            <RectangleBox textName={textComName} icon={userIcon} />
            <RectangleBox textName={textComName} icon={userIcon} />
          </View>
        </View>
      </View>
    </ScrollView>
  );
}
