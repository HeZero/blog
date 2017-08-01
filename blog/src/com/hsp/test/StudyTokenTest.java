package com.hsp.test;

import java.util.StringTokenizer;

public class StudyTokenTest {
	
	public static void main(String[] args) {
		String url="http://localhost:8080/admin/asserts/sdf/a.js";
		StringTokenizer token=new StringTokenizer(url,"");
		//System.out.println(token.nextToken());
		System.out.println(url.split("/asserts/")[1]);
	}

}
