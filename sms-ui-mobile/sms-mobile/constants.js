let BASE_URL = "http://127.0.0.1:8080/";
let ERROR_NO_PATH_FOUND = "error no path found";
let API_PATH_LOGIN = "login";

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
