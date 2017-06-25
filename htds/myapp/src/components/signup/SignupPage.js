import React, {Component} from "react";
import {Link} from "react-router";
import SignupForm from "./SignupForm";
import {connect } from "react-redux";
import {signup} from "../../actions/authActions/signupAction";
@connect(null,(dispatch) =>{
    return {
        requestSignup:(details) =>{
            //console.log(details);
            dispatch(signup(details));
        }
    }
})
export default class SignupPage extends Component {
    render() {
        return (
            <div className="row">
                <div className="col-md-4 col-md-offset-4">
                    <SignupForm {...this.props} requestSignup={(details) => {this.props.requestSignup(details)}} errorMessage={this.props.errorMessage} successMessage={this.props.successMessage}/>
                </div>
            </div>
        );
    }
}
// (store) =>{
//     return {
//         errorMessage: store.authenticate.errorMessage,
//         successMessage: store.authenticate.successMessage
//     }
// }