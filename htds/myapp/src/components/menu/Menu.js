import React, {Component} from 'react';
import { Link } from 'react-router';
import { LinkContainer } from 'react-router-bootstrap';
import {connect} from "react-redux";
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
@connect((store) =>{
    return {
        isAuthenticated: store.authenticate.isAuthenticated,
    }
},(dispatch) =>{
    return {
        requestSignin:(creds) =>{
            dispatch(signin(creds));
        }
    }
})
class Menu extends Component {
    render() {
        const { children,isAuthenticated } = this.props;
        return (
            <div className='Menu'>
                <Navbar inverse collapseOnSelect>
                    {isAuthenticated && <Navbar.Header>
                        <Navbar.Brand>
                            <Link to='/'>Home</Link>
                        </Navbar.Brand>
                        {/*<Navbar.Toggle />*/}
                    </Navbar.Header>}
                    <Navbar.Collapse>
                        {!isAuthenticated &&
                            <Nav pullRight>
                                <LinkContainer to="/login">
                                    <NavItem eventKey={0}>Login</NavItem>
                                </LinkContainer>
                                <LinkContainer to="/signup">
                                    <NavItem eventKey={5}>Signup</NavItem>
                                </LinkContainer>
                            </Nav>
                        }{ isAuthenticated &&
                            <div>
                                <Nav>
                                    {isAuthenticated && <LinkContainer to='/about'>
                                        <NavItem eventKey={2} >About</NavItem>
                                    </LinkContainer>}

                                </Nav>
                                <Nav pullRight>
                                    <LinkContainer to="/logout">
                                        <NavItem eventKey={1}>Logout</NavItem>
                                    </LinkContainer>
                                </Nav>
                            </div>
                        }
                    </Navbar.Collapse>
                </Navbar>
                { children }
            </div>
        );
    };
}

export default Menu;