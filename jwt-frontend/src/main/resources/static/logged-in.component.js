const template = /*html*/ `
        <h2>Logged In</h2>
        <button type="button" id="user-list-btn">Get user list!</button>
        <div id="user-list"></div>

<!--        <button type="button" onclick="getSession()">Get Session!</button>-->
        `;

export class LoggedInComponent extends HTMLElement {
    constructor() {
        super();
    }

    connectedCallback() {
        this.render();
    }

    render() {
        this.innerHTML = template;

        this.querySelector('#user-list-btn').addEventListener('click', this.getUserList);
    }

    getUserList() {
        const url = "http://localhost:8081/api/v1/user";

        fetch(url, {method: "GET", headers: {'withCredentials': 'true'}})
            .then(response => response.json())
            .then(body => {
              //  console.log(this);  // TODO:  this is the button here instead of the component, use document.queryS instead of this.queryS for now.
                document.querySelector("#user-list").innerHTML = body ? JSON.stringify(body)
                    :
                    "no users found or error"
            })
            .catch(error => console.error("Error occurred", error))
    };
}

window.customElements.define("app-logged-in", LoggedInComponent);


const getSession = () => {
    const url = 'http://localhost:8081/api/v1/session';

    fetch(url, {method: "GET", headers: {'withCredentials': 'true'}})
        .then(response => response.json())
        .then(body => console.log(body))
        .catch(error => console.error("Error occurred", error));

};
