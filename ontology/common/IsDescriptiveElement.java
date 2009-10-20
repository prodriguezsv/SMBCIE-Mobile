package ontology.common;


import jade.content.abs.*;
import jade.content.onto.*;

/**
* Protege name: IsDescriptiveElement
* @author ontology bean generator
* @version 2009/10/20, 12:55:34
*/
public class IsDescriptiveElement implements jade.content.Predicate, Introspectable {

	private String _internalInstanceName = null;

	  public IsDescriptiveElement() {
	    this._internalInstanceName = "";
	  }
	
	  public IsDescriptiveElement(String instance_name) {
	    this._internalInstanceName = instance_name;
	  }
	
	  public String toString() {
	    return _internalInstanceName;
	  }
	
	   /**
	   * Protege name: descriptiveElement
	   */
	   private String descriptiveElement;
	   public void setDescriptiveElement(String value) { 
	    this.descriptiveElement=value;
	   }
	   public String getDescriptiveElement() {
	     return this.descriptiveElement;
	   }
	
	  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
	    try {
	      AbsPredicate abs = (AbsPredicate) absObj;
	      abs.set( CommonTerminologyOntology.ISDESCRIPTIVEELEMENT_DESCRIPTIVEELEMENT, (AbsTerm) onto.fromObject(getDescriptiveElement()));
	     } catch (ClassCastException cce) {
	       throw new OntologyException("Error externalising IsDescriptiveElement");
	     }
	   }
	
	  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
	    try {
	      AbsPredicate abs = (AbsPredicate) absObj;
	      descriptiveElement = (String)onto.toObject(abs.getAbsObject(CommonTerminologyOntology.ISDESCRIPTIVEELEMENT_DESCRIPTIVEELEMENT));
	     } catch (ClassCastException cce) {
	       throw new OntologyException("Error internalising IsDescriptiveElement");
	     }
	   }

}
