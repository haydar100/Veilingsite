<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@include file="/header.jsp"%>
<section id="content">
<div class="jumbotron">
<div class="container">
<h1>Welkom op Auction Hunters!</h1>
<p>Dit is een site waarop u als koper gemakkelijk de nieuwste koopjes voor de laagste prijs vind, tevens kunt u hier als verkoper ook snel een groot publiek bereiken voor het verkopen van uw producten.</p>
<p><a href="over" class="btn btn-primary btn-lg">Meer informatie &raquo;</a></p>
</div>
</div>
<div class="container">
	<table>
		<tr class="thcolor">
			<th>Id</th>
			<th>Startdatum</th>
			<th>Sluitdatum</th>
			<th>Artikelnummer</th>
			<th>Categorie</th>
			<th>Omschrijving</th>
			<th>Minimumbedrag</th>
			<th>Aantal</th>
		</tr>
		<s:iterator value="alleVeilingen">
			<tr class="tdcolor">
				<td><s:property value="id"/></td>
				<td><s:property value="startdatum" /></td>
				<td><s:property value="sluitdatum" /></td>
				<td><s:property value="artikelnummer" /></td>
				<td><s:property value="categorie" /></td>
				<td><s:property value="omschrijving" /></td>
				<td><s:property value="minimumbedrag" /></td>
				<td><s:property value="aantal" /></td>
				
				
			</tr>
		</s:iterator>
	</table>
		<br/>
		
	

	<s:form action="BidAuction">
		<s:select label="id" name="id" list="alleVeilingen" listKey="id" listValue="id" multiple="false"  required="true"   value=""/>
		<s:submit value="Laat biedingen zien"/>
	</s:form>
</div>
</section>
<%@include file="/footer.jsp"%>