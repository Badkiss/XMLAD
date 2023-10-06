package org.example.Controler;

import org.example.Model.Dia;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.example.Model.Mes;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


public class CrearXML
{
    public static void main( String[] args )
    {
//        Mur.marshall();

        try(BufferedReader fichero= Files.newBufferedReader(Paths.get("202101casosm70.csv"), Charset.forName("UTF-8"))){
            Function<String, Dia> format=(s)-> {
                String[] split=s.split(",");
                SimpleDateFormat form=new SimpleDateFormat("yyyy-MM-dd");
                try {
                    return  new Dia(form.parse(split[0].replaceAll("fecha=","").trim()),Integer.valueOf(split[1].replaceAll("casosComunidad=","").trim()),Integer.valueOf(split[2].replaceAll("hombres=","").trim()), Integer.valueOf(split[3].replaceAll("mujeres=","").trim()));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            };
            List<Dia> dias =fichero.lines().map(format).collect(Collectors.toList());
            Mes mes =new Mes(dias);

            JAXBContext context=JAXBContext.newInstance(Mes.class);
            Marshaller marshaller=context.createMarshaller();
            Path path=Paths.get("MesCovid.xml");
            marshaller.marshal(mes,Files.newOutputStream(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
