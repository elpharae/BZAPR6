package pkg;

//1
// Implementujte třídu Kruh, v této třídě vytvořte jeho instanci a zavolejte metodu toString()
// Trida Kruh bude obsahovat:

// atributy
// double polomer

// konstruktor
// bude přijímat jako parametr polomer a ukladat si ho jako atribut

// funkce
//double dejObvod() - bude vracet obvod kruhu
//double dejObsah() - bude vracet obsah kruhu
//String toString() - Vypíše informace o kruhu - jeho polomer, obvod a obsah
class Kruh {
    //atributy
    private double polomer;

    //konstruktor
    public Kruh(double polomer) {
        this.polomer = polomer;
    }

    //funkce
    @Override
    public String toString() {return "Poloměr: " + polomer + ", Obvod: " + dejObvod() + ", Obsah: " + dejObsah();}
    public double dejObvod() {return 2*Math.PI*polomer;}
    public double dejObsah() {return Math.PI*polomer*polomer;}
}

//2
// Vytvoři třídu SpravcePole
// Třída bude obsahovat funkčnosti z minulého cvičení, příklad Cv1

// atributy
// int [] pole

// konstruktor
// parametr - int delkaPole
// na základe delkaPole, inicializuje promenou pole nahododnými cisly od 0-100
// funkce (viz 5. cviceni Cv1)
// int max()
// int min()
// int suma()
// double prumer()
// String toString() - vrátí String reprezentaci pole (vypis prvku).. napr "[2, 4, 8 , 9, 1]"
class SpravcePole {
    //atributy
    private int[] pole;

    //konstruktor
    public SpravcePole(int delkaPole) {
        this.pole = initArr(delkaPole);
    }

    private int[] initArr(int delkaPole) {
        int[] arr = new int[delkaPole];
        for (int i = 0; i < arr.length; i++) arr[i] = (int) (Math.random() * 100) + 1;
        return arr;
    }

    public int max() {
        int pom;
        for (int i = 0; i < this.pole.length; i++) {
            for (int j = 0; j < this.pole.length; j++) {
                if (this.pole[i] > this.pole[j]) {
                    pom = this.pole[i];
                    this.pole[i] = this.pole[j];
                    this.pole[j] = pom;
                }
            }
        }
        return pole[0];
    }

    public int min() {
        int pom;
        for (int i = 0; i < this.pole.length; i++) {
            for (int j = 0; j < this.pole.length; j++) {
                if (this.pole[i] < this.pole[j]) {
                    pom = this.pole[i];
                    this.pole[i] = this.pole[j];
                    this.pole[j] = pom;
                }
            }
        }
        return this.pole[0];
    }

    public int suma() {
        int result = 0;
        for (int num : this.pole) result += num;
        return result;
    }

    public double prumer() {return (double) suma() / this.pole.length;}

    @Override
    public String toString() {
        String text = "";
        for (int i = 0; i < this.pole.length; i++) text += this.pole[i] + ((i != this.pole.length - 1) ? ", " : "");
        return text;
    }


}
public class Main {

    private Main() {
        Kruh kruh = new Kruh(5.5);
        System.out.println(kruh);

        SpravcePole spravce = new SpravcePole(10);
        System.out.println(spravce);
        System.out.println("Max: " + spravce.max());
        System.out.println("Min: " + spravce.min());
        System.out.println("Prumer: " + spravce.prumer());
        System.out.println("Suma: " + spravce.suma());
    }

    public static void main(String[] args) {
        new Main();
    }
}
