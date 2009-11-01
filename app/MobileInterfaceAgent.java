/*****************************************************************
JADE - Java Agent DEvelopment Framework is a framework to develop
multi-agent systems in compliance with the FIPA specifications.
Copyright (C) 2000 CSELT S.p.A.

GNU Lesser General Public License

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation,
version 2.1 of the License.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the
Free Software Foundation, Inc., 59 Temple Place - Suite 330,
Boston, MA  02111-1307, USA.
*****************************************************************/

package app;

import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.content.ContentElement;
import jade.content.abs.AbsAggregate;
import jade.content.abs.AbsIRE;
import jade.content.abs.AbsPredicate;
import jade.content.abs.AbsPrimitive;
import jade.content.abs.AbsVariable;
import jade.content.onto.*;
import jade.content.onto.basic.Action;
import jade.content.lang.*;
import jade.content.lang.Codec.CodecException;
import jade.content.lang.sl.*;

import jade.core.AID;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.util.leap.ArrayList;
import jade.util.leap.List;
import ontology.CBR.Adapt;
import ontology.CBR.AreReasonableSolutionsTo;
import ontology.CBR.AreSimilarTo;
import ontology.CBR.CBRTerminologyOntology;
import ontology.CBR.Problem;
import ontology.CBR.ProposedSolution;
import ontology.CBR.Resolve;
import ontology.CBR.Retrieve;

import ontology.common.CommonTerminologyOntology;
import ontology.common.Description;
import ontology.common.Descriptor;
import ontology.common.SSCharacterDescriptor;
import ontology.common.SSHeuristicDescriptor;
import ontology.common.SVCharacterDescriptor;
import ontology.common.SVHeuristicDescriptor;
import ontology.common.SingleValue;
import oracleIDGui.MobileOracleIDGui;

//@SuppressWarnings("serial")
public class MobileInterfaceAgent extends Agent {
  // El GUI por medio del cual el usuario introduce la descripción de un espécimen
  //private OracleIDGui myGui;

  private Description currentDescription = null; // El caso actual que se está resolviendo
  private Problem problem;
					

  //Se registra el lenguaje de contenido y la ontología
  private Codec codec = new SLCodec();
  private Ontology ontology = CBRTerminologyOntology.getInstance();
  private AID[] agents;
  private List structures;
  private String structure;
  private List attributes;
  private String attribute;
  private List values;
  // Inicialización del agente
  MobileOracleIDGui myGui;

  protected void setup() {
    // Imprimir un mensaje de bienvenida
      
    System.out.println("¡Hola! Sistema de identificación Movil "+getAID().getName()+" listo.");
    //        
    getContentManager().registerLanguage(codec);
    getContentManager().registerOntology(ontology);

    DFAgentDescription template = new DFAgentDescription();
    ServiceDescription sd = new ServiceDescription();
    sd.setType("species-ID");
    template.addServices(sd);

    try {
        DFAgentDescription[] result = DFService.search(this, template);
        if (result.length != 0) {
            System.out.println(getAID().getName()+" encontro los siguientes agentes: ");
            agents = new AID[result.length];
            for (int i = 0; i < result.length; ++i) {
                agents[i] = result[i].getName();
            }
        } else
            System.out.println(getAID().getName()+" no encontro otros agentes identificadores.");
    } catch (FIPAException fe) {
        fe.printStackTrace();
    }
    myGui  = new MobileOracleIDGui(this);
    getStructures();
    problem = new Problem();

  }

  // Operaciones de limpieza del agente
  protected void takeDown() {
  	// Cierra la GUI

      // Imprimir un mensaje de despedida
    System.out.println("¡Que tenga buen día! Sistema de identificación "+getAID().getName()+" abortado.");
  }

  /**
   * Invocado por el GUI cuando el usuario urge identificar el espécimen
   */
  public void identifySpecimen() {
    addBehaviour(new OneShotBehaviour() {
      public void action() {
          System.out.println(getAID().getName()+" Iniciando proceso de identificación...");

          myAgent.addBehaviour(new RemoteIdentificationPerformer());
      }
    });
  }

//SSCharacterDescriptor
//SVCharacterDescriptor
//SSHeuristicDescriptor
//SVHeuristicDescriptor


