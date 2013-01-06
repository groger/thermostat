/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package thermostat;

/**
 *
 * @author gwendo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Chambre c = new Chambre();//Create a chambre modele
        c.startTemperatureModele();//Start le modele de Temperature: Chambre
        VueThermometre2 vue = new VueThermometre2(c);//Create a vueThermometre2
        ControleThermostat cc= new ControleThermostat(c,vue);//Create a controller : ControleThermostat
        cc.setVisible(true);//on affiche le jslider: le thermostat
        vue.setVisible(true);//on affiche la fenêtre principale avec les affichages et le progressbar

    }

}
