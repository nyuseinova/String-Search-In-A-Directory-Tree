package string.search.tests;

import static org.junit.Assert.*;
import string.search.Product;
import org.junit.Test;

public class ProductTest {
    @Test
    public void testIfProductIsInCorrectFormatPrinted() {
        Product testProduct = new Product();
        testProduct.setFileName("test_file.txt");
        testProduct.setLineNumber(11);
        testProduct.setLine("This is a test.");


        String expectedOutput = "File name: test_file.txt, line: 11, content: This is a test.";
        String actualOutput = "File name: " + testProduct.getFileName()
                              + ", line: " + testProduct.getLineNumber()
                              + ", content: " + testProduct.getLine();

        assertEquals(expectedOutput, actualOutput);

    }
}
