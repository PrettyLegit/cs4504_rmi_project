import java.rmi.*;

public interface NumberInterface {
    public String getSquare(int number) throws java.rmi.RemoteException;
    public String getFactorial(int number) throws java.rmi.RemoteException;
}
