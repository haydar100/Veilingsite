
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
<h4>Welkom ! hier kunt u alle gebruikers vinden die niet geblokkeerd zijn</h4>

<s:actionmessage/>
<s:actionerror/>


<hr />


<s:form action="blockUser">
<s:select name="email" list="allNonBlockedUsers" value="email" label="Kies email"/>  
  <s:submit value="blokkeer gebruiker !"/>
</s:form>

<hr />
</div>
</section>
<%@include file="/footer.jsp"%>

