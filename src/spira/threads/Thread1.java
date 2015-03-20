package spira.threads;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.ImageIcon;

public class Thread1 extends Thread {

	private URL url;
	private String file;

	public Thread1(String url, String file) throws MalformedURLException {
		super();
		this.url = new URL(url);
		this.file = file;
	}

	public void run() {
		try {
			URLConnection connection = url.openConnection();
			InputStream in = connection.getInputStream();

			FileOutputStream os = new FileOutputStream(file);
			byte[] b = new byte[2048];
			int length;

			while ((length = in.read(b)) != -1) {
				os.write(b, 0, length);
			}

			in.close();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
