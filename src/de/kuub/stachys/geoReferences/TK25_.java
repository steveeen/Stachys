package de.kuub.stachys.geoReferences;

import com.vividsolutions.jts.geom.Polygon;
import de.kuub.stachys.domain.CountingLocations;
import de.kuub.stachys.domain.TracebleClass_;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2011-08-29T12:35:32.202+0200")
@StaticMetamodel(TK25.class)
public class TK25_ extends TracebleClass_ {
	public static volatile SingularAttribute<TK25, BigDecimal> tk25nr;
	public static volatile SingularAttribute<TK25, String> tk25name;
	public static volatile SingularAttribute<TK25, Polygon> area;
	public static volatile ListAttribute<TK25, TK25vqu> quadrants;
	public static volatile ListAttribute<TK25, CountingLocations> countareas;
}
