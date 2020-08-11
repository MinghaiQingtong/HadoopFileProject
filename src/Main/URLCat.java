package Main;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.io.IOUtils;

public class URLCat {
	//本程序运行在namenode节点上，使用命令：hadoop jar ./URLCat.jar Main.URLCat hdfs://tangtong:9000/input2.txt
	static {
		URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
	}
	public static void main(String[] args) throws Exception, IOException {
		InputStream in = null;
		try {
			in = new URL(args[0]).openStream();//args[0] = hdfs://tangtong:9000/input2.txt  
//			byte[] buffer = new byte[30];
//			while(in.read(buffer) != -1) {
//				System.out.println(buffer);
//			}
			IOUtils.copyBytes(in, System.out, 4096, false);
		} finally {
			IOUtils.closeStream(in);
		}
	}
	
	
}
