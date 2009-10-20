/**
 * @see "Categor&iacute;a Main de SUKIA Smalltalk"
 */
package ontology.common;

import jade.content.abs.AbsConcept;
import jade.content.abs.AbsObject;
import jade.content.abs.AbsTerm;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.content.onto.UngroundedException;

/**
 * Descriptor es un elemento descriptivo de la descripción de un caso: el par attribute-value.
 * Generaliza conceptos en normas.
 * Todas las raíces de red (especializaciónes de normas) contienen un descriptor de la forma (nil, nil),
 * ya que ning&uacute;n par attribute-value particular generaliza todos los casos bajo ellos.
 * 
*/
public class SSHeuristicDescriptor extends QualitativeHeuristicDescriptor {
	String value;
	
	public SSHeuristicDescriptor() {
		
	}

	public SSHeuristicDescriptor(String instance_name) {
		super(instance_name);
	}
	
	/**
	 * Class instance invariant: self MUST always have exactly two values. The first
	 * element corresponds to the descriptor's attribute, and the second one to the value.
	 * Extreme care should be taken when using this method, as it assumes an empty self."
	 * @see "M&eacute;todo initialize del protocolo initializing en SUKIA SmallTalk"
	 */
	public SSHeuristicDescriptor(String aStructure, String aAttribute, String aValue) {
		super(aStructure, aAttribute);
		this.setValue(aValue);
	}
	
	public void setValue(Object value) {
		this.value = (String)value;
	}

	public Object getValue() {
		return (String)value;
	}
	
  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      abs.set(CommonTerminologyOntology.SSHEURISTICDESCRIPTOR_VALUE, (AbsTerm) onto.fromObject(getValue()));
      abs.set(CommonTerminologyOntology.DESCRIPTOR_ATTRIBUTE, (AbsTerm) onto.fromObject(getAttribute()));
      abs.set(CommonTerminologyOntology.DESCRIPTOR_STRUCTURE, (AbsTerm) onto.fromObject(getStructure()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising SSCharacterDescriptor");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      value = (String)onto.toObject(abs.getAbsObject(CommonTerminologyOntology.SSHEURISTICDESCRIPTOR_VALUE));
      setAttribute((String)onto.toObject(abs.getAbsObject(CommonTerminologyOntology.DESCRIPTOR_ATTRIBUTE)));
      setStructure((String)onto.toObject(abs.getAbsObject(CommonTerminologyOntology.DESCRIPTOR_STRUCTURE)));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising SSCharacterDescriptor");
     }
   }
}
