package choi.yeonho.bookstore.domain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import choi.yeonho.bookstore.main.Main;

public class DBIO {
	
	/*public static boolean checkFile(String path, String fileName) {
		File dirFile = new File(path);
		File[] fileList = dirFile.listFiles();
		for(File tempFile : fileList) {
			if(tempFile.isFile()) {
				if(fileName.equals(tempFile.getName())) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void saveDB(String fileName, Object obj) {
		try {
			FileOutputStream fs = new FileOutputStream(fileName);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(obj);
			System.out.println(fileName + " �� �����߽��ϴ�.");
			os.close();
			fs.close();
		} catch(Exception e) {e.printStackTrace();}
	}
	
	public static Object loadDB(String fileName) {
		Object obj = new Object();
		if(checkFile(Main.PATH, fileName)) {
			try{
				FileInputStream fi = new FileInputStream(fileName);
				ObjectInputStream is = new ObjectInputStream(fi);
				obj = is.readObject();
				System.out.println(fileName + " �� �ҷ��Խ��ϴ�.");
				is.close();
				fi.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("������ ã�� �� �����ϴ�.");
		}
		return obj;
	}*/
}
