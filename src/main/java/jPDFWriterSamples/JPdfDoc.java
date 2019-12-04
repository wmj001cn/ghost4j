package jPDFWriterSamples;

import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.ghost4j.document.PaperSize;

import com.qoppa.pdfWriter.PDFDocument;
import com.qoppa.pdfWriter.PDFPage;

public class JPdfDoc {
	
    PDFDocument pdfDoc2 = new PDFDocument();
    
	List<JPdfPage> pages = new ArrayList<>();
	Map<String, Collection<Integer>> pageIndexsByTag = new HashMap<>();
	
	private int width;
	private int height;
	public List<JPdfPage> getPages() {
		return pages;
	}
	public void setPages(List<JPdfPage> pages) {
		this.pages = pages;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	public void save() {
		try {
			this.pdfDoc2.saveDocument("output2.pdf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addPage(JPdfPage page) {
		
		PageFormat pageFormat2 = new PageFormat();
        
        Paper paper2 = new Paper();
        PaperSize pz = page.getPaperSize();
        int width = pz.getWidth();
		int height = pz.getHeight();
		paper2.setSize(width, height);
        paper2.setImageableArea(0, 0, width, height);
        pageFormat2.setPaper(paper2);
        
		PDFPage createPage = pdfDoc2.createPage(pageFormat2);
		page.setNewPage(createPage);
		pdfDoc2.addPage(createPage);
		this.pages.add(page);
		
		Collection<Integer> pageIndexs = pageIndexsByTag.get(page.getTag());
		if(pageIndexs == null) {
			ArrayList arrayList = new ArrayList();
			arrayList.add(pages.size()-1);
			pageIndexsByTag.put(page.getTag(), arrayList);
		} else {
			pageIndexs.add(pages.size()-1);
		}
	}
	
	public List<JPdfPage> getPagesByTag(String tag) {
		
		List<JPdfPage> pages = new ArrayList<JPdfPage>(); 
		
		Collection<Integer> indexs = pageIndexsByTag.get(tag);
		if(indexs != null && indexs.size() > 0) {
			for (Integer integer : indexs) {
				pages.add(this.pages.get(integer));
			}
		}
		
		return pages;
	}
	
	public JPdfPage getPage(int index) {
		return this.pages.get(index);
	}
	
	

}
