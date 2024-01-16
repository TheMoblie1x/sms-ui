import React, { useState } from "react";
import { Text, TextInput, View, StyleSheet } from "react-native";
const YourComponent = () => {
  const [text, setText] = useState("");
  const [borderColor, setBorderColor] = useState("#CCCCCC"); // Initial border color
  const handleTextChange = (newText) => {
    // Handle the text change here
    setText(newText);
  };
  const onFocus = () => {
    // Change border color when TextInput is focused
    setBorderColor("#007AFF"); // You can set your desired color here
  };
  const onBlur = () => {
    // Change border color when TextInput loses focus
    setBorderColor("#CCCCCC"); // You can set your desired color here
  };
  return (
    <View>
      <Text>helo</Text>
      <Text>helo</Text>
      <Text>helo</Text>
      <Text>helo</Text>
      <Text>helo</Text>
      <Text>helo</Text>
      <Text>helo</Text>

      <TextInput
        value={text}
        onChangeText={handleTextChange}
        placeholder="Type something..."
        style={[styles.textInput, { borderColor }]}
        onFocus={onFocus}
        onBlur={onBlur}
      />
    </View>
  );
};
const styles = StyleSheet.create({
  textInput: {
    height: 40,
    borderColor: "gray",
    borderWidth: 1,
    padding: 10,
  },
});
export default YourComponent;
