package de.kuub.stachys.geoReferences;

import com.vividsolutions.jts.geom.Polygon;
import de.kuub.stachys.domain.CountingLocations;
import de.kuub.stachys.domain.TracebleClass_;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2011-08-29T12:35:32.208+0200")
@StaticMetamodel(TK25vqu.class)
public class TK25vqu_ extends TracebleClass_ {
	public static volatile SingularAttribute<TK25vqu, Integer> tk25vqu_id;
	public static volatile SingularAttribute<TK25vqu, BigDecimal> quadnr;
	public static volatile SingularAttribute<TK25vqu, BigDecimal> vquadnr;
	public static volatile SingularAttribute<TK25vqu, Polygon> area;
	public static volatile SingularAttribute<TK25vqu, TK25> tk25;
	public static volatile ListAttribute<TK25vqu, CountingLocations> countareas;
}
