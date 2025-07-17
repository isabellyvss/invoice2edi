public class Main {
    public static void main(String[] args) {
        NFeParser parser = new NFeParser();
        EDIConverter converter = new EDIConverter();

        Invoice invoice = parser.parse("sample-nfe.xml");
        converter.generateEDI(invoice, "saida-edi.txt");

        System.out.println("Arquivo EDI gerado com sucesso!");
    }
}
