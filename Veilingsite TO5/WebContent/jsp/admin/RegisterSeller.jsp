<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@include file="/header.jsp"%>
<section id="content">

<!-- Main jumbotron for a primary marketing message or call to action -->
 <div class="jumbotron">
<div class="container">
<h1>Welkom op Auction Hunters!</h1>
<p>Dit is een site waarop u als koper gemakkelijk de nieuwste koopjes voor de laagste prijs vind, tevens kunt u hier als verkoper ook snel een groot publiek bereiken voor het verkopen van uw producten.</p>
<p><a href="over" class="btn btn-primary btn-lg">Meer informatie &raquo;</a></p>
</div>
</div>
<div class="container">

<h4>Een account aanmaken voor een verkoper</h4>
<s:actionmessage/>
<s:actionerror/>

<hr />

<s:form  action="CreateSellerAccount">
	<s:textfield name="email" label="Email" />	
	<s:password name="password" label="Wachtwoord" />
	<s:textfield name="bedrijfsnaam" label="Bedrijfsnaam" />
	<s:textfield name="kvkNummer" label="KvkNummer" />
	<s:textfield name="woonplaats" label="Woonplaats" />
	<s:textfield name="straat" label="Straatnaam" />
	<s:textfield name="postcode" label="Postcode" />
	<s:textfield name="huisnummer" label="Huisnummer" />
	<s:textfield name="telefoonnummer" label="Telefoonnummer" />
		<s:textfield name="rekeningnummer" label="Rekeningnummer" />


	
	<s:submit value="maak account aan!" />
</s:form>

<hr />


</div>


<hr />


</section>

<%@include file="/footer.jsp"%>