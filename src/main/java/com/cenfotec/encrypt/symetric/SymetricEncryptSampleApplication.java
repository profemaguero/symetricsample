package com.cenfotec.encrypt.symetric;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cenfotec.encrypt.symetric.simetricManager.EncryptManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class SymetricEncryptSampleApplication implements CommandLineRunner {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static EncryptManager encryptManager = new EncryptManager();
	
	
	public static void main(String[] args) {
		SpringApplication  app = new SpringApplication(SymetricEncryptSampleApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

	@Override
    public void run(String... args) throws Exception {
		
		int option = 0;
		do {
    		System.out.println("1.Create key");
        	System.out.println("2.Encript Message");
        	System.out.println("3.Decrypt Message");
        	System.out.println("4.Exit ");
        	option = Integer.parseInt(br.readLine());
        	if (option >= 1 && option <= 3){
        		executeAction(option);
        	}
    	} while (option != 4);

    	
    }

	private void executeAction(int option) throws Exception {
		if (option == 1){ 
			System.out.println("Key name: ");
			String name = br.readLine();
			encryptManager.createKey(name);
		}
		if (option == 2){
			System.out.println("Key name: ");
			String name = br.readLine();
			System.out.println("Message name: ");
			String messageName = br.readLine();
			System.out.println("Message: ");
			String message = br.readLine();
			encryptManager.encryptMessage(messageName,message,name);		
		}
		if (option == 3){
			System.out.println("Key name: ");
			String keyName = br.readLine();
			System.out.println("Message name: ");
			String messageName = br.readLine();
			encryptManager.decryptMessage(messageName, keyName);			
		}
	}
}
