/**
 * Copyright 2012 Winflow Financial Group Corporation.
 *      http://www.winflowfinancial.com
 */
package controllers;

import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;
import views.html.dashboard;

import java.io.File;

/**
 * @author Jatinder Singh on 2012-10-31 at 5:46 PM
 */
@Security.Authenticated(Secured.class)
public class Portfolios extends Controller {

    public static Result index() {
        return ok(dashboard.render("I'm Index"));
    }

    /**
     * Creates a portfolio by downloading the provided broker
     * file and broker name information
     *
     * @return
     */
    public static Result create() {
        Http.MultipartFormData body = request().body().asMultipartFormData();
        Http.MultipartFormData.FilePart picture = body.getFile("picture");

        if (picture != null) {
            String fileName = picture.getFilename();
            String contentType = picture.getContentType();
            File file = picture.getFile();
            return ok("File uploaded");
        } else {
            flash("error", "Missing file");
            return redirect(routes.Dashboard.index());
        }
    }
}
