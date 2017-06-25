import { combineReducers, createStore } from "redux";

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
        default:{

        }
    }
    return newState;
}

const tweetsReducer = (state=[],action) =>{
    return state;
}

const reducers = combineReducers({
    user: userReducer,
    tweets: tweetsReducer,
});

const store = createStore(reducers);

store.subscribe(() => {
    console.log("store changed: "+ store.getState()["user"]["name"]+" : "+ store.getState()["user"]["age"] )
});


store.dispatch({type: "CHANGE_NAME", payload: "PRABHAKAR"});
store.dispatch({type: "CHANGE_AGE", payload: 35});
store.dispatch({type: "CHANGE_AGE", payload: 36});
store.dispatch({type: "CHANGE_NAME", payload: "RAMESH"});



// <><>>>>><><><><><><><><><><><><><><>

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

const logger = (store) => (next) => (action) => {
          console.log("action logger: "+ action);
          next(action);
      }

      const error = (store) => (next) => (action) => {
          try {
          next(action);
      }catch(e) {
          console.log("Error: "+ e);
      }
      }

      const middleware = applyMiddleware(logger,error);

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

store.dispatch({type: "CHANGE_NAME"});
store.dispatch({type: "CHANGE_AGE"});
store.dispatch({type: "CHANGE_AGE"});
store.dispatch({type: "E"});