<%@page language="java" contentType="text/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList" %>
<html>
  <head>
    <title> Arrangor registration</title>
    <link rel="stylesheet" href="app.css" type="text/css"/>
    <script type="text/javascript" src="jquery-1.9.1.min.js"></script>
    <script type="text/java" src="jquery.validate.min.js"></script>
    <script type="text/javascript">
      $(document).ready(function{
          $("#add_arr").validate({
            rules: {
              name: "required",
              nummer: {
                number: true,
                required: true
                },

              email1: {
                required: true,
                email: true
                },

              email2: {
                equalTo: email1
                }
              },    
              messages: {
                name: "Name is required.",
                email: "Not a valid email",
                phone: "number is required."
              });
          });

    </script>
  </head>
  <body>
    <header id="page_header" type="banner">
        <h1> Vi vill ha, Telefon nummer och Email </h1>
    </header>
      <div id="content">
        <ul>

        <p>
          <div id="include_add">

            <jsp:include page="WEB-INF/create.jsp" />


          </div>
        </p>
        <p>
          <div id="include_show">

            <jsp:include page="WEB-INF/show.jsp" />


          </div>
        </p>
      </ul>
      </div>
    <footer id="page_footer">
    <ol>
      made by: Filip Pettersson for Nortic
    </ol>
    </footer>
  </body>
</html>