    public void addDescritorValue(String s,String a,double v){
        Descriptor d;
        if (s.equals("Factor biótico")||s.equals("Factor abiótico"))
            d = new SVHeuristicDescriptor();
        else
            d = new SVCharacterDescriptor();
        d.setStructure(s);
        d.setAttribute(a);

        d.setValue(new SingleValue(v,"count"));
        problem.getDescription().addToConcreteDescription(d);
    }
    public void addDescritorState(String s,String a,String v){
        Descriptor d;
        if (s.equals("Factor biótico")||s.equals("Factor abiótico"))
            d = new SSHeuristicDescriptor();
        else
            d = new SSCharacterDescriptor();
        d.setStructure(s);
        d.setAttribute(a);
        d.setValue(v);
        problem.getDescription().addToConcreteDescription(d);
    }
    public void addToProblem(Descriptor d){
        problem.getDescription().addToConcreteDescription(d);
    }

  public void getStructures() {
    addBehaviour(new OneShotBehaviour() {
      public void action() {
          System.out.println(getAID().getName()+"Traer las estruturas residenten en el back end.");

          myAgent.addBehaviour(new RemoteStructures());
      }
    });
  }

    public  void identify(){
        List descriptors = problem.getDescription().getDescriptors();
        if (descriptors!=null){
            for (int i = 0;i<descriptors.size();i++){
                Descriptor d = (Descriptor)descriptors.get(i);
                if (d instanceof SVHeuristicDescriptor){
                    SVHeuristicDescriptor svh = (SVHeuristicDescriptor)d;
                    System.out.println("SVHeuristicDescriptor");
                    System.out.println("Estructura:"+svh.getStructure());
                    System.out.println("Atributo:"+svh.getAttribute());
                    System.out.println("Valor:"+svh.getValue());
                }else if (d instanceof SVCharacterDescriptor){
                    SVCharacterDescriptor svc = (SVCharacterDescriptor)d;
                    System.out.println("SVCharacterDescriptor");
                    System.out.println("Estructura:"+svc.getStructure());
                    System.out.println("Atributo:"+svc.getAttribute());
                    System.out.println("Valor:"+svc.getValue());
                }else if (d instanceof SSHeuristicDescriptor){
                    SSHeuristicDescriptor ssh = (SSHeuristicDescriptor)d;
                    System.out.println("SSHeuristicDescriptor");
                    System.out.println("Estructura:"+ssh.getStructure());
                    System.out.println("Atributo:"+ssh.getAttribute());
                    System.out.println("Valor:"+ssh.getValue());
                }else if (d instanceof SSCharacterDescriptor){
                    SSCharacterDescriptor ssc = (SSCharacterDescriptor)d;
                    System.out.println("SSCharacterDescriptor");
                    System.out.println("Estructura:"+ssc.getStructure());
                    System.out.println("Atributo:"+ssc.getAttribute());
                    System.out.println("Valor:"+ssc.getValue());
                }
            }
        }

    }

    public List getStructuresList(){
              List myStructures = new ArrayList();
              if (structures!=null){
                  for (int i = 0; i<structures.size();i++)
                    myStructures.add((String)((List)structures.get(i)).get(0));
              }
              return myStructures;
          }
    public List getAttributesList(){
              List myAttributes = new ArrayList();
              if (attributes!=null){
                  for (int i = 0; i<attributes.size();i++)
                    myAttributes.add((String)((List)attributes.get(i)).get(0));
              }
              return myAttributes;
          }
    public List getValuesList(){
              List myValues = new ArrayList();
              if (values!=null){
                  for (int i = 0; i<values.size();i++)
                    myValues.add((String)((List)values.get(i)).get(0));
              }
              return myValues;
          }

    public void getAttributes(int index){
        if (structures!=null){
            List aStructure = (List)structures.get(index);
            getAttributes((String)aStructure.get(1));
        }
    }
    public void getValues(int index){
        if (attributes!=null){
            List aAttribute = (List)attributes.get(index);
            getValues((String)aAttribute.get(1));
        }
    }

  public void getAttributes(String aStructure) {
      structure = aStructure;
    addBehaviour(new OneShotBehaviour() {
      public void action() {
          System.out.println(getAID().getName()+"Traer los atributos residenten en el back end.");

          myAgent.addBehaviour(new RemoteAttributes());
      }
    });
  }
  
