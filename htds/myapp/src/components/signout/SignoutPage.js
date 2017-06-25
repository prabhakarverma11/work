import React, {Component} from "react";
import {Link} from "react-router";
import {connect} from "react-redux";
import SigninForm from "../signin/SigninForm";
import {signout} from "../../actions/authActions/signoutAction";
import {Navbar, Nav, NavItem, NavDropdown, FormGroup, FormControl, MenuItem,Button} from 'react-bootstrap';

@connect((store) =>{
    return {
        errorMessage: store.authenticate.errorMessage,
        successMessage: store.authenticate.successMessage
    }
},(dispatch) =>{
    return {
        requestSignin:(creds) =>{
            dispatch(signin(creds));
        },
        requestSignout: () =>{
            dispatch(signout());
        }
    }
})
class SignoutPage extends Component {
    componentWillMount(){
        this.props.requestSignout();
    }
    render() {
        const { children } = this.props;
        return (
            <div className="row">
                <div className="col-md-4 col-md-offset-4">
                    <h3>You've been logged out</h3>
                    {/*<SigninForm {...this.props} requestSignin={(creds) => {this.props.requestSignin(creds)}} errorMessage={this.props.errorMessage} successMessage={this.props.successMessage}/>*/}
                </div>
            </div>
        );
    }
}

export default SignoutPage;