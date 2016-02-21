/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author uli
 */
@Entity
@Table(name = "Locations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Locations.findAll", query = "SELECT l FROM Locations l"),
    @NamedQuery(name = "Locations.findByLocationId", query = "SELECT l FROM Locations l WHERE l.locationId = :locationId"),
    @NamedQuery(name = "Locations.findByLocationName", query = "SELECT l FROM Locations l WHERE l.locationName = :locationName"),
    @NamedQuery(name = "Locations.findByLocationActive", query = "SELECT l FROM Locations l WHERE l.locationActive = :locationActive"),
    @NamedQuery(name = "Locations.findByLocationLastUpdate", query = "SELECT l FROM Locations l WHERE l.locationLastUpdate = :locationLastUpdate"),
    @NamedQuery(name = "Locations.findByLocationCountry", query = "SELECT l FROM Locations l WHERE l.locationCountry = :locationCountry"),
    @NamedQuery(name = "Locations.findByLat", query = "SELECT l FROM Locations l WHERE l.lat = :lat"),
    @NamedQuery(name = "Locations.findByLon", query = "SELECT l FROM Locations l WHERE l.lon = :lon")})
public class Locations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LocationId")
    private String locationId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LocationName")
    private String locationName;
    @Column(name = "LocationActive")
    private Short locationActive;
    @Column(name = "LocationLastUpdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date locationLastUpdate;
    @Size(max = 50)
    @Column(name = "LocationCountry")
    private String locationCountry;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "lat")
    private Double lat;
    @Column(name = "lon")
    private Double lon;

    public Locations() {
    }

    public Locations(String locationId) {
        this.locationId = locationId;
    }

    public Locations(String locationId, String locationName) {
        this.locationId = locationId;
        this.locationName = locationName;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Short getLocationActive() {
        return locationActive;
    }

    public void setLocationActive(Short locationActive) {
        this.locationActive = locationActive;
    }

    public Date getLocationLastUpdate() {
        return locationLastUpdate;
    }

    public void setLocationLastUpdate(Date locationLastUpdate) {
        this.locationLastUpdate = locationLastUpdate;
    }

    public String getLocationCountry() {
        return locationCountry;
    }

    public void setLocationCountry(String locationCountry) {
        this.locationCountry = locationCountry;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locationId != null ? locationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Locations)) {
            return false;
        }
        Locations other = (Locations) object;
        if ((this.locationId == null && other.locationId != null) || (this.locationId != null && !this.locationId.equals(other.locationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Locations[ locationId=" + locationId + " ]";
    }
    
}
