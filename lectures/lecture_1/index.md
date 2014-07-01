# Föreläsning 1

!SLIDE pretty

# Java och Swing

[kontakt@lithehack.se](mailto:kontakt@lithehack.se) – [lithehack.se/koma](http://lithehack.se/koma)

!SLIDE left

* grafik
* animering
* menyer
* kortkommandon
* pop up-menyer
* submenyer

Skansholm *Java direkt* upplaga 6 eller 7 avsnitt 7.2, 12.4-7, 14.1

!SLIDE

## Grafik

Standardklassen `java.awt.Graphics` kan användas för att rita enkla figurer.

Linjer, ellipser, rektanglar och text.

!SLIDE code

``` text/x-java
public class MyPanel extends JPanel
{
  // instansvariabler
  // konstruktorer
  // instansmetoder

  // rita figuren, måste finnas
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    g.drawAAA(...);
    g.fillAAA(...);
  }
  // flera metoder möjliga
}
```

!NOTES

 * a note

# Some sample code

``` text/x-java
kåd
```
