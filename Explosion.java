import javax.swing.*;
public class Explosion extends Thread {

    Cell c;
    ImageIcon exp, expon;
    public Explosion(Cell c) {
        this.c = c;
    }

    public void imageColor(Cell c){
        //0 - rojo, 1 - verde, 2 - azul, 3 - morado, 4 - naranja
        //Esta funcion comprueba de que color es la figura y le pone un color de explosion
        String[] colors = {"r", "v", "a", "m", "n"};

        if (c.valor.equals("cherry") || c.valor.equals("dados")) {
            exp = new ImageIcon(".\\prueba1\\img\\exp\\"+ colors[0] +".png");
            expon = new ImageIcon(exp.getImage().getScaledInstance(700 / 8, 700 / 8, 0));
        }else if (c.valor.equals("bolsa") || c.valor.equals("lucky")){
            exp = new ImageIcon(".\\prueba1\\img\\exp\\"+ colors[1] +".png");
            expon = new ImageIcon(exp.getImage().getScaledInstance(700 / 8, 700 / 8, 0));
        }else if (c.valor.equals("diamond") || c.valor.equals("tragaperras")){
            exp = new ImageIcon(".\\prueba1\\img\\exp\\"+ colors[2] +".png");
            expon = new ImageIcon(exp.getImage().getScaledInstance(700 / 8, 700 / 8, 0));
        }else if (c.valor.equals("cartas") || c.valor.equals("uva") || c.valor.equals("game")){
            exp = new ImageIcon(".\\prueba1\\img\\exp\\"+ colors[3] +".png");
            expon = new ImageIcon(exp.getImage().getScaledInstance(700 / 8, 700 / 8, 0));
        }else if (c.valor.equals("crown") || c.valor.equals("limon") || c.valor.equals("ring")){
            exp = new ImageIcon(".\\prueba1\\img\\exp\\"+ colors[4] +".png");
            expon = new ImageIcon(exp.getImage().getScaledInstance(700 / 8, 700 / 8, 0));
        }
    }

    @Override
    public void run(){
        Icon temp;
        try {
            imageColor(this.c);
            temp = this.c.neigh.getIcon();
            Thread.sleep(75);
            this.c.neigh.setIcon(this.expon);
            Thread.sleep(75);
            this.c.neigh.setIcon(temp);
            Thread.sleep(75);
            this.c.neigh.setIcon(this.expon);
            Thread.sleep(75);
            this.c.neigh.setIcon(temp);
            Thread.sleep(75);
            this.c.neigh.setIcon(this.expon);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}