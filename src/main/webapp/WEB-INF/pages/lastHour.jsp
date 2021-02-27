<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Активность пользователей за последний час</title>
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
        <h3>Активность пользователей за последний час</h3>
        <c:if test="${!empty map}">
            <table>
                <tr>
                    <th>id формы</th>
                    <th>url формы</th>
                    <th>Организация предоставляющая услугу</th>
                    <th>Группа события</th>
                    <th>Тип события</th>
                    <th>Подтип события</th>
                    <th>Время события</th>
                </tr>
                <c:forEach var="user" items="${map}">
                    <tr>
                        <td colspan="7" style="text-align: center; background: darkseagreen">
                            id пользователя: ${user.key}
                        </td>
                    </tr>
                        <c:forEach var="userAction" items="${user.value}">
                            <tr>
                                <td>${userAction.formId}</td>
                                <td>${userAction.url}</td>
                                <td>${userAction.orgId}</td>
                                <td>${userAction.grp}</td>
                                <td>${userAction.type}</td>
                                <td>${userAction.subtype}</td>
                                <td>${userAction.ts}</td>
                            </tr>
                        </c:forEach>
                </c:forEach>
            </table>
        </c:if>
    </div>
</div>
</body>
</html>
