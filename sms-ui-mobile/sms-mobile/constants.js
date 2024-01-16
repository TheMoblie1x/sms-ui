//BASE Path goes here
let BASE_URL = "http://127.0.0.1:8080/";

//Message goes here
let ERROR_NO_PATH_FOUND = "error no path found";
let MSG_LOGIN_SUCCESS = "Logged in successfully"
//API Path goes here
let API_PATH_LOGIN = "login";

//Constant String Go here


function getBaseUrl() {
  return BASE_URL;
}

function getApiUrlFor(path) {
  if (isStringNullOrEmpty(path)) {
    return ERROR_NO_PATH_FOUND;
  } else {
    return BASE_URL + path;
  }
}
function isStringNullOrEmpty(value) {
  return value == null || value === null || value == "" || value === "";
}
