package application;
	
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
	private static int p;
public static int getP() {
		return p;
	}

	
public static void setP(int p) {
	Main.p = p;
}

public static ArrayList<String> FILE_NAME;	
Boolean setacpt=false;
Boolean startacpt=false;
private static String connectIp;
public static String getConnectIp() {
	return connectIp;
}

public static void setConnectIp(String connectIp) {
	Main.connectIp = connectIp;
}
private static List<String> FILE_NAME_RECEIVED;
public static List<String> getFILE_NAME_RECEIVED() {
	return FILE_NAME_RECEIVED;
}

public static void setFILE_NAME_RECEIVED(List<String> fILE_NAME_RECEIVED) {
	FILE_NAME_RECEIVED = fILE_NAME_RECEIVED;
}
private static List<String> FILE_TO_SEND_LIST;

public static List<String> getFILE_TO_SEND_LIST() {
	return FILE_TO_SEND_LIST;
}

public static void setFILE_TO_SEND_LIST(List<String> fILE_TO_SEND_LIST) {
	FILE_TO_SEND_LIST = fILE_TO_SEND_LIST;
}

public static List<String> getFILE_TO_RECEIVE_LIST() {
	return FILE_TO_RECEIVE_LIST;
}

public void setFILE_TO_RECEIVE_LIST(List<String> fILE_TO_RECEIVE_LIST) {
	FILE_TO_RECEIVE_LIST = fILE_TO_RECEIVE_LIST;
}
private static List<String> FILE_TO_RECEIVE_LIST;
String pcmIP;


	@Override
	public void start(Stage homeStage) {
		
		//	BorderPane root = new BorderPane();
			VBox vboxHome=new VBox();
			 vboxHome.setSpacing(50);
		        vboxHome.setPadding(new Insets(100,10,100,10));//top,rihgt,bottom,left
			vboxHome.setAlignment(Pos.BASELINE_CENTER);
			
		//	root.getChildren().add(vbox);
			Button clickwifimouse=new Button("WIFI MOUSE");
			
			Button clicksend=new Button("SEND");
			Button clickreceive=new Button("RECEIVE");
			Label check =new Label("ALWAYS RUN THIS APPLICATION AS ADMINSTRATOR");
			//btm.setLayoutX(200.0);
			
			vboxHome.getChildren().add(clickwifimouse);
			vboxHome.getChildren().add(clicksend);
			vboxHome.getChildren().add(clickreceive);
			vboxHome.getChildren().add(check);
			vboxHome.setStyle("-fx-background-color: WHITE;");
			clickwifimouse.setStyle("-fx-background-color: orange; -fx-text-fill:white;-fx-border-radius: 20;-fx-background-radius: 20;-fx-padding: 5;");
			clicksend.setStyle("-fx-background-color: blue; -fx-text-fill:white;-fx-border-radius: 20;-fx-background-radius: 20;-fx-padding: 5;");
			clickreceive.setStyle("-fx-background-color: blue; -fx-text-fill:white;-fx-border-radius: 20;-fx-background-radius: 20;-fx-padding: 5;");
			Scene sceneHome = new Scene(vboxHome,400,400);
			sceneHome.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			homeStage.setScene(sceneHome);
			homeStage.setTitle("WIFI MOUSE & FILE SHARING");
			homeStage.show();
		
			
		EventHandler<MouseEvent> eventHandlerClickWifiMouse = new EventHandler<MouseEvent>() {
			
    		@Override
    		public void handle(MouseEvent e) {
    			
    			//netsh wlan disconnect
    		//	ProcessBuilder pb = new ProcessBuilder("netsh", "wlan", "show","profiles");//before connect network
    			//ProcessBuilder pb = new ProcessBuilder("netsh", "wlan", "show","networks");	//show all network
    			//ProcessBuilder pb = new ProcessBuilder("netsh","wlan", "disconnect");
    		/*	ProcessBuilder pb = new ProcessBuilder("netsh","wlan", "name=com");
    			pb.redirectErrorStream(true);
    				Process process = null;
					try {
						process = pb.start();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
    				BufferedReader reader = new BufferedReader(
    				    new InputStreamReader(process.getInputStream()));
    				String line = null;
    				try {
						while ((line = reader.readLine()) != null) {
						    System.out.println(line);
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}*/
    			//try {
    				//Runtime.getRuntime().exec(new String[] {"netsh", "wlan", "connect", "name=\"Profile Name\"", "ssid=XXXXX"});
    	            // Execute command
    		/*		  String command1 = "netsh wlan set hostednetwork mode=allow ssid=connect1 key=12345678";
    				  
    	            String command2 = "netsh wlan stop hostednetwork";
    	         //  String command3="netsh wlan connect ssid="\"com\" key="\"12345678\";
    	          //  String command = "netsh wlan show networks mode=Bssid";
    	           // Runtime.getRuntime().exec("runas /profile /user:Administrator \"cmd.exe /c Powrprof.dll,SetSuspendState\"");
    	         //   Process p1 = Runtime.getRuntime().exec(command1);
    	            Process p2 = Runtime.getRuntime().exec(command2);
    	            System.out.println("create connect");
    	            try {
    	              //  p1.waitFor();
    	                p2.waitFor();
    	            } catch (InterruptedException ex) {
    	                ex.printStackTrace();
    	                
    	            }
    	} catch (IOException e1) {
    		e1.printStackTrace();
        }
    		*/	
    			try {
					setaccesspoint();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
    			if(setacpt){
    				try {
						startaccesspoint();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
    			}
    			
    			if(startacpt){
    			VBox vboxConnectMouse=new VBox();
    			
    			vboxConnectMouse.setSpacing(50);
		        vboxConnectMouse.setPadding(new Insets(100,10,100,10));//top,rihgt,bottom,left
			vboxConnectMouse.setAlignment(Pos.BASELINE_CENTER);
    				//Inet4Address localhost;
				/*	try {
						localhost = (Inet4Address) Inet4Address.getLocalHost();
						pcmIP=localhost.toString();
						
	/*byte[] ip = localhost.getAddress();
    			 		
    			 		// looping
    				for (int i = 1; i <= 254; i++)
    					{
    						ip[3] = (byte)i;
    						InetAddress address = InetAddress.getByAddress(ip);
    					if (address.isReachable(1000))
    					{
    						System.out.println(address + " - Pinging... Pinging");
    					}
    					else if (!address.getHostAddress().equals(address.getHostName()))
    					{
    						System.out.println(address + " - DNS lookup known..");
    					}
    					else
    					{
    						System.out.println(address + " - the host address and the host name are same");
    					}
    					}*/
				//	} catch (IOException e1) {
						// TODO Auto-generated catch block
					//	e1.printStackTrace();
				//	}*/
						Label showIP=new Label();
						
						vboxConnectMouse.getChildren().add(showIP);
						//String t=serip.substring(serip.lastIndexOf("/")+1);
						//showIP.setText(pcmIP.substring(pcmIP.lastIndexOf("/")+1));
						showIP.setText(getIp4());
						// System.out.println(localhost);
						//TextField enterCode=new TextField();
					//	enterCode.setPromptText("Enter code here from 0 to 65535");
					//	enterCode.setPrefColumnCount(10);
						 Button clickConnect=new Button("connect Android");
						 Label connectStatusShow=new Label("connection status");
						 
						 connectStatusShow.setAlignment(Pos.BOTTOM_CENTER);
						// vboxConnectMouse.getChildren().add(enterCode);
						 vboxConnectMouse.getChildren().add(clickConnect);
						// vboxConnectMouse.getChildren().add(connectStatusShow);
						
    			//String codeString=enterCode.getText().toString().trim();
    		//	try{
    			//setCode(Integer.parseInt(enterCode.getText()));
    		//	}catch(NumberFormatException e1){
    			//	e1.printStackTrace();
    		//	}
    					// IPv4 usage
						 vboxConnectMouse.setStyle("-fx-background-color: WHITE;");
						 showIP.setStyle("-fx-font: normal bold 20px 'serif' ");
						 clickConnect.setStyle("-fx-background-color: orange; -fx-text-fill:white;-fx-border-radius: 20;-fx-background-radius: 20;-fx-padding: 5;");
				Scene sceneConnectMouse = new Scene(vboxConnectMouse,400,400);
	    			Stage s=new Stage();
    			sceneConnectMouse.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    			s.setScene(sceneConnectMouse);
    		//	homeStage.close();
    			s.show();
    			
    			
    			EventHandler<MouseEvent> eventHandlerConnectAndroid = new EventHandler<MouseEvent>() {
    				String ip;
    	    		@Override
    	    		public void handle(MouseEvent e) {
    	    	    	WifiMousePc wmpc=new WifiMousePc();
    	    			//System.out.println(codeString);
    	    			
    	    			
    	    			
    	    			//StartThread2 st2=new StartThread2();
    	    			Thread t1=new Thread(wmpc);
//    	    			Thread t2=new Thread(st2);
    	    			//t2.start();
    	    			//try {
    	    			//	t2.join();//complete my thread then other//after start
    	    			//} catch (InterruptedException e) {
    	    				// TODO Auto-generated catch block
    	    				//e.printStackTrace();
//    	    			}
    	    			t1.start();
    	    			//t1.stop();
    	    			//connectStatusShow.setText(wmpc.getConnectionStatus());
    	    			showIP.setVisible(false);
    	    			clickConnect.setVisible(false);
    	    			 //vboxConnectMouse.getChildren().remove(clickConnect);
    	    			
    	    		}
        		};
    	    		
    			clickConnect.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,eventHandlerConnectAndroid);
    			}		
    	}
    		};
		
	clickwifimouse.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,eventHandlerClickWifiMouse);
		
	EventHandler<MouseEvent> eventHandlerReceive = new EventHandler<MouseEvent>() {
		String ip;
		@Override
		public void handle(MouseEvent e) {
			try {
				setaccesspoint();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			if(setacpt){
				try {
					startaccesspoint();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			if(startacpt){
			VBox vboxConnectMouse=new VBox();
		//vboxConnectMouse.setSpacing(50);
	     //   vboxConnectMouse.setPadding(new Insets(100,10,100,10));//top,rihgt,bottom,left
			//vboxConnectMouse.setAlignment(Pos.BASELINE_CENTER);
				//Inet4Address localhost;
				//try {
				//	localhost = (Inet4Address) Inet4Address.getLocalHost();
				//	pcmIP=localhost.toString();
					
/*byte[] ip = localhost.getAddress();
			 		
			 		// looping
				for (int i = 1; i <= 254; i++)
					{
						ip[3] = (byte)i;
						InetAddress address = InetAddress.getByAddress(ip);
					if (address.isReachable(1000))
					{
						System.out.println(address + " - Pinging... Pinging");
					}
					else if (!address.getHostAddress().equals(address.getHostName()))
					{
						System.out.println(address + " - DNS lookup known..");
					}
					else
					{
						System.out.println(address + " - the host address and the host name are same");
					}
					}*/
				//} catch (IOException e1) {
					// TODO Auto-generated catch block
				//	e1.printStackTrace();
				//}
					Label showIP=new Label();
					Label connecthotspot=new Label();
					vboxConnectMouse.getChildren().add(showIP);
					vboxConnectMouse.getChildren().add(connecthotspot);
					//String t=serip.substring(serip.lastIndexOf("/")+1);
					//showIP.setText(pcmIP.substring(pcmIP.lastIndexOf("/")+1));
					showIP.setText(getIp4());
					connecthotspot.setText("For PC SENDER OPEN YOUR PC WIFI & CONNECT TO NETWORK ENXHe12rtsXTY password=456wmfs654");
					// System.out.println(localhost);
					//TextField enterCode=new TextField();
				//	enterCode.setPromptText("Enter code here from 0 to 65535");
				//	enterCode.setPrefColumnCount(10);
					 Button clickConnect=new Button("VALIDATE");
					// Button clickReceiveFromPC=new Button("Receive From PC");
				//	 Label connectStatusShow=new Label("connection status");
					 
					// connectStatusShow.setAlignment(Pos.BOTTOM_CENTER);
					 Button clickok=new Button("RECEIVE");
					// vboxConnectMouse.getChildren().add(enterCode);
					 vboxConnectMouse.getChildren().add(clickConnect);
				//	 vboxConnectMouse.getChildren().add(clickReceiveFromPC);
					// vboxConnectMouse.getChildren().add(connectStatusShow);
					// if(clickReceiveFromAndroid.isPressed()){
						 vboxConnectMouse.getChildren().add(clickok);
						 ProgressIndicator pi=new ProgressIndicator(0);
							//vboxConnectMouse.getChildren().add(pb);
							
							// pi.setVisible(false);
							//   ProgressBar pbY = new ProgressBar(0);
							//  ProgressIndicator piY = new ProgressIndicator(0);
							
							// vboxConnectMouse.getChildren().add(piY);
						//	 Label l=new Label();
							// vboxConnectMouse.getChildren().add(l);
							// vboxConnectMouse.getChildren().add(connectStatusShow);
						//	 vboxConnectMouse.getChildren().add(connectStatusShow);
							 ListView<String> list = new ListView<String>();
							 list.setPrefSize(100, 200);
						//	list.setSize
							// list.setVisible(false);
							 //vboxConnectMouse.getChildren().add(pi);
							 vboxConnectMouse.getChildren().add(list);
						// vboxConnectMouse.getChildren().add(clickok);
						
					// }else{
					// vboxConnectMouse.getChildren().remove(clickok);
					// }
			//String codeString=enterCode.getText().toString().trim();
		//	try{
			//setCode(Integer.parseInt(enterCode.getText()));
		//	}catch(NumberFormatException e1){
			//	e1.printStackTrace();
		//	}
						 clickok.setVisible(false);
						// pi.setVisible(false);
						 //list.setVisible(false);
					// IPv4 usage
						 vboxConnectMouse.setStyle("-fx-background-color: WHITE;");
						 showIP.setStyle("-fx-font: normal bold 20px 'serif' ");
						 clickConnect.setStyle("-fx-background-color: blue; -fx-text-fill:white;-fx-border-radius: 20;-fx-background-radius: 20;-fx-padding: 5;");
						// clickReceiveFromPC.setStyle("-fx-background-color: orange; -fx-text-fill:white;-fx-border-radius: 20;-fx-background-radius: 20;-fx-padding: 5;");
						 clickok.setStyle("-fx-background-color: blue; -fx-text-fill:white;-fx-border-radius: 20;-fx-background-radius: 20;-fx-padding: 5;");
			Scene sceneConnectMouse = new Scene(vboxConnectMouse,600,400);
    			Stage s=new Stage();
			sceneConnectMouse.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			s.setScene(sceneConnectMouse);
			//homeStage.close();
			s.show();
			
			
			EventHandler<MouseEvent> eventHandlerReceiveConnect = new EventHandler<MouseEvent>() {
				
	    		@Override
	    		public void handle(MouseEvent e) {
	    	    	//WifiMousePc wmpc=new WifiMousePc();
	    			//System.out.println(codeString);
	    			showIP.setVisible(false);
	    			connecthotspot.setVisible(false);
	    			clickConnect.setVisible(false);
	    			//PcReceiveFileName rfn=new PcReceiveFileName();
	    			//StartThread2 st2=new StartThread2();
	    		//	Thread t1=new Thread(rfn);
//	    			Thread t2=new Thread(st2);
	    			//t2.start();
	    			//try {
	    			//	t2.join();//complete my thread then other//after start
	    			//} catch (InterruptedException e) {
	    				// TODO Auto-generated catch block
	    				//e.printStackTrace();
//	    			}
	    		//	t1.start();
	    			Task<Void> task = new Task<Void>() {
	    			    @Override protected Void call() throws Exception {
	    			    	
	    			   // 	SendFileName st=new SendFileName();
	    			    //	st.File2();
	    			    	
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
	    						    	while (true) {     
	    							      //  System.out.println("Waiting...");
	    							        try {
	    							        	sock2 = servsock2.accept();
	    								       //   System.out.println("Accepted connection2 : " + sock2);
	    							        //  sock1 = servsock1.accept();
	    							        //  System.out.println("Accepted connection1 : " + sock1);
	    							          
	    						      // receive file
	    								                    
	    						       dis=new DataInputStream(sock2.getInputStream());  
	    						      // if(dis.available()!=0){
	    						        str=dis.readUTF();
	    						       
	    						        FILE_NAME.add(str);

	    						       //setName(str);
	    						     // System.out.println("message= "+str); 
	    						      // }
	    						      
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
	    								          }
	    							       
	    							            
	    						    finally {
	    						    //  if (fos != null) fos.close();
	    						    //  if(dis!=null)dis.close();
	    						   //   if (bos != null) bos.close();
	    						      if (sock2 != null) sock2.close();
	    						   //   if (sock1 != null) sock2.close();
	    						    }
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
	    			    	
	    					return null;
	    			      /*  int iterations;
	    			        for (iterations = 0; iterations < 1000000; iterations++) {
	    			            if (isCancelled()) {
	    			                updateMessage("Cancelled");
	    			                break;
	    			            }
	    			            updateMessage("Iteration " + iterations);
	    			            updateProgress(iterations, 1000);
	    			 
	    			            //Block the thread for a short time, but be sure
	    			            //to check the InterruptedException for cancellation
	    			            try {
	    			                Thread.sleep(0);
	    			            } catch (InterruptedException interrupted) {
	    			                if (isCancelled()) {
	    			                    updateMessage("Cancelled");
	    			                    break;
	    			                }
	    			            }
	    			        }
	    			        return iterations;
	    			        */
	    			    }
	    			};
	    			Thread th = new Thread(task);
	    	        th.setDaemon(true);
	    	        th.start();
	    	       	clickok.setVisible(true);
						
					
	    		
						
				
	    			//t1.stop();
	    		//	connectStatusShow.setText(wmpc.getConnectionStatus());
	    			//clickok.setVisible(true);
	    			
	    			
	    		}
    		};
	    		
			clickConnect.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,eventHandlerReceiveConnect);
			
/*EventHandler<MouseEvent> eventHandlerReceiveFromPC = new EventHandler<MouseEvent>() {
				
	    		@Override
	    		public void handle(MouseEvent e) {
	    	    	//WifiMousePc wmpc=new WifiMousePc();
	    			//System.out.println(codeString);
	    			clickok.setVisible(false);
	    			pi.setVisible(true);
	    			
	    			ReceiveFileAll rfa=new ReceiveFileAll();
	    			//StartThread2 st2=new StartThread2();
	    			Thread t1=new Thread(rfa);
//	    			Thread t2=new Thread(st2);
	    			//t2.start();
	    			//try {
	    			//	t2.join();//complete my thread then other//after start
	    			//} catch (InterruptedException e) {
	    				// TODO Auto-generated catch block
	    				//e.printStackTrace();
//	    			}
	    			t1.start();
	    			//t1.stop();
	    		//	connectStatusShow.setText(wmpc.getConnectionStatus());
	    			
	    			
	    		}
    		};
	    		
			clickReceiveFromPC.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,eventHandlerReceiveFromPC);
		*/	
EventHandler<MouseEvent> eventHandlerclickok= new EventHandler<MouseEvent>() {
				
	    		@Override
	    		public void handle(MouseEvent e) {
	    	    	//WifiMousePc wmpc=new WifiMousePc();
	    			//System.out.println(codeString);
	
    				
    				ObservableList<String> items =FXCollections.observableArrayList();
					 for(String f:Main.FILE_NAME){
						 items.add("Desktop"+"/"+"File Sharing"+f);
					 }
					// items=(ObservableList<String>) Main.FILE_TO_RECEIVE_LIST;
						 list.setItems(items);
	    			clickok.setVisible(false);
	    			//pi.setVisible(true);
	    			PcReceiveFileAll rfa=new PcReceiveFileAll();
	    			//StartThread2 st2=new StartThread2();
	    		//	Thread t1=new Thread(rfa);
//	    			Thread t2=new Thread(st2);
	    			//t2.start();
	    			//try {
	    			//	t2.join();//complete my thread then other//after start
	    			//} catch (InterruptedException e) {
	    				// TODO Auto-generated catch block
	    				//e.printStackTrace();
//	    			}
	    		//	t1.start();
	    			//t1.stop();
	    			
	    			Task<Void> task = new Task<Void>() {
	    			    @Override protected Void call() throws Exception {
	    			    	
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
	    					    	// PcReceiveFileName rfn=new PcReceiveFileName();
	    					    	Main rfn=new Main();
	    						    	for(String fname:rfn.FILE_NAME){    
	    							    //    System.out.println("Waiting...");
	    							        try {
	    							       // 	sock2 = servsock2.accept();
	    								      //    System.out.println("Accepted connection2 : " + sock2);
	    							          sock1 = servsock1.accept();
	    							     //    System.out.println("Accepted connection1 : " + sock1);
	    							        
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
	    						//      System.out.println("File " + fname
	    						    //     + " downloaded (" + current + " bytes read)");
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
	    			    	
	    					return null;
	    			      /*  int iterations;
	    			        for (iterations = 0; iterations < 1000000; iterations++) {
	    			            if (isCancelled()) {
	    			                updateMessage("Cancelled");
	    			                break;
	    			            }
	    			            updateMessage("Iteration " + iterations);
	    			            updateProgress(iterations, 1000);
	    			 
	    			            //Block the thread for a short time, but be sure
	    			            //to check the InterruptedException for cancellation
	    			            try {
	    			                Thread.sleep(0);
	    			            } catch (InterruptedException interrupted) {
	    			                if (isCancelled()) {
	    			                    updateMessage("Cancelled");
	    			                    break;
	    			                }
	    			            }
	    			        }
	    			        return iterations;
	    			        */
	    			    }
	    			};
	    			Thread th = new Thread(task);
	    	        th.setDaemon(true);
	    	        th.start();
	    		//	connectStatusShow.setText(wmpc.getConnectionStatus());
	    			
	    		connecthotspot.setText("WAIT!!Check sender progress of sending");
	    		connecthotspot.setVisible(true);
						try {
							th.join();
							stopaccesspoint();
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	    		//try {
					//t1.join();
					//stopaccesspoint();
			//	} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
				//	e1.printStackTrace();
			//	} catch (IOException e1) {
					// TODO Auto-generated catch block
				//	e1.printStackTrace();
			//	}
 catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
							 //pi.setProgress(1.0);
							// list.setVisible(true);
					
				/*		 pi.setProgress(1.0);
						 try {
							stopaccesspoint();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						*/
	    		}
    		};
	    		
			clickok.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,eventHandlerclickok);
			
			}		
			
			}	
		};
	
		clickreceive.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,eventHandlerReceive);
		
		EventHandler<MouseEvent> eventHandlerSend = new EventHandler<MouseEvent>() {
			String ip;
			@Override
			public void handle(MouseEvent e) {
				
VBox vboxConnectMouse1=new VBox();
vboxConnectMouse1.setSpacing(100);
vboxConnectMouse1.setPadding(new Insets(100,10,100,10));//top,rihgt,bottom,left
vboxConnectMouse1.setAlignment(Pos.BASELINE_CENTER);
				
				//vboxConnectMouse1.setAlignment(Pos.BASELINE_CENTER);
					
						
						 Button clickToAndroid=new Button("TO ANDROID");
						
						 Button clickToPC=new Button("To PC");
						// vboxConnectMouse.getChildren().add(enterCode);
						 vboxConnectMouse1.getChildren().add(clickToAndroid);
						// vboxConnectMouse.getChildren().add(connectStatusShow);
						 vboxConnectMouse1.getChildren().add(clickToPC);
						
						//	 vboxConnectMouse1.getChildren().add(clickok);
						
				//String codeString=enterCode.getText().toString().trim();
			//	try{
				//setCode(Integer.parseInt(enterCode.getText()));
			//	}catch(NumberFormatException e1){
				//	e1.printStackTrace();
			//	}
						// IPv4 usage
				
						 vboxConnectMouse1.setStyle("-fx-background-color: WHITE;");
						 clickToAndroid.setStyle("-fx-background-color: blue; -fx-text-fill:white;-fx-border-radius: 20;-fx-background-radius: 20;-fx-padding: 5;");
						 clickToPC.setStyle("-fx-background-color: blue; -fx-text-fill:white;-fx-border-radius: 20;-fx-background-radius: 20;-fx-padding: 5;");
				Scene sceneConnectMouse1 = new Scene(vboxConnectMouse1,400,400);
	    			Stage ssend=new Stage();
				sceneConnectMouse1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				ssend.setScene(sceneConnectMouse1);
				//homeStage.close();
				ssend.show();
EventHandler<MouseEvent> eventHandlerToAndroid = new EventHandler<MouseEvent>() {
					
		    		@Override
		    		public void handle(MouseEvent e) {
		    	    	//WifiMousePc wmpc=new WifiMousePc();
		    			//System.out.println(codeString);
		    			
		    			//StartThread2 st=new StartThread2();
		    		//	SendFileName sfn=new SendFileName();
		    			//StartThread2 st2=new StartThread2();
		    		//	Thread t1=new Thread(sfn);
//		    			Thread t2=new Thread(st2);
		    			//t2.start();
		    			//try {
		    			//	t2.join();//complete my thread then other//after start
		    			//} catch (InterruptedException e) {
		    				// TODO Auto-generated catch block
		    				//e.printStackTrace();
//		    			}
		    			//t1.start();
		    			
		    			//t1.stop();
		    		//	connectStatusShow.setText(wmpc.getConnectionStatus());
		    			//setConnectIp(enterCode.getText().toString().trim());
		    		//	if(connectIp.isEmpty()){
		    				//System.out.println("please enter field");
		    		//	}
		    			//else{
		    				
		    			//}
		    			
		    		//	Stage stage=new Stage();
		    			//Button a=new Button();
		    		//	PBar.start(stage,a);	
		    			FileSelect();
						
		    			/*		try {
		    						setaccesspoint();
		    					} catch (IOException e2) {
		    						// TODO Auto-generated catch block
		    						e2.printStackTrace();
		    					}
		    					if(setacpt){
		    						try {
		    							startaccesspoint();
		    						} catch (IOException e1) {
		    							// TODO Auto-generated catch block
		    							e1.printStackTrace();
		    						}
		    					}
		    					*/
		    					if(startacpt){
		    					VBox vboxConnectMouse=new VBox();
		    					//vboxConnectMouse.setSpacing(50);
		    			       // vboxConnectMouse.setPadding(new Insets(100,10,100,10));//top,rihgt,bottom,left
		    			//	vboxConnectMouse.setAlignment(Pos.BASELINE_CENTER);
		    					
		    				/*	vboxConnectMouse.setAlignment(Pos.BASELINE_CENTER);
		    						Inet4Address localhost;
		    						try {
		    							localhost = (Inet4Address) Inet4Address.getLocalHost();
		    							pcmIP=localhost.toString();
		    							
		    		/*byte[] ip = localhost.getAddress();
		    					 		
		    					 		// looping
		    						for (int i = 1; i <= 254; i++)
		    							{
		    								ip[3] = (byte)i;
		    								InetAddress address = InetAddress.getByAddress(ip);
		    							if (address.isReachable(1000))
		    							{
		    								System.out.println(address + " - Pinging... Pinging");
		    							}
		    							else if (!address.getHostAddress().equals(address.getHostName()))
		    							{
		    								System.out.println(address + " - DNS lookup known..");
		    							}
		    							else
		    							{
		    								System.out.println(address + " - the host address and the host name are same");
		    							}
		    							}*/
		    						//} catch (IOException e1) {
		    							// TODO Auto-generated catch block
		    						//	e1.printStackTrace();
		    						//}
		    						//	Label showIP=new Label();
		    							
		    							//vboxConnectMouse.getChildren().add(showIP);
		    							//String t=serip.substring(serip.lastIndexOf("/")+1);
		    							//showIP.setText(pcmIP.substring(pcmIP.lastIndexOf("/")+1));
		    							//showIP.setText(getIp4());
		    							// System.out.println(localhost);
		    							HBox hbox=new HBox();
		    							hbox.setAlignment(Pos.BASELINE_LEFT);
		    							hbox.setSpacing(10.0);
		    							//hbox.setAlignment(Pos.BASELINE_CENTER);
		    							TextField enterCode=new TextField();
		    							enterCode.setPromptText("Enter from Android");
		    							enterCode.setPrefColumnCount(15);
		    							 hbox.getChildren().add(enterCode);
		    							 Button clickSendToAndroid=new Button("VALIDATE");
		    							 hbox.getChildren().add(clickSendToAndroid);
		    							 Label connectStatusShow=new Label("connection status");
		    							 
		    						//	 connectStatusShow.setAlignment(Pos.BOTTOM_CENTER);
		    							 Button clickok=new Button("SEND");
		    							// clickok.setAlignment(Pos.BASELINE_CENTER);
		    							// vboxConnectMouse.getChildren().add(enterCode);
		    							 vboxConnectMouse.getChildren().add(hbox);
		    							 //vboxConnectMouse.getChildren().add(connectStatusShow);
		    							// clickok.setVisible(false);
		    							 ProgressBar pb=new ProgressBar();
		    							ProgressIndicator pi=new ProgressIndicator(0);
		    							//vboxConnectMouse.getChildren().add(pb);
		    							
		    							// pi.setVisible(false);
		    							//   ProgressBar pbY = new ProgressBar(0);
		    							//  ProgressIndicator piY = new ProgressIndicator(0);
		    							
		    							// vboxConnectMouse.getChildren().add(piY);
		    						//	 Label l=new Label();
		    							// vboxConnectMouse.getChildren().add(l);
		    							// vboxConnectMouse.getChildren().add(connectStatusShow);
		    						//	 vboxConnectMouse.getChildren().add(connectStatusShow);
		    							 ListView<String> list = new ListView<String>();
		    							 list.setPrefSize(100, 300);
		    						//	list.setSize
		    							// list.setVisible(false);
		    							 
		    							 vboxConnectMouse.getChildren().add(list);
		    						 vboxConnectMouse.getChildren().add(clickok);
		    						 vboxConnectMouse.getChildren().add(pi);
		    						 
		    						
		    						 clickok.setVisible(false);
		    						 list.setVisible(false);
		    						 pi.setVisible(false);
		    							// pbY.setProgress((int)((SendFileAll.getCurrentsend()*100)/SendFileAll.getTotal()));
		    						
		    						//	list.setItems(Main.FILE_TO_RECEIVE_LIST);
		    					//String codeString=enterCode.getText().toString().trim();
		    				//	try{
		    					//setCode(Integer.parseInt(enterCode.getText()));
		    				//	}catch(NumberFormatException e1){
		    					//	e1.printStackTrace();
		    				//	}
		    							// IPv4 usage
		    					
		    						//System.out.println(getP());
		    						hbox.setStyle("-fx-background-color: WHITE;");
		    						 vboxConnectMouse.setStyle("-fx-background-color: WHITE;");
		    						// showIP.setStyle("-fx-font: normal bold 20px 'serif' ");
		    						 clickSendToAndroid.setStyle("-fx-background-color: blue; -fx-text-fill:white;-fx-border-radius: 20;-fx-background-radius: 20;-fx-padding: 5;");
		    						 clickok.setStyle("-fx-background-color: blue; -fx-text-fill:white;-fx-border-radius: 20;-fx-background-radius: 20;-fx-padding: 5;");		 
		    					Scene sceneConnectMouse = new Scene(vboxConnectMouse,400,400);
		    		    			Stage s=new Stage();
		    					sceneConnectMouse.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		    					s.setScene(sceneConnectMouse);
		    					ssend.close();
		    					s.show();
		    					
		    					
		    					EventHandler<MouseEvent> eventHandlerSendToAndroid = new EventHandler<MouseEvent>() {
		    						
		    			    		@Override
		    			    		public void handle(MouseEvent e) {
		    			    	    	//WifiMousePc wmpc=new WifiMousePc();
		    			    			//System.out.println(codeString);
		    			    			
		    			    			//StartThread2 st=new StartThread2();
		    			    		//	SendFileName sfn=new SendFileName();
		    			    			//StartThread2 st2=new StartThread2();
		    			    		//	Thread t1=new Thread(sfn);
//		    			    			Thread t2=new Thread(st2);
		    			    			//t2.start();
		    			    			//try {
		    			    			//	t2.join();//complete my thread then other//after start
		    			    			//} catch (InterruptedException e) {
		    			    				// TODO Auto-generated catch block
		    			    				//e.printStackTrace();
//		    			    			}
		    			    			//t1.start();
		    			    			
		    			    			//t1.stop();
		    			    		//	connectStatusShow.setText(wmpc.getConnectionStatus());
		    			    			setConnectIp(enterCode.getText().toString().trim());
		    			    			if(connectIp.isEmpty()){
		    			    				System.out.println("please enter field");
		    			    			}
		    			    			else{
		    			    				hbox.setVisible(false);
		    			    				SendFileName sfn=new SendFileName();
		    			    				try {
		    									sfn.File2();
		    									
		    								} catch (IOException e1) {
		    									// TODO Auto-generated catch block
		    									e1.printStackTrace();
		    								}
		    			    			//	vboxConnectMouse.getChildren().remove(hbox);
		    			    				list.setVisible(true);
		    			    				
		    			    				ObservableList<String> items =FXCollections.observableArrayList();
		    								 for(String f:Main.FILE_TO_RECEIVE_LIST){
		    									 items.add(f);
		    								 }
		    								// items=(ObservableList<String>) Main.FILE_TO_RECEIVE_LIST;
	   										 list.setItems(items);
	   										clickok.setVisible(true);
	   										pi.setVisible(true);
	   										
		    			    				// vboxConnectMouse.getChildren().add(list);
			    							//	 vboxConnectMouse.getChildren().add(clickok);
			    							
		    			    			}
		    			    			
		    			    		}
		    		    		};
		    			    		
		    					clickSendToAndroid.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,eventHandlerSendToAndroid);
		    					
		    		EventHandler<MouseEvent> eventHandlerclickok= new EventHandler<MouseEvent>() {
		    						
		    			    		@Override
		    			    		public void handle(MouseEvent e) {
		    			    	    	//WifiMousePc wmpc=new WifiMousePc();
		    			    			//System.out.println(codeString);
		    			    			
		    			    		
		    			    			//ReceiveFileAll sfa=new ReceiveFileAll();
		    			    			//StartThread2 st2=new StartThread2();
		    			    			//Thread t1=new Thread(sfa);
//		    			    			Thread t2=new Thread(st2);
		    			    			//t2.start();
		    			    			//try {
		    			    			//	t2.join();//complete my thread then other//after start
		    			    			//} catch (InterruptedException e) {
		    			    				// TODO Auto-generated catch block
		    			    				//e.printStackTrace();
//		    			    			}
		    			    		//	t1.start();
		    			    			//t1.stop();
		    			    			//PBar.launch(args);
		    			    			
		    			    			 
		    			    			
		    			    			
		    			    			
		    			    		//	connectStatusShow.setText(wmpc.getConnectionStatus());
		    			    			SendFileAll sfa=new SendFileAll();
		    			    			try {
		    			    				
		    			    			//	clickok.removeEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,eventHandlerclickok);	    			    				
		    								sfa.sendFile();
		    								
		    								//stopaccesspoint();
		    								//list.setVisible(false);
		    								//pi.setVisible(false);
		    							} catch (IOException e1) {
		    								// TODO Auto-generated catch block
		    								e1.printStackTrace();
		    							}
		    			    			clickok.setVisible(false);
		    			    			pi.setProgress(1.0);
		    			    			
	    								// 
    			    				//vboxConnectMouse.getChildren().add(clickok);
		    			    			
		    			    			//vboxConnectMouse.getChildren().remove(clickok);
		    			    			
		    			    		}
		    		    		};
		    			    		
		    					clickok.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,eventHandlerclickok);
		    					
		    					}		
		    					
		    			
		    		}
	    		};
		    		
				clickToAndroid.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,eventHandlerToAndroid);
EventHandler<MouseEvent> eventHandlerToPC = new EventHandler<MouseEvent>() {
					
		    		@Override
		    		public void handle(MouseEvent e) {
		    	    	//WifiMousePc wmpc=new WifiMousePc();
		    			//System.out.println(codeString);
		    			
		    			//StartThread2 st=new StartThread2();
		    		//	SendFileName sfn=new SendFileName();
		    			//StartThread2 st2=new StartThread2();
		    		//	Thread t1=new Thread(sfn);
//		    			Thread t2=new Thread(st2);
		    			//t2.start();
		    			//try {
		    			//	t2.join();//complete my thread then other//after start
		    			//} catch (InterruptedException e) {
		    				// TODO Auto-generated catch block
		    				//e.printStackTrace();
//		    			}
		    			//t1.start();
		    			
		    			//t1.stop();
		    		//	connectStatusShow.setText(wmpc.getConnectionStatus());
		    			
		FileSelectPC();
						
		    			/*		try {
		    						setaccesspoint();
		    					} catch (IOException e2) {
		    						// TODO Auto-generated catch block
		    						e2.printStackTrace();
		    					}
		    					if(setacpt){
		    						try {
		    							startaccesspoint();
		    						} catch (IOException e1) {
		    							// TODO Auto-generated catch block
		    							e1.printStackTrace();
		    						}
		    					}
		    					*/
		    					if(startacpt){
		    					VBox vboxConnectMouse=new VBox();
		    					
		    					//vboxConnectMouse.setAlignment(Pos.BASELINE_CENTER);
		    					//	Inet4Address localhost;
		    						//try {
		    						//	localhost = (Inet4Address) Inet4Address.getLocalHost();
		    						//	pcmIP=localhost.toString();
		    							
		    		/*byte[] ip = localhost.getAddress();
		    					 		
		    					 		// looping
		    						for (int i = 1; i <= 254; i++)
		    							{
		    								ip[3] = (byte)i;
		    								InetAddress address = InetAddress.getByAddress(ip);
		    							if (address.isReachable(1000))
		    							{
		    								System.out.println(address + " - Pinging... Pinging");
		    							}
		    							else if (!address.getHostAddress().equals(address.getHostName()))
		    							{
		    								System.out.println(address + " - DNS lookup known..");
		    							}
		    							else
		    							{
		    								System.out.println(address + " - the host address and the host name are same");
		    							}
		    							}*/
		    					//	} catch (IOException e1) {
		    							// TODO Auto-generated catch block
		    						//	e1.printStackTrace();
		    					//	}
		    							Label showIP=new Label();
		    							
		    							//vboxConnectMouse.getChildren().add(showIP);
		    							//String t=serip.substring(serip.lastIndexOf("/")+1);
		    							//showIP.setText(pcmIP.substring(pcmIP.lastIndexOf("/")+1));
		    							showIP.setText(getIp4());
		    							// System.out.println(localhost);
		    							HBox hbox=new HBox();
		    							hbox.setAlignment(Pos.BASELINE_LEFT);
		    							hbox.setSpacing(10.0);
		    							TextField enterCode=new TextField();
		    							enterCode.setPromptText("Enter from PC");
		    						//	enterCode.setPrefColumnCount(10);
		    							 hbox.getChildren().add(enterCode);
		    							 Button clickSendToPC=new Button("VALIDATE");
		    							 hbox.getChildren().add(clickSendToPC);
		    							// Label connectStatusShow=new Label("connection status");
		    							 
		    							// connectStatusShow.setAlignment(Pos.BOTTOM_CENTER);
		    							 Button clickok=new Button("SEND");
		    							// vboxConnectMouse.getChildren().add(enterCode);
		    							 vboxConnectMouse.getChildren().add(hbox);
		    							// vboxConnectMouse.getChildren().add(connectStatusShow);
		    						//	 vboxConnectMouse.getChildren().add(connectStatusShow);
		    							//ProgressIndicator pi=new ProgressIndicator();
		    							 ProgressIndicator pi=new ProgressIndicator(0);
		    							 ListView<String> list = new ListView<String>();
		    							 list.setPrefSize(100, 200);
		    						//	list.setSize
		    							// list.setVisible(false);
		    							 
		    							 vboxConnectMouse.getChildren().add(list);
		    						 vboxConnectMouse.getChildren().add(clickok);
		    						 vboxConnectMouse.getChildren().add(pi);
		    						 
		    						
		    						 clickok.setVisible(false);
		    						 list.setVisible(false);
		    						 pi.setVisible(false);
		    								
		    					//String codeString=enterCode.getText().toString().trim();
		    				//	try{
		    					//setCode(Integer.parseInt(enterCode.getText()));
		    				//	}catch(NumberFormatException e1){
		    					//	e1.printStackTrace();
		    				//	}
		    							// IPv4 usage
		    					
		    									hbox.setStyle("-fx-background-color: WHITE;");
		   		    						 vboxConnectMouse.setStyle("-fx-background-color: WHITE;");
		   		    						// showIP.setStyle("-fx-font: normal bold 20px 'serif' ");
		   		    						 clickSendToPC.setStyle("-fx-background-color: blue; -fx-text-fill:white;-fx-border-radius: 20;-fx-background-radius: 20;-fx-padding: 5;");
		   		    						 clickok.setStyle("-fx-background-color: blue; -fx-text-fill:white;-fx-border-radius: 20;-fx-background-radius: 20;-fx-padding: 5;");		 			
		    					Scene sceneConnectMouse = new Scene(vboxConnectMouse,400,400);
		    		    			Stage s=new Stage();
		    					sceneConnectMouse.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		    					s.setScene(sceneConnectMouse);
		    					ssend.close();
		    					s.show();
		    					
		    					
		    					EventHandler<MouseEvent> eventHandlerSendToPC = new EventHandler<MouseEvent>() {
		    						
		    			    		@Override
		    			    		public void handle(MouseEvent e) {
		    			    	    	//WifiMousePc wmpc=new WifiMousePc();
		    			    			//System.out.println(codeString);
		    			    			
		    			    			//StartThread2 st=new StartThread2();
		    			    		//	SendFileName sfn=new SendFileName();
		    			    			//StartThread2 st2=new StartThread2();
		    			    		//	Thread t1=new Thread(sfn);
//		    			    			Thread t2=new Thread(st2);
		    			    			//t2.start();
		    			    			//try {
		    			    			//	t2.join();//complete my thread then other//after start
		    			    			//} catch (InterruptedException e) {
		    			    				// TODO Auto-generated catch block
		    			    				//e.printStackTrace();
//		    			    			}
		    			    			//t1.start();
		    			    			
		    			    			//t1.stop();
		    			    		//	connectStatusShow.setText(wmpc.getConnectionStatus());
		    			    			setConnectIp(enterCode.getText().toString().trim());
		    			    			if(connectIp.isEmpty()){
		    			    				System.out.println("please enter field");
		    			    			}
		    			    			else{
		    			    				hbox.setVisible(false);
		    			    				PcSendFileName sfn=new PcSendFileName();
		    			    				try {
		    									sfn.File2();
		    									
		    								} catch (IOException e1) {
		    									// TODO Auto-generated catch block
		    									e1.printStackTrace();
		    								}
		    			    			//	vboxConnectMouse.getChildren().remove(hbox);
		    			    				list.setVisible(true);
		    			    				
		    			    				ObservableList<String> items =FXCollections.observableArrayList();
		    								 for(String f:Main.FILE_TO_RECEIVE_LIST){
		    									 items.add(f);
		    								 }
		    								// items=(ObservableList<String>) Main.FILE_TO_RECEIVE_LIST;
	   										 list.setItems(items);
	   										clickok.setVisible(true);
	   										pi.setVisible(true);
	   										
		    			    				// vboxConnectMouse.getChildren().add(list);
			    							//	 vboxConnectMouse.getChildren().add(clickok);
			    							
		    			    			}
		    			    			
		    			    		}
		    		    		};
		    			    		
		    					clickSendToPC.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,eventHandlerSendToPC);
		    					
		    		EventHandler<MouseEvent> eventHandlerclickok= new EventHandler<MouseEvent>() {
		    						
		    			    		@Override
		    			    		public void handle(MouseEvent e) {
		    			    	    	//WifiMousePc wmpc=new WifiMousePc();
		    			    			//System.out.println(codeString);
		    			    			
		    			    			
		    			    			//ReceiveFileAll sfa=new ReceiveFileAll();
		    			    			//StartThread2 st2=new StartThread2();
		    			    			//Thread t1=new Thread(sfa);
//		    			    			Thread t2=new Thread(st2);
		    			    			//t2.start();
		    			    			//try {
		    			    			//	t2.join();//complete my thread then other//after start
		    			    			//} catch (InterruptedException e) {
		    			    				// TODO Auto-generated catch block
		    			    				//e.printStackTrace();
//		    			    			}
		    			    		//	t1.start();
		    			    			//t1.stop();
		    	
		    			    		//	connectStatusShow.setText(wmpc.getConnectionStatus());
		    			    			//SendFileAll sfa=new SendFileAll();
		    			    	//	try {
		    						//		sfa.sendFile(pbY,piY,l);
		    							//} catch (IOException e1) {
		    								// TODO Auto-generated catch block
		    								//e1.printStackTrace();
		    						//	}
		    			    			PcSendFileAll sfa=new PcSendFileAll();
		    			    			try {
		    			    				clickok.setVisible(false);
		    			    			//	clickok.removeEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,eventHandlerclickok);	    			    				
		    								sfa.sendFile();
		    								pi.setProgress(1.0);
		    								
		    								//list.setVisible(false);
		    								//pi.setVisible(false);
		    							} catch (IOException e1) {
		    								// TODO Auto-generated catch block
		    								e1.printStackTrace();
		    							}
		    			    			
		    			    			
		    			    		}
		    		    		};
		    			    		
		    					clickok.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,eventHandlerclickok);
		    					
		    					}		
		    					
		    			
		    		}
	    		};
		    		
				clickToPC.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,eventHandlerToPC);
						
				
				
	
				}	
			};
		
			clicksend.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,eventHandlerSend);
	}
	
	public Boolean setaccesspoint() throws IOException{
		  String command1 = "netsh wlan set hostednetwork mode=allow ssid=ENXHe12rtsXTY key=456wmfs654";
		  Process p1 = Runtime.getRuntime().exec(command1);
        //  Process p2 = Runtime.getRuntime().exec(command2);
        //  System.out.println("create connect");
          try {
            //  p1.waitFor();
              p1.waitFor();
          } catch (InterruptedException ex) {
              ex.printStackTrace();
              
          }
		setacpt=true;
		//Runtime.getRuntime().exec(new String[] {"netsh", "wlan", "set", "hostednetwork","mode=allow","ssid=wifimouseconnection","key=23mouse49"});
		return setacpt; 
	}
	public Boolean startaccesspoint() throws IOException{
		startacpt=true;
		String command1 = "netsh wlan start hostednetwork";
		  Process p1 = Runtime.getRuntime().exec(command1);
      //  Process p2 = Runtime.getRuntime().exec(command2);
      //  System.out.println("satrt connect");
        try {
          //  p1.waitFor();
            p1.waitFor();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            
        }
        return startacpt;
	}
	public  void stopaccesspoint() throws IOException{
		startacpt=true;
		String command1 = "netsh wlan stop hostednetwork";
		  Process p1 = Runtime.getRuntime().exec(command1);
      //  Process p2 = Runtime.getRuntime().exec(command2);
      //  System.out.println("stop");
        try {
          //  p1.waitFor();
            p1.waitFor();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            
        }
        //return startacpt;
	}
	
	public String getIp4(){

        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface iface = interfaces.nextElement();
                // filters out 127.0.0.1 and inactive interfaces
                if (iface.isLoopback() || !iface.isUp())
                    continue;

                Enumeration<InetAddress> addresses = iface.getInetAddresses();
                while(addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();

                    // *EDIT*
                    if (addr instanceof Inet6Address) continue;

                    pcmIP = addr.getHostAddress();
                   // System.out.println(iface.getDisplayName() + " " + pcmIP);
                }
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
return pcmIP;
    }
	public static void main(String[] args) {
		launch(args);
	}
	public void FileSelect(){
		//FILE_TO_SEND_LIST=new ArrayList();
		//FILE_TO_RECEIVE_LIST=new ArrayList();
		List<String> filesendlist=new ArrayList();
		List<String> filereceivelist=new ArrayList();
		FileChooser fc = new FileChooser();
		// fc.setInitialDirectory(
	        //        new File(System.getProperty("user.home"))
	                //new File(System.getProperty("C:\\Users"))
	        //    );                 
	            fc.getExtensionFilters().addAll(
	               new FileChooser.ExtensionFilter("All Files", "*.*")
	             //  new FileChooser.ExtensionFilter("JPG", "*.jpg"),
	              //  new FileChooser.ExtensionFilter("PNG", "*.png")
	            );
	            
	     List<File> selectedFiles = fc.showOpenMultipleDialog(null);
	                    if (selectedFiles != null) {
	                    	for(int i=0;i<selectedFiles.size();i++){ 
	                    		
	                    		filesendlist.add(selectedFiles.get(i).getAbsolutePath());
	                    		filereceivelist.add(selectedFiles.get(i).getName());
	                    	//	listview.getItems().add(selectedFiles.get(i).getName()); 
	                    		
	                    		}
	                    //	StartThread st=new StartThread();
	                    //	StartThread2 st2=new StartThread2();
	                    	//Thread t1=new Thread(st);
	                   // 	Thread t2=new Thread(st2);
	                    //	t2.start();
	                    
	                    //	try {
								//File2();
						///	} catch (IOException e) {
								// TODO Auto-generated catch block
							//	System.out.println("receiver is not active");
							//	e.printStackTrace();
							//}
	                    //	t2.stop();
	                    	setFILE_TO_SEND_LIST(filesendlist);
	                    	setFILE_TO_RECEIVE_LIST(filereceivelist);
	                    	try {
	        					setaccesspoint();
	        				} catch (IOException e2) {
	        					// TODO Auto-generated catch block
	        					e2.printStackTrace();
	        				}
	            			if(setacpt){
	            				try {
	        						startaccesspoint();
	        					} catch (IOException e1) {
	        						// TODO Auto-generated catch block
	        						e1.printStackTrace();
	        					}
	            			}
	                    }
	               
	                    else {
	                    	//System.out.println("Not selected");
	                    }
	                }

	public void FileSelectPC(){
		//FILE_TO_SEND_LIST=new ArrayList();
		//FILE_TO_RECEIVE_LIST=new ArrayList();
		List<String> filesendlist=new ArrayList();
		List<String> filereceivelist=new ArrayList();
		FileChooser fc = new FileChooser();
		// fc.setInitialDirectory(
	        //        new File(System.getProperty("user.home"))
	                //new File(System.getProperty("C:\\Users"))
	        //    );                 
	            fc.getExtensionFilters().addAll(
	               new FileChooser.ExtensionFilter("All Files", "*.*")
	             //  new FileChooser.ExtensionFilter("JPG", "*.jpg"),
	              //  new FileChooser.ExtensionFilter("PNG", "*.png")
	            );
	            
	     List<File> selectedFiles = fc.showOpenMultipleDialog(null);
	                    if (selectedFiles != null) {
	                    	for(int i=0;i<selectedFiles.size();i++){ 
	                    		
	                    		filesendlist.add(selectedFiles.get(i).getAbsolutePath());
	                    		filereceivelist.add(selectedFiles.get(i).getName());
	                    	//	listview.getItems().add(selectedFiles.get(i).getName()); 
	                    		
	                    		}
	                    //	StartThread st=new StartThread();
	                    //	StartThread2 st2=new StartThread2();
	                    	//Thread t1=new Thread(st);
	                   // 	Thread t2=new Thread(st2);
	                    //	t2.start();
	                    
	                    //	try {
								//File2();
						///	} catch (IOException e) {
								// TODO Auto-generated catch block
							//	System.out.println("receiver is not active");
							//	e.printStackTrace();
							//}
	                    //	t2.stop();
	                    	setFILE_TO_SEND_LIST(filesendlist);
	                    	setFILE_TO_RECEIVE_LIST(filereceivelist);
	                    	startacpt=true;
	                    }
	               
	                    else {
	                    	//System.out.println("Not selected");
	                    }
	                }
	
			
		
}
