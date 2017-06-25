import React, {Component} from "react";
import {Link} from "react-router";
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
    HelpBlock,Glyphicon,InputGroup,
    Breadcrumb,
    FormControl,
    MenuItem,Button} from 'react-bootstrap';
export default class Register extends Component {
    render() {
        const { children } = this.props;

        return (
            <div className='Register'>
                <Col smOffset={2} sm={8}>
                     <Form horizontal>
                        <FormGroup controlId="firstName" >
                            <Col sm={3}>
                                <ControlLabel>First Name</ControlLabel>
                            </Col>
                            <Col sm={8}>
                                <FormControl type="text"/>
                            </Col>
                        </FormGroup>

                        <FormGroup controlId="last name" >
                            <Col sm={3}>
                                <ControlLabel>Last Name</ControlLabel>
                            </Col>
                            <Col sm={8}>
                                <FormControl type="text" />
                            </Col>
                        </FormGroup>

                        <FormGroup controlId="password" >
                            <Col sm={3}>
                                <ControlLabel>Password</ControlLabel>
                            </Col>
                            <Col sm={8}>
                                <FormControl type="password" />
                            </Col>
                        </FormGroup>

                        <FormGroup controlId="email">
                            <Col sm={3}>
                                <ControlLabel >Email address</ControlLabel>
                            </Col>
                            <Col sm={8}>
                                <FormControl type="email" />
                            </Col>
                        </FormGroup>

                        <FormGroup controlId="phone">
                            <Col sm={3}>
                                <ControlLabel>Phone Number</ControlLabel>
                            </Col>
                            <Col sm={8}>
                                <FormControl type="phone" />
                            </Col>
                        </FormGroup>
                        <Button type="submit">
                            Submit
                        </Button>
                    </Form>
                </Col>
            </div>
        );
    }
}