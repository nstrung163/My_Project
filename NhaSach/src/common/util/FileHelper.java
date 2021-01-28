package common.util;

import java.io.File;

public class FileHelper {

	/**
	 * Xóa ảnh của sách
	 * 
	 * @param fileName
	 */
	public static void deleteFile(String fileNameUrl) {
		File deleteFile = new File(fileNameUrl);
		if(deleteFile.exists()) {
			deleteFile.delete();
			System.out.println("Xóa ảnh thành công!");
		}
	}
}
