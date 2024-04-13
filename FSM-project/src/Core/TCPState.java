
package Core;

import Fsm.State;

public class TCPState extends State {
 
    private String stateName;

    public TCPState(String stateName) {
        super(stateName); 
        this.stateName = stateName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }   
}
