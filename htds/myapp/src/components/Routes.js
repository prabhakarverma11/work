import React from 'react';
import { Router, Route, IndexRoute } from 'react-router';

import Menu from './menu/Menu';
import HomePage from './home/HomePage';
import AboutPage from './about/AboutPage';
import SigninPage from './signin/SigninPage';
import SignoutPage from './signout/SignoutPage';
import SignupPage from './signup/SignupPage';
import TestingPage from './test/TestingPage';


export default (store) =>{
    const requireAuth = (nextState, replace, callback) => {
        const { authenticate: { isAuthenticated }} = store.getState();
        if (!isAuthenticated) {
            replace({
                pathname: '/login',
                state: { nextPathname: nextState.location.pathname }
            });
        }
        callback();
    };
    const redirectAuth = (nextState, replace, callback) => {
        const { authenticate: { isAuthenticated }} = store.getState();
        if (isAuthenticated) {
            replace({
                pathname: '/'
            });
        }
        callback();
    };

    return (
        <Route path='/' name="Menu" component={ Menu }>
            <IndexRoute component={ HomePage } name="Home" onEnter={requireAuth}/>
            <Route path='about' component={ AboutPage } name="About" onEnter={requireAuth}/>
            <Route path='login' component={ SigninPage} name="Login" onEnter={redirectAuth}/>
            <Route path='logout' component={ SignoutPage } name="Logout"/>
            <Route path='signup' component={ SignupPage } name="Signup"/>
            <Route path="*" component={ TestingPage } name="Testing"/>
        </Route>
    );
}