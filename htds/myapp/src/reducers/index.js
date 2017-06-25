import {combineReducers} from "redux";
import user from "./userReducer";
import tweets from "./tweetsReducer";
import authenticate from "./authReducer";

export default combineReducers({
    user: user,
    tweets: tweets,
    authenticate: authenticate,
});