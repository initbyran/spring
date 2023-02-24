package springIoc.sample06;

import java.io.FileWriter;

public class FileOutput implements Output {

	private String filePath;

	public void setFilePath(String filePath) {
		this.filePath = filePath;
		System.out.println("setFilePath() setter 호출");
	}

	public FileOutput() {
		System.out.println("FileOuput 기본 생성자 호출");
	}

	public FileOutput(String filePath) {
		super();
		this.filePath = filePath;
		System.out.println("FileOuput 생성자 호출 - "+filePath);
	}
	
	@Override
	public void print(String message) throws Exception {
		
		FileWriter out = new FileWriter(filePath);
		out.write(message);
		out.close();
		System.out.println("fileOuput override 호출 : "+message);
	}
	
}
