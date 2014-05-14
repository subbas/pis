package com.pis.timer;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

 

public class RunMyJob {
	public void sampleMethod() {
		
		String dbName = "pisdb";
		String dbUserName = "root";
		String dbPassword = "root";
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-H-m");
		String datum = sdf.format(new Date());
		String path = "C:\\pomoc\\mysqldump-"+datum+".sql";
		
		File file = new File(path);
		try {
			if (file.createNewFile()){
			    System.out.println("Vytvoril sa subor pre zalohu!");
			    System.out.println("zalohujem..");
				backupDB(dbName,dbUserName,dbPassword,path);
			  }else{
			    System.out.println("Vyskytli sa problemy pri vytvarani suboru pre zalohu!!! Zaloha sa vytvori do defaultneho suboru");
			    System.out.println("zalohujem..");
				backupDB(dbName,dbUserName,dbPassword,"C:\\pomoc\\mysqldump.sql");
			  }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean backupDB(String dbName, String dbUserName, String dbPassword, String path) {
		 
        String executeCmd = "mysqldump -u " + dbUserName + " -p" + dbPassword + " --add-drop-database -B " + dbName + " -r " + path;
        Process runtimeProcess;
        try {
 
            runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();
 
            if (processComplete == 0) {
                System.out.println("Vytvorila sa zaloha");
                return true;
            } else {
                System.out.println("Nepodarilo sa vytvorit zalohu!!!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
 
        return false;
    }
}