package imageProcessor;
import java.io.PrintWriter;
	public class my_main {
		public static void main(String[] args) {
			String input_file="C:\\test\\22.png";
			String output_file="C:\\test\\11_Text";	
			String tesseract_install_path="D:\\Tesseract-OCR\\tesseract";
			String[] command =
		    {
		        "cmd",
		    };
		    Process p;
			try {
				p = Runtime.getRuntime().exec(command);
			        new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
		                new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
		                PrintWriter stdin = new PrintWriter(p.getOutputStream());
		                //stdn.println() is a main method wich retypes the 19 line into the CMD which in its turn do the whole work
		                stdin.println("\""+tesseract_install_path+"\" \""+input_file+"\" \""+output_file+"\" -l eng");
		        	    stdin.close();
		                p.waitFor();
		                System.out.println();
		                System.out.println();
		                System.out.println();
		                System.out.println();
		                System.out.println(Read_File.read_a_file(output_file+".txt"));
		    	} catch (Exception e) {
		 		e.printStackTrace();
			}
		}	
	}	