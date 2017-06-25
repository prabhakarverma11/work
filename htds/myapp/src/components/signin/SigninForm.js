import React, {Component,PropTypes} from "react";
import {Link} from "react-router";
import ReactDOM from "react-dom";
export default class SigninForm extends Component {
    constructor(props){
        super(props);
    }
    onFormSubmit = (e) =>{
        e.preventDefault();
        //const {dispatch} = this.props;
        const username = ReactDOM.findDOMNode(this.refs.username).value;
        const password = ReactDOM.findDOMNode(this.refs.password).value;
        const creds = { "username": username.trim(), "password": password.trim() };
        console.log(creds);
        this.props.requestSignin(creds);

    }
    render() {
        const { errorMessage,successMessage } = this.props;
        return (
            <form className="form form-horizontal" role="form" method="post" onSubmit={this.onFormSubmit}>
                <div className="form-group">
                    <label className="control-label">Username</label>
                    <input type="text" ref="username" className="form-control"/>
                </div>
                <div className="form-group">
                    <label className="control-label">Password</label>
                    <input type="password" ref="password" className="form-control"/>
                </div>
                <div className="form-group">
                    <button className="btn btn-primary btn-md" onClick={this.onFormSubmit}> Signin</button>
                </div>

                <div className="form-group">
                    {
                        errorMessage &&
                        <div className="alert alert-danger fade in">{errorMessage}</div>
                    }
                    {
                        successMessage &&
                        <div className="alert alert-success fade in">{successMessage}</div>
                    }
                </div>
            </form>

        );
    }
}
SigninForm.propTypes = {
    // signin: PropTypes.func.isRequired,
    // errorMessage: PropTypes.string
}