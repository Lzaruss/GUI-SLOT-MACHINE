import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SlotMachine extends JFrame {

    //Columnas y filas de la maquina
    public int colx = 8;
    public int rowy = 8;
    //Altura y ancho de la ventana
    public int width = 700;
    public int height = 700;

    //Array bi-dimensional donde se guarda cada celda
    Cell[][] cells = new Cell[this.colx][this.rowy];
    JDialog over, premios;
    JButton start, buttonPrizes;
    JLabel ganancias, creditos, displayGanancias, displayCreditos, gameOver, dadoLabel, rules;
    int creditoInicial = 3000;
    String[] values = {"bolsa", "cartas", "cherry", "crown", "diamond", "game", "limon", "lucky", "ring", "tragaperras", "uva", "dados"};
    int[] prix = {2, 3, 5, 7, 8, 10, 15, 20, 25, 30, 35, 50};
    public SlotMachine() {

        this.initPantalla();
        this.initButtons();
        this.initCeldas();
        this.initDialog();
        this.setVisible(true);
    }

    public void initPantalla() {
        this.setLayout(new GridLayout(this.rowy, this.colx));
        this.setBounds(1920 / 2 - (this.width / 2), 1080 / 2 - (this.height / 2), this.width, this.height);
        this.setTitle("Slot Machine");
        this.getContentPane().setBackground(Color.BLACK);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void initCeldas() {
        for (int i = 0; i < this.colx; i++)
            for (int j = 0; j < this.rowy; j++) {
                //Si es un borde entra en este if
                if (i == 0 || j == 0 || i == this.rowy - 1 || j == this.colx - 1) {

                    this.cells[i][j] = new Cell(i, j, "0",  new JLabel());
                    //colocar botones
                    if ((i == this.colx - 1) && (j == 3))
                        this.add(this.start);
                    else if ((i == 0) && (j == 2))
                        this.add(this.ganancias);
                    else if ((i == 0) && (j == 4))
                        this.add(this.creditos);
                    else if ((i == 0) && (j == 3))
                        this.add(this.displayGanancias);
                    else if ((i == 0) && (j == 5))
                        this.add(this.displayCreditos);
                    else if ((i == 0) && (j == 0))
                        this.add(this.buttonPrizes);
                    else if ((i == this.colx - 1) && (j == this.rowy - 1))
                        this.add(this.dadoLabel);
                    else
                        this.add(this.cells[i][j].neigh);
                } else {
                    this.cells[i][j] = new Cell(i, j, "borde",  new JLabel());
                    this.cells[i][j].randomImage();
                    this.add(this.cells[i][j].neigh);
                }
            }
    }

    public void initButtons(){
        //Imagenes
        ImageIcon startIcon = new ImageIcon(".\\prueba1\\img\\start.png");
        this.start = new JButton(new ImageIcon(startIcon.getImage().getScaledInstance(this.width / this.colx, this.height / this.rowy , 0)));

        this.start.setBackground(Color.BLACK);
        this.start.setBorder(null);

        this.buttonPrizes = new JButton("PRIZES");
        this.buttonPrizes.setFont(new Font("SansSerif", Font.ITALIC, 20));
        this.buttonPrizes.setForeground(Color.white);
        this.buttonPrizes.setBackground(Color.BLACK);
        this.buttonPrizes.setBorder(null);

        this.dadoLabel = new JLabel("");
        this.dadoLabel.setBackground(Color.BLACK);
        this.dadoLabel.setBorder(null);

        this.displayGanancias = new JLabel("0");
        this.displayGanancias.setHorizontalAlignment(SwingConstants.CENTER);
        this.displayGanancias.setFont(new Font("SansSerif", Font.ITALIC, 30));
        this.displayGanancias.setForeground(Color.white);
        this.displayCreditos = new JLabel(String.valueOf(this.creditoInicial));
        this.displayCreditos.setHorizontalAlignment(SwingConstants.CENTER);
        this.displayCreditos.setFont(new Font("SansSerif", Font.ITALIC, 30));
        this.displayCreditos.setForeground(Color.white);

        ImageIcon gananciasIcon = new ImageIcon(".\\prueba1\\img\\lastPrice.png");
        this.ganancias = new JLabel(new ImageIcon(gananciasIcon.getImage().getScaledInstance(this.width / this.rowy, this.height / this.colx , 0)));

        ImageIcon creditosIcon = new ImageIcon(".\\prueba1\\img\\credits.png");
        this.creditos = new JLabel(new ImageIcon(creditosIcon.getImage().getScaledInstance(this.width / this.rowy, this.height / this.colx , 0)));

        this.start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Jugar a = new Jugar(cells, start, displayGanancias, displayCreditos, over, dadoLabel);
                start.setVisible(false);
                start.requestFocus();
                a.dadoThread.changeImage(new ImageIcon(""));
                a.dado.setVisible(false);
                a.start();
            }
        });

        this.buttonPrizes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                premios.setVisible(true);
                start.requestFocus();
            }
        });
    }

    public void initDialog(){

        this.over = new JDialog();
        this.over.setBounds(1920 / 2 - (this.width / 2), 1080 / 2 - (this.height / 2), this.width, this.height);
        this.over.getContentPane().setBackground(Color.BLACK);

        this.gameOver = new JLabel();
        this.gameOver.setBackground(Color.BLACK);
        ImageIcon gameOverIcon = new ImageIcon(".\\prueba1\\img\\game_over.png");
        this.gameOver.setIcon(new ImageIcon(gameOverIcon.getImage().getScaledInstance(this.width, this.height, 0)));

        this.over.add(this.gameOver);

        this.premios = new JDialog();
        this.premios.setBounds(1920 / 2 - (this.width / 2), 1080 / 2 - (this.height / 2), this.width, 400);
        this.premios.getContentPane().setBackground(Color.BLACK);
        this.rules = new JLabel("Las reglas del juego son que aparezcan 6 o más figuras para que exploten, los premios son los siguientes:");
        this.rules.setBounds(0, 0, this.width, 50);
        this.rules.setBackground(Color.BLACK);
        this.rules.setForeground(Color.white);
        this.premios.add(this.rules);

        JLabel[] prizes = new JLabel[this.values.length];
        JLabel x = new JLabel();
        int alt = 0;
        for (int i = 0; i < prizes.length; i++){
            prizes[i] = new JLabel(this.values[i] + " -> " + this.prix[i]);
            prizes[i].setBounds(20, alt+=20, this.width, 50);
            prizes[i].setBackground(Color.BLACK);
            prizes[i].setForeground(Color.white);
            this.premios.add(prizes[i]);
        }
        this.premios.add(x);
    }

    public static void main(String[] args) {
        new SlotMachine();
    }
}