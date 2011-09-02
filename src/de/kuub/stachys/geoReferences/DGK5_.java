package de.kuub.stachys.geoReferences;

import com.vividsolutions.jts.geom.Polygon;
import de.kuub.stachys.domain.CountingLocations;
import de.kuub.stachys.domain.TracebleClass_;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2011-08-29T12:35:32.060+0200")
@StaticMetamodel(DGK5.class)
public class DGK5_ extends TracebleClass_ {
	public static volatile SingularAttribute<DGK5, Integer> dgk5_id;
	public static volatile SingularAttribute<DGK5, BigDecimal> dgk5nr;
	public static volatile SingularAttribute<DGK5, String> dgkname;
	public static volatile SingularAttribute<DGK5, Polygon> area;
	public static volatile SingularAttribute<DGK5, Boolean> overlapping;
	public static volatile ListAttribute<DGK5, CountingLocations> countareas;
}