  public void getValues(String aAttribute) {
      attribute = aAttribute;
    addBehaviour(new OneShotBehaviour() {
      public void action() {
          System.out.println(getAID().getName()+"Traer los valores residenten en el back end.");

          myAgent.addBehaviour(new RemoteValues());
      }
    });

  }
	/**
	 * Este es el comportamiento usado por el agente interfaz para realizar un proceso de identificación
	 */
	private class RemoteValues extends Behaviour {
	  private MessageTemplate mt; // La plantilla para recibir respuestas
	  private int step = 0; // Guarda el estado de la conversación
	  public void action() {
	    switch (step) {
	    case 0:
		    // Enviar el mensaje al agente recuperador de posibles soluciones
		    ACLMessage msg = new ACLMessage(ACLMessage.QUERY_REF);
                    msg.addReceiver(agents[0]);

	        try {
	          msg.setLanguage(codec.getName());
	          msg.setOntology(ontology.getName());
	          msg.setConversationId("species-id"+System.currentTimeMillis());
	          msg.setReplyWith(getAID().getName()+System.currentTimeMillis()); // Valor único



                    AbsVariable x = new AbsVariable(attribute, BasicOntology.STRING);
                    AbsPredicate describeBy = new AbsPredicate(CommonTerminologyOntology.DESCRIBEDBY);
                    AbsVariable aAttribute = new AbsVariable(attribute, BasicOntology.STRING);
                    describeBy.set(CommonTerminologyOntology.DESCRIBES_ATTRIBUTE, aAttribute);
                    describeBy.set(CommonTerminologyOntology.DESCRIBEDBY_SCORE, x);
                    AbsIRE absAll = new AbsIRE(SLVocabulary.ALL);
                    absAll.setVariable(x);
                    absAll.setProposition(describeBy);


	          getContentManager().fillContent(msg, absAll);
	          send(msg);
	          System.out.println(getAID().getName()+" lista de valores...");
	        }
	        catch (CodecException ce) {
	          ce.printStackTrace();
	        }
	        catch (OntologyException oe) {
	          oe.printStackTrace();
	        }

	        step = 1;

	        break;
	    case 1:
	    	// Preparar plantilla para recibir el mensaje
	    	mt = MessageTemplate.and(MessageTemplate.and(
			MessageTemplate.MatchLanguage(codec.getName()),
			MessageTemplate.MatchOntology(ontology.getName())),
			MessageTemplate.MatchPerformative(ACLMessage.INFORM_REF));

	    	// Recibir todas las aceptaciones de servicio
	    	ACLMessage reply = myAgent.blockingReceive(mt);
	    	if (reply != null) {
            try {
              AbsPredicate ap = null;                    System.out.println("Atributos:");
                    if (attributes != null)
                        for (int i = 0; i<attributes.size();i++){
                            System.out.println((String)((List)attributes.get(i)).get(0)+ "(" +(String)((List)attributes.get(i)).get(1) + ")");
                        }


              // Convertir la cadena a descriptores abstractos
              ap = (AbsPredicate) getContentManager().extractAbsContent(reply);

              if (ap.getTypeName().equals(SLVocabulary.EQUALS)) {
                AbsAggregate absSet =  (AbsAggregate) ap.getAbsObject(SLVocabulary.EQUALS_RIGHT);
                if (absSet.isEmpty())
                    System.out.println("El agente "+reply.getSender().getName()+"no envio ninguna lista de valores.");
                else
                    // Procesar los casos
                    System.out.println("Los valores del agente "+reply.getSender().getName()+ " fueron recibidos.");
                    setValues(absSet);
                    if (values.size()>0)
                        myGui.switchDisplayable(null, myGui.getValuesChoice());
                    else
                        myGui.switchDisplayable(null, myGui.getValuesInput());
                    System.out.println("Valores:");
                    if (values != null)
                        for (int i = 0; i<values.size();i++){
                            System.out.println((String)((List)values.get(i)).get(0)+ "(" +(String)((List)values.get(i)).get(1) + ")");
                        }
             }
            }
            catch (CodecException ce) {
                ce.printStackTrace();
            }
            catch (OntologyException oe) {
                oe.printStackTrace();
            }
	      } else {
	        	  block();
	          }
                  step = 3;
	    	break;
	    }
	  }
          

