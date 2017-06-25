import React, {Component} from "react";
import {Link} from "react-router";
import ReactDOM from "react-dom";
export default class SignupForm extends Component {
    constructor(props){
        super(props);
        this.handleOnChange = this.handleOnChange.bind(this);
        this.onFormSubmit = this.onFormSubmit.bind(this);

    }
    handleOnChange(e){

    }
    onFormSubmit(e){
        e.preventDefault();
        const name = ReactDOM.findDOMNode(this.refs.name).value;
        const password = ReactDOM.findDOMNode(this.refs.password).value;
        const email = ReactDOM.findDOMNode(this.refs.email).value;
        const phone = ReactDOM.findDOMNode(this.refs.phone).value;
        const details = {
            "name": name,
            "password": password,
            "email": email,
            "phone": phone
        }
        console.log(details);
        this.props.requestSignup(details);
    }
    render() {
        return (
            <form className="form form-horizontal" role="form" method="post" onSubmit={this.onFormSubmit}>
                <h1>Signup Form</h1>
                <div className="form-group">
                    <label className="control-label">Name</label>
                    <input type="text" ref="name" className="form-control" name="name"  onChange={this.handleOnChange} required="required"/>
                </div>
                <div className="form-group">
                    <label className="control-label">Password</label>
                    <input type="password" ref="password" className="form-control" name="password" onChange={this.handleOnChange} required="required"/>
                </div>
                <div className="form-group">
                    <label className="control-label">Email address</label>
                    <input type="email" ref="email" className="form-control" name="email" onChange={this.handleOnChange} required="required"/>
                </div>
                <div className="form-group">
                    <label className="control-label">Phone Number</label>
                    <input type="phone" ref="phone" className="form-control" name="phone" onChange={this.handleOnChange} required="true"/>
                </div>
                <div className="form-group">
                    <button className="btn btn-primary btn-md" onClick={this.onFormSubmit}> Signup</button>
                </div>
            </form>

        );
    }
}
// import {
//     Navbar,
//     NavbarHeader,
//     Nav,
//     Item,
//     NavItem,
//     NavbarItems,
//     DropdownMenu,
//     NavbarDropdown,
//     NavDropdown,
//     Checkbox,
//     Radio,
//     FormGroup,
//     ControlLabel,
//     Form,
//     Col,
//     HelpBlock,Glyphicon,InputGroup,
//     Breadcrumb,
//     FormControl,
//     MenuItem,Button} from 'react-bootstrap';


//
// <Form horizontal>
//     <FormGroup controlId="firstName" >
//         <Col sm={3}>
//             <ControlLabel>First Name</ControlLabel>
//         </Col>
//         <Col sm={8}>
//             <FormControl type="text"/>
//         </Col>
//     </FormGroup>
//
//     <FormGroup controlId="last name" >
//         <Col sm={3}>
//             <ControlLabel>Last Name</ControlLabel>
//         </Col>
//         <Col sm={8}>
//             <FormControl type="text" />
//         </Col>
//     </FormGroup>
//
//     <FormGroup controlId="password" >
//         <Col sm={3}>
//             <ControlLabel>Password</ControlLabel>
//         </Col>
//         <Col sm={8}>
//             <FormControl type="password" />
//         </Col>
//     </FormGroup>
//
//     <FormGroup controlId="email">
//         <Col sm={3}>
//             <ControlLabel >Email address</ControlLabel>
//         </Col>
//         <Col sm={8}>
//             <FormControl type="email" />
//         </Col>
//     </FormGroup>
//
//     <FormGroup controlId="phone">
//         <Col sm={3}>
//             <ControlLabel>Phone Number</ControlLabel>
//         </Col>
//         <Col sm={8}>
//             <FormControl type="phone" />
//         </Col>
//     </FormGroup>
//     <Button type="submit">
//         Submit
//     </Button>
// </Form>
