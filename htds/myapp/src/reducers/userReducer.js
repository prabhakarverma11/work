export default function reducer(state={
    user: {
        id: null,
        name: null,
        age: null
    },
    fetching: false,
    fetched: false,
    error: null,
}, action){
    const newState = Object.assign({},state);
    switch (action.type) {
        case "FETCH_USER": {
            newState.fetching= true;
            break;
        }
        case "FETCH_USER_REJECTED": {
            newState.fetching = false;
            newState.error =  action.payload;
            break;
        }
        case "FETCH_USER_FULFILLED": {
            newState.fetching = false,
            newState.fetched = true,
            newState.user = action.payload;
            break;
        }
        case "SET_USER_NAME": {
            newState.user.name = action.payload;
            break;
        }
        case "SET_USER_AGE": {
            newState.user.age = action.payload;
            break;
        }
    }
    return newState;
};