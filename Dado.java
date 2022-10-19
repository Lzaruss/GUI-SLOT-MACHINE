import javax.swing.*;
import java.util.Random;


public class Dado extends Thread{

    ImageIcon exp;
    //Boton del dado
    JLabel c, ganancias, credito;
    JButton start;
    //Premios del dado, si toca un 1, tendras un 100, asi sucesivamente
    int[] premios = {100, 200, 300, 400, 500, 600};
    //Variable donde se guardara el valor del premio
    int valor;
    Contador contador = new Contador();
    public Dado(JLabel c, JButton start, JLabel ganancias, JLabel credito){
        this.c = c;
        this.start = start;
        this.ganancias = ganancias;
        this.credito = credito;
    }


    public void changeImage(ImageIcon icon){
        this.c.setIcon(icon);
    }

    @Override
    public void run(){
        int random;
        Random rnd = new Random();
        int numAlea = rnd.nextInt(40, 50);

        for(int i = 0; i < numAlea; i++) {
            random = rnd.nextInt(0,6);
            this.c.setVisible(true);
            this.exp = new ImageIcon(".\\prueba1\\img\\num\\" + (random+1) + ".PNG");
            ImageIcon numIcon = new ImageIcon(exp.getImage().getScaledInstance(700 / 8, 700 / 8, 0));
            try {
                Thread.sleep(20);
                this.c.setIcon(numIcon);
                this.valor = this.premios[random];

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        int temp = Integer.parseInt(ganancias.getText());
        contador.start();
        contador.refrescarPrice(ganancias, this.valor);

        credito.setText(String.valueOf(Integer.parseInt(credito.getText()) + this.valor));
        System.out.println("Bonus: " + this.valor);
        this.start.setVisible(true);

    }
}
