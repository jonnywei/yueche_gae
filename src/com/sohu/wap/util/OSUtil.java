package com.sohu.wap.util;

public class OSUtil {
	
	public static int LINUX = 0;
	public static int WINDOWS =1;
	
	public static int UNKNOWN=10;

	public static int getOSType(){
		String osName =System.getProperty("os.name");
		if(osName == null){
			return UNKNOWN;
		}
		osName =osName.toUpperCase();
		if (osName.indexOf("WINDOW") != -1){
			return 	WINDOWS;
		}else if(osName.indexOf("LINUX") != -1){
			return LINUX;
		}else{
			return UNKNOWN;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(System.getProperty("os.name")) ;
		while(true){
			System.out.println(getFakeIp()) ;
		}
		
	}
	
	public static String getFakeIp(){
		StringBuilder sb = new StringBuilder();
		int maxNum =255;
		for (int i = 0; i < 4; i++){
			sb.append(RandomUtil.getRandomInt(maxNum));
			if (i != 3){
				sb.append(".");
			}
		}
		return sb.toString();
	}

}
