package banana;

import java.net.InetAddress;

import javax.servlet.http.HttpServletRequest;

public class Util {
	public static String upload() {
		String t = System.getProperty("os.name");
		String upload = "/pukyung20/upload/";
		if( t.indexOf("indows") != -1 ) {
			upload = "C:\\upload\\";
		}
		return upload;
	}
	
	public static String han( String l ) {
		if( l == null || l.equals("") )
			return l;
		try {
			l = new String( l.getBytes("8859_1") , "utf-8");
		}
		catch( Exception e ) {}
		return l;
	}
	
	public static String getRemoteAddr( HttpServletRequest request ) 
	{
		String t = System.getProperty("os.name");
		if( t.indexOf("indows") != -1 ) 
		{
			try {
				return InetAddress.getLocalHost().getHostAddress().toString();
			}
			catch( Exception e ) {
				return "127.0.0.1";
			}
		}
		if( request != null ) {
			String ip = request.getHeader("X-FORWARDED-FOR"); 
	        if (ip == null || ip.length() == 0) {
	            ip = request.getHeader("Proxy-Client-IP");
	        }
	        if (ip == null || ip.length() == 0) {
	            ip = request.getHeader("WL-Proxy-Client-IP");
	        }
	        if (ip == null || ip.length() == 0) {
	            ip = request.getHeader("HTTP_CLIENT_IP");     
	        }
	        if (ip == null || ip.length() == 0) {
	            ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
	        }
	        if (ip == null || ip.length() == 0) {
	            ip = request.getRemoteAddr() ;
	        }
	        return ip;
		}
		return "!!error!!";
	}
	
	public static String alterColor( String l ) {
		/*
		String t = System.getProperty("os.name");
		if( t.indexOf("indows") != -1 ) { }
		*/
		String str = l;
		String text = str.replace(".", "");
		//System.out.println(text);
		
		String strR = text.substring(0, 3);
		int l_strR = Integer.parseInt(strR);
		
		String strG = text.substring(3, 6);
		int l_strG = Integer.parseInt(strG);
		
		String strB = text.substring(6, 8);
		int l_strB = Integer.parseInt(strB);
		
		while( l_strR > 255 ) { l_strR = l_strR - 30; }
		while( l_strR < 120 ) { l_strR = l_strR + 20; }
		
		while( l_strG > 255 ) { l_strG = l_strG - 30; }
		while( l_strG < 120 ) { l_strG = l_strG + 20; }
		
		while( l_strB > 255 ) { l_strB = l_strB - 30; }
		while( l_strB < 120 ) { l_strB = l_strB + 20; }
		
		String hexa_strR = Integer.toHexString(l_strR);
		String hexa_strG = Integer.toHexString(l_strG);
		String hexa_strB = Integer.toHexString(l_strB);
		
		StringBuffer sb = new StringBuffer();
		sb.append(hexa_strR);
		sb.append(hexa_strG);
		sb.append(hexa_strB);
		
		String RGB = sb.toString();
		
		return RGB;
	}
}
