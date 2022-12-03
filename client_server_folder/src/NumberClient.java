import java.io.*;
import java.rmi.*;

public class NumberClient {

    public static void main(String args[]){
        try {
            int RMIPort;
            String hostName;
            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(is);
            System.out.println("Enter the RMIRegistry host name:" );
            hostName = br.readLine();
            System.out.println("Enter the RMIRegistry port number:" );
            String portNum = br.readLine();
            RMIPort = Integer.parseInt(portNum);
            String registryURL = "rmi://" + hostName + ":" + portNum + "/number";

            NumberInterface h = (NumberInterface)Naming.lookup(registryURL);
            System.out.println("Lookup completed");

            String message = h.getSquare(5);
            System.out.println("NumberClient: " + message);
        }
        catch (Exception e){
            System.out.println("Exception in NumberClient: " + e);
        }
    }
}