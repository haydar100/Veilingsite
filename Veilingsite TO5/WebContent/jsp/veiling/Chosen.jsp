<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@include file="/header.jsp"%>
<section id="content">

	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="jumbotron">
		<div class="container">
			<h1>Welkom op Auction Hunters!</h1>
			<p>Dit is een site waarop u als koper gemakkelijk de nieuwste
				koopjes voor de laagste prijs vind, tevens kunt u hier als verkoper
				ook snel een groot publiek bereiken voor het verkopen van uw
				producten.</p>
			<p>
				<a href="over" class="btn btn-primary btn-lg">Meer informatie
					&raquo;</a>
			</p>
		</div>
	</div>
	<div class="container">



		<table>
			<tr class="thcolor">
				<th>Startdatum</th>
				<th>Sluitdatum</th>
				<th>Artikelnummer</th>
				<th>Categorie</th>
				<th>Omschrijving</th>
				<th>Minimumbedrag</th>
				<th>Huidig bod</th>
				<th>Huidige bieder</th>
				<th>Aantal</th>
			</tr>

			<tr class="tdcolor">
				<td><s:property value="auction.startdatum" /></td>
				<td><s:property value="auction.sluitdatum" /></td>
				<td><s:property value="auction.artikelnummer" /></td>
				<td><s:property value="auction.categorie" /></td>
				<td><s:property value="auction.omschrijving" /></td>
				<td><s:property value="auction.minimumbedrag" /></td>
				<s:set name="hb" value="huidigeBieder"/>
				<s:if test="%{#hb=='NOTHING'}">
					<td>-</td>
					<td>-</td>
				</s:if>
				<s:else>
					<td><s:property value="huidigBod" /></td>
					<td><s:property value="huidigeBieder" /></td>
				</s:else>
				<td><s:property value="auction.aantal" /></td>
			</tr>

		</table>

		<s:if test='%{#session.loggedUser != null}'>
			<s:if test='%{#session.loggedUser.getRecht().toString().equals("koper")}'>

			<s:form action="BiedMee" namespace="/koper">
				<s:hidden name="id" value="%{auction.id}" />
				<s:textfield name="bid" label="Credits" />
				<s:submit value="bied mee" />
			</s:form>
			
			</s:if>
		</s:if>



	</div>
</section>
<%@include file="/footer.jsp"%>