	  public boolean done() {
		  if (step == 3) {
			  System.out.println(getAID().getName()+" ha terminado el proceso de obtencion de valores.");
		  }

		  return (step == 3);
	  }
	}  // Fin de la clase interna

	/**
	 * Este es el comportamiento usado por el agente interfaz para realizar un proceso de identificación
	 */
	private class RemoteAttributes extends Behaviour {
	  private MessageTemplate mt; // La plantilla para recibir respuestas
	  private int step = 0; // Guarda el estado de la conversación
	  public void action() {
	    switch (step) {
	    case 0:
		    // Enviar el mensaje al agente recuperador de posibles soluciones
		    ACLMessage msg = new ACLMessage(ACLMessage.QUERY_REF);
                    msg.addReceiver(agents[0]);

	        try {
	          msg.setLanguage(codec.getName());
	          msg.setOntology(ontology.getName());
	          msg.setConversationId("species-id"+System.currentTimeMillis());
	          msg.setReplyWith(getAID().getName()+System.currentTimeMillis()); // Valor único



                    AbsPredicate owns = new AbsPredicate(CommonTerminologyOntology.OWNS);
                    AbsVariable x = new AbsVariable("x", BasicOntology.STRING);
                    AbsVariable aStructure = new AbsVariable(structure, BasicOntology.STRING);
                    owns.set(CommonTerminologyOntology.OWNS_DESCRIPTIVEELEMENT, aStructure);
                    owns.set(CommonTerminologyOntology.OWNS_ATTRIBUTE, x);
                    AbsIRE absAll = new AbsIRE(SLVocabulary.ALL);
                    absAll.setVariable(x);
                    absAll.setProposition(owns);



	          getContentManager().fillContent(msg, absAll);
	          send(msg);
	          System.out.println(getAID().getName()+" lista de attributos...");
	        }
	        catch (CodecException ce) {
	          ce.printStackTrace();
	        }
	        catch (OntologyException oe) {
	          oe.printStackTrace();
	        }

	        step = 1;

	        break;
	    case 1:
	    	// Preparar plantilla para recibir el mensaje
	    	mt = MessageTemplate.and(MessageTemplate.and(
			MessageTemplate.MatchLanguage(codec.getName()),
			MessageTemplate.MatchOntology(ontology.getName())),
			MessageTemplate.MatchPerformative(ACLMessage.INFORM_REF));

	    	// Recibir todas las aceptaciones de servicio
	    	ACLMessage reply = myAgent.blockingReceive(mt);
	    	if (reply != null) {
            try {
              AbsPredicate ap = null;

              // Convertir la cadena a descriptores abstractos
              ap = (AbsPredicate) getContentManager().extractAbsContent(reply);

              if (ap.getTypeName().equals(SLVocabulary.EQUALS)) {
                AbsAggregate absSet =  (AbsAggregate) ap.getAbsObject(SLVocabulary.EQUALS_RIGHT);
                if (absSet.isEmpty())
                    System.out.println("El agente "+reply.getSender().getName()+"no envio ninguna lista de attributos.");
                else
                    // Procesar los casos
                    System.out.println("Los attributos del agente "+reply.getSender().getName()+ " fueron recibidas.");
                    setAttributes(absSet);
                    myGui.switchDisplayable(null, myGui.getAttributes());

                    System.out.println("Atributos:");
                    if (attributes != null)
                        for (int i = 0; i<attributes.size();i++){
                            System.out.println((String)((List)attributes.get(i)).get(0)+ "(" +(String)((List)attributes.get(i)).get(1) + ")");
                        }
             }
            }
            catch (CodecException ce) {
                ce.printStackTrace();
            }
            catch (OntologyException oe) {
                oe.printStackTrace();
            }
	      } else {
	        	  block();
	          }
                  step = 3;
	    	break;
	    }
	  }

	  public boolean done() {
		  if (step == 3) {
			  System.out.println(getAID().getName()+" ha terminado el proceso de obtencion de atributos.");
		  }

		  return (step == 3);
	  }
	}  // Fin de la clase interna 

