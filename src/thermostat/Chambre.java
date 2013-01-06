/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package thermostat;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author michel
 * La classe Chambre reprÃ©sente une piÃ¨ce avec chauffage et thermostat.  Le chauffage se
 * mettra automatiquement en action dÃ¨s que la tempÃ©rature intÃ©rieure sera infÃ©rieure
 * Ã  celle fixÃ©e au thermostat.  L'Ã©change thermique avec l'extÃ©rieure et le systÃ¨me de chauffage
 * est simulÃ© par une fonction simple que l'on retrouve dans la mÃ©thode "tick()".
 * Un "timer" est utilisÃ© pour effectuer l'Ã©change thermique Ã  pÃ©riode rÃ©guliÃ¨re.
 */
public class Chambre implements ActionListener {
    // Les variables et leurs valeurs de dÃ©faut
    private double temperatureInterieure = 10; // brrrr...
    private double temperatureExterieure = 0;
    private double facteurIsolation = 0.01; // dÃ©termine l'Ã©change calorifique avec l'extÃ©rieur
    private double facteurChauffage = 0.01;  // dÃ©termine l'Ã©change calorifique avec le chauffage
    private boolean chauffage = false; // le chauffage n'est pas actif par dÃ©faut
    private double temperatureChauffage = 70; // tempÃ©rature des calorifÃ¨res
    private double temperatureThermostat = 20; // le chauffage dÃ©marre Ã  moins de 20 par dÃ©faut

    private javax.swing.Timer timer;

    public Chambre() {
        timer = new javax.swing.Timer(100, this); // les Ã©changes calorifiques
            // se produisent Ã  toutes les 0,1 seconde pour les besoins de cette simulation
        timer.addActionListener(this);
    }

    public void startTemperatureModele() {
        getTimer().start();
    }

    public double getTemperature() {
        return temperatureInterieure;
    }

    public void setTemperatureThermostat(int temperature) {
        temperatureThermostat = temperature;
    }

    public void setTemperatureExterieure(double temperatureExterieure) {
        this.temperatureExterieure = temperatureExterieure;
    }

    public void setTemperatureChauffage(double temperatureChauffage) {
        this.temperatureChauffage = temperatureChauffage;
    }

    // Un "tick" corresond Ã  un Ã©change calorifique
    public void tick() {
        temperatureInterieure += ((getTemperatureExterieure() - temperatureInterieure) * facteurIsolation);
        if (isChauffage() == true) {
            temperatureInterieure += ((temperatureChauffage - temperatureInterieure) * facteurChauffage);
            if(temperatureInterieure > getTemperatureThermostat())
                setChauffage(false);
        } else if(temperatureInterieure < getTemperatureThermostat()) {
            setChauffage(true);
        }
    }
    // L'objet chambre Ã©coute un javax.swing.Timer qui Ã©met un Ã©vÃ©nement "ActionEvent e" pÃ©riodiquement
    public void actionPerformed(ActionEvent e) {
        this.tick();
    }

    // Il est utile d'obtenir le "timer" pour se mettre Ã  jour au mÃªme rythme
    // qu'un objet Chambre
    public javax.swing.Timer getTimer() {
        return timer;
    }

    public double getTemperatureThermostat() {
        return temperatureThermostat;
    }

    public void setTemperatureThermostat(double temperatureThermostat) {
        this.temperatureThermostat = temperatureThermostat;
    }

    public void setChauffage(boolean chauffage) {
        this.chauffage = chauffage;
    }

    public boolean isChauffage() {
        return chauffage;
    }

   public double getTemperatureExterieure() {
        return temperatureExterieure;
    }
}

