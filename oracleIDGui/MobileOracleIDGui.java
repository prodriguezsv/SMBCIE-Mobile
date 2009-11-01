package oracleIDGui;

import app.MobileInterfaceAgent;
import jade.core.Agent;
import jade.core.MicroRuntime;
import javax.microedition.lcdui.*;


//import jade.util.leap.ArrayList;
//import jade.util.leap.List;



/**
 * @author pabloq
 */
public  class MobileOracleIDGui implements CommandListener {

//    private boolean midletPaused = false;
    private String structure;
    private String attribute;
    private String value;
    private MobileInterfaceAgent agent;
    

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Command OK;
    private Command exit;
    private Command backCommand;
    private Command identify;
    private Command addDescriptor;
    private TextBox valuesInput;
    private List descriptors;
    private List structures;
    private List attributes;
    private List valuesChoice;
    //</editor-fold>//GEN-END:|fields|0|

    /**
     * The MobileOracleIDGui constructor.
     */
    public MobileOracleIDGui(MobileInterfaceAgent aAgent) {
        agent = aAgent;
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
//GEN-LINE:|3-startMIDlet|1|3-postAction
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
                agent.getValues(((List)displayable).getSelectedIndex());
//GEN-LINE:|7-commandAction|2|37-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|3|130-preAction
                // write pre-action user code here
                switchDisplayable(null, getStructures());//GEN-LINE:|7-commandAction|4|130-postAction
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

                switchDisplayable(null, getStructures());

//GEN-LINE:|7-commandAction|10|90-postAction
                // write post-action user code here
            } else if (command == identify) {//GEN-LINE:|7-commandAction|11|65-preAction
                // write pre-action user code here

                agent.identifySpecimen();
                //testing
                //switchDisplayable(null, getStructures());

//GEN-LINE:|7-commandAction|12|65-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|13|16-preAction
        } else if (displayable == structures) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|13|16-preAction
                structure = ((List)displayable).getString(((List)displayable).getSelectedIndex());
                agent.getAttributes(((List)displayable).getSelectedIndex());
//GEN-LINE:|7-commandAction|14|16-postAction
                // write post-action user code here
            } else if (command == exit) {//GEN-LINE:|7-commandAction|15|31-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|16|31-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|17|46-preAction
        } else if (displayable == valuesChoice) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|17|46-preAction
                // write pre-action user code here
                value = ((List)displayable).getString(((List)displayable).getSelectedIndex());
                agent.addDescritorState(structure, attribute, value);


                switchDisplayable(null, getDescriptors());//GEN-LINE:|7-commandAction|18|46-postAction
                // write post-action user code here

                if (descriptors != null)
                    descriptors.append(structure+">"+attribute+">"+(String)value, null);

            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|19|132-preAction
                // write pre-action user code here
                switchDisplayable(null, getAttributes());//GEN-LINE:|7-commandAction|20|132-postAction
                // write post-action user code here
            } else if (command == exit) {//GEN-LINE:|7-commandAction|21|79-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|22|79-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|23|127-preAction
        } else if (displayable == valuesInput) {
            if (command == OK) {//GEN-END:|7-commandAction|23|127-preAction

                value = ((TextBox)displayable).getString();
                try {
                    agent.addDescritorValue(structure, attribute, Double.parseDouble(value));
                    switchDisplayable(null, getDescriptors());
                    if (descriptors != null)
                        descriptors.append(structure+">"+attribute+">"+(String)value, null);
                }catch (Exception e) {
                    switchDisplayable(null, getValuesInput());
                }


                // write pre-action user code here
//GEN-LINE:|7-commandAction|24|127-postAction
                // write post-action user code here
            } else if (command == exit) {//GEN-LINE:|7-commandAction|25|125-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|26|125-postAction
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

            structures = new List("Seleccion de Estructuras", Choice.IMPLICIT);//GEN-BEGIN:|14-getter|1|14-postInit
            structures.addCommand(getExit());
            structures.setCommandListener(this);
            structures.setFitPolicy(Choice.TEXT_WRAP_DEFAULT);//GEN-END:|14-getter|1|14-postInit
            // write post-init user code here
            jade.util.leap.List myStructures = agent.getStructuresList();
            if (myStructures!=null)
                for (int i=0;i<myStructures.size();i++)
                    structures.append((String)myStructures.get(i), null);

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


            attributes = new List("Seleccion de Atributos", Choice.IMPLICIT);//GEN-BEGIN:|36-getter|1|36-postInit
            attributes.addCommand(getExit());
            attributes.addCommand(getBackCommand());
            attributes.setCommandListener(this);//GEN-END:|36-getter|1|36-postInit
            // write post-init user code here
            jade.util.leap.List myAttributes = agent.getAttributesList();
            if (myAttributes!=null)
                for (int i=0;i<myAttributes.size();i++)
                    attributes.append((String)myAttributes.get(i), null);


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

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: valuesChoice ">//GEN-BEGIN:|45-getter|0|45-preInit
    /**
     * Returns an initiliazed instance of valuesChoice component.
     * @return the initialized component instance
     */
    public List getValuesChoice() {
        if (valuesChoice == null) {//GEN-END:|45-getter|0|45-preInit
            // write pre-init user code here


            valuesChoice = new List("Seleccion de Valores", Choice.IMPLICIT);//GEN-BEGIN:|45-getter|1|45-postInit
            valuesChoice.addCommand(getExit());
            valuesChoice.addCommand(getBackCommand());
            valuesChoice.setCommandListener(this);//GEN-END:|45-getter|1|45-postInit
            // write post-init user code here
            jade.util.leap.List myValues = agent.getValuesList();
            if (myValues!=null)
                for (int i=0;i<myValues.size();i++)
                    valuesChoice.append((String)myValues.get(i), null);
        }//GEN-BEGIN:|45-getter|2|
        return valuesChoice;
    }
    //</editor-fold>//GEN-END:|45-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: valuesChoiceAction ">//GEN-BEGIN:|45-action|0|45-preAction
    /**
     * Performs an action assigned to the selected list element in the valuesChoice component.
     */
    public void valuesChoiceAction() {//GEN-END:|45-action|0|45-preAction
        // enter pre-action user code here
        String __selectedString = getValuesChoice().getString(getValuesChoice().getSelectedIndex());//GEN-LINE:|45-action|1|45-postAction
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
            descriptors.addCommand(getAddDescriptor());
            descriptors.addCommand(getIdentify());
            descriptors.setCommandListener(this);//GEN-END:|60-getter|1|60-postInit

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


    

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: OK ">//GEN-BEGIN:|126-getter|0|126-preInit
    /**
     * Returns an initiliazed instance of OK component.
     * @return the initialized component instance
     */
    public Command getOK() {
        if (OK == null) {//GEN-END:|126-getter|0|126-preInit
        // write pre-init user code here
            OK = new Command("Ok", Command.OK, 0);//GEN-LINE:|126-getter|1|126-postInit
        // write post-init user code here
        }//GEN-BEGIN:|126-getter|2|
        return OK;
    }
    //</editor-fold>//GEN-END:|126-getter|2|





    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: valuesInput ">//GEN-BEGIN:|123-getter|0|123-preInit
    /**
     * Returns an initiliazed instance of valuesInput component.
     * @return the initialized component instance
     */
    public TextBox getValuesInput() {
        if (valuesInput == null) {//GEN-END:|123-getter|0|123-preInit
        // write pre-init user code here
            valuesInput = new TextBox("Inserte Valor para el Atributo", "", 100, TextField.NUMERIC);//GEN-BEGIN:|123-getter|1|123-postInit
            valuesInput.addCommand(getOK());
            valuesInput.addCommand(getExit());
            valuesInput.setCommandListener(this);//GEN-END:|123-getter|1|123-postInit
        // write post-init user code here
        }//GEN-BEGIN:|123-getter|2|
        return valuesInput;
    }
    //</editor-fold>//GEN-END:|123-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand ">//GEN-BEGIN:|129-getter|0|129-preInit
    /**
     * Returns an initiliazed instance of backCommand component.
     * @return the initialized component instance
     */
    public Command getBackCommand() {
        if (backCommand == null) {//GEN-END:|129-getter|0|129-preInit
            // write pre-init user code here
            backCommand = new Command("Back", Command.BACK, 0);//GEN-LINE:|129-getter|1|129-postInit
            // write post-init user code here
        }//GEN-BEGIN:|129-getter|2|
        return backCommand;
    }
    //</editor-fold>//GEN-END:|129-getter|2|

    
/**
//     * Returns a display instance.
//     * @return the display instance.
//     */
    public Display getDisplay () {
        return Display.getDisplay(Agent.midlet);
    }

//    /**
//     * Exits MIDlet.
//     */
    public void exitMIDlet() {
        switchDisplayable (null, null);
        Agent.midlet.notifyDestroyed();
        MicroRuntime.stopJADE();
    }

//
//    /**
//     * Called when MIDlet is paused.
//     */
//    public void pauseApp() {
//        midletPaused = true;
//    }

}
