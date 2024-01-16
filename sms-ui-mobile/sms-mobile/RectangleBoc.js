import { View, Text, Image, StyleSheet, TouchableOpacity } from "react-native";

export function RectangleBox({ textName, icon }) {
  return (
    <View style={rectangleStyle.rectangleBox}>
      <Image source={icon} />
      <Text style={{ marginTop: 20 }}>{textName}</Text>
    </View>
  );
}

const rectangleStyle = StyleSheet.create({
  rectangleBox: {
    width: 150,
    height: 150,
    margin: 10,
    backgroundColor: "#d9d9d9",
    alignItems: "center",
    justifyContent: "center",
  },
});
