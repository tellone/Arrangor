
<%@page language="java" contentType="text/html"%>
<html>
  <head>
    <title> Lägg till arragörer </title>
    <script type="text/javascript" src="jquery-1.91.min.js"></script>
    <script type="text/javascript" src="jquery.validate.min.js"></script>
    <script>
      $(document).ready( function() ( { 
        $("#arr_form").validate()
        });

      </script>
    </head>
    <body>
      <div id="content">
      <form id="arrForm" action="ArrangoerServlet" method="post" va>
        <fieldset>
          <legend>Add arrangor</legend>
          <label for="name">Namn</label>
          <input id="name" name="name" type="text"/><br/>

          <label for="nummer">Telefon nummer</label>
          <input id="nummer" name="nummer" type="text"/><br/>

          <label for="Email1">Email</label>
          <input id="email1" name="email1" type="text"/><br/>

          <label for="Email2">Email Igen</label>
          <input id="email2" name="email2" type="text"/><br/>
          <input type="submit" value="Submit"/>
        </fieldset>
      </form>
    </div>

  </html>
