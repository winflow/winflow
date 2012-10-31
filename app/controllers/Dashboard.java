/**
 * Copyright 2012 Winflow Financial Group Corporation.
 *      http://www.winflowfinancial.com
 */
package controllers;

import play.mvc.*;

import views.html.*;
import play.mvc.Security;

/**
 * @author Jatinder Singh on 2012-10-31 at 2:28 PM
 */
@Security.Authenticated(Secured.class)
public class Dashboard extends Controller {

    public static Result index() {
        return ok(dashboard.render("helloworld"));
    }

}
