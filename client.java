

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Socket sock = new Socket("192.168.1.100", 2222);
		OutputStream out = sock.getOutputStream();
		OutputStreamWriter kaka = new OutputStreamWriter(out);
		BufferedWriter kaki = new BufferedWriter(kaka);
		System.out.println("enter message:");
		Runnable shula = () -> {
			while(true) {
				Scanner scan = new Scanner(System.in);
				String output = scan.nextLine();
				try {
					kaki.write(output + "\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					kaki.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Thread t1 = new Thread(shula);
		t1.start();
		InputStream makita = sock.getInputStream();
		InputStreamReader goku = new InputStreamReader(makita);
		BufferedReader gohan = new BufferedReader(goku);
		Runnable lol = () -> {
			while(true) {
				try {
					if(gohan.ready()) {
						String temp = gohan.readLine();
						System.out.println("the other side: " + temp);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Thread t2 = new Thread(lol);
		t2.start();
	}
}
