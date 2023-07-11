<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EMI Calculator</title>
<style>
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
        font-family: Arial, sans-serif;
    }

    .container {
        width: 400px;
        padding: 40px;
        background-color: #f2f2f2;
        border-radius: 5px;
    }

    h1 {
        text-align: center;
        margin-bottom: 20px;
    }

    table {
        width: 100%;
    }

    label {
        display: block;
        margin-bottom: 10px;
    }

    input[type="number"],
    input[type="text"] {
        width: 100%;
        padding: 8px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
        font-size: 14px;
        margin-bottom: 12px;
    }

    input[type="submit"],
    input[type="button"] {
        background-color: #4CAF50;
        color: white;
        padding: 8px 16px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 14px;
        margin: 0 5px;
    }

    input[type="submit"]:hover,
    input[type="button"]:hover {
        background-color: #45a049;
    }

    .result-container {
        margin-top: 20px;
        text-align: center;
    }

    .result-container h2 {
        margin-bottom: 10px;
    }

    .result-container p {
        margin: 5px 0;
    }
    .button-container {
        display: flex;
        justify-content: center;
        margin-top: 10px;
    }
    
</style>
<script>
    function clearResult() {
        document.getElementById("result-container").innerHTML = "";
    }
</script>
</head>
<body>
    <div class="container">
        <h1>EMI Loan Calculator</h1>
        <form method="post">
            <table>
                <tr>
                    <td><label for="principal">Principal Amount:</label></td>
                    <td><input type="number" id="principal" name="principal" required></td>
                </tr>
                <tr>
                    <td><label for="interest">Rate of Interest:</label></td>
                    <td><input type="number" id="interest" name="interest" required></td>
                </tr>
                <tr>
                    <td><label for="time">Time (in months):</label></td>
                    <td><input type="number" id="time" name="time"></td>
                </tr>
            </table>
            <div class="button-container">
                <input type="submit" name="submit" value="Calculate EMI">
                <input type="button" value="Clear" onclick="clearResult()">
            </div>
        </form>

        <% // Java code for calculating EMI
        if (request.getParameter("submit") != null) {
            double principal = Double.parseDouble(request.getParameter("principal"));
            double interestRate = Double.parseDouble(request.getParameter("interest"));
            int time = Integer.parseInt(request.getParameter("time"));

            double monthlyInterest = interestRate / 12 / 100;
            double numerator = principal * monthlyInterest * Math.pow(1 + monthlyInterest, time);
            double denominator = Math.pow(1 + monthlyInterest, time) - 1;

            double emi = numerator / denominator;

            // Display the calculated EMI
        %>
        <div class="result-container" id="result-container">
            <h2>Result:</h2>
            <p>Principal Amount: <%= principal %></p>
            <p>Rate of Interest: <%= interestRate %></p>
            <p>Time (in months): <%= time %></p>
            <h3>EMI: <%= emi %></h3>
        </div>
        <%
        } else { // Form not submitted, hide the result container
        %>
        <div class="result-container" id="result-container" style="display: none;"></div>
        <%
        }
        %>
    </div>
</body>
</html>
