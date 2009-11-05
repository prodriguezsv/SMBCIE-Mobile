package oracleIDGui;

import app.MobileInterfaceAgent;
import jade.core.Agent;
import jade.core.MicroRuntime;
import javax.microedition.lcdui.*;
import ontology.CBR.ProposedSolution;

/**
 * @author pabloq
 */
public  class MobileOracleIDGui implements CommandListener {

    private String structure;
    private String attribute;
    private String value;
    private MobileInterfaceAgent agent;
    private int identificationIndex;
    

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Command exit;
    private Command next;
    private Command backCommand;
    private Command identify;
    private Command OK;
    private Command delDescriptor;
    private Command addDescriptor;
    private Command begin;
    private Command newProblem;
    private Alert alertWelcome;
    private TextBox valuesInput;
    private List descriptors;
    private List structures;
    private Form identificationResults;
    private StringItem identificationState;
    private StringItem cientificName;
    private StringItem taxonomicRank;
    private StringItem certaintyDegree;
    private Spacer spacer;
    private List attributes;
    private Alert alertIdentification;
    private List valuesChoice;
    //</editor-fold>//GEN-END:|fields|0|

    /**
     * The MobileOracleIDGui constructor.
     */
    public MobileOracleIDGui(MobileInterfaceAgent aAgent) {
        agent = aAgent;
    }
    
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
                valuesChoice = null;
                valuesInput = null;
                agent.getValues(((List)displayable).getSelectedIndex());
//GEN-LINE:|7-commandAction|2|37-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|3|130-preAction
                // write pre-action user code here
                switchDisplayable(null, getStructures());//GEN-LINE:|7-commandAction|4|130-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|5|61-preAction
        } else if (displayable == descriptors) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|5|61-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|6|61-postAction
                // write post-action user code here
            } else if (command == addDescriptor) {//GEN-LINE:|7-commandAction|7|90-preAction
                // write pre-action user code here

                structure = null;
                structures = null;
                attribute = null;
                attributes = null;
                value = null;
                valuesChoice = null;
                valuesInput = null;

                identificationResults = null;

                switchDisplayable(null, getStructures());

//GEN-LINE:|7-commandAction|8|90-postAction
                // write post-action user code here
            } else if (command == delDescriptor) {//GEN-LINE:|7-commandAction|9|150-preAction
                // write pre-action user code here
                int idx = ((List)displayable).getSelectedIndex();
                if (idx>=0)
                    deleteDescriptorAt(idx);

//GEN-LINE:|7-commandAction|10|150-postAction
                // write post-action user code here
            } else if (command == exit) {//GEN-LINE:|7-commandAction|11|152-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|12|152-postAction
                // write post-action user code here
            } else if (command == identify) {//GEN-LINE:|7-commandAction|13|65-preAction
                // write pre-action user code here

                agent.identifySpecimen();

//GEN-LINE:|7-commandAction|14|65-postAction
                // write post-action user code here
            } else if (command == newProblem) {//GEN-LINE:|7-commandAction|15|165-preAction
                // write pre-action user code here
                resetIdentification();
//GEN-LINE:|7-commandAction|16|165-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|17|162-preAction
        } else if (displayable == identificationResults) {
            if (command == begin) {//GEN-END:|7-commandAction|17|162-preAction
                // write pre-action user code here
                switchDisplayable(null, getDescriptors());//GEN-LINE:|7-commandAction|18|162-postAction
                // write post-action user code here
            } else if (command == next) {//GEN-LINE:|7-commandAction|19|144-preAction
                // write pre-action user code here

            if (agent.getProposedSolutions().size()>0){
                    identificationIndex = (identificationIndex+1)%agent.getProposedSolutions().size();
                    ProposedSolution aProposedSolution = (ProposedSolution)agent.getProposedSolutions().get(identificationIndex);
                    cientificName.setText(aProposedSolution.getSolution().getName());
                    taxonomicRank.setText(aProposedSolution.getSolution().getLevel());
                    certaintyDegree.setText(aProposedSolution.getCertaintyDegree());
                    String state = "Exitoso";
                    if (!aProposedSolution.getState())
                        state = "Fallido";
                    identificationState.setText(state);
            }

//GEN-LINE:|7-commandAction|20|144-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|21|16-preAction
        } else if (displayable == structures) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|21|16-preAction
                structure = ((List)displayable).getString(((List)displayable).getSelectedIndex());
                attribute = null;
                attributes = null;
                agent.getAttributes(((List)displayable).getSelectedIndex());
//GEN-LINE:|7-commandAction|22|16-postAction
                // write post-action user code here
            } else if (command == exit) {//GEN-LINE:|7-commandAction|23|31-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|24|31-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|25|46-preAction
        } else if (displayable == valuesChoice) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|25|46-preAction
                // write pre-action user code here
                value = ((List)displayable).getString(((List)displayable).getSelectedIndex());
                agent.addDescritorState(structure, attribute, value);


                switchDisplayable(null, getDescriptors());//GEN-LINE:|7-commandAction|26|46-postAction
                // write post-action user code here

                if (descriptors != null)
                    descriptors.append("("+structure+";"+attribute+";"+(String)value+")", null);

            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|27|132-preAction
                // write pre-action user code here
                switchDisplayable(null, getAttributes());//GEN-LINE:|7-commandAction|28|132-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|29|127-preAction
        } else if (displayable == valuesInput) {
            if (command == OK) {//GEN-END:|7-commandAction|29|127-preAction

                value = ((TextBox)displayable).getString();
                try {
                	Integer.parseInt(value);
                    agent.addDescritorValue(structure, attribute, value);
                    switchDisplayable(null, getDescriptors());
                    if (descriptors != null)
                        descriptors.append("("+structure+";"+attribute+";"+(String)value+")", null);
                }catch (Exception e) {
                    switchDisplayable(null, getValuesInput());
                }


                // write pre-action user code here
//GEN-LINE:|7-commandAction|30|127-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|31|155-preAction
                // write pre-action user code here
                switchDisplayable(null, getAttributes());//GEN-LINE:|7-commandAction|32|155-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|33|7-postCommandAction
        }//GEN-END:|7-commandAction|33|7-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|34|
    //</editor-fold>//GEN-END:|7-commandAction|34|





    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: structures ">//GEN-BEGIN:|14-getter|0|14-preInit
    /**
     * Returns an initiliazed instance of structures component.
     * @return the initialized component instance
     */
    public List getStructures() {
        if (structures == null) {//GEN-END:|14-getter|0|14-preInit
            // write pre-init user code here

            structures = new List("Selecci\u00F3n de estructura", Choice.IMPLICIT);//GEN-BEGIN:|14-getter|1|14-postInit
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


            attributes = new List("Selecci\u00F3n de atributo", Choice.IMPLICIT);//GEN-BEGIN:|36-getter|1|36-postInit
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

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: valuesChoice ">//GEN-BEGIN:|45-getter|0|45-preInit
    /**
     * Returns an initiliazed instance of valuesChoice component.
     * @return the initialized component instance
     */
    public List getValuesChoice() {
        if (valuesChoice == null) {//GEN-END:|45-getter|0|45-preInit
            // write pre-init user code here
            valuesChoice = new List("Selecci\u00F3n de valor", Choice.IMPLICIT);//GEN-BEGIN:|45-getter|1|45-postInit
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

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: descriptors ">//GEN-BEGIN:|60-getter|0|60-preInit
    /**
     * Returns an initiliazed instance of descriptors component.
     * @return the initialized component instance
     */
    public List getDescriptors() {
        if (descriptors == null) {//GEN-END:|60-getter|0|60-preInit
            // write pre-init user code here
            descriptors = new List("Descripci\u00F3n del problema", Choice.IMPLICIT);//GEN-BEGIN:|60-getter|1|60-postInit
            descriptors.addCommand(getAddDescriptor());
            descriptors.addCommand(getDelDescriptor());
            descriptors.addCommand(getIdentify());
            descriptors.addCommand(getNewProblem());
            descriptors.addCommand(getExit());
            descriptors.setCommandListener(this);
            descriptors.setFitPolicy(Choice.TEXT_WRAP_DEFAULT);//GEN-END:|60-getter|1|60-postInit

        }//GEN-BEGIN:|60-getter|2|
        return descriptors;
    }
    //</editor-fold>//GEN-END:|60-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: addDescriptor ">//GEN-BEGIN:|89-getter|0|89-preInit
    /**
     * Returns an initiliazed instance of addDescriptor component.
     * @return the initialized component instance
     */
    public Command getAddDescriptor() {
        if (addDescriptor == null) {//GEN-END:|89-getter|0|89-preInit
            // write pre-init user code here
            addDescriptor = new Command("Agregar descriptor", Command.OK, 0);//GEN-LINE:|89-getter|1|89-postInit
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
            OK = new Command("Aceptar", Command.OK, 0);//GEN-LINE:|126-getter|1|126-postInit
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
            valuesInput = new TextBox("Inserte valor para el atributo", "", 100, TextField.NUMERIC);//GEN-BEGIN:|123-getter|1|123-postInit
            valuesInput.addCommand(getOK());
            valuesInput.addCommand(getBackCommand());
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
            backCommand = new Command("Atr\u00E1s", Command.BACK, 0);//GEN-LINE:|129-getter|1|129-postInit
            // write post-init user code here
        }//GEN-BEGIN:|129-getter|2|
        return backCommand;
    }
    //</editor-fold>//GEN-END:|129-getter|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: identificationResults ">//GEN-BEGIN:|135-getter|0|135-preInit
    /**
     * Returns an initiliazed instance of identificationResults component.
     * @return the initialized component instance
     */
    public Form getIdentificationResults() {
        if (identificationResults == null) {//GEN-END:|135-getter|0|135-preInit
            // write pre-init user code here
            identificationResults = new Form("Soluciones propuestas", new Item[] { getCientificName(), getTaxonomicRank(), getSpacer(), getCertaintyDegree(), getIdentificationState() });//GEN-BEGIN:|135-getter|1|135-postInit
            identificationResults.addCommand(getNext());
            identificationResults.addCommand(getBegin());
            identificationResults.setCommandListener(this);//GEN-END:|135-getter|1|135-postInit
            // write post-init user code here
            identificationIndex = 0;
            if ((agent.getProposedSolutions().size()>0)
            		&&(agent.getProposedSolutions().get(identificationIndex) != null)){
                    ProposedSolution aProposedSolution = (ProposedSolution)agent.getProposedSolutions().get(identificationIndex);
                    cientificName.setText(aProposedSolution.getSolution().getName());
                    taxonomicRank.setText(aProposedSolution.getSolution().getLevel());
                    certaintyDegree.setText(aProposedSolution.getCertaintyDegree());
                    String state = "Exitoso";
                    if (!aProposedSolution.getState())
                        state = "Fallido";
                    identificationState.setText(state);
            }


        }//GEN-BEGIN:|135-getter|2|
        return identificationResults;
    }
    //</editor-fold>//GEN-END:|135-getter|2|
    //</editor-fold>
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: cientificName ">//GEN-BEGIN:|136-getter|0|136-preInit
    /**
     * Returns an initiliazed instance of cientificName component.
     * @return the initialized component instance
     */
    public StringItem getCientificName() {
        if (cientificName == null) {//GEN-END:|136-getter|0|136-preInit
            // write pre-init user code here
            cientificName = new StringItem("Nombre cient\u00EDfico:", null);//GEN-LINE:|136-getter|1|136-postInit
            // write post-init user code here
        }//GEN-BEGIN:|136-getter|2|
        return cientificName;
    }
    //</editor-fold>//GEN-END:|136-getter|2|
    //</editor-fold>
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: taxonomicRank ">//GEN-BEGIN:|137-getter|0|137-preInit
    /**
     * Returns an initiliazed instance of taxonomicRank component.
     * @return the initialized component instance
     */
    public StringItem getTaxonomicRank() {
        if (taxonomicRank == null) {//GEN-END:|137-getter|0|137-preInit
            // write pre-init user code here
            taxonomicRank = new StringItem("Rango taxon\u00F3mico:", null);//GEN-LINE:|137-getter|1|137-postInit
            // write post-init user code here
        }//GEN-BEGIN:|137-getter|2|
        return taxonomicRank;
    }
    //</editor-fold>//GEN-END:|137-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: spacer ">//GEN-BEGIN:|138-getter|0|138-preInit
    /**
     * Returns an initiliazed instance of spacer component.
     * @return the initialized component instance
     */
    public Spacer getSpacer() {
        if (spacer == null) {//GEN-END:|138-getter|0|138-preInit
            // write pre-init user code here
            spacer = new Spacer(16, 2);//GEN-LINE:|138-getter|1|138-postInit
            // write post-init user code here
        }//GEN-BEGIN:|138-getter|2|
        return spacer;
    }
    //</editor-fold>//GEN-END:|138-getter|2|
    //</editor-fold>
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: certaintyDegree ">//GEN-BEGIN:|139-getter|0|139-preInit
    /**
     * Returns an initiliazed instance of certaintyDegree component.
     * @return the initialized component instance
     */
    public StringItem getCertaintyDegree() {
        if (certaintyDegree == null) {//GEN-END:|139-getter|0|139-preInit
            // write pre-init user code here
            certaintyDegree = new StringItem("Grado de certeza:", null);//GEN-LINE:|139-getter|1|139-postInit
            // write post-init user code here
        }//GEN-BEGIN:|139-getter|2|
        return certaintyDegree;
    }
    //</editor-fold>//GEN-END:|139-getter|2|
    //</editor-fold>
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: identificationState ">//GEN-BEGIN:|140-getter|0|140-preInit
    /**
     * Returns an initiliazed instance of identificationState component.
     * @return the initialized component instance
     */
    public StringItem getIdentificationState() {
        if (identificationState == null) {//GEN-END:|140-getter|0|140-preInit
            // write pre-init user code here
            identificationState = new StringItem("Estado:", null);//GEN-LINE:|140-getter|1|140-postInit
            // write post-init user code here
        }//GEN-BEGIN:|140-getter|2|
        return identificationState;
    }
    //</editor-fold>//GEN-END:|140-getter|2|
    //</editor-fold>
    //</editor-fold>


    //</editor-fold>
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: next ">//GEN-BEGIN:|143-getter|0|143-preInit
    /**
     * Returns an initiliazed instance of next component.
     * @return the initialized component instance
     */
    public Command getNext() {
        if (next == null) {//GEN-END:|143-getter|0|143-preInit
            // write pre-init user code here
            next = new Command("Siguiente", Command.BACK, 0);//GEN-LINE:|143-getter|1|143-postInit
            // write post-init user code here
        }//GEN-BEGIN:|143-getter|2|
        return next;
    }
    //</editor-fold>//GEN-END:|143-getter|2|
    //</editor-fold>
    //</editor-fold>


    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: delDescriptor ">//GEN-BEGIN:|149-getter|0|149-preInit
    /**
     * Returns an initiliazed instance of delDescriptor component.
     * @return the initialized component instance
     */
    public Command getDelDescriptor() {
        if (delDescriptor == null) {//GEN-END:|149-getter|0|149-preInit
            // write pre-init user code here
            delDescriptor = new Command("Borrar descriptor", Command.OK, 0);//GEN-LINE:|149-getter|1|149-postInit
            // write post-init user code here
        }//GEN-BEGIN:|149-getter|2|
        return delDescriptor;
    }
    //</editor-fold>//GEN-END:|149-getter|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: alertIdentification ">//GEN-BEGIN:|154-getter|0|154-preInit
    /**
     * Returns an initiliazed instance of alertIdentification component.
     * @return the initialized component instance
     */
    public Alert getAlertIdentification() {
        if (alertIdentification == null) {//GEN-END:|154-getter|0|154-preInit
            // write pre-init user code here
            alertIdentification = new Alert("Identificaci\u00F3n fallida", null, null, AlertType.WARNING);//GEN-BEGIN:|154-getter|1|154-postInit
            alertIdentification.setTimeout(3000);//GEN-END:|154-getter|1|154-postInit
            // write post-init user code here
            alertIdentification.setString("No se encontró ningún resultado de identificación, intente especificar más la descripción.");
        }//GEN-BEGIN:|154-getter|2|
        return alertIdentification;
    }
    //</editor-fold>//GEN-END:|154-getter|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: alertWelcome ">//GEN-BEGIN:|158-getter|0|158-preInit
    /**
     * Returns an initiliazed instance of alertWelcome component.
     * @return the initialized component instance
     */
    public Alert getAlertWelcome() {
        if (alertWelcome == null) {//GEN-END:|158-getter|0|158-preInit
            // write pre-init user code here
            alertWelcome = new Alert("Bienvenidos!", null, null, AlertType.INFO);//GEN-BEGIN:|158-getter|1|158-postInit
            alertWelcome.setTimeout(3000);//GEN-END:|158-getter|1|158-postInit
            // write post-init user code here

            alertWelcome.setString("Bienvenidos al sistema OracleID en su version móvil.\n Con este sistema podrá identificar especímenes desde su celular!");
        }//GEN-BEGIN:|158-getter|2|
        return alertWelcome;
    }
    //</editor-fold>//GEN-END:|158-getter|2|

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
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: begin ">//GEN-BEGIN:|161-getter|0|161-preInit
    /**
     * Returns an initiliazed instance of begin component.
     * @return the initialized component instance
     */
    public Command getBegin() {
        if (begin == null) {//GEN-END:|161-getter|0|161-preInit
            // write pre-init user code here
            begin = new Command("Iniciar", Command.OK, 0);//GEN-LINE:|161-getter|1|161-postInit
            // write post-init user code here
        }//GEN-BEGIN:|161-getter|2|
        return begin;
    }
    //</editor-fold>//GEN-END:|161-getter|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: newProblem ">//GEN-BEGIN:|164-getter|0|164-preInit
    /**
     * Returns an initiliazed instance of newProblem component.
     * @return the initialized component instance
     */
    public Command getNewProblem() {
        if (newProblem == null) {//GEN-END:|164-getter|0|164-preInit
            // write pre-init user code here
            newProblem = new Command("Nuevo Problema", Command.OK, 0);//GEN-LINE:|164-getter|1|164-postInit
            // write post-init user code here
        }//GEN-BEGIN:|164-getter|2|
        return newProblem;
    }
    //</editor-fold>//GEN-END:|164-getter|2|

    public void resetIdentification(){
    structure = null;
    attribute = null;
    value = null;
    identificationIndex = 0;
    structures = null;
    attributes = null;
    valuesChoice = null;
    valuesInput = null;
    descriptors = null;
    if (identificationResults!=null)
        identificationResults.deleteAll();
    identificationResults = null;
    agent.resetIdentification();
    }
    public void deleteDescriptorAt(int idx){
    agent.deleteDescriptorAt(idx);
    descriptors.delete(idx);
    }

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
}
