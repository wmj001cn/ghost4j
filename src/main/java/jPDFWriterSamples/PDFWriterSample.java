package jPDFWriterSamples;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;

import com.qoppa.pdfWriter.PDFDocument;
import com.qoppa.pdfWriter.PDFPage;
import com.qoppa.pdfWriter.PDFPrinterJob;
/**
 * Insert the type's description here.
 * Creation date: (7/6/2002 4:47:00 PM)
 * @author: Administrator
 */
public class PDFWriterSample extends javax.swing.JPanel implements Printable 
{
	private javax.swing.JPanel mainPane = null;
	private javax.swing.JLabel ivjJLabel1 = null;
	private javax.swing.JLabel ivjJLabel2 = null;
	private javax.swing.JRadioButton ivjJRadioButton1 = null;
	private javax.swing.JTextField ivjJTextField1 = null;
	IvjEventHandler ivjEventHandler = new IvjEventHandler();
	private javax.swing.JTable ivjScrollPaneTable = null;
	private javax.swing.JScrollPane ivjprintTable = null;
	private javax.swing.JButton ivjjbPrintDocument = null;
	private javax.swing.JButton ivjjbPrintPanel = null;
	private javax.swing.JButton ivjjbPrintTable = null;
	private javax.swing.JCheckBox ivjJCheckBox1 = null;
	private javax.swing.JCheckBox ivjJCheckBox11 = null;
	private javax.swing.JEditorPane ivjjepRTFDocument = null;
	private javax.swing.JRadioButton ivjJRadioButton11 = null;
	private javax.swing.JScrollPane ivjJScrollPane1 = null;
	private javax.swing.JScrollPane ivjJScrollPane2 = null;
	private javax.swing.JTextField ivjJTextField11 = null;
	private javax.swing.JTree ivjJTree1 = null;
	private javax.swing.JPanel ivjjpPrintPanel = null;
	private javax.swing.JLabel ivjjlJARLocation = null;
	private javax.swing.JLabel ivjjlViewManual = null;
	private javax.swing.JPanel jpAPI = null;
	private javax.swing.JButton ivjjbViewManual = null;

	private final static String OS_WINDOWS_START = "windows";
	private final static String OS_MAC = "mac";
	private final static String JAR_FILE_NAME = "jPDFWriter.jar";
	private final static String SAMPLE_DIR_NAME = "jPDFWriterSamples";
	private final static String API_INDEX_FILENAME = "javadoc/index.html";
	
	private JLabel jlSampleLocation = null;
    private JButton jbCreateNewDocument = null;
    private JScrollPane jScrollPane = null;
    private JTextPane jtpRTFGraphics = null;
    private JPanel jpDocument = null;
    private JPanel jpSamples = null;
    private class PDFFileFilter extends FileFilter
	{
		public boolean accept (java.io.File f)
		{
			if (f.getName ().length() > 4)
			{
				String ext = f.getName ().substring (f.getName ().length() - 4, f.getName ().length ());
				if (".pdf".equalsIgnoreCase (ext))
				{
					return true;
				}
			}
		
			return false;
		}
		public String getDescription() 
		{
			return "PDF Files (*.pdf)";
		}
	}

class IvjEventHandler implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent e) {
			if (e.getSource() == PDFWriterSample.this.getjbPrintPanel()) 
				connEtoC1();
			if (e.getSource() == PDFWriterSample.this.getjbPrintTable()) 
				connEtoC2();
			if (e.getSource() == PDFWriterSample.this.getjbPrintDocument()) 
				connEtoC4();
			if (e.getSource() == PDFWriterSample.this.getjbViewManual()) 
				connEtoC5();
            if (e.getSource() == PDFWriterSample.this.getjbCreateNewDocument()) 
                connEtoC6();
		};
	};
/**
 * TestFrame2 constructor comment.
 */
public PDFWriterSample() {
	super();
		initialize();
	sample_Initialize();
}
/**
 * This method initializes this
 * 
 */
