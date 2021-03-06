<%@page import="veilingDomain.Gebruiker"%>
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
<h4>Accountgegevens wijzigen.</h4>
<h5>Formulier om de accountgegevens te wijzigen</h5>

<hr />

<s:form action="EditUserKoper">
	<s:textfield name="email" label="Email" />
	<s:textfield name="voornaam" label="Voornaam" />
	<s:textfield name="achternaam" label="Achternaam"/>
	<s:textfield name="woonplaats" label="Woonplaats" />
	<s:textfield name="straat" label="Straat"/>
	<s:textfield name="postcode" label="Postcode" />
	<s:textfield name="huisnummer" label="Huisnummer"  />
	<s:textfield name="telefoonnummer" label="telefoonnummer" />
	<s:textfield name="geboortedatum" label="Geboortedatum"  />
	<br> 
	
	<s:submit value="Wijzig accountgegevens" />
</s:form>

<hr />
</div>
</section>
<%@include file="/footer.jsp"%>