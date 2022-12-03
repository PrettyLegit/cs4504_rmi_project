import java.rmi.*;
import java.rmi.server.*;

public class NumberImpl extends UnicastRemoteObject implements NumberInterface{
    public NumberImpl() throws RemoteException{
        super();
    }

    public String getSquare(int number) throws RemoteException{
        int squared_num = number * number;
        return "The Square of " + number + " is " + Integer.toString(squared_num);
    }

    public String getFactorial(int number) throws RemoteException{
        int factorial_sum = 1;
        int i;
        for(i = 2; i <= number; i++){
            factorial_sum *= i;
        }
        return "The factorial of " + number + " is " + factorial_sum;
    }
}
