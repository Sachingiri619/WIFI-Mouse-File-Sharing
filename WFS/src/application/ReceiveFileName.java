package application;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ReceiveFileName implements Runnable {
	//StartThread st;
public static ArrayList<String> FILE_NAME;	
	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		// int SOCKET_PORT1 = 13267;
		 int SOCKET_PORT2 = 3333;
		 // you may change this
		 // public final static String SERVER = "127.0.0.1";  // localhost
		//  public final static String
		      // FILE_TO_RECEIVED = "E:/Musics/Videos/downloadलॉलीपॉप  लागेलू - Pawan Singh - Lollypop Lagelu - Bhojpuri Hot Songs HD_HD.mp4";  // you may change this, I give a
		                                                            // different name because i don't want to
		                                                            // overwrite the one used by server...

		//   int FILE_SIZE = 1024; // file size temporary hard coded MB668
		 String str;                                           // should bigger than the file to be downloaded
		//   String  str;
		   DataInputStream dis=null;
		//   int bytesRead;
		//    int current = 0;
		 //   FileOutputStream fos = null;
		//    BufferedOutputStream bos = null;
		 //   Socket sock1 = null;
		    Socket sock2 = null;
		//    ServerSocket servsock1 = null;
		    ServerSocket servsock2 = null;
		    try {
		    //	servsock1 = new ServerSocket(SOCKET_PORT1);
		    	servsock2 = new ServerSocket(SOCKET_PORT2);
			    //  System.out.println("Connecting...");
		    	FILE_NAME=new ArrayList();
		    	
				        System.out.println("Waiting...");
				        try {
				        	sock2 = servsock2.accept();
					          System.out.println("Accepted connection2 : " + sock2);
				        //  sock1 = servsock1.accept();
				        //  System.out.println("Accepted connection1 : " + sock1);
					          //String value;
					          while(true){
					          dis=new DataInputStream(sock2.getInputStream());  
					         // while(dis.available() > 0 && (value = dis.readUTF()) != null) {
					             // System.out.println(value);
					          if(dis.available()!=0){
					        	  str=dis.readUTF();
						    	   FILE_NAME.add(str);

							       //setName(str);
							      System.out.println("message= "+str); 
					          }
					          else{
					        	 
					          }
					          

			      // receive file
			/*		          while(sock2.isConnected()) {    	             
			       dis=new DataInputStream(sock2.getInputStream());  
			      // dis.re
			     //  dis.a
			       if(dis.available()!=0){
			    	   str=dis.readUTF();
			    	   FILE_NAME.add(str);

				       //setName(str);
				      System.out.println("message= "+str); 
				     
			       }else{
			    	   //dis.close();
			    	  // sock2.close();
			    	   //servsock2.close();
			      }
			     */  
			       
			        
			      
			   //   sock2.close();
			    //  servsock2.close();
			 //     byte [] mybytearray  = new byte [FILE_SIZE];
			 //     InputStream is = sock1.getInputStream();
			  //    File f=new File(System.getProperty("user.home"),"Downloads/sharingTest");
			  //    f.mkdirs();
			  //    File f1= new File(f,str); 
			  //    fos = new FileOutputStream(f1);
			  //    bos = new BufferedOutputStream(fos);
			 //     bytesRead = is.read(mybytearray,0,mybytearray.length);
			 //     current = bytesRead;

			  //    do {
			   //      bytesRead =
			  //          is.read(mybytearray, current, (mybytearray.length-current));
			    //     if(bytesRead >= 0) current += bytesRead;
			   //   } while(bytesRead > -1);

			  //    bos.write(mybytearray, 0 , current);
			  //    bos.flush();
			  //    System.out.println("File " + str
			  //        + " downloaded (" + current + " bytes read)");
			     // dis.close();
					       //   }
				        }    
				        }  
			    finally {
			    //  if (fos != null) fos.close();
			   //   if(dis!=null)dis.close();
			   //   if (bos != null) bos.close();
			      if (sock2 != null) sock2.close();
			   //   if (sock1 != null) sock2.close();
			    }
		    	 
			    //  Main home=new Main();
			      } catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			      
		    
				    finally {
				      if (servsock2 != null)
						try {
							servsock2.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				      
				   //   if (servsock1 != null)
						//	try {
						//		servsock1.close();
						//	} catch (IOException e) {
								// TODO Auto-generated catch block
							//	e.printStackTrace();
						//	}
				    }
	  }
	
	


}

