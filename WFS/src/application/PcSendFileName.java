package application;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class PcSendFileName{
	//StartThread st;
//	ArrayList<String> FILE_NAME=new ArrayList<>();
	public void File2()throws IOException{
	//String SERVER = "127.0.0.1";
	//String SERVER = "192.168.173.148";
	//int SOCKET_PORT1 = 13267;
	int SOCKET_PORT2 = 3333;
	// you may change this
		//public final static String FILE_TO_SEND = "E:/Musics/Videos/लॉलीपॉप  लागेलू - Pawan Singh - Lollypop Lagelu - Bhojpuri Hot Songs HD_HD.mp4";  // you may change this
	
		//    FileInputStream fis = null;
		//    BufferedInputStream bis = null;
		//    OutputStream os = null;
		    DataOutputStream dout=null;
		//    Socket sock1 = null;
		    Socket sock2 = null;
		  //  int j=0;
		//    Scanner sc = null;
		  //  while(true){
		    for(String filename:Main.getFILE_TO_RECEIVE_LIST()){  	  
		    try {
		    	
		        //  sock = servsock.accept();
		  //  	sock1 = new Socket(SERVER, SOCKET_PORT1);
		    	sock2 = new Socket(Main.getConnectIp(), SOCKET_PORT2);
			     // System.out.println("Connecting...");

		         // System.out.println("Accepted connection : " + sock);
		          // send file:
			     
			    	//  for(String selectedFN:FILE_TO_RECEIVE_LIST){
			  //  	  String selectedFN=selectedFP.substring(selectedFP.lastIndexOf(""\"")+1);"
	                    //setFILE_TO_RECEIVED(filename);
		    		//  File myFile = new File (selectedFP);  
		    //      File myFile = new File (selectedFP);
		    //      byte [] mybytearray  = new byte [1024];
		   //       fis = new FileInputStream(myFile);
		       //   sc = new Scanner(fis, "UTF-8");
		    //      bis = new BufferedInputStream(fis);
		      
		   //      bis.read(mybytearray,0,mybytearray.length);
		         // sc.read
		      //   sc.
		   //       os = sock1.getOutputStream();
		   //       System.out.println("Sending " + selectedFN + "(" + mybytearray.length + " bytes)");
			     
		          dout=new DataOutputStream(sock2.getOutputStream());  
	    		  dout.writeUTF(filename);  
		     //     os.write(mybytearray,0,mybytearray.length);
		          
		     //     os.flush();
		         // dout.flush(); 
		        //  j++;
		        //  dout.close(); 
		         // System.out.println("Done.");
		        
			    	//  }
			    	 
			     // }
		    	 
		       
			     // System.out.println("all send file name");   
		    
		    	 } finally {
		         // if (bis != null) bis.close();
		        
		       //  if (os != null) os.close();
		        	  if (dout != null) dout.close();
		      //   if (sock1!=null) sock1.close();
		         if (sock2!=null) sock2.close();
		        
		        }
		   // System.out.println("all name send");
		    
		    }
		    
		
}
	

}
