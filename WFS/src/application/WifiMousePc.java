package application;

import java.awt.AWTException;
import java.awt.event.WindowFocusListener;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetSocketAddress;

public class WifiMousePc implements Runnable {
	
	
	private static ServerSocket receiverMouse = null;
	private static Socket senderMouse = null;
	private static BufferedReader cmdin = null;
	private static String cmd;
	private static boolean isConnected=true;
	private static Robot robot;
	private static final int SERVER_PORT = 8998;
	private String connectionStatus;
	
	public String getConnectionStatus() {
		return connectionStatus;
	}

	public void setConnectionStatus(String connectionStatus) {
		this.connectionStatus = connectionStatus;
	}

	public void mousecmdreceive()  {
		boolean leftpressed=false;
		boolean rightpressed=false;
 
	    try{
	    
	    		robot = new Robot();
			receiverMouse = new ServerSocket(SERVER_PORT); //Create a server socket on port 8998
			System.out.println("waiting");
			
			senderMouse = receiverMouse.accept(); //Listens for a connection to be made to this socket and accepts it
			setConnectionStatus("connect to android");
			System.out.println(senderMouse.getRemoteSocketAddress());
			String ip=(((InetSocketAddress) senderMouse.getRemoteSocketAddress()).getAddress()).toString().replace("/","");
			System.out.println(ip);
			cmdin = new BufferedReader(new InputStreamReader(senderMouse.getInputStream())); //the input stream where data will come from client
		}catch (IOException e) {
			System.out.println("Error in opening sender mouse");
			System.exit(-1);
		}catch (AWTException e) {
			System.out.println("Error in creating robot instance");
			System.exit(-1);
		}
			
		//read input from client while it is connected
	    while(isConnected){
	        try{
			cmd = cmdin.readLine(); //read input from client
			System.out.println(cmd); //print whatever we get from client
			
			//if user clicks on next
			if(cmd.equalsIgnoreCase("LEFT_CLICK")){
				//Simulate press and release of mouse 'left click'
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			}
			//if user clicks on previous
			else if(cmd.equalsIgnoreCase("RIGHT_CLICK")){
				//Simulate press and release of mouse 'right click'
				robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
				robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);        	
			}
			
			//input will come in x,y format if user moves mouse on mousepad
			else if(cmd.contains(",")){
				float movex=Float.parseFloat(cmd.split(",")[0]);//extract movement in x direction
				float movey=Float.parseFloat(cmd.split(",")[1]);//extract movement in y direction
				Point point = MouseInfo.getPointerInfo().getLocation(); //Get current mouse position
				float nowx=point.x;
				float nowy=point.y;
				robot.mouseMove((int)(nowx+movex),(int)(nowy+movey));//Move mouse pointer to new location
			}
			
			//Exit if user ends the connection
			else if(cmd.equalsIgnoreCase("exit")){
				isConnected=false;
				//Close server and client socket
				receiverMouse.close();
				senderMouse.close();
			}
	        } catch (IOException e) {
				System.out.println("Read failed");
				System.exit(-1);
	        }
      	}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		mousecmdreceive();
		
	}


	


}
