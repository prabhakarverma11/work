export const SIGNOUT_REQUEST = 'SIGNOUT_REQUEST';
export const SIGNOUT_SUCCESS = 'SIGNOUT_SUCCESS';
export const SIGNOUT_FAILURE = 'SIGNOUT_FAILURE';



function requestSignout() {
    return {
        type: SIGNOUT_REQUEST,
        isFetching: true,
        isAuthenticated: true
    }
}

function receiveSignout() {
    return {
        type: SIGNOUT_SUCCESS,
        isFetching: false,
        isAuthenticated: false,
        successMessage: ""
    };
}

function signoutError() {
    return {
        type: SIGNOUT_FAILURE,
        isFetching: false,
        isAuthenticated: true,
        errorMessage: "Cound not signout"
    };
}

export function signout() {
    return dispatch => {
        dispatch(requestSignout());
        try {
            localStorage.removeItem('id_token');
        } catch (err){
            dispatch(signoutError());
        };
        dispatch(receiveSignout());
        return ;
    }
}
