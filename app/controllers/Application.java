package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import views.html.*;
import models.*;

public class Application extends Controller {

  /**
   *  Authentication
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
   *  Renders login page
   */
  public static Result login() {
    return ok(login.render(form(Login.class)));
  }


  /**
   *  Handles login form submission
   */
  public static Result authenticate() {
    Form<Login> loginForm = form(Login.class).bindFromRequest();
    if(loginForm.hasErrors()) {
      return badRequest(login.render(loginForm));
    } else {
      session("email", loginForm.get().email);
      return redirect(routes.Alerts.alerts());
    }    
  }

  /**
   *  Handles logout and cleans the session
   */
  public static Result logout() {
    session().clear();
    flash("success", "You've been logged out");;
    return redirect(routes.Application.login());
  }
}