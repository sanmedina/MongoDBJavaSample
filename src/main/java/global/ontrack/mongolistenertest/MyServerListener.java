/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package global.ontrack.mongolistenertest;

import com.mongodb.event.ServerClosedEvent;
import com.mongodb.event.ServerDescriptionChangedEvent;
import com.mongodb.event.ServerListener;
import com.mongodb.event.ServerOpeningEvent;

/**
 *
 * @author sanmedina
 */
public class MyServerListener implements ServerListener {

    @Override
    public void serverOpening(ServerOpeningEvent event) {
        System.out.println("Opening");
        System.out.println(event.toString());
    }

    @Override
    public void serverClosed(ServerClosedEvent event) {
        System.out.println("Closed");
        System.out.println(event.toString());
    }

    @Override
    public void serverDescriptionChanged(ServerDescriptionChangedEvent event) {
        System.out.println("Changed");
        System.out.println(event.toString());
    }
    
}
