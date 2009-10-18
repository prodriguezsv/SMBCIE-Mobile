/**
 * @see "Categor&iacute;a Sukia Values de SUKIA Smalltalk"
 */
package ontology.common;

import edu.stanford.smi.protege.exception.OntologyException;
import jade.content.abs.AbsConcept;
import jade.content.abs.AbsObject;
import jade.content.abs.AbsTerm;
import jade.content.onto.Introspectable;
import jade.content.onto.Ontology;
import jade.content.onto.UngroundedException;


/**
 * Clase modificada
 * @see "Clase ValueDescriptor"
 * @author Armando
 */
public abstract class Value implements jade.content.Concept, Introspectable {
	private String measuringUnit;
		
	private static final long serialVersionUID = -3087841394215437493L;
		
	private String _internalInstanceName = null;
		
	public Value() {
	  this._internalInstanceName = "";
	}
		
	public Value(String instance_name) {
	  this._internalInstanceName = instance_name;
	}
	  
	public String get_internalInstanceName() {
		return _internalInstanceName;
	}

	/**
	 * aMeasuringUnit can be #cm, #mm, #inch
	 * @see "M&eacute;todo measuringUnit: del protocolo setting-range values (private) en SUKIA SmallTalk"
	 * @param measuringUnit
	 */
	public void setMeasuringUnit(String aMeasuringUnit) {
		boolean iscontained = false;
                for (int i = 0;i<MeasuringUnit.values.size();i++){
                    if (MeasuringUnit.values.get(i).equals(aMeasuringUnit)){
				iscontained = true;
				break;
                    }
                }
		if (iscontained) this.measuringUnit = aMeasuringUnit;
	}

	/**
	 * @see "M&eacute;todo measuringUnit del protocolo accessing-range values en SUKIA SmallTalk"
	 * @return
	 */
	public String getMeasuringUnit() {
		return measuringUnit;
	}
 
	public abstract boolean equals(Object aValue);
  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException, jade.content.onto.OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      abs.set(CommonTerminologyOntology.VALUE_MEASURINGUNIT, (AbsTerm) onto.fromObject(getMeasuringUnit()));
//      abs.set(CommonTerminologyOntology.VALUE_DESCRIBES, (AbsTerm) onto.fromObject(getDescribes()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising Value");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException, jade.content.onto.OntologyException {
    try {
      AbsConcept abs = (AbsConcept) absObj;
      measuringUnit = (String)onto.toObject(abs.getAbsObject(CommonTerminologyOntology.VALUE_MEASURINGUNIT));
      //describes = (List)onto.toObject(abs.getAbsObject(CommonTerminologyOntology.VALUE_DESCRIBES));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising Value");
     }
   }

}
