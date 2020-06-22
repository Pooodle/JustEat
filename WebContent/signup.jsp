<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>signup</title>
    <link rel="stylesheet" href="login.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js" charset="utf-8"></script>
  </head>
  <body>

      <form action="search" class="signup-form">
        <h1>Sign up</h1>

        <div class="txtb">
          <input type="id">
          <span data-placeholder="ID"></span>
        </div>

        <div class="txtb">
          <input type="password">
          <span data-placeholder="Password"></span>
        </div>

        <div class="txtb">
          <input type="name">
          <span data-placeholder="name"></span>
        </div>

        <div class="txtb">
          <input type="phonenumber">
          <span data-placeholder="Phone Number"></span>
        </div>

        <div class="txtb">
          <input type="email">
          <span data-placeholder="Email"></span>
        </div>
        <input type="submit" class="logbtn" value="Sign Up">


      </form>

      <script type="text/javascript">
      $(".txtb input").on("focus",function(){
        $(this).addClass("focus");
      });

      $(".txtb input").on("blur",function(){
        if($(this).val() == "")
        $(this).removeClass("focus");
      });

      </script>


  </body>
</html>