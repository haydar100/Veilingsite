
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
<h4>Welkom hier kunt u alle gebruikers vinden </h4>

<s:actionmessage/>
<s:actionerror/>


<hr />


<s:form action="EditUserVerkoperForm">
<s:select name="email" list="AlleVerkopers" value="email" listKey="email" listValue="email" label="Kies verkoper"/>  
  <s:submit value="Selecteer verkoper"/>
</s:form>


<s:form action="EditUserKoperForm">
<s:select name="email" list="alleKopers" value="email" listKey="email" listValue="email" label="Kies koper"/>  
  <s:submit value="Selecteer koper "/>
</s:form>

<hr />
</section>
<%@include file="/footer.jsp"%>

