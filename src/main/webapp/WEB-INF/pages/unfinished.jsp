<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Незавершенные действия пользователей</title>
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
        <h3>Пользователи, которые начали активность на форме и не дошли до конца</h3>
        <c:if test="${!empty map}">
            <table>
                <tr>
                    <th>Уникальный идентификатор пользователей</th>
                    <th>id формы (url формы)</th>
                    <th>Группа события</th>
                    <th>Тип события</th>
                    <th>Подтип события</th>
                </tr>
                <c:forEach var="user" items="${map}">
                    <tr>
                        <td>
                                ${user.key}
                        </td>
                        <td>
                                ${user.value.formId} (${user.value.url})
                        </td>
                        <td>
                                ${user.value.grp}
                        </td>
                        <td>
                                ${user.value.type}
                        </td>
                        <td>
                                ${user.value.subtype}
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
</div>
</body>
</html>
