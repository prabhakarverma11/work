import {combineReducers} from "redux";
import {SIGNIN_REQUEST,SIGNIN_FAILURE,SIGNIN_SUCCESS} from "../actions/authActions/signinAction";
import {SIGNUP_REQUEST,SIGNUP_FAILURE,SIGNUP_SUCCESS} from "../actions/authActions/signupAction";
import {SIGNOUT_REQUEST, SIGNOUT_FAILURE, SIGNOUT_SUCCESS} from "../actions/authActions/signoutAction";

const isFetching = (
        state = false,
        action
    ) => {
        switch (action.type) {
            case SIGNIN_REQUEST:
            case SIGNOUT_REQUEST:
            case SIGNUP_REQUEST:
                return true;
            case SIGNIN_SUCCESS:
            case SIGNIN_FAILURE:
            case SIGNOUT_SUCCESS:
            case SIGNOUT_FAILURE:
            case SIGNUP_SUCCESS:
            case SIGNUP_FAILURE:
                return false;
            default:
                return state;
        }
};

const isAuthenticated = (
        state = localStorage.getItem('id_token'),
        action
    ) => {
        switch (action.type) {
            case SIGNIN_SUCCESS:
            case SIGNOUT_FAILURE:
                return true;
            case SIGNIN_REQUEST:
            case SIGNIN_FAILURE:
            case SIGNOUT_REQUEST:
            case SIGNOUT_SUCCESS:
            case SIGNUP_REQUEST:
            case SIGNUP_SUCCESS:
            case SIGNUP_FAILURE:
                return false;
            default:
                return state;
        }
};

const errorMessage = (
        state = '',
        action
    ) => {
        switch (action.type) {
            case SIGNIN_REQUEST:
            case SIGNIN_SUCCESS:
            case SIGNOUT_REQUEST:
            case SIGNOUT_SUCCESS:
            case SIGNUP_REQUEST:
            case SIGNUP_SUCCESS:
                return '';
            case SIGNIN_FAILURE:
            case SIGNOUT_FAILURE:
            case SIGNUP_FAILURE:
                return action.message;
            default:
                return state;
        }
};

const successMessage = (
    state = '',
    action
) => {
    switch (action.type) {
        case SIGNIN_SUCCESS:
        case SIGNOUT_SUCCESS:
        case SIGNUP_SUCCESS:
            return action.successMessage;
        case SIGNIN_FAILURE:
        case SIGNIN_REQUEST:
        case SIGNOUT_REQUEST:
        case SIGNOUT_FAILURE:
        case SIGNUP_FAILURE:
        case SIGNUP_REQUEST:
            return '';
        default:
            return state;
    }
};

const user = (
        state = {},
        action
    ) => {
    switch (action.type) {
        case SIGNIN_REQUEST:
            return {};
        case SIGNUP_REQUEST:
            return action.details;
        case SIGNIN_SUCCESS:
            console.log("Hi from authReducer: user: ");
            console.log(action.user);
            return action.user;
        case SIGNIN_FAILURE:
        case SIGNOUT_REQUEST:
        case SIGNOUT_SUCCESS:
        case SIGNOUT_FAILURE:
        case SIGNUP_SUCCESS:
        case SIGNUP_FAILURE:
            return {};
        default:
            return state;
    }
};

const idToken = (
    state = '',
    action
    ) => {
    switch (action.type) {
        case SIGNIN_SUCCESS:
            return action.id_token;
        case SIGNIN_REQUEST:
        case SIGNIN_FAILURE:
        case SIGNOUT_REQUEST:
        case SIGNOUT_SUCCESS:
        case SIGNOUT_FAILURE:
        case SIGNUP_SUCCESS:
        case SIGNUP_FAILURE:
        case SIGNUP_REQUEST:
            return '';
        default:
            return state;
    }
};

const authReducer = combineReducers({
    isFetching,
    isAuthenticated,
    errorMessage,
    user,
    successMessage,
    idToken,
});

export default authReducer;