import {hashLocationHandler} from "./hash-router.js";
import {HeaderComponent} from "./header.component.js";
import {LoginComponent} from "./login.component.js";
import {LoggedInComponent} from "./logged-in.component.js";
import {RegisterComponent} from "./register.component.js";

window.addEventListener("hashchange", hashLocationHandler);
window.location.hash = "/";

 const components = [
     HeaderComponent, LoginComponent, RegisterComponent, LoggedInComponent
];


