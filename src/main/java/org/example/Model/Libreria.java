package org.example.Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Libreria {
    @XmlAttribute
    private static int id=1;
   private List<Libro> libros;

    public Libreria() {
    }

    @Override
    public String toString() {
        return "Libreria{" +
                "libros=" + libros +
                '}';
    }

    public static int getId() {
        return id;
    }

    public static void setId() {
        id++;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}
