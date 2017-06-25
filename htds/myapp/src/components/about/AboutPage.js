import React, {Component} from "react";
import {Link} from "react-router";
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
export default class About extends Component {
    render() {
        const { children } = this.props;

        return (
            <div className='About'>

                <Navbar>
                    <Navbar.Header>
                        <Navbar.Brand>
                            <a href="#">Brand</a>
                        </Navbar.Brand>
                        <Navbar.Toggle />
                    </Navbar.Header>
                    <Navbar.Collapse>
                        <Navbar.Form pullLeft>
                            <FormGroup>
                                <FormControl type="text" placeholder="Search" />
                            </FormGroup>
                            {' '}
                            <Button type="submit">Submit</Button>
                        </Navbar.Form>
                    </Navbar.Collapse>
                </Navbar>
            </div>
        );
    }
}