private void initialize() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setSize(new java.awt.Dimension(677,727));
        this.add(getMainPane(), null);
		
}
/**
 * connEtoC1:  (jbPrintPanel.action. --> TestFrame2.jbPrintPanel_ActionEvents()V)
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC1() {
	try {
		// user code begin {1}
		// user code end
		this.jbPrintPanel_ActionEvents();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC2:  (jbPrintTable.action. --> TestFrame2.jbPrintTable_ActionEvents()V)
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC2() {
	try {
		// user code begin {1}
		// user code end
		this.jbPrintTable_ActionEvents();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC4:  (jbPrintDocument.action. --> TestFrame2.jbPrintDocument_ActionEvents()V)
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC4() {
	try {
		// user code begin {1}
		// user code end
		this.jbPrintDocument_ActionEvents();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC5:  (jbViewManual.action. --> Sample.jbViewManual_ActionEvents()V)
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC5() {
	try {
		// user code begin {1}
		// user code end
		this.jbViewManual_ActionEvents();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC5:  (jbPrintGraphics.action. --> Sample.jbPrintGraphics_ActionEvents()V)
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC6() {
    try {
        // user code begin {1}
        // user code end
        this.jbCreateNewDocument_ActionEvents();
        // user code begin {2}
        // user code end
    } catch (java.lang.Throwable ivjExc) {
        // user code begin {3}
        // user code end
        handleException(ivjExc);
    }
}
/**
 * Return the jbPrintDocument property value.
 * @return javax.swing.JButton
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JButton getjbPrintDocument() {
	if (ivjjbPrintDocument == null) {
		try {
			ivjjbPrintDocument = new javax.swing.JButton();
			ivjjbPrintDocument.setName("jbPrintDocument");
			ivjjbPrintDocument.setText("Print Document To PDF");
			ivjjbPrintDocument.setBounds(new java.awt.Rectangle(242,228,140,26));
			ivjjbPrintDocument.setMargin(new java.awt.Insets(2, 2, 2, 2));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjjbPrintDocument;
}
/**
 * Return the JButton11 property value.
 * @return javax.swing.JButton
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JButton getjbPrintPanel() {
	if (ivjjbPrintPanel == null) {
		try {
			ivjjbPrintPanel = new javax.swing.JButton();
			ivjjbPrintPanel.setName("jbPrintPanel");
			ivjjbPrintPanel.setBounds(new java.awt.Rectangle(100,176,150,27));
			ivjjbPrintPanel.setText("Print Panel To PDF");
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjjbPrintPanel;
}
/**
 * Return the JButton111 property value.
 * @return javax.swing.JButton
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JButton getjbPrintTable() {
	if (ivjjbPrintTable == null) {
		try {
			ivjjbPrintTable = new javax.swing.JButton();
			ivjjbPrintTable.setName("jbPrintTable");
			ivjjbPrintTable.setText("Print Table To PDF");
			ivjjbPrintTable.setBounds(new java.awt.Rectangle(100,350,150,27));
			ivjjbPrintTable.setMargin(new java.awt.Insets(2, 2, 2, 2));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjjbPrintTable;
}
/**
 * Return the JButton1 property value.
 * @return javax.swing.JButton
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JButton getjbViewManual() {
	if (ivjjbViewManual == null) {
		try {
			ivjjbViewManual = new javax.swing.JButton();
			ivjjbViewManual.setName("jbViewManual");
			ivjjbViewManual.setText("Click Here");
			ivjjbViewManual.setBounds(10, 48, 85, 20);
			ivjjbViewManual.setMargin(new java.awt.Insets(2, 2, 2, 2));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjjbViewManual;
}
/**
 * Return the JCheckBox1 property value.
 * @return javax.swing.JCheckBox
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JCheckBox getJCheckBox1() {
	if (ivjJCheckBox1 == null) {
		try {
			ivjJCheckBox1 = new javax.swing.JCheckBox();
			ivjJCheckBox1.setName("JCheckBox1");
			ivjJCheckBox1.setText("Check Box 1");
			ivjJCheckBox1.setBounds(10, 107, 110, 22);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJCheckBox1;
}
/**
 * Return the JCheckBox11 property value.
 * @return javax.swing.JCheckBox
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JCheckBox getJCheckBox11() {
	if (ivjJCheckBox11 == null) {
		try {
			ivjJCheckBox11 = new javax.swing.JCheckBox();
			ivjJCheckBox11.setName("JCheckBox11");
			ivjJCheckBox11.setText("Check Box 2");
			ivjJCheckBox11.setBounds(10, 131, 110, 22);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJCheckBox11;
}
/**
 * Return the jepRTFDocument property value.
 * @return javax.swing.JEditorPane
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JEditorPane getjepRTFDocument() {
	if (ivjjepRTFDocument == null) {
		try {
			ivjjepRTFDocument = new javax.swing.JEditorPane();
			ivjjepRTFDocument.setName("jepRTFDocument");
			ivjjepRTFDocument.setBounds(0, 0, 125, 124);
			ivjjepRTFDocument.setEditable(false);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjjepRTFDocument;
}
/**
 * Return the JFrameContentPane property value.
 * @return javax.swing.JPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPanel getMainPane() {
	if (mainPane == null) {
		try {
			mainPane = new javax.swing.JPanel();
            mainPane.setName("JFrameContentPane");
            mainPane.setLayout(new BoxLayout(getMainPane(), BoxLayout.Y_AXIS));
            mainPane.add(getJpDocument(), null);
            mainPane.add(getJpSamples(), null);
            mainPane.add(getjpAPI(), null);
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return mainPane;
}
/**
 * Return the JLabel1 property value.
 * @return javax.swing.JLabel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JLabel getJLabel1() {
	if (ivjJLabel1 == null) {
		try {
			ivjJLabel1 = new javax.swing.JLabel();
			ivjJLabel1.setName("JLabel1");
			ivjJLabel1.setText("Label 1:");
			ivjJLabel1.setBounds(10, 10, 77, 14);
			// user code begin {1}
			ivjJLabel1.setForeground(java.awt.Color.black);
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJLabel1;
}
/**
 * Return the JLabel2 property value.
 * @return javax.swing.JLabel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JLabel getJLabel2() {
	if (ivjJLabel2 == null) {
		try {
			ivjJLabel2 = new javax.swing.JLabel();
			ivjJLabel2.setName("JLabel2");
			ivjJLabel2.setText("Label 2:");
			ivjJLabel2.setBounds(10, 32, 77, 14);
			// user code begin {1}
			ivjJLabel2.setForeground(java.awt.Color.black);
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJLabel2;
}
/**
 * Return the jlJARLocation property value.
 * @return javax.swing.JLabel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JLabel getjlJARLocation() {
	if (ivjjlJARLocation == null) {
		try {
			ivjjlJARLocation = new javax.swing.JLabel();
			ivjjlJARLocation.setName("jlJARLocation");
			ivjjlJARLocation.setFont(new java.awt.Font("dialog", 0, 12));
			ivjjlJARLocation.setText("jlJARLocation");
			ivjjlJARLocation.setBounds(new java.awt.Rectangle(14,11,650,14));
			ivjjlJARLocation.setForeground(java.awt.Color.black);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjjlJARLocation;
}
/**
 * Return the jlViewManual property value.
 * @return javax.swing.JLabel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JLabel getjlViewManual() {
	if (ivjjlViewManual == null) {
		try {
			ivjjlViewManual = new javax.swing.JLabel();
			ivjjlViewManual.setName("jlViewManual");
			ivjjlViewManual.setFont(new java.awt.Font("dialog", 0, 12));
			ivjjlViewManual.setText("to view the API.");
			ivjjlViewManual.setBounds(100, 51, 570, 14);
			ivjjlViewManual.setForeground(java.awt.Color.black);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjjlViewManual;
}

private JLabel getjlSampleLocation()
{
    if (jlSampleLocation == null)
    {
		jlSampleLocation = new JLabel();
		jlSampleLocation.setBounds(15, 27, 650, 14);
		jlSampleLocation.setText("jlSampleLocation");
		jlSampleLocation.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
		jlSampleLocation.setName("jlSampleLocation");
		jlSampleLocation.setForeground(java.awt.Color.black);
    }
    return jlSampleLocation;
}
/**
 * Return the JPanel1 property value.
 * @return javax.swing.JPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public javax.swing.JPanel getjpAPI() {
	if (jpAPI == null) {
		try {
			jpAPI = new javax.swing.JPanel();
			jpAPI.setName("JPanel1");
			jpAPI.setBorder(new javax.swing.border.EtchedBorder());
			jpAPI.setLayout(null);
			jpAPI.setPreferredSize(new java.awt.Dimension(380,30));
            jpAPI.add(getjbViewManual(), getjbViewManual().getName());
            jpAPI.add(getjlViewManual(), getjlViewManual().getName());
			jpAPI.add(getjlSampleLocation(), null);
			jpAPI.add(getjlJARLocation(), null);
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return jpAPI;
}
/**
 * Return the JPanel1 property value.
 * @return javax.swing.JPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPanel getjpPrintPanel() {
	if (ivjjpPrintPanel == null) {
		try {
			ivjjpPrintPanel = new javax.swing.JPanel();
			ivjjpPrintPanel.setName("jpPrintPanel");
			ivjjpPrintPanel.setBorder(new javax.swing.border.EtchedBorder());
			ivjjpPrintPanel.setLayout(null);
			ivjjpPrintPanel.setBounds(new java.awt.Rectangle(14,11,322,162));
			getjpPrintPanel().add(getJLabel1(), getJLabel1().getName());
			getjpPrintPanel().add(getJLabel2(), getJLabel2().getName());
			getjpPrintPanel().add(getJTextField1(), getJTextField1().getName());
			getjpPrintPanel().add(getJRadioButton1(), getJRadioButton1().getName());
			getjpPrintPanel().add(getJTextField11(), getJTextField11().getName());
			getjpPrintPanel().add(getJRadioButton11(), getJRadioButton11().getName());
			getjpPrintPanel().add(getJCheckBox1(), getJCheckBox1().getName());
			getjpPrintPanel().add(getJCheckBox11(), getJCheckBox11().getName());
			getjpPrintPanel().add(getJScrollPane1(), getJScrollPane1().getName());
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjjpPrintPanel;
}
/**
 * Return the JRadioButton1 property value.
 * @return javax.swing.JRadioButton
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JRadioButton getJRadioButton1() {
	if (ivjJRadioButton1 == null) {
		try {
			ivjJRadioButton1 = new javax.swing.JRadioButton();
			ivjJRadioButton1.setName("JRadioButton1");
			ivjJRadioButton1.setText("Radio Button 1");
			ivjJRadioButton1.setBounds(10, 60, 115, 22);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJRadioButton1;
}
/**
 * Return the JRadioButton11 property value.
 * @return javax.swing.JRadioButton
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JRadioButton getJRadioButton11() {
	if (ivjJRadioButton11 == null) {
		try {
			ivjJRadioButton11 = new javax.swing.JRadioButton();
			ivjJRadioButton11.setName("JRadioButton11");
			ivjJRadioButton11.setText("Radio Button 2");
			ivjJRadioButton11.setBounds(10, 85, 115, 22);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJRadioButton11;
}
/**
 * Return the JScrollPane1 property value.
 * @return javax.swing.JScrollPane
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JScrollPane getJScrollPane1() {
	if (ivjJScrollPane1 == null) {
		try {
			ivjJScrollPane1 = new javax.swing.JScrollPane();
			ivjJScrollPane1.setName("JScrollPane1");
			ivjJScrollPane1.setViewportView(getJTree1());
			ivjJScrollPane1.setBounds(147, 57, 165, 97);
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJScrollPane1;
}
/**
 * Return the JScrollPane2 property value.
 * @return javax.swing.JScrollPane
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JScrollPane getJScrollPane2() {
	if (ivjJScrollPane2 == null) {
		try {
			ivjJScrollPane2 = new javax.swing.JScrollPane();
			ivjJScrollPane2.setName("JScrollPane2");
			ivjJScrollPane2.setBounds(new Rectangle(8, 9, 655, 212));
			getJScrollPane2().setViewportView(getjepRTFDocument());
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJScrollPane2;
}
/**
 * Return the JTextField1 property value.
 * @return javax.swing.JTextField
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JTextField getJTextField1() {
	if (ivjJTextField1 == null) {
		try {
			ivjJTextField1 = new javax.swing.JTextField();
			ivjJTextField1.setName("JTextField1");
			ivjJTextField1.setText("Text Field 1");
			ivjJTextField1.setBounds(80, 7, 150, 20);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJTextField1;
}
/**
 * Return the JTextField11 property value.
 * @return javax.swing.JTextField
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JTextField getJTextField11() {
	if (ivjJTextField11 == null) {
		try {
			ivjJTextField11 = new javax.swing.JTextField();
			ivjJTextField11.setName("JTextField11");
			ivjJTextField11.setText("Text Field 2");
			ivjJTextField11.setBounds(80, 30, 150, 20);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJTextField11;
}
/**
 * Return the JTree1 property value.
 * @return javax.swing.JTree
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JTree getJTree1() {
	if (ivjJTree1 == null) {
		try {
			ivjJTree1 = new javax.swing.JTree();
			ivjJTree1.setName("JTree1");
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJTree1;
}
/**
 * Return the printTable property value.
 * @return javax.swing.JScrollPane
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JScrollPane getprintTable() {
	if (ivjprintTable == null) {
		try {
			ivjprintTable = new javax.swing.JScrollPane();
			ivjprintTable.setName("printTable");
			ivjprintTable.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			ivjprintTable.setBounds(new java.awt.Rectangle(14,213,322,132));
			ivjprintTable.setViewportView(getScrollPaneTable());
			ivjprintTable.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjprintTable;
}
/**
 * Return the ScrollPaneTable property value.
 * @return javax.swing.JTable
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JTable getScrollPaneTable() {
	if (ivjScrollPaneTable == null) {
		try {
			ivjScrollPaneTable = new javax.swing.JTable();
			ivjScrollPaneTable.setName("ScrollPaneTable");
            getprintTable().setColumnHeaderView(ivjScrollPaneTable.getTableHeader());
			ivjScrollPaneTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
            ivjScrollPaneTable.setFont(new Font("dialog", Font.PLAIN, 12));
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjScrollPaneTable;
}
/**
 * Called whenever the part throws an exception.
 * @param exception java.lang.Throwable
 */
