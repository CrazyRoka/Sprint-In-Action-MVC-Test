package spittr;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.Date;
public class Spittle {
    volatile static int counter = 1;
    private final long id;
    private final String message;
    private final Date time;
    private Double latitude;
    private Double longitude;
    public Spittle(String message, Date time) {
        this(message, time, null, null);
    }
    public Spittle(String message, Date time, Double longitude, Double latitude) {
        this.id = counter++;
        this.message = message;
        this.time = time;
        this.longitude = longitude;
        this.latitude = latitude;
    }
    public long getId() {
        return id;
    }
    public String getMessage() {
        return message;
    }
    public Date getTime() {
        return time;
    }
    public Double getLongitude() {
        return longitude;
    }
    public Double getLatitude() {
        return latitude;
    }
    @Override
    public boolean equals(Object that) {
        if(!(that instanceof Spittle))return false;
        Spittle spittle = (Spittle)that;
        return new EqualsBuilder().append(time, ((Spittle) that).time).append(id, ((Spittle) that).id).isEquals();
    }
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}