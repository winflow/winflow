/**
 * Copyright 2012 Winflow Financial Group Corporation.
 *      http://www.winflowfinancial.com
 */
package controllers;

import play.mvc.*;
import play.data.*;

import views.html.*;
import models.*;

public class Application extends Controller {

    /**
     * Authentication
     */
    public static class Login {
        public String email;
        public String password;

        public String validate() {
            if(User.authenticate(email, password) == null) {
                return "Invalid user or password";
            }
            return null;
        }
    }

    /**
     * Renders login page
     * @return
     */
    public static Result login() {
        return ok(login.render(form(Login.class)));
    }


    /**
     * Handles login form submission
     * @return
     */
    public static Result authenticate() {
        Form<Login> loginForm = form(Login.class).bindFromRequest();

        if(loginForm.hasErrors()) {
            return badRequest(login.render(loginForm));
        } else {
            session("email", loginForm.get().email);
            return redirect(routes.Dashboard.index());
        }
    }

    /**
     * Handles logout and cleans the session
     * @return
     */
    public static Result logout() {
        session().clear();
        flash("success", "You've been logged out");;
        return redirect(routes.Application.login());
    }
}