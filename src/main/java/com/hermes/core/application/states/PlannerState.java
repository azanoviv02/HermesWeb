package com.hermes.core.application.states;

import com.hermes.core.userinterface.ConsoleView;
import com.hermes.core.userinterface.Controller;

/**
 * Created by ivan on 31.10.16.
 */
public class PlannerState extends AbstractUserState {

    public PlannerState() {
    }

//    public void analyseCommands(Controller controller){
//
//        ConsoleView consoleView = controller.getConsoleView();
//        consoleView.print("Planner: ");
//        String[] command = consoleView.readLine();
//
//        switch(command.length){
//            case 1:
//                switch (command[0].toLowerCase()){
//                    case "new":
//                        consoleView.println("Creating haul!");
//                        return;
//                }
//        }
//
//        analyseCommandsUserCommon(controller, command);
//    }

    void printHelp(Controller controller){
        super.printHelp(controller);
        ConsoleView consoleView = controller.getConsoleView();
        consoleView.println("  new: creates new haul");
    }
}
