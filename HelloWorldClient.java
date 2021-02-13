package com.yoon;

import javax.xml.rpc.ParameterMode;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;

public class HelloWorldClient {
	
	public static void main (String args[]) {
        try {

              // EndPoint URL for the HelloWorld  Web Service
              String endpointURL = "http://localhost:8080/axis/HelloWorld.jws";

              // Method Name to invoke for HelloWorld Web Service
              String methodName = "getHelloWorldMessage";

              // Create the Service call
              Service service = new Service();
              Call call = (Call) service.createCall();

              //Set the endPoint URL
              call.setTargetEndpointAddress(new java.net.URL(endpointURL));

              //Set the methodname to invoke - getHelloWorldMessage
              call.setOperationName(methodName);

              //Set the input and output parameters - their Return Types.
              call.addParameter("name",XMLType.XSD_STRING,ParameterMode.IN);
              call.setReturnType(XMLType.XSD_STRING);

              //Setup the Parameters i.e. the name to be passed as input parameter to the
              //HelloWorld Web Service
              String result = (String) call.invoke( new Object[] { "Axis" } );

              //Print out the result
              System.out.println(result);
        }
        catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}
