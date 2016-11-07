package com.hermes.hermes.application.states;


import com.hermes.hermes.domain.users.InvalidPasswordException;
import com.hermes.hermes.userinterface.ConsoleView;
import com.hermes.hermes.userinterface.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ivan on 31.10.16.
 */
@Component
public class StartState extends AbstractState {

    private final UserStateFactory userStateFactory;

    @Autowired
    public StartState(UserStateFactory userStateFactory) {
        this.userStateFactory = userStateFactory;
    }

//    public void analyseCommands(Controller controller) {
//
//        ConsoleView consoleView = controller.getConsoleView();
//        consoleView.print("Guest: ");
//        String[] command = consoleView.readLine();
//
//        switch(command.length){
//            case 1:
//                switch (command[0].toLowerCase()){
//                    case "enter":
//                        enterNewState(controller);
//                        return;
//                }
//        }
//
//        analyseCommandsGlobal(controller, command);
//    }

    void printHelp(Controller controller){
        super.printHelp(controller);
        ConsoleView consoleView = controller.getConsoleView();
        consoleView.println("  enter: enters into your personal account");
    }

    public void enterNewState(Controller controller) {

        ConsoleView consoleView = controller.getConsoleView();

        consoleView.print("Login: ");
        String login = consoleView.readLogin();
        consoleView.print("Password: ");
        String password = consoleView.readPassword();

        try{
            AbstractUserState newState = this.userStateFactory.createUserState(login, password);
            controller.setCurrentState(newState);
        }catch(InvalidPasswordException e){
            consoleView.println("Error: incorrect password");
        }catch (NoSuchLoginException e){
            consoleView.println("Error: incorrect login");
        }
    }
}
