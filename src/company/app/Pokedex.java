package company.app;


import Interfaces.app.IAbm;


public class Pokedex implements IAbm<Pokedex> {

        public void pokedex(){

        }

        public void listar(){

        }

        public void transferir(){

        }

        @Override
        public void agregar(Pokedex elemento) {

        }

        @Override
        public Pokedex borrar(Pokedex elemento) {
                return null;
        }

        @Override
        public void modificar(Pokedex elemento) {

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