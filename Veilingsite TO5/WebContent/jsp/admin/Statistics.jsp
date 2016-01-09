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
	
	<span class="pageTitle">Statistieken</span>
		<br/><br/>
	<s:if test='hoogsteBiedingDag == null'>
		<span class="labelStatistics">Hoogste bieding van vandaag:</span><span>Geen biedingen vandaag</span>
	</s:if>
	<s:else>
		<span class="labelStatistics">Hoogste bieding van vandaag:</span><span><s:property value="hoogsteBiedingDag.bedrag"/> door <s:property value="hoogsteBiedingDag.gebruikermail"/> in veiling <s:property value="hoogsteBiedingDag.veiling_id"/> </span> 	<br/>
	</s:else>
		<br/><br/>
	
	<s:if test='hoogsteBiedingMaand == null'>
		<span class="labelStatistics">Hoogste bieding van de maand:</span><span>Geen biedingen deze maand</span>
	</s:if>
	<s:else>
		<span class="labelStatistics">Hoogste bieding van de maand:</span><span><s:property value="hoogsteBiedingMaand.bedrag"/> door <s:property value="hoogsteBiedingMaand.gebruikermail"/> in veiling <s:property value="hoogsteBiedingMaand.veiling_id"/>   </span>
	</s:else>
		<br/><br/>
		
	<s:if test='hoogsteBiedingJaar == null'>
		<span class="labelStatistics">Hoogste bieding van het jaar:</span><span>Geen biedingen dit jaar</span>
	</s:if>
	<s:else>
		<span class="labelStatistics">Hoogste bieding van het jaar: </span><span><s:property value="hoogsteBiedingJaar.bedrag"/> door <s:property value="hoogsteBiedingJaar.gebruikermail"/> in veiling <s:property value="hoogsteBiedingJaar.veiling_id"/>   </span>
	</s:else>
		<br/><br/>
	<span class="labelStatistics">Veiling met de meeste biedingen is: </span><span><s:property value="veilingMeesteBiedingen.veiling_id"/> met aantal <s:property value="veilingMeesteBiedingen.aantal"/></span>
	
</div>
</section>
<%@include file="/footer.jsp"%>