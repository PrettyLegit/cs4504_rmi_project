import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.net.*;
import java.io.*;

public class NumberServer {
    public static void main(String args[]){
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String portNum, registryURL;

        try {
            System.out.println("=== Number Server ===\n\n");
            System.out.println("Enter the RMI registry port number:");
            portNum = (br.readLine()).trim();
            int RMIPortNum = Integer.parseInt(portNum);
            startRegistry(RMIPortNum);
            NumberImpl exportedObj = new NumberImpl();
            registryURL = "rmi://localhost:" + portNum + "/number";
            Naming.rebind(registryURL, exportedObj);
            System.out.println(
                    "Server registered. Registry currently contains:"
            );
            listRegistry(registryURL);
            System.out.println("Number Server ready.");
        } catch (Exception re) {
            System.out.println("Exception in NumberServer.main: " + re);
        }
    }

    // This method starts an RMI registry on the local host,
    // if it does not already exist at the specified port number.
    private static void startRegistry(int RMIPortNum) throws RemoteException{
        try{
            Registry registry = LocateRegistry.getRegistry(RMIPortNum);
            registry.list();
        }
        catch(RemoteException e){
            System.out.println("RMI registry cannot be located at port " + RMIPortNum);
            Registry registry = LocateRegistry.createRegistry(RMIPortNum);
            System.out.println("RMI registry created at port " + RMIPortNum);
        }
    }
    private static void listRegistry(String registryURL) throws RemoteException, MalformedURLException {
        System.out.println("Registry " + registryURL + " contains: ");
        String [] names = Naming.list(registryURL);
        for(int i = 0; i < names.length; i++){
            System.out.println(names[i]);
        }
    }
}
