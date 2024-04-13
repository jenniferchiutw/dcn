

import java.util.*;
import Fsm.Event;
import Fsm.FSM;
import Fsm.Transition;
import Fsm.FsmException;
import Fsm.State;
import Core.TCPEvent;
import Core.TCPState;
import Core.TCPAction;

public class TCPStateMachine {
        static Map<String, State> mapState;
        static Map<String, Event> mapEvent;

        public static void main(String[] args) {
                mapState = new HashMap<>();
                mapEvent = new HashMap<>();
                buildState(mapState);
                buildEvent(mapEvent);

                FSM myFSM = new FSM("myFSM", mapState.get("LISTEN"));
                addTran(myFSM);

                Scanner sc = new Scanner(System.in);
                while (sc.hasNext()) {
                        String s1 = sc.next();
                        if (s1.equals("exit"))
                                break;
                        try {
                                Event curEvent = mapEvent.get(s1);
                                myFSM.doEvent(curEvent);
                        } catch (FsmException e) {
                                System.out.print(e.toString());
                        }
                }
        }

        private static void buildState(Map<String, State> mapState) {
                mapState.put("CLOSED", new TCPState("CLOSED"));
                mapState.put("LISTEN", new TCPState("LISTEN"));
                mapState.put("SYN_SENT", new TCPState("SYN_SENT"));
                mapState.put("SYN_RCVD", new TCPState("SYN_RCVD"));
                mapState.put("ESTABLISHED", new TCPState("ESTABLISHED"));
                mapState.put("FIN_WAIT_1", new TCPState("FIN_WAIT_1"));
                mapState.put("CLOSE_WAIT", new TCPState("CLOSE_WAIT"));
                mapState.put("FIN_WAIT_2", new TCPState("FIN_WAIT_2"));
                mapState.put("CLOSING", new TCPState("CLOSING"));
                mapState.put("LAST_ACK", new TCPState("LAST_ACK"));
                mapState.put("TIME_WAIT", new TCPState("TIME_WAIT"));
        }

        private static void buildEvent(Map<String, Event> mapEvent) {
                mapEvent.put("PASSIVE", new TCPEvent("PASSIVE"));
                mapEvent.put("ACTIVE", new TCPEvent("ACTIVE"));
                mapEvent.put("SYN", new TCPEvent("SYN"));
                mapEvent.put("SYNACK", new TCPEvent("SYNACK"));
                mapEvent.put("ACK", new TCPEvent("ACK"));
                mapEvent.put("RDATA", new TCPEvent("RDATA"));
                mapEvent.put("SDATA", new TCPEvent("SDATA"));
                mapEvent.put("FIN", new TCPEvent("FIN"));
                mapEvent.put("CLOSE", new TCPEvent("CLOSE"));
                mapEvent.put("TIMEOUT", new TCPEvent("TIMEOUT"));
        }

        private static void addTran(FSM myfsm) {
                // Transition(State cs, Event evt, State ns, Action act)
                Transition t1 = new Transition(mapState.get("LISTEN"), mapEvent.get("CLOSE"), mapState.get("CLOSED"),
                                new TCPAction());
                Transition t2 = new Transition(mapState.get("SYN_SENT"), mapEvent.get("CLOSE"), mapState.get("CLOSED"),
                                new TCPAction());
                Transition t3 = new Transition(mapState.get("CLOSE_WAIT"), mapEvent.get("CLOSE"),
                                mapState.get("LAST_ACK"),
                                new TCPAction());
                Transition t4 = new Transition(mapState.get("SYN_RCVD"), mapEvent.get("CLOSE"),
                                mapState.get("FIN_WAIT_1"),
                                new TCPAction());
                Transition t5 = new Transition(mapState.get("ESTABLISHED"), mapEvent.get("CLOSE"),
                                mapState.get("FIN_WAIT_1"),
                                new TCPAction());
                Transition t6 = new Transition(mapState.get("LISTEN"), mapEvent.get("SYN"), mapState.get("SYN_RCVD"),
                                new TCPAction());
                Transition t7 = new Transition(mapState.get("SYN_SENT"), mapEvent.get("SYN"), mapState.get("SYN_RCVD"),
                                new TCPAction());
                Transition t8 = new Transition(mapState.get("LAST_ACK"), mapEvent.get("ACK"), mapState.get("CLOSED"),
                                new TCPAction());
                Transition t9 = new Transition(mapState.get("CLOSING"), mapEvent.get("ACK"), mapState.get("TIME_WAIT"),
                                new TCPAction());
                Transition t10 = new Transition(mapState.get("FIN_WAIT_1"), mapEvent.get("ACK"),
                                mapState.get("FIN_WAIT_2"),
                                new TCPAction());
                Transition t11 = new Transition(mapState.get("SYN_RCVD"), mapEvent.get("ACK"),
                                mapState.get("ESTABLISHED"),
                                new TCPAction());
                Transition t12 = new Transition(mapState.get("FIN_WAIT_2"), mapEvent.get("FIN"),
                                mapState.get("TIME_WAIT"),
                                new TCPAction());
                Transition t13 = new Transition(mapState.get("FIN_WAIT_1"), mapEvent.get("FIN"),
                                mapState.get("CLOSING"),
                                new TCPAction());
                Transition t14 = new Transition(mapState.get("ESTABLISHED"), mapEvent.get("FIN"),
                                mapState.get("CLOSE_WAIT"),
                                new TCPAction());
                Transition t15 = new Transition(mapState.get("TIME_WAIT"), mapEvent.get("TIMEOUT"),
                                mapState.get("CLOSED"),
                                new TCPAction());
                Transition t16 = new Transition(mapState.get("CLOSED"), mapEvent.get("ACTIVE"),
                                mapState.get("SYN_SENT"),
                                new TCPAction());
                Transition t17 = new Transition(mapState.get("SYN_SENT"), mapEvent.get("SYNACK"),
                                mapState.get("ESTABLISHED"),
                                new TCPAction());
                Transition t18 = new Transition(mapState.get("ESTABLISHED"), mapEvent.get("RDATA"),
                                mapState.get("ESTABLISHED"),
                                new TCPAction());
                Transition t19 = new Transition(mapState.get("ESTABLISHED"), mapEvent.get("SDATA"),
                                mapState.get("ESTABLISHED"),
                                new TCPAction());
                Transition t20 = new Transition(mapState.get("CLOSED"), mapEvent.get("PASSIVE"), mapState.get("LISTEN"),
                                new TCPAction());
        }
}


