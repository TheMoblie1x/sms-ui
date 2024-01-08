import { View, Text, Image, StyleSheet, TouchableOpacity } from "react-native";
const userIcon = require("./icon/fi-bs-user.png");

export function RectangleBox() {
  return (
    <View style={rectangleStyle.rectangleBox}>
      <Image source={userIcon} />
      <Text style={{ marginTop: 20 }}>Company Name</Text>
    </View>
  );
}

const rectangleStyle = StyleSheet.create({
  rectangleBox: {
    width: 80,
    height: 150,
    marginLeft: 10,
    backgroundColor: "#d9d9d9",
    alignItems: "center",
    justifyContent: "center",
  },
});
