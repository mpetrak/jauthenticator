package com.jauthenticator;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author mpetrak
 */
public class JAuthenticator {
	
	public static String computePin(String secret) {
		if (secret == null || secret.length() == 0) {
			return "Null or empty secret!";
		}
		try {
			final byte[] keyBytes = Base32String.decode(secret);
			Mac mac = Mac.getInstance("HMACSHA1");
			mac.init(new SecretKeySpec(keyBytes, ""));
			PasscodeGenerator pcg = new PasscodeGenerator(mac);
			return pcg.generateTimeoutCode();
		} catch (GeneralSecurityException e) {
			return "General security exception";
		} catch (Base32String.DecodingException e) {
			return "Decoding exception";
		}
	}
}
