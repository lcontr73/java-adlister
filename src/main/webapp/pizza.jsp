<%--
  Created by IntelliJ IDEA.
  User: begin
  Date: 7/11/22
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order Form</title>
</head>
<body>
<form action="pizza-order" method="post"><H2>Build Your Pizza</H2>
    <label for="crust">Choose your crust</label>
    <select name="crust" id="crust">
        <option value="thin">Thin and crispy</option>
        <option value="deep">Deep dish</option>
        <option value="stuffed">Stuffed crust</option>
    </select>

    <br><br>
    <hr>
    <br>

    <label for="sauce">Choose your sauce</label>
    <select name="sauce" id="sauce">

        <option value="original">Original</option>
        <option value="bbq">BBQ</option>
        <option value="Buffalo">Buffalo</option>
    </select>

    <br><br>
    <hr>
    <br>
    <label for="size">Choose your size</label>
    <select name="size" id="size">
        <%--        <option value="">Please pick your size</option>--%>
        <option value="small">Small</option>
        <option value="medium">Medium</option>
        <option value="large">Large</option>
    </select>

    <br><br>
    <hr>

    <h3>Choose your toppings</h3>
    <input type="checkbox" id="pepperoni" name="pepperoni" value="Pepperoni">
    <label for="pepperoni">Pepperoni</label>
    <input type="checkbox" id="cheese" name="cheese" value="Cheese">
    <label for="cheese">Cheese</label>
    <input type="checkbox" id="veggie" name="veggie" value="Veggie">
    <label for="veggie">Veggie</label>

    <br><br>
    <hr>
    <h3>Delivery Address</h3>
    <label for="address"> Please enter your delivery address: </label><br>
    <input type="text" id="address" name="address" minlength="3" maxlength="100">

    <br><br>
    <hr>
    <button>Submit</button>
</form>
</body>
</html>
