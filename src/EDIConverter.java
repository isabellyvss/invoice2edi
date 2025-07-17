import java.io.FileWriter;
import java.io.IOException;

public class EDIConverter {
    public void generateEDI(Invoice invoice, String outputPath) {
        try (FileWriter writer = new FileWriter(outputPath)) {
            writer.write("ISA*00*          *00*          *ZZ*SENDERCNPJ      *ZZ*RECEIVERCNPJ    *\n");
            writer.write("GS*INVOICE*" + invoice.senderCNPJ + "*" + invoice.receiverCNPJ + "*\n");
            writer.write("ST*850*0001\n");
            writer.write("PO1*1*" + invoice.quantity + "*" + invoice.unitPrice + "*" + invoice.product + "*\n");
            writer.write("SE*4*0001\n");
            writer.write("GE*1*1\n");
            writer.write("IEA*1*000000001\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
