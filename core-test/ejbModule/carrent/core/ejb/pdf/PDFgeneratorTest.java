package carrent.core.ejb.pdf;

import javax.annotation.Generated;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;

import carrent.core.model.order.Rent;
import carrent.core.model.person.customer.ConfirmedCustomer;
import mockit.Deencapsulation;

@Generated(value = "org.junit-tools-1.0.6")
public class PDFgeneratorTest {

	private PDFgenerator createTestSubject() {
		return new PDFgenerator();
	}

	@MethodRef(name = "createPdf", signature = "(QConfirmedCustomer;QRent;)V")
	@Test
	public void testCreatePdf() throws Exception {
		PDFgenerator testSubject;
		ConfirmedCustomer confirmedCustomer = null;
		Rent rent = null;

		// default test
		testSubject = createTestSubject();
		testSubject.createPdf(confirmedCustomer, rent);
	}

	@MethodRef(name = "addMetaData", signature = "(QDocument;)V")
	@Test
	public void testAddMetaData() throws Exception {
		PDFgenerator testSubject;
		Document document = null;

		// default test
		testSubject = createTestSubject();
		Deencapsulation.invoke(testSubject, "addMetaData", new Object[] { Document.class });
	}

	@MethodRef(name = "addTitlePage", signature = "(QDocument;)V")
	@Test
	public void testAddTitlePage() throws Exception {
		PDFgenerator testSubject;
		Document document = null;

		// default test
		testSubject = createTestSubject();
		Deencapsulation.invoke(testSubject, "addTitlePage", new Object[] { Document.class });
	}

	@MethodRef(name = "addEmptyLine", signature = "(QParagraph;I)V")
	@Test
	public void testAddEmptyLine() throws Exception {
		PDFgenerator testSubject;
		Paragraph paragraph = null;
		int number = 0;

		// default test
		testSubject = createTestSubject();
		Deencapsulation.invoke(testSubject, "addEmptyLine", new Object[] { Paragraph.class, number });
	}
}