import { View, Text, Image, TouchableOpacity, ScrollView } from "react-native";
import styles from "./style/AddCompanyStyle";
import { RectangleBox } from "./RectangleBoc";
const addGroupIcon = require("./icon/fi-rr-plus.png");
const groupIcon = require("./icon/group.png");
export default function AddGroup({ navigation }) {
  const textGroupName = "Group Name";
  return (
    <ScrollView>
      <View style={styles.mainContainer}>
        <Text style={styles.usernames}>Logged in As- Username (Admin)</Text>
        <View>
          <Text style={styles.textCompany}>Group Name</Text>
        </View>
        <View style={styles.secondContainer}>
          <View style={styles.thirdContainer}></View>

          <View style={styles.containerCompany}>
            <TouchableOpacity>
              <View style={styles.rectangleBox}>
                <Image style={styles.addIcon} source={addGroupIcon} />
              </View>
            </TouchableOpacity>
            <RectangleBox textName={textGroupName} icon={groupIcon} />
          </View>
          <View style={styles.containerCompany}>
            <RectangleBox textName={textGroupName} icon={groupIcon} />
            <RectangleBox textName={textGroupName} icon={groupIcon} />
          </View>
          <View style={styles.containerCompany}>
            <RectangleBox textName={textGroupName} icon={groupIcon} />
            <RectangleBox textName={textGroupName} icon={groupIcon} />
          </View>
          <View style={styles.containerCompany}>
            <RectangleBox textName={textGroupName} icon={groupIcon} />
            <RectangleBox textName={textGroupName} icon={groupIcon} />
          </View>
        </View>
      </View>
    </ScrollView>
  );
}
