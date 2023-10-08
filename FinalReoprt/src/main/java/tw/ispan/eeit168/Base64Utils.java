package tw.ispan.eeit168;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;

public class Base64Utils {
	
	//單張照片轉成Base64
	public static final String convertToBase64(MultipartFile file) {
		try {
			String base64Encoder = null;
			if(file != null) {
				byte[] buffer = file.getBytes();
				base64Encoder = Base64.encodeBase64String(buffer);
				base64Encoder.replaceAll("[\\s*\t\n\r]","");
				base64Encoder = "data:image/jpeg;base64,"+ base64Encoder;
			}
			return base64Encoder;
		}catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//多張照片轉成Base64
	public static final Map<Integer, String> convertToBase64(MultipartFile[] files) {
		try {
			Map<Integer, String> result = new HashMap<Integer, String>();
			String base64Encoder = null;
			byte[] buffer = null;
			if(files != null) {
				Integer i = 1;
				for(MultipartFile file : files) {
					buffer = file.getBytes();
					base64Encoder = Base64.encodeBase64String(buffer);
					if(base64Encoder != null && base64Encoder.length() != 0) {
						base64Encoder.replaceAll("[\\s*\t\n\r]","");
						base64Encoder = "data:image/jpeg;base64,"+ base64Encoder;
//						base64Encoder = "data:image/jpeg;base64,"+ i;
						result.put(i, base64Encoder);
						i++;
					}
				}
			}
			return result;
		}catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
