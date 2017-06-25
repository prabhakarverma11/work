import React, {Component} from "react";
import {Link} from "react-router";
import Home from './Home';
import {
    Navbar,
    // NavbarHeader,
    Nav,
    // Item,
    NavItem,
    // NavbarItems,
    // DropdownMenu,
    // NavbarDropdown,
    NavDropdown,
    // Checkbox,
    // Radio,
    FormGroup,
    // ControlLabel,
    // Form,
    // Col,
    // Breadcrumb,
    FormControl,
    MenuItem,Button} from 'react-bootstrap';
export default class Logout extends Component {
    render() {
        const { children } = this.props;

        return (
            <div className='Logout'>
                <h3>You've been logged out</h3>
                <Home />
            </div>
        );
    }
}