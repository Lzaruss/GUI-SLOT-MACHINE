import javax.swing.*;
import java.util.ArrayList;

public class Jugar extends Thread{

    private Cell[][] cell;
    String[] values = {"bolsa", "cartas", "cherry", "crown", "diamond", "game", "limon", "lucky", "ring", "tragaperras", "uva", "dados"};
    int[] numValues = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int[] apuesta = {100};
    int[] premios = {2, 3, 5, 7, 8, 10, 15, 20, 25, 30, 35, 50};
    int lastPremio;
    JButton start;
    JLabel ganancias, credito, dado;
    JDialog over;
    Dado dadoThread;
    Contador contador, contadorCreditos;
    ArrayList<Cell> celdasGanadoras = new ArrayList<>();
    Explosion explosion;

    public Jugar(Cell[][] cell, JButton b, JLabel ganancias, JLabel credito, JDialog over, JLabel dado){

        this.cell = cell;
        this.start = b;
        this.lastPremio = 0;
        this.ganancias = ganancias;
        this.credito = credito;
        this.over = over;
        this.dado = dado;
        this.dadoThread = new Dado(dado, this.start, this.ganancias, this.credito);
    }


    public void explosion(int pos) {
        Icon temp;
        //Cambia la imagen de las frutas en concreto.
        for (int k = 1; k < this.cell.length; k++)
            for (int j = 1; j < this.cell[k].length; j++) {
                if (this.cell[k][j].valor.equals(this.values[pos])) {
                    this.celdasGanadoras.add(this.cell[k][j]);
                }
                for (int i = 0; i < this.celdasGanadoras.size(); i++){

                    explosion = new Explosion(this.celdasGanadoras.get(i));
                    explosion.start();

                }
            }
    }

    public void data(){
        //bolsa - 1, cartas - 2, cherry - 3, crown - 4, dados - 5, diamond - 6, game - 7, limon - 8, lucky - 9, ring - 10, tragaperras - 11, uva - 12;
        //Comprueba de que tipo es cada celda y la suma a una variable de control
        for(int i = 1; i < this.cell.length; i++)
            for(int j = 1; j < this.cell[i].length; j++){
                if (this.cell[i][j].valor.equals("bolsa")){
                    this.numValues[0]++;
                }else if (this.cell[i][j].valor.equals("cartas")){
                    this.numValues[1]++;
                }else if (this.cell[i][j].valor.equals("cherry")){
                    this.numValues[2]++;
                }else if (this.cell[i][j].valor.equals("crown")){
                    this.numValues[3]++;
                }else if (this.cell[i][j].valor.equals("diamond")){
                    this.numValues[4]++;
                }else if (this.cell[i][j].valor.equals("game")){
                    this.numValues[5]++;
                }else if (this.cell[i][j].valor.equals("limon")){
                    this.numValues[6]++;
                }else if (this.cell[i][j].valor.equals("lucky")){
                    this.numValues[7]++;
                }else if (this.cell[i][j].valor.equals("ring")){
                    this.numValues[8]++;
                }else if (this.cell[i][j].valor.equals("tragaperras")){
                    this.numValues[9]++;
                }else if (this.cell[i][j].valor.equals("uva")){
                    this.numValues[10]++;
                }else if (this.cell[i][j].valor.equals("dados")){
                    this.numValues[11]++;
                }
            }
        //Comprueba si hay algun tipo de figura con mas de 6 y en ese caso llamará a explosion
        for (int i = 0; i < this.values.length; i++) {
            System.out.println("Fruta: " + this.values[i] + "->"+ this.numValues[i]);
            if (this.numValues[i] >= 8) {
                this.explosion(i);
                this.premios(i, this.numValues[i]);
                if (i == 11) {
                    this.dadoThread.start();
                }
            }
        }
        System.out.println("Tirada: " + this.lastPremio);
        this.credito.setText(String.valueOf(Integer.parseInt(this.credito.getText()) + this.lastPremio));

        System.out.println(this.dadoThread.isAlive());
        if(!this.dadoThread.isAlive())
                this.start.setVisible(true);

        System.out.println("\n");
    }

