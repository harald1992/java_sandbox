const template = /*html*/ `
   <h2>Log in here</h2>
   <br>
   
   <form id="loginForm" class="form">
    <label>
        User Name: *
        <input type="text" name="username" id="username" placeholder="postgres">
    </label>
    <label>
        Password: *
        <input type="text" name="password" id="password" placeholder="root">
    </label>
    <button type="button"">Log in</button>
</form>
`;


export class LoginComponent extends HTMLElement {
    constructor() {
        super();
    }

    connectedCallback() {
        this.render();
    }

    render() {
        this.innerHTML = template;

        this.querySelector('button').addEventListener('click', this.submitLoginForm);
    }

    submitLoginForm() {
        const url = "http://localhost:8081/api/v1/auth/login";
        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;

        fetch(url,
            {method: "POST", headers: {'Content-Type': 'application/json'}, body: JSON.stringify({username, password})}
        )
            .then(response => {

                if (response.ok) {
                    window.location.hash = "loggedIn";

                } else {
                    console.error("Login failed");
                    // Handle failed login (e.g., display an error message)
                }
            })

            .catch(error => console.error("Error occurred", error))
    }
    ;
}

window.customElements.define("app-login", LoginComponent);