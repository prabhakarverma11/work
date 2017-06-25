import { applyMiddleware, combineReducers, createStore } from "redux";
import { createLogger } from 'redux-logger'

const userReducer = (state={}, action) =>{
    const newState = Object.assign({},state);
    switch (action.type){
        case "CHANGE_NAME":{
            newState.name = action.payload;
            break;
        }
        case "CHANGE_AGE":{
            newState.age = action.payload;
            break;
        }
        case "E":{
            throw new Error("E");
            break;
        }
        default:{

        }
    }
    return newState;
};


const middleware = applyMiddleware(createLogger());

const tweetsReducer = (state=[],action) =>{
    return state;
};

const reducers = combineReducers({
    user: userReducer,
    tweets: tweetsReducer,
});

const store = createStore(reducers,middleware);

store.subscribe(()=>{
   console.log("store changed"+store.getState());
});

store.dispatch({type: "CHANGE_NAME", payload: "PRABHAKAR"});
store.dispatch({type: "CHANGE_AGE", payload: 35});
store.dispatch({type: "CHANGE_AGE", payload: 36});
store.dispatch({type: "CHANGE_NAME", payload: "RAMESH"});