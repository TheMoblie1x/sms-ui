import { StyleSheet, Text, View } from "react-native";
import React, { useState } from "react";

export default styles = StyleSheet.create({
  containerMain: {
    flex: 5,
    backgroundColor: "#fff",
    alignItems: "center",
    justifyContent: "center",
    backgroundColor: "#86D2EC",
  },
  container: {
    top: 50,
    flex: 1,
    alignItems: "left",
    backgroundColor: "##86D2EC",
  },

  heading1: {
    textAlign: "left",
    marginTop: 20,
    marginBottom: 20,
    color: "black",
  },
  input: {
    backgroundColor: "white",
    marginBottom: 15,
    borderRadius: 20,
    padding: 5,
  },
  loginButton: {
    backgroundColor: "#1b3360",
    color: "#fff",
    padding: 10,
    borderRadius: 32,
    cursor: "pointer",
    height: 48,
    width: 300,
    justifyContent: "center",
    alignItems: "center",
    marginTop: 40,
  },
  containerLoginOp: {
    alignItems: "center",
    flexDirection: "row",
    marginTop: 20,
  },
  input: {
    backgroundColor: "white",
    marginBottom: 20,
    borderRadius: 20,
    padding: 5,
  },
});
