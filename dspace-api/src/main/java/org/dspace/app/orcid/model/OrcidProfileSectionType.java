/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.orcid.model;

/**
 * Enum that model all the ORCID profile sections that could be synchronized.
 * @author Luca Giamminonni (luca.giamminonni at 4science.it)
 *
 */
public enum OrcidProfileSectionType {

    AFFILIATION("/employment"),
    EDUCATION("/education"),
    QUALIFICATION("/qualification"),
    OTHER_NAMES("/other-names"),
    COUNTRY("/address"),
    KEYWORDS("/keywords"),
    EXTERNAL_IDS("/external-identifiers"),
    RESEARCHER_URLS("/researcher-urls");

    private final String path;

    private OrcidProfileSectionType(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

}
