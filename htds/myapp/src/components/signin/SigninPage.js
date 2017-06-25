import React, {Component,PropTypes} from "react";
import {connect } from "react-redux";
import {Link} from "react-router";

import SigninForm from "./SigninForm";
import {signin} from "../../actions/authActions/signinAction";

@connect((store) =>{
    return {
        errorMessage: store.authenticate.errorMessage,
        successMessage: store.authenticate.successMessage
    }
},(dispatch) =>{
    return {
        requestSignin:(creds) =>{
            dispatch(signin(creds));
        }
    }
})
class SigninPage extends Component {
    render() {
        return (
            <div className="row">
                 <div className="col-md-4 col-md-offset-4">
                    <h1>Signin</h1>
                    <SigninForm {...this.props} requestSignin={(creds) => {this.props.requestSignin(creds)}} errorMessage={this.props.errorMessage} successMessage={this.props.successMessage}/>

                </div>
            </div>
        );
    }
}
SigninPage.propTypes = {
    //requestSignin: React.PropTypes.func.isRequired,
    // signin: React.PropTypes.func.isRequired,
    // signout: React.PropTypes.func.isRequired,
};

export default SigninPage;