	/**
	 * Este es el comportamiento usado por el agente interfaz para realizar un proceso de identificación
	 */
	private class RemoteStructures extends Behaviour {
	  private MessageTemplate mt; // La plantilla para recibir respuestas
	  private int step = 0; // Guarda el estado de la conversación
	  public void action() {
	    switch (step) {
	    case 0:
		    // Enviar el mensaje al agente recuperador de posibles soluciones
		    ACLMessage msg = new ACLMessage(ACLMessage.QUERY_REF);
                    msg.addReceiver(agents[0]);

	        try {
	          msg.setLanguage(codec.getName());
	          msg.setOntology(ontology.getName());
	          msg.setConversationId("species-id"+System.currentTimeMillis());
	          msg.setReplyWith(getAID().getName()+System.currentTimeMillis()); // Valor único



                    AbsVariable x = new AbsVariable("x", BasicOntology.STRING);
                    AbsPredicate absIsDescriptiveElement = new AbsPredicate(CommonTerminologyOntology.ISDESCRIPTIVEELEMENT);
                    absIsDescriptiveElement.set(CommonTerminologyOntology.ISDESCRIPTIVEELEMENT_DESCRIPTIVEELEMENT, x);
                    AbsIRE absAll = new AbsIRE(SLVocabulary.ALL);
                    absAll.setVariable(x);
                    absAll.setProposition(absIsDescriptiveElement);

	          getContentManager().fillContent(msg, absAll);
	          send(msg);
	          System.out.println(getAID().getName()+" lista de estructuras...");
	        }
	        catch (CodecException ce) {
	          ce.printStackTrace();
	        }
	        catch (OntologyException oe) {
	          oe.printStackTrace();
	        }

	        step = 1;

	        break;
	    case 1:
	    	// Preparar plantilla para recibir el mensaje
	    	mt = MessageTemplate.and(MessageTemplate.and(
			MessageTemplate.MatchLanguage(codec.getName()),
			MessageTemplate.MatchOntology(ontology.getName())),
			MessageTemplate.MatchPerformative(ACLMessage.INFORM_REF));

	    	// Recibir todas las aceptaciones de servicio
	    	ACLMessage reply = myAgent.blockingReceive(mt);
	    	if (reply != null) {
            try {
              AbsPredicate ap = null;

              // Convertir la cadena a descriptores abstractos
              ap = (AbsPredicate) getContentManager().extractAbsContent(reply);

              if (ap.getTypeName().equals(SLVocabulary.EQUALS)) {
                AbsAggregate absSet =  (AbsAggregate) ap.getAbsObject(SLVocabulary.EQUALS_RIGHT);
                if (absSet.isEmpty())
                    System.out.println("El agente "+reply.getSender().getName()+"no envio ninguna lista de estructuras.");
                else
                    // Procesar los casos
                    System.out.println("Las estruturas del agente "+reply.getSender().getName()+ " fueron recibidas.");
                    setStructures(absSet);
                    myGui.switchDisplayable(null, myGui.getStructures());
                    System.out.println("Estruturas:");
                    if (structures != null)
                        for (int i = 0; i<structures.size();i++){
                           System.out.println((String)((List)structures.get(i)).get(0)+ "(" +(String)((List)structures.get(i)).get(1) + ")");
                        }
             }
            }
            catch (CodecException ce) {
                ce.printStackTrace();
            }
            catch (OntologyException oe) {
                oe.printStackTrace();
            }
	      } else {
	        	  block();
	          }
                  step = 3;
	    	break;
	    }
	  }

	  public boolean done() {
		  if (step == 3) {
			  System.out.println(getAID().getName()+" ha terminado el proceso de obtencion de estructuras");
		  }

		  return (step == 3);
	  }
	}  // Fin de la clase interna 

	/**
	 * Este es el comportamiento usado por el agente interfaz para realizar un proceso de identificación
	 */
	private class RemoteIdentificationPerformer extends Behaviour {
	  private MessageTemplate mt; // La plantilla para recibir respuestas
	  private int step = 0; // Guarda el estado de la conversación

