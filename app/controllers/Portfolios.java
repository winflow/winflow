/**
 * Copyright 2012 Winflow Financial Group Corporation.
 *      http://www.winflowfinancial.com
 */
package controllers;

import models.ActiveTrade;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;
import views.html.portfolios.show;
import views.html.portfolios.index;

import java.util.List;

import static play.mvc.Http.MultipartFormData.FilePart;

/**
 * @author Jatinder Singh on 2012-10-31 at 5:46 PM
 */
@Security.Authenticated(Secured.class)
public class Portfolios extends Controller {

    public static Result index() {
        return ok(index.render());
    }

    public static Result show() {
        return ok(show.render(ActiveTrade.findAll()));
    }

    /**
     * Uploads active trades from a CSV file
     *
     * @return
     */
    public static Result upload() {
        Http.MultipartFormData body = request().body().asMultipartFormData();
        FilePart activeTrades = body.getFile("activeTrades");
        String brokerage = request().body().asMultipartFormData().asFormUrlEncoded().get("brokerage")[0];

        if(activeTrades != null) {
            ActiveTrade.create(activeTrades.getFile(), brokerage);
            return redirect(routes.Portfolios.show());
        } else {
            return ok("File NOT available");
        }
    }
}
