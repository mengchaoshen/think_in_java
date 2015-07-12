package com.smc;



public class Test {
	
	public static String unescapeXml(String sText) {
		if(null != sText && !"".equals(sText)){
			return sText.replace("&amp;", "&").replace("&lt;", "<").
					replace("&gt;", ">").replace("&quot;", "\"").replaceAll("&apos;", "'");
		}
		return "";
	}
	
	public static String escapeXml(String sText) {
		if(null != sText && !"".equals(sText)){
			return sText.replace("&", "&amp;").replace("<", "&lt;").
					replace(">", "&gt;").replace("\"", "&quot;").replaceAll("'", "&apos;");
		}
		return "";
	}

	public static void main(String[] args) {

		String t1 = "1'1''&'\"''<<'";
		
		System.out.println(escapeXml(t1));
	}

}
