**Introduction**

In this project, we present the design and implementation of a TCP connection protocol using Finite State Machines (FSMs). The program, implemented in Java, utilizes the principles of FSMs to model the behavior of TCP connection establishment and management.

**Main.java**

The Main class serves as the entry point for the program. It initializes the FSM, builds the state and event maps, adds transitions to the FSM, and handles input events from the user. The program continuously reads events from standard input and processes them using the FSM until the end of the input stream is reached.

**TCPState.java**

The TCPState class extends the State class from the FSM package. It represents the states of the TCP connection protocol. Each state is defined by a unique state name, and the class provides methods to get and set the state name.

**TCPEvent.java**

The TCPEvent class extends the Event class from the FSM package. It represents the events that can occur during the TCP connection protocol. Each event is defined by a unique event name, and the class provides methods to get and set the event name.

**TCPAction.java**

The TCPAction class extends the Action class from the FSM package. It defines the actions to be taken upon transitions between states triggered by events. The execute() method is invoked whenever a transition occurs, and it handles specific actions based on the event type. It also maintains counts for data sent and received events.
