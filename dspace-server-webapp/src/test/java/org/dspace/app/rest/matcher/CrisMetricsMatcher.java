/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.rest.matcher;
import static com.jayway.jsonpath.matchers.JsonPathMatchers.hasJsonPath;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.dspace.app.metrics.CrisMetrics;
import org.dspace.app.rest.model.CrisMetricsRest;
import org.hamcrest.Matcher;

/**
 * Provide convenient org.hamcrest.Matcher to verify a CrisMetricsRest json response
 *
 * @author Mykhaylo Boychuk (mykhaylo.boychuk at 4science.it)
 */
public class CrisMetricsMatcher {

    private CrisMetricsMatcher() {}

    public static Matcher<? super Object> matchCrisMetrics(CrisMetrics crisMetrics) {
        return allOf(hasJsonPath("$.id", is(crisMetrics.getID())),
                     hasJsonPath("$.metricType", is(crisMetrics.getMetricType())),
                     hasJsonPath("$.metricCount", is(crisMetrics.getMetricCount())),
                  // TODO
                 //  hasJsonPath("$.acquisitionDate", is(formatDate(crisMetrics.getAcquisitionDate()))),
                     hasJsonPath("$.last", is(crisMetrics.getLast())),
                     hasJsonPath("$.remark", is(crisMetrics.getRemark())),
                     hasJsonPath("$.deltaPeriod1", is(crisMetrics.getDeltaPeriod1())),
                     hasJsonPath("$.deltaPeriod2", is(crisMetrics.getDeltaPeriod2())),
                     hasJsonPath("$.rank", is(crisMetrics.getRank())),
                     hasJsonPath("$.type", is(CrisMetricsRest.NAME))
                     );
    }

    private static String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        String formattedDate = formatter.format(date);
        return formattedDate;
    }

}