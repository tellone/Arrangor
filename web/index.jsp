<%@page language="java" contentType="text/html"%>
<html>
  <head>
    <title> Arrangor registration</title>

    </head>
    <body>
      <header id="page_header">

      </header>
      <ul>
        <div id="content">
          <h1> Vi vill ha, Telefon nummer och Email </h1>
          
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
          
        </div>
      </ul>
      <footer id="page_footer">
      <ol>
        made by: Filip Pettersson for Nortic
      </ol>
      </footer>
    </body>
  </html>