private void handleException(java.lang.Throwable exception) {

	/* Uncomment the following lines to print uncaught exceptions to stdout */
	// System.out.println("--------- UNCAUGHT EXCEPTION ---------");
	// exception.printStackTrace(System.out);
}
/**
 * Initializes connections
 * @exception java.lang.Exception The exception description.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initConnections() throws java.lang.Exception {
	// user code begin {1}
	// user code end
	getjbPrintPanel().addActionListener(ivjEventHandler);
	getjbPrintTable().addActionListener(ivjEventHandler);
	getjbPrintDocument().addActionListener(ivjEventHandler);
    getjbCreateNewDocument().addActionListener(ivjEventHandler);
	getjbViewManual().addActionListener(ivjEventHandler);
}
/**
 * Insert the method's description here.
 * Creation date: (11/10/2003 9:18:05 PM)
 * @return boolean
 */
private boolean isSystemMac() 
{
	// Check the OS
	String osName = System.getProperty ("os.name");
	osName = osName.toLowerCase();
	int firstIndexOfMac = osName.indexOf (OS_MAC);
	if (firstIndexOfMac == -1)
	{
		return false;
	}
	else
	{
		return true;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (11/10/2003 9:16:17 PM)
 * @return boolean
 */
private boolean isSystemWindows()
{
	// Check the OS
	String osName = System.getProperty ("os.name");
	osName = osName.toLowerCase();
	return osName.startsWith(OS_WINDOWS_START);
}
/**
 * Comment
 */
public void jbPrintDocument_ActionEvents() 
{
    PDFDocument pdfDoc = new PDFDocument ();
    
    // Create page
    PDFPage page = pdfDoc.createPage(null);
    Graphics2D g2d = page.createGraphics();
    
	g2d.scale(.9, .9);
	g2d.translate (10, 10);
	getjepRTFDocument().print(g2d);
	pdfDoc.addPage (page);
	
	// Save the document
	try
	{
	    File outFile = getOutputFile ();
	    if (outFile != null)
	    {
	        pdfDoc.saveDocument (outFile.getAbsolutePath());
	    }
	}
	catch (IOException ioe)
	{
	    JOptionPane.showMessageDialog(this, ioe.getMessage());
	}
}

private File getOutputFile()
{
	JFileChooser fileChooser = new JFileChooser ();
	fileChooser.setFileFilter(new PDFFileFilter ());
	int rc = fileChooser.showSaveDialog (this);
	if (rc == JFileChooser.APPROVE_OPTION)
	{
	    return fileChooser.getSelectedFile();
	}
	else
	{
		return null;
	}
}
/**
 * Comment
 */
public void jbPrintPanel_ActionEvents()
{
	try
	{
		PDFPrinterJob printer = (PDFPrinterJob)PDFPrinterJob.getPrinterJob ();
		printer.setPrintable (this);
		printer.setCopies (1);
		printer.print();
	}
	catch (Throwable t)
	{
		t.printStackTrace();
	}
}
/**
 * Comment
 */
public void jbCreateNewDocument_ActionEvents()
{
    try
    {
        // create a new document 
        PDFDocument pdfDoc = new PDFDocument ();

        // create page 
        PDFPage page = pdfDoc.createPage(null);

        // add page to document 
        pdfDoc.addPage (page);

        // get graphics object from the page 
        Graphics2D g2d = page.createGraphics();
       
        // draw a red rectangle
        g2d.setColor(Color.red);
        g2d.fillRect(100, 100, 400, 200);
        
        // draw a round border to the rectangle
        g2d.setStroke(new BasicStroke(6));
        g2d.setColor(Color.black);
        g2d.drawRoundRect(100, 100, 400, 200, 10, 10);
        
        // draw a string 
        g2d.setFont(new Font ("Helvetica", Font.BOLD, 36));
        g2d.setColor(Color.white);
        g2d.drawString("Qoppa Software", 150, 200);
        
        // draw a yellow rectangle
        g2d.setColor(Color.yellow);
        g2d.fillOval(200, 400, 400, 400);
        
        // create a subgraphics
        Graphics2D subgraphics = (Graphics2D)g2d.create(300, 500, 300, 300);
        
        // draw string at different orientations in blue in size 34 and bold
        subgraphics.setFont(new Font ("Arial", Font.BOLD, 48));
        subgraphics.setColor(Color.blue);
        subgraphics.rotate (Math.PI / 4);
        subgraphics.drawString ("jPDFWriter", 30,30);
        
        // get a file name
        File outFile = getOutputFile ();
        if (outFile != null)
        {
            // save the document
            pdfDoc.saveDocument (outFile.getAbsolutePath());
        }
    }
    catch (Throwable t)
    {
        JOptionPane.showMessageDialog(this, "Error writing to file " + t.getMessage());
        t.printStackTrace();
    }
}
/**
 * Comment
 */
public void jbPrintTable_ActionEvents() 
{
    GridPrinter gridPrinter = new GridPrinter (getScrollPaneTable(), true);

	try
	{
		gridPrinter.print (gridPrinter.getDefaultPage (PageFormat.PORTRAIT));
	}
	catch (Throwable t)
	{
		t.printStackTrace();
	}
}
/**
 * Comment
 */
public void jbViewManual_ActionEvents() 
{
	try
	{
	    File apiIndex = new File (API_INDEX_FILENAME);
		if (isSystemWindows())
		{
			Runtime.getRuntime().exec ("rundll32 url.dll,FileProtocolHandler " + apiIndex.getAbsolutePath ());
		}
		else if (isSystemMac())
		{
			String [] cmdArray = new String [2];
			cmdArray [0] = "open";
			cmdArray [1] = apiIndex.getAbsolutePath ();
			Runtime.getRuntime ().exec (cmdArray);
		}
        // assume Unix or Linux
        else 
        { 
            String[] browsers = {"firefox", "opera", "konqueror", "epiphany", "mozilla", "netscape" };
            String browser = null;
            for (int count = 0; count < browsers.length && browser == null; count++)
            {
               if (Runtime.getRuntime().exec(new String[] {"which", browsers[count]}).waitFor() == 0)
               {
                  browser = browsers[count];
                  break;
               }
            }
            if (browser == null)
               throw new Exception("Could not find web browser");
            else
               Runtime.getRuntime().exec(new String[] {browser, apiIndex.getAbsolutePath ()});
        }
	}
	catch (Throwable t)
	{
		javax.swing.JOptionPane.showMessageDialog (this, t.getMessage ());
	}
}
/**
 * Insert the method's description here.
 * Creation date: (6/23/2002 9:24:22 PM)
 * @return int
 * @param g java.awt.Graphics
 * @param pf java.awt.print.PageFormat
 * @param pageIndex int
 */
public int print (Graphics g, PageFormat pf, int pageIndex) 
{
	if (pageIndex == 0)
	{
	    getjpPrintPanel().print (g);
		return Printable.PAGE_EXISTS;
	}
	else
	{
		return Printable.NO_SUCH_PAGE;
	}
}
/**
 * Comment
 */
public void sample_Initialize() 
{
    try
    {
        initConnections();
    }
    catch(Exception exc)
    {
        exc.printStackTrace();
    }
    
    // Initialize help messages
    File jarFile = new File (JAR_FILE_NAME);
    getjlJARLocation().setText (JAR_FILE_NAME + " is located at " + jarFile.getAbsolutePath () + ".");
    getjlJARLocation().setToolTipText(jarFile.getAbsolutePath ());
    
    File sampleDir = new File (SAMPLE_DIR_NAME);
    getjlSampleLocation().setText ("Samples are located at " + sampleDir.getAbsolutePath() + ".");
    getjlSampleLocation().setToolTipText(sampleDir.getAbsolutePath());

    
	// Initialize the table
	javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel ();
	tableModel.addColumn ("Column1");
	tableModel.addColumn ("Column2");
	tableModel.addColumn ("Column3");
	tableModel.addColumn ("Column4");
	tableModel.addColumn ("Column5");
	tableModel.addColumn ("Column6");

	Vector newRow;
	for (int count = 0; count < 75; ++count)
	{
		newRow = new Vector ();
		newRow.addElement ("cell 1, " + count);
		newRow.addElement ("cell 2, " + count);
		newRow.addElement ("cell 3, " + count);
		newRow.addElement ("cell 4, " + count);
		newRow.addElement ("cell 5, " + count);
		newRow.addElement ("cell 6, " + count);
		newRow.addElement ("cell 7, " + count);

		tableModel.addRow (newRow);
	}
	getScrollPaneTable().setModel (tableModel);

	// Initialize the RTF documents
	try
	{
		getjepRTFDocument().setContentType ("text/rtf");
		getjepRTFDocument().read (this.getClass().getResourceAsStream ("/jpsample.rtf"), null);
        
        getjtpRTFGraphics().setContentType ("text/rtf");
        getjtpRTFGraphics().read (this.getClass().getResourceAsStream ("/jpsample_graphics.rtf"), null);
	}
	catch (Throwable t)
	{
		t.printStackTrace();
	}
}
/**
 * This method initializes jButton	
 * 	
 * @return javax.swing.JButton	
 */
private JButton getjbCreateNewDocument()
{
    if (jbCreateNewDocument == null)
    {
        jbCreateNewDocument = new JButton();
        jbCreateNewDocument.setText("Execute Code to Create PDF Document");
        jbCreateNewDocument.setBounds(new java.awt.Rectangle(364,350,274,26));
        jbCreateNewDocument.setName("jbCreateNewDocumentPanel");
    }
    return jbCreateNewDocument;
}
/**
 * This method initializes jScrollPane	
 * 	
 * @return javax.swing.JScrollPane	
 */
private JScrollPane getJScrollPane()
{
    if (jScrollPane == null)
    {
        jScrollPane = new JScrollPane();
        jScrollPane.setBounds(new Rectangle(344, 12, 319, 333));
        jScrollPane.setViewportView(getjtpRTFGraphics());
        jScrollPane.setName("JScrollPane2");
    }
    return jScrollPane;
}
/**
 * This method initializes jEditorPane	
 * 	
 * @return javax.swing.JEditorPane	
 */
private JTextPane getjtpRTFGraphics()
{
    if (jtpRTFGraphics == null)
    {
        jtpRTFGraphics = new JTextPane();
        jtpRTFGraphics.setEditable(false);
        jtpRTFGraphics.setName("jtpRTFGraphics");
    }
    return jtpRTFGraphics;
}
/**
 * This method initializes jpDocument	
 * 	
 * @return javax.swing.JPanel	
 */
private JPanel getJpDocument()
{
    if (jpDocument == null)
    {
        jpDocument = new JPanel();
        jpDocument.setLayout(null);
        jpDocument.setPreferredSize(new java.awt.Dimension(380,200));
        jpDocument.add(getjbPrintDocument(), null);
        jpDocument.add(getJScrollPane2(), null);
    }
    return jpDocument;
}
    /**
     * This method initializes jpSamples	
     * 	
     * @return javax.swing.JPanel	
     */
    private JPanel getJpSamples()
    {
        if (jpSamples == null)
        {
            jpSamples = new JPanel();
            jpSamples.setLayout(null);
            jpSamples.setPreferredSize(new java.awt.Dimension(380,320));
            jpSamples.add(getjbCreateNewDocument(), null);
            jpSamples.add(getjpPrintPanel(), null);
            jpSamples.add(getprintTable(), null);
            jpSamples.add(getJScrollPane(), null);
            jpSamples.add(getjbPrintTable(), null);
            jpSamples.add(getjbPrintPanel(), null);
        }
        return jpSamples;
    }
    
    /**
     * Set the look and feel.
     */
    public static void setLookAndFeel ()
    {
        // Set the look and feel
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Throwable t)
        {
            // ignore
        }
    }
}  //  @jve:decl-index=0:visual-constraint="10,15"
