<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <a href="/ads/create">Create Ad</a>
    <h1>Here Are all the ads!</h1>

    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <c:if test="${sessionScope.user != null}">
                <c:if test="${ad.userId == sessionScope.userId}">
                    <form method="POST" action="/delete">
                        <button type="submit">Delete your ad</button>
                        <input type="hidden" value="${ad.id}" name="deleteThisAd" id="deleteThisAd">
                    </form>
                    <form method="GET" action="/editForm">
                        <button type="submit">Edit your ad</button>
                        <input type="hidden" value="${ad.id}" name="editThisAd" id="editThisAd">
                    </form>
                </c:if>
            </c:if>
            <h2><c:out value="${ad.title}"/></h2>
            <p><c:out value="${ad.description}"/></p>
        </div>
    </c:forEach>
</div>

</body>
</html>
