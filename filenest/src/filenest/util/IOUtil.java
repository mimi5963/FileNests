package filenest.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import filenest.domain.Document;
import filenest.domain.label.DeptCode;

public class IOUtil {
	private static FileOutputStream fos;
	private static FileInputStream fis;
	private static ObjectInputStream ois;
	private static ObjectOutputStream oos;
	private static final String OBJECTPATH = "C:\\Users\\KOSA\\Desktop\\docsIO\\seial"+File.separator+"dos.ser";
	private static final String ROLLBACK_PATH = "C:\\Users\\KOSA\\Desktop\\docsIO\\rollback"+File.separator+"roll.ser";
	public static void writeDocumentPdf(Document document) {
		
		try {
			fos = new FileOutputStream(document.path()+File.separator+document.getDocumentStatus().getversionName()+".txt");
			fos.write("------------------------".getBytes());
			fos.write(document.toString().getBytes());
			fos.write("------------------------".getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

	
	public static void writeDocumentMapToSerial(EnumMap<DeptCode, Map<String,Document>> target) {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(OBJECTPATH));
			oos.writeObject(target);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static EnumMap<DeptCode,Map<String,Document>> readDocumentMap(){
		try {
			ois = new ObjectInputStream(new FileInputStream(OBJECTPATH));
			return (EnumMap<DeptCode,Map<String,Document>>)ois.readObject();
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}finally {
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static void writeRollBackDocument(Map<String, List<Document>> rollbackDocs) {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(ROLLBACK_PATH));
			oos.writeObject(rollbackDocs);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static Map<String, List<Document>> readRollBackDocumentMap(){
		try {
			ois = new ObjectInputStream(new FileInputStream(ROLLBACK_PATH));
			return (Map<String, List<Document>>)ois.readObject();
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}finally {
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
}
