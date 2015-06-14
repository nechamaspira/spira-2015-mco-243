package spira.os.security;

import org.apache.commons.codec.digest.DigestUtils;

public class GenerateMD5 {

	public static void main(String [] args){
		String sentence = "I will graduate soon";
		System.out.println(DigestUtils.md5Hex(sentence));
	}
}
