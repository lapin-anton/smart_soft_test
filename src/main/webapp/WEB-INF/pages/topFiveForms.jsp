<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Топ 5 форм по посещаемости</title>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body>
<div class="container">
    <div class="nav-list">
        <ul>
            <li><a href="uploadFile">Загрузить файл</a></li>
            <li><a href="lastHour">Список используемых форм за последний час</a></li>
            <li><a href="unfinished">Список незаконченных действий</a></li>
            <li><a href="topFiveForms">Топ 5 - самых используемых форм</a></li>
        </ul>
    </div>
    <div class="main">
        <h3>Топ 5 форм по посещаемости</h3>
        <c:if test="${!empty forms}">
            <table>
                <tr>
                    <th>id</th>
                    <th>Идентификатор формы</th>
                    <th>URL формы</th>
                    <th>Организация предоставляющая услугу</th>
                    <th>Посещаемость</th>
                </tr>
                <c:forEach var="form" items="${forms}">
                    <tr>
                        <td>${form.id}</td>
                        <td>${form.formId}</td>
                        <td>${form.url}</td>
                        <td>${form.orgId}</td>
                        <td>${form.count}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
</div>
</body>
</html>
