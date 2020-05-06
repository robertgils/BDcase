package BDExchange.System;

import BDExchange.Domain.User;

import java.util.HashMap;
import java.util.Map;

public class StateManager {

    private State currentState;
    final static Map<String, State> statesByOptionsMap = new HashMap<>();
    public static User loggedInUser;

    public void initialize() {
        // initialize all states
        WelcomeState welcomeState = new WelcomeState( this,"Login", "Register", "Exit");
        RegisterState registerState = new RegisterState(this);
        ExitState exitState = new ExitState(this);
        LoginState loginState = new LoginState(this, "LoggedOnState");
        LoggedOnState loggedonState = new LoggedOnState(this, "Option 1", "Option 2", "Option 3");

        // Map options to states
        addToMap("Welcome", welcomeState);
        addToMap("Register", registerState);
        addToMap("Exit", exitState);
        addToMap("Login", loginState);
        addToMap("LoggedOnState", loggedonState);

        // Set first state to welcome state
        changeState(welcomeState);
        updateState();
    }

    public void addToMap(String option, State state) {
        statesByOptionsMap.put(option, state);
    }
    public void changeState(State state) {
        currentState = state;
    }
    public void changeAndUpdateState(String option) {
        changeState(statesByOptionsMap.getOrDefault(option, currentState));
        updateState();
    }

    public void updateState() {
        currentState.updateState();
    }

    public State getCurrentState() {
        return currentState;
    }
}
