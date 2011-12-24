<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <script src="<%=request.getContextPath()%>/jquery.js"></script>
    <script>

        function testLoad1() {
            $("#container1").load("<%=request.getContextPath()%>/servlet?action=testLoad1");
        }

        function testLoad2() {
            $.post("<%=request.getContextPath()%>/servlet", $("#simpleForm").serialize(), function(data) {
                $('#container2').html(data);
            })
        }

        function testLoad3() {
            $.getJSON("<%=request.getContextPath()%>/servlet?action=testLoad3", function(json) {
                for (i in json){
                    $('#container3').append("Id: ");
                    $('#container3').append(json[i].id);
                    $('#container3').append(", Address: ");
                    $('#container3').append(json[i].address);
                    $('#container3').append("<br/>");
                }
            })
        }

    </script>
</head>
<body>

<a href="#" onclick="testLoad1(); return false;">Test Load 1</a>

<div id="container1"></div>

<br/><br/>

<form id="simpleForm" method="post">
    <input type="text" name="input1"/><br/>
    <input type="text" name="input2"/><br/>
    <input type="submit" value="Test Load2" onclick="testLoad2(); return false;"/>
    <input type="hidden" name="action" value="testLoad2"/>
</form>
<div id="container2"></div>

<br/><br/>

<a href="#" onclick="testLoad3(); return false;">Test Load 3</a>

<div id="container3"></div>


</body>
</html>