	  public void action() {
	    switch (step) {
	    case 0:
		    // Enviar el mensaje al agente recuperador de posibles soluciones
		    ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
	        msg.addReceiver(agents[0]);


	        try {
	          msg.setLanguage(codec.getName());
	          msg.setOntology(ontology.getName());
	          msg.setConversationId("species-id"+System.currentTimeMillis());
	          msg.setReplyWith(getAID().getName()+System.currentTimeMillis()); // Valor único

	          Resolve resolve = new Resolve();
                  resolve.setProblem(problem);

	          Action action = new Action();
	          action.setAction(resolve);
	          action.setActor(agents[0]);

	          // Convertir objetos Java a cadena
	          getContentManager().fillContent(msg, action);
	          send(msg);
	          System.out.println(getAID().getName()+" solicitando casos similares o soluciones posibles... ");
	        }
	        catch (CodecException ce) {
	          ce.printStackTrace();
	        }
	        catch (OntologyException oe) {
	          oe.printStackTrace();
	        }

	        step = 1;
	        break;
	    case 1:
	    	// Preparar plantilla para recibir el mensaje
	    	mt = MessageTemplate.and(MessageTemplate.and(
	    	MessageTemplate.MatchLanguage(codec.getName()),
	    	MessageTemplate.MatchOntology(ontology.getName())),
	    	MessageTemplate.MatchPerformative(ACLMessage.INFORM));

	    	// Recibir todos los casos devueltos
	    	ACLMessage reply = myAgent.blockingReceive(mt);
	    	if (reply != null) {
	    		try {
		    		// Respuesta recibida
		    		ContentElement ce = null;

		    		// Convertir la cadena a objetos Java
		    		ce = getContentManager().extractContent(reply);

		    		if (ce instanceof AreReasonableSolutionsTo) {
		    			AreReasonableSolutionsTo areReasonableSolutionsTo = (AreReasonableSolutionsTo) ce;

				        System.out.println(getAID().getName()+"ha recibido las soluciones propuestas...");

				        if (!areReasonableSolutionsTo.getProposedSolutions().isEmpty()) {
					        System.out.println(getAID().getName()+" presentando las soluciones propuestas...");

					        List proposedSolutions = areReasonableSolutionsTo.getProposedSolutions();

                                                for (int i=0; i<proposedSolutions.size();i++){
                                                    ProposedSolution p = (ProposedSolution)proposedSolutions.get(i);
                                                    System.out.println("State:"+p.getState());
                                                    System.out.println("Level:"+p.getSolution().getLevel());
                                                    System.out.println("Name:"+p.getSolution().getName());
                                                    System.out.println("----");
                                                }


				        } else {
				        	//show gui warnning message
                                            System.out.println("Not solutions!");
				        }

				        step = 3;
		    		}
	    		}
	    		catch (CodecException ce) {
			          ce.printStackTrace();
		        }
		        catch (OntologyException oe) {
		          oe.printStackTrace();
		        }
	    	} else {
	    		block();
	    	}
	    }
	  }

	  public boolean done() {
		  if (step == 2) {
			  System.out.println(getAID().getName()+" ha terminado proceso de identificación...");
		  }

		  return (step == 2);
	  }
	}  // Fin de la clase interna IdentificationPerformer


	public Description getCurrentDescription() {
		return currentDescription;
	}

	public void setCurrentDescription(Description description) {
		this.currentDescription = description;
	}
        public void setStructures(AbsAggregate myStructures){
            structures = new ArrayList();
            if (myStructures!= null)
                for (int i=0;i<(myStructures.size()-1);i++){
                    List aStructure = new ArrayList();
                    aStructure.add(((AbsPrimitive)myStructures.get(i)).getString());
                    aStructure.add(((AbsPrimitive)myStructures.get(i+1)).getString());
                    ++i;
                    structures.add(aStructure);
                }
        }
        public void setAttributes(AbsAggregate myAttributes){
            attributes = new ArrayList();
            if (myAttributes!= null)
                for (int i=0;i<(myAttributes.size()-1);i++){
                    List aList = new ArrayList();
                    aList.add(((AbsPrimitive)myAttributes.get(i)).getString());
                    aList.add(((AbsPrimitive)myAttributes.get(i+1)).getString());
                    ++i;
                    attributes.add(aList);
                }
        }
        public void setValues(AbsAggregate myValues){
            values = new ArrayList();
            if (myValues!= null)
                for (int i=0;i<(myValues.size()-1);i++){
                    List aList = new ArrayList();
                    aList.add(((AbsPrimitive)myValues.get(i)).getString());
                    aList.add(((AbsPrimitive)myValues.get(i+1)).getString());
                    ++i;
                    values.add(aList);
                }
        }

}
