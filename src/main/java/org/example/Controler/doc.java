package org.example.Controler;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.xml.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class doc {
        public static void main(String[] args) {
            // Ruta al archivo XML "coches.xml"
            Path filePath = Paths.get("coches.xml");
            try {
                // Obtiene un flujo de entrada (InputStream) desde el archivo XML
                InputStream inputStream = Files.newInputStream(filePath);
                // Configura una fábrica de documentos XML
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                // Crea un constructor de documentos
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                // Parsea el flujo de entrada y obtiene un objeto Document que representa su contenido
                Document doc = dBuilder.parse(inputStream);
                // Normaliza el documento, lo que asegura que la estructura del árbol esté bien formada
                doc.getDocumentElement().normalize();
                // Obtiene una lista de nodos "coche" del documento XML
                NodeList nList = doc.getElementsByTagName("coche");
                // Muestra la cantidad de nodos "coche" en el archivo XML
                System.out.println("Número de coches: " + nList.getLength());
                // Itera a través de los nodos "coche"
                for (int temp = 0; temp < nList.getLength(); temp++) {
                    // Obtiene el nodo actual
                    Node nNode = nList.item(temp);
                    // Verifica si el nodo es de tipo ELEMENT_NODE (nodos de elementos)
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                  //       Convierte el nodo en un elemento (nodo de elemento)
                        Element eElement = (Element) nNode;
                        Element matricula= doc.createElement("Matricula");
                        matricula.appendChild(doc.createTextNode(String.valueOf(temp)));
                        eElement.appendChild(matricula);


                    }
                }
                TransformerFactory transformerFactory=TransformerFactory.newInstance();
                Transformer transformer= transformerFactory.newTransformer();
                DOMSource dom=new DOMSource(doc);
                StreamResult streamResult=new StreamResult(new File("coches.xml"));
                // Cierra el flujo de entrada después de su uso
                inputStream.close();
            } catch (Exception e) {
                // Captura y muestra cualquier excepción que pueda ocurrir durante la ejecución
                e.printStackTrace();
            }
        }

    }
