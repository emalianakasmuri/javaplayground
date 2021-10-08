package javapdf.sample;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

public class DocumentCreator {

	public static void main(String[] args) {
		
		

		try {
			
			Rectangle layout = new Rectangle(PageSize.A4);
		    layout.setBorderWidth(6);      //Border width  
		    layout.setBorder(Rectangle.BOX); 
			
			// Create a document object
			Document coverPage = new Document(layout);
		
			// Create a writer object
			PdfWriter writer = PdfWriter.getInstance(coverPage, 
					new FileOutputStream("Cover.pdf"));
			
			// Open the document
			coverPage.open();
			
			// Add logo
			String imageFile = "LogoJawi.png"; 
			Image image = Image.getInstance(imageFile);
			Chunk imageChunk = new Chunk(image, 0, 0, true);
			Paragraph logo = new Paragraph("\n\n\n");
			logo.add(imageChunk);
			logo.setAlignment(Element.ALIGN_CENTER);
			coverPage.add(logo);
			
						
			// Add title
			
			// Add faculty name
			Font bold18 = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
			Paragraph faculty = new Paragraph("Fakulti Teknologi Maklumat dan Komunikasi", bold18);
			faculty.setAlignment(Element.ALIGN_CENTER);
			coverPage.add(faculty);
			
			// Add subject code
			Font normal14 = new Font(Font.FontFamily.HELVETICA, 14);
			Paragraph subjectCode = new Paragraph("\n\nBITP3123", normal14);
			subjectCode.setAlignment(Element.ALIGN_CENTER);
			coverPage.add(subjectCode);
			
			// Subject Name
			Paragraph subjectNameEn = new Paragraph("Distributed Application Development", normal14);
			subjectNameEn.setAlignment(Element.ALIGN_CENTER);
			coverPage.add(subjectNameEn);
			
			// Subject Name
			Font italic14 = new Font(Font.FontFamily.HELVETICA, 14, Font.ITALIC);
			Paragraph subjectNameMy = new Paragraph("(Pembangunan Aplikasi Teragih)", italic14);
			subjectNameMy.setAlignment(Element.ALIGN_CENTER);
			coverPage.add(subjectNameMy);
			
			// Subject Name
			Paragraph semester = new Paragraph("\n\nSem 2 2020/2021", normal14);
			semester.setAlignment(Element.ALIGN_CENTER);
			coverPage.add(semester);

			
			
			System.out.println("Open Cover.pdf");
			
			
			// Close
			coverPage.close();
			writer.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
