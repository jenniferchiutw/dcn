
package Core;

import Fsm.Event;

public class TCPEvent extends Event {
    
    private String eventName;
    
    public TCPEvent(String eventName) {
        
        super(eventName);
        this.eventName = eventName;
    }

    public String getEventName() {
        return eventName;
    }
    
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

}
