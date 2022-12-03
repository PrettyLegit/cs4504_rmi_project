import java.rmi.*;

public interface NumberInterface extends Remote {
    public String getSquare(int number) throws RemoteException;
    public String getFactorial(int number) throws RemoteException;
}
