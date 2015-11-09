<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="my.app.switcher.Test" %>
<html>
<head>
    <title></title>
    <link href="css/bootstrap.css" rel="stylesheet">
</head>
<body>
<form action="start" method="get">
    <%
        String expression = request.getParameter("expression");
        String result = request.getParameter("result");
        if (expression == null) {
            expression = "";
        }
        if (result == null) {
            result = "";
        }
    %>

    <center><h1>Calc</h1></center>
    <table class="table">
        <tr>
            <td><input onmousemove="check('dec1', 'bin1', 'hex1')" onclick="changeD('ex')" type="radio" name="group1"
                       id="dec1" checked>Dec<br></td>
            <td><input onmousemove="check('dec2', 'bin2', 'hex2')" onclick="changeD('res')" type="radio" name="group2"
                       id="dec2" checked>Dec<br></td>
        </tr>
        <tr>
            <td><input onmousemove="check('dec1', 'bin1', 'hex1')" onclick="changeB('ex')" type="radio" name="group1"
                       id="bin1">Bin<br></td>
            <td><input onmousemove="check('dec2', 'bin2', 'hex2')" onclick="changeB('res')" type="radio" name="group2"
                       id="bin2">Bin<br></td>
        </tr>
        <tr>
            <td><input onmousemove="check('dec1', 'bin1', 'hex1')" onclick="changeH('ex')" type="radio" name="group1"
                       id="hex1">Hex<br></td>
            <td><input onmousemove="check('dec2', 'bin2', 'hex2')" onclick="changeH('res')" type="radio" name="group2"
                       id="hex2">Hex<br></td>
        <tr>
            <td>Expression <input type="text" class="form-control" name="expression" value="<%=expression%>" id="ex"/>
            </td>
            <td>Result <input type="text" class="form-control" name="result" value="<%=result%>" id="res"/></td>
        </tr>
        <tr>
            <td>
                <button class="btn btn-success" name="enter" value="eval">
                    Eval
                </button>
                <button class="btn btn-success" name="enter" value="load">
                    Load File
                </button>
                <button class="btn btn-success" name="enter" value="save">
                    Save File
                </button>
                <button class="btn btn-success" name="enter" value="insert">
                    Database
                </button>
            </td>
        </tr>
    </table>

    <script type="text/javascript" src="resources/app.js"></script>

</form>

</body>
</html>
