import {makeRequest} from '../makeRequest';
export const SIGNIN_REQUEST = 'SIGNIN_REQUEST';
export const SIGNIN_SUCCESS = 'SIGNIN_SUCCESS';
export const SIGNIN_FAILURE = 'SIGNIN_FAILURE';

function requestSignin(creds) {
    return ({
        type: SIGNIN_REQUEST,
        isFetching: true,
        isAuthenticated: false,
        creds
    });
}

function receiveSignin(user){
    return ({
        type: SIGNIN_SUCCESS,
        isFetching: false,
        isAuthenticated: true,
        successMessage: "Signed in successfully",
        id_token: user.id_token,
        user
    });
}

function signinError(message) {
    return ({
        type: SIGNIN_FAILURE,
        isFetching: false,
        isAuthenticated: false,
        message
    });
}

export function signin(creds){
    const config = {
        api: 'http://localhost:8080/sme/api/login',
        method: "POST",
        headers: {
            "Access-Control-Allow-Origin": "*",
            "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8",
            "Access-Control-Allow-Headers": "X-Requested-With, Content-Type, X-Codingpedia"
        },
        data: creds
    }
    return dispatch => {
        dispatch(requestSignin({username:creds.username,password:creds.password}));
        return makeRequest(config.method,config.api,config.data,config.headers)
            .then(response => {
                if(response.status ===200){
                    localStorage.setItem('id_token', JSON.parse(response.data.user).id_token);
                    dispatch(receiveSignin(JSON.parse(response.data.user)));
                }else{
                    dispatch(signinError(response.data.message));
                    return Promise.reject(response.data);
                }
            }).catch((err) => {
                dispatch(signinError("Authentication Failed !"));
                console.error("Authentication Error: ")
            });
    }
}