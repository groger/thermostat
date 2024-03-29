/*
 Le composant JSlider sert de contrôle au thermostat dont la plage de températures est de -10 à 35
 */

/*
 * ControleThermostat.java
 *
 * Created on 31 oct. 2012, 01:28:28
 */

package thermostat;


import javax.swing.BoundedRangeModel;
import javax.swing.event.ChangeListener;

/**
 *
 * @author gwendo
 */
public class ControleThermostat extends javax.swing.JFrame implements BoundedRangeModel {

    Chambre chambre;//on definit un modele : Chambre
    VueThermometre2 vue;//on definit une vue : VueThermometre2
    double min = -10;//valeurs min et max du thermostat
    double max = 35;

    /** Creates new form ControleThermostat */
    public ControleThermostat(Chambre c, VueThermometre2 v ) {
        chambre=c;
        vue=v;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        thermostat = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        thermostat.setMajorTickSpacing(10);
        thermostat.setMaximum(35);
        thermostat.setMinimum(-10);
        thermostat.setMinorTickSpacing(2);
        thermostat.setOrientation(javax.swing.JSlider.VERTICAL);
        thermostat.setPaintLabels(true);
        thermostat.setPaintTicks(true);
        thermostat.setValue(20);
        thermostat.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                thermostatStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(thermostat, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(thermostat, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void thermostatStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_thermostatStateChanged
     int value =  thermostat.getValue();//get the current value of the jslider thermostat
     this.chambre.setTemperatureThermostat(value); //set it to the model Chambre
    
}//GEN-LAST:event_thermostatStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider thermostat;
    // End of variables declaration//GEN-END:variables

    /*methods of BoundedRangeModel */

     public int getMinimum() {
        return (int)min;
    }

    public void setMinimum(int newMinimum) {
        min=newMinimum;
    }

    public int getMaximum() {
        return (int)max;
    }

    public void setMaximum(int newMaximum) {
        max=newMaximum;
    }

    public int getValue() {
        return (int)chambre.getTemperatureThermostat();
    }

    public void setValue(int newValue) {
        chambre.setTemperatureThermostat(newValue);
    }

    public void setValueIsAdjusting(boolean b) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean getValueIsAdjusting() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getExtent() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setExtent(int newExtent) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setRangeProperties(int value, int extent, int min, int max, boolean adjusting) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addChangeListener(ChangeListener x) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void removeChangeListener(ChangeListener x) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   
}
