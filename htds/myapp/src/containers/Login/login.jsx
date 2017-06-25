import React, {Component} from "react";
import {Link} from "react-router";
// import Helmet from "react-helmet";
 import {
    Navbar,
    NavbarHeader,
    Nav,
    Item,
    NavItem,
    NavbarItems,
    DropdownMenu,
    NavbarDropdown,
    NavDropdown,
    Checkbox,
    Radio,
    FormGroup,
    ControlLabel,
    Form,
    Col,
    Breadcrumb,
    FormControl,
    MenuItem,Button} from 'react-bootstrap';


export default class Login extends Component {

    handleFormSubmit(e){
        e.preventDefault();
        const username = this.refs.username;
        const password = this.refs.password;
        this.props.login({"username": username,"password":password});
        username.value = '';
        password.value = '';
        // request({
        //     url: 'http://localhost:8080/chat' ,
        //     method: 'POST',
        //     data: data,
        //     withCredentials: true
        // }).then(response => {
        //     if (response.status === 200) {
        //         dispatch(loginSuccess(response.data.message));
        //         dispatch(push('/'));
        //     } else {
        //         dispatch(loginError('Oops! Something went wrong!'));
        //     }
        // })
        //     .catch(err => {
        //         dispatch(loginError(err.data.message));
        //     });
        console.log("alert");
    };
    render() {
        //const {user, logout} = this.props;
        //const { children } = this.props;
        return (
            <div className='Home'>
                <Col smOffset={2} sm={6}>
                    <Form horizontal onSubmit={this.handleFormSubmit.bind(this)} role="form">
                        <FormGroup controlId="formHorizontalEmail">
                            <Col componentClass={ControlLabel} sm={3}>
                                User Name
                            </Col>
                            <Col sm={8}>
                                <FormControl type="email" ref="username" placeholder="Email Address" required="true" />
                            </Col>
                        </FormGroup>

                        <FormGroup controlId="formHorizontalPassword">
                            <Col componentClass={ControlLabel} sm={3}>
                                Password
                            </Col>
                            <Col sm={8}>
                                <FormControl type="password" ref="password" placeholder="Password" required="true"/>
                            </Col>
                        </FormGroup>

                        <FormGroup>
                            <Col smOffset={3} sm={9}>
                                <Checkbox>Remember me</Checkbox>
                            </Col>
                        </FormGroup>

                        <FormGroup>
                            <Col smOffset={3} sm={9}>
                                <Button type="submit" bsStyle='primary' onClick={this.handleFormSubmit.bind(this)}>
                                    Sign in
                                </Button>
                            </Col>
                        </FormGroup>
                    </Form>

                </Col>
            </div>
        );
    }
}
