import React, {Component} from 'react';
import { Link } from 'react-router';
import { LinkContainer } from 'react-router-bootstrap';

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
export default class Menu extends Component {
    render() {
        const { children } = this.props;
        return (
            <div className='Menu'>
                <Navbar inverse collapseOnSelect>
                    <Navbar.Header>
                        <Navbar.Brand>
                            <Link to='/'>Home</Link>
                        </Navbar.Brand>
                        {/*<Navbar.Toggle />*/}
                    </Navbar.Header>
                    <Navbar.Collapse>
                        <Nav>
                            <LinkContainer to='/about'>
                                <NavItem eventKey={2} >About</NavItem>
                            </LinkContainer>
                            <LinkContainer to="/register">
                                <NavItem eventKey={3}>Register</NavItem>
                            </LinkContainer>
                            <LinkContainer to="/practice">
                                <NavItem eventKey={4}>Practice</NavItem>
                            </LinkContainer>
                        </Nav>
                        <Nav pullRight>
                            <LinkContainer to="/login">
                                <NavItem eventKey={0}>Login</NavItem>
                            </LinkContainer>
                            <LinkContainer to="/logout">
                                <NavItem eventKey={1}>Logout</NavItem>
                            </LinkContainer>
                        </Nav>
                    </Navbar.Collapse>
                </Navbar>
                { children }
            </div>
        );
    };
}