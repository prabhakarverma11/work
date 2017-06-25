import React,{PropTypes} from 'react';
import {connect } from "react-redux";
import { Router, browserHistory } from 'react-router';
import createRoutes from './Routes';
import { syncHistoryWithStore } from 'react-router-redux';
import store from "../store";

@connect((store)=>{
    return {
        user: store.user.user,
        tweets: store.tweets.tweets,
        authenticate: store.authenticate.authenticate
    };
})
export default class Layout extends React.Component{
    render(){
        const routes = createRoutes(store);

        return (
            <Router history={ browserHistory} >
                {routes}
            </Router>
        );
    }
}