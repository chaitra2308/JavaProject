<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Feedback</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container-fluid text-center">
    <div><h2>Manage Feedback</h2></div>
    <div class="m-2">
        <a class="h3" href="/feedback/new">Add New Feedback</a>
    </div>

    <%-- Check if there's any message to display --%>
    <c:if test="${not empty message}">
        <div class="alert alert-success text-center">${message}</div>
    </c:if>

    <div>
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <th>ID</th>
                <th>User ID</th>
                <th>Date</th>
                <th>Rating</th>
                <th>Comments</th>
                <th>Experience</th>
                <th>Destination</th>
                <th>Improvement Suggestions</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listFeedback}" var="feedback">
                <tr>
                    <td>${feedback.id}</td>
                    <td>${feedback.userId}</td>
                    <td><fmt:formatDate value="${feedback.date}" pattern="yyyy-MM-dd"/></td>
                    <td>${feedback.rating}</td>
                    <td>${feedback.comments}</td>
                    <td>${feedback.experience}</td>
                    <td>${feedback.destination}</td>
                    <td>${feedback.improvementSuggestions}</td>

                    <td>
                        <a class="h4 mr-3" href="/feedback/edit/${feedback.id}">Edit</a>
                        <a class="h4" href="/feedback/delete/${feedback.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
