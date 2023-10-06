package org.example.Model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.text.SimpleDateFormat;
import java.util.Date;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Dia {
  private  Date date;
  private  int casos;
  private int hombres;
  private int mujeres;

  public Dia() {
  }

  public Dia(Date date, int casos, int hombres, int mujeres) {
    this.date = date;
    this.casos = casos;
    this.hombres = hombres;
    this.mujeres = mujeres;
  }

  public Date getDate() {
    return date;
  }

  public int getCasos() {
    return casos;
  }

  public int getHombres() {
    return hombres;
  }

  public int getMujeres() {
    return mujeres;
  }

  @Override
  public String toString() {
    SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
    return "Casos{" +
            "date=" + form.format(date) +
            ", casos=" + casos +
            ", hombres=" + hombres +
            ", mujeres=" + mujeres +
            '}';
  }
}
