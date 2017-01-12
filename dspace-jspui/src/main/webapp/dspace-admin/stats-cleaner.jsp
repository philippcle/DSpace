<%--

    The contents of this file are subject to the license and copyright
    detailed in the LICENSE and NOTICE files at the root of the source
    tree and available online at

    http://www.dspace.org/license/

--%>
<%@page import="org.apache.solr.client.solrj.response.TermsResponse.Term"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"
    prefix="fmt" %>


<%@ taglib uri="http://www.dspace.org/dspace-tags.tld" prefix="dspace" %>

<%@ page import="javax.servlet.jsp.jstl.fmt.LocaleSupport" %>
<%@ page import="org.dspace.app.webui.util.CurateTaskResult" %>
<%@ page import="org.dspace.core.ConfigurationManager" %>

<%
	List<Term> terms = (List<Term>) request.getAttribute("terms");
	Boolean deleted = (Boolean) request.getAttribute("deleted");
%>
<dspace:layout 
			   style="submission"
			   titlekey="jsp.dspace-admin.stats-cleaner.title"
               navbar="admin"
               locbar="link"
               parenttitlekey="jsp.administer"
               parentlink="/dspace-admin">


  <h1><fmt:message key="jsp.dspace-admin.stats-cleaner.heading"/></h1>

<% if (deleted != null && deleted) { %>
<div class="alert alert-success">Deleted</div>
<% } %>

<% for (Term t : terms) { %>
<form action="" method="post">
	<%= t.getTerm() %> [<%= t.getFrequency() %>]
	<textarea name="userAgent"><%= t.getTerm() %></textarea>
	<input type="submit" value="delete" />
</form>
<br/>
<% } %>
</dspace:layout>
