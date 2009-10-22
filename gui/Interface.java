package gui;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import org.netbeans.microedition.databinding.DataBinder;
import org.netbeans.microedition.databinding.DataSet;

/**
 * @author pabloq
 */
public class Interface extends MIDlet implements CommandListener {

    private boolean midletPaused = false;
    private String estructura;
    private String atributo;
    private Object valor;

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private DataSet dataSet;
    private Command salir;
    private Command indentificar;
    private Command atras;
    private Command eliminarDescritor;
    private Command agregarDescriptor;
    private List descriptores;
    private List estructuras;
    private List atributos;
    private List valores;
    //</editor-fold>//GEN-END:|fields|0|

    /**
     * The Interface constructor.
     */
    public Interface() {
    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    //</editor-fold>//GEN-END:|methods|0|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initilizes the application.
     * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
        atras = new Command("Atras", Command.BACK, 0);//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
    //</editor-fold>//GEN-END:|0-initialize|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
        switchDisplayable(null, getEstructuras());//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
    }//GEN-BEGIN:|3-startMIDlet|2|
    //</editor-fold>//GEN-END:|3-startMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
    //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here

    }//GEN-BEGIN:|5-switchDisplayable|2|
    //</editor-fold>//GEN-END:|5-switchDisplayable|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a particular displayable.
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
        if (displayable == atributos) {//GEN-BEGIN:|7-commandAction|1|37-preAction
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|1|37-preAction
                atributo = ((List)displayable).getString(((List)displayable).getSelectedIndex());
                valor = null;
                // write pre-action user code here
                switchDisplayable(null, getValores());//GEN-LINE:|7-commandAction|2|37-postAction
                // write post-action user code here
            } else if (command == atras) {//GEN-LINE:|7-commandAction|3|41-preAction

                estructura = null;
                estructuras = null;
                // write pre-action user code here
                switchDisplayable(null, getEstructuras());//GEN-LINE:|7-commandAction|4|41-postAction
                // write post-action user code here
            } else if (command == salir) {//GEN-LINE:|7-commandAction|5|77-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|6|77-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|7|61-preAction
        } else if (displayable == descriptores) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|7|61-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|8|61-postAction
                // write post-action user code here
            } else if (command == agregarDescriptor) {//GEN-LINE:|7-commandAction|9|90-preAction
                // write pre-action user code here

                estructura = null;
                estructuras = null;
                atributo = null;
                atributos = null;
                valor = null;
                valores = null;

                switchDisplayable(null, getEstructuras());//GEN-LINE:|7-commandAction|10|90-postAction
                // write post-action user code here
            } else if (command == atras) {//GEN-LINE:|7-commandAction|11|84-preAction
                valor = null;
                valores = null;
                switchDisplayable(null, getValores());//GEN-LINE:|7-commandAction|12|84-postAction
                // write post-action user code here
            } else if (command == eliminarDescritor) {//GEN-LINE:|7-commandAction|13|100-preAction
                // write pre-action user code here

                int idx = ((List)displayable).getSelectedIndex();
                if (idx>=0){
                  descriptores.delete(idx);
                }

//GEN-LINE:|7-commandAction|14|100-postAction
                // write post-action user code here
            } else if (command == indentificar) {//GEN-LINE:|7-commandAction|15|65-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|16|65-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|17|16-preAction
        } else if (displayable == estructuras) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|17|16-preAction
                // write pre-action user code here
                estructura = ((List)displayable).getString(((List)displayable).getSelectedIndex());
                atributo = null;
                valor = null;
                switchDisplayable(null, getAtributos());//GEN-LINE:|7-commandAction|18|16-postAction
                // write post-action user code here
            } else if (command == salir) {//GEN-LINE:|7-commandAction|19|31-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|20|31-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|21|46-preAction
        } else if (displayable == valores) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|21|46-preAction
                // write pre-action user code here
                valor = ((List)displayable).getString(((List)displayable).getSelectedIndex());
                if (descriptores != null)
                    descriptores.append((String)valor, null);

                switchDisplayable(null, getDescriptores());//GEN-LINE:|7-commandAction|22|46-postAction
                // write post-action user code here
            } else if (command == atras) {//GEN-LINE:|7-commandAction|23|82-preAction
                // write pre-action user code here
                atributo = null;
                atributos = null;

                switchDisplayable(null, getAtributos());//GEN-LINE:|7-commandAction|24|82-postAction
                // write post-action user code here
            } else if (command == salir) {//GEN-LINE:|7-commandAction|25|79-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|26|79-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|27|7-postCommandAction
        }//GEN-END:|7-commandAction|27|7-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|28|
    //</editor-fold>//GEN-END:|7-commandAction|28|
    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: estructuras ">//GEN-BEGIN:|14-getter|0|14-preInit
    /**
     * Returns an initiliazed instance of estructuras component.
     * @return the initialized component instance
     */
    public List getEstructuras() {
        if (estructuras == null) {//GEN-END:|14-getter|0|14-preInit
            // write pre-init user code here
            String[] values = {"E1","E2","E3","E4"};
            estructuras = new List("Seleccion de Estructuras", Choice.IMPLICIT);//GEN-BEGIN:|14-getter|1|14-postInit
            estructuras.addCommand(getSalir());
            estructuras.setCommandListener(this);
            estructuras.setFitPolicy(Choice.TEXT_WRAP_DEFAULT);//GEN-END:|14-getter|1|14-postInit
            // write post-init user code here
            for (int i = 0; i<values.length;i++){
                estructuras.append(values[i], null);
            }
            estructuras.setSelectedIndex(0, false);
        }//GEN-BEGIN:|14-getter|2|
        return estructuras;
    }
    //</editor-fold>//GEN-END:|14-getter|2|
    //<editor-fold defaultstate="collapsed" desc=" Generated Method: estructurasAction ">//GEN-BEGIN:|14-action|0|14-preAction
    /**
     * Performs an action assigned to the selected list element in the estructuras component.
     */
    public void estructurasAction() {//GEN-END:|14-action|0|14-preAction
        // enter pre-action user code here
//GEN-LINE:|14-action|1|14-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|14-action|2|
    //</editor-fold>//GEN-END:|14-action|2|
    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: salir ">//GEN-BEGIN:|30-getter|0|30-preInit
    /**
     * Returns an initiliazed instance of salir component.
     * @return the initialized component instance
     */
    public Command getSalir() {
        if (salir == null) {//GEN-END:|30-getter|0|30-preInit
            // write pre-init user code here
            salir = new Command("Salir", Command.EXIT, 0);//GEN-LINE:|30-getter|1|30-postInit
            // write post-init user code here
        }//GEN-BEGIN:|30-getter|2|
        return salir;
    }
    //</editor-fold>//GEN-END:|30-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: indentificar ">//GEN-BEGIN:|64-getter|0|64-preInit
    /**
     * Returns an initiliazed instance of indentificar component.
     * @return the initialized component instance
     */
    public Command getIndentificar() {
        if (indentificar == null) {//GEN-END:|64-getter|0|64-preInit
            // write pre-init user code here
            indentificar = new Command("Identificar", Command.OK, 0);//GEN-LINE:|64-getter|1|64-postInit
            // write post-init user code here
        }//GEN-BEGIN:|64-getter|2|
        return indentificar;
    }
    //</editor-fold>//GEN-END:|64-getter|2|
    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: atributos ">//GEN-BEGIN:|36-getter|0|36-preInit
    /**
     * Returns an initiliazed instance of atributos component.
     * @return the initialized component instance
     */
    public List getAtributos() {
        if (atributos == null) {//GEN-END:|36-getter|0|36-preInit
            // write pre-init user code here


            String[] values = {"A1","A2","A3","A4"};

            atributos = new List("Seleccion de Atributos", Choice.IMPLICIT);//GEN-BEGIN:|36-getter|1|36-postInit
            atributos.addCommand(atras);
            atributos.addCommand(getSalir());
            atributos.setCommandListener(this);//GEN-END:|36-getter|1|36-postInit
            // write post-init user code here
            for (int i = 0; i<values.length;i++){
                atributos.append(estructura +">"+ values[i], null);
            }

        }//GEN-BEGIN:|36-getter|2|
        return atributos;
    }
    //</editor-fold>//GEN-END:|36-getter|2|
    //<editor-fold defaultstate="collapsed" desc=" Generated Method: atributosAction ">//GEN-BEGIN:|36-action|0|36-preAction
    /**
     * Performs an action assigned to the selected list element in the atributos component.
     */
    public void atributosAction() {//GEN-END:|36-action|0|36-preAction
        // enter pre-action user code here
        String __selectedString = getAtributos().getString(getAtributos().getSelectedIndex());//GEN-LINE:|36-action|1|36-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|36-action|2|
    //</editor-fold>//GEN-END:|36-action|2|
    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: valores ">//GEN-BEGIN:|45-getter|0|45-preInit
    /**
     * Returns an initiliazed instance of valores component.
     * @return the initialized component instance
     */
    public List getValores() {
        if (valores == null) {//GEN-END:|45-getter|0|45-preInit
            // write pre-init user code here

            String[] values = {"V1","V2","V3","V4"};
            valores = new List("Seleccion de Valores", Choice.IMPLICIT);//GEN-BEGIN:|45-getter|1|45-postInit
            valores.addCommand(atras);
            valores.addCommand(getSalir());
            valores.setCommandListener(this);//GEN-END:|45-getter|1|45-postInit
            // write post-init user code here

            for (int i = 0; i<values.length;i++){
                valores.append(atributo +">"+ values[i], null);
            }



        }//GEN-BEGIN:|45-getter|2|
        return valores;
    }
    //</editor-fold>//GEN-END:|45-getter|2|
    //<editor-fold defaultstate="collapsed" desc=" Generated Method: valoresAction ">//GEN-BEGIN:|45-action|0|45-preAction
    /**
     * Performs an action assigned to the selected list element in the valores component.
     */
    public void valoresAction() {//GEN-END:|45-action|0|45-preAction
        // enter pre-action user code here
        String __selectedString = getValores().getString(getValores().getSelectedIndex());//GEN-LINE:|45-action|1|45-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|45-action|2|
    //</editor-fold>//GEN-END:|45-action|2|
    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: descriptores ">//GEN-BEGIN:|60-getter|0|60-preInit
    /**
     * Returns an initiliazed instance of descriptores component.
     * @return the initialized component instance
     */
    public List getDescriptores() {
        if (descriptores == null) {//GEN-END:|60-getter|0|60-preInit
            // write pre-init user code here
            descriptores = new List("Lista de Descriptores", Choice.IMPLICIT);//GEN-BEGIN:|60-getter|1|60-postInit
            descriptores.addCommand(atras);
            descriptores.addCommand(getAgregarDescriptor());
            descriptores.addCommand(getEliminarDescritor());
            descriptores.addCommand(getIndentificar());
            descriptores.setCommandListener(this);//GEN-END:|60-getter|1|60-postInit

                if (valor != null)
                    descriptores.append((String)valor, null);

        }//GEN-BEGIN:|60-getter|2|
        return descriptores;
    }
    //</editor-fold>//GEN-END:|60-getter|2|
    //<editor-fold defaultstate="collapsed" desc=" Generated Method: descriptoresAction ">//GEN-BEGIN:|60-action|0|60-preAction
    /**
     * Performs an action assigned to the selected list element in the descriptores component.
     */
    public void descriptoresAction() {//GEN-END:|60-action|0|60-preAction
        // enter pre-action user code here
        String __selectedString = getDescriptores().getString(getDescriptores().getSelectedIndex());//GEN-LINE:|60-action|1|60-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|60-action|2|
    //</editor-fold>//GEN-END:|60-action|2|
    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: agregarDescriptor ">//GEN-BEGIN:|89-getter|0|89-preInit
    /**
     * Returns an initiliazed instance of agregarDescriptor component.
     * @return the initialized component instance
     */
    public Command getAgregarDescriptor() {
        if (agregarDescriptor == null) {//GEN-END:|89-getter|0|89-preInit
            // write pre-init user code here
            agregarDescriptor = new Command("Agregar Descriptor", Command.OK, 0);//GEN-LINE:|89-getter|1|89-postInit
            // write post-init user code here
        }//GEN-BEGIN:|89-getter|2|
        return agregarDescriptor;
    }
    //</editor-fold>//GEN-END:|89-getter|2|
    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: dataSet ">//GEN-BEGIN:|94-getter|0|94-preInit
    /**
     * Returns an initiliazed instance of dataSet component.
     * @return the initialized component instance
     */
    public DataSet getDataSet() {
        if (dataSet == null) {//GEN-END:|94-getter|0|94-preInit
            // write pre-init user code here
            dataSet = new DataSet_();//GEN-LINE:|94-getter|1|94-postInit
            // write post-init user code here
        }//GEN-BEGIN:|94-getter|2|94codeZone1
        return dataSet;
    }
    private class DataSet_ implements DataSet {//GEN-END:|94-getter|2|94codeZone1
        // declaration field

        public Class getType(String name) throws IllegalStateException {//GEN-LINE:|94-getter|3|94codeZone2

            throw new IllegalStateException("Not implemented yet.");
        }//GEN-LINE:|94-getter|4|94codeZone3

        public Object getValue(String name) throws IllegalStateException {//GEN-LINE:|94-getter|5|94codeZone4

            throw new IllegalStateException("Not implemented yet.");
        }//GEN-LINE:|94-getter|6|94codeZone5

        public void setValue(String name, Object value) throws IllegalStateException {//GEN-LINE:|94-getter|7|94codeZone6
            //TODO
            DataBinder.fireDataSetChanged(this , name);
        }//GEN-LINE:|94-getter|8|94codeZone7

        public void setAsString(String name, String stringValue) throws IllegalStateException {//GEN-LINE:|94-getter|9|94codeZone8
            //TODO
            DataBinder.fireDataSetChanged(this , name);
        }//GEN-LINE:|94-getter|10|94codeZone9

        public boolean isReadOnly(String readOnly) throws IllegalStateException {//GEN-LINE:|94-getter|11|94codeZone10

            throw new IllegalStateException("Not implemented yet.");
        }//GEN-LINE:|94-getter|12|94codeZone11

    };//GEN-LINE:|94-getter|13|94end
    //</editor-fold>//GEN-LINE:|94-getter|14|








    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: eliminarDescritor ">//GEN-BEGIN:|99-getter|0|99-preInit
    /**
     * Returns an initiliazed instance of eliminarDescritor component.
     * @return the initialized component instance
     */
    public Command getEliminarDescritor() {
        if (eliminarDescritor == null) {//GEN-END:|99-getter|0|99-preInit
            // write pre-init user code here
            eliminarDescritor = new Command("Eliminar Descriptor", Command.OK, 0);//GEN-LINE:|99-getter|1|99-postInit
            // write post-init user code here
        }//GEN-BEGIN:|99-getter|2|
        return eliminarDescritor;
    }
    //</editor-fold>//GEN-END:|99-getter|2|

    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay () {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable (null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started.
     * Checks whether the MIDlet have been already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet ();
        } else {
            initialize ();
            startMIDlet ();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     * @param unconditional if true, then the MIDlet has to be unconditionally terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }

}
