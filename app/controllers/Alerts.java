package controllers;

import play.mvc.*;
import play.data.*;

import models.*;

@Security.Authenticated(Secured.class)
public class Alerts extends Controller {
	static Form<Alert> alertForm = form(Alert.class);

	/**
   * 	Result represents HTTP Response to send back to 
	 *	the web browser.
	 */
  public static Result index() {
  	return redirect(routes.Alerts.alerts());
  }

  public static Result alerts() {
  	return ok(views.html.index.render(Alert.all(), alertForm));
  }

  public static Result newAlert() {
  	// We use bindFormRequest to create a new form filled
  	// with the request data. If there are any errors in
  	// the form, we redisplay it (here we use 400 Bad Request
  	// instead of 200 OK). If there are no errors, we create
  	// the alert and then redirect to the alerts list.
  	Form<Alert> filledForm = alertForm.bindFromRequest();

  	if(filledForm.hasErrors()) {
  		return badRequest(views.html.index.render(Alert.all(), filledForm));
  	} else {
  		Alert.create(filledForm.get());
  		return redirect(routes.Alerts.alerts());
  	}		

  }

  public static Result deleteAlert(Long id) {
  	Alert.delete(id);
  	return redirect(routes.Alerts.alerts());
  }
}