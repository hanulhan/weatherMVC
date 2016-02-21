/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author uli
 */
@Entity
@Table(name = "ProviderLocations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProviderLocations.findAll", query = "SELECT p FROM ProviderLocations p"),
    @NamedQuery(name = "ProviderLocations.findById", query = "SELECT p FROM ProviderLocations p WHERE p.id = :id"),
    @NamedQuery(name = "ProviderLocations.findByProviderLocationId", query = "SELECT p FROM ProviderLocations p WHERE p.providerLocationId = :providerLocationId")})
public class ProviderLocations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ProviderLocationId")
    private String providerLocationId;
    @JoinColumn(name = "LocationId", referencedColumnName = "LocationId")
    @ManyToOne(optional = false)
    private Locations locationId;
    @JoinColumn(name = "ProviderId", referencedColumnName = "ProviderId")
    @ManyToOne(optional = false)
    private Providers providerId;

    public ProviderLocations() {
    }

    public ProviderLocations(Integer id) {
        this.id = id;
    }

    public ProviderLocations(Integer id, String providerLocationId) {
        this.id = id;
        this.providerLocationId = providerLocationId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProviderLocationId() {
        return providerLocationId;
    }

    public void setProviderLocationId(String providerLocationId) {
        this.providerLocationId = providerLocationId;
    }

    public Locations getLocationId() {
        return locationId;
    }

    public void setLocationId(Locations locationId) {
        this.locationId = locationId;
    }

    public Providers getProviderId() {
        return providerId;
    }

    public void setProviderId(Providers providerId) {
        this.providerId = providerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProviderLocations)) {
            return false;
        }
        ProviderLocations other = (ProviderLocations) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ProviderLocations[ id=" + id + " ]";
    }
    
}
