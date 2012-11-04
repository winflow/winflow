/**
 * Copyright 2012 Winflow Financial Group Corporation.
 *      http://www.winflowfinancial.com
 */
package models;

import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.libs.F.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

/**
 * @author Jatinder Singh on 2012-11-04 at 2:36 AM
 */
public class UserTest {

    @Test
    public void findUserByEmail() {
        running(fakeApplication(inMemoryDatabase()), new Runnable() {
            @Override
            public void run() {
                User user = User.findByEmail("jsingh@gmail.com");

                assertThat(user).isNotNull();
                assertThat(user.firstName).isEqualTo("Jatinder");
                assertThat(user.lastName).isEqualTo("Singh");
            }
        });
    }
}
