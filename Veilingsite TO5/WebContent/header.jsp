<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="assets/ico/favicon.png">
    <title>Auction Hunters</title>
    
    <!-- Bootstrap core CSS -->
    <link href="dist/css/bootstrap.css" rel="stylesheet">
    
    <!-- Custom styles for this template -->
    <link href="jumbotron.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="assets/js/html5shiv.js"></script>
    <script src="assets/js/respond.min.js"></script>
    <![endif]-->
  </head>
<body>

			<!--==============================header=================================-->
<header>

<section id="content">

    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Auction Hunters</a>
        </div>
        <div class="navbar-collapse collapse">
        <ul class="nav navbar-nav">
        <li class="active"><a href="index.jsp">Home</a></li>
        
        <s:if test='%{#session.loggedUser != null}'>
		<s:if test='%{#session.loggedUser.getRecht().toString().equals("admin")}'>
        <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Beheer <b class="caret"></b></a>
        <ul class="dropdown-menu">
		<li><a href="<s:url action="blockUserForm.action" namespace="/admin" />">Blokkeer gebruiker</a></li>
		<li><a href="<s:url action="UnblockUserForm.action" namespace="/admin" />">Deblokkeer gebruiker</a></li>
		<li><a href="<s:url action="AllUsersForm.action" namespace="/admin" />">Wijzig gebruiker</a></li>
		<li><a href="<s:url action="Statistics.action"  namespace="/admin" />">Statistieken</a></li>
		<li><a href="<s:url action="CreateSellerAccountForm.action" namespace="/admin" />">Maak verkoper aan</a></li>
		</ul></li>
		</s:if>
          
        <s:else>
        <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Over <b class="caret"></b></a>
        <ul class="dropdown-menu">
		<li><a href="algemenevoorwaarden">Algemene Voorwaarden</a></li>
		<li><a href="contact">Contact</a></li>
		<li><a href="over">Over</a></li>
	 	</ul>
	    </li>
	 	</s:else>
		</s:if>
		
        <s:else>
        <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Over <b class="caret"></b></a>
        <ul class="dropdown-menu">
		<li><a href="algemenevoorwaarden">Algemene Voorwaarden</a></li>
		<li><a href="contact">Contact</a></li>
		<li><a href="over">Over</a></li>
		</ul>
		</li>
		</s:else>
        
        <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Veilingen <b class="caret"></b></a>
        <ul class="dropdown-menu">
        <li><a href="<s:url action="bidsAuctionForm.action" namespace="" ></s:url>">Biedingen per veiling</a></li>
		<li><a href="<s:url action="auctionElectronica.action" namespace="" ><s:param name="categorie">Elektronica</s:param></s:url>">Elektronica</a></li>
		<li><a href="<s:url action="auctionVakantie.action" namespace=""  ><s:param name="categorie">Vakantie</s:param></s:url>">Vakantie's</a></li>
		<s:if test='%{#session.loggedUser != null}'>
		<s:if test='%{#session.loggedUser.getRecht().toString().equals("verkoper")}'>		
		<li><a href="<s:url action="AddAuctionForm.action" namespace="/verkoper" ></s:url>">Veiling aanmaken</a></li>
		</s:if>
		</s:if>
		<li><a href="<s:url action="AllAuction.action" namespace=""></s:url>">Alle veilingen overzicht</a></li>
		</ul>
		</li>
        
        
        
		
		<s:if  test='%{#session.loggedUser != null}'>
		<li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Mijn account informatie<b class="caret"></b></a>
        <ul class="dropdown-menu">
        <li><a href="<s:url action="showaccount.action" ></s:url>">Mijn Account</a></li>
        
        <s:if  test='%{#session.loggedUser != null}'>
        	<s:if test='%{#session.loggedUser.getRecht().toString().equals("koper")}'>		
        
		<li><a href="<s:url action="AddCreditsForm" namespace="/koper"></s:url>">Credits toevoegen</a></li>
			</s:if>
		</s:if>
		</ul>
		</li>
	
		
		<li><a href="<s:url action="logout" namespace=""></s:url>">Uitloggen</a></li>
		
		</s:if>
		
		
	    <s:else>
		<li class="active"><a href="register">Registreer</a></li>
		<br>
		<s:form class="navbar-form navbar-right" action="ActionLogin">
        <div class="form-group-email">
        <input type="text" name="email" placeholder="Email" class="form-control">
        </div>
        <div class="form-group-pass">
        <input type="password" name="password" placeholder="Password" class="form-control">
        </div>
        <button type="submit" value="" class="btn btn-success">Sign in</button>
        </s:form>
		</s:else>
		<%@page language="java" session="true" %>
   		<%@ page import="veilingDomain.Koper" %>
   		<%@ page import="javax.servlet.*" %>
		<s:if  test='%{#session.loggedUser != null}'>
		<s:if test='%{#session.loggedUser.getRecht().toString().equals("koper")}'>
		<li class="active"><a href="#">Credits: <s:property value="#session.loggedUser.getCredits()" /></a></li>
		</s:if>
		</s:if>

		</ul>



        
        </div><!--/.navbar-collapse -->
      	</div>
    	</div>
</section>
</header>