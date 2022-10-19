import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Cell{
    int x;
    int y;
    public String valor;
    public JLabel neigh;
    public boolean visited;
    public int numValues;
    //bolsa - 1, cartas - 2, cherry - 3, crown - 4, diamond - 5, game - 6, limon - 7, lucky - 8, ring - 9, tragaperras - 10, uva - 11, dados - 12;
    String[] values = {"bolsa", "cartas", "cherry", "crown", "diamond", "game", "limon", "lucky", "ring", "tragaperras", "uva", "dados"};

    public Cell(int x, int y, String valor, JLabel neigh){
        this.x = x;
        this.y = y;
        this.valor = valor;
        this.neigh = neigh;
        this.numValues = 0;
        this.visited = false;
    }
    public void randomImage(){

        //int random = (int) (Math.random() * 12);
        int random = randomNumber();
        ImageIcon fruta = new ImageIcon(".\\prueba1\\img\\" + this.values[random] + ".PNG");
        ImageIcon fruton = new ImageIcon(fruta.getImage().getScaledInstance(700 / 8, 700 / 8, 0));
        this.neigh.setIcon(fruton);
        this.neigh.setText(String.valueOf(random + 1));
        this.valor = this.values[random];
    }

    private int randomNumber (){
        //Probabilidad para que aparezcan distintas figuras
        //bolsa - 1, cartas - 2, cherry - 3, crown - 4, diamond - 5, game - 6, limon - 7, lucky - 8, ring - 9, tragaperras - 10, uva - 11, dados - 12;
        int random;
        Random rnd = new Random();
        random = rnd.nextInt(100);

        if (random < 8)
            return 8;
        else if (random < 16)
            return 7;
        else if (random < 24)
            return 9;
        else if (random < 32)
            return 6;
        else if (random < 40)
            return 1;
        else if (random < 48)
            return 0;
        else if (random < 56)
            return 10;
        else if (random < 64)
            return 2;
        else if (random < 72)
            return 3;
        else if (random < 80)
            return 4;
        else if (random < 88)
            return 5;
        else
            return 11;
    }
}