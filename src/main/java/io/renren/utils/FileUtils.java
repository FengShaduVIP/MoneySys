package io.renren.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

public class FileUtils {

	private static Logger logger = Logger.getLogger(FileUtils.class);

	public static void saveTestBenchFile(MultipartFile uploadFile,
			String itemId, String fileName) {

		String TI_KU = PublicUtils.getConfig("TI_KU");
		String filePath = TI_KU + File.separator + (itemId) + File.separator
				+ fileName + "_tb.v";
		File file = new File(filePath);
		if (file.exists())
			file.delete();
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		try {
			InputStream inputStream = uploadFile.getInputStream();
			byte[] b = new byte[1024 * 1024];
			int length = inputStream.read(b);
			FileOutputStream outputStream = new FileOutputStream(filePath);
			outputStream.write(b, 0, length);
			file.setExecutable(true);// 设置可执行权限
			file.setReadable(true);// 设置可读权限
			file.setWritable(true);// 设置可写权限
			inputStream.close();
			outputStream.close();
		} catch (Exception e) {
			logger.error(e);
		}
		/*
		 * } else { logger.info("test_bench文件为空。"); }
		 */
	}

	/**
	 * @throws IOException
	 * 
	 */
	public static void updateFile(String itemId, String fileName, String content)
			throws IOException {
		String TI_KU = PublicUtils.getConfig("TI_KU");
		String filePath = TI_KU + File.separator + (itemId) + File.separator
				+ fileName + "_tb.v";
		File file = new File(filePath);
		if (!file.exists()) {
			
		}else{
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
			dos.close();
			file.delete();
			logger.info("文件路径： " + filePath);
		}

		file.setExecutable(true);// 设置可执行权限
		file.setReadable(true);// 设置可读权限
		file.setWritable(true);// 设置可写权限
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		FileWriter filewriter = new FileWriter(file, true);
		BufferedWriter bufwriter = new BufferedWriter(filewriter);
		filewriter.write(content);
		filewriter.flush();
	}

	/**
	 * 从文本文件中读取内容
	 * 
	 * @param path
	 * @return
	 */
	public static String readfile(String path) {
		String readStr = "";
		try {
			File file = new File(path);
			FileReader fileread = new FileReader(file);
			BufferedReader bufread = new BufferedReader(fileread);
			String read = null;
			while ((read = bufread.readLine()) != null) {
				readStr = readStr + read + '\n';
			}
		} catch (Exception d) {
			System.out.println(d.getMessage());
		}
		return readStr; // 返回从文本文件中读取内容
	}

	/**
	 * 把10位时间戳数字转成字符串(混合大小写)
	 * 
	 * @param num
	 * @return
	 */
	private static String n2s(int num) {
		String str = "";
		char _char;
		String numStr = String.valueOf(num);
		for (int i = 0; i < numStr.length(); i++) {
			int n = Integer.parseInt(numStr.substring(i, i + 1));
			if (n <= 2) { // 这里最后一组只保留xyz不转换，用来做分隔符
				_char = (char) (n + 65 + rand(0, 3) * 10 + rand(0, 2) * 32);
			} else {
				_char = (char) (n + 65 + rand(0, 2) * 10 + rand(0, 2) * 32);
			}
			str += _char;
		}
		return str;
	}

	/**
	 * 产生随机整数,范围[m,n)
	 * 
	 * @return
	 */
	private static int rand(int m, int n) {
		return (int) (Math.random() * (n - m) + m);
	}

	public static String ImgName() {
		return n2s(DateUtils.time());
	}
	
}
