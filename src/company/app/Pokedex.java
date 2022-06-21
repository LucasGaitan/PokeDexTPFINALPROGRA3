package company.app;


import Entidad.app.Pokemon;

import java.util.ArrayList;


public class Pokedex{
    ArrayList<Pokemon> pokedex;

    public ArrayList<Pokemon> listar(){
        return pokedex;
    }

    public void agregar(Pokemon elemento) {
        pokedex.add(elemento);
    }

    public Pokemon borrar(Pokemon elemento) {
        Pokemon aux= new Pokemon();
        for(Pokemon p: pokedex)
        {
            if(p.equals(elemento))
            {
                aux=p;
            }
        }
        pokedex.remove(aux);
        return aux;
    }

        /* public void mostrar(String url) throws Exception{
            BufferedImage img = ImageIO.read(new URL(url));
            ImageIcon icon = new ImageIcon(img);
            JFrame frame = new JFrame();
            frame.setLayout(new FlowLayout());
            frame.setSize(200, 300);
            JLabel lbl = new JLabel();
            lbl.setIcon(icon);
            frame.add(lbl);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }*/
}