    public void premios (int pos, int cant){
        //Funcion que calcula cuanto ganará en cada tirada.
        //bolsa - 1, cartas - 2, cherry - 3, crown - 4, dados - 5, diamond - 6, game - 7, limon - 8, lucky - 9, ring - 10, tragaperras - 11, uva - 12;

        if (this.values[pos].equals("game")){
            this.lastPremio = this.lastPremio + premios[0]*cant;
            contador = new Contador();
            contador.start();
            contador.refrescarPrice(this.ganancias, this.lastPremio);
        }else if (this.values[pos].equals("limon")){
            this.lastPremio = this.lastPremio + premios[1]*cant;
            contador = new Contador();
            contador.start();
            contador.refrescarPrice(this.ganancias, this.lastPremio);
        }else if (this.values[pos].equals("ring")){
            this.lastPremio = this.lastPremio + premios[2]*cant;
            contador = new Contador();
            contador.start();
            contador.refrescarPrice(this.ganancias, this.lastPremio);
        }else if (this.values[pos].equals("uva")){
            this.lastPremio = this.lastPremio + premios[3]*cant;
            contador = new Contador();
            contador.start();
            contador.refrescarPrice(this.ganancias, this.lastPremio);
        }else if (this.values[pos].equals("cartas")){
            this.lastPremio = this.lastPremio + premios[4]*cant;
            contador = new Contador();
            contador.start();
            contador.refrescarPrice(this.ganancias, this.lastPremio);
        }else if (this.values[pos].equals("bolsa")){
            this.lastPremio = this.lastPremio + premios[5]*cant;
            contador = new Contador();
            contador.start();
            contador.refrescarPrice(this.ganancias, this.lastPremio);
        }else if (this.values[pos].equals("tragaperras")){
            this.lastPremio = this.lastPremio + premios[6]*cant;
            contador = new Contador();
            contador.start();
            contador.refrescarPrice(this.ganancias, this.lastPremio);
        }else if (this.values[pos].equals("cherry")){
            this.lastPremio = this.lastPremio + premios[7]*cant;
            contador = new Contador();
            contador.start();
            contador.refrescarPrice(this.ganancias, this.lastPremio);
        }else if (this.values[pos].equals("crown")){
            this.lastPremio = this.lastPremio + premios[8]*cant;
            contador = new Contador();
            contador.start();
            contador.refrescarPrice(this.ganancias, this.lastPremio);
        }else if (this.values[pos].equals("dados")){
            this.lastPremio = this.lastPremio + premios[9]*cant;
            contador = new Contador();
            contador.start();
            contador.refrescarPrice(this.ganancias, this.lastPremio);
        }else if (this.values[pos].equals("diamond")){
            this.lastPremio = this.lastPremio + premios[10]*cant;
            contador = new Contador();
            contador.start();
            contador.refrescarPrice(this.ganancias, this.lastPremio);
        }else if (this.values[pos].equals("lucky")){
            this.lastPremio = this.lastPremio + premios[11]*cant;
            contador = new Contador();
            contador.start();
            contador.refrescarPrice(this.ganancias, this.lastPremio);
        }
    }

    @Override
    public void run(){

        this.lastPremio = 0;
        this.ganancias.setText("0");
        //Este if comprueba que no tiene menos de la minima apuesta, en ese caso saltara el dialog de game over
        if (Integer.parseInt(this.credito.getText()) >= this.apuesta[0]) {
            for (int i = 1; i < this.cell.length - 1; i++) {
                for (int j = 1; j < this.cell[i].length - 1; j++) {
                    this.cell[i][j].randomImage();
                }
            }
            this.credito.setText(String.valueOf(Integer.parseInt(this.credito.getText()) - this.apuesta[0]));
            data();
        }else{
            this.over.setVisible(true);
        }
    }
}