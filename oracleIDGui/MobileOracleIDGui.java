package oracleIDGui;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import org.netbeans.microedition.databinding.DataBinder;
import org.netbeans.microedition.databinding.DataSet;
import org.netbeans.microedition.lcdui.TableItem;
import app.MobileInterfaceAgent;

/**
 * @author pabloq
 */
public class MobileOracleIDGui extends MIDlet implements CommandListener {

    private boolean midletPaused = false;
    private String structure;
    private String attribute;
    private Object value;
    private MobileInterfaceAgent myAgent;

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private DataSet dataSet;
    private Command exit;
    private Command identify;
    private Command back;
    private Command removeDescriptor;
    private Command addDescriptor;
    private List descriptors;
    private List structures;
    private List attributes;
    private List values;
    private Form identificationResults;
    private TableItem tableItem;
    private TextField textField;
    private Alert alert;
    //</editor-fold>//GEN-END:|fields|0|

    /**
     * The MobileOracleIDGui constructor.
     */
    public MobileOracleIDGui(MobileInterfaceAgent agent) {
        myAgent = agent;
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
        back = new Command("Atras", Command.BACK, 0);//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
    //</editor-fold>//GEN-END:|0-initialize|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
        switchDisplayable(null, getStructures());//GEN-LINE:|3-startMIDlet|1|3-postAction
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
        if (displayable == attributes) {//GEN-BEGIN:|7-commandAction|1|37-preAction
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|1|37-preAction
                attribute = ((List)displayable).getString(((List)displayable).getSelectedIndex());
                value = null;
                // write pre-action user code here
                switchDisplayable(null, getValues());//GEN-LINE:|7-commandAction|2|37-postAction
                // write post-action user code here
            } else if (command == back) {//GEN-LINE:|7-commandAction|3|41-preAction

                structure = null;
                structures = null;
                // write pre-action user code here
                switchDisplayable(null, getStructures());//GEN-LINE:|7-commandAction|4|41-postAction
                // write post-action user code here
            } else if (command == exit) {//GEN-LINE:|7-commandAction|5|77-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|6|77-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|7|61-preAction
        } else if (displayable == descriptors) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|7|61-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|8|61-postAction
                // write post-action user code here
            } else if (command == addDescriptor) {//GEN-LINE:|7-commandAction|9|90-preAction
                // write pre-action user code here

                structure = null;
                structures = null;
                attribute = null;
                attributes = null;
                value = null;
                values = null;

                switchDisplayable(null, getStructures());//GEN-LINE:|7-commandAction|10|90-postAction
                // write post-action user code here
            } else if (command == back) {//GEN-LINE:|7-commandAction|11|84-preAction
                value = null;
                values = null;
                switchDisplayable(null, getValues());//GEN-LINE:|7-commandAction|12|84-postAction
                // write post-action user code here
            } else if (command == identify) {//GEN-LINE:|7-commandAction|13|65-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|14|65-postAction
                // write post-action user code here
            } else if (command == removeDescriptor) {//GEN-LINE:|7-commandAction|15|100-preAction
                // write pre-action user code here

                int idx = ((List)displayable).getSelectedIndex();
                if (idx>=0){
                  descriptors.delete(idx);
                }

//GEN-LINE:|7-commandAction|16|100-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|17|16-preAction
        } else if (displayable == structures) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|17|16-preAction
                // write pre-action user code here
                structure = ((List)displayable).getString(((List)displayable).getSelectedIndex());
                attribute = null;
                value = null;
                switchDisplayable(null, getAttributes());//GEN-LINE:|7-commandAction|18|16-postAction
                // write post-action user code here
            } else if (command == exit) {//GEN-LINE:|7-commandAction|19|31-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|20|31-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|21|46-preAction
        } else if (displayable == values) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|21|46-preAction
                // write pre-action user code here
                value = ((List)displayable).getString(((List)displayable).getSelectedIndex());
                if (descriptors != null)
                    descriptors.append((String)value, null);

                switchDisplayable(null, getDescriptors());//GEN-LINE:|7-commandAction|22|46-postAction
                // write post-action user code here
            } else if (command == back) {//GEN-LINE:|7-commandAction|23|82-preAction
                // write pre-action user code here
                attribute = null;
                attributes = null;

                switchDisplayable(null, getAttributes());//GEN-LINE:|7-commandAction|24|82-postAction
                // write post-action user code here
            } else if (command == exit) {//GEN-LINE:|7-commandAction|25|79-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|26|79-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|27|7-postCommandAction
        }//GEN-END:|7-commandAction|27|7-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|28|
    //</editor-fold>//GEN-END:|7-commandAction|28|
    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: structures ">//GEN-BEGIN:|14-getter|0|14-preInit
    /**
     * Returns an initiliazed instance of structures component.
     * @return the initialized component instance
     */
    public List getStructures() {
        if (structures == null) {//GEN-END:|14-getter|0|14-preInit
            // write pre-init user code here
            String[] values = {"E1","E2","E3","E4"};
            structures = new List("Seleccion de Estructuras", Choice.IMPLICIT);//GEN-BEGIN:|14-getter|1|14-postInit
            structures.addCommand(getExit());
            structures.setCommandListener(this);
            structures.setFitPolicy(Choice.TEXT_WRAP_DEFAULT);//GEN-END:|14-getter|1|14-postInit
            // write post-init user code here
            for (int i = 0; i<values.length;i++){
                structures.append(values[i], null);
            }
            structures.setSelectedIndex(0, false);
        }//GEN-BEGIN:|14-getter|2|
        return structures;
    }
    //</editor-fold>//GEN-END:|14-getter|2|
    //<editor-fold defaultstate="collapsed" desc=" Generated Method: structuresAction ">//GEN-BEGIN:|14-action|0|14-preAction
    /**
     * Performs an action assigned to the selected list element in the structures component.
     */
    public void structuresAction() {//GEN-END:|14-action|0|14-preAction
        // enter pre-action user code here
//GEN-LINE:|14-action|1|14-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|14-action|2|
    //</editor-fold>//GEN-END:|14-action|2|
    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exit ">//GEN-BEGIN:|30-getter|0|30-preInit
    /**
     * Returns an initiliazed instance of exit component.
     * @return the initialized component instance
     */
    public Command getExit() {
        if (exit == null) {//GEN-END:|30-getter|0|30-preInit
            // write pre-init user code here
            exit = new Command("Salir", Command.EXIT, 0);//GEN-LINE:|30-getter|1|30-postInit
            // write post-init user code here
        }//GEN-BEGIN:|30-getter|2|
        return exit;
    }
    //</editor-fold>//GEN-END:|30-getter|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: identify ">//GEN-BEGIN:|64-getter|0|64-preInit
    /**
     * Returns an initiliazed instance of identify component.
     * @return the initialized component instance
     */
    public Command getIdentify() {
        if (identify == null) {//GEN-END:|64-getter|0|64-preInit
            // write pre-init user code here
            identify = new Command("Identificar", Command.OK, 0);//GEN-LINE:|64-getter|1|64-postInit
            // write post-init user code here
        }//GEN-BEGIN:|64-getter|2|
        return identify;
    }
    //</editor-fold>//GEN-END:|64-getter|2|
    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: attributes ">//GEN-BEGIN:|36-getter|0|36-preInit
    /**
     * Returns an initiliazed instance of attributes component.
     * @return the initialized component instance
     */
    public List getAttributes() {
        if (attributes == null) {//GEN-END:|36-getter|0|36-preInit
            // write pre-init user code here


            String[] values = {"A1","A2","A3","A4"};

            attributes = new List("Seleccion de Atributos", Choice.IMPLICIT);//GEN-BEGIN:|36-getter|1|36-postInit
            attributes.addCommand(back);
            attributes.addCommand(getExit());
            attributes.setCommandListener(this);//GEN-END:|36-getter|1|36-postInit
            // write post-init user code here
            for (int i = 0; i<values.length;i++){
                attributes.append(structure +">"+ values[i], null);
            }

        }//GEN-BEGIN:|36-getter|2|
        return attributes;
    }
    //</editor-fold>//GEN-END:|36-getter|2|
    //<editor-fold defaultstate="collapsed" desc=" Generated Method: attributesAction ">//GEN-BEGIN:|36-action|0|36-preAction
    /**
     * Performs an action assigned to the selected list element in the attributes component.
     */
    public void attributesAction() {//GEN-END:|36-action|0|36-preAction
        // enter pre-action user code here
        String __selectedString = getAttributes().getString(getAttributes().getSelectedIndex());//GEN-LINE:|36-action|1|36-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|36-action|2|
    //</editor-fold>//GEN-END:|36-action|2|
    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: values ">//GEN-BEGIN:|45-getter|0|45-preInit
    /**
     * Returns an initiliazed instance of values component.
     * @return the initialized component instance
     */
    public List getValues() {
        if (values == null) {//GEN-END:|45-getter|0|45-preInit
            // write pre-init user code here

            String[] myvalues = {"V1","V2","V3","V4"};
            values = new List("Seleccion de Valores", Choice.IMPLICIT);//GEN-BEGIN:|45-getter|1|45-postInit
            values.addCommand(back);
            values.addCommand(getExit());
            values.setCommandListener(this);//GEN-END:|45-getter|1|45-postInit
            // write post-init user code here

            for (int i = 0; i<myvalues.length;i++){
                values.append(attribute +">"+ myvalues[i], null);
            }



        }//GEN-BEGIN:|45-getter|2|
        return values;
    }
    //</editor-fold>//GEN-END:|45-getter|2|
    //<editor-fold defaultstate="collapsed" desc=" Generated Method: valuesAction ">//GEN-BEGIN:|45-action|0|45-preAction
    /**
     * Performs an action assigned to the selected list element in the values component.
     */
    public void valuesAction() {//GEN-END:|45-action|0|45-preAction
        // enter pre-action user code here
        String __selectedString = getValues().getString(getValues().getSelectedIndex());//GEN-LINE:|45-action|1|45-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|45-action|2|
    //</editor-fold>//GEN-END:|45-action|2|
    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: descriptors ">//GEN-BEGIN:|60-getter|0|60-preInit
    /**
     * Returns an initiliazed instance of descriptors component.
     * @return the initialized component instance
     */
    public List getDescriptors() {
        if (descriptors == null) {//GEN-END:|60-getter|0|60-preInit
            // write pre-init user code here
            descriptors = new List("Lista de Descriptores", Choice.IMPLICIT);//GEN-BEGIN:|60-getter|1|60-postInit
            descriptors.addCommand(back);
            descriptors.addCommand(getAddDescriptor());
            descriptors.addCommand(getRemoveDescriptor());
            descriptors.addCommand(getIdentify());
            descriptors.setCommandListener(this);//GEN-END:|60-getter|1|60-postInit

                if (value != null)
                    descriptors.append((String)value, null);

        }//GEN-BEGIN:|60-getter|2|
        return descriptors;
    }
    //</editor-fold>//GEN-END:|60-getter|2|
    //<editor-fold defaultstate="collapsed" desc=" Generated Method: descriptorsAction ">//GEN-BEGIN:|60-action|0|60-preAction
    /**
     * Performs an action assigned to the selected list element in the descriptors component.
     */
    public void descriptorsAction() {//GEN-END:|60-action|0|60-preAction
        // enter pre-action user code here
        String __selectedString = getDescriptors().getString(getDescriptors().getSelectedIndex());//GEN-LINE:|60-action|1|60-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|60-action|2|
    //</editor-fold>//GEN-END:|60-action|2|
    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: addDescriptor ">//GEN-BEGIN:|89-getter|0|89-preInit
    /**
     * Returns an initiliazed instance of addDescriptor component.
     * @return the initialized component instance
     */
    public Command getAddDescriptor() {
        if (addDescriptor == null) {//GEN-END:|89-getter|0|89-preInit
            // write pre-init user code here
            addDescriptor = new Command("Agregar Descriptor", Command.OK, 0);//GEN-LINE:|89-getter|1|89-postInit
            // write post-init user code here
        }//GEN-BEGIN:|89-getter|2|
        return addDescriptor;
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
        }//GEN-BEGIN:|94-getter|2|
        return dataSet;
    }
    private class DataSet_ implements DataSet {//GEN-END:|94-getter|2|
        // declaration field//GEN-LINE:|94-getter|7|

        public Class getType(String name) throws IllegalStateException {

            throw new IllegalStateException("Not implemented yet.");
        }

        public Object getValue(String name) throws IllegalStateException {

            throw new IllegalStateException("Not implemented yet.");
        }

        public void setValue(String name, Object value) throws IllegalStateException {
            //TODO
            DataBinder.fireDataSetChanged(this , name);
        }

        public void setAsString(String name, String stringValue) throws IllegalStateException {
            //TODO
            DataBinder.fireDataSetChanged(this , name);
        }

        public boolean isReadOnly(String readOnly) throws IllegalStateException {

            throw new IllegalStateException("Not implemented yet.");
        }

    };
    //</editor-fold>//GEN-LINE:|94-getter|6|94codeZone5





    //</editor-fold>
















    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: removeDescriptor ">//GEN-BEGIN:|99-getter|0|99-preInit
    /**
     * Returns an initiliazed instance of removeDescriptor component.
     * @return the initialized component instance
     */
    public Command getRemoveDescriptor() {
        if (removeDescriptor == null) {//GEN-END:|99-getter|0|99-preInit
            // write pre-init user code here
            removeDescriptor = new Command("Eliminar Descriptor", Command.OK, 0);//GEN-LINE:|99-getter|1|99-postInit
            // write post-init user code here
        }//GEN-BEGIN:|99-getter|2|
        return removeDescriptor;
    }
    //</editor-fold>//GEN-END:|99-getter|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: identificationResults ">//GEN-BEGIN:|101-getter|0|101-preInit
    /**
     * Returns an initiliazed instance of identificationResults component.
     * @return the initialized component instance
     */
    public Form getIdentificationResults() {
        if (identificationResults == null) {//GEN-END:|101-getter|0|101-preInit
            // write pre-init user code here
            identificationResults = new Form("form", new Item[] { getTableItem(), getTextField() });//GEN-LINE:|101-getter|1|101-postInit
            // write post-init user code here
        }//GEN-BEGIN:|101-getter|2|
        return identificationResults;
    }
    //</editor-fold>//GEN-END:|101-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tableItem ">//GEN-BEGIN:|102-getter|0|102-preInit
    /**
     * Returns an initiliazed instance of tableItem component.
     * @return the initialized component instance
     */
    public TableItem getTableItem() {
        if (tableItem == null) {//GEN-END:|102-getter|0|102-preInit
            // write pre-init user code here
            tableItem = new TableItem(getDisplay(), "tableItem");//GEN-LINE:|102-getter|1|102-postInit
            // write post-init user code here
        }//GEN-BEGIN:|102-getter|2|
        return tableItem;
    }
    //</editor-fold>//GEN-END:|102-getter|2|
    //</editor-fold>
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField ">//GEN-BEGIN:|103-getter|0|103-preInit
    /**
     * Returns an initiliazed instance of textField component.
     * @return the initialized component instance
     */
    public TextField getTextField() {
        if (textField == null) {//GEN-END:|103-getter|0|103-preInit
            // write pre-init user code here
            textField = new TextField("textField", null, 32, TextField.ANY);//GEN-LINE:|103-getter|1|103-postInit
            // write post-init user code here
        }//GEN-BEGIN:|103-getter|2|
        return textField;
    }
    //</editor-fold>//GEN-END:|103-getter|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: alert ">//GEN-BEGIN:|104-getter|0|104-preInit
    /**
     * Returns an initiliazed instance of alert component.
     * @return the initialized component instance
     */
    public Alert getAlert() {
        if (alert == null) {//GEN-END:|104-getter|0|104-preInit
            // write pre-init user code here
            alert = new Alert("alert");//GEN-BEGIN:|104-getter|1|104-postInit
            alert.setTimeout(Alert.FOREVER);//GEN-END:|104-getter|1|104-postInit
            // write post-init user code here
        }//GEN-BEGIN:|104-getter|2|
        return alert;
    }
    //</editor-fold>//GEN-END:|104-getter|2|

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
