/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jackpot;

import com.sun.org.apache.xml.internal.serializer.OutputPropertiesFactory;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author usuario
 */
public class parserXML {
    private static Document documento;
    //crear xml
    public static void createXML(ArrayList<Jackpot> jackpotList, String xmlFileName) {
        try {
            DocumentBuilderFactory fábricaCreadorDocumento = DocumentBuilderFactory.newInstance();
            DocumentBuilder creadorDocumento = fábricaCreadorDocumento.newDocumentBuilder();
            documento = creadorDocumento.newDocument();
            
            Element raiz = documento.createElement("historial");
            documento.appendChild(raiz);
                        
            for(Jackpot jackpot: jackpotList) {
                Element elementpartida = documento.createElement("partida");
                raiz.appendChild(elementpartida);
                //Añadir elementos
                //addElementData(elementpartida, "fecha", jackpot.fecha().toString());
                addElementData(elementpartida, "saldo", jackpot.getSaldoSTR());
                addElementData(elementpartida, "deposito", String.valueOf(jackpot.deposito));
                addElementData(elementpartida, "premio", jackpot.getPremioSTR());
            }
            //Mostrar en salida estándar el documento XML generado 
            TransformerFactory fábricaTransformador = TransformerFactory.newInstance();
            Transformer transformador = fábricaTransformador.newTransformer();
            transformador.setOutputProperty(OutputKeys.INDENT, "yes");
            transformador.setOutputProperty(OutputPropertiesFactory.S_KEY_INDENT_AMOUNT, "3");            
            Source origen = new DOMSource(documento);
            Result destino = new StreamResult(xmlFileName);
            transformador.transform(origen, destino);            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(parserXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(parserXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(parserXML.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private static void addElementData(Element parent, String tag, String value) {
        Element element = documento.createElement(tag);
        parent.appendChild(element);
        Text text = documento.createTextNode(value);
        element.appendChild(text);        
    }
}
