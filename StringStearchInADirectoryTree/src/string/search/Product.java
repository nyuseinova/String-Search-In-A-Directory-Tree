package string.search;

public class Product {
    private String fileName;
    private int lineNumber;
    private String line;


    public Product(String fileName, int lineNumber, String line) {
        this.fileName = fileName;
        this.lineNumber = lineNumber;
        this.line = line;
    }

    public Product() {
        this.fileName = "";
        this.lineNumber = 0;
        this.line = "";
    }

    public String getFileName() {
        return fileName;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public String getLine() {
        return line;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public void printProduct() throws InterruptedException {
        System.out.println("File name: " + fileName + ", line: " + lineNumber + ", content: " + line);
    }
}
