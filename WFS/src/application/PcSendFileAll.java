package application;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.GenericArrayType;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;

public  class PcSendFileAll {
	 
	public void sendFile()throws IOException{
		// String SERVER = "127.0.0.1";
//		String SERVER = "192.168.173.148";
		int SOCKET_PORT1 = 13267;
		//int SOCKET_PORT2 = 3267;
		
		// you may change this
			//public final static String FILE_TO_SEND = "E:/Musics/Videos/लॉलीपॉप  लागेलू - Pawan Singh - Lollypop Lagelu - Bhojpuri Hot Songs HD_HD.mp4";  // you may change this
		 int bytesRead;
		    int current = 0;
			    FileInputStream fis = null;
			    BufferedInputStream bis = null;
			    OutputStream os = null;
			  //  DataOutputStream dout=null;
			    Socket sock1 = null;
			    int i=0;
			   
			  //  Socket sock2 = null;
			//    Scanner sc = null;
			   
			    for(String filepath:Main.getFILE_TO_SEND_LIST()){	    
			   
			    try {
			        //  sock = servsock.accept();
			    	sock1 = new Socket(Main.getConnectIp(), SOCKET_PORT1);
			    //	sock2 = new Socket(SERVER, SOCKET_PORT2);
				    //  System.out.println("Connecting...");

			         // System.out.println("Accepted connection : " + sock);
			          // send file:
				    
				    	 // for(String selectedFN:FILE_TO_RECEIVE_LIST){
				    		//  String selectedFN=selectedFP.substring(selectedFP.lastIndexOf("/")+1);
				     
			                    //setFILE_TO_RECEIVED(filename);
				      
			/*	    		  File myFile = new File (filepath);
				    		  byte [] mybytearray= new byte [(int)myFile.length()];
			          fis = new FileInputStream(myFile);
			       //   sc = new Scanner(fis, "UTF-8");
			          bis = new BufferedInputStream(fis);
			    //  bis.
			         bis.read(mybytearray,0,mybytearray.length);
			         // sc.read
			      //   sc.
			          os = sock1.getOutputStream();
			          System.out.println("Sending " +Main.getFILE_TO_RECEIVE_LIST().get(i)+ "(" + mybytearray.length + " bytes)");
			       //   dout=new DataOutputStream(sock2.getOutputStream());  
		    		//  dout.writeUTF(selectedFN);  
			          i++;
			          os.write(mybytearray,0,mybytearray.length);
			          
			          os.flush();
			        //  dout.flush(); 
			        //  dout.close(); 
			          System.out.println("Done.");
				    	  
				*/      
			    	 
			 		  File myFile = new File (filepath);
			 		 
		    		  byte [] mybytearray= new byte [1024*1024];
	          fis = new FileInputStream(myFile);
	       //   sc = new Scanner(fis, "UTF-8");
	          bis = new BufferedInputStream(fis);
	          os = sock1.getOutputStream();
	    //  bis.
	          
	         
	          while((bytesRead=bis.read(mybytearray,0,mybytearray.length))!=-1){
	        	
	        	  os.write(mybytearray,0,bytesRead );
	        	
	        	  os.flush();
	        	
	          }
	          //current = bytesRead;
	         
	       //   do {
             //     bytesRead =
                    //      bis.read(mybytearray, current, (mybytearray.length - current));
              //    bos.write(mybytearray, 0, current);
                 
                //  if (bytesRead >= 0) current += bytesRead;
             // } while (bytesRead > -1);
	         // sc.read
	      //   sc.
	         
	         // System.out.println("Sending " +Main.getFILE_TO_RECEIVE_LIST().get(i)+ "(" +current+"ggg"+bytesRead+ " bytes)");
	       //   dout=new DataOutputStream(sock2.getOutputStream());  
    		//  dout.writeUTF(selectedFN);  
	        //  i++;
	        
	          
	         
	        //  dout.flush(); 
	        //  dout.close(); 
	        //  System.out.println("Done.");
		    	  
	     
				    //  }
			    	 
			    }
			        finally {
			        	if (bis != null) bis.close();
					   //   if(fis!=null)fis.close();  
					         if (os != null) os.close();
			        // if (dout != null) dout.close();
			         if (sock1!=null) sock1.close();
			       //  if (sock2!=null) sock2.close();
			        
			        }
			    }
			   
			 //   System.out.println("all send");
			}


}

