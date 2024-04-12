const template = /*html*/ `
   <h2>Register</h2>
`;

export class RegisterComponent extends HTMLElement {
    constructor() {
        super();
    }

    connectedCallback() {
        this.render();
    }

    render() {
        this.innerHTML = template;
    }
}

window.customElements.define("app-register", RegisterComponent);