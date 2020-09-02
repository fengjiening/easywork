package org.fengjiening.util;


import org.springframework.web.context.request.RequestContextHolder;

import java.io.*;
import java.util.Base64;

public class FileUtils {
	/**缓冲区大小*/
	private static final int BUFFER_SIZE = 5 * 1024;
	
	
	/**
	 * 将文件转成base64 字符串
	 * 
	 * @return String
	 * @throws Exception
	 */
	public static String encodeBase64File(String path) throws Exception {
		File file = new File(path);
		FileInputStream inputFile = new FileInputStream(file);
		byte[] buffer = new byte[(int) file.length()];
		inputFile.read(buffer);
		inputFile.close();
		return Base64.getEncoder().encodeToString(buffer);
	}
	
	/**
	 * 将base64字符解码保存文件
	 * 
	 * @param base64Code
	 * @param targetPath
	 * @throws Exception
	 */
	public static void decoderBase64File(String base64Code, String targetPath) throws Exception {
		FileOutputStream out=null;
	
		try{
			byte[] buffer = Base64.getDecoder().decode(base64Code);
			out= new FileOutputStream(targetPath);
			out.write(buffer);
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			out.close();
		}
	}
	
	/**
	 * 将base64字符保存文本文件
	 * 
	 * @param base64Code
	 * @param targetPath
	 * @throws Exception
	 */
	public static void toFile(String base64Code, String targetPath)
			throws Exception {

		byte[] buffer = base64Code.getBytes();
		FileOutputStream out = new FileOutputStream(targetPath);
		out.write(buffer);
		out.close();
	}

	public static String getPath() {
		try {
			if (RequestContextHolder.getRequestAttributes() != null) {
				String path = FileUtils.class.getClassLoader().getResource("/").getPath().replace("/WEB-INF/classes/", "");
				return path+"/";
			} else {
				String path = FileUtils.class.getClassLoader()
						.getResource("").toString().replace("file:", "")
						.replace("/WEB-INF/classes/", "");
				return path +"/";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String getSignPath() {
		try {
			String path = FileUtils.class.getClassLoader().getResource("/").getPath().replace("/WEB-INF/classes/", "");
			return path+"/";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/** 
	 * 删除目录（文件夹）以及目录下的文件 
	 * @param   sPath 被删除目录的文件路径 
	 * @return  目录删除成功返回true，否则返回false 
	 */  
	public static boolean deleteDirectory(String sPath) {  
	    //如果sPath不以文件分隔符结尾，自动添加文件分隔符  
	    if (!sPath.endsWith(File.separator)) {  
	        sPath = sPath + File.separator;  
	    }  
	    File dirFile = new File(sPath);  
	    //如果dir对应的文件不存在，或者不是一个目录，则退出  
	    if (!dirFile.exists() || !dirFile.isDirectory()) {  
	        return false;  
	    }  
	    boolean flag = true;  
	    //删除文件夹下的所有文件(包括子目录)  
	    File[] files = dirFile.listFiles();  
	    for (int i = 0; i < files.length; i++) {  
	        //删除子文件  
	        if (files[i].isFile()) {  
	            flag = deleteFile(files[i].getAbsolutePath());  
	            if (!flag) break;  
	        } //删除子目录  
	        else {  
	            flag = deleteDirectory(files[i].getAbsolutePath());  
	            if (!flag) break;  
	        }  
	    }  
	    if (!flag) return false;  
	    //删除当前目录  
	    if (dirFile.delete()) {  
	        return true;  
	    } else {  
	        return false;  
	    }  
	} 
	/** 
	 * 删除单个文件 
	 * @param   sPath    被删除文件的文件名 
	 * @return 单个文件删除成功返回true，否则返回false 
	 */  
	public static boolean deleteFile(String sPath) {  
		boolean flag = false;  
		File file = new File(sPath);  
	    // 路径为文件且不为空则进行删除  
	    if (file.isFile() && file.exists()) {  
	        file.delete();  
	        flag = true;  
	    }  
	    return flag;  
	}

	/**
	 * 复制文件
	 * @param src 本地文件
	 * @param dst 目标文件
	 */
	public static void copy(File src, File dst) {
		InputStream in = null;
		OutputStream out = null;
		FileOutputStream f = null;
		try {
			f = new FileOutputStream(dst);
			in = new BufferedInputStream(new FileInputStream(src),BUFFER_SIZE);
			out = new BufferedOutputStream(f, BUFFER_SIZE);
			byte[] buffer = new byte[BUFFER_SIZE];
			while (in.read(buffer) > 0) {
				out.write(buffer);
			}
		 }catch(Exception e ){
			e.printStackTrace();
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(null != f){
				try {
					f.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	  //int32转换为二进制（4个字节）
    public static byte[] int2byte(int i){
    	byte[] res = new byte[4];
    	res[0] = (byte)(i & 0xff);
    	res[1] = (byte)(i >> 8 & 0xff);
    	res[2] = (byte)(i >> 16 & 0xff);
    	res[3] = (byte)(i >> 24 & 0xff);
    	return res;
    	}
	//获得指定文件的byte数组 
    public static byte[] getBytes(String filePath){  
        byte[] buffer = null;  
        try {  
            File file = new File(filePath);  
            FileInputStream fis = new FileInputStream(file);  
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);  
            byte[] b = new byte[1000];  
            int n;  
            while ((n = fis.read(b)) != -1) {  
                bos.write(b, 0, n);  
            }  
            fis.close();  
            bos.close();  
            buffer = bos.toByteArray();  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return buffer;  
    }

	/**
	 * 将InputStream写入本地文件
	 * @param destination 写入本地目录
	 * @param input 输入流
	 * @throws IOException IOException
	 */
	public static void writeToLocal(String destination, InputStream input)
			throws IOException {
		int index;
		byte[] bytes = new byte[1024];
		FileOutputStream downloadFile = new FileOutputStream(destination);
		while ((index = input.read(bytes)) != -1) {
			downloadFile.write(bytes, 0, index);
			downloadFile.flush();
		}
		input.close();
		downloadFile.close();

	}
    
}
