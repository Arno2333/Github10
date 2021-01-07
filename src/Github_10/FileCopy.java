package Github_10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {
	public static void main(String[] args) {
		System.out.println("正在复制...");
		copy("E:\\input.txt","E:\\output.txt");
		System.out.println("复制成功");
	}
	
	private static void copy(String src,String target) {
		//创建源文件，和目标文件
		File srcFile = new File(src);
		File targetFile = new File(target);
		//创建输入输出流
		InputStream in =  null;
		OutputStream out = null;
		
		try {
			in = new FileInputStream(srcFile);
			out = new FileOutputStream(targetFile);
			byte[] bytes = new byte[1024];
			int len = -1;
			while((len = in.read(bytes))!=-1) {
				out.write(bytes,0,len);
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(in != null) in.close();
				if(out != null) out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
