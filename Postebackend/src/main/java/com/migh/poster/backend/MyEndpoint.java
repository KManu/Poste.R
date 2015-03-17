/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.migh.poster.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import java.util.Calendar;
import java.util.TimeZone;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(name = "myApi", version = "v1", namespace = @ApiNamespace(ownerDomain = "backend.poster.migh.com", ownerName = "backend.poster.migh.com", packagePath = ""))
public class MyEndpoint {

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();
        Calendar curCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

        String sendBackDate = "\nDate: "+curCal.get(Calendar.DATE)+
                "\nTime: "+curCal.get(Calendar.HOUR)+":"+curCal.get(Calendar.MINUTE)+":"+curCal.get(Calendar.SECOND)
                +"\nYear: "+curCal.get(Calendar.YEAR);



        response.setData("Current Date and time is: " + sendBackDate);

        return response;
    }

}
