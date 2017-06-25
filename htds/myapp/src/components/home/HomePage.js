import React, {Component} from "react";
import {Link} from "react-router";
import {connect} from "react-redux";

@connect((store) =>{
    return {
        username: store.authenticate.user.name
    }
})
class App extends Component {
    render() {
        return (
            <div className='Home'>
                <h1>Welcome {this.props.username == null ?this.props.username:this.props.username.split(" ")[0]+"!"} </h1>
            </div>
        );
    }
}


export default App;