import { View, TextInput } from "react-native";
import React, { useState } from "react";

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

const styles = {
  input: {
    backgroundColor: "white",
    marginBottom: 20,
    borderRadius: 20,
    padding: 5,
  },
};
