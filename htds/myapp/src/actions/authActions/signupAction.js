import {makeRequest} from '../makeRequest';
export const SIGNUP_REQUEST = 'SIGNIN_REQUEST';
export const SIGNUP_SUCCESS = 'SIGNIN_SUCCESS';
export const SIGNUP_FAILURE = 'SIGNIN_FAILURE';


function requestSignup(details) {
    return ({
        type: SIGNUP_REQUEST,
        isFetching: true,
        details
    });
}

function receiveSignup(user){
    return ({
        type: SIGNUP_SUCCESS,
        isFetching: false,
        successMessage: "Signed up successfully",
        user
    });
}

function signupError(message) {
    return ({
        type: SIGNUP_FAILURE,
        isFetching: false,
        message
    });
}

export function signup(details) {
    const config = {
        api: 'http://localhost:8080/sme/api/signup',
        method: "POST",
        headers: {
            "Access-Control-Allow-Origin": "*",
            "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8",
            "Access-Control-Allow-Headers": "X-Requested-With, Content-Type, X-Codingpedia"
        },
        data: details
    };
    return dispatch => {
        console.log("hi from authActions");
        dispatch(requestSignup(details));
        return makeRequest(config.method,config.api,config.data,config.headers)
            .then(response => {
                if(response.status ===200){
                    console.log("receiving data for signup");
                    console.log(response.data);
                    dispatch(receiveSignup(JSON.parse(response.data)));
                }else{
                    dispatch(signupError(response.data));
                    return Promise.reject(response.data);
                }
            }).catch((err) => {
                dispatch(signupError("Authentication Failed !"));
                console.error("Authentication Error: ")
            });
    }
}