package ontology.taxonomy;


import jade.content.abs.*;
import jade.content.onto.*;

/**
* Protege name: IsSuccessorTaxonOf
* @author ontology bean generator
* @version 2009/10/17, 17:24:41
*/
public class IsSuccessorTaxonOf implements jade.content.Predicate, Introspectable {

  private String _internalInstanceName = null;

  public IsSuccessorTaxonOf() {
    this._internalInstanceName = "";
  }

  public IsSuccessorTaxonOf(String instance_name) {
    this._internalInstanceName = instance_name;
  }

  public String toString() {
    return _internalInstanceName;
  }

   /**
   * Protege name: objectTaxon
   */
   private Taxon objectTaxon;
   public void setObjectTaxon(Taxon value) {
    this.objectTaxon=value;
   }
   public Taxon getObjectTaxon() {
     return this.objectTaxon;
   }

   /**
   * Protege name: subjectTaxon
   */
   private Taxon subjectTaxon;
   public void setSubjectTaxon(Taxon value) {
    this.subjectTaxon=value;
   }
   public Taxon getSubjectTaxon() {
     return this.subjectTaxon;
   }

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      abs.set(TaxonomyOntology.ISSUCCESSORTAXONOF_OBJECTTAXON, (AbsTerm) onto.fromObject(getObjectTaxon()));
      abs.set(TaxonomyOntology.ISSUCCESSORTAXONOF_SUBJECTTAXON, (AbsTerm) onto.fromObject(getSubjectTaxon()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising IsSuccessorTaxonOf");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      objectTaxon = (Taxon)onto.toObject(abs.getAbsObject(TaxonomyOntology.ISSUCCESSORTAXONOF_OBJECTTAXON));
      subjectTaxon = (Taxon)onto.toObject(abs.getAbsObject(TaxonomyOntology.ISSUCCESSORTAXONOF_SUBJECTTAXON));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising IsSuccessorTaxonOf");
     }
   }

}
