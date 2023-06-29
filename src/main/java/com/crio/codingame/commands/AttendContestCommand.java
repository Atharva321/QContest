package com.crio.codingame.commands;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import com.crio.codingame.dtos.UserRegistrationDto;
import com.crio.codingame.exceptions.ContestNotFoundException;
import com.crio.codingame.exceptions.InvalidOperationException;
import com.crio.codingame.exceptions.UserNotFoundException;
import com.crio.codingame.services.IUserService;

public class AttendContestCommand implements ICommand{

    private final IUserService userService;
    
    public AttendContestCommand(IUserService userService) {
        this.userService = userService;
    }

    // TODO: CRIO_TASK_MODULE_CONTROLLER
    // Execute attendContest method of IUserService and print the result.
    // Also Handle Exceptions and print the error messsages if any.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["ATTEND_CONTEST","3","Joey"]
    // Hint - Use Parameterized Exceptions in the Service class to match with the Unit Tests Output.

    @Override
    public void execute(List<String> tokens) {
        String contestId = tokens.get(1);
        String  userName = tokens.get(2);
        try{
            UserRegistrationDto attendContest = userService.attendContest(contestId, userName);
            System.out.println(attendContest);
        }
        catch(ContestNotFoundException exception){
            System.out.println("Cannot Attend Contest. Contest for given id:"+contestId+" not found!");
        }
        catch(UserNotFoundException exception){
            System.out.println("Cannot Attend Contest. User for given name:"+userName+" not found!");
        }
        catch(InvalidOperationException exception){
            System.out.println(exception.getMessage());
        }
        catch(Exception exception){
            System.out.println(exception.getMessage());
        }
    }
    
}
