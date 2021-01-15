/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.metrics;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.dspace.content.Item;
import org.dspace.core.ReloadableEntity;

/**
 * 
 * @author Mykhaylo Boychuk (mykhaylo.boychuk at 4science.it)
 */
@Entity
@Table(name = "cris_metrics")
public class CrisMetrics  implements ReloadableEntity<String> {

    public final static String STORED_METRIC_ID_PREFIX = "storedmetric-";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cris_metrics_seq")
    @SequenceGenerator(name = "cris_metrics_seq", sequenceName = "cris_metrics_seq", allocationSize = 1)
    private Integer id;

    private String metricType;

    private Double metricCount;

    private Date acquisitionDate;

    private Date startDate;

    private Date endDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "resource_id")
    protected Item resource;

    private boolean last;

    @Lob
    private String remark;

    private Double deltaPeriod1;

    private Double deltaPeriod2;

    private Double rank;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMetricType() {
        return metricType;
    }

    public void setMetricType(String metricType) {
        this.metricType = metricType;
    }

    public Double getMetricCount() {
        return metricCount;
    }

    public void setMetricCount(Double metricCount) {
        this.metricCount = metricCount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean getLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public Date getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(Date acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public Item getResource() {
        return resource;
    }

    public void setResource(Item resource) {
        this.resource = resource;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String getID() {
        return String.valueOf(this.getId());
    }

    public Double getDeltaPeriod1() {
        return deltaPeriod1;
    }

    public void setDeltaPeriod1(Double deltaPeriod1) {
        this.deltaPeriod1 = deltaPeriod1;
    }

    public Double getDeltaPeriod2() {
        return deltaPeriod2;
    }

    public void setDeltaPeriod2(Double deltaPeriod2) {
        this.deltaPeriod2 = deltaPeriod2;
    }

    public Double getRank() {
        return rank;
    }

    public void setRank(Double rank) {
        this.rank = rank;
    }

}