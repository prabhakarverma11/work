import React from 'react';
import ReactDOM from 'react-dom';
import {Provider} from "react-redux";
import store from "./store";
import createRoutes from './components/Routes';
import { Router, browserHistory } from 'react-router';

const initialState = window.__INITIAL_STATE__;

const routes = createRoutes(store);

function onUpdate(){
    console.log("Hi from onUpdate method of app.js");
}


ReactDOM.render(
    <Provider store={store}>
        <Router history={ browserHistory}>
            {routes}
        </Router>
    </Provider>,
    document.getElementById('root')
);