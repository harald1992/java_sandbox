export const ROUTES = {
    "/": {
        title: "Home",
        template: "<app-login></app-login>",
        description:
            "This is the landing page containing links to other parts in the website",
    },
    login: {
        title: "Login",
        template: "<app-login></app-login>",
        description: "Login Page",
    },

    loggedIn: {
        title: "Logged In",
        template: "<app-logged-in></app-logged-in>",
        description: "User details page etc",
    },
    register: {
        title: "Register",
        template: "<app-register></app-register>",
        description: "Register Page",
    },
    404: {
        title: "404",
        template: "404: Not Found",
        description:
            "This page states that the page that is being navigated to does not exist",
    },
};

let previousRoute = { title: "", template: "", description: "" };

export const hashLocationHandler = async event => {
    console.log("new hashrouting event", event)
    let location = window.location.hash.replace("#", "");

    if (location.length === 0) {
        location = "/"; // if string has 0 characters
    }

  let route = {template: ''};

     route = ROUTES[404];

    for (const page in ROUTES) {
        if (location.includes(page)) {
            route = ROUTES[page];
        }
    }

    if (previousRoute && previousRoute === route) {
        // todo: use event.oldURL and event.newURL
        return;
    }
     // route = ROUTES[location] || ROUTES[404];

    document.title = route.title;

    const pageDescription = document.querySelector('meta[name="description"]');
    pageDescription?.setAttribute("content", route.description || "");

    const routerOutlet = document.querySelector("router-outlet");
    if (!routerOutlet) {
        return;
    }
    routerOutlet.innerHTML = route.template;

    previousRoute = route;
};

