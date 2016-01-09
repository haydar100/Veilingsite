
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


<h4>Welkom ! hier kunt u een nieuwe veiling aanmaken</h4>

<s:actionmessage/>
<s:actionerror/>

<h5>Vul hieronder de gegevens in van de Veiling </h5>
<hr />


<s:form action="AddAuction">
	<s:textfield name="startdatum" label="startdatum" />
	<s:textfield name="sluitdatum" label="sluitdatum" />
	Categorie:  	<select name="categorie"> <option value="Elektronica">Elektronica</option>
    				<option value="Vakantie">Vakantie</option>
    				</select>
	<s:textfield name="artikelnummer" label="artikelnummer"/>
	<s:textfield name="omschrijving" label="omschrijving"/>
	<s:textfield name="minimumbedrag" label="minimumbedrag"/>
	<s:textfield name="aantal" label="aantal"/>
	<s:submit value="Voeg veiling toe !" />
</s:form>
</div>
<hr />
</section>
<%@include file="/footer.jsp"%>

