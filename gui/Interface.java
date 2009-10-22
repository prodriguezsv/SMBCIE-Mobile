/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
    private Command salir;
    private Command atras;
    private Command indentificar;
    private Command borrarDescriptor;
    private Command AgregarDescriptor;
    private List Estructuras;
    private List Atributos;
    private List Valores;
    private List Descriptores;
    private DataSet dataSet;
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
//GEN-LINE:|0-initialize|1|0-postInitialize
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
        if (displayable == Atributos) {//GEN-BEGIN:|7-commandAction|1|37-preAction
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|1|37-preAction
                atributo = ((List)displayable).getString(((List)displayable).getSelectedIndex());
                valor = null;
                // write pre-action user code here
                switchDisplayable(null, getValores());//GEN-LINE:|7-commandAction|2|37-postAction
                // write post-action user code here
            } else if (command == atras) {//GEN-LINE:|7-commandAction|3|41-preAction
                // write pre-action user code here
                switchDisplayable(null, getEstructuras());//GEN-LINE:|7-commandAction|4|41-postAction
                // write post-action user code here
            } else if (command == salir) {//GEN-LINE:|7-commandAction|5|77-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|6|77-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|7|90-preAction
        } else if (displayable == Descriptores) {
            if (command == AgregarDescriptor) {//GEN-END:|7-commandAction|7|90-preAction
                // write pre-action user code here
                switchDisplayable(null, getEstructuras());//GEN-LINE:|7-commandAction|8|90-postAction
                // write post-action user code here
            } else if (command == List.SELECT_COMMAND) {//GEN-LINE:|7-commandAction|9|61-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|10|61-postAction
                // write post-action user code here
            } else if (command == atras) {//GEN-LINE:|7-commandAction|11|84-preAction
                // write pre-action user code here
                switchDisplayable(null, getValores());//GEN-LINE:|7-commandAction|12|84-postAction
                // write post-action user code here
            } else if (command == borrarDescriptor) {//GEN-LINE:|7-commandAction|13|76-preAction
                // write pre-action user code here
                Descriptores.delete(((List)displayable).getSelectedIndex());
//GEN-LINE:|7-commandAction|14|76-postAction
                // write post-action user code here
            } else if (command == indentificar) {//GEN-LINE:|7-commandAction|15|65-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|16|65-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|17|16-preAction
        } else if (displayable == Estructuras) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|17|16-preAction
                // write pre-action user code here
                estructura = ((List)displayable).getString(((List)displayable).getSelectedIndex());

                atributo = null;
                valor = null;
                switchDisplayable(null, getAtributos());//GEN-LINE:|7-commandAction|18|16-postAction
                // write post-action user code here
            } else if (command == atras) {//GEN-LINE:|7-commandAction|19|86-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|20|86-postAction
                // write post-action user code here
            } else if (command == salir) {//GEN-LINE:|7-commandAction|21|31-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|22|31-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|23|46-preAction
        } else if (displayable == Valores) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|23|46-preAction
                // write pre-action user code here
                valor = ((List)displayable).getString(((List)displayable).getSelectedIndex());
                switchDisplayable(null, getDescriptores());//GEN-LINE:|7-commandAction|24|46-postAction
                // write post-action user code here
            } else if (command == atras) {//GEN-LINE:|7-commandAction|25|82-preAction
                // write pre-action user code here
                switchDisplayable(null, getAtributos());//GEN-LINE:|7-commandAction|26|82-postAction
                // write post-action user code here
            } else if (command == salir) {//GEN-LINE:|7-commandAction|27|79-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|28|79-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|29|7-postCommandAction
        }//GEN-END:|7-commandAction|29|7-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|30|
    //</editor-fold>//GEN-END:|7-commandAction|30|



    //</editor-fold>


    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Estructuras ">//GEN-BEGIN:|14-getter|0|14-preInit
    /**
     * Returns an initiliazed instance of Estructuras component.
     * @return the initialized component instance
     */
    public List getEstructuras() {
        if (Estructuras == null) {//GEN-END:|14-getter|0|14-preInit
            // write pre-init user code here
            String[] values = {"E1","E2","E3","E4"};
            Estructuras = new List("Seleccion de Estructuras", Choice.IMPLICIT);//GEN-BEGIN:|14-getter|1|14-postInit
            Estructuras.addCommand(getSalir());
            Estructuras.addCommand(getAtras());
            Estructuras.setCommandListener(this);
            Estructuras.setFitPolicy(Choice.TEXT_WRAP_DEFAULT);//GEN-END:|14-getter|1|14-postInit
            // write post-init user code here
            for (int i = 0; i<values.length;i++){
                Estructuras.append(values[i], null);
            }
        }//GEN-BEGIN:|14-getter|2|
        return Estructuras;
    }
    //</editor-fold>//GEN-END:|14-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: EstructurasAction ">//GEN-BEGIN:|14-action|0|14-preAction
    /**
     * Performs an action assigned to the selected list element in the Estructuras component.
     */
    public void EstructurasAction() {//GEN-END:|14-action|0|14-preAction
        // enter pre-action user code here
//GEN-LINE:|14-action|1|14-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|14-action|2|
    //</editor-fold>//GEN-END:|14-action|2|










    //</editor-fold>

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
    //</editor-fold>


    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: atras ">//GEN-BEGIN:|40-getter|0|40-preInit
    /**
     * Returns an initiliazed instance of atras component.
     * @return the initialized component instance
     */
    public Command getAtras() {
        if (atras == null) {//GEN-END:|40-getter|0|40-preInit
            // write pre-init user code here
            atras = new Command("Volver", Command.BACK, 0);//GEN-LINE:|40-getter|1|40-postInit
            // write post-init user code here
        }//GEN-BEGIN:|40-getter|2|
        return atras;
    }
    //</editor-fold>//GEN-END:|40-getter|2|


    //</editor-fold>


    //</editor-fold>


    //</editor-fold>


    //</editor-fold>


    //</editor-fold>

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
    //</editor-fold>


    //</editor-fold>
    //</editor-fold>


    //</editor-fold>


    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Atributos ">//GEN-BEGIN:|36-getter|0|36-preInit
    /**
     * Returns an initiliazed instance of Atributos component.
     * @return the initialized component instance
     */
    public List getAtributos() {
        if (Atributos == null) {//GEN-END:|36-getter|0|36-preInit
            // write pre-init user code here


            String[] values = {"A1","A2","A3","A4"};

            Atributos = new List("Seleccion de Atributos", Choice.IMPLICIT);//GEN-BEGIN:|36-getter|1|36-postInit
            Atributos.addCommand(getAtras());
            Atributos.addCommand(getSalir());
            Atributos.setCommandListener(this);//GEN-END:|36-getter|1|36-postInit
            // write post-init user code here
            for (int i = 0; i<values.length;i++){
                Atributos.append(estructura +">"+ values[i], null);
            }

        }//GEN-BEGIN:|36-getter|2|
        return Atributos;
    }
    //</editor-fold>//GEN-END:|36-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: AtributosAction ">//GEN-BEGIN:|36-action|0|36-preAction
    /**
     * Performs an action assigned to the selected list element in the Atributos component.
     */
    public void AtributosAction() {//GEN-END:|36-action|0|36-preAction
        // enter pre-action user code here
        String __selectedString = getAtributos().getString(getAtributos().getSelectedIndex());//GEN-LINE:|36-action|1|36-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|36-action|2|
    //</editor-fold>//GEN-END:|36-action|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Valores ">//GEN-BEGIN:|45-getter|0|45-preInit
    /**
     * Returns an initiliazed instance of Valores component.
     * @return the initialized component instance
     */
    public List getValores() {
        if (Valores == null) {//GEN-END:|45-getter|0|45-preInit
            // write pre-init user code here

            String[] values = {"V1","V2","V3","V4"};
            Valores = new List("Seleccion de Valores", Choice.IMPLICIT);//GEN-BEGIN:|45-getter|1|45-postInit
            Valores.addCommand(getSalir());
            Valores.addCommand(getAtras());
            Valores.setCommandListener(this);//GEN-END:|45-getter|1|45-postInit
            // write post-init user code here

            for (int i = 0; i<values.length;i++){
                Valores.append(atributo +">"+ values[i], null);
            }



        }//GEN-BEGIN:|45-getter|2|
        return Valores;
    }
    //</editor-fold>//GEN-END:|45-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: ValoresAction ">//GEN-BEGIN:|45-action|0|45-preAction
    /**
     * Performs an action assigned to the selected list element in the Valores component.
     */
    public void ValoresAction() {//GEN-END:|45-action|0|45-preAction
        // enter pre-action user code here
        String __selectedString = getValores().getString(getValores().getSelectedIndex());//GEN-LINE:|45-action|1|45-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|45-action|2|
    //</editor-fold>//GEN-END:|45-action|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Descriptores ">//GEN-BEGIN:|60-getter|0|60-preInit
    /**
     * Returns an initiliazed instance of Descriptores component.
     * @return the initialized component instance
     */
    public List getDescriptores() {
        if (Descriptores == null) {//GEN-END:|60-getter|0|60-preInit
            // write pre-init user code here
            Descriptores = new List("Lista de Descriptores", Choice.IMPLICIT);//GEN-BEGIN:|60-getter|1|60-postInit
            Descriptores.addCommand(getIndentificar());
            Descriptores.addCommand(getBorrarDescriptor());
            Descriptores.addCommand(getAtras());
            Descriptores.addCommand(getAgregarDescriptor());
            Descriptores.setCommandListener(this);//GEN-END:|60-getter|1|60-postInit
            Descriptores.append((String)valor, null);
        }//GEN-BEGIN:|60-getter|2|
        return Descriptores;
    }
    //</editor-fold>//GEN-END:|60-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: DescriptoresAction ">//GEN-BEGIN:|60-action|0|60-preAction
    /**
     * Performs an action assigned to the selected list element in the Descriptores component.
     */
    public void DescriptoresAction() {//GEN-END:|60-action|0|60-preAction
        // enter pre-action user code here
        String __selectedString = getDescriptores().getString(getDescriptores().getSelectedIndex());//GEN-LINE:|60-action|1|60-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|60-action|2|
    //</editor-fold>//GEN-END:|60-action|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: borrarDescriptor ">//GEN-BEGIN:|75-getter|0|75-preInit
    /**
     * Returns an initiliazed instance of borrarDescriptor component.
     * @return the initialized component instance
     */
    public Command getBorrarDescriptor() {
        if (borrarDescriptor == null) {//GEN-END:|75-getter|0|75-preInit
            // write pre-init user code here
            borrarDescriptor = new Command("Borrar Descriptor", "<null>", Command.OK, 0);//GEN-LINE:|75-getter|1|75-postInit
            // write post-init user code here
        }//GEN-BEGIN:|75-getter|2|
        return borrarDescriptor;
    }
    //</editor-fold>//GEN-END:|75-getter|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: AgregarDescriptor ">//GEN-BEGIN:|89-getter|0|89-preInit
    /**
     * Returns an initiliazed instance of AgregarDescriptor component.
     * @return the initialized component instance
     */
    public Command getAgregarDescriptor() {
        if (AgregarDescriptor == null) {//GEN-END:|89-getter|0|89-preInit
            // write pre-init user code here
            AgregarDescriptor = new Command("Agregar Descriptor", Command.OK, 0);//GEN-LINE:|89-getter|1|89-postInit
            // write post-init user code here
        }//GEN-BEGIN:|89-getter|2|
        return AgregarDescriptor;
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
