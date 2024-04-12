import {ROUTES} from "./hash-router.js";

const template = /*html*/ `
<header class="header">
    <h1>Jwt Frontend</h1>
    <div class="d-flex" id="links"></div>
    <button type="button" onclick="logout()" id="loginOutBtn">Log Out!</button>
</header>
`;

export class HeaderComponent extends HTMLElement {
    loggedIn = false;

    constructor() {
        super();
    }

    connectedCallback() {
        this.render();
    }

    render() {
        this.innerHTML = template;

        this.querySelector("#links").innerHTML =
            Object.entries(ROUTES)
                .filter(([key, value]) => key !== "404")
                .map(([key, value]) =>
                    `<a href="#${key}">${value.title}`
                ).join("");


        const logInOutBtn = this.querySelector('#loginOutBtn');
        if (this.loggedIn) {
            logInOutBtn.innerHTML = this.loggedIn ? '<button type="button" onclick="logout()" id="loginOutBtn">Log Out!</button>'
                :
                '<button type="button" onclick="login()" id="loginOutBtn">Log In!</button>';
        }
    }
}

window.customElements.define("app-header", HeaderComponent);

const
    logout = () => {
        const url = 'http://localhost:8081/api/v1/login/logout';

        fetch(url, {method: "GET", headers: {'withCredentials': 'true'}})
            .then(response => response.json())
            .then(body => {
                document.querySelector('#loginStatus').innerHTML = 'Uitgelogd';
            })
            .catch(error => console.error("Error occurred", error));

    };

const login = () => {

}
