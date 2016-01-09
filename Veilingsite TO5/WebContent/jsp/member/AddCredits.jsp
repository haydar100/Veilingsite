
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


<h4>Welkom! Hier kunt u credits toevoegen aan uw account</h4>

<s:actionmessage/>
<s:actionerror/>

<h5>Kies hieronder het gewenste bedrag om op te waarderen</h5>
<hr />


<s:form action="AddCredits">
	<s:textfield name="credits" label="Opwaarderen" />
	<s:submit value="Koop credits" />
</s:form>
<p>Door voor "Koop credits" te kiezen gaat u akkoord met de algemene voorwaarden en verkoopvoorwaarden, deze houden onder andere in dat de klant 1 pizza over moet maken naar Robin Kuijt.</p>

<hr />
</div>
</section>
<%@include file="/footer.jsp"%>
