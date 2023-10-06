package org.example.Controler;

import org.example.Model.Libreria;
import org.example.Model.Libro;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Mur {
    public static void marshall(){
        try{
            Libreria n=new Libreria();
            Libreria n2=new Libreria();
            List<Libro> libros=new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                Libro libro=new Libro();
                libro.setId(i);
                libro.setNombre(i+" Mi nombre");
                libro.setTitulo(i+" Mi Titulo");
             libros.add(libro);
            }
            n.setLibros(libros);
            n2.setLibros(libros);
            JAXBContext context =JAXBContext.newInstance(Libreria.class);

            Marshaller marshaller=context.createMarshaller();
            Path path= Paths.get("Libreria.xml");
            marshaller.marshal(n, Files.newOutputStream(path));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
