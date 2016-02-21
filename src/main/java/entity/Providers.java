/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author uli
 */
@Entity
@Table(name = "Providers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Providers.findAll", query = "SELECT p FROM Providers p"),
    @NamedQuery(name = "Providers.findByProviderId", query = "SELECT p FROM Providers p WHERE p.providerId = :providerId"),
    @NamedQuery(name = "Providers.findByProviderName", query = "SELECT p FROM Providers p WHERE p.providerName = :providerName"),
    @NamedQuery(name = "Providers.findByProviderURL", query = "SELECT p FROM Providers p WHERE p.providerURL = :providerURL"),
    @NamedQuery(name = "Providers.findByProviderDescription", query = "SELECT p FROM Providers p WHERE p.providerDescription = :providerDescription"),
    @NamedQuery(name = "Providers.findByProviderFarenheit", query = "SELECT p FROM Providers p WHERE p.providerFarenheit = :providerFarenheit"),
    @NamedQuery(name = "Providers.findByActive", query = "SELECT p FROM Providers p WHERE p.active = :active"),
    @NamedQuery(name = "Providers.findByMaxActivePerSecond", query = "SELECT p FROM Providers p WHERE p.maxActivePerSecond = :maxActivePerSecond"),
    @NamedQuery(name = "Providers.findByRefreshInterval", query = "SELECT p FROM Providers p WHERE p.refreshInterval = :refreshInterval"),
    @NamedQuery(name = "Providers.findByRequiresId", query = "SELECT p FROM Providers p WHERE p.requiresId = :requiresId"),
    @NamedQuery(name = "Providers.findBySleepWhenMaxActive", query = "SELECT p FROM Providers p WHERE p.sleepWhenMaxActive = :sleepWhenMaxActive")})
public class Providers implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "providerId")
    private Collection<ProviderLocations> providerLocationsCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProviderId")
    private Integer providerId;
    @Size(max = 50)
    @Column(name = "ProviderName")
    private String providerName;
    @Size(max = 255)
    @Column(name = "ProviderURL")
    private String providerURL;
    @Size(max = 255)
    @Column(name = "ProviderDescription")
    private String providerDescription;
    @Column(name = "ProviderFarenheit")
    private Short providerFarenheit;
    @Column(name = "Active")
    private Short active;
    @Column(name = "MaxActivePerSecond")
    private Integer maxActivePerSecond;
    @Column(name = "RefreshInterval")
    private Integer refreshInterval;
    @Column(name = "RequiresId")
    private Short requiresId;
    @Column(name = "SleepWhenMaxActive")
    private Integer sleepWhenMaxActive;

    public Providers() {
    }

    public Providers(Integer providerId) {
        this.providerId = providerId;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderURL() {
        return providerURL;
    }

    public void setProviderURL(String providerURL) {
        this.providerURL = providerURL;
    }

    public String getProviderDescription() {
        return providerDescription;
    }

    public void setProviderDescription(String providerDescription) {
        this.providerDescription = providerDescription;
    }

    public Short getProviderFarenheit() {
        return providerFarenheit;
    }

    public void setProviderFarenheit(Short providerFarenheit) {
        this.providerFarenheit = providerFarenheit;
    }

    public Short getActive() {
        return active;
    }

    public void setActive(Short active) {
        this.active = active;
    }

    public Integer getMaxActivePerSecond() {
        return maxActivePerSecond;
    }

    public void setMaxActivePerSecond(Integer maxActivePerSecond) {
        this.maxActivePerSecond = maxActivePerSecond;
    }

    public Integer getRefreshInterval() {
        return refreshInterval;
    }

    public void setRefreshInterval(Integer refreshInterval) {
        this.refreshInterval = refreshInterval;
    }

    public Short getRequiresId() {
        return requiresId;
    }

    public void setRequiresId(Short requiresId) {
        this.requiresId = requiresId;
    }

    public Integer getSleepWhenMaxActive() {
        return sleepWhenMaxActive;
    }

    public void setSleepWhenMaxActive(Integer sleepWhenMaxActive) {
        this.sleepWhenMaxActive = sleepWhenMaxActive;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (providerId != null ? providerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Providers)) {
            return false;
        }
        Providers other = (Providers) object;
        if ((this.providerId == null && other.providerId != null) || (this.providerId != null && !this.providerId.equals(other.providerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Providers[ providerId=" + providerId + " ]";
    }

    @XmlTransient
    public Collection<ProviderLocations> getProviderLocationsCollection() {
        return providerLocationsCollection;
    }

    public void setProviderLocationsCollection(Collection<ProviderLocations> providerLocationsCollection) {
        this.providerLocationsCollection = providerLocationsCollection;
    }
    
}
