import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

public class NFeParser {
    public Invoice parse(String path) {
        Invoice invoice = new Invoice();
        try {
            Document doc = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder().parse(path);

            invoice.senderCNPJ = doc.getElementsByTagName("CNPJ").item(0).getTextContent();
            invoice.receiverCNPJ = doc.getElementsByTagName("CNPJ").item(1).getTextContent();
            invoice.product = doc.getElementsByTagName("xProd").item(0).getTextContent();
            invoice.quantity = Integer.parseInt(doc.getElementsByTagName("qCom").item(0).getTextContent());
            invoice.unitPrice = Double.parseDouble(doc.getElementsByTagName("vUnCom").item(0).getTextContent());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return invoice;
    }
}
