<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html class="no-js" lang="">

<head>
  <meta charset="utf-8">
  <title>ЛР№2</title>
  <meta name="description" content="Калькулятор функції">
  <link rel="stylesheet" href="css/main.css" type="text/css">
  <meta name="theme-color" content="#ffffff">
</head>
<body>

  <main class="container">

    <h1 class="display center">Розрахунок функції</h1>

    <form method="post" action="">
      <div class="input_row">
        <label for="src_a">a:</label>
        <input type="text" id="src_a" name="src_a" value="${requestScope.get('src_a')}">
      </div>
      <div class="input_row">
        <label for="src_x_min">Min x:</label>
        <input type="text" id="src_x_min" name="src_x_min" value="${requestScope.get('src_x_min')}">
      </div>
      <div class="input_row">
        <label for="src_x_max">Max x:</label>
        <input type="text" id="src_x_max" name="src_x_max" value="${requestScope.get('src_x_max')}">
      </div>
      <div class="input_row">
        <label for="src_step">Step:</label>
        <input type="text" id="src_step" name="src_step" value="${requestScope.get('src_step')}">
      </div>
      <div class="input_row">
        <label for="src_breakline">Breakline:</label>
        <input type="text" id="src_breakline" name="src_breakline" value="${requestScope.get('src_breakline')}">
      </div>
      <div class="input_row">
        <label></label>
        <button type="submit">Рахувати</button>
      </div>

      <% if (request.getAttribute("result") != null) { %>
      <jsp:useBean id="result" type="com.lab.web.lab_02.lib.CalculationResult" scope="request"/>
      <div class="input_row">
        <label for="result"></label>
        <div id="result" class="success">
          <h2>Результати:</h2>
          <strong>Steps:</strong> ${result._steps}<br/>
          <strong>Item 0:</strong> x=${result.get_x(0)}; y=${result.get_y(0)}<br/>
          <strong>Item 180:</strong> x=${result.get_x(180)}; y=${result.get_y(180)}<br/>
          <strong>Item 240:</strong> x=${result.get_x(240)}; y=${result.get_y(240)}<br/>
          <strong>Max:</strong> i=${result._max}; x=${result.get_x(result._max)}; y=${result.get_y(result._max)}<br/>
          <strong>Min:</strong> i=${result._min}; x=${result.get_x(result._min)}; y=${result.get_y(result._min)}<br/>
          <strong>Sum:</strong> ${result._sum}<br/>
          <strong>Avg:</strong> ${result._avg}<br/>
        </div>
      </div>
      <% } else if (request.getAttribute("error") != null) { %>
      <div class="input_row">
        <label for="error"></label>
        <div id="error" class="error">
          <h3><%=request.getAttribute("error")%></h3>
          <p><%=request.getAttribute("error_details")%></p>
        </div>
      </div>
      <% } %>
    </form>

  </main>
</body>
</html>
