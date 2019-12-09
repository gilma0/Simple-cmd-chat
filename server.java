

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket server = new ServerSocket(2222);
		Socket sock = server.accept();
		InputStream kaka = sock.getInputStream();
		InputStreamReader kaki = new InputStreamReader(kaka);
		BufferedReader shula = new BufferedReader(kaki);
		OutputStream out = sock.getOutputStream();
		OutputStreamWriter out1 = new OutputStreamWriter(out);
		BufferedWriter out2 = new BufferedWriter(out1);
		Runnable mama = () -> {
			while(true) {
				Scanner scan = new Scanner(System.in);
				String output = scan.nextLine();
				try {
					out2.write(output + "\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					out2.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Thread t1 = new Thread(mama);
		t1.start();
		while(true) {
			if(shula.ready()) {
				String temp = shula.readLine();
				System.out.println("the other side: " + temp);
			}
		}
		
	}

}
