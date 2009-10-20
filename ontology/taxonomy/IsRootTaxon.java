package ontology.taxonomy;


import jade.content.abs.*;
import jade.content.onto.*;

/**
* Protege name: IsRootTaxon
* @author ontology bean generator
* @version 2009/10/17, 17:24:41
*/
public class IsRootTaxon implements jade.content.Predicate, Introspectable {

  private String _internalInstanceName = null;

  public IsRootTaxon() {
    this._internalInstanceName = "";
  }

  public IsRootTaxon(String instance_name) {
    this._internalInstanceName = instance_name;
  }

  public String toString() {
    return _internalInstanceName;
  }

   /**
   * Protege name: taxon
   */
   private Taxon taxon;
   public void setTaxon(Taxon value) {
    this.taxon=value;
   }
   public Taxon getTaxon() {
     return this.taxon;
   }

  public void externalise(AbsObject absObj, Ontology onto) throws OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      abs.set(TaxonomyOntology.ISROOTTAXON_TAXON, (AbsTerm) onto.fromObject(getTaxon()));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error externalising IsRootTaxon");
     }
   }

  public void internalise(AbsObject absObj, Ontology onto) throws UngroundedException, OntologyException {
    try {
      AbsPredicate abs = (AbsPredicate) absObj;
      taxon = (Taxon)onto.toObject(abs.getAbsObject(TaxonomyOntology.ISROOTTAXON_TAXON));
     } catch (ClassCastException cce) {
       throw new OntologyException("Error internalising IsRootTaxon");
     }
   }

}

