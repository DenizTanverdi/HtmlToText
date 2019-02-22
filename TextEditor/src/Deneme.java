import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.swing.text.html.HTMLEditorKit.Parser;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.Node;

public class Deneme {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		 try {
			 String url="http://kodefterde.blogspot.com/2016/04/jsoup-ile-websiteden-veri-cekme.html";
				Response response = Jsoup.connect(url).timeout(30000).execute();
				Document doc=response.parse();
				  /* String question = doc.select("#question .post-text").text();
			        System.out.println("Question: " + question);
			        Elements answerers = doc.select("#answers .user-details a");
			        for (Element answerer : answerers) {
			            System.out.println("Answerer: " + answerer.text());*/
			          
				
String deneme=doc.toString();

String text=Jsoup.parse(deneme).text();
//String strippedText = deneme.replaceAll("(?s)<[^>]*>(\\s*<[^>]*>)*", " ");
System.out.println(text);
convertDocumentToString(text);
		} catch (Exception e) {
			// TODO: handle exceptio
			System.out.println("Error:"+e.getMessage());
		}
		
	
	}
	private static void convertDocumentToString(String deneme) throws IOException {
		File file = new File("F:\\SABAH\\web\\text.docs");
		if(file.exists()) {
			System.out.println("Dosya var!");
		} else {
			System.out.println("Dosya yok!");
		}
        FileWriter fileWriter = new FileWriter(file, false);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        bWriter.write(deneme);
        bWriter.close();
    }
}
