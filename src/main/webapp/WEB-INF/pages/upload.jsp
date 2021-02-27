<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Загрузка файла</title>
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
    <div class="upload-form">
        <h3>Импорт данных из загружаемого файла</h3>
        <form:form enctype="multipart/form-data" method="post" class="form">
            <input type="file" name="file"/>
            <input type="submit" value="Импорт" />
        </form:form>
    </div>
</div>
</body>
</html>
