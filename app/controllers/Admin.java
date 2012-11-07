/**
 * Copyright 2012 Winflow Financial Group Corporation.
 *      http://www.winflowfinancial.com
 */
package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

/**
 * Handles admin related responsibilities e.g. manage trade properties, users, etc.
 *
 * @author Jatinder Singh on 2012-11-07 at 12:57 PM
 */
@Security.Authenticated(Secured.class)
public class Admin extends Controller {
    public static Result index() {
        return ok("Coming in future");
    }
}
