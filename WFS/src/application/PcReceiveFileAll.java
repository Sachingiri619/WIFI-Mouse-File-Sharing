package application;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class PcReceiveFileAll implements Runnable {
//ReceiveFileName rfn;

		@Override
		public void run() {
			// TODO Auto-generated method stub
			//rfn=new ReceiveFileName();
			 int SOCKET_PORT1 = 13267;
			// int SOCKET_PORT2 = 3267;
			 // you may change this
			 // public final static String SERVER = "127.0.0.1";  // localhost
			//  public final static String
			      // FILE_TO_RECEIVED = "E:/Musics/Videos/downloadलॉलीपॉप  लागेलू - Pawan Singh - Lollypop Lagelu - Bhojpuri Hot Songs HD_HD.mp4";  // you may change this, I give a
			                                                            // different name because i don't want to
			                                                            // overwrite the one used by server...

			 int FILE_SIZE = 1024*1024; // file size temporary hard coded MB668
			//   StartThread2 st2;                                         // should bigger than the file to be downloaded
			//   String  str;
			 //  DataInputStream dis=null;
			   int bytesRead;
			   int i=0;
			    int current = 0;
			    FileOutputStream fos = null;
			    BufferedOutputStream bos = null;
			    Socket sock1 = null;
			 ///   Socket sock2 = null;
			    ServerSocket servsock1 = null;
			 //   ServerSocket servsock2 = null;
			    try {
			    	servsock1 = new ServerSocket(SOCKET_PORT1);
			    //	servsock2 = new ServerSocket(SOCKET_PORT2);
				    //  System.out.println("Connecting...");
				 //     while (true) {
			    	 PcReceiveFileName rfn=new PcReceiveFileName();
				    	for(String fname:rfn.FILE_NAME){    
					        System.out.println("Waiting...");
					        try {
					       // 	sock2 = servsock2.accept();
						      //    System.out.println("Accepted connection2 : " + sock2);
					          sock1 = servsock1.accept();
					         System.out.println("Accepted connection1 : " + sock1);
					        
				      // receive file
				     
				     //  dis=new DataInputStream(sock2.getInputStream());  
				     //   String str=(String)dis.readUTF();  
				    //  System.out.println("message= "+str); 
				     
				   //   sock2.close();
				    //  servsock2.close();
					          //Main home=new Main();
					        //  for(String fname:home.getFILE_NAME_RECEIVED()){
					          
					          
					          
						    	
						    	
				      byte [] mybytearray  = new byte [FILE_SIZE];
				      InputStream is = sock1.getInputStream();
				      File f=new File(System.getProperty("user.home"),"Desktop/File Sharing");
				      f.mkdirs();
				      File f1= new File(f,fname); 
				      fos = new FileOutputStream(f1);
				    
				      bos = new BufferedOutputStream(fos);
				      
				 /*     bytesRead = is.read(mybytearray,0,mybytearray.length);
				      current = bytesRead;

				      do {
				         bytesRead =
				            is.read(mybytearray, current, (mybytearray.length-current));
				         if(bytesRead >= 0) current += bytesRead;
				      } while(bytesRead > -1);

				      bos.write(mybytearray, 0 , current);
				      bos.flush();
				      */
				     // int j=0;
				      while((bytesRead = is.read(mybytearray, 0, mybytearray.length))!=-1){
	                        bos.write(mybytearray,0, bytesRead);
	                       // current=current+bytesRead;
	                        bos.flush();
	                       // j++;
	                        //.setProgress(j/50);
	                    }
				      System.out.println("File " + fname
				          + " downloaded (" + current + " bytes read)");
					      //    }
						    	
						    	
				    } catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    finally {
				    //  if (fos != null) fos.close();
				    //  if(dis!=null)dis.close();
				      if (bos != null) bos.close();
				   //   if (sock2 != null) sock2.close();
				      if (sock1 != null) sock1.close();
				    }
				    	}  
			    	
			    //	System.out.println("all receieved");
				      } catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					    finally {
					   //   if (servsock2 != null)
						//	try {
						//		servsock2.close();
						//	} catch (IOException e) {
								// TODO Auto-generated catch block
						//		e.printStackTrace();
						//	}
					      
					      if (servsock1 != null)
								try {
									servsock1.close();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
					    }
		  }



	}



